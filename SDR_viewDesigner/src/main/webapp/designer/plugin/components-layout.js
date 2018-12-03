bgcolorClasses = ["bg-primary", "bg-secondary", "bg-success", "bg-danger", "bg-warning", "bg-info", "bg-light", "bg-dark", "bg-white"]

bgcolorSelectOptions =
	[{
		value: "Default",
		text: ""
	},
		{
			value: "bg-primary",
			text: "Primary"
		}, {
		value: "bg-secondary",
		text: "Secondary"
	}, {
		value: "bg-success",
		text: "Success"
	}, {
		value: "bg-danger",
		text: "Danger"
	}, {
		value: "bg-warning",
		text: "Warning"
	}, {
		value: "bg-info",
		text: "Info"
	}, {
		value: "bg-light",
		text: "Light"
	}, {
		value: "bg-dark",
		text: "Dark"
	}, {
		value: "bg-white",
		text: "White"
	}];

function changeNodeName(node, newNodeName)
{
	var newNode;
	newNode = document.createElement(newNodeName);
	attributes = node.get(0).attributes;

	for (i = 0, len = attributes.length; i < len; i++) {
		newNode.setAttribute(attributes[i].nodeName, attributes[i].nodeValue);
	}

	$(newNode).append($(node).contents());
	$(node).replaceWith(newNode);

	return newNode;
}


Vvveb.ComponentsGroup['Layout'] = [
	// "Layout/container",
    
    "Layout/gridrow-12",
    "Layout/gridrow-66",
    "Layout/gridrow",
    // "Layout/gridrow-39",
    // "Layout/gridrow-93",
	"Layout/gridrow-48",
	"Layout/gridrow-84",

    "Layout/panel"
    
	
];

Vvveb.ComponentsGroup['Components'] = [
	"Components/heading",
	"Components/label",
	"Components/link",
	
	// "Components/table",
	"Components/table-normal",
	"Components/table-non-border",
	"Components/table-coordinate",
	"Components/listgroup",

	"Components/image",
	"Components/video",
	"Components/alert",
	"Components/badge",
	
	"Components/button",
	"Components/buttongroup",
    "Components/hr",

    "Layout/jumbotron",
    "Layout/card"
	
	// "Components/buttontoolbar",
	// "Components/progress",
	// "Components/navbar",
	// "Components/breadcrumbs",
	// "Components/pagination",
	// "Components/form",
	// "Components/textinput",
	// "Components/textareainput",
	// "Components/selectinput",
	// "Components/fileinput",
	// "Components/checkbox",
	// "Components/radiobutton",
];


var base_sort = 100;//start sorting for base component from 100 to allow extended properties to be first

Vvveb.Components.add("_base", {
	name: "Element",
	properties: [{
		key: "element_header",
		inputtype: SectionInput,
		name:false,
		sort:base_sort++,
		data: {header:"General", expanded:false},
	}, {
		name: "Id",
		key: "id",
		htmlAttr: "id",
		sort: base_sort++,
		inline:true,
		col:6,
		inputtype: TextInput
	}, {
		name: "Class",
		key: "class",
		htmlAttr: "class",
		sort: base_sort++,
		inline:true,
		col:6,
		inputtype: TextInput
	}
	]
});

//display
Vvveb.Components.extend("_base", "_base", {
	properties: [
		{
			key: "display_header",
			inputtype: SectionInput,
			name:false,
			sort: base_sort++,
			data: {header:"Display", expanded:false},
		}, {
			name: "Display",
			key: "display",
			htmlAttr: "style",
			sort: base_sort++,
			col:6,
			inline:true,
			inputtype: SelectInput,
			validValues: ["block", "inline", "inline-block", "none"],
			data: {
				options: [{
					value: "block",
					text: "Block"
				}, {
					value: "inline",
					text: "Inline"
				}, {
					value: "inline-block",
					text: "Inline Block"
				}, {
					value: "none",
					text: "none"
				}]
			}
		}, {
			name: "Position",
			key: "position",
			htmlAttr: "style",
			sort: base_sort++,
			col:6,
			inline:true,
			inputtype: SelectInput,
			validValues: ["static", "fixed", "relative", "absolute"],
			data: {
				options: [{
					value: "static",
					text: "Static"
				}, {
					value: "fixed",
					text: "Fixed"
				}, {
					value: "relative",
					text: "Relative"
				}, {
					value: "absolute",
					text: "Absolute"
				}]
			}
		}, {
			name: "Top",
			key: "top",
			htmlAttr: "style",
			sort: base_sort++,
			col:6,
			inline:true,
			parent:"",
			inputtype: CssUnitInput
		}, {
			name: "Left",
			key: "left",
			htmlAttr: "style",
			sort: base_sort++,
			col:6,
			inline:true,
			parent:"",
			inputtype: CssUnitInput
		}, {
			name: "Bottom",
			key: "bottom",
			htmlAttr: "style",
			sort: base_sort++,
			col:6,
			inline:true,
			parent:"",
			inputtype: CssUnitInput
		}, {
			name: "Right",
			key: "right",
			htmlAttr: "style",
			sort: base_sort++,
			col:6,
			inline:true,
			parent:"",
			inputtype: CssUnitInput
		},{
			name: "Float",
			key: "float",
			htmlAttr: "style",
			sort: base_sort++,
			col:12,
			inline:true,
			inputtype: RadioButtonInput,
			data: {
				extraclass:"btn-group-sm btn-group-fullwidth",
				options: [{
					value: "none",
					icon:"la la-close",
					//text: "None",
					title: "None",
					checked:true,
				}, {
					value: "left",
					//text: "Left",
					title: "Left",
					icon:"la la-align-left",
					checked:false,
				}, {
					value: "right",
					//text: "Right",
					title: "Right",
					icon:"la la-align-right",
					checked:false,
				}],
			}
		}, {
			name: "Opacity",
			key: "opacity",
			htmlAttr: "style",
			sort: base_sort++,
			col:12,
			inline:true,
			parent:"",
			inputtype: RangeInput,
			data:{
				max: 1, //max zoom level
				min:0,
				step:0.1
			},
		}, {
			name: "Background Color",
			key: "background-color",
			sort: base_sort++,
			col:6,
			inline:true,
			htmlAttr: "style",
			inputtype: ColorInput,
		}, {
			name: "Text Color",
			key: "color",
			sort: base_sort++,
			col:6,
			inline:true,
			htmlAttr: "style",
			inputtype: ColorInput,
		}]
});

