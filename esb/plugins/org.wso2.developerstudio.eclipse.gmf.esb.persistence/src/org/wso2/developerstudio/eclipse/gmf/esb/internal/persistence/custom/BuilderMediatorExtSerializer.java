package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom;

import java.util.List;

import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.AbstractMediatorSerializer;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageBuilder;

public class BuilderMediatorExtSerializer extends AbstractMediatorSerializer {

	@Override
	protected OMElement serializeSpecificMediator(Mediator mediator) {

		if (!(mediator instanceof BuilderMediatorExt)) {
			handleException("Unsupported mediator passed in for serialization : "
					+ mediator.getType());
		}

		BuilderMediatorExt builderMediatorExt = (BuilderMediatorExt) mediator;
		OMElement builder = fac.createOMElement("builder", nullNS);
		saveTracingState(builder, mediator);

		List<MessageBuilder> messageBuilderList = builderMediatorExt
				.getMessageBuilderList();

		if (messageBuilderList != null && messageBuilderList.size() != 0) {

			for (MessageBuilder messageBuilder : messageBuilderList) {

				OMElement omMessageBuilder = fac.createOMElement(
						"messageBuilder", nullNS);

				if (messageBuilder.getContentType() != null) {

					omMessageBuilder.addAttribute(fac.createOMAttribute(
							"contentType", nullNS,
							messageBuilder.getContentType()));

				}

				if (messageBuilder.getBuilderClass() != null) {

					omMessageBuilder.addAttribute(fac.createOMAttribute(
							"class", nullNS, messageBuilder.getBuilderClass()));

				}

				if (messageBuilder.getFormatterClass() != null) {

					omMessageBuilder.addAttribute(fac.createOMAttribute(
							"formatterClass", nullNS,
							messageBuilder.getFormatterClass()));
				}

				builder.addChild(omMessageBuilder);
			}
		}

		return builder;
	}

	public String getMediatorClassName() {

		return BuilderMediatorExt.class.getName();
	}

}
