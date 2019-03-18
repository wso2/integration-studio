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

import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementCallbackHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementClientType;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;

// End of user code

/**
 * 
 * 
 */
public class EntitlementMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

    public static String BASE_PART = "Base"; //$NON-NLS-1$

    /**
     * Default constructor
     * 
     */
    public EntitlementMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext,
            EObject entitlementMediator, String editing_mode) {
        super(editingContext, entitlementMediator, editing_mode);
        parts = new String[] { BASE_PART };
        repositoryKey = EsbViewsRepository.class;
        partKey = EsbViewsRepository.EntitlementMediator.class;
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

            final EntitlementMediator entitlementMediator = (EntitlementMediator) elt;
            final EntitlementMediatorPropertiesEditionPart basePart = (EntitlementMediatorPropertiesEditionPart) editingPart;
            // init values
            if (isAccessible(EsbViewsRepository.EntitlementMediator.Properties.description))
                basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
                        entitlementMediator.getDescription()));

            if (isAccessible(EsbViewsRepository.EntitlementMediator.Properties.commentsList))
                basePart.setCommentsList(entitlementMediator.getCommentsList());

            if (isAccessible(EsbViewsRepository.EntitlementMediator.Properties.reverse)) {
                basePart.setReverse(entitlementMediator.isReverse());
            }
            if (isAccessible(EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL))
                basePart.setEntitlementServerURL(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
                        entitlementMediator.getEntitlementServerURL()));

            if (isAccessible(EsbViewsRepository.EntitlementMediator.Properties.username))
                basePart.setUsername(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
                        entitlementMediator.getUsername()));

            if (isAccessible(EsbViewsRepository.EntitlementMediator.Properties.password))
                basePart.setPassword(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
                        entitlementMediator.getPassword()));

            if (isAccessible(EsbViewsRepository.EntitlementMediator.Properties.callbackClassName))
                basePart.setCallbackClassName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
                        entitlementMediator.getCallbackClassName()));

            if (isAccessible(EsbViewsRepository.EntitlementMediator.Properties.thriftHost))
                basePart.setThriftHost(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
                        entitlementMediator.getThriftHost()));

            if (isAccessible(EsbViewsRepository.EntitlementMediator.Properties.thriftPort))
                basePart.setThriftPort(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
                        entitlementMediator.getThriftPort()));

            if (isAccessible(EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType)) {
                basePart.initEntitlementClientType(
                        EEFUtils.choiceOfValues(entitlementMediator,
                                EsbPackage.eINSTANCE.getEntitlementMediator_EntitlementClientType()),
                        entitlementMediator.getEntitlementClientType());
            }
            if (isAccessible(EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType)) {
                basePart.initOnRejectSequenceType(
                        EEFUtils.choiceOfValues(entitlementMediator,
                                EsbPackage.eINSTANCE.getEntitlementMediator_OnRejectSequenceType()),
                        entitlementMediator.getOnRejectSequenceType());
            }
            if (isAccessible(EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType)) {
                basePart.initOnAcceptSequenceType(
                        EEFUtils.choiceOfValues(entitlementMediator,
                                EsbPackage.eINSTANCE.getEntitlementMediator_OnAcceptSequenceType()),
                        entitlementMediator.getOnAcceptSequenceType());
            }
            if (isAccessible(EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType)) {
                basePart.initAdviceSequenceType(
                        EEFUtils.choiceOfValues(entitlementMediator,
                                EsbPackage.eINSTANCE.getEntitlementMediator_AdviceSequenceType()),
                        entitlementMediator.getAdviceSequenceType());
            }
            if (isAccessible(EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType)) {
                basePart.initObligationsSequenceType(
                        EEFUtils.choiceOfValues(entitlementMediator,
                                EsbPackage.eINSTANCE.getEntitlementMediator_ObligationsSequenceType()),
                        entitlementMediator.getObligationsSequenceType());
            }
            if (isAccessible(EsbViewsRepository.EntitlementMediator.Properties.callbackHandler)) {
                basePart.initCallbackHandler(
                        EEFUtils.choiceOfValues(entitlementMediator,
                                EsbPackage.eINSTANCE.getEntitlementMediator_CallbackHandler()),
                        entitlementMediator.getCallbackHandler());
            }
            // Start of user code for onRejectSequenceKey command update
            // End of user code

            // Start of user code for onAcceptSequenceKey command update
            // End of user code

            // Start of user code for adviceSequenceKey command update
            // End of user code

            // Start of user code for obligationsSequenceKey command update
            // End of user code

            // init filters

            // Start of user code for onRejectSequenceKey filter update
            // End of user code

            // Start of user code for onAcceptSequenceKey filter update
            // End of user code

            // Start of user code for adviceSequenceKey filter update
            // End of user code

            // Start of user code for obligationsSequenceKey filter update
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
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.description) {
            return EsbPackage.eINSTANCE.getEsbElement_Description();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.commentsList) {
            return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.reverse) {
            return EsbPackage.eINSTANCE.getMediator_Reverse();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL) {
            return EsbPackage.eINSTANCE.getEntitlementMediator_EntitlementServerURL();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.username) {
            return EsbPackage.eINSTANCE.getEntitlementMediator_Username();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.password) {
            return EsbPackage.eINSTANCE.getEntitlementMediator_Password();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.callbackClassName) {
            return EsbPackage.eINSTANCE.getEntitlementMediator_CallbackClassName();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.thriftHost) {
            return EsbPackage.eINSTANCE.getEntitlementMediator_ThriftHost();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.thriftPort) {
            return EsbPackage.eINSTANCE.getEntitlementMediator_ThriftPort();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType) {
            return EsbPackage.eINSTANCE.getEntitlementMediator_EntitlementClientType();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType) {
            return EsbPackage.eINSTANCE.getEntitlementMediator_OnRejectSequenceType();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType) {
            return EsbPackage.eINSTANCE.getEntitlementMediator_OnAcceptSequenceType();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType) {
            return EsbPackage.eINSTANCE.getEntitlementMediator_AdviceSequenceType();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType) {
            return EsbPackage.eINSTANCE.getEntitlementMediator_ObligationsSequenceType();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.callbackHandler) {
            return EsbPackage.eINSTANCE.getEntitlementMediator_CallbackHandler();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceKey) {
            return EsbPackage.eINSTANCE.getEntitlementMediator_OnRejectSequenceKey();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceKey) {
            return EsbPackage.eINSTANCE.getEntitlementMediator_OnAcceptSequenceKey();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceKey) {
            return EsbPackage.eINSTANCE.getEntitlementMediator_AdviceSequenceKey();
        }
        if (editorKey == EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceKey) {
            return EsbPackage.eINSTANCE.getEntitlementMediator_ObligationsSequenceKey();
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
        EntitlementMediator entitlementMediator = (EntitlementMediator) semanticObject;
        if (EsbViewsRepository.EntitlementMediator.Properties.description == event.getAffectedEditor()) {
            entitlementMediator.setDescription((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.EntitlementMediator.Properties.commentsList == event.getAffectedEditor()) {
            if (event.getKind() == PropertiesEditionEvent.SET) {
                entitlementMediator.getCommentsList().clear();
                entitlementMediator.getCommentsList().addAll(((EList) event.getNewValue()));
            }
        }
        if (EsbViewsRepository.EntitlementMediator.Properties.reverse == event.getAffectedEditor()) {
            entitlementMediator.setReverse((Boolean) event.getNewValue());
        }
        if (EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL == event.getAffectedEditor()) {
            entitlementMediator.setEntitlementServerURL((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.EntitlementMediator.Properties.username == event.getAffectedEditor()) {
            entitlementMediator.setUsername((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.EntitlementMediator.Properties.password == event.getAffectedEditor()) {
            entitlementMediator.setPassword((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.EntitlementMediator.Properties.callbackClassName == event.getAffectedEditor()) {
            entitlementMediator.setCallbackClassName((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.EntitlementMediator.Properties.thriftHost == event.getAffectedEditor()) {
            entitlementMediator.setThriftHost((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.EntitlementMediator.Properties.thriftPort == event.getAffectedEditor()) {
            entitlementMediator.setThriftPort((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType == event.getAffectedEditor()) {
            entitlementMediator.setEntitlementClientType((EntitlementClientType) event.getNewValue());
        }
        if (EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType == event.getAffectedEditor()) {
            entitlementMediator.setOnRejectSequenceType((EntitlementSequenceType) event.getNewValue());
        }
        if (EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType == event.getAffectedEditor()) {
            entitlementMediator.setOnAcceptSequenceType((EntitlementSequenceType) event.getNewValue());
        }
        if (EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType == event.getAffectedEditor()) {
            entitlementMediator.setAdviceSequenceType((EntitlementSequenceType) event.getNewValue());
        }
        if (EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType == event.getAffectedEditor()) {
            entitlementMediator.setObligationsSequenceType((EntitlementSequenceType) event.getNewValue());
        }
        if (EsbViewsRepository.EntitlementMediator.Properties.callbackHandler == event.getAffectedEditor()) {
            entitlementMediator.setCallbackHandler((EntitlementCallbackHandler) event.getNewValue());
        }
        if (EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceKey == event.getAffectedEditor()) {
            // Start of user code for updateOnRejectSequenceKey method body
            // End of user code

        }
        if (EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceKey == event.getAffectedEditor()) {
            // Start of user code for updateOnAcceptSequenceKey method body
            // End of user code

        }
        if (EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceKey == event.getAffectedEditor()) {
            // Start of user code for updateAdviceSequenceKey method body
            // End of user code

        }
        if (EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceKey == event.getAffectedEditor()) {
            // Start of user code for updateObligationsSequenceKey method body
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
            EntitlementMediatorPropertiesEditionPart basePart = (EntitlementMediatorPropertiesEditionPart) editingPart;
            if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.EntitlementMediator.Properties.description)) {
                if (msg.getNewValue() != null) {
                    basePart.setDescription(
                            EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setDescription("");
                }
            }
            if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.EntitlementMediator.Properties.commentsList)) {
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
                    && isAccessible(EsbViewsRepository.EntitlementMediator.Properties.reverse))
                basePart.setReverse((Boolean) msg.getNewValue());

            if (EsbPackage.eINSTANCE.getEntitlementMediator_EntitlementServerURL().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL)) {
                if (msg.getNewValue() != null) {
                    basePart.setEntitlementServerURL(
                            EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setEntitlementServerURL("");
                }
            }
            if (EsbPackage.eINSTANCE.getEntitlementMediator_Username().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.EntitlementMediator.Properties.username)) {
                if (msg.getNewValue() != null) {
                    basePart.setUsername(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setUsername("");
                }
            }
            if (EsbPackage.eINSTANCE.getEntitlementMediator_Password().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.EntitlementMediator.Properties.password)) {
                if (msg.getNewValue() != null) {
                    basePart.setPassword(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setPassword("");
                }
            }
            if (EsbPackage.eINSTANCE.getEntitlementMediator_CallbackClassName().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.EntitlementMediator.Properties.callbackClassName)) {
                if (msg.getNewValue() != null) {
                    basePart.setCallbackClassName(
                            EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setCallbackClassName("");
                }
            }
            if (EsbPackage.eINSTANCE.getEntitlementMediator_ThriftHost().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.EntitlementMediator.Properties.thriftHost)) {
                if (msg.getNewValue() != null) {
                    basePart.setThriftHost(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setThriftHost("");
                }
            }
            if (EsbPackage.eINSTANCE.getEntitlementMediator_ThriftPort().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.EntitlementMediator.Properties.thriftPort)) {
                if (msg.getNewValue() != null) {
                    basePart.setThriftPort(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setThriftPort("");
                }
            }
            if (EsbPackage.eINSTANCE.getEntitlementMediator_EntitlementClientType().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType))
                basePart.setEntitlementClientType((EntitlementClientType) msg.getNewValue());

            if (EsbPackage.eINSTANCE.getEntitlementMediator_OnRejectSequenceType().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType))
                basePart.setOnRejectSequenceType((EntitlementSequenceType) msg.getNewValue());

            if (EsbPackage.eINSTANCE.getEntitlementMediator_OnAcceptSequenceType().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType))
                basePart.setOnAcceptSequenceType((EntitlementSequenceType) msg.getNewValue());

            if (EsbPackage.eINSTANCE.getEntitlementMediator_AdviceSequenceType().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType))
                basePart.setAdviceSequenceType((EntitlementSequenceType) msg.getNewValue());

            if (EsbPackage.eINSTANCE.getEntitlementMediator_ObligationsSequenceType().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType))
                basePart.setObligationsSequenceType((EntitlementSequenceType) msg.getNewValue());

            if (EsbPackage.eINSTANCE.getEntitlementMediator_CallbackHandler().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.EntitlementMediator.Properties.callbackHandler))
                basePart.setCallbackHandler((EntitlementCallbackHandler) msg.getNewValue());

            // Start of user code for onRejectSequenceKey live update

            // End of user code

            // Start of user code for onAcceptSequenceKey live update

            // End of user code

            // Start of user code for adviceSequenceKey live update

            // End of user code

            // Start of user code for obligationsSequenceKey live update

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
                EsbPackage.eINSTANCE.getEntitlementMediator_EntitlementServerURL(),
                EsbPackage.eINSTANCE.getEntitlementMediator_Username(),
                EsbPackage.eINSTANCE.getEntitlementMediator_Password(),
                EsbPackage.eINSTANCE.getEntitlementMediator_CallbackClassName(),
                EsbPackage.eINSTANCE.getEntitlementMediator_ThriftHost(),
                EsbPackage.eINSTANCE.getEntitlementMediator_ThriftPort(),
                EsbPackage.eINSTANCE.getEntitlementMediator_EntitlementClientType(),
                EsbPackage.eINSTANCE.getEntitlementMediator_OnRejectSequenceType(),
                EsbPackage.eINSTANCE.getEntitlementMediator_OnAcceptSequenceType(),
                EsbPackage.eINSTANCE.getEntitlementMediator_AdviceSequenceType(),
                EsbPackage.eINSTANCE.getEntitlementMediator_ObligationsSequenceType(),
                EsbPackage.eINSTANCE.getEntitlementMediator_CallbackHandler(),
                EsbPackage.eINSTANCE.getEntitlementMediator_OnRejectSequenceKey(),
                EsbPackage.eINSTANCE.getEntitlementMediator_OnAcceptSequenceKey(),
                EsbPackage.eINSTANCE.getEntitlementMediator_AdviceSequenceKey(),
                EsbPackage.eINSTANCE.getEntitlementMediator_ObligationsSequenceKey());
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
                if (EsbViewsRepository.EntitlementMediator.Properties.description == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE
                            .validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.EntitlementMediator.Properties.commentsList == event.getAffectedEditor()) {
                    BasicDiagnostic chain = new BasicDiagnostic();
                    for (Iterator iterator = ((List) event.getNewValue()).iterator(); iterator.hasNext();) {
                        chain.add(Diagnostician.INSTANCE.validate(
                                EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(),
                                iterator.next()));
                    }
                    ret = chain;
                }
                if (EsbViewsRepository.EntitlementMediator.Properties.reverse == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE
                            .validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL == event
                        .getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getEntitlementMediator_EntitlementServerURL().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getEntitlementMediator_EntitlementServerURL().getEAttributeType(),
                            newValue);
                }
                if (EsbViewsRepository.EntitlementMediator.Properties.username == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getEntitlementMediator_Username().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getEntitlementMediator_Username().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.EntitlementMediator.Properties.password == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getEntitlementMediator_Password().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getEntitlementMediator_Password().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.EntitlementMediator.Properties.callbackClassName == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getEntitlementMediator_CallbackClassName().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getEntitlementMediator_CallbackClassName().getEAttributeType(),
                            newValue);
                }
                if (EsbViewsRepository.EntitlementMediator.Properties.thriftHost == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getEntitlementMediator_ThriftHost().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getEntitlementMediator_ThriftHost().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.EntitlementMediator.Properties.thriftPort == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getEntitlementMediator_ThriftPort().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getEntitlementMediator_ThriftPort().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType == event
                        .getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getEntitlementMediator_EntitlementClientType().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getEntitlementMediator_EntitlementClientType().getEAttributeType(),
                            newValue);
                }
                if (EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType == event
                        .getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getEntitlementMediator_OnRejectSequenceType().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getEntitlementMediator_OnRejectSequenceType().getEAttributeType(),
                            newValue);
                }
                if (EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType == event
                        .getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getEntitlementMediator_OnAcceptSequenceType().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getEntitlementMediator_OnAcceptSequenceType().getEAttributeType(),
                            newValue);
                }
                if (EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getEntitlementMediator_AdviceSequenceType().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getEntitlementMediator_AdviceSequenceType().getEAttributeType(),
                            newValue);
                }
                if (EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType == event
                        .getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE
                                .getEntitlementMediator_ObligationsSequenceType().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getEntitlementMediator_ObligationsSequenceType().getEAttributeType(),
                            newValue);
                }
                if (EsbViewsRepository.EntitlementMediator.Properties.callbackHandler == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getEntitlementMediator_CallbackHandler().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            EsbPackage.eINSTANCE.getEntitlementMediator_CallbackHandler().getEAttributeType(),
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