//Typography
Vvveb.Components.extend("_base", "_base", {
	properties: [
		{
			key: "typography_header",
			inputtype: SectionInput,
			name:false,
			sort: base_sort++,
			data: {header:"Typography", expanded:false},
		}, {
			name: "Font family",
			key: "font-family",
			htmlAttr: "style",
			sort: base_sort++,
			col:6,
			inline:true,
			inputtype: SelectInput,
			data: {
				options: [{
					value: "",
					text: "Default"
				}, {
					value: "Arial, Helvetica, sans-serif",
					text: "Arial"
				}, {
					value: 'Lucida Sans Unicode", "Lucida Grande", sans-serif',
					text: 'Lucida Grande'
				}, {
					value: 'Palatino Linotype", "Book Antiqua", Palatino, serif',
					text: 'Palatino Linotype'
				}, {
					value: '"Times New Roman", Times, serif',
					text: 'Times New Roman'
				}, {
					value: "Georgia, serif",
					text: "Georgia, serif"
				}, {
					value: "Tahoma, Geneva, sans-serif",
					text: "Tahoma"
				}, {
					value: 'Comic Sans MS, cursive, sans-serif',
					text: 'Comic Sans'
				}, {
					value: 'Verdana, Geneva, sans-serif',
					text: 'Verdana'
				}, {
					value: 'Impact, Charcoal, sans-serif',
					text: 'Impact'
				}, {
					value: 'Arial Black, Gadget, sans-serif',
					text: 'Arial Black'
				}, {
					value: 'Trebuchet MS, Helvetica, sans-serif',
					text: 'Trebuchet'
				}, {
					value: 'Courier New", Courier, monospace',
					text: 'Courier New", Courier, monospace'
				}, {
					value: 'Brush Script MT, sans-serif',
					text: 'Brush Script'
				}]
			}
		}, {
			name: "Font weight",
			key: "font-weight",
			htmlAttr: "style",
			sort: base_sort++,
			col:6,
			inline:true,
			inputtype: SelectInput,
			data: {
				options: [{
					value: "",
					text: "Default"
				}, {
					value: "100",
					text: "Thin"
				}, {
					value: "200",
					text: "Extra-Light"
				}, {
					value: "300",
					text: "Light"
				}, {
					value: "400",
					text: "Normal"
				}, {
					value: "500",
					text: "Medium"
				}, {
					value: "600",
					text: "Semi-Bold"
				}, {
					value: "700",
					text: "Bold"
				}, {
					value: "800",
					text: "Extra-Bold"
				}, {
					value: "900",
					text: "Ultra-Bold"
				}],
			}
		}, {
			name: "Font size",
			key: "font-size",
			htmlAttr: "style",
			sort: base_sort++,
			col:12,
			inline:true,
			inputtype: CssUnitInput
		}, {
			name: "Text align",
			key: "text-align",
			htmlAttr: "style",
			sort: base_sort++,
			col:12,
			inline:true,
			inputtype: RadioButtonInput,
			data: {
				extraclass:"btn-group-sm btn-group-fullwidth",
				options: [{
					value: "none",
					icon:"la la-close",
					//text: "None",
					title: "None",
					checked:true,
				}, {
					value: "left",
					//text: "Left",
					title: "Left",
					icon:"la la-align-left",
					checked:false,
				}, {
					value: "center",
					//text: "Center",
					title: "Center",
					icon:"la la-align-center",
					checked:false,
				}, {
					value: "right",
					//text: "Right",
					title: "Right",
					icon:"la la-align-right",
					checked:false,
				}, {
					value: "justify",
					//text: "justify",
					title: "Justify",
					icon:"la la-align-justify",
					checked:false,
				}],
			},
		}, {
			name: "Line height",
			key: "line-height",
			htmlAttr: "style",
			sort: base_sort++,
			col:6,
			inline:true,
			inputtype: CssUnitInput
		}, {
			name: "Letter spacing",
			key: "letter-spacing",
			htmlAttr: "style",
			sort: base_sort++,
			col:6,
			inline:true,
			inputtype: CssUnitInput
		}, {
			name: "Text decoration",
			key: "text-decoration-line",
			htmlAttr: "style",
			sort: base_sort++,
			col:12,
			inline:true,
			inputtype: RadioButtonInput,
			data: {
				extraclass:"btn-group-sm btn-group-fullwidth",
				options: [{
					value: "none",
					icon:"la la-close",
					//text: "None",
					title: "None",
					checked:true,
				}, {
					value: "underline",
					//text: "Left",
					title: "underline",
					icon:"la la-long-arrow-down",
					checked:false,
				}, {
					value: "overline",
					//text: "Right",
					title: "overline",
					icon:"la la-long-arrow-up",
					checked:false,
				}, {
					value: "line-through",
					//text: "Right",
					title: "Line Through",
					icon:"la la-strikethrough",
					checked:false,
				}, {
					value: "underline overline",
					//text: "justify",
					title: "Underline Overline",
					icon:"la la-arrows-v",
					checked:false,
				}],
			},
		}, {
			name: "Decoration Color",
			key: "text-decoration-color",
			sort: base_sort++,
			col:6,
			inline:true,
			htmlAttr: "style",
			inputtype: ColorInput,
		}, {
			name: "Decoration style",
			key: "text-decoration-style",
			htmlAttr: "style",
			sort: base_sort++,
			col:6,
			inline:true,
			inputtype: SelectInput,
			data: {
				options: [{
					value: "",
					text: "Default"
				}, {
					value: "solid",
					text: "Solid"
				}, {
					value: "wavy",
					text: "Wavy"
				}, {
					value: "dotted",
					text: "Dotted"
				}, {
					value: "dashed",
					text: "Dashed"
				}, {
					value: "double",
					text: "Double"
				}],
			}
		}]
})

//Size
Vvveb.Components.extend("_base", "_base", {
	properties: [{
		key: "size_header",
		inputtype: SectionInput,
		name:false,
		sort: base_sort++,
		data: {header:"Size", expanded:false},
	}, {
		name: "Width",
		key: "width",
		htmlAttr: "style",
		sort: base_sort++,
		col:6,
		inline:true,
		inputtype: CssUnitInput
	}, {
		name: "Height",
		key: "height",
		htmlAttr: "style",
		sort: base_sort++,
		col:6,
		inline:true,
		inputtype: CssUnitInput
	}, {
		name: "Min Width",
		key: "min-width",
		htmlAttr: "style",
		sort: base_sort++,
		col:6,
		inline:true,
		inputtype: CssUnitInput
	}, {
		name: "Min Height",
		key: "min-height",
		htmlAttr: "style",
		sort: base_sort++,
		col:6,
		inline:true,
		inputtype: CssUnitInput
	}, {
		name: "Max Width",
		key: "max-width",
		htmlAttr: "style",
		sort: base_sort++,
		col:6,
		inline:true,
		inputtype: CssUnitInput
	}, {
		name: "Max Height",
		key: "max-height",
		htmlAttr: "style",
		sort: base_sort++,
		col:6,
		inline:true,
		inputtype: CssUnitInput
	}]
});

//Margin
Vvveb.Components.extend("_base", "_base", {
	properties: [{
		key: "margins_header",
		inputtype: SectionInput,
		name:false,
		sort: base_sort++,
		data: {header:"Margin", expanded:false},
	}, {
		name: "Top",
		key: "margin-top",
		htmlAttr: "style",
		sort: base_sort++,
		col:6,
		inline:true,
		inputtype: CssUnitInput
	}, {
		name: "Right",
		key: "margin-right",
		htmlAttr: "style",
		sort: base_sort++,
		col:6,
		inline:true,
		inputtype: CssUnitInput
	}, {
		name: "Bottom",
		key: "margin-bottom",
		htmlAttr: "style",
		sort: base_sort++,
		col:6,
		inline:true,
		inputtype: CssUnitInput
	}, {
		name: "Left",
		key: "margin-Left",
		htmlAttr: "style",
		sort: base_sort++,
		col:6,
		inline:true,
		inputtype: CssUnitInput
	}]
});

//Padding
Vvveb.Components.extend("_base", "_base", {
	properties: [{
		key: "paddings_header",
		inputtype: SectionInput,
		name:false,
		sort: base_sort++,
		data: {header:"Padding", expanded:false},
	}, {
		name: "Top",
		key: "padding-top",
		htmlAttr: "style",
		sort: base_sort++,
		col:6,
		inline:true,
		inputtype: CssUnitInput
	}, {
		name: "Right",
		key: "padding-right",
		htmlAttr: "style",
		sort: base_sort++,
		col:6,
		inline:true,
		inputtype: CssUnitInput
	}, {
		name: "Bottom",
		key: "padding-bottom",
		htmlAttr: "style",
		sort: base_sort++,
		col:6,
		inline:true,
		inputtype: CssUnitInput
	}, {
		name: "Left",
		key: "padding-Left",
		htmlAttr: "style",
		sort: base_sort++,
		col:6,
		inline:true,
		inputtype: CssUnitInput
	}]
});


//Border
Vvveb.Components.extend("_base", "_base", {
	properties: [{
		key: "border_header",
		inputtype: SectionInput,
		name:false,
		sort: base_sort++,
		data: {header:"Border", expanded:false},
	}, {
		name: "Style",
		key: "border-style",
		htmlAttr: "style",
		sort: base_sort++,
		col:12,
		inline:true,
		inputtype: SelectInput,
		data: {
			options: [{
				value: "",
				text: "Default"
			}, {
				value: "solid",
				text: "Solid"
			}, {
				value: "dotted",
				text: "Dotted"
			}, {
				value: "dashed",
				text: "Dashed"
			}],
		}
	}, {
		name: "Width",
		key: "border-width",
		htmlAttr: "style",
		sort: base_sort++,
		col:6,
		inline:true,
		inputtype: CssUnitInput
	}, {
		name: "Color",
		key: "border-color",
		sort: base_sort++,
		col:6,
		inline:true,
		htmlAttr: "style",
		inputtype: ColorInput,
	}]
});

