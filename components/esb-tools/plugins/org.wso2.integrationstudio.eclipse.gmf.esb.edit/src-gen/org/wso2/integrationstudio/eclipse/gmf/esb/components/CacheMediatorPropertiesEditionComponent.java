/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.components;

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
import org.wso2.integrationstudio.eclipse.gmf.esb.CacheImplementationType;
import org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediatorType;
import org.wso2.integrationstudio.eclipse.gmf.esb.CacheProtocolType;
import org.wso2.integrationstudio.eclipse.gmf.esb.CacheScopeType;
import org.wso2.integrationstudio.eclipse.gmf.esb.CacheSequenceType;
import org.wso2.integrationstudio.eclipse.gmf.esb.CacheType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;

// End of user code

/**
 * 
 * 
 */
public class CacheMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

    public static String BASE_PART = "Base"; //$NON-NLS-1$

    /**
     * Default constructor
     * 
     */
    public CacheMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject cacheMediator,
            String editing_mode) {
        super(editingContext, cacheMediator, editing_mode);
        parts = new String[] { BASE_PART };
        repositoryKey = EsbViewsRepository.class;
        partKey = EsbViewsRepository.CacheMediator.class;
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

            final CacheMediator cacheMediator = (CacheMediator) elt;
            final CacheMediatorPropertiesEditionPart basePart = (CacheMediatorPropertiesEditionPart) editingPart;
            // init values
            if (isAccessible(EsbViewsRepository.CacheMediator.Misc.description))
                basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
                        cacheMediator.getDescription()));

            if (isAccessible(EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType)) {
                basePart.initCacheProtocolType(
                        EEFUtils.choiceOfValues(cacheMediator,
                                EsbPackage.eINSTANCE.getCacheMediator_CacheProtocolType()),
                        cacheMediator.getCacheProtocolType());
            }
            if (isAccessible(EsbViewsRepository.CacheMediator.Properties.cacheType)) {
                basePart.initCacheType(
                        EEFUtils.choiceOfValues(cacheMediator, EsbPackage.eINSTANCE.getCacheMediator_CacheType()),
                        cacheMediator.getCacheType());
            }
            if (isAccessible(EsbViewsRepository.CacheMediator.Protocol.hashGenerator))
                basePart.setHashGenerator(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
                        cacheMediator.getHashGenerator()));

            if (isAccessible(EsbViewsRepository.CacheMediator.Properties.cacheTimeout)) {
                basePart.setCacheTimeout(
                        EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, cacheMediator.getCacheTimeout()));
            }

            if (isAccessible(EsbViewsRepository.CacheMediator.Properties.maxMessageSize)) {
                basePart.setMaxMessageSize(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT,
                        cacheMediator.getMaxMessageSize()));
            }

            if (isAccessible(EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods))
                basePart.setCacheProtocolMethods(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
                        cacheMediator.getCacheProtocolMethods()));

            if (isAccessible(EsbViewsRepository.CacheMediator.Implementation.maxEntryCount)) {
                basePart.setMaxEntryCount(
                        EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, cacheMediator.getMaxEntryCount()));
            }

            if (isAccessible(EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType)) {
                basePart.initSequenceType(
                        EEFUtils.choiceOfValues(cacheMediator, EsbPackage.eINSTANCE.getCacheMediator_SequenceType()),
                        cacheMediator.getSequenceType());
            }
            if (isAccessible(EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash))
                basePart.setHeadersToExcludeInHash(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
                        cacheMediator.getHeadersToExcludeInHash()));

            if (isAccessible(EsbViewsRepository.CacheMediator.Protocol.responseCodes))
                basePart.setResponseCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
                        cacheMediator.getResponseCodes()));

            if (isAccessible(EsbViewsRepository.CacheMediator.Protocol.enableCacheControl)) {
                basePart.setEnableCacheControl(cacheMediator.isEnableCacheControl());
            }
            if (isAccessible(EsbViewsRepository.CacheMediator.Protocol.includeAgeHeader)) {
                basePart.setIncludeAgeHeader(cacheMediator.isIncludeAgeHeader());
            }
            // Start of user code for sequenceKey command update
            if (isAccessible(EsbViewsRepository.CacheMediator.OnCacheHit.sequenceKey)) {
                basePart.setSequenceKey(cacheMediator.getSequenceKey());
            }
            // End of user code

            if (isAccessible(EsbViewsRepository.CacheMediator.Properties.commentsList))
                basePart.setCommentsList(cacheMediator.getCommentsList());

            if (isAccessible(EsbViewsRepository.CacheMediator.Properties.reverse)) {
                basePart.setReverse(cacheMediator.isReverse());
            }
            
            if (isAccessible(EsbViewsRepository.CacheMediator.Type.cacheMediatorImplementation)) {
                basePart.initCacheMediatorImplementation(
                        EEFUtils.choiceOfValues(cacheMediator, EsbPackage.eINSTANCE.getCacheMediator_CacheMediatorImplementation()),
                        cacheMediator.getCacheMediatorImplementation());
            }
            
            if (isAccessible(EsbViewsRepository.CacheMediator.Properties.id)) {
                basePart.setId(cacheMediator.getId());
            }
            
            if (isAccessible(EsbViewsRepository.CacheMediator.Properties.scope)) {
                basePart.initScope(
                        EEFUtils.choiceOfValues(cacheMediator, EsbPackage.eINSTANCE.getCacheMediator_Scope()),
                        cacheMediator.getScope());
            }
            
            if (isAccessible(EsbViewsRepository.CacheMediator.Properties.hashGeneratorAttribute)) {
                basePart.setHashGeneratorAttribute(cacheMediator.getHashGeneratorAttribute());
            }
            
            if (isAccessible(EsbViewsRepository.CacheMediator.Implementation.implementationType)) {
                basePart.initImplementationType(
                        EEFUtils.choiceOfValues(cacheMediator, EsbPackage.eINSTANCE.getCacheMediator_ImplementationType()),
                        cacheMediator.getImplementationType());
            }
            // init filters

            // Start of user code for sequenceKey filter update
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
        if (editorKey == EsbViewsRepository.CacheMediator.Misc.description) {
            return EsbPackage.eINSTANCE.getEsbElement_Description();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType) {
            return EsbPackage.eINSTANCE.getCacheMediator_CacheProtocolType();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Properties.cacheType) {
            return EsbPackage.eINSTANCE.getCacheMediator_CacheType();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Protocol.hashGenerator) {
            return EsbPackage.eINSTANCE.getCacheMediator_HashGenerator();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Properties.cacheTimeout) {
            return EsbPackage.eINSTANCE.getCacheMediator_CacheTimeout();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Properties.maxMessageSize) {
            return EsbPackage.eINSTANCE.getCacheMediator_MaxMessageSize();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods) {
            return EsbPackage.eINSTANCE.getCacheMediator_CacheProtocolMethods();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Implementation.maxEntryCount) {
            return EsbPackage.eINSTANCE.getCacheMediator_MaxEntryCount();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType) {
            return EsbPackage.eINSTANCE.getCacheMediator_SequenceType();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash) {
            return EsbPackage.eINSTANCE.getCacheMediator_HeadersToExcludeInHash();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Protocol.responseCodes) {
            return EsbPackage.eINSTANCE.getCacheMediator_ResponseCodes();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Protocol.enableCacheControl) {
            return EsbPackage.eINSTANCE.getCacheMediator_EnableCacheControl();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Protocol.includeAgeHeader) {
            return EsbPackage.eINSTANCE.getCacheMediator_IncludeAgeHeader();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.OnCacheHit.sequenceKey) {
            return EsbPackage.eINSTANCE.getCacheMediator_SequenceKey();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Properties.commentsList) {
            return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Properties.reverse) {
            return EsbPackage.eINSTANCE.getMediator_Reverse();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Type.cacheMediatorImplementation) {
            return EsbPackage.eINSTANCE.getCacheMediator_CacheMediatorImplementation();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Properties.id) {
            return EsbPackage.eINSTANCE.getCacheMediator_Id();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Properties.scope) {
            return EsbPackage.eINSTANCE.getCacheMediator_Scope();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Properties.hashGeneratorAttribute) {
            return EsbPackage.eINSTANCE.getCacheMediator_HashGeneratorAttribute();
        }
        if (editorKey == EsbViewsRepository.CacheMediator.Implementation.implementationType) {
            return EsbPackage.eINSTANCE.getCacheMediator_ImplementationType();
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
        CacheMediator cacheMediator = (CacheMediator) semanticObject;
        if (EsbViewsRepository.CacheMediator.Misc.description == event.getAffectedEditor()) {
            cacheMediator.setDescription((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType == event.getAffectedEditor()) {
            cacheMediator.setCacheProtocolType((CacheProtocolType) event.getNewValue());
        }
        if (EsbViewsRepository.CacheMediator.Properties.cacheType == event.getAffectedEditor()) {
            cacheMediator.setCacheType((CacheType) event.getNewValue());
        }
        if (EsbViewsRepository.CacheMediator.Protocol.hashGenerator == event.getAffectedEditor()) {
            cacheMediator.setHashGenerator((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.CacheMediator.Properties.cacheTimeout == event.getAffectedEditor()) {
            cacheMediator.setCacheTimeout(
                    (EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String) event.getNewValue())));
        }
        if (EsbViewsRepository.CacheMediator.Properties.maxMessageSize == event.getAffectedEditor()) {
            cacheMediator.setMaxMessageSize(
                    (EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String) event.getNewValue())));
        }
        if (EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods == event.getAffectedEditor()) {
            cacheMediator.setCacheProtocolMethods((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.CacheMediator.Implementation.maxEntryCount == event.getAffectedEditor()) {
            cacheMediator.setMaxEntryCount(
                    (EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String) event.getNewValue())));
        }
        if (EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType == event.getAffectedEditor()) {
            cacheMediator.setSequenceType((CacheSequenceType) event.getNewValue());
        }
        if (EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash == event.getAffectedEditor()) {
            cacheMediator.setHeadersToExcludeInHash((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.CacheMediator.Protocol.responseCodes == event.getAffectedEditor()) {
            cacheMediator.setResponseCodes((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.CacheMediator.Protocol.enableCacheControl == event.getAffectedEditor()) {
            cacheMediator.setEnableCacheControl((Boolean) event.getNewValue());
        }
        if (EsbViewsRepository.CacheMediator.Protocol.includeAgeHeader == event.getAffectedEditor()) {
            cacheMediator.setIncludeAgeHeader((Boolean) event.getNewValue());
        }
        if (EsbViewsRepository.CacheMediator.OnCacheHit.sequenceKey == event.getAffectedEditor()) {
            // Start of user code for updateSequenceKey method body
            if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                cacheMediator.setSequenceKey(rkp);
            } else {
                cacheMediator.setSequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
            // End of user code

        }
        if (EsbViewsRepository.CacheMediator.Properties.commentsList == event.getAffectedEditor()) {
            if (event.getKind() == PropertiesEditionEvent.SET) {
                cacheMediator.getCommentsList().clear();
                cacheMediator.getCommentsList().addAll(((EList) event.getNewValue()));
            }
        }
        if (EsbViewsRepository.CacheMediator.Properties.reverse == event.getAffectedEditor()) {
            cacheMediator.setReverse((Boolean) event.getNewValue());
        }
        if (EsbViewsRepository.CacheMediator.Type.cacheMediatorImplementation == event.getAffectedEditor()) {
            cacheMediator.setCacheMediatorImplementation((CacheMediatorType)event.getNewValue());
        }
        if (EsbViewsRepository.CacheMediator.Properties.id == event.getAffectedEditor()) {
            cacheMediator.setId((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.CacheMediator.Properties.scope == event.getAffectedEditor()) {
            cacheMediator.setScope((CacheScopeType)event.getNewValue());
        }
        if (EsbViewsRepository.CacheMediator.Properties.hashGeneratorAttribute == event.getAffectedEditor()) {
            cacheMediator.setHashGeneratorAttribute((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.CacheMediator.Implementation.implementationType == event.getAffectedEditor()) {
            cacheMediator.setImplementationType((CacheImplementationType)event.getNewValue());
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
            CacheMediatorPropertiesEditionPart basePart = (CacheMediatorPropertiesEditionPart) editingPart;
            if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CacheMediator.Misc.description)) {
                if (msg.getNewValue() != null) {
                    basePart.setDescription(
                            EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setDescription("");
                }
            }
            if (EsbPackage.eINSTANCE.getCacheMediator_CacheProtocolType().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType))
                basePart.setCacheProtocolType((CacheProtocolType) msg.getNewValue());

            if (EsbPackage.eINSTANCE.getCacheMediator_CacheType().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.CacheMediator.Properties.cacheType))
                basePart.setCacheType((CacheType) msg.getNewValue());

            if (EsbPackage.eINSTANCE.getCacheMediator_HashGenerator().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CacheMediator.Protocol.hashGenerator)) {
                if (msg.getNewValue() != null) {
                    basePart.setHashGenerator(
                            EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setHashGenerator("");
                }
            }
            if (EsbPackage.eINSTANCE.getCacheMediator_CacheTimeout().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CacheMediator.Properties.cacheTimeout)) {
                if (msg.getNewValue() != null) {
                    basePart.setCacheTimeout(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
                } else {
                    basePart.setCacheTimeout("");
                }
            }
            if (EsbPackage.eINSTANCE.getCacheMediator_MaxMessageSize().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CacheMediator.Properties.maxMessageSize)) {
                if (msg.getNewValue() != null) {
                    basePart.setMaxMessageSize(
                            EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
                } else {
                    basePart.setMaxMessageSize("");
                }
            }
            if (EsbPackage.eINSTANCE.getCacheMediator_CacheProtocolMethods().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods)) {
                if (msg.getNewValue() != null) {
                    basePart.setCacheProtocolMethods(
                            EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setCacheProtocolMethods("");
                }
            }
            if (EsbPackage.eINSTANCE.getCacheMediator_MaxEntryCount().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CacheMediator.Implementation.maxEntryCount)) {
                if (msg.getNewValue() != null) {
                    basePart.setMaxEntryCount(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
                } else {
                    basePart.setMaxEntryCount("");
                }
            }
            if (EsbPackage.eINSTANCE.getCacheMediator_SequenceType().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType))
                basePart.setSequenceType((CacheSequenceType) msg.getNewValue());

            if (EsbPackage.eINSTANCE.getCacheMediator_HeadersToExcludeInHash().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash)) {
                if (msg.getNewValue() != null) {
                    basePart.setHeadersToExcludeInHash(
                            EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setHeadersToExcludeInHash("");
                }
            }
            if (EsbPackage.eINSTANCE.getCacheMediator_ResponseCodes().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CacheMediator.Protocol.responseCodes)) {
                if (msg.getNewValue() != null) {
                    basePart.setResponseCodes(
                            EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setResponseCodes("");
                }
            }
            if (EsbPackage.eINSTANCE.getCacheMediator_EnableCacheControl().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CacheMediator.Protocol.enableCacheControl))
                basePart.setEnableCacheControl((Boolean) msg.getNewValue());

            if (EsbPackage.eINSTANCE.getCacheMediator_IncludeAgeHeader().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CacheMediator.Protocol.includeAgeHeader))
                basePart.setIncludeAgeHeader((Boolean) msg.getNewValue());

            // Start of user code for sequenceKey live update
            if (EsbPackage.eINSTANCE.getCacheMediator_SequenceKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.CacheMediator.OnCacheHit.sequenceKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setSequenceKey((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setSequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
                }
            }
            // End of user code

            if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CacheMediator.Properties.commentsList)) {
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
                    && isAccessible(EsbViewsRepository.CacheMediator.Properties.reverse))
                basePart.setReverse((Boolean) msg.getNewValue());

            if (EsbPackage.eINSTANCE.getCacheMediator_CacheMediatorImplementation().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CacheMediator.Type.cacheMediatorImplementation)) {
                if (msg.getNewValue() instanceof CacheImplementationType) {
                    basePart.setCacheMediatorImplementation((CacheImplementationType)msg.getNewValue());
                }
            }
            
            if (EsbPackage.eINSTANCE.getCacheMediator_Id().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CacheMediator.Properties.id)) {
                if (msg.getNewValue() != null) {
                    basePart.setId(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setId("");
                }
            }
            
            if (EsbPackage.eINSTANCE.getCacheMediator_Scope().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CacheMediator.Properties.scope)) {
                basePart.setScope((CacheScopeType)msg.getNewValue());
            }
            
            if (EsbPackage.eINSTANCE.getCacheMediator_HashGeneratorAttribute().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CacheMediator.Properties.hashGeneratorAttribute)) {
                if (msg.getNewValue() != null) {
                    basePart.setHashGeneratorAttribute(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setHashGeneratorAttribute("");
                }
            }
            
            if (EsbPackage.eINSTANCE.getCacheMediator_ImplementationType().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CacheMediator.Implementation.implementationType)) {
                basePart.setImplementationType((CacheImplementationType)msg.getNewValue());
            }
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
                EsbPackage.eINSTANCE.getEsbElement_Description(),
                EsbPackage.eINSTANCE.getCacheMediator_CacheProtocolType(),
                EsbPackage.eINSTANCE.getCacheMediator_CacheType(),
                EsbPackage.eINSTANCE.getCacheMediator_HashGenerator(),
                EsbPackage.eINSTANCE.getCacheMediator_CacheTimeout(),
                EsbPackage.eINSTANCE.getCacheMediator_MaxMessageSize(),
                EsbPackage.eINSTANCE.getCacheMediator_CacheProtocolMethods(),
                EsbPackage.eINSTANCE.getCacheMediator_MaxEntryCount(),
                EsbPackage.eINSTANCE.getCacheMediator_SequenceType(),
                EsbPackage.eINSTANCE.getCacheMediator_HeadersToExcludeInHash(),
                EsbPackage.eINSTANCE.getCacheMediator_ResponseCodes(),
                EsbPackage.eINSTANCE.getCacheMediator_EnableCacheControl(),
                EsbPackage.eINSTANCE.getCacheMediator_IncludeAgeHeader(),
                EsbPackage.eINSTANCE.getCacheMediator_SequenceKey(),
                EsbPackage.eINSTANCE.getEsbElement_CommentsList(),
                EsbPackage.eINSTANCE.getCacheMediator_CacheMediatorImplementation(),
                EsbPackage.eINSTANCE.getCacheMediator_Id(),
                EsbPackage.eINSTANCE.getCacheMediator_Scope(),
                EsbPackage.eINSTANCE.getCacheMediator_HashGeneratorAttribute(),
                EsbPackage.eINSTANCE.getCacheMediator_ImplementationType(),
                EsbPackage.eINSTANCE.getMediator_Reverse());
        return new NotificationFilter[] { filter, };
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
                if (EsbViewsRepository.CacheMediator.Misc.description == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE
                            .validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getCacheMediator_CacheProtocolType().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getCacheMediator_CacheProtocolType().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.CacheMediator.Properties.cacheType == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getCacheMediator_CacheType().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE
                            .validate(EsbPackage.eINSTANCE.getCacheMediator_CacheType().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.CacheMediator.Protocol.hashGenerator == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getCacheMediator_HashGenerator().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getCacheMediator_HashGenerator().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.CacheMediator.Properties.cacheTimeout == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getCacheMediator_CacheTimeout().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getCacheMediator_CacheTimeout().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.CacheMediator.Properties.maxMessageSize == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getCacheMediator_MaxMessageSize().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getCacheMediator_MaxMessageSize().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getCacheMediator_CacheProtocolMethods().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getCacheMediator_CacheProtocolMethods().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.CacheMediator.Implementation.maxEntryCount == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getCacheMediator_MaxEntryCount().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getCacheMediator_MaxEntryCount().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getCacheMediator_SequenceType().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getCacheMediator_SequenceType().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getCacheMediator_HeadersToExcludeInHash().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getCacheMediator_HeadersToExcludeInHash().getEAttributeType(),
                            newValue);
                }
                if (EsbViewsRepository.CacheMediator.Protocol.responseCodes == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getCacheMediator_ResponseCodes().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getCacheMediator_ResponseCodes().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.CacheMediator.Protocol.enableCacheControl == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getCacheMediator_EnableCacheControl().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getCacheMediator_EnableCacheControl().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.CacheMediator.Protocol.includeAgeHeader == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getCacheMediator_IncludeAgeHeader().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getCacheMediator_IncludeAgeHeader().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.CacheMediator.Properties.commentsList == event.getAffectedEditor()) {
                    BasicDiagnostic chain = new BasicDiagnostic();
                    for (Iterator iterator = ((List) event.getNewValue()).iterator(); iterator.hasNext();) {
                        chain.add(Diagnostician.INSTANCE.validate(
                                EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(),
                                iterator.next()));
                    }
                    ret = chain;
                }
                if (EsbViewsRepository.CacheMediator.Properties.reverse == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE
                            .validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
                }
            } catch (IllegalArgumentException iae) {
                ret = BasicDiagnostic.toDiagnostic(iae);
            } catch (WrappedException we) {
                ret = BasicDiagnostic.toDiagnostic(we);
            }
        }
        return ret;
    }
    
    // Start of user code for help compatibility

    /**
     * @generated NOT
     */
    @Override
    public String getHelpContent(Object key, int kind) {
        return EEFPropertyViewUtil.getHelpContent(key);
    }

    // End of user code

}
