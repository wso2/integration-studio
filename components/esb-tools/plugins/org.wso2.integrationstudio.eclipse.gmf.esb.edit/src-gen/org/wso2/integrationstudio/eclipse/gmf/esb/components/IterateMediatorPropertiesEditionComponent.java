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

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.IterateMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.SequenceType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;

// End of user code

/**
 * 
 * 
 */
public class IterateMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

    public static String BASE_PART = "Base"; //$NON-NLS-1$

    /**
     * Default constructor
     * 
     */
    public IterateMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject iterateMediator,
            String editing_mode) {
        super(editingContext, iterateMediator, editing_mode);
        parts = new String[] { BASE_PART };
        repositoryKey = EsbViewsRepository.class;
        partKey = EsbViewsRepository.IterateMediator.class;
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

            final IterateMediator iterateMediator = (IterateMediator) elt;
            final IterateMediatorPropertiesEditionPart basePart = (IterateMediatorPropertiesEditionPart) editingPart;
            // init values
            if (isAccessible(EsbViewsRepository.IterateMediator.Properties.description))
                basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
                        iterateMediator.getDescription()));

            if (isAccessible(EsbViewsRepository.IterateMediator.Properties.commentsList))
                basePart.setCommentsList(iterateMediator.getCommentsList());

            if (isAccessible(EsbViewsRepository.IterateMediator.Properties.reverse)) {
                basePart.setReverse(iterateMediator.isReverse());
            }
            if (isAccessible(EsbViewsRepository.IterateMediator.Properties.iterateID))
                basePart.setIterateID(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
                        iterateMediator.getIterateID()));

            if (isAccessible(EsbViewsRepository.IterateMediator.Properties.sequentialMediation)) {
                basePart.setSequentialMediation(iterateMediator.isSequentialMediation());
            }
            if (isAccessible(EsbViewsRepository.IterateMediator.Properties.continueParent)) {
                basePart.setContinueParent(iterateMediator.isContinueParent());
            }
            if (isAccessible(EsbViewsRepository.IterateMediator.Properties.preservePayload)) {
                basePart.setPreservePayload(iterateMediator.isPreservePayload());
            }
            if (isAccessible(EsbViewsRepository.IterateMediator.Properties.sequenceType)) {
                basePart.initSequenceType(
                        EEFUtils.choiceOfValues(iterateMediator,
                                EsbPackage.eINSTANCE.getIterateMediator_SequenceType()),
                        iterateMediator.getSequenceType());
            }
            if (isAccessible(EsbViewsRepository.IterateMediator.Properties.sequenceName))
                basePart.setSequenceName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
                        iterateMediator.getSequenceName()));

            // Start of user code for iterateExpression command update
            if (isAccessible(EsbViewsRepository.IterateMediator.Properties.iterateExpression)) {
                basePart.setIterateExpression(iterateMediator.getIterateExpression());
            }
            // End of user code

            // Start of user code for attachPath command update
            if (isAccessible(EsbViewsRepository.IterateMediator.Properties.attachPath)) {
                basePart.setAttachPath(iterateMediator.getAttachPath());
            }
            // End of user code

            // Start of user code for sequenceKey command update
            if (isAccessible(EsbViewsRepository.IterateMediator.Properties.sequenceKey)) {
                basePart.setSequenceKey(iterateMediator.getSequenceKey());
            }
            // End of user code

            // init filters

            // Start of user code for iterateExpression filter update
            // End of user code

            // Start of user code for attachPath filter update
            // End of user code

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
        if (editorKey == EsbViewsRepository.IterateMediator.Properties.description) {
            return EsbPackage.eINSTANCE.getEsbElement_Description();
        }
        if (editorKey == EsbViewsRepository.IterateMediator.Properties.commentsList) {
            return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
        }
        if (editorKey == EsbViewsRepository.IterateMediator.Properties.reverse) {
            return EsbPackage.eINSTANCE.getMediator_Reverse();
        }
        if (editorKey == EsbViewsRepository.IterateMediator.Properties.iterateID) {
            return EsbPackage.eINSTANCE.getIterateMediator_IterateID();
        }
        if (editorKey == EsbViewsRepository.IterateMediator.Properties.sequentialMediation) {
            return EsbPackage.eINSTANCE.getIterateMediator_SequentialMediation();
        }
        if (editorKey == EsbViewsRepository.IterateMediator.Properties.continueParent) {
            return EsbPackage.eINSTANCE.getIterateMediator_ContinueParent();
        }
        if (editorKey == EsbViewsRepository.IterateMediator.Properties.preservePayload) {
            return EsbPackage.eINSTANCE.getIterateMediator_PreservePayload();
        }
        if (editorKey == EsbViewsRepository.IterateMediator.Properties.sequenceType) {
            return EsbPackage.eINSTANCE.getIterateMediator_SequenceType();
        }
        if (editorKey == EsbViewsRepository.IterateMediator.Properties.sequenceName) {
            return EsbPackage.eINSTANCE.getIterateMediator_SequenceName();
        }
        if (editorKey == EsbViewsRepository.IterateMediator.Properties.iterateExpression) {
            return EsbPackage.eINSTANCE.getIterateMediator_IterateExpression();
        }
        if (editorKey == EsbViewsRepository.IterateMediator.Properties.attachPath) {
            return EsbPackage.eINSTANCE.getIterateMediator_AttachPath();
        }
        if (editorKey == EsbViewsRepository.IterateMediator.Properties.sequenceKey) {
            return EsbPackage.eINSTANCE.getIterateMediator_SequenceKey();
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
        IterateMediator iterateMediator = (IterateMediator) semanticObject;
        if (EsbViewsRepository.IterateMediator.Properties.description == event.getAffectedEditor()) {
            iterateMediator.setDescription((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.IterateMediator.Properties.commentsList == event.getAffectedEditor()) {
            if (event.getKind() == PropertiesEditionEvent.SET) {
                iterateMediator.getCommentsList().clear();
                iterateMediator.getCommentsList().addAll(((EList) event.getNewValue()));
            }
        }
        if (EsbViewsRepository.IterateMediator.Properties.reverse == event.getAffectedEditor()) {
            iterateMediator.setReverse((Boolean) event.getNewValue());
        }
        if (EsbViewsRepository.IterateMediator.Properties.iterateID == event.getAffectedEditor()) {
            iterateMediator.setIterateID((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.IterateMediator.Properties.sequentialMediation == event.getAffectedEditor()) {
            iterateMediator.setSequentialMediation((Boolean) event.getNewValue());
        }
        if (EsbViewsRepository.IterateMediator.Properties.continueParent == event.getAffectedEditor()) {
            iterateMediator.setContinueParent((Boolean) event.getNewValue());
        }
        if (EsbViewsRepository.IterateMediator.Properties.preservePayload == event.getAffectedEditor()) {
            iterateMediator.setPreservePayload((Boolean) event.getNewValue());
        }
        if (EsbViewsRepository.IterateMediator.Properties.sequenceType == event.getAffectedEditor()) {
            iterateMediator.setSequenceType((SequenceType) event.getNewValue());
        }
        if (EsbViewsRepository.IterateMediator.Properties.sequenceName == event.getAffectedEditor()) {
            iterateMediator.setSequenceName((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.IterateMediator.Properties.iterateExpression == event.getAffectedEditor()) {
            // Start of user code for updateIterateExpression method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                iterateMediator.setIterateExpression(nsp);
            } else {
                iterateMediator.setIterateExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
            // End of user code

        }
        if (EsbViewsRepository.IterateMediator.Properties.attachPath == event.getAffectedEditor()) {
            // Start of user code for updateAttachPath method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                iterateMediator.setAttachPath(nsp);
            } else {
                iterateMediator.setAttachPath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
            // End of user code

        }
        if (EsbViewsRepository.IterateMediator.Properties.sequenceKey == event.getAffectedEditor()) {
            // Start of user code for updateSequenceKey method body
            if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                iterateMediator.setSequenceKey(rkp);
            } else {
                iterateMediator.setSequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
            IterateMediatorPropertiesEditionPart basePart = (IterateMediatorPropertiesEditionPart) editingPart;
            if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.IterateMediator.Properties.description)) {
                if (msg.getNewValue() != null) {
                    basePart.setDescription(
                            EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setDescription("");
                }
            }
            if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.IterateMediator.Properties.commentsList)) {
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
                    && isAccessible(EsbViewsRepository.IterateMediator.Properties.reverse))
                basePart.setReverse((Boolean) msg.getNewValue());

            if (EsbPackage.eINSTANCE.getIterateMediator_IterateID().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.IterateMediator.Properties.iterateID)) {
                if (msg.getNewValue() != null) {
                    basePart.setIterateID(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setIterateID("");
                }
            }
            if (EsbPackage.eINSTANCE.getIterateMediator_SequentialMediation().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.IterateMediator.Properties.sequentialMediation))
                basePart.setSequentialMediation((Boolean) msg.getNewValue());

            if (EsbPackage.eINSTANCE.getIterateMediator_ContinueParent().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.IterateMediator.Properties.continueParent))
                basePart.setContinueParent((Boolean) msg.getNewValue());

            if (EsbPackage.eINSTANCE.getIterateMediator_PreservePayload().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.IterateMediator.Properties.preservePayload))
                basePart.setPreservePayload((Boolean) msg.getNewValue());

            if (EsbPackage.eINSTANCE.getIterateMediator_SequenceType().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.IterateMediator.Properties.sequenceType))
                basePart.setSequenceType((SequenceType) msg.getNewValue());

            if (EsbPackage.eINSTANCE.getIterateMediator_SequenceName().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.IterateMediator.Properties.sequenceName)) {
                if (msg.getNewValue() != null) {
                    basePart.setSequenceName(
                            EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setSequenceName("");
                }
            }
            // Start of user code for iterateExpression live update
            if (EsbPackage.eINSTANCE.getIterateMediator_IterateExpression().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.IterateMediator.Properties.iterateExpression)) {
                if (msg.getNewValue() != null) {
                    basePart.setIterateExpression((NamespacedProperty) msg.getNewValue());
                } else {
                    basePart.setIterateExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
                }
            }
            // End of user code

            // Start of user code for attachPath live update
            if (EsbPackage.eINSTANCE.getIterateMediator_AttachPath().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.IterateMediator.Properties.attachPath)) {
                if (msg.getNewValue() != null) {
                    basePart.setAttachPath((NamespacedProperty) msg.getNewValue());
                } else {
                    basePart.setAttachPath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
                }
            }
            // End of user code

            // Start of user code for sequenceKey live update
            if (EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.IterateMediator.Properties.sequenceKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setSequenceKey((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setSequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
                EsbPackage.eINSTANCE.getMediator_Reverse(), EsbPackage.eINSTANCE.getIterateMediator_IterateID(),
                EsbPackage.eINSTANCE.getIterateMediator_SequentialMediation(),
                EsbPackage.eINSTANCE.getIterateMediator_ContinueParent(),
                EsbPackage.eINSTANCE.getIterateMediator_PreservePayload(),
                EsbPackage.eINSTANCE.getIterateMediator_SequenceType(),
                EsbPackage.eINSTANCE.getIterateMediator_SequenceName(),
                EsbPackage.eINSTANCE.getIterateMediator_IterateExpression(),
                EsbPackage.eINSTANCE.getIterateMediator_AttachPath(),
                EsbPackage.eINSTANCE.getIterateMediator_SequenceKey());
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
                if (EsbViewsRepository.IterateMediator.Properties.description == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE
                            .validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.IterateMediator.Properties.commentsList == event.getAffectedEditor()) {
                    BasicDiagnostic chain = new BasicDiagnostic();
                    for (Iterator iterator = ((List) event.getNewValue()).iterator(); iterator.hasNext();) {
                        chain.add(Diagnostician.INSTANCE.validate(
                                EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(),
                                iterator.next()));
                    }
                    ret = chain;
                }
                if (EsbViewsRepository.IterateMediator.Properties.reverse == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE
                            .validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.IterateMediator.Properties.iterateID == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getIterateMediator_IterateID().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getIterateMediator_IterateID().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.IterateMediator.Properties.sequentialMediation == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getIterateMediator_SequentialMediation().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getIterateMediator_SequentialMediation().getEAttributeType(),
                            newValue);
                }
                if (EsbViewsRepository.IterateMediator.Properties.continueParent == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getIterateMediator_ContinueParent().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getIterateMediator_ContinueParent().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.IterateMediator.Properties.preservePayload == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getIterateMediator_PreservePayload().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getIterateMediator_PreservePayload().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.IterateMediator.Properties.sequenceType == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getIterateMediator_SequenceType().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getIterateMediator_SequenceType().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.IterateMediator.Properties.sequenceName == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getIterateMediator_SequenceName().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getIterateMediator_SequenceName().getEAttributeType(), newValue);
                }
            } catch (IllegalArgumentException iae) {
                ret = BasicDiagnostic.toDiagnostic(iae);
            } catch (WrappedException we) {
                ret = BasicDiagnostic.toDiagnostic(we);
            }
        }
        return ret;
    }
    
    /**
     * @generated NOT
     */
    @Override
    public String getHelpContent(Object key, int kind) {
        return EEFPropertyViewUtil.getHelpContent(key);
    }
}