Vvveb.Components.extend("_base", "Layout/container", {
	classes: ["container", "container-fluid"],
	image: "icons/container.svg",
	html: '<div class="container-fluid" style="min-height: 80px;"></div>',
	name: "Container",
	properties: [
		{
			name: "Type",
			key: "type",
			htmlAttr: "class",
			inputtype: SelectInput,
			validValues: ["container", "container-fluid"],
			data: {
				options: [{
					value: "container",
					text: "Default"
				}, {
					value: "container-fluid",
					text: "Fluid"
				}]
			}
		},
		{
			name: "Background",
			key: "background",
			htmlAttr: "class",
			validValues: bgcolorClasses,
			inputtype: SelectInput,
			data: {
				options: bgcolorSelectOptions
			}
		},
		{
			name: "Background Color",
			key: "background-color",
			htmlAttr: "style",
			inputtype: ColorInput,
		},
		{
			name: "Text Color",
			key: "color",
			htmlAttr: "style",
			inputtype: ColorInput,
		}],
});

Vvveb.Components.extend("_base", "Components/heading", {
	image: "icons/custom/icon_02_heading.svg",
	name: "Heading",
	nodes: ["h1", "h2","h3", "h4","h5","h6"],
	html: "<h1>Heading</h1>",

	properties: [
		{
			name: "Size",
			key: "id",
			htmlAttr: "id",
			inputtype: SelectInput,

			onChange: function(node, value) {

				return changeNodeName(node, "h" + value);
			},

			init: function(node) {
				var regex;
				regex = /H(\d)/.exec(node.nodeName);
				if (regex && regex[1]) {
					return regex[1]
				}
				return 1
			},

			data:{
				options: [{
					value: "1",
					text: "h1"
				}, {
					value: "2",
					text: "h2"
				}, {
					value: "3",
					text: "h3"
				}, {
					value: "4",
					text: "h4"
				}, {
					value: "5",
					text: "h5"
				}, {
					value: "6",
					text: "h6"
				}]
			},
		}]
});
Vvveb.Components.extend("_base", "Components/link", {
	nodes: ["a"],
	name: "Link",
	html: '<a href="http://" target="_blank">Link</a>',
	image: "icons/custom/icon_01_link.svg",
	properties: [{
		name: "Url",
		key: "href",
		htmlAttr: "href",
		inputtype: LinkInput
	}, {
		name: "Target",
		key: "target",
		htmlAttr: "target",
		inputtype: SelectInput,
		validValues: ["_self", "_blank", "_parent", "_top"],
		data: {
			options: [{
				value: "_self",
				text: "_self"
			}, {
				value: "_blank",
				text: "_blank"
			}, {
				value: "_parent",
				text: "_parent"
			}, {
				value: "_top",
				text: "_top"
			}]
		}
	}]
});
// Vvveb.Components.extend("_base", "Components/image", {
// 	nodes: ["img"],
// 	name: "Image",
// 	html: '<img src="' +  Vvveb.baseUrl + 'icons/image.svg" height="128" width="128">',
// 	/*
// 	afterDrop: function (node)
// 	{
// 		node.attr("src", '');
// 		return node;
// 	},*/
// 	image: "icons/image.svg",
// 	properties: [{
// 		name: "Image",
// 		key: "src",
// 		htmlAttr: "src",
// 		inputtype: FileUploadInput
// 	}, {
// 		name: "Width",
// 		key: "width",
// 		htmlAttr: "width",
// 		inputtype: TextInput
// 	}, {
// 		name: "Height",
// 		key: "height",
// 		htmlAttr: "height",
// 		inputtype: TextInput
// 	}, {
// 		name: "Alt",
// 		key: "alt",
// 		htmlAttr: "alt",
// 		inputtype: TextInput
// 	}]
// });
Vvveb.Components.add("Components/hr", {
	image: "icons/hr.svg",
	nodes: ["hr"],
	name: "Horizontal Rule",
	html: "<hr>"
});
Vvveb.Components.extend("_base", "Components/label", {
	name: "Label",
	nodes: ["label"],
	image: "icons/label.svg",
	html: '<label for="">Label</label>',
	properties: [{
		name: "For id",
		htmlAttr: "for",
		key: "for",
		inputtype: TextInput
	}]
});
Vvveb.Components.extend("_base", "Components/button", {
	classes: ["btn", "btn-link"],
	name: "Button",
	image: "icons/button.svg",
	html: '<button type="button" class="btn btn-primary">Primary</button>',
	properties: [{
		name: "Link To",
		key: "href",
		htmlAttr: "href",
		inputtype: LinkInput
	}, {
		name: "Type",
		key: "type",
		htmlAttr: "class",
		inputtype: SelectInput,
		validValues: ["btn-default", "btn-primary", "btn-info", "btn-success", "btn-warning", "btn-info", "btn-light", "btn-dark", "btn-outline-primary", "btn-outline-info", "btn-outline-success", "btn-outline-warning", "btn-outline-info", "btn-outline-light", "btn-outline-dark", "btn-link"],
		data: {
			options: [{
				value: "btn-default",
				text: "Default"
			}, {
				value: "btn-primary",
				text: "Primary"
			}, {
				value: "btn btn-info",
				text: "Info"
			}, {
				value: "btn-success",
				text: "Success"
			}, {
				value: "btn-warning",
				text: "Warning"
			}, {
				value: "btn-info",
				text: "Info"
			}, {
				value: "btn-light",
				text: "Light"
			}, {
				value: "btn-dark",
				text: "Dark"
			}, {
				value: "btn-outline-primary",
				text: "Primary outline"
			}, {
				value: "btn btn-outline-info",
				text: "Info outline"
			}, {
				value: "btn-outline-success",
				text: "Success outline"
			}, {
				value: "btn-outline-warning",
				text: "Warning outline"
			}, {
				value: "btn-outline-info",
				text: "Info outline"
			}, {
				value: "btn-outline-light",
				text: "Light outline"
			}, {
				value: "btn-outline-dark",
				text: "Dark outline"
			}, {
				value: "btn-link",
				text: "Link"
			}]
		}
	}, {
		name: "Size",
		key: "size",
		htmlAttr: "class",
		inputtype: SelectInput,
		validValues: ["btn-lg", "btn-sm"],
		data: {
			options: [{
				value: "",
				text: "Default"
			}, {
				value: "btn-lg",
				text: "Large"
			}, {
				value: "btn-sm",
				text: "Small"
			}]
		}
	}, {
		name: "Target",
		key: "target",
		htmlAttr: "target",
		inputtype: TextInput
	}, {
		name: "Disabled",
		key: "disabled",
		htmlAttr: "class",
		inputtype: ToggleInput,
		validValues: ["disabled"],
		data: {
			on: "disabled",
			off: ""
		}
	}]
});
Vvveb.Components.extend("_base", "Components/buttongroup", {
	classes: ["btn-group"],
	name: "Button Group",
	image: "icons/button_group.svg",
	html: '<div class="btn-group" role="group" aria-label="Basic example"><button type="button" class="btn btn-secondary">Left</button><button type="button" class="btn btn-secondary">Middle</button> <button type="button" class="btn btn-secondary">Right</button></div>',
	properties: [{
		name: "Size",
		key: "size",
		htmlAttr: "class",
		inputtype: SelectInput,
		validValues: ["btn-group-lg", "btn-group-sm"],
		data: {
			options: [{
				value: "",
				text: "Default"
			}, {
				value: "btn-group-lg",
				text: "Large"
			}, {
				value: "btn-group-sm",
				text: "Small"
			}]
		}
	}, {
		name: "Alignment",
		key: "alignment",
		htmlAttr: "class",
		inputtype: SelectInput,
		validValues: ["btn-group", "btn-group-vertical"],
		data: {
			options: [{
				value: "",
				text: "Default"
			}, {
				value: "btn-group",
				text: "Horizontal"
			}, {
				value: "btn-group-vertical",
				text: "Vertical"
			}]
		}
	}]
});
Vvveb.Components.extend("_base", "Components/buttontoolbar", {
	classes: ["btn-toolbar"],
	name: "Button Toolbar",
	image: "icons/button_toolbar.svg",
	html: '<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">\
		  <div class="btn-group mr-2" role="group" aria-label="First group">\
			<button type="button" class="btn btn-secondary">1</button>\
			<button type="button" class="btn btn-secondary">2</button>\
			<button type="button" class="btn btn-secondary">3</button>\
			<button type="button" class="btn btn-secondary">4</button>\
		  </div>\
		  <div class="btn-group mr-2" role="group" aria-label="Second group">\
			<button type="button" class="btn btn-secondary">5</button>\
			<button type="button" class="btn btn-secondary">6</button>\
			<button type="button" class="btn btn-secondary">7</button>\
		  </div>\
		  <div class="btn-group" role="group" aria-label="Third group">\
			<button type="button" class="btn btn-secondary">8</button>\
		  </div>\
		</div>'
});
Vvveb.Components.extend("_base","Components/alert", {
	classes: ["alert"],
	name: "Alert",
	image: "icons/alert.svg",
	html: '<div class="alert alert-warning alert-dismissible fade show" role="alert">\
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">\
			<span aria-hidden="true">&times;</span>\
		  </button>\
		  <strong>Holy guacamole!</strong> You should check in on some of those fields below.\
		</div>',
	properties: [{
		name: "Type",
		key: "type",
		htmlAttr: "class",
		validValues: ["alert-primary", "alert-secondary", "alert-success", "alert-danger", "alert-warning", "alert-info", "alert-light", "alert-dark"],
		inputtype: SelectInput,
		data: {
			options: [{
				value: "alert-primary",
				text: "Default"
			}, {
				value: "alert-secondary",
				text: "Secondary"
			}, {
				value: "alert-success",
				text: "Success"
			}, {
				value: "alert-danger",
				text: "Danger"
			}, {
				value: "alert-warning",
				text: "Warning"
			}, {
				value: "alert-info",
				text: "Info"
			}, {
				value: "alert-light",
				text: "Light"
			}, {
				value: "alert-dark",
				text: "Dark"
			}]
		}
	}]
});
Vvveb.Components.extend("_base", "Components/badge", {
	classes: ["badge"],
	image: "icons/badge.svg",
	name: "Badge",
	html: '<span class="badge badge-primary">Primary badge</span>',
	properties: [{
		name: "Color",
		key: "color",
		htmlAttr: "class",
		validValues:["badge-primary", "badge-secondary", "badge-success", "badge-danger", "badge-warning", "badge-info", "badge-light", "badge-dark"],
		inputtype: SelectInput,
		data: {
			options: [{
				value: "",
				text: "Default"
			}, {
				value: "badge-primary",
				text: "Primary"
			}, {
				value: "badge-secondary",
				text: "Secondary"
			}, {
				value: "badge-success",
				text: "Success"
			}, {
				value: "badge-warning",
				text: "Warning"
			}, {
				value: "badge-danger",
				text: "Danger"
			}, {
				value: "badge-info",
				text: "Info"
			}, {
				value: "badge-light",
				text: "Light"
			}, {
				value: "badge-dark",
				text: "Dark"
			}]
		}
	}]
});
Vvveb.Components.extend("_base", "Layout/card", {
	classes: ["card"],
	image: "icons/panel.svg",
	name: "Card",
	html: '<div class="card">\
		  <img class="card-img-top" src="../../libs/builder/icons/image.svg" alt="Card image cap" width="128" height="128">\
		  <div class="card-body">\
			<h4 class="card-title">Card title</h4>\
			<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card\'s content.</p>\
			<a href="#" class="btn btn-primary">Go somewhere</a>\
		  </div>\
		</div>'
});
Vvveb.Components.extend("_base", "Components/listgroup", {
	name: "List Group",
	image: "icons/list_group.svg",
	classes: ["list-group"],
	html: '<ul class="list-group">\n  <li class="list-group-item">\n    <span class="badge">14</span>\n    Cras justo odio\n  </li>\n  <li class="list-group-item">\n    <span class="badge">2</span>\n    Dapibus ac facilisis in\n  </li>\n  <li class="list-group-item">\n    <span class="badge">1</span>\n    Morbi leo risus\n  </li>\n</ul>'
});
Vvveb.Components.extend("_base", "Layout/listitem", {
	name: "List Item",
	classes: ["list-group-item"],
	html: '<li class="list-group-item"><span class="badge">14</span> Cras justo odio</li>'
});
Vvveb.Components.extend("_base", "Components/breadcrumbs", {
	classes: ["breadcrumb"],
	name: "Breadcrumbs",
	image: "icons/breadcrumbs.svg",
	html: '<ol class="breadcrumb">\
		  <li class="breadcrumb-item active"><a href="#">Home</a></li>\
		  <li class="breadcrumb-item active"><a href="#">Library</a></li>\
		  <li class="breadcrumb-item active">Data 3</li>\
		</ol>'
});
Vvveb.Components.extend("_base", "Layout/breadcrumbitem", {
	classes: ["breadcrumb-item"],
	name: "Breadcrumb Item",
	html: '<li class="breadcrumb-item"><a href="#">Library</a></li>',
	properties: [{
		name: "Active",
		key: "active",
		htmlAttr: "class",
		validValues: ["", "active"],
		inputtype: ToggleInput,
		data: {
			on: "active",
			off: ""
		}
	}]
});
Vvveb.Components.extend("_base", "Components/pagination", {
	classes: ["pagination"],
	name: "Pagination",
	image: "icons/pagination.svg",
	html: '<nav aria-label="Page navigation example">\
	  <ul class="pagination">\
		<li class="page-item"><a class="page-link" href="#">Previous</a></li>\
		<li class="page-item"><a class="page-link" href="#">1</a></li>\
		<li class="page-item"><a class="page-link" href="#">2</a></li>\
		<li class="page-item"><a class="page-link" href="#">3</a></li>\
		<li class="page-item"><a class="page-link" href="#">Next</a></li>\
	  </ul>\
	</nav>',

	properties: [{
		name: "Size",
		key: "size",
		htmlAttr: "class",
		inputtype: SelectInput,
		validValues: ["btn-lg", "btn-sm"],
		data: {
			options: [{
				value: "",
				text: "Default"
			}, {
				value: "btn-lg",
				text: "Large"
			}, {
				value: "btn-sm",
				text: "Small"
			}]
		}
	},{
		name: "Alignment",
		key: "alignment",
		htmlAttr: "class",
		inputtype: SelectInput,
		validValues: ["justify-content-center", "justify-content-end"],
		data: {
			options: [{
				value: "",
				text: "Default"
			}, {
				value: "justify-content-center",
				text: "Center"
			}, {
				value: "justify-content-end",
				text: "Right"
			}]
		}
	}]
});
Vvveb.Components.extend("_base", "Layout/pageitem", {
	classes: ["page-item"],
	html: '<li class="page-item"><a class="page-link" href="#">1</a></li>',
	name: "Pagination Item",
	properties: [{
		name: "Link To",
		key: "href",
		htmlAttr: "href",
		child:".page-link",
		inputtype: TextInput
	}, {
		name: "Disabled",
		key: "disabled",
		htmlAttr: "class",
		validValues: ["disabled"],
		inputtype: ToggleInput,
		data: {
			on: "disabled",
			off: ""
		}
	}]
});
Vvveb.Components.extend("_base", "Components/progress", {
	classes: ["progress"],
	name: "Progress Bar",
	image: "icons/progressbar.svg",
	html: '<div class="progress"><div class="progress-bar w-25"></div></div>',
	properties: [{
		name: "Background",
		key: "background",
		htmlAttr: "class",
		validValues: bgcolorClasses,
		inputtype: SelectInput,
		data: {
			options: bgcolorSelectOptions
		}
	},
		{
			name: "Progress",
			key: "background",
			child:".progress-bar",
			htmlAttr: "class",
			validValues: ["", "w-25", "w-50", "w-75", "w-100"],
			inputtype: SelectInput,
			data: {
				options: [{
					value: "",
					text: "None"
				}, {
					value: "w-25",
					text: "25%"
				}, {
					value: "w-50",
					text: "50%"
				}, {
					value: "w-75",
					text: "75%"
				}, {
					value: "w-100",
					text: "100%"
				}]
			}
		},
		{
			name: "Progress background",
			key: "background",
			child:".progress-bar",
			htmlAttr: "class",
			validValues: bgcolorClasses,
			inputtype: SelectInput,
			data: {
				options: bgcolorSelectOptions
			}
		}, {
			name: "Striped",
			key: "striped",
			child:".progress-bar",
			htmlAttr: "class",
			validValues: ["", "progress-bar-striped"],
			inputtype: ToggleInput,
			data: {
				on: "progress-bar-striped",
				off: "",
			}
		}, {
			name: "Animated",
			key: "animated",
			child:".progress-bar",
			htmlAttr: "class",
			validValues: ["", "progress-bar-animated"],
			inputtype: ToggleInput,
			data: {
				on: "progress-bar-animated",
				off: "",
			}
		}]
});
Vvveb.Components.extend("_base", "Layout/jumbotron", {
	classes: ["jumbotron"],
	image: "icons/jumbotron.svg",
	name: "Jumbotron",
	html: '<div class="jumbotron">\
		  <h1 class="display-3">Hello, world!</h1>\
		  <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>\
		  <hr class="my-4">\
		  <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>\
		  <p class="lead">\
			<a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>\
		  </p>\
		</div>'
});
Vvveb.Components.extend("_base", "Components/navbar", {
	classes: ["navbar"],
	image: "icons/navbar.svg",
	name: "Nav Bar",
	html: '<nav class="navbar navbar-expand-lg navbar-light bg-light">\
		  <a class="navbar-brand" href="#">Navbar</a>\
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">\
			<span class="navbar-toggler-icon"></span>\
		  </button>\
		\
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">\
			<ul class="navbar-nav mr-auto">\
			  <li class="nav-item active">\
				<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>\
			  </li>\
			  <li class="nav-item">\
				<a class="nav-link" href="#">Link</a>\
			  </li>\
			  <li class="nav-item">\
				<a class="nav-link disabled" href="#">Disabled</a>\
			  </li>\
			</ul>\
			<form class="form-inline my-2 my-lg-0">\
			  <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">\
			  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>\
			</form>\
		  </div>\
		</nav>',

	properties: [{
		name: "Color theme",
		key: "color",
		htmlAttr: "class",
		validValues: ["navbar-light", "navbar-dark"],
		inputtype: SelectInput,
		data: {
			options: [{
				value: "",
				text: "Default"
			}, {
				value: "navbar-light",
				text: "Light"
			}, {
				value: "navbar-dark",
				text: "Dark"
			}]
		}
	},{
		name: "Background color",
		key: "background",
		htmlAttr: "class",
		validValues: bgcolorClasses,
		inputtype: SelectInput,
		data: {
			options: bgcolorSelectOptions
		}
	}, {
		name: "Placement",
		key: "placement",
		htmlAttr: "class",
		validValues: ["fixed-top", "fixed-bottom", "sticky-top"],
		inputtype: SelectInput,
		data: {
			options: [{
				value: "",
				text: "Default"
			}, {
				value: "fixed-top",
				text: "Fixed Top"
			}, {
				value: "fixed-bottom",
				text: "Fixed Bottom"
			}, {
				value: "sticky-top",
				text: "Sticky top"
			}]
		}
	}]
});

