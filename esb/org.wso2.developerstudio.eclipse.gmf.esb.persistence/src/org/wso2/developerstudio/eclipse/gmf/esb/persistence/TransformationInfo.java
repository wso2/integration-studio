package org.wso2.developerstudio.eclipse.gmf.esb.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.synapse.config.SynapseConfiguration;
import org.apache.synapse.core.axis2.ProxyService;
import org.apache.synapse.mediators.ListMediator;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.rest.API;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;

public class TransformationInfo {
	
	public static final int TRAVERSAL_DIRECTION_IN = 1;
	public static final int TRAVERSAL_DIRECTION_OUT = 2;
	
	SynapseConfiguration synapseConfiguration;
	SequenceMediator mainSequence;
	ListMediator originInSequence;
	ListMediator originOutSequence;
	ListMediator parentSequence;
	ListMediator currentReferredSequence;
	API currentAPI;
	int traversalDirection;
	public boolean isEndPointFound;
	public EObject firstEndPoint;
	public boolean isOutputPathSet;
	public EsbLink sequenceIncomingLink;
	public Sequence currentSequence;
	public EObject previousNode;
	private ProxyService currentProxy;
	
	public ProxyService getCurrentProxy() {
		return currentProxy;
	}

	public void setCurrentProxy(ProxyService currentProxy) {
		this.currentProxy = currentProxy;
	}

	private static List<EsbNode> transformedMediators = new ArrayList<EsbNode>();
	
	public ListMediator getOriginInSequence() {
		return originInSequence;
	}
	
	public ListMediator getParentSequence() {
		return parentSequence;
	}
	
	public ListMediator getOriginOutSequence() {
		return originOutSequence;
	}
	
	public SequenceMediator getMainSequence(){
		return mainSequence;
	}
	
	public SynapseConfiguration getSynapseConfiguration() {
		return synapseConfiguration;
	}
	
	public API getCurrentAPI(){
		return currentAPI;
	}
	
	public int getTraversalDirection() {
		return traversalDirection;
	}
	
	public EObject getPreviouNode(){
		return previousNode;
	}
	
	public EObject getFirstEndpoint(){
		return firstEndPoint;
	}

	public ListMediator getCurrentReferredSequence(){
		return currentReferredSequence;
	}
	
	public void setOriginOutSequence(ListMediator originOutSequence) {
		this.originOutSequence = originOutSequence;
	}
	
	public void setOriginInSequence(ListMediator originInSequence) {
		this.originInSequence = originInSequence;
	}
	
	public void setMainSequence(SequenceMediator mainSequence){
		this.mainSequence=mainSequence;
	}
	
	public void setParentSequence(ListMediator parentMediator) {
		this.parentSequence = parentMediator;
	}
	
	public void setSynapseConfiguration(
			SynapseConfiguration synapseConfiguration) {
		this.synapseConfiguration = synapseConfiguration;
	}
	
	public void setCurrentAPI(API currentAPI){
		this.currentAPI=currentAPI;
	}
	
	public void setTraversalDirection(int traversalDirection) {
		this.traversalDirection = traversalDirection;
	}
	
	public void setPreviousNode(EObject previousNode){
		this.previousNode=previousNode;
	}
	
	public void setFirstEndpoint(EObject firstEndpointNode){
		this.firstEndPoint = firstEndpointNode;
	}
	
	public void setCurrentReferredSequence(ListMediator currentReferredSequence){
		this.currentReferredSequence=currentReferredSequence;
	}

	public List<EsbNode> getTransformedMediators() {
		return transformedMediators;
	}
}
