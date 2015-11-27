package org.eclipse.bpel.compare.ui.gef.bpel;
/*******************************************************************************
 * Copyright (c) 2006, 2012, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.compare.EMFComparePlugin;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.engine.IMatchEngine;
import org.eclipse.emf.compare.match.internal.statistic.NameSimilarity;
import org.eclipse.emf.compare.match.internal.statistic.StructureSimilarity;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.Match3Elements;
import org.eclipse.emf.compare.match.metamodel.MatchElement;
import org.eclipse.emf.compare.match.metamodel.MatchFactory;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.compare.match.metamodel.UnmatchElement;
import org.eclipse.emf.compare.match.statistic.MetamodelFilter;
import org.eclipse.emf.compare.util.EFactory;
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.compare.util.EMFComparePreferenceConstants;
import org.eclipse.emf.compare.util.EclipseModelUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;

/**
 * These services are useful when one wants to compare models more precisely using the method modelDiff.
 * 
 * @author <a href="mailto:cedric.brun@obeo.fr">Cedric Brun</a>
 */
public class BPELMatchEngine implements IMatchEngine {
//public class BPELMatchEngine extends GenericMatchEngine {

	/** Used while computing similarity, this defines the general threshold. */
	private static final double GENERAL_THRESHOLD = 0.96d;

	/** Containmnent reference for the matched elements root. */
	private static final String MATCH_ELEMENT_NAME = "matchedElements"; //$NON-NLS-1$

	/**
	 * Minimal number of attributes an element must have for content comparison.
	 */
	private static final int MIN_ATTRIBUTES_COUNT = 5;

	/** This constant is used as key for the buffering of name similarity. */
	private static final char NAME_SIMILARITY = 'n';

	/** This constant is used as key for the buffering of relations similarity. */
	private static final char RELATION_SIMILARITY = 'r';

	/** Containmnent reference for {@link MatchElement}s' submatches. */
	private static final String SUBMATCH_ELEMENT_NAME = "subMatchElements"; //$NON-NLS-1$

	/** This constant is used as key for the buffering of type similarity. */
	private static final char TYPE_SIMILARITY = 't';

	/** Containmnent reference for the {@link MatchModel}'s unmatched elements. */
	private static final String UNMATCH_ELEMENT_NAME = "unmatchedElements"; //$NON-NLS-1$

	/** This constant is used as key for the buffering of value similarity. */
	private static final char VALUE_SIMILARITY = 'v';

	/**
	 * {@link MetamodelFilter} used for filtering unused features of the objects we're computing the
	 * similarity for.
	 */
	protected final MetamodelFilter filter = new MetamodelFilter();

	/** Contains the options given to the match procedure. */
	protected final Map<String, Object> options = new EMFCompareMap<String, Object>();

	/**
	 * This map allows us memorize the {@link EObject} we've been able to match thanks to their functional ID.
	 */
	private final Map<String, EObject> matchedByID = new EMFCompareMap<String, EObject>();

	/**
	 * This map allows us memorize the {@link EObject} we've been able to match thanks to their XMI ID.
	 */
	private final Map<String, EObject> matchedByXMIID = new EMFCompareMap<String, EObject>();

	/**
	 * This map is used to cache the comparison results Pair(Element1, Element2) => [nameSimilarity,
	 * valueSimilarity, relationSimilarity, TypeSimilarity].
	 */
	private final Map<String, Double> metricsCache = new EMFCompareMap<String, Double>();

	/**
	 * This list allows us to memorize the unMatched elements for a three-way comparison.<br/>
	 * <p>
	 * More specifically, we will populate this list with the {@link UnmatchElement}s created by the
	 * comparison between the left and the ancestor model, followed by the {@link UnmatchElement} created by
	 * the comparison between the right and the ancestor model.<br/> Those {@link UnmatchElement} will then
	 * be filtered to retain only those that actually cannot be matched.
	 * </p>
	 */
	private final Set<EObject> remainingUnMatchedElements = new HashSet<EObject>();

	/**
	 * This list will be intensively used while matching elements to keep track of the unmatched ones from the
	 * left model.
	 */
	private final List<EObject> stillToFindFromModel1 = new ArrayList<EObject>();

	/**
	 * This list will be intensively used while matching elements to keep track of the unmatched ones from the
	 * right model.
	 */
	private final List<EObject> stillToFindFromModel2 = new ArrayList<EObject>();