Vvveb.Components.extend("_base", "Components/form", {
	nodes: ["form"],
	image: "icons/form.svg",
	name: "Form",
	html: '<form><div class="form-group"><label>Text</label><input type="text" class="form-control"></div></div></form>',
	properties: [{
		name: "Style",
		key: "style",
		htmlAttr: "class",
		validValues: ["", "form-search", "form-inline", "form-horizontal"],
		inputtype: SelectInput,
		data: {
			options: [{
				value: "",
				text: "Default"
			}, {
				value: "form-search",
				text: "Search"
			}, {
				value: "form-inline",
				text: "Inline"
			}, {
				value: "form-horizontal",
				text: "Horizontal"
			}]
		}
	}, {
		name: "Action",
		key: "action",
		htmlAttr: "action",
		inputtype: TextInput
	}, {
		name: "Method",
		key: "method",
		htmlAttr: "method",
		inputtype: TextInput
	}]
});

Vvveb.Components.extend("_base", "Components/textinput", {
	name: "Text Input",
	attributes: {"type":"text"},
	image: "icons/text_input.svg",
	html: '<div class="form-group"><label>Text</label><input type="text" class="form-control"></div></div>',
	properties: [{
		name: "Value",
		key: "value",
		htmlAttr: "value",
		inputtype: TextInput
	}, {
		name: "Placeholder",
		key: "placeholder",
		htmlAttr: "placeholder",
		inputtype: TextInput
	}]
});

