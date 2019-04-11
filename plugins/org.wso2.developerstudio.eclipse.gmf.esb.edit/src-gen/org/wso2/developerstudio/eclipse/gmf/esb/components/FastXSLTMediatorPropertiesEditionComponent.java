/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.components;

// Start of user code for imports
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.FastXSLTMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;

// End of user code

/**
 * 
 * 
 */
public class FastXSLTMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

    public static String BASE_PART = "Base"; //$NON-NLS-1$

    /**
     * Default constructor
     * 
     */
    public FastXSLTMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject fastXSLTMediator,
            String editing_mode) {
        super(editingContext, fastXSLTMediator, editing_mode);
        parts = new String[] { BASE_PART };
        repositoryKey = EsbViewsRepository.class;
        partKey = EsbViewsRepository.FastXSLTMediator.class;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int,
     *      org.eclipse.emf.ecore.EObject,
     *      org.eclipse.emf.ecore.resource.ResourceSet)
     * 
     */
    public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
        setInitializing(true);
        if (editingPart != null && key == partKey) {
            editingPart.setContext(elt, allResource);

            final FastXSLTMediator fastXSLTMediator = (FastXSLTMediator) elt;
            final FastXSLTMediatorPropertiesEditionPart basePart = (FastXSLTMediatorPropertiesEditionPart) editingPart;
            // init values
            if (isAccessible(EsbViewsRepository.FastXSLTMediator.Misc.description))
                basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
                        fastXSLTMediator.getDescription()));

            if (isAccessible(EsbViewsRepository.FastXSLTMediator.Properties.commentsList))
                basePart.setCommentsList(fastXSLTMediator.getCommentsList());

            if (isAccessible(EsbViewsRepository.FastXSLTMediator.Properties.reverse)) {
                basePart.setReverse(fastXSLTMediator.isReverse());
            }
            if (isAccessible(EsbViewsRepository.FastXSLTMediator.Misc.fastXsltSchemaKeyType)) {
                basePart.initFastXsltSchemaKeyType(
                        EEFUtils.choiceOfValues(fastXSLTMediator,
                                EsbPackage.eINSTANCE.getFastXSLTMediator_FastXsltSchemaKeyType()),
                        fastXSLTMediator.getFastXsltSchemaKeyType());
            }
            // Start of user code for fastXsltStaticSchemaKey command update
            if (isAccessible(EsbViewsRepository.FastXSLTMediator.Basic.fastXsltStaticSchemaKey)) {
                basePart.setFastXsltStaticSchemaKey(fastXSLTMediator.getFastXsltStaticSchemaKey());
            }
            // End of user code

            // Start of user code for fastXsltDynamicSchemaKey command update
            if (isAccessible(EsbViewsRepository.FastXSLTMediator.Basic.fastXsltStaticSchemaKey)) {
                basePart.setFastXsltDynamicSchemaKey(fastXSLTMediator.getFastXsltDynamicSchemaKey());
            }
            // End of user code

            // init filters

            // Start of user code for fastXsltStaticSchemaKey filter update
            // End of user code

            // Start of user code for fastXsltDynamicSchemaKey filter update
            // End of user code

            // init values for referenced views

            // init filters for referenced views

        }
        setInitializing(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
     */
    public EStructuralFeature associatedFeature(Object editorKey) {
        if (editorKey == EsbViewsRepository.FastXSLTMediator.Misc.description) {
            return EsbPackage.eINSTANCE.getEsbElement_Description();
        }
        if (editorKey == EsbViewsRepository.FastXSLTMediator.Properties.commentsList) {
            return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
        }
        if (editorKey == EsbViewsRepository.FastXSLTMediator.Properties.reverse) {
            return EsbPackage.eINSTANCE.getMediator_Reverse();
        }
        if (editorKey == EsbViewsRepository.FastXSLTMediator.Misc.fastXsltSchemaKeyType) {
            return EsbPackage.eINSTANCE.getFastXSLTMediator_FastXsltSchemaKeyType();
        }
        if (editorKey == EsbViewsRepository.FastXSLTMediator.Basic.fastXsltStaticSchemaKey) {
            return EsbPackage.eINSTANCE.getFastXSLTMediator_FastXsltStaticSchemaKey();
        }
        if (editorKey == EsbViewsRepository.FastXSLTMediator.Basic.fastXsltDynamicSchemaKey) {
            return EsbPackage.eINSTANCE.getFastXSLTMediator_FastXsltDynamicSchemaKey();
        }
        return super.associatedFeature(editorKey);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
     * 
     */
    public void updateSemanticModel(final IPropertiesEditionEvent event) {
        FastXSLTMediator fastXSLTMediator = (FastXSLTMediator) semanticObject;
        if (EsbViewsRepository.FastXSLTMediator.Misc.description == event.getAffectedEditor()) {
            fastXSLTMediator.setDescription((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.FastXSLTMediator.Properties.commentsList == event.getAffectedEditor()) {
            if (event.getKind() == PropertiesEditionEvent.SET) {
                fastXSLTMediator.getCommentsList().clear();
                fastXSLTMediator.getCommentsList().addAll(((EList) event.getNewValue()));
            }
        }
        if (EsbViewsRepository.FastXSLTMediator.Properties.reverse == event.getAffectedEditor()) {
            fastXSLTMediator.setReverse((Boolean) event.getNewValue());
        }
        if (EsbViewsRepository.FastXSLTMediator.Misc.fastXsltSchemaKeyType == event.getAffectedEditor()) {
            fastXSLTMediator.setFastXsltSchemaKeyType((KeyType) event.getNewValue());
        }
        if (EsbViewsRepository.FastXSLTMediator.Basic.fastXsltStaticSchemaKey == event.getAffectedEditor()) {
            // Start of user code for updateFastXsltStaticSchemaKey method body
            if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                fastXSLTMediator.setFastXsltStaticSchemaKey(rkp);
            } else {
                fastXSLTMediator.setFastXsltStaticSchemaKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
            // End of user code

        }
        if (EsbViewsRepository.FastXSLTMediator.Basic.fastXsltDynamicSchemaKey == event.getAffectedEditor()) {
            // Start of user code for updateFastXsltDynamicSchemaKey method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                fastXSLTMediator.setFastXsltDynamicSchemaKey(nsp);
            } else {
                fastXSLTMediator.setFastXsltDynamicSchemaKey(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
            // End of user code

        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
     */
    public void updatePart(Notification msg) {
        super.updatePart(msg);
        if (editingPart.isVisible()) {
            FastXSLTMediatorPropertiesEditionPart basePart = (FastXSLTMediatorPropertiesEditionPart) editingPart;
            if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.FastXSLTMediator.Misc.description)) {
                if (msg.getNewValue() != null) {
                    basePart.setDescription(
                            EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setDescription("");
                }
            }
            if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.FastXSLTMediator.Properties.commentsList)) {
                if (msg.getNewValue() instanceof EList<?>) {
                    basePart.setCommentsList((EList<?>) msg.getNewValue());
                } else if (msg.getNewValue() == null) {
                    basePart.setCommentsList(new BasicEList<Object>());
                } else {
                    BasicEList<Object> newValueAsList = new BasicEList<Object>();
                    newValueAsList.add(msg.getNewValue());
                    basePart.setCommentsList(newValueAsList);
                }
            }

            if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.FastXSLTMediator.Properties.reverse))
                basePart.setReverse((Boolean) msg.getNewValue());

            if (EsbPackage.eINSTANCE.getFastXSLTMediator_FastXsltSchemaKeyType().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.FastXSLTMediator.Misc.fastXsltSchemaKeyType))
                basePart.setFastXsltSchemaKeyType((KeyType) msg.getNewValue());

            // Start of user code for fastXsltStaticSchemaKey live update
            if (EsbPackage.eINSTANCE.getFastXSLTMediator_FastXsltStaticSchemaKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.FastXSLTMediator.Basic.fastXsltStaticSchemaKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setFastXsltStaticSchemaKey((RegistryKeyProperty)msg.getNewValue());
                } else {
                    basePart.setFastXsltStaticSchemaKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
                }
            }
            // End of user code

            // Start of user code for fastXsltDynamicSchemaKey live update
            if (EsbPackage.eINSTANCE.getFastXSLTMediator_FastXsltDynamicSchemaKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.FastXSLTMediator.Basic.fastXsltDynamicSchemaKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setFastXsltDynamicSchemaKey((NamespacedProperty)msg.getNewValue());
                } else {
                    basePart.setFastXsltDynamicSchemaKey(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
                }
            }
            // End of user code
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
     */
    @Override
    protected NotificationFilter[] getNotificationFilters() {
        NotificationFilter filter = new EStructuralFeatureNotificationFilter(
                EsbPackage.eINSTANCE.getEsbElement_Description(), EsbPackage.eINSTANCE.getEsbElement_CommentsList(),
                EsbPackage.eINSTANCE.getMediator_Reverse(),
                EsbPackage.eINSTANCE.getFastXSLTMediator_FastXsltSchemaKeyType(),
                EsbPackage.eINSTANCE.getFastXSLTMediator_FastXsltStaticSchemaKey(),
                EsbPackage.eINSTANCE.getFastXSLTMediator_FastXsltDynamicSchemaKey());
        return new NotificationFilter[] { filter, };
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object,
     *      int)
     * 
     */
    public String getHelpContent(Object key, int kind) {
        return EEFPropertyViewUtil.getHelpContent(key);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
     * 
     */
    public Diagnostic validateValue(IPropertiesEditionEvent event) {
        Diagnostic ret = Diagnostic.OK_INSTANCE;
        if (event.getNewValue() != null) {
            try {
                if (EsbViewsRepository.FastXSLTMediator.Misc.description == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE
                            .validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.FastXSLTMediator.Properties.commentsList == event.getAffectedEditor()) {
                    BasicDiagnostic chain = new BasicDiagnostic();
                    for (Iterator iterator = ((List) event.getNewValue()).iterator(); iterator.hasNext();) {
                        chain.add(Diagnostician.INSTANCE.validate(
                                EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(),
                                iterator.next()));
                    }
                    ret = chain;
                }
                if (EsbViewsRepository.FastXSLTMediator.Properties.reverse == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE
                            .validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.FastXSLTMediator.Misc.fastXsltSchemaKeyType == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getFastXSLTMediator_FastXsltSchemaKeyType().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getFastXSLTMediator_FastXsltSchemaKeyType().getEAttributeType(),
                            newValue);
                }
            } catch (IllegalArgumentException iae) {
                ret = BasicDiagnostic.toDiagnostic(iae);
            } catch (WrappedException we) {
                ret = BasicDiagnostic.toDiagnostic(we);
            }
        }
        return ret;
    }

}