	/**
	 * The options map must be initialized to avoid potential NPEs. This initializer will take care of this
	 * issue.
	 */
	{
		options.putAll(loadPreferenceOptionMap());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.match.api.IMatchEngine#contentMatch(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, java.util.Map)
	 */
	public MatchModel contentMatch(EObject leftObject, EObject rightObject, EObject ancestor,
			Map<String, Object> optionMap) {
		final MatchModel root = MatchFactory.eINSTANCE.createMatchModel();
		setModelRoots(root, leftObject.eResource(), rightObject.eResource(), ancestor.eResource());
		final Monitor monitor = createProgressMonitor();
		final MatchModel leftObjectAncestorMatch = contentMatch(leftObject, ancestor, optionMap);
		final MatchModel rightObjectAncestorMatch = contentMatch(rightObject, ancestor, optionMap);

		final List<MatchElement> leftObjectMatchedElements = new ArrayList<MatchElement>(
				leftObjectAncestorMatch.getMatchedElements());
		final List<MatchElement> rightObjectMatchedElements = new ArrayList<MatchElement>(
				rightObjectAncestorMatch.getMatchedElements());

		// populates the unmatched elements list for later use
		for (Object unMatch : leftObjectAncestorMatch.getUnmatchedElements())
			remainingUnMatchedElements.add(((UnmatchElement)unMatch).getElement());
		for (Object unMatch : rightObjectAncestorMatch.getUnmatchedElements())
			remainingUnMatchedElements.add(((UnmatchElement)unMatch).getElement());

		try {
			Match3Elements subMatchRoot = null;
			if (leftObjectMatchedElements.size() > 0 && rightObjectMatchedElements.size() > 0) {
				final Match2Elements leftObjectMatchRoot = (Match2Elements)leftObjectMatchedElements.get(0);
				final Match2Elements rightObjectMatchRoot = (Match2Elements)rightObjectMatchedElements.get(0);
				subMatchRoot = MatchFactory.eINSTANCE.createMatch3Elements();

				subMatchRoot.setSimilarity(absoluteMetric(leftObjectMatchRoot.getLeftElement(),
						rightObjectMatchRoot.getLeftElement(), rightObjectMatchRoot.getRightElement()));
				subMatchRoot.setLeftElement(leftObjectMatchRoot.getLeftElement());
				subMatchRoot.setRightElement(rightObjectMatchRoot.getLeftElement());
				subMatchRoot.setOriginElement(rightObjectMatchRoot.getRightElement());
				redirectedAdd(root, MATCH_ELEMENT_NAME, subMatchRoot);
				createSub3Match(root, subMatchRoot, leftObjectMatchRoot, rightObjectMatchRoot);
			} else {
				for (EObject left : leftObjectMatchedElements)
					stillToFindFromModel1.add(left);
				for (EObject right : rightObjectMatchedElements)
					stillToFindFromModel2.add(right);
			}

			// We will now check through the unmatched object for matches.
			processUnmatchedElements(root, subMatchRoot);

			// #createSub3Match(MatchModel, Match3Element, Match2Elements,
			// Match2Elements) will have updated "remainingUnMatchedElements"
			final Set<EObject> remainingLeft = new HashSet<EObject>();
			final Set<EObject> remainingRight = new HashSet<EObject>();
			for (EObject unMatched : remainingUnMatchedElements) {
				if (unMatched.eResource() == leftObject.eResource()) {
					remainingLeft.add(unMatched);
					final TreeIterator<EObject> iterator = unMatched.eAllContents();
					while (iterator.hasNext())
						remainingLeft.add(iterator.next());
				} else if (unMatched.eResource() == rightObject.eResource()) {
					remainingRight.add(unMatched);
					final TreeIterator<EObject> iterator = unMatched.eAllContents();
					while (iterator.hasNext())
						remainingRight.add(iterator.next());
				}
			}
			stillToFindFromModel1.clear();
			stillToFindFromModel2.clear();
			final List<Match2Elements> mappings = mapLists(new ArrayList<EObject>(remainingLeft),
					new ArrayList<EObject>(remainingRight), this
							.<Integer> getOption(MatchOptions.OPTION_SEARCH_WINDOW), monitor);
			for (Match2Elements map : mappings) {
				final Match3Elements subMatch = MatchFactory.eINSTANCE.createMatch3Elements();
				subMatch.setLeftElement(map.getLeftElement());
				subMatch.setRightElement(map.getRightElement());
				if (subMatchRoot == null)
					redirectedAdd(root, MATCH_ELEMENT_NAME, subMatch);
				else
					redirectedAdd(subMatchRoot, SUBMATCH_ELEMENT_NAME, subMatch);
			}
			final Map<EObject, Boolean> unMatchedElements = new EMFCompareMap<EObject, Boolean>();
			for (EObject remoteUnMatch : stillToFindFromModel1) {
				unMatchedElements.put(remoteUnMatch, true);
			}
			for (EObject unMatch : stillToFindFromModel2) {
				unMatchedElements.put(unMatch, false);
			}
			createThreeWayUnmatchElements(root, unMatchedElements);
		} catch (FactoryException e) {
			EMFComparePlugin.log(e, false);
		} catch (InterruptedException e) {
			// Cannot be thrown since we have no monitor
		}

		return root;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.match.api.IMatchEngine#contentMatch(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject, java.util.Map)
	 */
	public MatchModel contentMatch(EObject leftObject, EObject rightObject, Map<String, Object> optionMap) {
		if (optionMap != null && optionMap.size() > 0)
			loadOptionMap(optionMap);

		final Monitor monitor = createProgressMonitor();

		final MatchModel root = MatchFactory.eINSTANCE.createMatchModel();
		setModelRoots(root, leftObject.eResource(), rightObject.eResource());

		/*
		 * As we could very well be passed two EClasses (as opposed to modelMatch which compares all roots of
		 * a resource), we cannot filter the model.
		 */

		final Set<EObject> still1 = new HashSet<EObject>();
		final Set<EObject> still2 = new HashSet<EObject>();

		// navigate through both objects at the same time and realize mappings..
		try {
			if (!this.<Boolean> getOption(MatchOptions.OPTION_IGNORE_XMI_ID))
				matchByXMIID(leftObject, rightObject);
			if (!this.<Boolean> getOption(MatchOptions.OPTION_IGNORE_ID))
				matchByID(leftObject, rightObject);
			if (isSimilar(leftObject, rightObject)) {
				stillToFindFromModel1.clear();
				stillToFindFromModel2.clear();
				final Match2Elements matchModelRoot = recursiveMappings(leftObject, rightObject, monitor);
				redirectedAdd(root, MATCH_ELEMENT_NAME, matchModelRoot);
				createSubMatchElements(matchModelRoot, new ArrayList<EObject>(stillToFindFromModel1),
						new ArrayList<EObject>(stillToFindFromModel2), monitor);
				still1.addAll(stillToFindFromModel1);
				still2.addAll(stillToFindFromModel2);
				createUnmatchElements(root, still1, Side.LEFT);
				createUnmatchElements(root, still2, Side.RIGHT);
			} else {
				// The two objects passed as this method's parameters are not
				// similar. Creates unmatch root.
				still1.add(leftObject);
				still1.add(rightObject);
				createUnmatchElements(root, still1, null);
			}
		} catch (FactoryException e) {
			EMFComparePlugin.log(e, false);
		} catch (InterruptedException e) {
			// Cannot be thrown since we have no monitor
		}
		return root;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.match.api.IMatchEngine#modelMatch(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, java.util.Map)
	 */
	public MatchModel modelMatch(EObject leftRoot, EObject rightRoot, EObject ancestor,
			Map<String, Object> optionMap) throws InterruptedException {
		if (optionMap != null && optionMap.size() > 0)
			loadOptionMap(optionMap);

		MatchModel result = null;
		// Creates and sizes progress monitor
		final Monitor monitor = createProgressMonitor();
		int size = 1;
		for (EObject root : leftRoot.eResource().getContents()) {
			final Iterator<EObject> rootContent = root.eAllContents();
			while (rootContent.hasNext()) {
				rootContent.next();
				size++;
			}
		}
		startMonitor(monitor, size * 2);

		result = doMatch(leftRoot.eResource(), rightRoot.eResource(), ancestor.eResource(), monitor);

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.match.api.IMatchEngine#modelMatch(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject, java.util.Map)
	 */
	public MatchModel modelMatch(EObject leftRoot, EObject rightRoot, Map<String, Object> optionMap)
			throws InterruptedException {
		if (optionMap != null && optionMap.size() > 0)
			loadOptionMap(optionMap);

		MatchModel result = null;
		// Creates and sizes progress monitor
		final Monitor monitor = createProgressMonitor();
		int size = 1;
		for (EObject root : leftRoot.eResource().getContents()) {
			final Iterator<EObject> rootContent = root.eAllContents();
			while (rootContent.hasNext()) {
				rootContent.next();
				size++;
			}
		}
		startMonitor(monitor, size);

		result = doMatch(leftRoot.eResource(), rightRoot.eResource(), monitor);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.match.api.IMatchEngine#reset()
	 */
	public void reset() {
		filter.clear();
		options.clear();
		matchedByID.clear();
		matchedByXMIID.clear();
		metricsCache.clear();
		remainingUnMatchedElements.clear();
		stillToFindFromModel1.clear();
		stillToFindFromModel2.clear();
		options.putAll(loadPreferenceOptionMap());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.match.api.IMatchEngine#resourceMatch(org.eclipse.emf.ecore.resource.Resource,
	 *      org.eclipse.emf.ecore.resource.Resource, java.util.Map)
	 */
	public MatchModel resourceMatch(Resource leftResource, Resource rightResource,
			Map<String, Object> optionMap) throws InterruptedException {
		if (optionMap != null && optionMap.size() > 0)
			loadOptionMap(optionMap);

		MatchModel result = null;
		// Creates and sizes progress monitor
		final Monitor monitor = createProgressMonitor();
		int size = 1;
		for (EObject root : leftResource.getContents()) {
			final Iterator<EObject> rootContent = root.eAllContents();
			while (rootContent.hasNext()) {
				rootContent.next();
				size++;
			}
		}
		startMonitor(monitor, size);

		result = doMatch(leftResource, rightResource, monitor);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.match.api.IMatchEngine#resourceMatch(org.eclipse.emf.ecore.resource.Resource,
	 *      org.eclipse.emf.ecore.resource.Resource, org.eclipse.emf.ecore.resource.Resource, java.util.Map)
	 */
	public MatchModel resourceMatch(Resource leftResource, Resource rightResource, Resource ancestorResource,
			Map<String, Object> optionMap) throws InterruptedException {
		if (optionMap != null && optionMap.size() > 0)
			loadOptionMap(optionMap);

		MatchModel result = null;
		// Creates and sizes progress monitor
		final Monitor monitor = createProgressMonitor();
		int size = 1;
		for (EObject root : leftResource.getContents()) {
			final Iterator<EObject> rootContent = root.eAllContents();
			while (rootContent.hasNext()) {
				rootContent.next();
				size++;
			}
		}
		startMonitor(monitor, size * 2);

		result = doMatch(leftResource, rightResource, ancestorResource, monitor);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.match.api.IMatchEngine#resourceSetMatch(org.eclipse.emf.ecore.resource.ResourceSet,
	 *      org.eclipse.emf.ecore.resource.ResourceSet, java.util.Map)
	 */
	public MatchModel resourceSetMatch(ResourceSet leftResourceSet, ResourceSet rightResourceSet,
			Map<String, Object> optionMap) {
		// TODO this should be implemented. It will break both match and diff
		// MMs so wait till 0.9/1.0.
		throw new UnsupportedOperationException("Not implemented yet."); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.match.api.IMatchEngine#resourceSetMatch(org.eclipse.emf.ecore.resource.ResourceSet,
	 *      org.eclipse.emf.ecore.resource.ResourceSet, org.eclipse.emf.ecore.resource.ResourceSet,
	 *      java.util.Map)
	 */
	public MatchModel resourceSetMatch(ResourceSet leftResourceSet, ResourceSet rightResourceSet,
			ResourceSet ancestorResourceSet, Map<String, Object> optionMap) {
		// TODO this should be implemented. It will break both match and diff
		// MMs so wait till 0.9/1.0.
		throw new UnsupportedOperationException("Not implemented yet."); //$NON-NLS-1$
	}

	/**
	 * This will compute the similarity between two {@link EObject}s' contents.
	 * 
	 * @param obj1
	 *            First of the two {@link EObject}s.
	 * @param obj2
	 *            Second of the two {@link EObject}s.
	 * @return <code>double</code> representing the similarity between the two {@link EObject}s' contents.
	 *         0 &lt; value &lt; 1.
	 * @throws FactoryException
	 *             Thrown if we cannot compute the {@link EObject}s' contents similarity metrics.
	 * @see NameSimilarity#contentValue(EObject, MetamodelFilter)
	 */
	protected double contentSimilarity(EObject obj1, EObject obj2) throws FactoryException {
		double similarity = 0d;
		final Double value = getSimilarityFromCache(obj1, obj2, VALUE_SIMILARITY);
		if (value != null) {
			similarity = value;
		} else {
			similarity = NameSimilarity.nameSimilarityMetric(NameSimilarity.contentValue(obj1, filter),
					NameSimilarity.contentValue(obj2, filter));
			setSimilarityInCache(obj1, obj2, VALUE_SIMILARITY, similarity);
		}
		return similarity;
	}

	/**
	 * This will iterate through the given {@link List} and return its element which is most similar (as given
	 * by {@link #absoluteMetric(EObject, EObject)}) to the given {@link EObject}.
	 * 
	 * @param eObj
	 *            {@link EObject} we're searching a similar item for in the list.
	 * @param list
	 *            {@link List} in which we are to find an object similar to <code>eObj</code>.
	 * @return The element from <code>list</code> which is the most similar to <code>eObj</code>.
	 * @throws FactoryException
	 *             Thrown if we cannot compute the {@link #absoluteMetric(EObject, EObject) absolute metric}
	 *             between <code>eObj</code> and one of the list's objects.
	 */
	protected EObject findMostSimilar(EObject eObj, List<EObject> list) throws FactoryException {
		double max = 0d;
		EObject resultObject = null;
		final Iterator<EObject> it = list.iterator();
		while (it.hasNext() && max != 1.0d) {
			final EObject next = it.next();
			if (this.<Boolean> getOption(MatchOptions.OPTION_DISTINCT_METAMODELS)
					|| eObj.eClass() == next.eClass()) {
				final double similarity = absoluteMetric(eObj, next);
				if (similarity > max) {
					max = similarity;
					resultObject = next;
				}
			}
		}
		return resultObject;
	}

	/**
	 * This will return the value associated to the given key in the options map.
	 * <p>
	 * NOTE : Misuses of this method will easily throw {@link ClassCastException}s.
	 * </p>
	 * 
	 * @param <T>
	 *            Expected type of the value associated to <code>key</code>.
	 * @param key
	 *            Key of the value to retrieve.
	 * @return Value associated to the given key in the options map.
	 * @throws ClassCastException
	 *             If the value isn't assignment compatible with the expected type.
	 */
	@SuppressWarnings("unchecked")
	protected <T> T getOption(String key) throws ClassCastException {
		return (T)options.get(key);
	}

	/**
	 * This will lookup in the {@link #matchedByID} map and check if the two given objects have indeed been
	 * matched by their ID.
	 * 
	 * @param left
	 *            Left of the two objects to check.
	 * @param right
	 *            right of the two objects to check.
	 * @return <code>True</code> these objects haven't been matched by their ID, <code>False</code>
	 *         otherwise.
	 * @throws FactoryException
	 *             Thrown if we cannot compute the key for the object to match.
	 */
	protected boolean haveDistinctID(EObject left, EObject right) throws FactoryException {
		boolean result = false;
		final StringBuilder leftKey = new StringBuilder();
		leftKey.append(NameSimilarity.findName(left));
		leftKey.append(left.hashCode());
		final EObject matched = matchedByID.get(leftKey.toString());
		// must be the same instance
		if (matched != null)
			result = matched != right;
		else
			// we didn't match a single element with this ID.
			// This could be because no IDs are defined.
			result = EcoreUtil.getID(left) != null;
		return result;
	}

	/**
	 * This will lookup in the {@link #matchedByXMIID} map and check if the two given objects have indeed been
	 * matched by their XMI ID.
	 * 
	 * @param left
	 *            Left of the two objects to check.
	 * @param right
	 *            right of the two objects to check.
	 * @return <code>True</code> these objects haven't been matched by their XMI ID, <code>False</code>
	 *         otherwise.
	 * @throws FactoryException
	 *             Thrown if we cannot compute the key for the object to match.
	 */
	protected boolean haveDistinctXMIID(EObject left, EObject right) throws FactoryException {
		boolean result = false;
		final StringBuilder leftKey = new StringBuilder();
		leftKey.append(NameSimilarity.findName(left));
		leftKey.append(left.hashCode());
		final EObject matched = matchedByXMIID.get(leftKey.toString());
		// must be the same instance
		if (matched != null)
			result = matched != right;
		else
			// we didn't match a single element with this ID.
			// This could be because no IDs are defined.
			result = left.eResource() instanceof XMIResource
					&& ((XMIResource)left.eResource()).getID(left) != null;
		return result;
	}

	/**
	 * Returns <code>True</code> if the 2 given {@link EObject}s are considered similar.
	 * 
	 * @param obj1
	 *            The first {@link EObject} to compare.
	 * @param obj2
	 *            Second of the {@link EObject}s to compare.
	 * @return <code>True</code> if both elements have the same serialization ID, <code>False</code>
	 *         otherwise.
	 * @throws FactoryException
	 *             Thrown if we cannot compute one of the needed similarity.
	 */
	protected boolean isSimilar(EObject obj1, EObject obj2) throws FactoryException {
		boolean similar = false;

		// Defines threshold constants to assume objects' similarity
		final double nameOnlyMetricThreshold = 0.7d;
		final double fewerAttributesNameThreshold = 0.8d;
		final double relationsThreshold = 0.3d;
		final double nameThreshold = 0.2d;
		final double contentThreshold = 0.9d;
		final double triWayThreshold = 0.9d;
		final double generalThreshold = GENERAL_THRESHOLD;

		// Computes some of the required metrics
		final double nameSimilarity = nameSimilarity(obj1, obj2);
		final boolean hasSameUri = hasSameUri(obj1, obj2);
		final int obj1NonNullFeatures = nonNullFeaturesCount(obj1);
		final int obj2NonNullFeatures = nonNullFeaturesCount(obj2);

		if (!this.<Boolean> getOption(MatchOptions.OPTION_DISTINCT_METAMODELS)
				&& obj1.eClass() != obj2.eClass()) {
			similar = false;
		} else if (!this.<Boolean> getOption(MatchOptions.OPTION_IGNORE_ID) && haveDistinctID(obj1, obj2)) {
			similar = false;
		} else if (!this.<Boolean> getOption(MatchOptions.OPTION_IGNORE_XMI_ID)
				&& haveDistinctXMIID(obj1, obj2)) {
			similar = false;
		} else if (nameSimilarity == 1) {
			similar = true;
			// softer tests if we don't have enough attributes to compare the
			// objects
		} else if (obj1NonNullFeatures == 1 && obj2NonNullFeatures == 1) {
			similar = nameSimilarity > nameOnlyMetricThreshold;
		} else if (nameSimilarity > fewerAttributesNameThreshold
				&& obj1NonNullFeatures <= MIN_ATTRIBUTES_COUNT && obj2NonNullFeatures <= MIN_ATTRIBUTES_COUNT
				&& typeSimilarity(obj1, obj2) > generalThreshold) {
			similar = true;
		} else {
			final double contentSimilarity = contentSimilarity(obj1, obj2);
			final double relationsSimilarity = relationsSimilarity(obj1, obj2);

			if (relationsSimilarity == 1 && hasSameUri && nameSimilarity > nameThreshold) {
				similar = true;
			} else if (contentSimilarity == 1 && relationsSimilarity == 1) {
				similar = true;
			} else if (contentSimilarity > generalThreshold && relationsSimilarity > relationsThreshold
					&& nameSimilarity > nameThreshold) {
				similar = true;
			} else if (relationsSimilarity > generalThreshold && contentSimilarity > contentThreshold) {
				similar = true;
			} else if (contentSimilarity > triWayThreshold && nameSimilarity > triWayThreshold
					&& relationsSimilarity > triWayThreshold) {
				similar = true;
			} else if (contentSimilarity > generalThreshold && nameSimilarity > generalThreshold
					&& typeSimilarity(obj1, obj2) > generalThreshold) {
				similar = true;
			}
		}
		return similar;
	}

	/**
	 * This will compute the similarity between two {@link EObject}s' names.
	 * 
	 * @param obj1
	 *            First of the two {@link EObject}s.
	 * @param obj2
	 *            Second of the two {@link EObject}s.
	 * @return <code>double</code> representing the similarity between the two {@link EObject}s' names. 0
	 *         &lt; value &lt; 1.
	 * @see NameSimilarity#nameSimilarityMetric(String, String)
	 */
	protected double nameSimilarity(EObject obj1, EObject obj2) {
		double similarity = 0d;
		try {
			final Double value = getSimilarityFromCache(obj1, obj2, NAME_SIMILARITY);
			if (value != null) {
				similarity = value;
			} else {
				similarity = NameSimilarity.nameSimilarityMetric(NameSimilarity.findName(obj1),
						NameSimilarity.findName(obj2));
				setSimilarityInCache(obj1, obj2, NAME_SIMILARITY, similarity);
			}
		} catch (FactoryException e) {
			// fails silently, will return a similarity of 0d
		}
		return similarity;
	}

	/*
	 * created as package visibility method to allow access from initializer's listener. Shouldn't be further
	 * opened.
	 */
	/**
	 * This will load all the needed options with their default values.
	 * 
	 * @return Map containing all the needed options with their default values.
	 */
	/* package */Map<String, Object> loadPreferenceOptionMap() {
		final Map<String, Object> optionMap = new EMFCompareMap<String, Object>(17);
		optionMap.put(MatchOptions.OPTION_SEARCH_WINDOW, getPreferenceSearchWindow());
		optionMap.put(MatchOptions.OPTION_IGNORE_ID, getPreferenceIgnoreID());
		optionMap.put(MatchOptions.OPTION_IGNORE_XMI_ID, getPreferenceIgnoreXMIID());
		optionMap.put(MatchOptions.OPTION_DISTINCT_METAMODELS, getPreferenceDistinctMetaModel());
		optionMap.put(MatchOptions.OPTION_PROGRESS_MONITOR, null);
		return optionMap;
	}

	/**
	 * Returns an absolute comparison metric between the two given {@link EObject}s.
	 * 
	 * @param obj1
	 *            The first {@link EObject} to compare.
	 * @param obj2
	 *            Second of the {@link EObject}s to compare.
	 * @return An absolute comparison metric. 0 &lt; value &lt; 1.
	 * @throws FactoryException
	 *             Thrown if we cannot compute the content similarity.
	 */
	private double absoluteMetric(EObject obj1, EObject obj2) throws FactoryException {
		final double nameSimilarity = nameSimilarity(obj1, obj2);
		if (nameSimilarity == 1.0d) {
			return 1.0;
		}
		final double relationsSimilarity = relationsSimilarity(obj1, obj2);
		double sameUri = 0d;
		if (hasSameUri(obj1, obj2))
			sameUri = 1;
		final double positionSimilarity = relationsSimilarity / 2d + sameUri / 2d;

		final double contentWeight = 0.5d;

		if (nonNullFeaturesCount(obj1) > MIN_ATTRIBUTES_COUNT
				&& nonNullFeaturesCount(obj2) > MIN_ATTRIBUTES_COUNT) {
			final double nameWeight = 0.8d;
			final double positionWeight = 0.4d;
			final double contentSimilarity = contentSimilarity(obj1, obj2);
			// Computing type similarity really is time expensive
			// double typeSimilarity = typeSimilarity(obj1, obj2);
			return (contentSimilarity * contentWeight + nameSimilarity * nameWeight + positionSimilarity
					* positionWeight)
					/ (contentWeight + nameWeight + positionWeight);
		}
		// we didn't have enough features to compute an accurate metric
		final double nameWeight = 0.4d;
		final double positionWeight = 0.2d;
		return (nameSimilarity * nameWeight + positionSimilarity * positionWeight)
				/ (nameWeight + positionWeight);
	}

	/**
	 * Returns an absolute comparison metric between the three given {@link EObject}s.
	 * 
	 * @param obj1
	 *            The first {@link EObject} to compare.
	 * @param obj2
	 *            Second of the {@link EObject}s to compare.
	 * @param obj3
	 *            Second of the {@link EObject}s to compare.
	 * @return An absolute comparison metric
	 * @throws FactoryException
	 *             Thrown if we cannot compute the content similarity.
	 */
	private double absoluteMetric(EObject obj1, EObject obj2, EObject obj3) throws FactoryException {
		final double metric1 = absoluteMetric(obj1, obj2);
		final double metric2 = absoluteMetric(obj1, obj3);
		final double metric3 = absoluteMetric(obj2, obj3);

		return (metric1 + metric2 + metric3) / 3;
	}

	/**
	 * This will recursively create three-way submatches and add them under the given {@link MatchModel}. The
	 * two {@link Match2Elements} we consider as parameters are the result of the two-way comparisons between :
	 * <ul>
	 * <li>The left and origin model.</li>
	 * <li>The right and origin model.</li>
	 * </ul>
	 * <br/><br/>We can then consider that a {@link Match3Element} would be :
	 * 
	 * <pre>
	 * match.leftElement = left.getLeftElement();
	 * match.originElement = left.getRightElement() = right.getRightElement();
	 * match.rightElement = right.getLeftElement();
	 * </pre>
	 * 
	 * @param root
	 *            {@link MatchModel} under which to add our {@link Match3Element}s.
	 * @param matchElementRoot
	 *            Root of the {@link Match3Element}s' hierarchy for the current element to be created.
	 * @param left
	 *            Left {@link Match2Elements} to consider.
	 * @param right
	 *            Right {@link Match2Elements} to consider.
	 * @throws FactoryException
	 *             Thrown if we cannot compute the {@link #absoluteMetric(EObject, EObject, EObject) absolute
	 *             metric} between the three elements or if we cannot add a {@link Match3Element} under the
	 *             given <code>matchElementRoot</code>.
	 */
	private void createSub3Match(MatchModel root, Match3Elements matchElementRoot, Match2Elements left,
			Match2Elements right) throws FactoryException {
		final List<MatchElement> leftSubMatches = left.getSubMatchElements();
		final List<MatchElement> rightSubMatches = right.getSubMatchElements();
		final List<MatchElement> leftNotFound = new ArrayList<MatchElement>(leftSubMatches);
		final List<MatchElement> rightNotFound = new ArrayList<MatchElement>(rightSubMatches);

		for (MatchElement nextLeft : leftSubMatches) {
			final Match2Elements nextLeftMatch = (Match2Elements)nextLeft;
			Match2Elements correspondingMatch = null;

			for (MatchElement nextRight : rightNotFound) {
				final Match2Elements nextRightMatch = (Match2Elements)nextRight;
				if (nextRightMatch.getRightElement().equals(nextLeftMatch.getRightElement())) {
					correspondingMatch = nextRightMatch;
					break;
				}
			}

			if (correspondingMatch != null) {
				final Match3Elements match = MatchFactory.eINSTANCE.createMatch3Elements();
				match.setSimilarity(absoluteMetric(nextLeftMatch.getLeftElement(), correspondingMatch
						.getLeftElement(), correspondingMatch.getRightElement()));
				match.setLeftElement(nextLeftMatch.getLeftElement());
				match.setRightElement(correspondingMatch.getLeftElement());
				match.setOriginElement(correspondingMatch.getRightElement());
				redirectedAdd(matchElementRoot, SUBMATCH_ELEMENT_NAME, match);
				createSub3Match(root, matchElementRoot, nextLeftMatch, correspondingMatch);
				leftNotFound.remove(nextLeftMatch);
				rightNotFound.remove(correspondingMatch);
			}
		}

		for (MatchElement nextLeftNotFound : leftNotFound) {
			stillToFindFromModel1.add(nextLeftNotFound);
		}
		for (MatchElement nextRightNotFound : rightNotFound) {
			stillToFindFromModel2.add(nextRightNotFound);
		}
	}

	/**
	 * Creates the {@link Match2Elements submatch elements} corresponding to the mapping of objects from the
	 * two given {@link List}s.
	 * 
	 * @param root
	 *            Root of the {@link MatchModel} where to insert all these mappings.
	 * @param list1
	 *            First of the lists used to compute mapping.
	 * @param list2
	 *            Second of the lists used to compute mapping.
	 * @param monitor
	 *            {@link CompareProgressMonitor progress monitor} to display while the comparison lasts. Might
	 *            be <code>null</code>, in which case we won't monitor progress.
	 * @throws FactoryException
	 *             Thrown if we cannot match the elements of the two lists or add submatch elements to
	 *             <code>root</code>.
	 * @throws InterruptedException
	 *             Thrown if the operation is cancelled or fails somehow.
	 */
	private void createSubMatchElements(EObject root, List<EObject> list1, List<EObject> list2,
			Monitor monitor) throws FactoryException, InterruptedException {
		stillToFindFromModel1.clear();
		stillToFindFromModel2.clear();
		final List<Match2Elements> mappings = mapLists(list1, list2, this
				.<Integer> getOption(MatchOptions.OPTION_SEARCH_WINDOW), monitor);

		final Iterator<Match2Elements> it = mappings.iterator();
		while (it.hasNext()) {
			final Match2Elements map = it.next();
			final Match2Elements match = recursiveMappings(map.getLeftElement(), map.getRightElement(),
					monitor);
			redirectedAdd(root, SUBMATCH_ELEMENT_NAME, match);
		}
	}

	/**
	 * Creates {@link UnmatchElement}s and {@link RemoteUnmatchElement}s wrapped around all the elements of
	 * the given {@link List}.
	 * 
	 * @param root
	 *            Root of the {@link MatchModel} under which to insert all these elements.
	 * @param unMatchedElements
	 *            {@link List} containing all the elements we haven't been able to match.
	 * @throws FactoryException
	 *             Thrown if we cannot add elements under the given {@link MatchModel root}.
	 */
	private void createThreeWayUnmatchElements(MatchModel root, Map<EObject, Boolean> unMatchedElements)
			throws FactoryException {
		
		for( Map.Entry<EObject, Boolean> entry : unMatchedElements.entrySet()) {
			
			// We will only consider the highest level of an unmatched element
			// hierarchy
			if (!unMatchedElements.containsKey(entry.getKey().eContainer())) {
				final UnmatchElement unMap;
				if( entry.getValue()) {
					unMap = MatchFactory.eINSTANCE.createUnmatchElement();
					unMap.setRemote(true);
				}
				else
					unMap = MatchFactory.eINSTANCE.createUnmatchElement();
				unMap.setElement( entry.getKey());
				redirectedAdd(root, UNMATCH_ELEMENT_NAME, unMap);
			}
		}
		unMatchedElements.clear();
	}

	/**
	 * Creates {@link UnmatchElement}s wrapped around all the elements of the given {@link List}.
	 * 
	 * @param root
	 *            Root of the {@link MatchModel} under which to insert all these {@link UnmatchElement}s.
	 * @param unMatchedElements
	 *            {@link Set} containing all the elements we haven't been able to match.
	 * @throws FactoryException
	 *             Thrown if we cannot add elements under the given {@link MatchModel root}.
	 */
	private void createUnmatchElements(MatchModel root, Set<EObject> unMatchedElements, Side side)
			throws FactoryException {
		for (EObject element : unMatchedElements) {
			final UnmatchElement unMap = MatchFactory.eINSTANCE.createUnmatchElement();
			unMap.setElement(element);
			if (side != null)
				unMap.setSide(side);
			redirectedAdd(root, UNMATCH_ELEMENT_NAME, unMap);
		}
		unMatchedElements.clear();
	}

	/**
	 * This method handles the creation and returning of a two way model match.
	 * 
	 * @param leftResource
	 *            Left model for the comparison.
	 * @param rightResource
	 *            Right model for the comparison.
	 * @param monitor
	 *            Progress monitor to display while the comparison lasts.
	 * @return The corresponding {@link MatchModel}.
	 * @throws InterruptedException
	 *             Thrown if the comparison is interrupted somehow.
	 */
	private MatchModel doMatch(Resource leftResource, Resource rightResource, Monitor monitor)
			throws InterruptedException {
		final MatchModel root = MatchFactory.eINSTANCE.createMatchModel();
		setModelRoots(root, leftResource, rightResource);

		// filters unused features
		filterUnused(leftResource);
		filterUnused(rightResource);

		// navigate through both models at the same time and realize mappings..
		try {
			if (!this.<Boolean> getOption(MatchOptions.OPTION_IGNORE_XMI_ID))
				if (leftResource instanceof XMIResource && rightResource instanceof XMIResource)
					matchByXMIID((XMIResource)leftResource, (XMIResource)rightResource);
			if (!this.<Boolean> getOption(MatchOptions.OPTION_IGNORE_ID))
				matchByID(leftResource, rightResource);

			monitor.subTask("Matching roots"); //$NON-NLS-1$
			final List<Match2Elements> matchedRoots = mapLists(leftResource.getContents(), rightResource
					.getContents(), this.<Integer> getOption(MatchOptions.OPTION_SEARCH_WINDOW), monitor);
			stillToFindFromModel1.clear();
			stillToFindFromModel2.clear();
			final List<EObject> unMatchedLeftRoots = new ArrayList<EObject>(leftResource.getContents());
			final List<EObject> unMatchedRightRoots = new ArrayList<EObject>(rightResource.getContents());
			// These sets will help us in keeping track of the yet to be found
			// elements
			final Set<EObject> still1 = new HashSet<EObject>();
			final Set<EObject> still2 = new HashSet<EObject>();

			// If one of the resources has no roots, considers it as deleted
			if (leftResource.getContents().size() > 0 && rightResource.getContents().size() > 0) {
				Match2Elements matchModelRoot = MatchFactory.eINSTANCE.createMatch2Elements();
				// We haven't found any similar roots, we then consider the
				// firsts to be similar.
				if (matchedRoots.size() == 0) {
					final Match2Elements rootMapping = MatchFactory.eINSTANCE.createMatch2Elements();
					rootMapping.setLeftElement(leftResource.getContents().get(0));
					EObject rightElement = findMostSimilar(leftResource.getContents().get(0),
							unMatchedRightRoots);
					if (rightElement == null)
						rightElement = unMatchedRightRoots.get(0);
					rootMapping.setRightElement(rightElement);
					matchedRoots.add(rootMapping);
				}
				monitor.subTask("Processing matched roots' contents"); //$NON-NLS-1$
				for (Match2Elements matchedRoot : matchedRoots) {
					
					List<EObject> rightContentsWithChildren = getContentsWithChildren(matchedRoot.getRightElement());
					final Match2Elements rootMapping = myRecursiveMappings(matchedRoot.getLeftElement(),
							matchedRoot.getRightElement(), rightContentsWithChildren, monitor);
					stillToFindFromModel2.addAll(rightContentsWithChildren);
//					final Match2Elements rootMapping = recursiveMappings(matchedRoot.getLeftElement(),
//							matchedRoot.getRightElement(), monitor);
					// this is the first passage
					if (matchModelRoot.getLeftElement() == null) {
						matchModelRoot = rootMapping;
						redirectedAdd(root, MATCH_ELEMENT_NAME, matchModelRoot);
					} else {
						redirectedAdd(matchModelRoot, SUBMATCH_ELEMENT_NAME, rootMapping);
					}

					// Synchronizes the two lists to avoid multiple elements
					still1.removeAll(stillToFindFromModel1);
					still2.removeAll(stillToFindFromModel2);
					// checks for matches within the yet to found elements lists
					createSubMatchElements(rootMapping, new ArrayList<EObject>(stillToFindFromModel1),
							new ArrayList<EObject>(stillToFindFromModel2), monitor);
					// Adds all unfound elements to the sets
					still1.addAll(stillToFindFromModel1);
					still2.addAll(stillToFindFromModel2);

					unMatchedLeftRoots.remove(matchedRoot.getLeftElement());
					unMatchedRightRoots.remove(matchedRoot.getRightElement());
				}
				// We'll iterate through the unMatchedRoots all contents
				monitor.subTask("Processing unmatched roots"); //$NON-NLS-1$
				createSubMatchElements(matchModelRoot, unMatchedLeftRoots, unMatchedRightRoots, monitor);
			} else {
				// Roots are unmatched, this is either a file addition or
				// deletion
				still1.addAll(unMatchedLeftRoots);
				still2.addAll(unMatchedRightRoots);
			}

			// Now takes care of remaining unfound elements
			still1.addAll(stillToFindFromModel1);
			still2.addAll(stillToFindFromModel2);
			createUnmatchElements(root, still1, Side.LEFT);
			createUnmatchElements(root, still2, Side.RIGHT);
		} catch (FactoryException e) {
			EMFComparePlugin.log(e, false);
		}
		return root;
	}

	/**
	 * This method handles the creation and returning of a three way model match.
	 * 
	 * @param leftResource
	 *            Left model for the comparison.
	 * @param rightResource
	 *            Right model for the comparison.
	 * @param ancestorResource
	 *            Common ancestor of the right and left models.
	 * @param monitor
	 *            Progress monitor to display while the comparison lasts.
	 * @return The corresponding {@link MatchModel}.
	 * @throws InterruptedException
	 *             Thrown if the comparison is interrupted somehow.
	 */
	private MatchModel doMatch(Resource leftResource, Resource rightResource, Resource ancestorResource,
			Monitor monitor) throws InterruptedException {
		final MatchModel root = MatchFactory.eINSTANCE.createMatchModel();
		setModelRoots(root, leftResource, rightResource, ancestorResource);
		final MatchModel root1AncestorMatch = doMatch(leftResource, ancestorResource, monitor);
		final MatchModel root2AncestorMatch = doMatch(rightResource, ancestorResource, monitor);

		final List<MatchElement> root1MatchedElements = new ArrayList<MatchElement>(root1AncestorMatch
				.getMatchedElements());
		final List<MatchElement> root2MatchedElements = new ArrayList<MatchElement>(root2AncestorMatch
				.getMatchedElements());

		// populates the unmatched elements list for later use
		for (Object unMatch : root1AncestorMatch.getUnmatchedElements())
			remainingUnMatchedElements.add(((UnmatchElement)unMatch).getElement());
		for (Object unMatch : root2AncestorMatch.getUnmatchedElements())
			remainingUnMatchedElements.add(((UnmatchElement)unMatch).getElement());

		try {
			final Match3Elements subMatchRoot = MatchFactory.eINSTANCE.createMatch3Elements();
			if (root2MatchedElements.size() > 0) {
				final Match2Elements root1Match = (Match2Elements)root1MatchedElements.get(0);
				final Match2Elements root2Match = (Match2Elements)root2MatchedElements.get(0);

				subMatchRoot.setSimilarity(absoluteMetric(root1Match.getLeftElement(), root2Match
						.getLeftElement(), root2Match.getRightElement()));
				subMatchRoot.setLeftElement(root1Match.getLeftElement());
				subMatchRoot.setRightElement(root2Match.getLeftElement());
				subMatchRoot.setOriginElement(root2Match.getRightElement());
				redirectedAdd(root, MATCH_ELEMENT_NAME, subMatchRoot);
				createSub3Match(root, subMatchRoot, root1Match, root2Match);
			} else if (root1MatchedElements.size() > 0) {
				stillToFindFromModel1.add(root1MatchedElements.get(0));
			}

			// We will now check through the unmatched object for matches. This
			// will allow for a more accurate detection
			// for models with multiple roots.
			processUnmatchedElements(root, subMatchRoot);

			// #processUnmatchedElements(MatchModel, Match3Element)
			// will have updated "remainingUnMatchedElements"
			final Set<EObject> remainingLeft = new HashSet<EObject>();
			final Set<EObject> remainingRight = new HashSet<EObject>();
			for (EObject unMatched : remainingUnMatchedElements) {
				if (unMatched.eResource() == leftResource) {
					remainingLeft.add(unMatched);
					final TreeIterator<EObject> iterator = unMatched.eAllContents();
					while (iterator.hasNext())
						remainingLeft.add(iterator.next());
				} else if (unMatched.eResource() == rightResource) {
					remainingRight.add(unMatched);
					final TreeIterator<EObject> iterator = unMatched.eAllContents();
					while (iterator.hasNext())
						remainingRight.add(iterator.next());
				}
			}
			stillToFindFromModel1.clear();
			stillToFindFromModel2.clear();
			final List<Match2Elements> mappings = mapLists(new ArrayList<EObject>(remainingLeft),
					new ArrayList<EObject>(remainingRight), this
							.<Integer> getOption(MatchOptions.OPTION_SEARCH_WINDOW), monitor);
			for (Match2Elements map : mappings) {
				final Match3Elements subMatch = MatchFactory.eINSTANCE.createMatch3Elements();
				subMatch.setLeftElement(map.getLeftElement());
				subMatch.setRightElement(map.getRightElement());
				redirectedAdd(subMatchRoot, SUBMATCH_ELEMENT_NAME, subMatch);
			}
			final Map<EObject, Boolean> unMatchedElements = new EMFCompareMap<EObject, Boolean>();
			for (EObject remoteUnMatch : stillToFindFromModel1) {
				unMatchedElements.put(remoteUnMatch, true);
			}
			for (EObject unMatch : stillToFindFromModel2) {
				unMatchedElements.put(unMatch, false);
			}
			createThreeWayUnmatchElements(root, unMatchedElements);
		} catch (FactoryException e) {
			EMFComparePlugin.log(e, false);
		}

		return root;
	}

	/**
	 * Filters unused features of the resource.
	 * 
	 * @param resource
	 *            Resource to be apply filter on.
	 */
	private void filterUnused(Resource resource) {
		for (EObject root : resource.getContents())
			filter.analyseModel(root);
	}

	/**
	 * Workaround for bug #235606 : elements held by a reference with containment=true and derived=true are
	 * not matched since not returned by {@link EObject#eContents()}. This allows us to return the list of all
	 * contents from an EObject <u>including</u> those references.
	 * 
	 * @param eObject
	 *            The EObject we seek the content of.
	 * @return The list of all the content of a given EObject, derived containmnent references included.
	 */
	@SuppressWarnings("unchecked")
	private List<EObject> getContents(EObject eObject) {
		// TODO can this be cached (Map<EClass, List<EReference>>)?
		final List<EObject> result = new ArrayList(eObject.eContents());
		for (EReference reference : eObject.eClass().getEAllReferences()) {
			if (reference.isContainment() && reference.isDerived()) {
				final Object value = eObject.eGet(reference);
				if (value instanceof Collection)
					result.addAll((Collection)value);
				else if (value instanceof EObject)
					result.add((EObject)value);
			}
		}
		return result;
	}

	/**
	 * Returns whether we should assume the metamodels of the compared models are distinct.
	 * 
	 * @return <code>true</code> if the metamodels are to be assumed distinct, <code>false</code>
	 *         otherwise.
	 */
	private boolean getPreferenceDistinctMetaModel() {
		if (EMFPlugin.IS_ECLIPSE_RUNNING && EMFComparePlugin.getDefault() != null)
			return EMFComparePlugin.getDefault().getBoolean(
					EMFComparePreferenceConstants.PREFERENCES_KEY_DISTINCT_METAMODEL);
		return MatchOptions.DEFAULT_DISTINCT_METAMODEL;
	}

	/**
	 * Returns whether we should ignore the IDs or compare using them.
	 * 
	 * @return <code>True</code> if we should ignore ID, <code>False</code> otherwise.
	 */
	private boolean getPreferenceIgnoreID() {
		if (EMFPlugin.IS_ECLIPSE_RUNNING && EMFComparePlugin.getDefault() != null)
			return EMFComparePlugin.getDefault().getBoolean(
					EMFComparePreferenceConstants.PREFERENCES_KEY_IGNORE_ID);
		return MatchOptions.DEFAULT_IGNORE_ID;
	}

	/**
	 * Returns whether we should ignore the XMI IDs or compare with them.
	 * 
	 * @return <code>True</code> if we should ignore XMI ID, <code>False</code> otherwise.
	 */
	private boolean getPreferenceIgnoreXMIID() {
		if (EMFPlugin.IS_ECLIPSE_RUNNING && EMFComparePlugin.getDefault() != null)
			return EMFComparePlugin.getDefault().getBoolean(
					EMFComparePreferenceConstants.PREFERENCES_KEY_IGNORE_XMIID);
		return MatchOptions.DEFAULT_IGNORE_XMI_ID;
	}

	/**
	 * Returns the search window corresponding to the number of siblings to consider while matching. Reducing
	 * this number (on the preferences page) considerably improve performances while reducing precision.
	 * 
	 * @return An <code>int</code> representing the number of siblings to consider for matching.
	 */
	private int getPreferenceSearchWindow() {
		int searchWindow = MatchOptions.DEFAULT_SEARCH_WINDOW;
		if (EMFPlugin.IS_ECLIPSE_RUNNING
				&& EMFComparePlugin.getDefault() != null
				&& EMFComparePlugin.getDefault().getInt(
						EMFComparePreferenceConstants.PREFERENCES_KEY_SEARCH_WINDOW) > 0)
			searchWindow = EMFComparePlugin.getDefault().getInt(
					EMFComparePreferenceConstants.PREFERENCES_KEY_SEARCH_WINDOW);
		if (searchWindow < 0)
			searchWindow = 0;
		return searchWindow;
	}

	/**
	 * Returns the given similarity between the two given {@link EObject}s as it is stored in cache.<br/>
	 * <p>
	 * <code>similarityKind</code> must be one of
	 * <ul>
	 * <li>{@link #NAME_SIMILARITY}</li>
	 * <li>{@link #TYPE_SIMILARITY}</li>
	 * <li>{@link #VALUE_SIMILARITY}</li>
	 * <li>{@link #RELATION_SIMILARITY}</li>
	 * </ul>
	 * </p>
	 * 
	 * @param obj1
	 *            First of the two {@link EObject}s we seek the similarity for.
	 * @param obj2
	 *            Second of the two {@link EObject}s we seek the similarity for.
	 * @param similarityKind
	 *            Kind of similarity to get.
	 * @return The similarity as described by <code>similarityKind</code> as it is stored in cache for the
	 *         two given {@link EObject}s.
	 */
	private Double getSimilarityFromCache(EObject obj1, EObject obj2, char similarityKind) {
		return metricsCache.get(pairHashCode(obj1, obj2, similarityKind));
	}

	/**
	 * Checks wether the two given {@link EObject} have the same URI.
	 * 
	 * @param obj1
	 *            First of the two {@link EObject} we're comparing.
	 * @param obj2
	 *            Second {@link EObject} we're comparing.
	 * @return <code>True</code> if the {@link EObject}s have the same URI, <code>False</code> otherwise.
	 */
	private boolean hasSameUri(EObject obj1, EObject obj2) {
		if (obj1.eResource() != null && obj2.eResource() != null)
			return obj1.eResource().getURIFragment(obj1).equals(obj2.eResource().getURIFragment(obj2));
		return false;
	}

	/**
	 * This replaces the contents of the defaults options map with the options overridden by the given map.
	 * 
	 * @param map
	 *            Map containing the option given to the match procedure. cannot be <code>null</code>.
	 */
	private void loadOptionMap(Map<String, Object> map) {
		options.putAll(map);
		if (this.<Integer> getOption(MatchOptions.OPTION_SEARCH_WINDOW) < 0)
			options.put(MatchOptions.OPTION_SEARCH_WINDOW, getPreferenceSearchWindow());
	}

	/**
	 * Returns a list containing mappings of the nodes of both given {@link List}s.
	 * 
	 * @param list1
	 *            First of the lists from which we need to map the elements
	 * @param list2
	 *            Second list to map the elements from.
	 * @param window
	 *            Number of siblings to consider for the matching.
	 * @param monitor
	 *            {@link CompareProgressMonitor Progress monitor} to display while the comparison lasts. Might
	 *            be <code>null</code>, in which case we won't monitor progress.
	 * @return A {@link List} containing mappings of the nodes of both given {@link List}s.
	 * @throws FactoryException
	 *             Thrown if the metrics cannot be computed.
	 * @throws InterruptedException
	 *             Thrown if the matching process is interrupted somehow.
	 */
	private List<Match2Elements> mapLists(List<EObject> list1, List<EObject> list2, int window,
			Monitor monitor) throws FactoryException, InterruptedException {
		final List<Match2Elements> result = new ArrayList<Match2Elements>();
		int curIndex = 0 - window / 2;
		final List<EObject> notFoundList1 = new ArrayList<EObject>(list1);
		final List<EObject> notFoundList2 = new ArrayList<EObject>(list2);

		final Iterator<EObject> it1 = list1.iterator();
		// then iterate over the 2 lists and compare the elements
		while (it1.hasNext() && notFoundList2.size() > 0) {
			final EObject obj1 = it1.next();

			final StringBuilder obj1Key = new StringBuilder();
			obj1Key.append(NameSimilarity.findName(obj1));
			obj1Key.append(obj1.hashCode());
			EObject obj2 = matchedByID.get(obj1Key.toString());

			if (obj2 == null) {
				// subtracts the difference between the notfound and the
				// original list to avoid ArrayOutOfBounds
				final int end = Math.min(curIndex + window - (list2.size() - notFoundList2.size()),
						notFoundList2.size());
				final int index = Math
						.min(Math.max(curIndex - (list2.size() - notFoundList2.size()), 0), end);

				obj2 = findMostSimilar(obj1, notFoundList2.subList(index, end));
				if (obj2 != null) {
					// checks if the most similar to obj2 is obj1
					final EObject obj1Check = findMostSimilar(obj2, notFoundList1);
					if (obj1Check != obj1 && obj1Check != null && isSimilar(obj1Check, obj2)) {
						continue;
					}
				}
			}

			if (notFoundList1.contains(obj1) && notFoundList2.contains(obj2) && isSimilar(obj1, obj2)) {
				final Match2Elements mapping = MatchFactory.eINSTANCE.createMatch2Elements();
				final double metric = absoluteMetric(obj1, obj2);

				mapping.setLeftElement(obj1);
				mapping.setRightElement(obj2);
				mapping.setSimilarity(metric);
				result.add(mapping);
				notFoundList2.remove(obj2);
				notFoundList1.remove(obj1);
			}
			curIndex += 1;
			monitor.worked(1);
			if (monitor.isCanceled())
				throw new InterruptedException();
		}

		// now putting the not found elements aside for later
		stillToFindFromModel2.addAll(notFoundList2);
		stillToFindFromModel1.addAll(notFoundList1);
		return result;
	}
	
	/**
	 * Returns a list containing mappings of the nodes of both given {@link List}s.
	 * 
	 * @param list1
	 *            First of the lists from which we need to map the elements
	 * @param list2
	 *            Second list to map the elements from.
	 * @param window
	 *            Number of siblings to consider for the matching.
	 * @param monitor
	 *            {@link CompareProgressMonitor Progress monitor} to display while the comparison lasts. Might
	 *            be <code>null</code>, in which case we won't monitor progress.
	 * @return A {@link List} containing mappings of the nodes of both given {@link List}s.
	 * @throws FactoryException
	 *             Thrown if the metrics cannot be computed.
	 * @throws InterruptedException
	 *             Thrown if the matching process is interrupted somehow.
	 */
	private List<Match2Elements> myMapLists(List<EObject> list1, List<EObject> list2, int window,
			Monitor monitor) throws FactoryException, InterruptedException {
		final List<Match2Elements> result = new ArrayList<Match2Elements>();
		int curIndex = 0 - window / 2;
		final List<EObject> notFoundList1 = new ArrayList<EObject>(list1);
		final List<EObject> notFoundList2 = new ArrayList<EObject>(list2);

		final Iterator<EObject> it1 = list1.iterator();
		// then iterate over the 2 lists and compare the elements
		while (it1.hasNext() && notFoundList2.size() > 0) {
			final EObject obj1 = it1.next();

			final StringBuilder obj1Key = new StringBuilder();
			obj1Key.append(NameSimilarity.findName(obj1));
			obj1Key.append(obj1.hashCode());
			EObject obj2 = matchedByID.get(obj1Key.toString());

			if (obj2 == null) {
				// subtracts the difference between the notfound and the
				// original list to avoid ArrayOutOfBounds
				final int end = Math.min(curIndex + window - (list2.size() - notFoundList2.size()),
						notFoundList2.size());
				final int index = Math
						.min(Math.max(curIndex - (list2.size() - notFoundList2.size()), 0), end);

				obj2 = findMostSimilar(obj1, notFoundList2.subList(index, end));
				if (obj2 != null) {
					// checks if the most similar to obj2 is obj1
					final EObject obj1Check = findMostSimilar(obj2, notFoundList1);
					if (obj1Check != obj1 && obj1Check != null && isSimilar(obj1Check, obj2)) {
						continue;
					}
				}
			}

			if (notFoundList1.contains(obj1) && notFoundList2.contains(obj2) && isSimilar(obj1, obj2)) {
				final Match2Elements mapping = MatchFactory.eINSTANCE.createMatch2Elements();
				final double metric = absoluteMetric(obj1, obj2);

				mapping.setLeftElement(obj1);
				mapping.setRightElement(obj2);
				mapping.setSimilarity(metric);
				result.add(mapping);
				notFoundList2.remove(obj2);
				notFoundList1.remove(obj1);
				list2.remove(obj2);
			}
			curIndex += 1;
			monitor.worked(1);
			if (monitor.isCanceled())
				throw new InterruptedException();
		}

		// now putting the not found elements aside for later
//		stillToFindFromModel2.addAll(notFoundList2);
		stillToFindFromModel1.addAll(notFoundList1);
		return result;
	}


	/**
	 * Iterates through both of the given EObjects to find all of their children that can be matched by their
	 * functional ID, then populates {@link #matchedByID} with those mappings.
	 * <p>
	 * Note that this method will perform a check to ensure the two objects' resources are indeed
	 * XMIResources.
	 * </p>
	 * 
	 * @param obj1
	 *            First of the two EObjects to visit.
	 * @param obj2
	 *            Second of the EObjects to visit.
	 * @throws FactoryException
	 *             Thrown if we couldn't compute a key to store the items in cache.
	 */
	private void matchByID(EObject obj1, EObject obj2) throws FactoryException {
		matchedByID.clear();
		final Iterator<EObject> iterator1 = obj1.eAllContents();
		while (iterator1.hasNext()) {
			final EObject item1 = iterator1.next();
			final String item1ID = EcoreUtil.getID(item1);
			if (item1ID != null) {
				final Iterator<EObject> iterator2 = obj2.eAllContents();
				while (iterator2.hasNext()) {
					final EObject item2 = iterator2.next();
					final String item2ID = EcoreUtil.getID(item2);
					if (item2 != null && item1ID.equals(item2ID)) {
						final StringBuilder item1Key = new StringBuilder();
						item1Key.append(NameSimilarity.findName(item1));
						item1Key.append(item1.hashCode());
						matchedByID.put(item1Key.toString(), item2);
						break;
					}
				}
			}
		}
	}

	/**
	 * Iterates through both of the given {@link XMIResource resources} to find all the elements that can be
	 * matched by their XMI ID, then populates {@link #matchedByID} with those mappings.
	 * 
	 * @param left
	 *            First of the two {@link XMIResource resources} to visit.
	 * @param right
	 *            Second of the {@link XMIResource resources} to visit.
	 * @throws FactoryException
	 *             Thrown if we couldn't compute a key to store the items in cache.
	 */
	private void matchByID(Resource left, Resource right) throws FactoryException {
		matchedByID.clear();
		final Iterator<EObject> leftIterator = left.getAllContents();
		while (leftIterator.hasNext()) {
			final EObject item1 = leftIterator.next();
			final String item1ID = EcoreUtil.getID(item1);
			if (item1ID != null) {
				final Iterator<EObject> rightIterator = right.getAllContents();
				while (rightIterator.hasNext()) {
					final EObject item2 = rightIterator.next();
					final String item2ID = EcoreUtil.getID(item2);
					if (item2 != null && item1ID.equals(item2ID)) {
						final StringBuilder item1Key = new StringBuilder();
						item1Key.append(NameSimilarity.findName(item1));
						item1Key.append(item1.hashCode());
						matchedByID.put(item1Key.toString(), item2);
						break;
					}
				}
			}
		}
	}

	/**
	 * Iterates through both of the given EObjects to find all of their children that can be matched by their
	 * XMI ID, then populates {@link #matchedByXMIID} with those mappings.
	 * <p>
	 * Note that this method will perform a check to ensure the two objects' resources are indeed
	 * XMIResources.
	 * </p>
	 * 
	 * @param obj1
	 *            First of the two EObjects to visit.
	 * @param obj2
	 *            Second of the EObjects to visit.
	 * @throws FactoryException
	 *             Thrown if we couldn't compute a key to store the items in cache.
	 */
	private void matchByXMIID(EObject obj1, EObject obj2) throws FactoryException {
		matchedByXMIID.clear();
		if (obj1 != null && obj2 != null && obj1.eResource() instanceof XMIResource
				&& obj2.eResource() instanceof XMIResource) {
			final XMIResource left = (XMIResource)obj1.eResource();
			final XMIResource right = (XMIResource)obj2.eResource();
			final Iterator<EObject> iterator = obj1.eAllContents();
			while (iterator.hasNext()) {
				final EObject item1 = iterator.next();
				final String item1ID = left.getID(item1);
				if (item1ID != null) {
					final EObject item2 = right.getEObject(item1ID);
					if (item2 != null) {
						final StringBuilder item1Key = new StringBuilder();
						item1Key.append(NameSimilarity.findName(item1));
						item1Key.append(item1.hashCode());
						matchedByXMIID.put(item1Key.toString(), item2);
					}
				}
			}
		}
	}

	/**
	 * Iterates through both of the given {@link XMIResource resources} to find all the elements that can be
	 * matched by their XMI ID, then populates {@link #matchedByXMIID} with those mappings.
	 * 
	 * @param left
	 *            First of the two {@link XMIResource resources} to visit.
	 * @param right
	 *            Second of the {@link XMIResource resources} to visit.
	 * @throws FactoryException
	 *             Thrown if we couldn't compute a key to store the items in cache.
	 */
	private void matchByXMIID(XMIResource left, XMIResource right) throws FactoryException {
		matchedByXMIID.clear();
		final Iterator<EObject> leftIterator = left.getAllContents();

		while (leftIterator.hasNext()) {
			final EObject item1 = leftIterator.next();
			final String item1ID = left.getID(item1);
			if (item1ID != null) {
				final EObject item2 = right.getEObject(item1ID);
				if (item2 != null) {
					final StringBuilder item1Key = new StringBuilder();
					item1Key.append(NameSimilarity.findName(item1));
					item1Key.append(item1.hashCode());
					matchedByXMIID.put(item1Key.toString(), item2);
				}
			}
		}
	}

	/**
	 * Counts all the {@link EStructuralFeature features} of the given {@link EObject} that are
	 * <code>null</code> or initialized to the empty {@link String} &quot;&quot;.
	 * 
	 * @param eobj
	 *            {@link EObject} we need to count the empty features of.
	 * @return The number of features initialized to <code>null</code> or the empty String.
	 */
	private int nonNullFeaturesCount(EObject eobj) {
		// TODO should probably cache result here
		int nonNullFeatures = 0;
		final Iterator<EStructuralFeature> features = eobj.eClass().getEAllStructuralFeatures().iterator();
		while (features.hasNext()) {
			final EStructuralFeature feature = features.next();
			if (eobj.eGet(feature) != null && !"".equals(eobj.eGet(feature).toString())) //$NON-NLS-1$
				nonNullFeatures++;
		}
		return nonNullFeatures;
	}

	/**
	 * Computes an unique key between to {@link EObject}s to store their similarity in cache.
	 * <p>
	 * <code>similarityKind</code> must be one of
	 * <ul>
	 * <li>{@link #NAME_SIMILARITY}</li>
	 * <li>{@link #TYPE_SIMILARITY}</li>
	 * <li>{@link #VALUE_SIMILARITY}</li>
	 * <li>{@link #RELATION_SIMILARITY}</li>
	 * </ul>
	 * </p>
	 * 
	 * @param obj1
	 *            First of the two {@link EObject}s.
	 * @param obj2
	 *            Second of the two {@link EObject}s.
	 * @param similarityKind
	 *            Kind of similarity this key will represent in cache.
	 * @return Unique key for the similarity cache.
	 */
	private String pairHashCode(EObject obj1, EObject obj2, char similarityKind) {
		if (similarityKind == NAME_SIMILARITY || similarityKind == TYPE_SIMILARITY
				|| similarityKind == VALUE_SIMILARITY || similarityKind == RELATION_SIMILARITY) {
			final StringBuilder hash = new StringBuilder();
			hash.append(similarityKind).append(obj1.hashCode()).append(obj2.hashCode());
			return hash.toString();
		}
		throw new IllegalArgumentException("DifferencesServices.illegalSimilarityKind"); //$NON-NLS-1$
	}

	/**
	 * Allows for a more accurate modifications detection for three way comparison with multiple roots models.
	 * 
	 * @param root
	 *            Root of the {@link MatchModel}.
	 * @param subMatchRoot
	 *            Root of the {@link Match3Element}s' hierarchy for the current element to be created.
	 * @throws FactoryException
	 *             Thrown if we cannot compute {@link EObject}s similarity or if adding elements to either
	 *             <code>root</code> or <code>subMatchRoot</code> fails somehow.
	 */
	private void processUnmatchedElements(MatchModel root, Match3Elements subMatchRoot)
			throws FactoryException {
		for (EObject obj1 : new ArrayList<EObject>(stillToFindFromModel1)) {
			boolean matchFound = false;
			if (obj1 instanceof Match2Elements) {
				final Match2Elements match1 = (Match2Elements)obj1;
				for (EObject obj2 : new ArrayList<EObject>(stillToFindFromModel2)) {
					if (obj2 instanceof Match2Elements) {
						final Match2Elements match2 = (Match2Elements)obj2;

						if (match1.getRightElement() == match2.getRightElement()) {
							matchFound = true;
							final Match3Elements match = MatchFactory.eINSTANCE.createMatch3Elements();
							match.setSimilarity(absoluteMetric(match1.getLeftElement(), match2
									.getLeftElement(), match2.getRightElement()));
							match.setLeftElement(match1.getLeftElement());
							match.setRightElement(match2.getLeftElement());
							match.setOriginElement(match2.getRightElement());
							// This will happen if we couldn't match previously
							if (subMatchRoot == null) {
								redirectedAdd(root, MATCH_ELEMENT_NAME, match);
								createSub3Match(root, match, match1, match2);
							} else {
								redirectedAdd(subMatchRoot, SUBMATCH_ELEMENT_NAME, match);
								createSub3Match(root, subMatchRoot, match1, match2);
							}
							stillToFindFromModel1.remove(match1);
							stillToFindFromModel2.remove(match2);
						}
					}
				}
				if (!matchFound) {
					remainingUnMatchedElements.add(match1.getLeftElement());
				}
			}
		}

		for (EObject eObj : new ArrayList<EObject>(stillToFindFromModel1)) {
			if (eObj instanceof Match2Elements) {
				final Match2Elements nextLeftNotFound = (Match2Elements)eObj;
				final UnmatchElement unMatch = MatchFactory.eINSTANCE.createUnmatchElement();
				unMatch.setElement(nextLeftNotFound.getLeftElement());
				remainingUnMatchedElements.remove(nextLeftNotFound.getLeftElement());
				remainingUnMatchedElements.remove(nextLeftNotFound.getRightElement());
				redirectedAdd(root, UNMATCH_ELEMENT_NAME, unMatch);
			}
		}
		for (EObject eObj : new ArrayList<EObject>(stillToFindFromModel2)) {
			if (eObj instanceof Match2Elements) {
				final Match2Elements nextRightNotFound = (Match2Elements)eObj;
				final UnmatchElement unMatch = MatchFactory.eINSTANCE.createUnmatchElement();
				unMatch.setRemote(true);
				unMatch.setElement(nextRightNotFound.getLeftElement());
				remainingUnMatchedElements.remove(nextRightNotFound.getLeftElement());
				remainingUnMatchedElements.remove(nextRightNotFound.getRightElement());
				redirectedAdd(root, UNMATCH_ELEMENT_NAME, unMatch);
			}
		}
	}
	

	/**
	 * We consider here <code>current1</code> and <code>current2</code> are similar. This method creates
	 * the mapping for the objects <code>current1</code> and <code>current2</code>, Then submappings for
	 * these two elements' contents.
	 * 
	 * @param current1
	 *            First element of the two elements mapping.
	 * @param current2
	 *            Second of the two elements mapping.
	 * @param monitor
	 *            {@link CompareProgressMonitor Progress monitor} to display while the comparison lasts. Might
	 *            be <code>null</code>, in which case we won't monitor progress.
	 * @return The mapping for <code>current1</code> and <code>current2</code> and their content.
	 * @throws FactoryException
	 *             Thrown when the metrics cannot be computed for <code>current1</code> and
	 *             <code>current2</code>.
	 * @throws InterruptedException
	 *             Thrown if the matching process is interrupted somehow.
	 */
	private Match2Elements recursiveMappings(EObject current1, EObject current2,
			Monitor monitor) throws FactoryException, InterruptedException {
		Match2Elements mapping = null;
		mapping = MatchFactory.eINSTANCE.createMatch2Elements();
		mapping.setLeftElement(current1);
		mapping.setRightElement(current2);
		mapping.setSimilarity(absoluteMetric(current1, current2));
		final List<Match2Elements> mapList = mapLists(getContents(current1), getContents(current2), this
				.<Integer> getOption(MatchOptions.OPTION_SEARCH_WINDOW), monitor);
		// We can map other elements with mapLists; we iterate through them.
		final Iterator<Match2Elements> it = mapList.iterator();
		while (it.hasNext()) {
			final Match2Elements subMapping = it.next();
			// As we know source and target are similars, we call recursive
			// mappings onto these objects
			EFactory.eAdd(mapping, SUBMATCH_ELEMENT_NAME, recursiveMappings(subMapping.getLeftElement(),
					subMapping.getRightElement(), monitor));
		}
		return mapping;
	}


	/**
	 * We consider here <code>current1</code> and <code>current2</code> are similar. This method creates
	 * the mapping for the objects <code>current1</code> and <code>current2</code>, Then submappings for
	 * these two elements' contents.
	 * 
	 * @param current1
	 *            First element of the two elements mapping.
	 * @param current2
	 *            Second of the two elements mapping.
	 * @param monitor
	 *            {@link CompareProgressMonitor Progress monitor} to display while the comparison lasts. Might
	 *            be <code>null</code>, in which case we won't monitor progress.
	 * @return The mapping for <code>current1</code> and <code>current2</code> and their content.
	 * @throws FactoryException
	 *             Thrown when the metrics cannot be computed for <code>current1</code> and
	 *             <code>current2</code>.
	 * @throws InterruptedException
	 *             Thrown if the matching process is interrupted somehow.
	 */
	private Match2Elements myRecursiveMappings(EObject current1, EObject current2, List<EObject> rightChildren,
			Monitor monitor) throws FactoryException, InterruptedException {
		Match2Elements mapping = null;
		mapping = MatchFactory.eINSTANCE.createMatch2Elements();
		mapping.setLeftElement(current1);
		mapping.setRightElement(current2);
		mapping.setSimilarity(absoluteMetric(current1, current2));
		final List<Match2Elements> mapList = myMapLists(getContents(current1), rightChildren, this
				.<Integer> getOption(MatchOptions.OPTION_SEARCH_WINDOW), monitor);
		// We can map other elements with mapLists; we iterate through them.
		final Iterator<Match2Elements> it = mapList.iterator();
		while (it.hasNext()) {
			final Match2Elements subMapping = it.next();
			// As we know source and target are similars, we call recursive
			// mappings onto these objects
			EFactory.eAdd(mapping, SUBMATCH_ELEMENT_NAME, myRecursiveMappings(subMapping.getLeftElement(),
					subMapping.getRightElement(), rightChildren, monitor));
		}
		return mapping;
	}

	private List<EObject> getContentsWithChildren(EObject eObject) {
		List<EObject> result = new ArrayList<EObject>();
		List<EObject> children = getContents(eObject);
		result.addAll(children);
		for (EObject child : children) {
			result.addAll(getContentsWithChildren(child));
		}
		return result;
	}

	/**
	 * This method is an indirection for adding Mappings in the current MappingGroup.
	 * 
	 * @param object
	 *            {@link EObject} to add a feature value to.
	 * @param name
	 *            Name of the feature to consider.
	 * @param value
	 *            Value to add to the feature <code>name</code> of <code>object</code>.
	 * @throws FactoryException
	 *             Thrown if the value's affectation fails.
	 */
	private void redirectedAdd(EObject object, String name, Object value) throws FactoryException {
		EFactory.eAdd(object, name, value);
	}

	/**
	 * This will compute the similarity between two {@link EObject}s' relations.
	 * 
	 * @param obj1
	 *            First of the two {@link EObject}s.
	 * @param obj2
	 *            Second of the two {@link EObject}s.
	 * @return <code>double</code> representing the similarity between the two {@link EObject}s' relations.
	 *         0 &lt; value &lt; 1.
	 * @throws FactoryException
	 *             Thrown if we cannot compute the relations' similarity metrics.
	 * @see StructureSimilarity#relationsSimilarityMetric(EObject, EObject, MetamodelFilter)
	 */
	private double relationsSimilarity(EObject obj1, EObject obj2) throws FactoryException {
		double similarity = 0d;
		final Double value = getSimilarityFromCache(obj1, obj2, RELATION_SIMILARITY);
		if (value != null) {
			similarity = value;
		} else {
			similarity = StructureSimilarity.relationsSimilarityMetric(obj1, obj2, filter);
			setSimilarityInCache(obj1, obj2, RELATION_SIMILARITY, similarity);
		}
		return similarity;
	}

	/**
	 * Sets the values of the {@link MatchModel}'s left and right models.
	 * 
	 * @param modelRoot
	 *            Root of the {@link MatchModel}.
	 * @param left
	 *            Element from which to resolve the left model URI.
	 * @param right
	 *            Element from which to resolve the right model URI.
	 */
	private void setModelRoots(MatchModel modelRoot, Resource left, Resource right) {
		setModelRoots(modelRoot, left, right, null);
	}

	/**
	 * Sets the values of the {@link MatchModel}'s left, right and ancestor models.
	 * 
	 * @param modelRoot
	 *            Root of the {@link MatchModel}.
	 * @param left
	 *            Element from which to resolve the left model URI.
	 * @param right
	 *            Element from which to resolve the right model URI.
	 * @param ancestor
	 *            Element from which to resolve the ancestor model URI. Can be <code>null</code>.
	 */
	private void setModelRoots(MatchModel modelRoot, Resource left, Resource right, Resource ancestor) {
		// Sets values of left, right and ancestor model URIs
		if (left != null) {
			modelRoot.getLeftRoots().addAll(left.getContents());
		}
		if (right != null) {
			modelRoot.getRightRoots().addAll(right.getContents());
		}
		if (ancestor != null) {
			modelRoot.getAncestorRoots().addAll(ancestor.getContents());
		}
	}

	/**
	 * Stores in cache the given similarity between the two given {@link EObject}s.<br/>
	 * <p>
	 * <code>similarityKind</code> must be one of
	 * <ul>
	 * <li>{@link #NAME_SIMILARITY}</li>
	 * <li>{@link #TYPE_SIMILARITY}</li>
	 * <li>{@link #VALUE_SIMILARITY}</li>
	 * <li>{@link #RELATION_SIMILARITY}</li>
	 * </ul>
	 * </p>
	 * 
	 * @param obj1
	 *            First of the two {@link EObject}s we're setting the similarity for.
	 * @param obj2
	 *            Second of the two {@link EObject}s we're setting the similarity for.
	 * @param similarityKind
	 *            Kind of similarity to set.
	 * @param similarity
	 *            Value of the similarity between the two {@link EObject}s.
	 */
	private void setSimilarityInCache(EObject obj1, EObject obj2, char similarityKind, double similarity) {
		metricsCache.put(pairHashCode(obj1, obj2, similarityKind), new Double(similarity));
	}

	/**
	 * Starts the monitor for comparison progress. Externalized here to avoid multiple usage of the Strings.
	 * 
	 * @param monitor
	 *            The monitor that need be started
	 * @param size
	 *            Size of the monitor
	 */
	private void startMonitor(Monitor monitor, int size) {
		monitor.beginTask("Comparing model", size); //$NON-NLS-1$
		monitor.subTask("Browsing model"); //$NON-NLS-1$
	}

	/**
	 * This will compute the similarity between two {@link EObject}s' types.
	 * 
	 * @param obj1
	 *            First of the two {@link EObject}s.
	 * @param obj2
	 *            Second of the two {@link EObject}s.
	 * @return <code>double</code> representing the similarity between the two {@link EObject}s' types. 0
	 *         &lt; value &lt; 1.
	 * @throws FactoryException
	 *             Thrown if we cannot compute the type similarity metrics.
	 * @see StructureSimilarity#typeSimilarityMetric(EObject, EObject)
	 */
	private double typeSimilarity(EObject obj1, EObject obj2) throws FactoryException {
		double similarity = 0d;
		final Double value = getSimilarityFromCache(obj1, obj2, TYPE_SIMILARITY);
		if (value != null) {
			similarity = value;
		} else {
			similarity = StructureSimilarity.typeSimilarityMetric(obj1, obj2);
			setSimilarityInCache(obj1, obj2, TYPE_SIMILARITY, similarity);
		}
		return similarity;
	}
	
	/**
	 * Creates the progress monitor that will be displayed to the user while the comparison lasts.
	 * 
	 * @return The progress monitor that will be displayed to the user while the comparison lasts.
	 */
	private Monitor createProgressMonitor() {
		Monitor monitor = new BasicMonitor();
		final Object delegateMonitor = getOption(MatchOptions.OPTION_PROGRESS_MONITOR);
		if (delegateMonitor != null && EMFPlugin.IS_ECLIPSE_RUNNING) {
			monitor = EclipseModelUtils.createProgressMonitor(delegateMonitor);
		}
		return monitor;
	}
}