Vvveb.Components.extend("_base", "Components/selectinput", {
	nodes: ["select"],
	name: "Select Input",
	image: "icons/select_input.svg",
	html: '<div class="form-group"><label>Choose an option </label><select class="form-control"><option value="value1">Text 1</option><option value="value2">Text 2</option><option value="value3">Text 3</option></select></div>',

	beforeInit: function (node)
	{
		properties = [];
		var i = 0;

		$(node).find('option').each(function() {

			data = {"value": this.value, "text": this.text};

			i++;
			properties.push({
				name: "Option " + i,
				key: "option" + i,
				//index: i - 1,
				optionNode: this,
				inputtype: TextValueInput,
				data: data,
				onChange: function(node, value, input) {

					option = $(this.optionNode);

					//if remove button is clicked remove option and render row properties
					if (input.nodeName == 'BUTTON')
					{
						option.remove();
						Vvveb.Components.render("Components/selectinput");
						return node;
					}

					if (input.name == "value") option.attr("value", value);
					else if (input.name == "text") option.text(value);

					return node;
				},
			});
		});

		//remove all option properties
		this.properties = this.properties.filter(function(item) {
			return item.key.indexOf("option") === -1;
		});

		//add remaining properties to generated column properties
		properties.push(this.properties[0]);

		this.properties = properties;
		return node;
	},

	properties: [{
		name: "Option",
		key: "option1",
		inputtype: TextValueInput
	}, {
		name: "Option",
		key: "option2",
		inputtype: TextValueInput
	}, {
		name: "",
		key: "addChild",
		inputtype: ButtonInput,
		data: {text:"Add option"},
		onChange: function(node)
		{
			$(node).append('<option value="value">Text</option>');

			//render component properties again to include the new column inputs
			Vvveb.Components.render("Components/selectinput");

			return node;
		}
	}]
});
Vvveb.Components.extend("_base", "Components/textareainput", {
	name: "Text Area",
	image: "icons/text_area.svg",
	html: '<div class="form-group"><label>Your response:</label><textarea class="form-control"></textarea></div>'
});
Vvveb.Components.extend("_base", "Components/radiobutton", {
	name: "Radio Button",
	attributes: {"type":"radio"},
	image: "icons/radio.svg",
	html: '<label class="radio"><input type="radio"> Radio</label>',
	properties: [{
		name: "Name",
		key: "name",
		htmlAttr: "name",
		inputtype: TextInput
	}]
});
Vvveb.Components.extend("_base", "Components/checkbox", {
	name: "Checkbox",
	attributes: {"type":"checkbox"},
	image: "icons/checkbox.svg",
	html: '<label class="checkbox"><input type="checkbox"> Checkbox</label>',
	properties: [{
		name: "Name",
		key: "name",
		htmlAttr: "name",
		inputtype: TextInput
	}]
});
Vvveb.Components.extend("_base", "Components/fileinput", {
	name: "Input group",
	attributes: {"type":"file"},
	image: "icons/text_input.svg",
	html: '<div class="form-group">\
			  <input type="file" class="form-control">\
			</div>'
});
Vvveb.Components.extend("_base", "Components/table", {
	nodes: ["table"],
	classes: ["table"],
	image: "icons/table.svg",
	name: "Table",
	html: '<table class="table">\
		  <thead>\
			<tr>\
			  <th>#</th>\
			  <th>First Name</th>\
			  <th>Last Name</th>\
			  <th>Username</th>\
			</tr>\
		  </thead>\
		  <tbody>\
			<tr>\
			  <th scope="row">1</th>\
			  <td>Mark</td>\
			  <td>Otto</td>\
			  <td>@mdo</td>\
			</tr>\
			<tr>\
			  <th scope="row">2</th>\
			  <td>Jacob</td>\
			  <td>Thornton</td>\
			  <td>@fat</td>\
			</tr>\
			<tr>\
			  <th scope="row">3</th>\
			  <td>Larry</td>\
			  <td>the Bird</td>\
			  <td>@twitter</td>\
			</tr>\
		  </tbody>\
		</table>',
	properties: [
		{
			name: "Type",
			key: "type",
			htmlAttr: "class",
			validValues: ["table-primary", "table-secondary", "table-success", "table-danger", "table-warning", "table-info", "table-light", "table-dark", "table-white"],
			inputtype: SelectInput,
			data: {
				options: [{
					value: "Default",
					text: ""
				}, {
					value: "table-primary",
					text: "Primary"
				}, {
					value: "table-secondary",
					text: "Secondary"
				}, {
					value: "table-success",
					text: "Success"
				}, {
					value: "table-danger",
					text: "Danger"
				}, {
					value: "table-warning",
					text: "Warning"
				}, {
					value: "table-info",
					text: "Info"
				}, {
					value: "table-light",
					text: "Light"
				}, {
					value: "table-dark",
					text: "Dark"
				}, {
					value: "table-white",
					text: "White"
				}]
			}
		},
		{
			name: "Responsive",
			key: "responsive",
			htmlAttr: "class",
			validValues: ["table-responsive"],
			inputtype: ToggleInput,
			data: {
				on: "table-responsive",
				off: ""
			}
		},
		{
			name: "Small",
			key: "small",
			htmlAttr: "class",
			validValues: ["table-sm"],
			inputtype: ToggleInput,
			data: {
				on: "table-sm",
				off: ""
			}
		},
		{
			name: "Hover",
			key: "hover",
			htmlAttr: "class",
			validValues: ["table-hover"],
			inputtype: ToggleInput,
			data: {
				on: "table-hover",
				off: ""
			}
		},
		{
			name: "Bordered",
			key: "bordered",
			htmlAttr: "class",
			validValues: ["table-bordered"],
			inputtype: ToggleInput,
			data: {
				on: "table-bordered",
				off: ""
			}
		},
		{
			name: "Striped",
			key: "striped",
			htmlAttr: "class",
			validValues: ["table-striped"],
			inputtype: ToggleInput,
			data: {
				on: "table-striped",
				off: ""
			}
		},
		{
			name: "Inverse",
			key: "inverse",
			htmlAttr: "class",
			validValues: ["table-inverse"],
			inputtype: ToggleInput,
			data: {
				on: "table-inverse",
				off: ""
			}
		},
		{
			name: "Head options",
			key: "head",
			htmlAttr: "class",
			child:"thead",
			inputtype: SelectInput,
			validValues: ["", "thead-inverse", "thead-default"],
			data: {
				options: [{
					value: "",
					text: "None"
				}, {
					value: "thead-default",
					text: "Default"
				}, {
					value: "thead-inverse",
					text: "Inverse"
				}]
			}
		}]
});
Vvveb.Components.extend("_base", "Components/tablerow", {
	nodes: ["tr"],
	name: "Table Row",
	html: "<tr><td>Cell 1</td><td>Cell 2</td><td>Cell 3</td></tr>",
	properties: [{
		name: "Type",
		key: "type",
		htmlAttr: "class",
		inputtype: SelectInput,
		validValues: ["", "success", "danger", "warning", "active"],
		data: {
			options: [{
				value: "",
				text: "Default"
			}, {
				value: "success",
				text: "Success"
			}, {
				value: "error",
				text: "Error"
			}, {
				value: "warning",
				text: "Warning"
			}, {
				value: "active",
				text: "Active"
			}]
		}
	}]
});
Vvveb.Components.extend("_base", "Components/tablecell", {
	nodes: ["td"],
	name: "Table Cell",
	html: "<td>Cell</td>"
});
Vvveb.Components.extend("_base", "Components/tableheadercell", {
	nodes: ["th"],
	name: "Table Header Cell",
	html: "<th>Head</th>"
});
Vvveb.Components.extend("_base", "Components/tablehead", {
	nodes: ["thead"],
	name: "Table Head",
	html: "<thead><tr><th>Head 1</th><th>Head 2</th><th>Head 3</th></tr></thead>",
	properties: [{
		name: "Type",
		key: "type",
		htmlAttr: "class",
		inputtype: SelectInput,
		validValues: ["", "success", "danger", "warning", "info"],
		data: {
			options: [{
				value: "",
				text: "Default"
			}, {
				value: "success",
				text: "Success"
			}, {
				value: "anger",
				text: "Error"
			}, {
				value: "warning",
				text: "Warning"
			}, {
				value: "info",
				text: "Info"
			}]
		}
	}]
});
Vvveb.Components.extend("_base", "Components/tablebody", {
	nodes: ["tbody"],
	name: "Table Body",
	html: "<tbody><tr><td>Cell 1</td><td>Cell 2</td><td>Cell 3</td></tr></tbody>"
});

