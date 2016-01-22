var OperatorFactory = function(paper) {
	this.graph = graph;
	this.operatorSize = {width : 90, height : 90};
	this.operatorRect = {
			fill : '#F0F0F0',
			rx : 8,
			ry : 8,
			'stroke-width' : 2,
			stroke : 'blue'
		}
};

OperatorFactory.prototype.addOperator = function createDiv(type, position, objName) {
	var operator = null;
	if (type == "Concat") {
		operator = new joint.shapes.devs.Model({
			size : this.operatorSize,
			position : position,
			inPorts : [ 'in1', 'in2' ],
			outPorts : [ 'out' ],
			attrs : {
				'.label' : {
					text : objName,
					'ref-x' : .4,
					'ref-y' : .2
				},
				'graphProperties' : {
					marked : 0,
					visited : 0,
					index : -1,
					portVariableIndex : [ -1 ]
				},
				rect : this.operatorRect,
				circle : {
					r : 6
				},
				'.inPorts circle' : {
					fill : '#6495ED'
				},
				'.outPorts circle' : {
					fill : '#6495ED'
				}
			}
		});
	} else if (type == "Split") {
		operator = new joint.shapes.devs.Model({
			size : this.operatorSize,
			position : position,
			inPorts : [ 'in1' ],
			outPorts : [ 'out1', 'out2' ],
			attrs : {
				'.label' : {
					text : objName,
					'ref-x' : .4,
					'ref-y' : .2
				},
				'graphProperties' : {
					marked : 0,
					visited : 0,
					index : -1,
					portVariableIndex : [ -1, -1 ]
				},
				rect : this.operatorRect,
				circle : {
					r : 6
				},
				'.inPorts circle' : {
					fill : '#6495ED'
				},
				'.outPorts circle' : {
					fill : '#6495ED'
				}
			}
		});
	}

	this.graph.addCell(operator);
}