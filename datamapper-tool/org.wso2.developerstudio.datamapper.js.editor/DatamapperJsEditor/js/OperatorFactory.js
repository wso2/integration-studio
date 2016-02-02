joint.shapes.devs.CustomOperator = joint.shapes.basic.Generic.extend(_.extend({}, joint.shapes.basic.PortsModelInterface, {

	
	markup: '<g class="rotatable"><g class="scalable"><rect class="topbody"/><g class="btn edit" transform="translate(100,5)"><rect class="edit" width="45" height="20" rx="2" ry="2" fill="transparent" stroke-width="1"></rect><text class="edit" fill="#000" font-size="15" font-weight="500" stroke="#000" x="5" y="15" font-family="Sans Serif">EDIT</text></g><rect class="body"/></g><text class="label"/><g class="inPorts"/><g class="outPorts"/><text class="label2"/></g>',
    portMarkup: '<g class="port port<%= id %>"><circle class="port-body"/><text class="port-label"/></g>',

    defaults: joint.util.deepSupplement({

        type: 'devs.Model',
        size: { width: 1, height: 1 },

        inPorts: [],
        outPorts: [],

        attrs: {
            '.': { magnet: false },
            '.topbody': {
                width: 150, height: 250,
                fill:'#0B615E',
                rx : 8,
    			ry : 8,
                stroke: '#6097aa'
            },
            '.body': {
                width: 148, height: 199,
                transform:"translate(1,50)",
                stroke: 'none',
                fill:'#90e3ff'
            },
            '.port-body': {
                r: 10,
                magnet: true,
                stroke: '#000000'
            },
            text: {
                'pointer-events': 'none'
            },
            '.label': { text: 'Model', 'ref-x': .5, 'ref-y': .05, ref: '.topbody', 'font-weight': 'bold', 'text-anchor': 'middle', fill: '#000000' },
            '.label2': { text: 'Delimiter = tab', 'ref-x': .2, 'ref-y': .5, ref: '.body', 'text-anchor': 'start', fill: '#000000' },
            '.inPorts .port-label': { x:-15, dy: 4, 'text-anchor': 'end', fill: '#000000' },
            '.outPorts .port-label':{ x: 15, dy: 4, fill: '#000000' }
        }

    }, joint.shapes.basic.Generic.prototype.defaults),
    

    getPortAttrs: function(portName, index, total, selector, type) {

        var attrs = {};

        var portClass = 'port' + index;
        var portSelector = selector + '>.' + portClass;
        var portLabelSelector = portSelector + '>.port-label';
        var portBodySelector = portSelector + '>.port-body';

        attrs[portLabelSelector] = { text: portName };
        attrs[portBodySelector] = { port: { id: portName || _.uniqueId(type) , type: type } };
        attrs[portSelector] = { ref: '.body', 'ref-y': (index + 0.5) * (1 / total) };

        if (selector === '.outPorts') { attrs[portSelector]['ref-dx'] = 0; }

        return attrs;
    },


}));

joint.shapes.devs.ModelView = joint.dia.ElementView.extend(joint.shapes.basic.PortsViewInterface);



var OperatorFactory = function(paper) {
	this.graph = graph;
	this.operatorSize = {width : 100, height : 100};
	this.operatorRect = {
			fill : '#81D0DA',
			rx : 8,
			ry : 8,
			'stroke-width' : 2,
			stroke : 'blue'
		}
};

OperatorFactory.prototype.addOperator = function createDiv(type, position, objName) {
	var operator = null;
	if (type == "Concat") {
		operator = new joint.shapes.devs.CustomOperator({
			size : this.operatorSize,
			position : position,
			inPorts : [ 'in1', 'in2' ],
			outPorts : [ 'out' ],
			attrs : {
				'.label' : {text : objName, 'ref-x' : .4},
				'.label2' : {text : 'options=""', 'ref-x' : .1},
				'graphProperties' : {
					marked : 0,
					visited : 0,
					index : -1,
					portVariableIndex : [ -1 ]
				},
				
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