Vvveb.Components.add("Layout/gridcolumn", {
	name: "Grid Column",
	image: "icons/grid_row.svg",
	classesRegex: ["col-"],
	html: '<div class="col-sm-4"><h3>col-sm-4</h3></div>',
	properties: [{
		name: "Column",
		key: "column",
		inputtype: GridInput,
		data: {hide_remove:true},

		beforeInit: function(node) {
			_class = $(node).attr("class");

			var reg = /col-([^-\$ ]*)?-?(\d+)/g;
			var match;

			while ((match = reg.exec(_class)) != null) {
				this.data["col" + ((match[1] != undefined)?"_" + match[1]:"")] = match[2];
			}
		},

		onChange: function(node, value, input) {
			_class = node.attr("class");

			//remove previous breakpoint column size
			_class = _class.replace(new RegExp(input.name + '-\\d+?'), '');
			//add new column size
			if (value) _class +=  ' ' + input.name + '-' + value;
			node.attr("class", _class);

			return node;
		},
	}]
});
Vvveb.Components.add("Layout/gridrow", {
	name: "Grid Row(4:4:4)",
	image: "icons/custom/icon_03_05_444grid.svg",
	classes: ["row"],
	html: '<div class="gridrow row"><div class="gridrow-col gridrow-nocontent col-4"></div><div class="gridrow-col gridrow-nocontent col-4"></div><div class="gridrow-col gridrow-nocontent col-4"></div></div>',

	beforeInit: function (node)
	{
		properties = [];
		var i = 0;
		var j = 0;

		$(node).find('[class*="col"]').each(function() {
			_class = $(this).attr("class");

			var reg = /col([^-\$ ]*)?-?(\d+)/g;
			var match;
			data = {};

			while ((match = reg.exec(_class)) != null) {
				data["col" + ((match[1] != undefined)?"_" + match[1]:"")] = match[2];
			}

			i++;
			properties.push({
				name: "Column " + i,
				key: "column" + i,
				//index: i - 1,
				columnNode: this,
				inline:true,
				inputtype: GridInput,
				data: data,
				onChange: function(node, value, input) {

					//column = $('[class*="col-"]:eq(' + this.index + ')', node);
					column = $(this.columnNode);

					//if remove button is clicked remove column and render row properties
					if (input.nodeName == 'BUTTON')
					{
						column.remove();
						Vvveb.Components.render("Layout/gridrow");
						return node;
					}

					//if select input then change column class
					_class = column.attr("class");

					//remove previous breakpoint column size
					_class = _class.replace(new RegExp(input.name + '-\\d+?'), '');
					//add new column size
					if (value) _class +=  ' ' + input.name + '-' + value;
					else _class += 'col';
					column.attr("class", _class);

					return node;
				},
			});
		});

		//remove all column properties
		this.properties = this.properties.filter(function(item) {
			return item.key.indexOf("column") === -1;
		});

		//add remaining properties to generated column properties
		properties.push(this.properties[0]);

		this.properties = properties;
		return node;
	},

	properties: [{
		name: "Column",
		key: "column1",
		inputtype: GridInput
	}, {
		name: "Column",
		key: "column1",
		inline:true,
		col:12,
		inputtype: GridInput
	}, {
		name: "",
		key: "addChild",
		inputtype: ButtonInput,
		data: {text:"Add column"},
		onChange: function(node)
		{
			$(node).append('<div class="gridrow-col gridrow-nocontent col-4"></div>');

			//render component properties again to include the new column inputs
			Vvveb.Components.render("Layout/gridrow");

			return node;
		}
	}]
});


