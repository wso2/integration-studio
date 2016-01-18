function generateLanguage() {
		
		function VariableElement(name, id, value) {
			this.name = name;
			this.id = id;
			this.value = value;
			this.index = -1;
			this.visited = false;
		}

		VariableElement.prototype.isOutputVariable = function() {
			return this.name.search('output') == 0;
		};

		function OperationContainer(name, id) {
			this.name = name;
			this.id = id;
			this.index = -1;
			this.visited = false;
		}

		function VariablePair(source, target) {
			this.source = source;
			this.target = target;
		}
		
		VariablePair.prototype.printMapping = function() {
			return this.target.name + " = " + this.source.name;
		};
		
		console.log("mapping started");
		var graphOperationModelElements = [];
		var inputVariablesArray = [];
		var outputVariablesArray = [];
		var operationsArray = [];
		var resolvedVariableArray = [];
		var resolvedOutputVariableArray = [];

		var inputAdjList = [];
		var outputAdjList = [];
		var executionSeq = [];
		var directVariableMappings = [];

		populateOutputVariableArray();
		populateAdjLists();
		GenerateExecutionSequence();
		var generatedScript = printOutput();
		return generatedScript;
	

		function printOutput() {
			var directMappingOutput = "";
			for (var i = 0; directVariableMappings.length > i; ++i) {
				console.log(directVariableMappings[i]
						.printMapping());
				directMappingOutput += directVariableMappings[i].printMapping() + "\n" ;
			}
			var operationString = "";
			var opNumber = -1;
			for (var index = 0; executionSeq.length > index; ++index) {
				operationString = "[ ";
				opNumber = executionSeq[index];
				var varList = outputAdjList[opNumber]
				for (var i = 0; i < varList.length; ++i) {
					operationString += varList[i].name + " ";
				}
				operationString += " ] = ";
				operationString += operationsArray[opNumber].name + " [ ";
				varList = inputAdjList[opNumber]
				for (var i = 0; i < varList.length; ++i) {
					operationString += inputVariablesArray[varList[i]].name + " ";
				}
				operationString += " ]";
				console.log(operationString);
				directMappingOutput += operationString + "\n";
			}
			
			return directMappingOutput;
		}

		function GenerateExecutionSequence() {
			var startIndex = 0;
			var unexecutedOperationList = [];
			var tempUnexecutedOperationList = [];
			var numberOfOperations = operationsArray.length;
			for (var i = 0; i < numberOfOperations; ++i) {
				unexecutedOperationList.push(i);
			}
			while (executionSeq.length < numberOfOperations) {
				for (var index = 0; unexecutedOperationList.length > index; ++index) {
					if (operationIsExecutable(unexecutedOperationList[index])) {
						executionSeq
								.push(unexecutedOperationList[index]);
						addOutputsToResolvedVariables(unexecutedOperationList[index]);
					} else {
						tempUnexecutedOperationList
								.push(unexecutedOperationList[index]);
					}
				}
				unexecutedOperationList = tempUnexecutedOperationList;
				tempUnexecutedOperationList = [];
			}
		}

		function operationIsExecutable(index) {
			var inputVariables = inputAdjList[index];
			for (var count = 0; inputVariables.length > count; count++) {
				if (resolvedVariableArray
						.indexOf(inputVariables[count]) < 0) {
					return false;
				}
			}
			return true;
		}

		function addOutputsToResolvedVariables(index) {
			var outputVariables = outputAdjList[index];
			for (var count = 0; outputVariables.length > count; count++) {
				if (outputVariables[count].isOutputVariable()) {
					resolvedOutputVariableArray
							.push(outputVariables[count]);
				} else {
					resolvedVariableArray
							.push(outputVariables[count].index);
				}
			}
		}

		function populateAdjLists() {
			var tempNodeArray = [];
			var topElement = mInput.getEmbeddedCells()[0];
			tempNodeArray.push(topElement);
			var tempElement;
			var embeds;
			var variablePrefix = "input";
			var links = [];
			var link;
			var target;
			var source;
			while (tempNodeArray.length > 0) {
				tempElement = tempNodeArray.shift();
				if (isElementaVariableContainer(tempElement)) {
					embeds = tempElement.getEmbeddedCells();
					tempNodeArray = tempNodeArray
							.concat(embeds);
				} else if (isElementaVariable(tempElement)) {
					var tempVar = new VariableElement(
							getVariableName(variablePrefix,
									tempElement), tempElement
									.get('id'), "");
					inputVariablesArray.push(tempVar);
					tempElement.get('attrs')['graphProperties'].index = inputVariablesArray.length - 1;
					tempVar.index = inputVariablesArray.length - 1;
					resolvedVariableArray.push(tempVar.index);
					var opt = {
						outbound : true
					};
					links = graph.getConnectedLinks(
							tempElement, opt);
					for (var count = 0; links.length > count; ++count) {
						link = links[count];
						target = link.getTargetElement();
						if (isElementaVariable(target)) {
							directVariableMappings
									.push(new VariablePair(
											inputVariablesArray[tempElement
													.get('attrs')['graphProperties'].index],
											outputVariablesArray[target
													.get('attrs')['graphProperties'].index]));
						} else if (target.get('attrs')['graphProperties'].marked == 0) {
							target.get('attrs')['graphProperties'].marked = 1;
							tempNodeArray.push(target);
						}
					}

				} else if (isElementanOperation(tempElement)
						&& tempElement.get('attrs')['graphProperties'].visited == 0) {
					var tempOp = new OperationContainer(
							getOperationName(tempElement),
							tempElement.get('id'));
					operationsArray.push(tempOp);
					graphOperationModelElements
							.push(tempElement);
					tempElement.get('attrs')['graphProperties'].index = operationsArray.length - 1;
					tempOp.index = operationsArray.length - 1;
					outputAdjList[tempOp.index] = [];
					inputAdjList[tempOp.index] = [];
					var opt = {
						outbound : true
					};
					links = graph.getConnectedLinks(
							tempElement, opt);
					for (var count = 0; links.length > count; ++count) {
						link = links[count];
						target = link.getTargetElement();
						if (isElementaVariable(target)) {
							outputAdjList[tempOp.index]
									.push(outputVariablesArray[target
											.get('attrs')['graphProperties'].index]);
						} else {
							if (target.get('attrs')['graphProperties'].marked == 0) {
								target.get('attrs')['graphProperties'].marked = 1;
								tempNodeArray.push(target);
							}
							var variablePrefix = tempElement
									.get("attrs")['.label'].text
									+ "_"
									+ tempOp.index
									+ "_"
									+ link.get('source')['port'];
							var indexOfPort = tempElement.get(
									'outPorts').indexOf(
									link.get('source')['port']);
							if (tempElement.get('attrs')['graphProperties'].portVariableIndex[indexOfPort] < 0) {
								var tempVar = new VariableElement(
										variablePrefix,
										tempElement.get('id'),
										"");
								inputVariablesArray
										.push(tempVar);
								tempElement.get('attrs')['graphProperties'].portVariableIndex[indexOfPort] = inputVariablesArray.length - 1;
								tempVar.index = inputVariablesArray.length - 1;
								outputAdjList[tempOp.index]
										.push(tempVar);
								if (target.get('attrs')['graphProperties'].visited == 1) {
									inputAdjList[target
											.get('attrs')['graphProperties'].index]
											.push(tempVar.index);
								}

							}
						}
					}
					var opt = {
						inbound : true
					};
					links = graph.getConnectedLinks(
							tempElement, opt);
					for (var count = 0; links.length > count; ++count) {
						link = links[count];
						source = link.getSourceElement();
						if (isElementaVariable(source)) {
							inputAdjList[tempOp.index]
									.push(source.get('attrs')['graphProperties'].index);
						} else {
							if (source.get('attrs')['graphProperties'].marked == 0) {
								source.get('attrs')['graphProperties'].marked = 1;
								tempNodeArray.push(source);
							} else if (source.get('attrs')['graphProperties'].visited == 1) {
								var indexOfPort = (source
										.get('outPorts'))
										.indexOf(link
												.get('source')['port']);

								inputAdjList[tempOp.index]
										.push(source
												.get('attrs')['graphProperties'].portVariableIndex[indexOfPort]);
							}

						}
					}

					tempElement.get('attrs')['graphProperties'].visited = 1;
				} else {
					console.log("Unknown Element");
				}
			}

			for (var index = 0; graphOperationModelElements.length > index; ++index) {
				graphOperationModelElements[index].get('attrs')['graphProperties'].visited = 0;
				graphOperationModelElements[index].get('attrs')['graphProperties'].marked = 0;
				graphOperationModelElements[index].get('attrs')['graphProperties'].index = -1;
				graphOperationModelElements[index].get('attrs')['graphProperties'].portVariableIndex = [];
				for (var i = 0; i < graphOperationModelElements[index]
						.get('outPorts').length; ++i) {
					graphOperationModelElements[index]
							.get('attrs')['graphProperties'].portVariableIndex
							.push(-1);
				}
			}
		}

		function isElementaVariableContainer(element) {
			return element.getEmbeddedCells().length > 0;
		}

		function isElementaVariable(element) {
			return element.get("inPorts").length == 0
					|| element.get("outPorts").length == 0;
		}
		function isElementanOperation(element) {
			return element.get("inPorts").length > 0
					|| element.get("outPorts").length > 0;
		}

		function populateOutputVariableArray() {
			var tempNodeArray = [];
			var topElement = mOutput.getEmbeddedCells()[0];
			tempNodeArray.push(topElement);
			var tempElement;
			var embeds;
			var variablePrefix = "output";
			while (tempNodeArray.length > 0) {
				tempElement = tempNodeArray.pop();
				embeds = tempElement.getEmbeddedCells();
				if (embeds.length > 0) {
					tempNodeArray = tempNodeArray
							.concat(embeds);
				} else {
					outputVariablesArray
							.push(new VariableElement(
									getVariableName(
											variablePrefix,
											tempElement),
									tempElement.get('id'), ""));
					tempElement.get('attrs')['graphProperties'].index = outputVariablesArray.length - 1;
				}
			}
		}

		function insertStringAtPosition(position, baseString,
				newString) {
			var leftString = baseString.substring(0,
					position + 1);
			var rightString = baseString.substring(
					position + 1, baseString.length);
			return leftString + newString + rightString;
		}

		function getElementTextFromRect(element) {
			return element.get("attrs").text.text;
		}

		function getVariableName(variablePrefix, element) {
			return variablePrefix.concat("_.", element
					.get("attrs")['.label'].text);
		}

		function getOperationName(element) {
			return element.get("attrs")['.label'].text;
		}
	}
