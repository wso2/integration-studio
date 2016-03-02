package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom;

import java.util.List;

import org.wso2.carbon.relay.mediators.builder.BuilderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageBuilder;

public class BuilderMediatorExt extends BuilderMediator {

	private List<MessageBuilder> messageBuilderList;

	public List<MessageBuilder> getMessageBuilderList() {
		return messageBuilderList;
	}

	public void setMessageBuilderList(List<MessageBuilder> messageBuilderList) {
		this.messageBuilderList = messageBuilderList;
	}

}