Vvveb.Components.add("Layout/gridrow-12", {
	name: "Grid Row(12)",
	image: "icons/custom/icon_03_01_12grid.svg",
	html: '<div class="gridrow row"><div class="gridrow-col gridrow-nocontent col-12"></div></div>'
});
Vvveb.Components.add("Layout/gridrow-66", {
	name: "Grid Row(6:6)",
	image: "icons/custom/icon_03_02_66grid.svg",
	html: '<div class="gridrow row"><div class="gridrow-col gridrow-nocontent col-6"></div><div class="gridrow-col gridrow-nocontent col-6"></div></div>'
});
Vvveb.Components.add("Layout/gridrow-39", {
	name: "Grid Row(3:9)",
	image: "icons/custom/icon_03_07_39grid.svg",
	html: '<div class="gridrow row"><div class="gridrow-col gridrow-nocontent col-3"></div><div class="gridrow-col gridrow-nocontent col-9"></div></div>'
});
Vvveb.Components.add("Layout/gridrow-93", {
	name: "Grid Row(9:3)",
	image: "icons/custom/icon_03_06_93grid.svg",
	html: '<div class="gridrow row"><div class="gridrow-col gridrow-nocontent col-9"></div><div class="gridrow-col gridrow-nocontent col-3"></div></div>'
});
Vvveb.Components.add("Layout/gridrow-48", {
	name: "Grid Row(4:8)",
	image: "icons/custom/icon_03_03_48grid.svg",
	html: '<div class="gridrow row"><div class="gridrow-col gridrow-nocontent col-4"></div><div class="gridrow-col gridrow-nocontent col-8"></div></div>'
});
Vvveb.Components.add("Layout/gridrow-84", {
	name: "Grid Row(8:4)",
	image: "icons/custom/icon_03_04_84grid.svg",
	html: '<div class="gridrow row"><div class="gridrow-col gridrow-nocontent col-8"></div><div class="gridrow-col gridrow-nocontent col-4"></div></div>'
});
Vvveb.Components.add("Layout/panel", {
	name: "Panel",
	image: "icons/custom/icon_04_panel.svg",
	html: '<div class="panel panel-default">\n' +
			'  <div class="panel-heading"></div>\n' +
			'  <div class="panel-body"></div>\n' +
			'</div>'
});

Vvveb.Components.extend("_base", "Components/image", {
	nodes: ["img"],
	name: "Image",
	html: '<img class="image" src="'+Vvveb.baseUrl+'icons/image.svg" height="128" width="128" data-file-type="" data-file-path="'+Vvveb.baseUrl+'icons/image.svg" >',
	dragStart: function (node)
	{
		var body = Vvveb.Builder.frameBody;
		if ($("#image-script", body).length == 0)
		{
			$(body).append(
				"<script id='image-script' type='text/javascript'>\
				$(document).ready(function() {\
					$('.image').each(function (index) {\
						var path = this.dataset.fileType + this.dataset.filePath;\
						$(this).attr('src', path);\
					});\
				});\
				</script>"
			);
		}
		return node;
	},
	image: "icons/image.svg",
	properties: [{
		name: "Alt",
		key: "alt",
		htmlAttr: "alt",
		sort: 1,
		inputtype: TextInput
	}, {
		name: "Width",
		key: "width",
		htmlAttr: "width",
		sort: 2,
		inputtype: TextInput
	}, {
		name: "Height",
		key: "height",
		htmlAttr: "height",
		sort: 3,
		inputtype: TextInput
	}, {
		name: "File Type",
		key: "fileType",
		sort: 4,
		inputtype: SelectInput,
		data:{
			options: [{
				text: "Final Path",
				value: "{{finalPath}}"
			}, {
				text: "Meta Path",
				value: "{{metaPath}}"
			}, {
				text: "Another",
				value: ""
			}]
		},
		init: function(node) {
		},
		onChange: function(node, value, input, component) {
			node.attr('data-file-type', value);
			return node;
		}
	}, {
		name: "Image",
		key: "src",
		htmlAttr: "src",
		sort: 5,
		inputtype: FileUploadInput,
		init: function(node) {
		},
		onChange: function(node, value, input, component) {
			node.attr('data-file-path', value);
			return node;
		}
	}]
});


Vvveb.Components.extend("_base", "Components/video", {
	name: "Video",
	attributes: ["data-component-video"],
	image: "icons/video.svg",
	dragHtml: '<img src="' + Vvveb.baseUrl + 'icons/video.svg" width="100" height="100">', //use image for drag and swap with iframe on drop for drag performance
	html: '<div data-component-video style="min-height:240px;min-width:240px;position:relative"><iframe frameborder="0" src="https://www.youtube.com/embed/-stFvGmg1A8" style="width:100%;height:100%;position:absolute;left:0px;pointer-events:none"></iframe></div>',


	//url parameters set with onChange
	t:'y',//video type
	video_id:'',//video id
	url: '', //html5 video src
	autoplay: false,
	controls: true,
	loop: false,

	init: function (node)
	{
		iframe = jQuery('iframe', node);
		video = jQuery('video', node);

		$("#right-panel [data-key=url]").hide();

		//check if html5
		if (video.length)
		{
			this.url = video.src;
		} else if (iframe.length) //vimeo or youtube
		{
			src = iframe.attr("src");

			if (src && src.indexOf("youtube"))//youtube
			{
				this.video_id = src.match(/youtube.com\/embed\/([^$\?]*)/)[1];
			} else if (src && src.indexOf("vimeo"))//youtube
			{
				this.video_id = src.match(/vimeo.com\/video\/([^$\?]*)/)[1];
			}
		}

		$("#right-panel input[name=video_id]").val(this.video_id);
		$("#right-panel input[name=url]").val(this.url);
	},

	onChange: function (node, property, value)
	{
		this[property.key] = value;

		//if (property.key == "t")
		// {
			switch (this.t)
			{
				case 'y':
					$("#right-panel [data-key=video_id]").show();
					$("#right-panel [data-key=url]").hide();
					newnode = $('<div data-component-video><iframe src="https://www.youtube.com/embed/' + this.video_id + '?&amp;autoplay=' + this.autoplay + '&amp;controls=' + this.controls + '&amp;loop=' + this.loop + '" allowfullscreen="true" style="height: 100%; width: 100%;" frameborder="0"></iframe></div>');
					break;
				case 'v':
					$("#right-panel [data-key=video_id]").show();
					$("#right-panel [data-key=url]").hide();
					newnode = $('<div data-component-video><iframe src="https://player.vimeo.com/video/' + this.video_id + '?&amp;autoplay=' + this.autoplay + '&amp;controls=' + this.controls + '&amp;loop=' + this.loop + '" allowfullscreen="true" style="height: 100%; width: 100%;" frameborder="0"></iframe></div>');
					break;
				case 'h':
					$("#right-panel [data-key=video_id]").hide();
					$("#right-panel [data-key=url]").show();
					newnode = $('<div data-component-video><video src="' + this.url + '" ' + (this.controls?' controls ':'') + (this.loop?' loop ':'') + ' style="height: 100%; width: 100%;"></video></div>');
					break;
				case 'finalPath':
					$("#right-panel [data-key=video_id]").hide();
					$("#right-panel [data-key=url]").show();
					newnode = $('<div data-component-video><video src="{{finalPath}}' + this.url + '" ' + (this.controls?' controls ':'') + (this.loop?' loop ':'') + ' style="height: 100%; width: 100%;"></video></div>');
					break;
				case 'metaPath':
					$("#right-panel [data-key=video_id]").hide();
					$("#right-panel [data-key=url]").show();
					newnode = $('<div data-component-video><video src="{{metaPath}}' + this.url + '" ' + (this.controls?' controls ':'') + (this.loop?' loop ':'') + ' style="height: 100%; width: 100%;"></video></div>');
					break;
			}

			node.replaceWith(newnode);
			return newnode;
		// }
		return node;
	},

	properties: [{
		name: "Provider",
		key: "t",
		inputtype: SelectInput,
		data:{
			options: [{
					text: "Youtube",
					value: "y"
				}, {
					text: "Vimeo",
					value: "v"
				},{
					text: "HTML5",
					value: "h"
				},{
					text: "Final Path",
					value: "finalPath"
				},{
					text: "Meta Path",
					value: "metaPath"
				}]
			}
		},{
			name: "Video id",
			key: "video_id",
			inputtype: TextInput
		},{
			name: "Url",
			key: "url",
			inputtype: TextInput
		},{
			name: "Autoplay",
			key: "autoplay",
			inputtype: CheckboxInput
		},{
			name: "Controls",
			key: "controls",
			inputtype: CheckboxInput
		},{
			name: "Loop",
			key: "loop",
			inputtype: CheckboxInput
		}]
});




Vvveb.Components.extend("_base", "Components/table-normal", {
	// nodes: ["table"],
	// classes: ["table","table_01"],
	attributes: ['table-normal'],
	image: "icons/custom/icon_12_01_normal.table.svg",
	name: "Normal Table",
	html: '<table table-normal class="table table_01" data-row="3" data-col="4">\
		  <thead>\
			<tr>\
			  <th></th>\
			  <th></th>\
			  <th></th>\
			  <th></th>\
			</tr>\
		  </thead>\
		  <tbody>\
			<tr>\
			  <td></td>\
			  <td></td>\
			  <td></td>\
			  <td></td>\
			</tr>\
			<tr>\
			  <td></td>\
			  <td></td>\
			  <td></td>\
			  <td></td>\
			</tr>\
			<tr>\
			  <td></td>\
			  <td></td>\
			  <td></td>\
			  <td></td>\
			</tr>\
		  </tbody>\
		</table>',

	onChange: function (node, property, value)
	{
		node.data(property.key, value);
		var row = node.data('row');
		var col = node.data('col');

		var tbody = node.find('tbody'), thead = node.find('thead');
		if(property.key=='row'){
			if (tbody.children().length <= row) {
				//add row
				for(var i=tbody.children().length; i<row; i++){
					var new_tr = tbody.find('tr:last-child').clone();
					new_tr.find('td').text('');
					tbody.append(new_tr);
				}
			}else{
				//remove row
				for(var i=tbody.children().length; i>=row; i--){
					tbody.find('tr:eq('+i+')').remove();
				}
			}
		}else if(property.key=='col'){
			if (tbody.find('tr:eq(0) td').length <= col) {
				//add col
				for(var i=tbody.find('tr:eq(0) td').length; i<col; i++){
					thead.find('th:last-child').after('<th></th>');
					tbody.find('td:last-child').after('<td></td>');
				}
			}else{
				//remove col
				for(var i=tbody.find('tr:eq(0) td').length; i>col; i--){
					thead.find('th:last-child').remove();
					tbody.find('td:last-child').remove();
				}
			}
		}
		return node;
	},

	properties: [
		{
			name: "Row Count",
			key: "row",
			htmlAttr: "data-row",
			sort: 1,
			inputtype: NumberInput,
			data: {
				step: "1",
				min:1
			}
		},
		{
			name: "Col Count",
			key: "col",
			htmlAttr: "data-col",
			sort: 2,
			inputtype: NumberInput,
			data: {
				step: "1",
				min:1
			}
		}
	]
});


Vvveb.Components.extend("_base", "Components/table-non-border", {
	// nodes: ["table"],
	// classes: ["table", "table_02"],
	attributes: ['data-table-non-border'],
	image: "icons/custom/icon_12_02_non.border.table.svg",
	name: "Non-border Table",
	html: '<table data-table-non-border class="table table-bordered table_02" data-row="2" data-col="2">\
		  <tbody>\
			<tr>\
			  <th></th>\
			  <th></th>\
			</tr>\
			<tr>\
			  <td></td>\
			  <td></td>\
			</tr>\
			<tr>\
			  <th></th>\
			  <th></th>\
			</tr>\
			<tr>\
			  <td></td>\
			  <td></td>\
			</tr>\
		  </tbody>\
		</table>',

	onChange: function (node, property, value)
	{
		node.data(property.key, value);
		var row = node.data('row');
		var col = node.data('col');

		var tbody = node.find('tbody'), thead = node.find('thead');
		if(property.key=='row'){
			if (tbody.children().length/2 <= row) {
				//add row
				for(var i=tbody.children().length/2; i<row; i++){
					var new_tr1 = tbody.find('tr:last-child').prev().clone();
					var new_tr2 = tbody.find('tr:last-child').clone();
					tbody.append(new_tr1).append(new_tr2);
				}
			}else{
				//remove row
				for(var i=tbody.children().length/2; i>=row; i--){
					tbody.find('tr:eq('+i+')').remove();
				}
			}
		}else if(property.key=='col'){
			if (tbody.find('tr:eq(0) th').length <= col) {
				//add col
				for(var i=tbody.find('tr:eq(0) th').length; i<col; i++){
					tbody.find('th:last-child').after('<th></th>');
					tbody.find('td:last-child').after('<td></td>');
				}
			}else{
				//remove col
				for(var i=tbody.find('tr:eq(0) th').length; i>col; i--){
					tbody.find('th:last-child').remove();
					tbody.find('td:last-child').remove();
				}
			}
		}
		return node;
	},

	properties: [
		{
			name: "Row Count",
			key: "row",
			htmlAttr: "data-row",
			sort: 1,
			inputtype: NumberInput,
			data: {
				step: "1",
				min:1
			}
		},
		{
			name: "Col Count",
			key: "col",
			htmlAttr: "data-col",
			sort: 2,
			inputtype: NumberInput,
			data: {
				step: "1",
				min:1
			}
		}
	]
});


Vvveb.Components.add("Components/table-coordinate", {
	attributes: ['data-table-coordinate'],
	image: "icons/custom/icon_12_03_coordinate.table.svg",
	name: "Coordinate Table",
	html: '<div data-table-coordinate class="table-coordinate">\
				<div style="width:100%; height:270px; background-color: #eeeeee; pointer-events:none;">\
					Coordinate table is visible when you preview\
				</div>\
			</div>',

	dragStart: function (node)
	{
		var body = Vvveb.Builder.frameBody;
		
		if ($(".table-coordinate-script", body).length == 0)
		{
            $(body).append("<script class='table-coordinate-script' src='/SDR_base-portlet/designer/plugin/components-coordinate-script.js' type='text/javascript'></script>");
			$(body).append(
				"<script class='table-coordinate-script' type='text/javascript'>\
				$(document).ready(function() {\
					$('.table-coordinate').each(function (index) {\
						$(this).attr('id','coordinate_'+index);\
						if(!this.dataset.metadata) {$('#coordinate_'+index).html(\"There was an error in the metadata and no coordinate table was created.\");return;}\
						var metadata = JSON.parse('{ \"metadata\": '+this.dataset.metadata+'}');\
                        var title = $(this).data('title');\
						var column = $(this).data('column');\
                        coord.init(metadata,title,column,index);\
					});\
				});\
				</script>"
			);
		}

		return node;
	},
	
	properties: [
		{
			name: "Metadata *",
			key: "metadata",
			htmlAttr: "data-metadata",
			sort: 1,
			inputtype: TextInput,
            onChange: function(node, value, input, component) {
                node.attr('data-metadata', '{{dm.'+value+'}}');
                coord.coordinateValue = value;
                return node;
            },
            init: function(node){
                this.node = node;
                return coord.coordinateValue;
            }
		},
		{
			name: "Title",
			key: "title",
			htmlAttr: "data-title",
			sort: 2,
			inputtype: TextInput
		},
		{
			name: "Column",
			key: "column",
			htmlAttr: "data-column",
			sort: 3,
			inputtype: TextInput
		}
	]
});
