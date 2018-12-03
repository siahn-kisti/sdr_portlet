(function webpackUniversalModuleDefinition(root, factory) {
	if(typeof exports === 'object' && typeof module === 'object')
		module.exports = factory();
	else if(typeof define === 'function' && define.amd)
		define([], factory);
	else {
		var a = factory();
		for(var i in a) (typeof exports === 'object' ? exports : root)[i] = a[i];
	}
})(typeof self !== 'undefined' ? self : this, function() {
return /******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 992);
/******/ })
/************************************************************************/
/******/ ({

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function(global) {

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.EVENT_ABORT = exports.TYPED_ARRAYS = exports.VOID = undefined;

var _slicedToArray = function () { function sliceIterator(arr, i) { var _arr = []; var _n = true; var _d = false; var _e = undefined; try { for (var _i = arr[Symbol.iterator](), _s; !(_n = (_s = _i.next()).done); _n = true) { _arr.push(_s.value); if (i && _arr.length === i) break; } } catch (err) { _d = true; _e = err; } finally { try { if (!_n && _i["return"]) _i["return"](); } finally { if (_d) throw _e; } } return _arr; } return function (arr, i) { if (Array.isArray(arr)) { return arr; } else if (Symbol.iterator in Object(arr)) { return sliceIterator(arr, i); } else { throw new TypeError("Invalid attempt to destructure non-iterable instance"); } }; }();

var _typeof = typeof Symbol === "function" && typeof Symbol.iterator === "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : typeof obj; };

exports.setLoggerFunction = setLoggerFunction;
exports.vtkLogMacro = vtkLogMacro;
exports.vtkInfoMacro = vtkInfoMacro;
exports.vtkDebugMacro = vtkDebugMacro;
exports.vtkErrorMacro = vtkErrorMacro;
exports.vtkWarningMacro = vtkWarningMacro;
exports.capitalize = capitalize;
exports.formatBytesToProperUnit = formatBytesToProperUnit;
exports.formatNumbersWithThousandSeparator = formatNumbersWithThousandSeparator;
exports.obj = obj;
exports.get = get;
exports.set = set;
exports.setGet = setGet;
exports.getArray = getArray;
exports.setArray = setArray;
exports.setGetArray = setGetArray;
exports.algo = algo;
exports.event = event;
exports.newInstance = newInstance;
exports.chain = chain;
exports.isVtkObject = isVtkObject;
exports.traverseInstanceTree = traverseInstanceTree;
exports.debounce = debounce;
exports.throttle = throttle;
exports.keystore = keystore;
exports.proxy = proxy;
exports.proxyPropertyMapping = proxyPropertyMapping;
exports.proxyPropertyState = proxyPropertyState;

var _vtk = __webpack_require__(52);

var _vtk2 = _interopRequireDefault(_vtk);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

function _toConsumableArray(arr) { if (Array.isArray(arr)) { for (var i = 0, arr2 = Array(arr.length); i < arr.length; i++) { arr2[i] = arr[i]; } return arr2; } else { return Array.from(arr); } }

var globalMTime = 0;

var VOID = exports.VOID = Symbol('void');

function getCurrentGlobalMTime() {
  return globalMTime;
}

// ----------------------------------------------------------------------------
// Logging function calls
// ----------------------------------------------------------------------------
/* eslint-disable no-prototype-builtins                                      */

var fakeConsole = {};

function noOp() {}

var consoleMethods = ['log', 'debug', 'info', 'warn', 'error', 'time', 'timeEnd', 'group', 'groupEnd'];
consoleMethods.forEach(function (methodName) {
  fakeConsole[methodName] = noOp;
});

global.console = console.hasOwnProperty('log') ? console : fakeConsole;

var loggerFunctions = {
  debug: noOp, // Don't print debug by default
  error: global.console.error || noOp,
  info: global.console.info || noOp,
  log: global.console.log || noOp,
  warn: global.console.warn || noOp
};

function setLoggerFunction(name, fn) {
  if (loggerFunctions[name]) {
    loggerFunctions[name] = fn || noOp;
  }
}

function vtkLogMacro() {
  loggerFunctions.log.apply(loggerFunctions, arguments);
}

function vtkInfoMacro() {
  loggerFunctions.info.apply(loggerFunctions, arguments);
}

function vtkDebugMacro() {
  loggerFunctions.debug.apply(loggerFunctions, arguments);
}

function vtkErrorMacro() {
  loggerFunctions.error.apply(loggerFunctions, arguments);
}

function vtkWarningMacro() {
  loggerFunctions.warn.apply(loggerFunctions, arguments);
}

// ----------------------------------------------------------------------------
// TypedArray
// ----------------------------------------------------------------------------

var TYPED_ARRAYS = exports.TYPED_ARRAYS = {
  Float32Array: Float32Array,
  Float64Array: Float64Array,
  Uint8Array: Uint8Array,
  Int8Array: Int8Array,
  Uint16Array: Uint16Array,
  Int16Array: Int16Array,
  Uint32Array: Uint32Array,
  Int32Array: Int32Array
};

// ----------------------------------------------------------------------------
// capitilze provided string
// ----------------------------------------------------------------------------

function capitalize(str) {
  return str.charAt(0).toUpperCase() + str.slice(1);
}

// ----------------------------------------------------------------------------
// Convert byte size into a well formatted string
// ----------------------------------------------------------------------------

function formatBytesToProperUnit(size) {
  var precision = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 2;
  var chunkSize = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : 1000;

  var units = ['TB', 'GB', 'MB', 'KB'];
  var value = Number(size);
  var currentUnit = 'B';
  while (value > chunkSize) {
    value /= chunkSize;
    currentUnit = units.pop();
  }
  return value.toFixed(precision) + ' ' + currentUnit;
}
// ----------------------------------------------------------------------------
// Convert thousand number with proper seperator
// ----------------------------------------------------------------------------

function formatNumbersWithThousandSeparator(n) {
  var separator = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : ' ';

  var sections = [];
  var size = n;
  while (size > 1000) {
    sections.push(('000' + size % 1000).slice(-3));
    size = Math.floor(size / 1000);
  }
  if (size > 0) {
    sections.push(size);
  }
  sections.reverse();
  return sections.join(separator);
}

// ----------------------------------------------------------------------------
// Array helper
// ----------------------------------------------------------------------------

function safeArrays(model) {
  Object.keys(model).forEach(function (key) {
    if (Array.isArray(model[key])) {
      model[key] = [].concat(model[key]);
    }
  });
}

// ----------------------------------------------------------------------------

function enumToString(e, value) {
  return Object.keys(e).find(function (key) {
    return e[key] === value;
  });
}

function getStateArrayMapFunc(item) {
  if (item.isA) {
    return item.getState();
  }
  return item;
}

// ----------------------------------------------------------------------------
// vtkObject: modified(), onModified(callback), delete()
// ----------------------------------------------------------------------------

function obj() {
  var publicAPI = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {};
  var model = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : {};

  // Ensure each instance as a unique ref of array
  safeArrays(model);

  var callbacks = [];
  model.mtime = Number.isInteger(model.mtime) ? model.mtime : ++globalMTime;
  model.classHierarchy = ['vtkObject'];

  function off(index) {
    callbacks[index] = null;
  }

  function on(index) {
    function unsubscribe() {
      off(index);
    }
    return Object.freeze({
      unsubscribe: unsubscribe
    });
  }

  publicAPI.isDeleted = function () {
    return !!model.deleted;
  };

  publicAPI.modified = function (otherMTime) {
    if (model.deleted) {
      vtkErrorMacro('instance deleted - cannot call any method');
      return;
    }

    if (otherMTime && otherMTime < model.mtime) {
      return;
    }

    model.mtime = ++globalMTime;
    callbacks.forEach(function (callback) {
      return callback && callback(publicAPI);
    });
  };

  publicAPI.onModified = function (callback) {
    if (model.deleted) {
      vtkErrorMacro('instance deleted - cannot call any method');
      return null;
    }

    var index = callbacks.length;
    callbacks.push(callback);
    return on(index);
  };

  publicAPI.getMTime = function () {
    return model.mtime;
  };

  publicAPI.isA = function (className) {
    var count = model.classHierarchy.length;
    // we go backwards as that is more likely for
    // early termination
    while (count--) {
      if (model.classHierarchy[count] === className) {
        return true;
      }
    }
    return false;
  };

  publicAPI.getClassName = function () {
    var depth = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 0;
    return model.classHierarchy[model.classHierarchy.length - 1 - depth];
  };

  publicAPI.set = function () {
    var map = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {};
    var noWarning = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : false;
    var noFunction = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : false;

    var ret = false;
    Object.keys(map).forEach(function (name) {
      var fn = noFunction ? null : publicAPI['set' + capitalize(name)];
      if (fn && Array.isArray(map[name])) {
        ret = fn.apply(undefined, _toConsumableArray(map[name])) || ret;
      } else if (fn) {
        ret = fn(map[name]) || ret;
      } else {
        // Set data on model directly
        if (['mtime'].indexOf(name) === -1 && !noWarning) {
          vtkWarningMacro('Warning: Set value to model directly ' + name + ', ' + map[name]);
        }
        model[name] = map[name];
        ret = true;
      }
    });
    return ret;
  };

  publicAPI.get = function () {
    for (var _len = arguments.length, list = Array(_len), _key = 0; _key < _len; _key++) {
      list[_key] = arguments[_key];
    }

    if (!list.length) {
      return model;
    }
    var subset = {};
    list.forEach(function (name) {
      subset[name] = model[name];
    });
    return subset;
  };

  publicAPI.getReferenceByName = function (val) {
    return model[val];
  };

  publicAPI.delete = function () {
    Object.keys(model).forEach(function (field) {
      return delete model[field];
    });
    callbacks.forEach(function (el, index) {
      return off(index);
    });

    // Flag the instance being deleted
    model.deleted = true;
  };

  // Add serialization support
  publicAPI.getState = function () {
    var jsonArchive = Object.assign({}, model, {
      vtkClass: publicAPI.getClassName()
    });

    // Convert every vtkObject to its serializable form
    Object.keys(jsonArchive).forEach(function (keyName) {
      if (jsonArchive[keyName] === null || jsonArchive[keyName] === undefined) {
        delete jsonArchive[keyName];
      } else if (jsonArchive[keyName].isA) {
        jsonArchive[keyName] = jsonArchive[keyName].getState();
      } else if (Array.isArray(jsonArchive[keyName])) {
        jsonArchive[keyName] = jsonArchive[keyName].map(getStateArrayMapFunc);
      }
    });

    // Sort resulting object by key name
    var sortedObj = {};
    Object.keys(jsonArchive).sort().forEach(function (name) {
      sortedObj[name] = jsonArchive[name];
    });

    // Remove mtime
    if (sortedObj.mtime) {
      delete sortedObj.mtime;
    }

    return sortedObj;
  };

  // Add shallowCopy(otherInstance) support
  publicAPI.shallowCopy = function (other) {
    var debug = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : false;

    if (other.getClassName() !== publicAPI.getClassName()) {
      throw new Error('Cannot ShallowCopy ' + other.getClassName() + ' into ' + publicAPI.getClassName());
    }
    var otherModel = other.get();

    var keyList = Object.keys(model).sort();
    var otherKeyList = Object.keys(otherModel).sort();

    otherKeyList.forEach(function (key) {
      var keyIdx = keyList.indexOf(key);
      if (keyIdx === -1) {
        if (debug) {
          vtkDebugMacro('add ' + key + ' in shallowCopy');
        }
      } else {
        keyList.splice(keyIdx, 1);
      }
      model[key] = otherModel[key];
    });
    if (keyList.length && debug) {
      vtkDebugMacro('Untouched keys: ' + keyList.join(', '));
    }

    publicAPI.modified();
  };

  // Allow usage as decorator
  return publicAPI;
}

// ----------------------------------------------------------------------------
// getXXX: add getters
// ----------------------------------------------------------------------------

function get(publicAPI, model, fieldNames) {
  fieldNames.forEach(function (field) {
    if ((typeof field === 'undefined' ? 'undefined' : _typeof(field)) === 'object') {
      publicAPI['get' + capitalize(field.name)] = function () {
        return model[field.name];
      };
    } else {
      publicAPI['get' + capitalize(field)] = function () {
        return model[field];
      };
    }
  });
}

// ----------------------------------------------------------------------------
// setXXX: add setters
// ----------------------------------------------------------------------------

var objectSetterMap = {
  enum: function _enum(publicAPI, model, field) {
    return function (value) {
      if (typeof value === 'string') {
        if (field.enum[value] !== undefined) {
          if (model[field.name] !== field.enum[value]) {
            model[field.name] = field.enum[value];
            publicAPI.modified();
            return true;
          }
          return false;
        }
        vtkErrorMacro('Set Enum with invalid argument ' + field + ', ' + value);
        throw new RangeError('Set Enum with invalid string argument');
      }
      if (typeof value === 'number') {
        if (model[field.name] !== value) {
          if (Object.keys(field.enum).map(function (key) {
            return field.enum[key];
          }).indexOf(value) !== -1) {
            model[field.name] = value;
            publicAPI.modified();
            return true;
          }
          vtkErrorMacro('Set Enum outside numeric range ' + field + ', ' + value);
          throw new RangeError('Set Enum outside numeric range');
        }
        return false;
      }
      vtkErrorMacro('Set Enum with invalid argument (String/Number) ' + field + ', ' + value);
      throw new TypeError('Set Enum with invalid argument (String/Number)');
    };
  }
};

function findSetter(field) {
  if ((typeof field === 'undefined' ? 'undefined' : _typeof(field)) === 'object') {
    var fn = objectSetterMap[field.type];
    if (fn) {
      return function (publicAPI, model) {
        return fn(publicAPI, model, field);
      };
    }

    vtkErrorMacro('No setter for field ' + field);
    throw new TypeError('No setter for field');
  }
  return function getSetter(publicAPI, model) {
    return function setter(value) {
      if (model.deleted) {
        vtkErrorMacro('instance deleted - cannot call any method');
        return false;
      }

      if (model[field] !== value) {
        model[field] = value;
        publicAPI.modified();
        return true;
      }
      return false;
    };
  };
}

function set(publicAPI, model, fields) {
  fields.forEach(function (field) {
    if ((typeof field === 'undefined' ? 'undefined' : _typeof(field)) === 'object') {
      publicAPI['set' + capitalize(field.name)] = findSetter(field)(publicAPI, model);
    } else {
      publicAPI['set' + capitalize(field)] = findSetter(field)(publicAPI, model);
    }
  });
}

// ----------------------------------------------------------------------------
// set/get XXX: add both setters and getters
// ----------------------------------------------------------------------------

function setGet(publicAPI, model, fieldNames) {
  get(publicAPI, model, fieldNames);
  set(publicAPI, model, fieldNames);
}

// ----------------------------------------------------------------------------
// getXXX: add getters for object of type array with copy to be safe
// getXXXByReference: add getters for object of type array without copy
// ----------------------------------------------------------------------------

function getArray(publicAPI, model, fieldNames) {
  fieldNames.forEach(function (field) {
    publicAPI['get' + capitalize(field)] = function () {
      return [].concat(model[field]);
    };
    publicAPI['get' + capitalize(field) + 'ByReference'] = function () {
      return model[field];
    };
  });
}

// ----------------------------------------------------------------------------
// setXXX: add setter for object of type array
// if 'defaultVal' is supplied, shorter arrays will be padded to 'size' with 'defaultVal'
// set...From: fast path to copy the content of an array to the current one without call to modified.
// ----------------------------------------------------------------------------

function setArray(publicAPI, model, fieldNames, size) {
  var defaultVal = arguments.length > 4 && arguments[4] !== undefined ? arguments[4] : undefined;

  fieldNames.forEach(function (field) {
    publicAPI['set' + capitalize(field)] = function () {
      for (var _len2 = arguments.length, args = Array(_len2), _key2 = 0; _key2 < _len2; _key2++) {
        args[_key2] = arguments[_key2];
      }

      if (model.deleted) {
        vtkErrorMacro('instance deleted - cannot call any method');
        return false;
      }

      var array = args;
      // allow an array passed as a single arg.
      if (array.length === 1 && Array.isArray(array[0])) {
        /* eslint-disable prefer-destructuring */
        array = array[0];
        /* eslint-enable prefer-destructuring */
      }

      if (array.length !== size) {
        if (array.length < size && defaultVal !== undefined) {
          array = [].concat(array);
          while (array.length < size) {
            array.push(defaultVal);
          }
        } else {
          throw new RangeError('Invalid number of values for array setter');
        }
      }
      var changeDetected = false;
      model[field].forEach(function (item, index) {
        if (item !== array[index]) {
          if (changeDetected) {
            return;
          }
          changeDetected = true;
        }
      });

      if (changeDetected || model[field].length !== array.length) {
        model[field] = [].concat(array);
        publicAPI.modified();
      }
      return true;
    };

    publicAPI['set' + capitalize(field) + 'From'] = function (otherArray) {
      var target = model[field];
      otherArray.forEach(function (v, i) {
        target[i] = v;
      });
    };
  });
}

// ----------------------------------------------------------------------------
// set/get XXX: add setter and getter for object of type array
// ----------------------------------------------------------------------------

function setGetArray(publicAPI, model, fieldNames, size) {
  var defaultVal = arguments.length > 4 && arguments[4] !== undefined ? arguments[4] : undefined;

  getArray(publicAPI, model, fieldNames);
  setArray(publicAPI, model, fieldNames, size, defaultVal);
}

// ----------------------------------------------------------------------------
// vtkAlgorithm: setInputData(), setInputConnection(), getOutputData(), getOutputPort()
// ----------------------------------------------------------------------------

function algo(publicAPI, model, numberOfInputs, numberOfOutputs) {
  if (model.inputData) {
    model.inputData = model.inputData.map(_vtk2.default);
  } else {
    model.inputData = [];
  }

  if (model.inputConnection) {
    model.inputConnection = model.inputConnection.map(_vtk2.default);
  } else {
    model.inputConnection = [];
  }

  if (model.output) {
    model.output = model.output.map(_vtk2.default);
  } else {
    model.output = [];
  }

  if (model.inputArrayToProcess) {
    model.inputArrayToProcess = model.inputArrayToProcess.map(_vtk2.default);
  } else {
    model.inputArrayToProcess = [];
  }

  // Cache the argument for later manipulation
  model.numberOfInputs = numberOfInputs;

  // Methods
  function setInputData(dataset) {
    var port = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 0;

    if (model.deleted) {
      vtkErrorMacro('instance deleted - cannot call any method');
      return;
    }
    if (port >= model.numberOfInputs) {
      var msg = 'algorithm ' + publicAPI.getClassName() + ' only has ';
      msg += '' + model.numberOfInputs;
      msg += ' input ports. To add more input ports, use addInputData()';
      vtkErrorMacro(msg);
      return;
    }
    if (model.inputData[port] !== dataset || model.inputConnection[port]) {
      model.inputData[port] = dataset;
      model.inputConnection[port] = null;
      if (publicAPI.modified) {
        publicAPI.modified();
      }
    }
  }

  function getInputData() {
    var port = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 0;

    if (model.inputConnection[port]) {
      model.inputData[port] = model.inputConnection[port]();
    }
    return model.inputData[port];
  }

  function setInputConnection(outputPort) {
    var port = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 0;

    if (model.deleted) {
      vtkErrorMacro('instance deleted - cannot call any method');
      return;
    }
    if (port >= model.numberOfInputs) {
      var msg = 'algorithm ' + publicAPI.getClassName() + ' only has ';
      msg += '' + model.numberOfInputs;
      msg += ' input ports. To add more input ports, use addInputConnection()';
      vtkErrorMacro(msg);
      return;
    }
    model.inputData[port] = null;
    model.inputConnection[port] = outputPort;
  }

  function getInputConnection() {
    var port = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 0;

    return model.inputConnection[port];
  }

  function addInputConnection(outputPort) {
    if (model.deleted) {
      vtkErrorMacro('instance deleted - cannot call any method');
      return;
    }
    model.numberOfInputs++;
    setInputConnection(outputPort, model.numberOfInputs - 1);
  }

  function addInputData(dataset) {
    if (model.deleted) {
      vtkErrorMacro('instance deleted - cannot call any method');
      return;
    }
    model.numberOfInputs++;
    setInputData(dataset, model.numberOfInputs - 1);
  }

  function getOutputData() {
    var port = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 0;

    if (model.deleted) {
      vtkErrorMacro('instance deleted - cannot call any method');
      return null;
    }
    if (publicAPI.shouldUpdate()) {
      publicAPI.update();
    }
    return model.output[port];
  }

  publicAPI.shouldUpdate = function () {
    var localMTime = model.mtime;
    var count = numberOfOutputs;
    var minOutputMTime = Infinity;
    while (count--) {
      if (!model.output[count]) {
        return true;
      }
      var mt = model.output[count].getMTime();
      if (mt < localMTime) {
        return true;
      }
      if (mt < minOutputMTime) {
        minOutputMTime = mt;
      }
    }

    count = model.numberOfInputs;
    while (count--) {
      if (model.inputConnection[count] && model.inputConnection[count].filter.shouldUpdate()) {
        return true;
      }
    }

    count = model.numberOfInputs;
    while (count--) {
      if (publicAPI.getInputData(count) && publicAPI.getInputData(count).getMTime() > minOutputMTime) {
        return true;
      }
    }
    return false;
  };

  function getOutputPort() {
    var port = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 0;

    var outputPortAccess = function outputPortAccess() {
      return getOutputData(port);
    };
    // Add reference to filter
    outputPortAccess.filter = publicAPI;
    return outputPortAccess;
  }

  // Handle input if needed
  if (model.numberOfInputs) {
    // Reserve inputs
    var count = model.numberOfInputs;
    while (count--) {
      model.inputData.push(null);
      model.inputConnection.push(null);
    }

    // Expose public methods
    publicAPI.setInputData = setInputData;
    publicAPI.setInputConnection = setInputConnection;
    publicAPI.addInputData = addInputData;
    publicAPI.addInputConnection = addInputConnection;
    publicAPI.getInputData = getInputData;
    publicAPI.getInputConnection = getInputConnection;
  }

  if (numberOfOutputs) {
    publicAPI.getOutputData = getOutputData;
    publicAPI.getOutputPort = getOutputPort;
  }

  publicAPI.update = function () {
    var ins = [];
    if (model.numberOfInputs) {
      var _count = 0;
      while (_count < model.numberOfInputs) {
        ins[_count] = publicAPI.getInputData(_count);
        _count++;
      }
    }
    if (publicAPI.shouldUpdate() && publicAPI.requestData) {
      publicAPI.requestData(ins, model.output);
    }
  };

  publicAPI.getNumberOfInputPorts = function () {
    return model.numberOfInputs;
  };
  publicAPI.getNumberOfOutputPorts = function () {
    return numberOfOutputs;
  };

  publicAPI.getInputArrayToProcess = function (inputPort) {
    var arrayDesc = model.inputArrayToProcess[inputPort];
    var ds = model.inputData[inputPort];
    if (arrayDesc && ds) {
      return ds['get' + arrayDesc.fieldAssociation]().getArray(arrayDesc.arrayName);
    }
    return null;
  };
  publicAPI.setInputArrayToProcess = function (inputPort, arrayName, fieldAssociation) {
    var attributeType = arguments.length > 3 && arguments[3] !== undefined ? arguments[3] : 'Scalars';

    while (model.inputArrayToProcess.length < inputPort) {
      model.inputArrayToProcess.push(null);
    }
    model.inputArrayToProcess[inputPort] = {
      arrayName: arrayName,
      fieldAssociation: fieldAssociation,
      attributeType: attributeType
    };
  };
}

// ----------------------------------------------------------------------------
// Event handling: onXXX(callback), invokeXXX(args...)
// ----------------------------------------------------------------------------

var EVENT_ABORT = exports.EVENT_ABORT = Symbol('Event abort');

function event(publicAPI, model, eventName) {
  var callbacks = [];
  var previousDelete = publicAPI.delete;
  var curCallbackID = 1;

  function off(callbackID) {
    for (var i = 0; i < callbacks.length; ++i) {
      var _callbacks$i = _slicedToArray(callbacks[i], 1),
          cbID = _callbacks$i[0];

      if (cbID === callbackID) {
        callbacks.splice(i, 1);
        return;
      }
    }
  }

  function on(callbackID) {
    function unsubscribe() {
      off(callbackID);
    }
    return Object.freeze({
      unsubscribe: unsubscribe
    });
  }

  function invoke() {
    var _arguments = arguments;

    if (model.deleted) {
      vtkErrorMacro('instance deleted - cannot call any method');
      return;
    }
    /* eslint-disable prefer-rest-params */
    // Go through a copy of the callbacks array in case new callbacks
    // get prepended within previous callbacks
    var currentCallbacks = callbacks.slice();

    var _loop = function _loop(index) {
      var _currentCallbacks$ind = _slicedToArray(currentCallbacks[index], 3),
          cb = _currentCallbacks$ind[1],
          priority = _currentCallbacks$ind[2];

      if (priority < 0) {
        setTimeout(function () {
          return cb.apply(publicAPI, _arguments);
        }, 1 - priority);
      } else if (cb) {
        // Abort only if the callback explicitly returns false
        var continueNext = cb.apply(publicAPI, _arguments);
        if (continueNext === EVENT_ABORT) {
          return 'break';
        }
      }
    };

    for (var index = 0; index < currentCallbacks.length; ++index) {
      var _ret = _loop(index);

      if (_ret === 'break') break;
    }
    /* eslint-enable prefer-rest-params */
  }

  publicAPI['invoke' + capitalize(eventName)] = invoke;

  publicAPI['on' + capitalize(eventName)] = function (callback) {
    var priority = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 0.0;

    if (model.deleted) {
      vtkErrorMacro('instance deleted - cannot call any method');
      return null;
    }

    var callbackID = curCallbackID++;
    callbacks.push([callbackID, callback, priority]);
    callbacks.sort(function (cb1, cb2) {
      return cb2[2] - cb1[2];
    });
    return on(callbackID);
  };

  publicAPI.delete = function () {
    previousDelete();
    callbacks.forEach(function (_ref) {
      var _ref2 = _slicedToArray(_ref, 1),
          cbID = _ref2[0];

      return off(cbID);
    });
  };
}

// ----------------------------------------------------------------------------
// newInstance
// ----------------------------------------------------------------------------

function newInstance(extend, className) {
  var constructor = function constructor() {
    var initialValues = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {};

    var model = {};
    var publicAPI = {};
    extend(publicAPI, model, initialValues);
    return Object.freeze(publicAPI);
  };

  // Register constructor to factory
  if (className) {
    _vtk2.default.register(className, constructor);
  }

  return constructor;
}

// ----------------------------------------------------------------------------
// Chain function calls
// ----------------------------------------------------------------------------

function chain() {
  for (var _len3 = arguments.length, fn = Array(_len3), _key3 = 0; _key3 < _len3; _key3++) {
    fn[_key3] = arguments[_key3];
  }

  return function () {
    for (var _len4 = arguments.length, args = Array(_len4), _key4 = 0; _key4 < _len4; _key4++) {
      args[_key4] = arguments[_key4];
    }

    return fn.filter(function (i) {
      return !!i;
    }).forEach(function (i) {
      return i.apply(undefined, args);
    });
  };
}

// ----------------------------------------------------------------------------
// Some utility methods for vtk objects
// ----------------------------------------------------------------------------

function isVtkObject(instance) {
  return instance && instance.isA && instance.isA('vtkObject');
}

function traverseInstanceTree(instance, extractFunction) {
  var accumulator = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : [];
  var visitedInstances = arguments.length > 3 && arguments[3] !== undefined ? arguments[3] : [];

  if (isVtkObject(instance)) {
    if (visitedInstances.indexOf(instance) >= 0) {
      // avoid cycles
      return accumulator;
    }

    visitedInstances.push(instance);
    var result = extractFunction(instance);
    if (result !== undefined) {
      accumulator.push(result);
    }

    // Now go through this instance's model
    var model = instance.get();
    Object.keys(model).forEach(function (key) {
      var modelObj = model[key];
      if (Array.isArray(modelObj)) {
        modelObj.forEach(function (subObj) {
          traverseInstanceTree(subObj, extractFunction, accumulator, visitedInstances);
        });
      } else {
        traverseInstanceTree(modelObj, extractFunction, accumulator, visitedInstances);
      }
    });
  }

  return accumulator;
}

// ----------------------------------------------------------------------------
// Returns a function, that, as long as it continues to be invoked, will not
// be triggered. The function will be called after it stops being called for
// N milliseconds. If `immediate` is passed, trigger the function on the
// leading edge, instead of the trailing.

function debounce(func, wait, immediate) {
  var _this = this;

  var timeout = void 0;
  return function () {
    for (var _len5 = arguments.length, args = Array(_len5), _key5 = 0; _key5 < _len5; _key5++) {
      args[_key5] = arguments[_key5];
    }

    var context = _this;
    var later = function later() {
      timeout = null;
      if (!immediate) {
        func.apply(context, args);
      }
    };
    var callNow = immediate && !timeout;
    clearTimeout(timeout);
    timeout = setTimeout(later, wait);
    if (callNow) {
      func.apply(context, args);
    }
  };
}

// ----------------------------------------------------------------------------
// Creates a throttled function that only invokes `func` at most once per
// every `wait` milliseconds.

function throttle(callback, delay) {
  var isThrottled = false;
  var argsToUse = null;

  function next() {
    isThrottled = false;
    if (argsToUse !== null) {
      wrapper.apply(undefined, _toConsumableArray(argsToUse)); // eslint-disable-line
      argsToUse = null;
    }
  }

  function wrapper() {
    for (var _len6 = arguments.length, args = Array(_len6), _key6 = 0; _key6 < _len6; _key6++) {
      args[_key6] = arguments[_key6];
    }

    if (isThrottled) {
      argsToUse = args;
      return;
    }
    isThrottled = true;
    callback.apply(undefined, args);
    setTimeout(next, delay);
  }

  return wrapper;
}

// ----------------------------------------------------------------------------
// keystore(publicAPI, model, initialKeystore)
//
//    - initialKeystore: Initial keystore. This can be either a Map or an
//      object.
//
// Generated API
//  setKey(key, value) : mixed (returns value)
//  getKey(key) : mixed
//  getAllKeys() : [mixed]
//  deleteKey(key) : Boolean
// ----------------------------------------------------------------------------

function keystore(publicAPI, model) {
  var initialKeystore = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : {};

  model.keystore = Object.assign(model.keystore || {}, initialKeystore);

  publicAPI.setKey = function (key, value) {
    model.keystore[key] = value;
  };
  publicAPI.getKey = function (key, value) {
    return model.keystore[key];
  };
  publicAPI.getAllKeys = function (key, value) {
    return Object.keys(model.keystore);
  };
  publicAPI.deleteKey = function (key, value) {
    return delete model.keystore[key];
  };
  publicAPI.clearKeystore = function () {
    return publicAPI.getAllKeys().forEach(function (key) {
      return delete model.keystore[key];
    });
  };
}

// ----------------------------------------------------------------------------
// proxy(publicAPI, model, sectionName, propertyUI)
//
//    - sectionName: Name of the section for UI
//    - propertyUI: List of props with their UI description
//
// Generated API
//  getProxyId() : String
//  listProxyProperties() : [string]
//  updateProxyProperty(name, prop)
//  getProxySection() => List of properties for UI generation
// ----------------------------------------------------------------------------
var nextProxyId = 1;
var ROOT_GROUP_NAME = '__root__';

function proxy(publicAPI, model) {
  // Proxies are keystores
  keystore(publicAPI, model);

  var parentDelete = publicAPI.delete;

  // getProxyId
  model.proxyId = '' + nextProxyId++;

  // ui handling
  model.ui = JSON.parse(JSON.stringify(model.ui || [])); // deep copy
  get(publicAPI, model, ['proxyId', 'proxyGroup', 'proxyName']);
  setGet(publicAPI, model, ['proxyManager']);

  // group properties
  var propertyMap = {};
  var groupChildrenNames = {};

  function registerProperties(descriptionList, currentGroupName) {
    if (!groupChildrenNames[currentGroupName]) {
      groupChildrenNames[currentGroupName] = [];
    }
    var childrenNames = groupChildrenNames[currentGroupName];

    for (var i = 0; i < descriptionList.length; i++) {
      childrenNames.push(descriptionList[i].name);
      propertyMap[descriptionList[i].name] = descriptionList[i];
      if (descriptionList[i].children && descriptionList[i].children.length) {
        registerProperties(descriptionList[i].children, descriptionList[i].name);
      }
    }
  }
  registerProperties(model.ui, ROOT_GROUP_NAME);

  publicAPI.updateUI = function (ui) {
    model.ui = JSON.parse(JSON.stringify(ui || [])); // deep copy
    Object.keys(propertyMap).forEach(function (k) {
      return delete propertyMap[k];
    });
    Object.keys(groupChildrenNames).forEach(function (k) {
      return delete groupChildrenNames[k];
    });
    registerProperties(model.ui, ROOT_GROUP_NAME);
    publicAPI.modified();
  };

  function listProxyProperties() {
    var gName = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : ROOT_GROUP_NAME;

    return groupChildrenNames[gName];
  }

  publicAPI.updateProxyProperty = function (propertyName, propUI) {
    var prop = propertyMap[propertyName];
    if (prop) {
      Object.assign(prop, propUI);
    } else {
      propertyMap[propertyName] = Object.assign({}, propUI);
    }
  };

  publicAPI.activate = function () {
    if (model.proxyManager) {
      var setActiveMethod = 'setActive' + capitalize(publicAPI.getProxyGroup().slice(0, -1));
      if (model.proxyManager[setActiveMethod]) {
        model.proxyManager[setActiveMethod](publicAPI);
      }
    }
  };

  // property link
  model.propertyLinkSubscribers = [];
  publicAPI.registerPropertyLinkForGC = function (otherLink) {
    model.propertyLinkSubscribers.push(otherLink);
  };

  publicAPI.gcPropertyLinks = function () {
    while (model.propertyLinkSubscribers.length) {
      model.propertyLinkSubscribers.pop().unbind(publicAPI);
    }
  };

  model.propertyLinkMap = {};
  publicAPI.getPropertyLink = function (id) {
    var persistent = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : false;

    if (model.propertyLinkMap[id]) {
      return model.propertyLinkMap[id];
    }
    var value = null;
    var links = [];
    var count = 0;
    var updateInProgress = false;

    function update(source) {
      var force = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : false;

      if (updateInProgress) {
        return null;
      }

      var needUpdate = [];
      var sourceLink = null;
      count = links.length;
      while (count--) {
        var link = links[count];
        if (link.instance === source) {
          sourceLink = link;
        } else {
          needUpdate.push(link);
        }
      }

      var newValue = sourceLink.instance['get' + capitalize(sourceLink.propertyName)]();
      if (newValue !== value || force) {
        value = newValue;
        updateInProgress = true;
        while (needUpdate.length) {
          var linkToUpdate = needUpdate.pop();
          linkToUpdate.instance.set(_defineProperty({}, linkToUpdate.propertyName, value));
        }
        updateInProgress = false;
      }

      if (model.propertyLinkMap[id].persistent) {
        model.propertyLinkMap[id].value = newValue;
      }

      return newValue;
    }

    function unbind(instance, propertyName) {
      var indexToDelete = [];
      count = links.length;
      while (count--) {
        var link = links[count];
        if (link.instance === instance && (link.propertyName === propertyName || propertyName === undefined)) {
          link.subscription.unsubscribe();
          indexToDelete.push(count);
        }
      }
      while (indexToDelete.length) {
        links.splice(indexToDelete.pop(), 1);
      }
    }

    function bind(instance, propertyName) {
      var updateMe = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : false;

      var subscription = instance.onModified(update);
      var other = links[0];
      links.push({
        instance: instance,
        propertyName: propertyName,
        subscription: subscription
      });
      if (updateMe) {
        if (model.propertyLinkMap[id].persistent && model.propertyLinkMap[id].value !== undefined) {
          instance.set(_defineProperty({}, propertyName, model.propertyLinkMap[id].value));
        } else if (other) {
          update(other.instance, true);
        }
      }
      return {
        unsubscribe: function unsubscribe() {
          return unbind(instance, propertyName);
        }
      };
    }

    function unsubscribe() {
      while (links.length) {
        links.pop().subscription.unsubscribe();
      }
    }

    var linkHandler = {
      bind: bind,
      unbind: unbind,
      unsubscribe: unsubscribe,
      persistent: persistent
    };
    model.propertyLinkMap[id] = linkHandler;
    return linkHandler;
  };

  // extract values
  function getProperties() {
    var groupName = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : ROOT_GROUP_NAME;

    var values = [];
    var id = model.proxyId;
    var propertyNames = listProxyProperties(groupName) || [];
    for (var i = 0; i < propertyNames.length; i++) {
      var name = propertyNames[i];
      var method = publicAPI['get' + capitalize(name)];
      var value = method ? method() : undefined;
      var prop = {
        id: id,
        name: name,
        value: value
      };
      var children = getProperties(name);
      if (children.length) {
        prop.children = children;
      }
      values.push(prop);
    }
    return values;
  }

  publicAPI.listPropertyNames = function () {
    return getProperties().map(function (p) {
      return p.name;
    });
  };

  publicAPI.getPropertyByName = function (name) {
    return getProperties().find(function (p) {
      return p.name === name;
    });
  };

  publicAPI.getPropertyDomainByName = function (name) {
    return propertyMap[name].domain;
  };

  // ui section
  publicAPI.getProxySection = function () {
    return {
      id: model.proxyId,
      name: model.proxyGroup,
      ui: model.ui,
      properties: getProperties()
    };
  };

  // free resources
  publicAPI.delete = function () {
    var list = Object.keys(model.propertyLinkMap);
    var count = list.length;
    while (count--) {
      model.propertyLinkMap[list[count]].unsubscribe();
    }
    count = model.propertyLinkSubscribers.length;
    while (count--) {
      model.propertyLinkSubscribers[count].unbind(publicAPI);
    }
    parentDelete();
  };
}

// ----------------------------------------------------------------------------
// proxyPropertyMapping(publicAPI, model, map)
//
//   map = {
//      opacity: { modelKey: 'property', property: 'opacity' },
//   }
//
// Generated API:
//  Elevate set/get methods from internal object stored in the model to current one
// ----------------------------------------------------------------------------

function proxyPropertyMapping(publicAPI, model, map) {
  var parentDelete = publicAPI.delete;
  var subscriptions = [];

  var propertyNames = Object.keys(map);
  var count = propertyNames.length;
  while (count--) {
    var propertyName = propertyNames[count];
    var _map$propertyName = map[propertyName],
        modelKey = _map$propertyName.modelKey,
        property = _map$propertyName.property,
        _map$propertyName$mod = _map$propertyName.modified,
        modified = _map$propertyName$mod === undefined ? true : _map$propertyName$mod;

    var methodSrc = capitalize(property);
    var methodDst = capitalize(propertyName);
    publicAPI['get' + methodDst] = model[modelKey]['get' + methodSrc];
    publicAPI['set' + methodDst] = model[modelKey]['set' + methodSrc];
    if (modified) {
      subscriptions.push(model[modelKey].onModified(publicAPI.modified));
    }
  }

  publicAPI.delete = function () {
    while (subscriptions.length) {
      subscriptions.pop().unsubscribe();
    }
    parentDelete();
  };
}

// ----------------------------------------------------------------------------
// proxyPropertyState(publicAPI, model, state, defaults)
//
//   state = {
//     representation: {
//       'Surface with edges': { property: { edgeVisibility: true, representation: 2 } },
//       Surface: { property: { edgeVisibility: false, representation: 2 } },
//       Wireframe: { property: { edgeVisibility: false, representation: 1 } },
//       Points: { property: { edgeVisibility: false, representation: 0 } },
//     },
//   }
//
//   defaults = {
//      representation: 'Surface',
//   }
//
// Generated API
//   get / set Representation ( string ) => push state to various internal objects
// ----------------------------------------------------------------------------

function proxyPropertyState(publicAPI, model) {
  var state = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : {};
  var defaults = arguments.length > 3 && arguments[3] !== undefined ? arguments[3] : {};

  model.this = publicAPI;

  function applyState(map) {
    var modelKeys = Object.keys(map);
    var count = modelKeys.length;
    while (count--) {
      var modelKey = modelKeys[count];
      model[modelKey].set(map[modelKey]);
    }
  }

  var modelKeys = Object.keys(defaults);
  var count = modelKeys.length;

  var _loop2 = function _loop2() {
    // Add default
    var key = modelKeys[count];
    model[key] = defaults[key];

    // Add set method
    var mapping = state[key];
    publicAPI['set' + capitalize(key)] = function (value) {
      if (value !== model[key]) {
        model[key] = value;
        var propValues = mapping[value];
        applyState(propValues);
        publicAPI.modified();
      }
    };
  };

  while (count--) {
    _loop2();
  }

  // Add getter
  if (modelKeys.length) {
    get(publicAPI, model, modelKeys);
  }
}

// ----------------------------------------------------------------------------
// Default export
// ----------------------------------------------------------------------------

exports.default = {
  EVENT_ABORT: EVENT_ABORT,
  VOID: VOID,
  TYPED_ARRAYS: TYPED_ARRAYS,
  algo: algo,
  capitalize: capitalize,
  chain: chain,
  enumToString: enumToString,
  event: event,
  get: get,
  getArray: getArray,
  getCurrentGlobalMTime: getCurrentGlobalMTime,
  getStateArrayMapFunc: getStateArrayMapFunc,
  isVtkObject: isVtkObject,
  keystore: keystore,
  newInstance: newInstance,
  obj: obj,
  safeArrays: safeArrays,
  set: set,
  setArray: setArray,
  setGet: setGet,
  setGetArray: setGetArray,
  setLoggerFunction: setLoggerFunction,
  traverseInstanceTree: traverseInstanceTree,
  vtkDebugMacro: vtkDebugMacro,
  vtkErrorMacro: vtkErrorMacro,
  vtkInfoMacro: vtkInfoMacro,
  vtkLogMacro: vtkLogMacro,
  vtkWarningMacro: vtkWarningMacro,
  debounce: debounce,
  throttle: throttle,
  proxy: proxy,
  proxyPropertyMapping: proxyPropertyMapping,
  proxyPropertyState: proxyPropertyState,
  formatBytesToProperUnit: formatBytesToProperUnit,
  formatNumbersWithThousandSeparator: formatNumbersWithThousandSeparator
};
/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(20)))

/***/ }),

/***/ 114:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.newInstance = undefined;
exports.extend = extend;

var _macro = __webpack_require__(0);

var _macro2 = _interopRequireDefault(_macro);

var _vtk = __webpack_require__(52);

var _vtk2 = _interopRequireDefault(_vtk);

var _DataSetAttributes = __webpack_require__(210);

var _DataSetAttributes2 = _interopRequireDefault(_DataSetAttributes);

var _Constants = __webpack_require__(213);

var _Constants2 = _interopRequireDefault(_Constants);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

// import vtkBoundingBox from '../BoundingBox';
// import vtkMath from '../../Core/Math';
//
// function getBounds(dataset) {
//   if (dataset.bounds) {
//     return dataset.bounds;
//   }
//   if (dataset.type && dataset[dataset.type]) {
//     const ds = dataset[dataset.type];
//     if (ds.bounds) {
//       return ds.bounds;
//     }
//     if (ds.Points && ds.Points.bounds) {
//       return ds.Points.bounds;
//     }

//     if (ds.Points && ds.Points.values) {
//       const array = ds.Points.values;
//       const bbox = vtkBoundingBox.newInstance();
//       const size = array.length;
//       const delta = ds.Points.numberOfComponents ? ds.Points.numberOfComponents : 3;
//       for (let idx = 0; idx < size; idx += delta) {
//         bbox.addPoint(array[idx * delta], array[(idx * delta) + 1], array[(idx * delta) + 2]);
//       }
//       ds.Points.bounds = bbox.getBounds();
//       return ds.Points.bounds;
//     }
//   }
//   return vtkMath.createUninitializedBounds();
// }

// ----------------------------------------------------------------------------
// Global methods
// ----------------------------------------------------------------------------

var DATASET_FIELDS = ['pointData', 'cellData', 'fieldData'];

// ----------------------------------------------------------------------------
// vtkDataSet methods
// ----------------------------------------------------------------------------

function vtkDataSet(publicAPI, model) {
  // Set our className
  model.classHierarchy.push('vtkDataSet');

  // Add dataset attributes
  DATASET_FIELDS.forEach(function (fieldName) {
    if (!model[fieldName]) {
      model[fieldName] = _DataSetAttributes2.default.newInstance();
    } else {
      model[fieldName] = (0, _vtk2.default)(model[fieldName]);
    }
  });
}

// ----------------------------------------------------------------------------
// Object factory
// ----------------------------------------------------------------------------

var DEFAULT_VALUES = {
  // pointData: null,
  // cellData: null,
  // fieldData: null,
};

// ----------------------------------------------------------------------------

function extend(publicAPI, model) {
  var initialValues = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : {};

  Object.assign(model, DEFAULT_VALUES, initialValues);

  // Object methods
  _macro2.default.obj(publicAPI, model);
  _macro2.default.setGet(publicAPI, model, DATASET_FIELDS);

  // Object specific methods
  vtkDataSet(publicAPI, model);
}

// ----------------------------------------------------------------------------

var newInstance = exports.newInstance = _macro2.default.newInstance(extend, 'vtkDataSet');

// ----------------------------------------------------------------------------

exports.default = Object.assign({ newInstance: newInstance, extend: extend }, _Constants2.default);

/***/ }),

/***/ 115:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});
var StructuredType = exports.StructuredType = {
  UNCHANGED: 0,
  SINGLE_POINT: 1,
  X_LINE: 2,
  Y_LINE: 3,
  Z_LINE: 4,
  XY_PLANE: 5,
  YZ_PLANE: 6,
  XZ_PLANE: 7,
  XYZ_GRID: 8,
  EMPTY: 9
};

exports.default = {
  StructuredType: StructuredType
};

/***/ }),

/***/ 116:
/***/ (function(module, exports, __webpack_require__) {

/* Copyright (c) 2015, Brandon Jones, Colin MacKenzie IV.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE. */

var glMatrix = __webpack_require__(21);

/**
 * @class 3x3 Matrix
 * @name mat3
 */
var mat3 = {};

/**
 * Creates a new identity mat3
 *
 * @returns {mat3} a new 3x3 matrix
 */
mat3.create = function() {
    var out = new glMatrix.ARRAY_TYPE(9);
    out[0] = 1;
    out[1] = 0;
    out[2] = 0;
    out[3] = 0;
    out[4] = 1;
    out[5] = 0;
    out[6] = 0;
    out[7] = 0;
    out[8] = 1;
    return out;
};

/**
 * Copies the upper-left 3x3 values into the given mat3.
 *
 * @param {mat3} out the receiving 3x3 matrix
 * @param {mat4} a   the source 4x4 matrix
 * @returns {mat3} out
 */
mat3.fromMat4 = function(out, a) {
    out[0] = a[0];
    out[1] = a[1];
    out[2] = a[2];
    out[3] = a[4];
    out[4] = a[5];
    out[5] = a[6];
    out[6] = a[8];
    out[7] = a[9];
    out[8] = a[10];
    return out;
};

/**
 * Creates a new mat3 initialized with values from an existing matrix
 *
 * @param {mat3} a matrix to clone
 * @returns {mat3} a new 3x3 matrix
 */
mat3.clone = function(a) {
    var out = new glMatrix.ARRAY_TYPE(9);
    out[0] = a[0];
    out[1] = a[1];
    out[2] = a[2];
    out[3] = a[3];
    out[4] = a[4];
    out[5] = a[5];
    out[6] = a[6];
    out[7] = a[7];
    out[8] = a[8];
    return out;
};

/**
 * Copy the values from one mat3 to another
 *
 * @param {mat3} out the receiving matrix
 * @param {mat3} a the source matrix
 * @returns {mat3} out
 */
mat3.copy = function(out, a) {
    out[0] = a[0];
    out[1] = a[1];
    out[2] = a[2];
    out[3] = a[3];
    out[4] = a[4];
    out[5] = a[5];
    out[6] = a[6];
    out[7] = a[7];
    out[8] = a[8];
    return out;
};

/**
 * Set a mat3 to the identity matrix
 *
 * @param {mat3} out the receiving matrix
 * @returns {mat3} out
 */
mat3.identity = function(out) {
    out[0] = 1;
    out[1] = 0;
    out[2] = 0;
    out[3] = 0;
    out[4] = 1;
    out[5] = 0;
    out[6] = 0;
    out[7] = 0;
    out[8] = 1;
    return out;
};

/**
 * Transpose the values of a mat3
 *
 * @param {mat3} out the receiving matrix
 * @param {mat3} a the source matrix
 * @returns {mat3} out
 */
mat3.transpose = function(out, a) {
    // If we are transposing ourselves we can skip a few steps but have to cache some values
    if (out === a) {
        var a01 = a[1], a02 = a[2], a12 = a[5];
        out[1] = a[3];
        out[2] = a[6];
        out[3] = a01;
        out[5] = a[7];
        out[6] = a02;
        out[7] = a12;
    } else {
        out[0] = a[0];
        out[1] = a[3];
        out[2] = a[6];
        out[3] = a[1];
        out[4] = a[4];
        out[5] = a[7];
        out[6] = a[2];
        out[7] = a[5];
        out[8] = a[8];
    }
    
    return out;
};

/**
 * Inverts a mat3
 *
 * @param {mat3} out the receiving matrix
 * @param {mat3} a the source matrix
 * @returns {mat3} out
 */
mat3.invert = function(out, a) {
    var a00 = a[0], a01 = a[1], a02 = a[2],
        a10 = a[3], a11 = a[4], a12 = a[5],
        a20 = a[6], a21 = a[7], a22 = a[8],

        b01 = a22 * a11 - a12 * a21,
        b11 = -a22 * a10 + a12 * a20,
        b21 = a21 * a10 - a11 * a20,

        // Calculate the determinant
        det = a00 * b01 + a01 * b11 + a02 * b21;

    if (!det) { 
        return null; 
    }
    det = 1.0 / det;

    out[0] = b01 * det;
    out[1] = (-a22 * a01 + a02 * a21) * det;
    out[2] = (a12 * a01 - a02 * a11) * det;
    out[3] = b11 * det;
    out[4] = (a22 * a00 - a02 * a20) * det;
    out[5] = (-a12 * a00 + a02 * a10) * det;
    out[6] = b21 * det;
    out[7] = (-a21 * a00 + a01 * a20) * det;
    out[8] = (a11 * a00 - a01 * a10) * det;
    return out;
};

/**
 * Calculates the adjugate of a mat3
 *
 * @param {mat3} out the receiving matrix
 * @param {mat3} a the source matrix
 * @returns {mat3} out
 */
mat3.adjoint = function(out, a) {
    var a00 = a[0], a01 = a[1], a02 = a[2],
        a10 = a[3], a11 = a[4], a12 = a[5],
        a20 = a[6], a21 = a[7], a22 = a[8];

    out[0] = (a11 * a22 - a12 * a21);
    out[1] = (a02 * a21 - a01 * a22);
    out[2] = (a01 * a12 - a02 * a11);
    out[3] = (a12 * a20 - a10 * a22);
    out[4] = (a00 * a22 - a02 * a20);
    out[5] = (a02 * a10 - a00 * a12);
    out[6] = (a10 * a21 - a11 * a20);
    out[7] = (a01 * a20 - a00 * a21);
    out[8] = (a00 * a11 - a01 * a10);
    return out;
};

/**
 * Calculates the determinant of a mat3
 *
 * @param {mat3} a the source matrix
 * @returns {Number} determinant of a
 */
mat3.determinant = function (a) {
    var a00 = a[0], a01 = a[1], a02 = a[2],
        a10 = a[3], a11 = a[4], a12 = a[5],
        a20 = a[6], a21 = a[7], a22 = a[8];

    return a00 * (a22 * a11 - a12 * a21) + a01 * (-a22 * a10 + a12 * a20) + a02 * (a21 * a10 - a11 * a20);
};

/**
 * Multiplies two mat3's
 *
 * @param {mat3} out the receiving matrix
 * @param {mat3} a the first operand
 * @param {mat3} b the second operand
 * @returns {mat3} out
 */
mat3.multiply = function (out, a, b) {
    var a00 = a[0], a01 = a[1], a02 = a[2],
        a10 = a[3], a11 = a[4], a12 = a[5],
        a20 = a[6], a21 = a[7], a22 = a[8],

        b00 = b[0], b01 = b[1], b02 = b[2],
        b10 = b[3], b11 = b[4], b12 = b[5],
        b20 = b[6], b21 = b[7], b22 = b[8];

    out[0] = b00 * a00 + b01 * a10 + b02 * a20;
    out[1] = b00 * a01 + b01 * a11 + b02 * a21;
    out[2] = b00 * a02 + b01 * a12 + b02 * a22;

    out[3] = b10 * a00 + b11 * a10 + b12 * a20;
    out[4] = b10 * a01 + b11 * a11 + b12 * a21;
    out[5] = b10 * a02 + b11 * a12 + b12 * a22;

    out[6] = b20 * a00 + b21 * a10 + b22 * a20;
    out[7] = b20 * a01 + b21 * a11 + b22 * a21;
    out[8] = b20 * a02 + b21 * a12 + b22 * a22;
    return out;
};

/**
 * Alias for {@link mat3.multiply}
 * @function
 */
mat3.mul = mat3.multiply;

/**
 * Translate a mat3 by the given vector
 *
 * @param {mat3} out the receiving matrix
 * @param {mat3} a the matrix to translate
 * @param {vec2} v vector to translate by
 * @returns {mat3} out
 */
mat3.translate = function(out, a, v) {
    var a00 = a[0], a01 = a[1], a02 = a[2],
        a10 = a[3], a11 = a[4], a12 = a[5],
        a20 = a[6], a21 = a[7], a22 = a[8],
        x = v[0], y = v[1];

    out[0] = a00;
    out[1] = a01;
    out[2] = a02;

    out[3] = a10;
    out[4] = a11;
    out[5] = a12;

    out[6] = x * a00 + y * a10 + a20;
    out[7] = x * a01 + y * a11 + a21;
    out[8] = x * a02 + y * a12 + a22;
    return out;
};

/**
 * Rotates a mat3 by the given angle
 *
 * @param {mat3} out the receiving matrix
 * @param {mat3} a the matrix to rotate
 * @param {Number} rad the angle to rotate the matrix by
 * @returns {mat3} out
 */
mat3.rotate = function (out, a, rad) {
    var a00 = a[0], a01 = a[1], a02 = a[2],
        a10 = a[3], a11 = a[4], a12 = a[5],
        a20 = a[6], a21 = a[7], a22 = a[8],

        s = Math.sin(rad),
        c = Math.cos(rad);

    out[0] = c * a00 + s * a10;
    out[1] = c * a01 + s * a11;
    out[2] = c * a02 + s * a12;

    out[3] = c * a10 - s * a00;
    out[4] = c * a11 - s * a01;
    out[5] = c * a12 - s * a02;

    out[6] = a20;
    out[7] = a21;
    out[8] = a22;
    return out;
};

/**
 * Scales the mat3 by the dimensions in the given vec2
 *
 * @param {mat3} out the receiving matrix
 * @param {mat3} a the matrix to rotate
 * @param {vec2} v the vec2 to scale the matrix by
 * @returns {mat3} out
 **/
mat3.scale = function(out, a, v) {
    var x = v[0], y = v[1];

    out[0] = x * a[0];
    out[1] = x * a[1];
    out[2] = x * a[2];

    out[3] = y * a[3];
    out[4] = y * a[4];
    out[5] = y * a[5];

    out[6] = a[6];
    out[7] = a[7];
    out[8] = a[8];
    return out;
};

/**
 * Creates a matrix from a vector translation
 * This is equivalent to (but much faster than):
 *
 *     mat3.identity(dest);
 *     mat3.translate(dest, dest, vec);
 *
 * @param {mat3} out mat3 receiving operation result
 * @param {vec2} v Translation vector
 * @returns {mat3} out
 */
mat3.fromTranslation = function(out, v) {
    out[0] = 1;
    out[1] = 0;
    out[2] = 0;
    out[3] = 0;
    out[4] = 1;
    out[5] = 0;
    out[6] = v[0];
    out[7] = v[1];
    out[8] = 1;
    return out;
}

/**
 * Creates a matrix from a given angle
 * This is equivalent to (but much faster than):
 *
 *     mat3.identity(dest);
 *     mat3.rotate(dest, dest, rad);
 *
 * @param {mat3} out mat3 receiving operation result
 * @param {Number} rad the angle to rotate the matrix by
 * @returns {mat3} out
 */
mat3.fromRotation = function(out, rad) {
    var s = Math.sin(rad), c = Math.cos(rad);

    out[0] = c;
    out[1] = s;
    out[2] = 0;

    out[3] = -s;
    out[4] = c;
    out[5] = 0;

    out[6] = 0;
    out[7] = 0;
    out[8] = 1;
    return out;
}

/**
 * Creates a matrix from a vector scaling
 * This is equivalent to (but much faster than):
 *
 *     mat3.identity(dest);
 *     mat3.scale(dest, dest, vec);
 *
 * @param {mat3} out mat3 receiving operation result
 * @param {vec2} v Scaling vector
 * @returns {mat3} out
 */
mat3.fromScaling = function(out, v) {
    out[0] = v[0];
    out[1] = 0;
    out[2] = 0;

    out[3] = 0;
    out[4] = v[1];
    out[5] = 0;

    out[6] = 0;
    out[7] = 0;
    out[8] = 1;
    return out;
}

/**
 * Copies the values from a mat2d into a mat3
 *
 * @param {mat3} out the receiving matrix
 * @param {mat2d} a the matrix to copy
 * @returns {mat3} out
 **/
mat3.fromMat2d = function(out, a) {
    out[0] = a[0];
    out[1] = a[1];
    out[2] = 0;

    out[3] = a[2];
    out[4] = a[3];
    out[5] = 0;

    out[6] = a[4];
    out[7] = a[5];
    out[8] = 1;
    return out;
};

/**
* Calculates a 3x3 matrix from the given quaternion
*
* @param {mat3} out mat3 receiving operation result
* @param {quat} q Quaternion to create matrix from
*
* @returns {mat3} out
*/
mat3.fromQuat = function (out, q) {
    var x = q[0], y = q[1], z = q[2], w = q[3],
        x2 = x + x,
        y2 = y + y,
        z2 = z + z,

        xx = x * x2,
        yx = y * x2,
        yy = y * y2,
        zx = z * x2,
        zy = z * y2,
        zz = z * z2,
        wx = w * x2,
        wy = w * y2,
        wz = w * z2;

    out[0] = 1 - yy - zz;
    out[3] = yx - wz;
    out[6] = zx + wy;

    out[1] = yx + wz;
    out[4] = 1 - xx - zz;
    out[7] = zy - wx;

    out[2] = zx - wy;
    out[5] = zy + wx;
    out[8] = 1 - xx - yy;

    return out;
};

/**
* Calculates a 3x3 normal matrix (transpose inverse) from the 4x4 matrix
*
* @param {mat3} out mat3 receiving operation result
* @param {mat4} a Mat4 to derive the normal matrix from
*
* @returns {mat3} out
*/
mat3.normalFromMat4 = function (out, a) {
    var a00 = a[0], a01 = a[1], a02 = a[2], a03 = a[3],
        a10 = a[4], a11 = a[5], a12 = a[6], a13 = a[7],
        a20 = a[8], a21 = a[9], a22 = a[10], a23 = a[11],
        a30 = a[12], a31 = a[13], a32 = a[14], a33 = a[15],

        b00 = a00 * a11 - a01 * a10,
        b01 = a00 * a12 - a02 * a10,
        b02 = a00 * a13 - a03 * a10,
        b03 = a01 * a12 - a02 * a11,
        b04 = a01 * a13 - a03 * a11,
        b05 = a02 * a13 - a03 * a12,
        b06 = a20 * a31 - a21 * a30,
        b07 = a20 * a32 - a22 * a30,
        b08 = a20 * a33 - a23 * a30,
        b09 = a21 * a32 - a22 * a31,
        b10 = a21 * a33 - a23 * a31,
        b11 = a22 * a33 - a23 * a32,

        // Calculate the determinant
        det = b00 * b11 - b01 * b10 + b02 * b09 + b03 * b08 - b04 * b07 + b05 * b06;

    if (!det) { 
        return null; 
    }
    det = 1.0 / det;

    out[0] = (a11 * b11 - a12 * b10 + a13 * b09) * det;
    out[1] = (a12 * b08 - a10 * b11 - a13 * b07) * det;
    out[2] = (a10 * b10 - a11 * b08 + a13 * b06) * det;

    out[3] = (a02 * b10 - a01 * b11 - a03 * b09) * det;
    out[4] = (a00 * b11 - a02 * b08 + a03 * b07) * det;
    out[5] = (a01 * b08 - a00 * b10 - a03 * b06) * det;

    out[6] = (a31 * b05 - a32 * b04 + a33 * b03) * det;
    out[7] = (a32 * b02 - a30 * b05 - a33 * b01) * det;
    out[8] = (a30 * b04 - a31 * b02 + a33 * b00) * det;

    return out;
};

/**
 * Returns a string representation of a mat3
 *
 * @param {mat3} mat matrix to represent as a string
 * @returns {String} string representation of the matrix
 */
mat3.str = function (a) {
    return 'mat3(' + a[0] + ', ' + a[1] + ', ' + a[2] + ', ' + 
                    a[3] + ', ' + a[4] + ', ' + a[5] + ', ' + 
                    a[6] + ', ' + a[7] + ', ' + a[8] + ')';
};

/**
 * Returns Frobenius norm of a mat3
 *
 * @param {mat3} a the matrix to calculate Frobenius norm of
 * @returns {Number} Frobenius norm
 */
mat3.frob = function (a) {
    return(Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2) + Math.pow(a[2], 2) + Math.pow(a[3], 2) + Math.pow(a[4], 2) + Math.pow(a[5], 2) + Math.pow(a[6], 2) + Math.pow(a[7], 2) + Math.pow(a[8], 2)))
};


module.exports = mat3;


/***/ }),

/***/ 117:
/***/ (function(module, exports, __webpack_require__) {

/* Copyright (c) 2015, Brandon Jones, Colin MacKenzie IV.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE. */

var glMatrix = __webpack_require__(21);

/**
 * @class 3 Dimensional Vector
 * @name vec3
 */
var vec3 = {};

/**
 * Creates a new, empty vec3
 *
 * @returns {vec3} a new 3D vector
 */
vec3.create = function() {
    var out = new glMatrix.ARRAY_TYPE(3);
    out[0] = 0;
    out[1] = 0;
    out[2] = 0;
    return out;
};

/**
 * Creates a new vec3 initialized with values from an existing vector
 *
 * @param {vec3} a vector to clone
 * @returns {vec3} a new 3D vector
 */
vec3.clone = function(a) {
    var out = new glMatrix.ARRAY_TYPE(3);
    out[0] = a[0];
    out[1] = a[1];
    out[2] = a[2];
    return out;
};

/**
 * Creates a new vec3 initialized with the given values
 *
 * @param {Number} x X component
 * @param {Number} y Y component
 * @param {Number} z Z component
 * @returns {vec3} a new 3D vector
 */
vec3.fromValues = function(x, y, z) {
    var out = new glMatrix.ARRAY_TYPE(3);
    out[0] = x;
    out[1] = y;
    out[2] = z;
    return out;
};

/**
 * Copy the values from one vec3 to another
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a the source vector
 * @returns {vec3} out
 */
vec3.copy = function(out, a) {
    out[0] = a[0];
    out[1] = a[1];
    out[2] = a[2];
    return out;
};

/**
 * Set the components of a vec3 to the given values
 *
 * @param {vec3} out the receiving vector
 * @param {Number} x X component
 * @param {Number} y Y component
 * @param {Number} z Z component
 * @returns {vec3} out
 */
vec3.set = function(out, x, y, z) {
    out[0] = x;
    out[1] = y;
    out[2] = z;
    return out;
};

/**
 * Adds two vec3's
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a the first operand
 * @param {vec3} b the second operand
 * @returns {vec3} out
 */
vec3.add = function(out, a, b) {
    out[0] = a[0] + b[0];
    out[1] = a[1] + b[1];
    out[2] = a[2] + b[2];
    return out;
};

/**
 * Subtracts vector b from vector a
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a the first operand
 * @param {vec3} b the second operand
 * @returns {vec3} out
 */
vec3.subtract = function(out, a, b) {
    out[0] = a[0] - b[0];
    out[1] = a[1] - b[1];
    out[2] = a[2] - b[2];
    return out;
};

/**
 * Alias for {@link vec3.subtract}
 * @function
 */
vec3.sub = vec3.subtract;

/**
 * Multiplies two vec3's
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a the first operand
 * @param {vec3} b the second operand
 * @returns {vec3} out
 */
vec3.multiply = function(out, a, b) {
    out[0] = a[0] * b[0];
    out[1] = a[1] * b[1];
    out[2] = a[2] * b[2];
    return out;
};

/**
 * Alias for {@link vec3.multiply}
 * @function
 */
vec3.mul = vec3.multiply;

/**
 * Divides two vec3's
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a the first operand
 * @param {vec3} b the second operand
 * @returns {vec3} out
 */
vec3.divide = function(out, a, b) {
    out[0] = a[0] / b[0];
    out[1] = a[1] / b[1];
    out[2] = a[2] / b[2];
    return out;
};

/**
 * Alias for {@link vec3.divide}
 * @function
 */
vec3.div = vec3.divide;

/**
 * Returns the minimum of two vec3's
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a the first operand
 * @param {vec3} b the second operand
 * @returns {vec3} out
 */
vec3.min = function(out, a, b) {
    out[0] = Math.min(a[0], b[0]);
    out[1] = Math.min(a[1], b[1]);
    out[2] = Math.min(a[2], b[2]);
    return out;
};

/**
 * Returns the maximum of two vec3's
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a the first operand
 * @param {vec3} b the second operand
 * @returns {vec3} out
 */
vec3.max = function(out, a, b) {
    out[0] = Math.max(a[0], b[0]);
    out[1] = Math.max(a[1], b[1]);
    out[2] = Math.max(a[2], b[2]);
    return out;
};

/**
 * Scales a vec3 by a scalar number
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a the vector to scale
 * @param {Number} b amount to scale the vector by
 * @returns {vec3} out
 */
vec3.scale = function(out, a, b) {
    out[0] = a[0] * b;
    out[1] = a[1] * b;
    out[2] = a[2] * b;
    return out;
};

/**
 * Adds two vec3's after scaling the second operand by a scalar value
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a the first operand
 * @param {vec3} b the second operand
 * @param {Number} scale the amount to scale b by before adding
 * @returns {vec3} out
 */
vec3.scaleAndAdd = function(out, a, b, scale) {
    out[0] = a[0] + (b[0] * scale);
    out[1] = a[1] + (b[1] * scale);
    out[2] = a[2] + (b[2] * scale);
    return out;
};

/**
 * Calculates the euclidian distance between two vec3's
 *
 * @param {vec3} a the first operand
 * @param {vec3} b the second operand
 * @returns {Number} distance between a and b
 */
vec3.distance = function(a, b) {
    var x = b[0] - a[0],
        y = b[1] - a[1],
        z = b[2] - a[2];
    return Math.sqrt(x*x + y*y + z*z);
};

/**
 * Alias for {@link vec3.distance}
 * @function
 */
vec3.dist = vec3.distance;

/**
 * Calculates the squared euclidian distance between two vec3's
 *
 * @param {vec3} a the first operand
 * @param {vec3} b the second operand
 * @returns {Number} squared distance between a and b
 */
vec3.squaredDistance = function(a, b) {
    var x = b[0] - a[0],
        y = b[1] - a[1],
        z = b[2] - a[2];
    return x*x + y*y + z*z;
};

/**
 * Alias for {@link vec3.squaredDistance}
 * @function
 */
vec3.sqrDist = vec3.squaredDistance;

/**
 * Calculates the length of a vec3
 *
 * @param {vec3} a vector to calculate length of
 * @returns {Number} length of a
 */
vec3.length = function (a) {
    var x = a[0],
        y = a[1],
        z = a[2];
    return Math.sqrt(x*x + y*y + z*z);
};

/**
 * Alias for {@link vec3.length}
 * @function
 */
vec3.len = vec3.length;

/**
 * Calculates the squared length of a vec3
 *
 * @param {vec3} a vector to calculate squared length of
 * @returns {Number} squared length of a
 */
vec3.squaredLength = function (a) {
    var x = a[0],
        y = a[1],
        z = a[2];
    return x*x + y*y + z*z;
};

/**
 * Alias for {@link vec3.squaredLength}
 * @function
 */
vec3.sqrLen = vec3.squaredLength;

/**
 * Negates the components of a vec3
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a vector to negate
 * @returns {vec3} out
 */
vec3.negate = function(out, a) {
    out[0] = -a[0];
    out[1] = -a[1];
    out[2] = -a[2];
    return out;
};

/**
 * Returns the inverse of the components of a vec3
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a vector to invert
 * @returns {vec3} out
 */
vec3.inverse = function(out, a) {
  out[0] = 1.0 / a[0];
  out[1] = 1.0 / a[1];
  out[2] = 1.0 / a[2];
  return out;
};

/**
 * Normalize a vec3
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a vector to normalize
 * @returns {vec3} out
 */
vec3.normalize = function(out, a) {
    var x = a[0],
        y = a[1],
        z = a[2];
    var len = x*x + y*y + z*z;
    if (len > 0) {
        //TODO: evaluate use of glm_invsqrt here?
        len = 1 / Math.sqrt(len);
        out[0] = a[0] * len;
        out[1] = a[1] * len;
        out[2] = a[2] * len;
    }
    return out;
};

/**
 * Calculates the dot product of two vec3's
 *
 * @param {vec3} a the first operand
 * @param {vec3} b the second operand
 * @returns {Number} dot product of a and b
 */
vec3.dot = function (a, b) {
    return a[0] * b[0] + a[1] * b[1] + a[2] * b[2];
};

/**
 * Computes the cross product of two vec3's
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a the first operand
 * @param {vec3} b the second operand
 * @returns {vec3} out
 */
vec3.cross = function(out, a, b) {
    var ax = a[0], ay = a[1], az = a[2],
        bx = b[0], by = b[1], bz = b[2];

    out[0] = ay * bz - az * by;
    out[1] = az * bx - ax * bz;
    out[2] = ax * by - ay * bx;
    return out;
};

/**
 * Performs a linear interpolation between two vec3's
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a the first operand
 * @param {vec3} b the second operand
 * @param {Number} t interpolation amount between the two inputs
 * @returns {vec3} out
 */
vec3.lerp = function (out, a, b, t) {
    var ax = a[0],
        ay = a[1],
        az = a[2];
    out[0] = ax + t * (b[0] - ax);
    out[1] = ay + t * (b[1] - ay);
    out[2] = az + t * (b[2] - az);
    return out;
};

/**
 * Performs a hermite interpolation with two control points
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a the first operand
 * @param {vec3} b the second operand
 * @param {vec3} c the third operand
 * @param {vec3} d the fourth operand
 * @param {Number} t interpolation amount between the two inputs
 * @returns {vec3} out
 */
vec3.hermite = function (out, a, b, c, d, t) {
  var factorTimes2 = t * t,
      factor1 = factorTimes2 * (2 * t - 3) + 1,
      factor2 = factorTimes2 * (t - 2) + t,
      factor3 = factorTimes2 * (t - 1),
      factor4 = factorTimes2 * (3 - 2 * t);
  
  out[0] = a[0] * factor1 + b[0] * factor2 + c[0] * factor3 + d[0] * factor4;
  out[1] = a[1] * factor1 + b[1] * factor2 + c[1] * factor3 + d[1] * factor4;
  out[2] = a[2] * factor1 + b[2] * factor2 + c[2] * factor3 + d[2] * factor4;
  
  return out;
};

/**
 * Performs a bezier interpolation with two control points
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a the first operand
 * @param {vec3} b the second operand
 * @param {vec3} c the third operand
 * @param {vec3} d the fourth operand
 * @param {Number} t interpolation amount between the two inputs
 * @returns {vec3} out
 */
vec3.bezier = function (out, a, b, c, d, t) {
  var inverseFactor = 1 - t,
      inverseFactorTimesTwo = inverseFactor * inverseFactor,
      factorTimes2 = t * t,
      factor1 = inverseFactorTimesTwo * inverseFactor,
      factor2 = 3 * t * inverseFactorTimesTwo,
      factor3 = 3 * factorTimes2 * inverseFactor,
      factor4 = factorTimes2 * t;
  
  out[0] = a[0] * factor1 + b[0] * factor2 + c[0] * factor3 + d[0] * factor4;
  out[1] = a[1] * factor1 + b[1] * factor2 + c[1] * factor3 + d[1] * factor4;
  out[2] = a[2] * factor1 + b[2] * factor2 + c[2] * factor3 + d[2] * factor4;
  
  return out;
};

/**
 * Generates a random vector with the given scale
 *
 * @param {vec3} out the receiving vector
 * @param {Number} [scale] Length of the resulting vector. If ommitted, a unit vector will be returned
 * @returns {vec3} out
 */
vec3.random = function (out, scale) {
    scale = scale || 1.0;

    var r = glMatrix.RANDOM() * 2.0 * Math.PI;
    var z = (glMatrix.RANDOM() * 2.0) - 1.0;
    var zScale = Math.sqrt(1.0-z*z) * scale;

    out[0] = Math.cos(r) * zScale;
    out[1] = Math.sin(r) * zScale;
    out[2] = z * scale;
    return out;
};

/**
 * Transforms the vec3 with a mat4.
 * 4th vector component is implicitly '1'
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a the vector to transform
 * @param {mat4} m matrix to transform with
 * @returns {vec3} out
 */
vec3.transformMat4 = function(out, a, m) {
    var x = a[0], y = a[1], z = a[2],
        w = m[3] * x + m[7] * y + m[11] * z + m[15];
    w = w || 1.0;
    out[0] = (m[0] * x + m[4] * y + m[8] * z + m[12]) / w;
    out[1] = (m[1] * x + m[5] * y + m[9] * z + m[13]) / w;
    out[2] = (m[2] * x + m[6] * y + m[10] * z + m[14]) / w;
    return out;
};

/**
 * Transforms the vec3 with a mat3.
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a the vector to transform
 * @param {mat4} m the 3x3 matrix to transform with
 * @returns {vec3} out
 */
vec3.transformMat3 = function(out, a, m) {
    var x = a[0], y = a[1], z = a[2];
    out[0] = x * m[0] + y * m[3] + z * m[6];
    out[1] = x * m[1] + y * m[4] + z * m[7];
    out[2] = x * m[2] + y * m[5] + z * m[8];
    return out;
};

/**
 * Transforms the vec3 with a quat
 *
 * @param {vec3} out the receiving vector
 * @param {vec3} a the vector to transform
 * @param {quat} q quaternion to transform with
 * @returns {vec3} out
 */
vec3.transformQuat = function(out, a, q) {
    // benchmarks: http://jsperf.com/quaternion-transform-vec3-implementations

    var x = a[0], y = a[1], z = a[2],
        qx = q[0], qy = q[1], qz = q[2], qw = q[3],

        // calculate quat * vec
        ix = qw * x + qy * z - qz * y,
        iy = qw * y + qz * x - qx * z,
        iz = qw * z + qx * y - qy * x,
        iw = -qx * x - qy * y - qz * z;

    // calculate result * inverse quat
    out[0] = ix * qw + iw * -qx + iy * -qz - iz * -qy;
    out[1] = iy * qw + iw * -qy + iz * -qx - ix * -qz;
    out[2] = iz * qw + iw * -qz + ix * -qy - iy * -qx;
    return out;
};

/**
 * Rotate a 3D vector around the x-axis
 * @param {vec3} out The receiving vec3
 * @param {vec3} a The vec3 point to rotate
 * @param {vec3} b The origin of the rotation
 * @param {Number} c The angle of rotation
 * @returns {vec3} out
 */
vec3.rotateX = function(out, a, b, c){
   var p = [], r=[];
	  //Translate point to the origin
	  p[0] = a[0] - b[0];
	  p[1] = a[1] - b[1];
  	p[2] = a[2] - b[2];

	  //perform rotation
	  r[0] = p[0];
	  r[1] = p[1]*Math.cos(c) - p[2]*Math.sin(c);
	  r[2] = p[1]*Math.sin(c) + p[2]*Math.cos(c);

	  //translate to correct position
	  out[0] = r[0] + b[0];
	  out[1] = r[1] + b[1];
	  out[2] = r[2] + b[2];

  	return out;
};

/**
 * Rotate a 3D vector around the y-axis
 * @param {vec3} out The receiving vec3
 * @param {vec3} a The vec3 point to rotate
 * @param {vec3} b The origin of the rotation
 * @param {Number} c The angle of rotation
 * @returns {vec3} out
 */
vec3.rotateY = function(out, a, b, c){
  	var p = [], r=[];
  	//Translate point to the origin
  	p[0] = a[0] - b[0];
  	p[1] = a[1] - b[1];
  	p[2] = a[2] - b[2];
  
  	//perform rotation
  	r[0] = p[2]*Math.sin(c) + p[0]*Math.cos(c);
  	r[1] = p[1];
  	r[2] = p[2]*Math.cos(c) - p[0]*Math.sin(c);
  
  	//translate to correct position
  	out[0] = r[0] + b[0];
  	out[1] = r[1] + b[1];
  	out[2] = r[2] + b[2];
  
  	return out;
};

/**
 * Rotate a 3D vector around the z-axis
 * @param {vec3} out The receiving vec3
 * @param {vec3} a The vec3 point to rotate
 * @param {vec3} b The origin of the rotation
 * @param {Number} c The angle of rotation
 * @returns {vec3} out
 */
vec3.rotateZ = function(out, a, b, c){
  	var p = [], r=[];
  	//Translate point to the origin
  	p[0] = a[0] - b[0];
  	p[1] = a[1] - b[1];
  	p[2] = a[2] - b[2];
  
  	//perform rotation
  	r[0] = p[0]*Math.cos(c) - p[1]*Math.sin(c);
  	r[1] = p[0]*Math.sin(c) + p[1]*Math.cos(c);
  	r[2] = p[2];
  
  	//translate to correct position
  	out[0] = r[0] + b[0];
  	out[1] = r[1] + b[1];
  	out[2] = r[2] + b[2];
  
  	return out;
};

/**
 * Perform some operation over an array of vec3s.
 *
 * @param {Array} a the array of vectors to iterate over
 * @param {Number} stride Number of elements between the start of each vec3. If 0 assumes tightly packed
 * @param {Number} offset Number of elements to skip at the beginning of the array
 * @param {Number} count Number of vec3s to iterate over. If 0 iterates over entire array
 * @param {Function} fn Function to call for each vector in the array
 * @param {Object} [arg] additional argument to pass to fn
 * @returns {Array} a
 * @function
 */
vec3.forEach = (function() {
    var vec = vec3.create();

    return function(a, stride, offset, count, fn, arg) {
        var i, l;
        if(!stride) {
            stride = 3;
        }

        if(!offset) {
            offset = 0;
        }
        
        if(count) {
            l = Math.min((count * stride) + offset, a.length);
        } else {
            l = a.length;
        }

        for(i = offset; i < l; i += stride) {
            vec[0] = a[i]; vec[1] = a[i+1]; vec[2] = a[i+2];
            fn(vec, vec, arg);
            a[i] = vec[0]; a[i+1] = vec[1]; a[i+2] = vec[2];
        }
        
        return a;
    };
})();

/**
 * Get the angle between two 3D vectors
 * @param {vec3} a The first operand
 * @param {vec3} b The second operand
 * @returns {Number} The angle in radians
 */
vec3.angle = function(a, b) {
   
    var tempA = vec3.fromValues(a[0], a[1], a[2]);
    var tempB = vec3.fromValues(b[0], b[1], b[2]);
 
    vec3.normalize(tempA, tempA);
    vec3.normalize(tempB, tempB);
 
    var cosine = vec3.dot(tempA, tempB);

    if(cosine > 1.0){
        return 0;
    } else {
        return Math.acos(cosine);
    }     
};

/**
 * Returns a string representation of a vector
 *
 * @param {vec3} vec vector to represent as a string
 * @returns {String} string representation of the vector
 */
vec3.str = function (a) {
    return 'vec3(' + a[0] + ', ' + a[1] + ', ' + a[2] + ')';
};

module.exports = vec3;


/***/ }),

/***/ 118:
/***/ (function(module, exports, __webpack_require__) {

/* Copyright (c) 2015, Brandon Jones, Colin MacKenzie IV.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE. */

var glMatrix = __webpack_require__(21);

/**
 * @class 4 Dimensional Vector
 * @name vec4
 */
var vec4 = {};

/**
 * Creates a new, empty vec4
 *
 * @returns {vec4} a new 4D vector
 */
vec4.create = function() {
    var out = new glMatrix.ARRAY_TYPE(4);
    out[0] = 0;
    out[1] = 0;
    out[2] = 0;
    out[3] = 0;
    return out;
};

/**
 * Creates a new vec4 initialized with values from an existing vector
 *
 * @param {vec4} a vector to clone
 * @returns {vec4} a new 4D vector
 */
vec4.clone = function(a) {
    var out = new glMatrix.ARRAY_TYPE(4);
    out[0] = a[0];
    out[1] = a[1];
    out[2] = a[2];
    out[3] = a[3];
    return out;
};

/**
 * Creates a new vec4 initialized with the given values
 *
 * @param {Number} x X component
 * @param {Number} y Y component
 * @param {Number} z Z component
 * @param {Number} w W component
 * @returns {vec4} a new 4D vector
 */
vec4.fromValues = function(x, y, z, w) {
    var out = new glMatrix.ARRAY_TYPE(4);
    out[0] = x;
    out[1] = y;
    out[2] = z;
    out[3] = w;
    return out;
};

/**
 * Copy the values from one vec4 to another
 *
 * @param {vec4} out the receiving vector
 * @param {vec4} a the source vector
 * @returns {vec4} out
 */
vec4.copy = function(out, a) {
    out[0] = a[0];
    out[1] = a[1];
    out[2] = a[2];
    out[3] = a[3];
    return out;
};

/**
 * Set the components of a vec4 to the given values
 *
 * @param {vec4} out the receiving vector
 * @param {Number} x X component
 * @param {Number} y Y component
 * @param {Number} z Z component
 * @param {Number} w W component
 * @returns {vec4} out
 */
vec4.set = function(out, x, y, z, w) {
    out[0] = x;
    out[1] = y;
    out[2] = z;
    out[3] = w;
    return out;
};

/**
 * Adds two vec4's
 *
 * @param {vec4} out the receiving vector
 * @param {vec4} a the first operand
 * @param {vec4} b the second operand
 * @returns {vec4} out
 */
vec4.add = function(out, a, b) {
    out[0] = a[0] + b[0];
    out[1] = a[1] + b[1];
    out[2] = a[2] + b[2];
    out[3] = a[3] + b[3];
    return out;
};

/**
 * Subtracts vector b from vector a
 *
 * @param {vec4} out the receiving vector
 * @param {vec4} a the first operand
 * @param {vec4} b the second operand
 * @returns {vec4} out
 */
vec4.subtract = function(out, a, b) {
    out[0] = a[0] - b[0];
    out[1] = a[1] - b[1];
    out[2] = a[2] - b[2];
    out[3] = a[3] - b[3];
    return out;
};

/**
 * Alias for {@link vec4.subtract}
 * @function
 */
vec4.sub = vec4.subtract;

/**
 * Multiplies two vec4's
 *
 * @param {vec4} out the receiving vector
 * @param {vec4} a the first operand
 * @param {vec4} b the second operand
 * @returns {vec4} out
 */
vec4.multiply = function(out, a, b) {
    out[0] = a[0] * b[0];
    out[1] = a[1] * b[1];
    out[2] = a[2] * b[2];
    out[3] = a[3] * b[3];
    return out;
};

/**
 * Alias for {@link vec4.multiply}
 * @function
 */
vec4.mul = vec4.multiply;

/**
 * Divides two vec4's
 *
 * @param {vec4} out the receiving vector
 * @param {vec4} a the first operand
 * @param {vec4} b the second operand
 * @returns {vec4} out
 */
vec4.divide = function(out, a, b) {
    out[0] = a[0] / b[0];
    out[1] = a[1] / b[1];
    out[2] = a[2] / b[2];
    out[3] = a[3] / b[3];
    return out;
};

/**
 * Alias for {@link vec4.divide}
 * @function
 */
vec4.div = vec4.divide;

/**
 * Returns the minimum of two vec4's
 *
 * @param {vec4} out the receiving vector
 * @param {vec4} a the first operand
 * @param {vec4} b the second operand
 * @returns {vec4} out
 */
vec4.min = function(out, a, b) {
    out[0] = Math.min(a[0], b[0]);
    out[1] = Math.min(a[1], b[1]);
    out[2] = Math.min(a[2], b[2]);
    out[3] = Math.min(a[3], b[3]);
    return out;
};

/**
 * Returns the maximum of two vec4's
 *
 * @param {vec4} out the receiving vector
 * @param {vec4} a the first operand
 * @param {vec4} b the second operand
 * @returns {vec4} out
 */
vec4.max = function(out, a, b) {
    out[0] = Math.max(a[0], b[0]);
    out[1] = Math.max(a[1], b[1]);
    out[2] = Math.max(a[2], b[2]);
    out[3] = Math.max(a[3], b[3]);
    return out;
};

/**
 * Scales a vec4 by a scalar number
 *
 * @param {vec4} out the receiving vector
 * @param {vec4} a the vector to scale
 * @param {Number} b amount to scale the vector by
 * @returns {vec4} out
 */
vec4.scale = function(out, a, b) {
    out[0] = a[0] * b;
    out[1] = a[1] * b;
    out[2] = a[2] * b;
    out[3] = a[3] * b;
    return out;
};

/**
 * Adds two vec4's after scaling the second operand by a scalar value
 *
 * @param {vec4} out the receiving vector
 * @param {vec4} a the first operand
 * @param {vec4} b the second operand
 * @param {Number} scale the amount to scale b by before adding
 * @returns {vec4} out
 */
vec4.scaleAndAdd = function(out, a, b, scale) {
    out[0] = a[0] + (b[0] * scale);
    out[1] = a[1] + (b[1] * scale);
    out[2] = a[2] + (b[2] * scale);
    out[3] = a[3] + (b[3] * scale);
    return out;
};

/**
 * Calculates the euclidian distance between two vec4's
 *
 * @param {vec4} a the first operand
 * @param {vec4} b the second operand
 * @returns {Number} distance between a and b
 */
vec4.distance = function(a, b) {
    var x = b[0] - a[0],
        y = b[1] - a[1],
        z = b[2] - a[2],
        w = b[3] - a[3];
    return Math.sqrt(x*x + y*y + z*z + w*w);
};

/**
 * Alias for {@link vec4.distance}
 * @function
 */
vec4.dist = vec4.distance;

/**
 * Calculates the squared euclidian distance between two vec4's
 *
 * @param {vec4} a the first operand
 * @param {vec4} b the second operand
 * @returns {Number} squared distance between a and b
 */
vec4.squaredDistance = function(a, b) {
    var x = b[0] - a[0],
        y = b[1] - a[1],
        z = b[2] - a[2],
        w = b[3] - a[3];
    return x*x + y*y + z*z + w*w;
};

/**
 * Alias for {@link vec4.squaredDistance}
 * @function
 */
vec4.sqrDist = vec4.squaredDistance;

/**
 * Calculates the length of a vec4
 *
 * @param {vec4} a vector to calculate length of
 * @returns {Number} length of a
 */
vec4.length = function (a) {
    var x = a[0],
        y = a[1],
        z = a[2],
        w = a[3];
    return Math.sqrt(x*x + y*y + z*z + w*w);
};

/**
 * Alias for {@link vec4.length}
 * @function
 */
vec4.len = vec4.length;

/**
 * Calculates the squared length of a vec4
 *
 * @param {vec4} a vector to calculate squared length of
 * @returns {Number} squared length of a
 */
vec4.squaredLength = function (a) {
    var x = a[0],
        y = a[1],
        z = a[2],
        w = a[3];
    return x*x + y*y + z*z + w*w;
};

/**
 * Alias for {@link vec4.squaredLength}
 * @function
 */
vec4.sqrLen = vec4.squaredLength;

/**
 * Negates the components of a vec4
 *
 * @param {vec4} out the receiving vector
 * @param {vec4} a vector to negate
 * @returns {vec4} out
 */
vec4.negate = function(out, a) {
    out[0] = -a[0];
    out[1] = -a[1];
    out[2] = -a[2];
    out[3] = -a[3];
    return out;
};

/**
 * Returns the inverse of the components of a vec4
 *
 * @param {vec4} out the receiving vector
 * @param {vec4} a vector to invert
 * @returns {vec4} out
 */
vec4.inverse = function(out, a) {
  out[0] = 1.0 / a[0];
  out[1] = 1.0 / a[1];
  out[2] = 1.0 / a[2];
  out[3] = 1.0 / a[3];
  return out;
};

/**
 * Normalize a vec4
 *
 * @param {vec4} out the receiving vector
 * @param {vec4} a vector to normalize
 * @returns {vec4} out
 */
vec4.normalize = function(out, a) {
    var x = a[0],
        y = a[1],
        z = a[2],
        w = a[3];
    var len = x*x + y*y + z*z + w*w;
    if (len > 0) {
        len = 1 / Math.sqrt(len);
        out[0] = x * len;
        out[1] = y * len;
        out[2] = z * len;
        out[3] = w * len;
    }
    return out;
};

/**
 * Calculates the dot product of two vec4's
 *
 * @param {vec4} a the first operand
 * @param {vec4} b the second operand
 * @returns {Number} dot product of a and b
 */
vec4.dot = function (a, b) {
    return a[0] * b[0] + a[1] * b[1] + a[2] * b[2] + a[3] * b[3];
};

/**
 * Performs a linear interpolation between two vec4's
 *
 * @param {vec4} out the receiving vector
 * @param {vec4} a the first operand
 * @param {vec4} b the second operand
 * @param {Number} t interpolation amount between the two inputs
 * @returns {vec4} out
 */
vec4.lerp = function (out, a, b, t) {
    var ax = a[0],
        ay = a[1],
        az = a[2],
        aw = a[3];
    out[0] = ax + t * (b[0] - ax);
    out[1] = ay + t * (b[1] - ay);
    out[2] = az + t * (b[2] - az);
    out[3] = aw + t * (b[3] - aw);
    return out;
};

/**
 * Generates a random vector with the given scale
 *
 * @param {vec4} out the receiving vector
 * @param {Number} [scale] Length of the resulting vector. If ommitted, a unit vector will be returned
 * @returns {vec4} out
 */
vec4.random = function (out, scale) {
    scale = scale || 1.0;

    //TODO: This is a pretty awful way of doing this. Find something better.
    out[0] = glMatrix.RANDOM();
    out[1] = glMatrix.RANDOM();
    out[2] = glMatrix.RANDOM();
    out[3] = glMatrix.RANDOM();
    vec4.normalize(out, out);
    vec4.scale(out, out, scale);
    return out;
};

/**
 * Transforms the vec4 with a mat4.
 *
 * @param {vec4} out the receiving vector
 * @param {vec4} a the vector to transform
 * @param {mat4} m matrix to transform with
 * @returns {vec4} out
 */
vec4.transformMat4 = function(out, a, m) {
    var x = a[0], y = a[1], z = a[2], w = a[3];
    out[0] = m[0] * x + m[4] * y + m[8] * z + m[12] * w;
    out[1] = m[1] * x + m[5] * y + m[9] * z + m[13] * w;
    out[2] = m[2] * x + m[6] * y + m[10] * z + m[14] * w;
    out[3] = m[3] * x + m[7] * y + m[11] * z + m[15] * w;
    return out;
};

/**
 * Transforms the vec4 with a quat
 *
 * @param {vec4} out the receiving vector
 * @param {vec4} a the vector to transform
 * @param {quat} q quaternion to transform with
 * @returns {vec4} out
 */
vec4.transformQuat = function(out, a, q) {
    var x = a[0], y = a[1], z = a[2],
        qx = q[0], qy = q[1], qz = q[2], qw = q[3],

        // calculate quat * vec
        ix = qw * x + qy * z - qz * y,
        iy = qw * y + qz * x - qx * z,
        iz = qw * z + qx * y - qy * x,
        iw = -qx * x - qy * y - qz * z;

    // calculate result * inverse quat
    out[0] = ix * qw + iw * -qx + iy * -qz - iz * -qy;
    out[1] = iy * qw + iw * -qy + iz * -qx - ix * -qz;
    out[2] = iz * qw + iw * -qz + ix * -qy - iy * -qx;
    out[3] = a[3];
    return out;
};

/**
 * Perform some operation over an array of vec4s.
 *
 * @param {Array} a the array of vectors to iterate over
 * @param {Number} stride Number of elements between the start of each vec4. If 0 assumes tightly packed
 * @param {Number} offset Number of elements to skip at the beginning of the array
 * @param {Number} count Number of vec4s to iterate over. If 0 iterates over entire array
 * @param {Function} fn Function to call for each vector in the array
 * @param {Object} [arg] additional argument to pass to fn
 * @returns {Array} a
 * @function
 */
vec4.forEach = (function() {
    var vec = vec4.create();

    return function(a, stride, offset, count, fn, arg) {
        var i, l;
        if(!stride) {
            stride = 4;
        }

        if(!offset) {
            offset = 0;
        }
        
        if(count) {
            l = Math.min((count * stride) + offset, a.length);
        } else {
            l = a.length;
        }

        for(i = offset; i < l; i += stride) {
            vec[0] = a[i]; vec[1] = a[i+1]; vec[2] = a[i+2]; vec[3] = a[i+3];
            fn(vec, vec, arg);
            a[i] = vec[0]; a[i+1] = vec[1]; a[i+2] = vec[2]; a[i+3] = vec[3];
        }
        
        return a;
    };
})();

/**
 * Returns a string representation of a vector
 *
 * @param {vec4} vec vector to represent as a string
 * @returns {String} string representation of the vector
 */
vec4.str = function (a) {
    return 'vec4(' + a[0] + ', ' + a[1] + ', ' + a[2] + ', ' + a[3] + ')';
};

module.exports = vec4;


/***/ }),

/***/ 12:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.newInstance = exports.STATIC = undefined;
exports.extend = extend;

var _Constants = __webpack_require__(39);

var _Constants2 = _interopRequireDefault(_Constants);

var _macro = __webpack_require__(0);

var _macro2 = _interopRequireDefault(_macro);

var _Math = __webpack_require__(6);

var _Math2 = _interopRequireDefault(_Math);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var DefaultDataType = _Constants2.default.DefaultDataType;

var TUPLE_HOLDER = [];

// ----------------------------------------------------------------------------
// Global methods
// ----------------------------------------------------------------------------

function createRangeHelper() {
  var min = Number.MAX_VALUE;
  var max = -Number.MAX_VALUE;
  var count = 0;
  var sum = 0;

  return {
    add: function add(value) {
      if (min > value) {
        min = value;
      }
      if (max < value) {
        max = value;
      }
      count++;
      sum += value;
    },
    get: function get() {
      return { min: min, max: max, count: count, sum: sum, mean: sum / count };
    },
    getRange: function getRange() {
      return { min: min, max: max };
    }
  };
}

function computeRange(values) {
  var component = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 0;
  var numberOfComponents = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : 1;

  var helper = createRangeHelper();
  var size = values.length;
  var value = 0;

  if (component < 0 && numberOfComponents > 1) {
    // Compute magnitude
    for (var i = 0; i < size; i += numberOfComponents) {
      value = 0;
      for (var j = 0; j < numberOfComponents; j++) {
        value += values[i + j] * values[i + j];
      }
      value = Math.pow(value, 0.5);

      helper.add(value);
    }
    return helper.getRange();
  }

  var offset = component < 0 ? 0 : component;
  for (var _i = offset; _i < size; _i += numberOfComponents) {
    helper.add(values[_i]);
  }

  return helper.getRange();
}

function ensureRangeSize(rangeArray) {
  var size = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 0;

  var ranges = rangeArray || [];
  // Pad ranges with null value to get the
  while (ranges.length <= size) {
    ranges.push(null);
  }
  return ranges;
}

function getDataType(typedArray) {
  return Object.prototype.toString.call(typedArray).split(' ')[1].slice(0, -1);
}

function getMaxNorm(normArray) {
  var numComps = normArray.getNumberOfComponents();
  var maxNorm = 0.0;
  for (var i = 0; i < normArray.getNumberOfTuples(); ++i) {
    var norm = _Math2.default.norm(normArray.getTuple(i), numComps);
    if (norm > maxNorm) {
      maxNorm = norm;
    }
  }
  return maxNorm;
}

// ----------------------------------------------------------------------------
// Static API
// ----------------------------------------------------------------------------

var STATIC = exports.STATIC = {
  computeRange: computeRange,
  createRangeHelper: createRangeHelper,
  getDataType: getDataType,
  getMaxNorm: getMaxNorm
};

// ----------------------------------------------------------------------------
// vtkDataArray methods
// ----------------------------------------------------------------------------

function vtkDataArray(publicAPI, model) {
  // Set our className
  model.classHierarchy.push('vtkDataArray');

  function dataChange() {
    model.ranges = null;
    publicAPI.modified();
  }

  publicAPI.getElementComponentSize = function () {
    return model.values.BYTES_PER_ELEMENT;
  };

  // Description:
  // Return the data component at the location specified by tupleIdx and
  // compIdx.
  publicAPI.getComponent = function (tupleIdx) {
    var compIdx = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 0;
    return model.values[tupleIdx * model.numberOfComponents + compIdx];
  };

  // Description:
  // Set the data component at the location specified by tupleIdx and compIdx
  // to value.
  // Note that i is less than NumberOfTuples and j is less than
  //  NumberOfComponents. Make sure enough memory has been allocated
  // (use SetNumberOfTuples() and SetNumberOfComponents()).
  publicAPI.setComponent = function (tupleIdx, compIdx, value) {
    if (value !== model.values[tupleIdx * model.numberOfComponents + compIdx]) {
      model.values[tupleIdx * model.numberOfComponents + compIdx] = value;
      dataChange();
    }
  };

  publicAPI.getData = function () {
    return model.values;
  };

  publicAPI.getRange = function () {
    var componentIndex = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : -1;

    var rangeIdx = componentIndex < 0 ? model.numberOfComponents : componentIndex;
    var range = null;

    if (!model.ranges) {
      model.ranges = ensureRangeSize(model.ranges, model.numberOfComponents);
    }
    range = model.ranges[rangeIdx];

    if (range) {
      model.rangeTuple[0] = range.min;
      model.rangeTuple[1] = range.max;
      return model.rangeTuple;
    }

    // Need to compute ranges...
    range = computeRange(model.values, componentIndex, model.numberOfComponents);
    model.ranges[rangeIdx] = range;
    model.rangeTuple[0] = range.min;
    model.rangeTuple[1] = range.max;
    return model.rangeTuple;
  };

  publicAPI.setTuple = function (idx, tuple) {
    var offset = idx * model.numberOfComponents;
    for (var i = 0; i < model.numberOfComponents; i++) {
      model.values[offset + i] = tuple[i];
    }
  };

  publicAPI.getTuple = function (idx) {
    var tupleToFill = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : TUPLE_HOLDER;

    var numberOfComponents = model.numberOfComponents || 1;
    if (tupleToFill.length) {
      tupleToFill.length = numberOfComponents;
    }
    var offset = idx * numberOfComponents;
    for (var i = 0; i < numberOfComponents; i++) {
      tupleToFill[i] = model.values[offset + i];
    }
    return tupleToFill;
  };

  publicAPI.getTupleLocation = function () {
    var idx = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 1;
    return idx * model.numberOfComponents;
  };
  publicAPI.getNumberOfComponents = function () {
    return model.numberOfComponents;
  };
  publicAPI.getNumberOfValues = function () {
    return model.values.length;
  };
  publicAPI.getNumberOfTuples = function () {
    return model.values.length / model.numberOfComponents;
  };
  publicAPI.getDataType = function () {
    return model.dataType;
  };
  /* eslint-disable no-use-before-define */
  publicAPI.newClone = function () {
    return newInstance({
      empty: true,
      name: model.name,
      dataType: model.dataType,
      numberOfComponents: model.numberOfComponents
    });
  };
  /* eslint-enable no-use-before-define */

  publicAPI.getName = function () {
    if (!model.name) {
      publicAPI.modified();
      model.name = 'vtkDataArray' + publicAPI.getMTime();
    }
    return model.name;
  };

  publicAPI.setData = function (typedArray, numberOfComponents) {
    model.values = typedArray;
    model.size = typedArray.length;
    model.dataType = getDataType(typedArray);
    if (numberOfComponents) {
      model.numberOfComponents = numberOfComponents;
    }
    if (model.size % model.numberOfComponents !== 0) {
      model.numberOfComponents = 1;
    }
    dataChange();
  };

  /* eslint-disable no-use-before-define */
  publicAPI.shallowCopy = function () {
    return newInstance(Object.assign({}, model));
  };
  /* eslint-enable no-use-before-define */

  // Override serialization support
  publicAPI.getState = function () {
    var jsonArchive = Object.assign({}, model, {
      vtkClass: publicAPI.getClassName()
    });

    // Convert typed array to regular array
    jsonArchive.values = Array.from(jsonArchive.values);
    delete jsonArchive.buffer;

    // Clean any empty data
    Object.keys(jsonArchive).forEach(function (keyName) {
      if (!jsonArchive[keyName]) {
        delete jsonArchive[keyName];
      }
    });

    // Sort resulting object by key name
    var sortedObj = {};
    Object.keys(jsonArchive).sort().forEach(function (name) {
      sortedObj[name] = jsonArchive[name];
    });

    // Remove mtime
    if (sortedObj.mtime) {
      delete sortedObj.mtime;
    }

    return sortedObj;
  };
}

// ----------------------------------------------------------------------------
// Object factory
// ----------------------------------------------------------------------------

var DEFAULT_VALUES = {
  name: '',
  numberOfComponents: 1,
  size: 0,
  dataType: DefaultDataType,
  rangeTuple: [0, 0]
  // values: null,
  // ranges: null,
};

// ----------------------------------------------------------------------------

function extend(publicAPI, model) {
  var initialValues = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : {};

  Object.assign(model, DEFAULT_VALUES, initialValues);

  if (!model.empty && !model.values && !model.size) {
    throw new TypeError('Cannot create vtkDataArray object without: size > 0, values');
  }

  if (!model.values) {
    model.values = new window[model.dataType](model.size);
  } else if (Array.isArray(model.values)) {
    model.values = window[model.dataType].from(model.values);
  }

  if (model.values) {
    model.size = model.values.length;
    model.dataType = getDataType(model.values);
  }

  // Object methods
  _macro2.default.obj(publicAPI, model);
  _macro2.default.set(publicAPI, model, ['name', 'numberOfComponents']);

  // Object specific methods
  vtkDataArray(publicAPI, model);
}

// ----------------------------------------------------------------------------

var newInstance = exports.newInstance = _macro2.default.newInstance(extend, 'vtkDataArray');

// ----------------------------------------------------------------------------

exports.default = Object.assign({ newInstance: newInstance, extend: extend }, STATIC, _Constants2.default);

/***/ }),

/***/ 14:
/***/ (function(module, exports) {

module.exports = function() {
	throw new Error("define cannot be used indirect");
};


/***/ }),

/***/ 15:
/***/ (function(module, exports, __webpack_require__) {

/**
 * @fileoverview gl-matrix - High performance matrix and vector operations
 * @author Brandon Jones
 * @author Colin MacKenzie IV
 * @version 2.3.0
 */

/* Copyright (c) 2015, Brandon Jones, Colin MacKenzie IV.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE. */
// END HEADER

exports.glMatrix = __webpack_require__(21);
exports.mat2 = __webpack_require__(215);
exports.mat2d = __webpack_require__(216);
exports.mat3 = __webpack_require__(116);
exports.mat4 = __webpack_require__(217);
exports.quat = __webpack_require__(218);
exports.vec2 = __webpack_require__(219);
exports.vec3 = __webpack_require__(117);
exports.vec4 = __webpack_require__(118);

/***/ }),

/***/ 151:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _slicedToArray = function () { function sliceIterator(arr, i) { var _arr = []; var _n = true; var _d = false; var _e = undefined; try { for (var _i = arr[Symbol.iterator](), _s; !(_n = (_s = _i.next()).done); _n = true) { _arr.push(_s.value); if (i && _arr.length === i) break; } } catch (err) { _d = true; _e = err; } finally { try { if (!_n && _i["return"]) _i["return"](); } finally { if (_d) throw _e; } } return _arr; } return function (arr, i) { if (Array.isArray(arr)) { return arr; } else if (Symbol.iterator in Object(arr)) { return sliceIterator(arr, i); } else { throw new TypeError("Invalid attempt to destructure non-iterable instance"); } }; }();

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _get = function get(object, property, receiver) { if (object === null) object = Function.prototype; var desc = Object.getOwnPropertyDescriptor(object, property); if (desc === undefined) { var parent = Object.getPrototypeOf(object); if (parent === null) { return undefined; } else { return get(parent, property, receiver); } } else if ("value" in desc) { return desc.value; } else { var getter = desc.get; if (getter === undefined) { return undefined; } return getter.call(receiver); } };

function _toArray(arr) { return Array.isArray(arr) ? arr : Array.from(arr); }

function _toConsumableArray(arr) { if (Array.isArray(arr)) { for (var i = 0, arr2 = Array(arr.length); i < arr.length; i++) { arr2[i] = arr[i]; } return arr2; } else { return Array.from(arr); } }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var TinyEmitter = __webpack_require__(236);

var MESSAGE_RESULT = 0;
var MESSAGE_EVENT = 1;

var RESULT_ERROR = 0;
var RESULT_SUCCESS = 1;

var Worker = function (_TinyEmitter) {
  _inherits(Worker, _TinyEmitter);

  /**
   *
   * @param worker {Worker}
   */
  function Worker(worker) {
    _classCallCheck(this, Worker);

    var _this = _possibleConstructorReturn(this, (Worker.__proto__ || Object.getPrototypeOf(Worker)).call(this));

    _this._messageId = 1;
    _this._messages = new Map();

    _this._worker = worker;
    _this._worker.onmessage = _this._onMessage.bind(_this);
    _this._id = Math.ceil(Math.random() * 10000000);
    return _this;
  }

  _createClass(Worker, [{
    key: 'terminate',
    value: function terminate() {
      this._worker.terminate();
    }

    /**
     * return true if there is no unresolved jobs
     * @returns {boolean}
     */

  }, {
    key: 'isFree',
    value: function isFree() {
      return this._messages.size === 0;
    }
  }, {
    key: 'jobsLength',
    value: function jobsLength() {
      return this._messages.size;
    }

    /**
     * @param operationName string
     * @param data any
     * @param transferable array
     * @param onEvent function
     * @returns {Promise}
     */

  }, {
    key: 'exec',
    value: function exec(operationName) {
      var data = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : null;

      var _this2 = this;

      var transferable = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : [];
      var onEvent = arguments[3];

      return new Promise(function (res, rej) {
        var messageId = _this2._messageId++;
        _this2._messages.set(messageId, [res, rej, onEvent]);
        _this2._worker.postMessage([messageId, data, operationName], transferable || []);
      });
    }

    /**
     *
     * @param data any
     * @param transferable array
     * @param onEvent function
     * @returns {Promise}
     */

  }, {
    key: 'postMessage',
    value: function postMessage() {
      var data = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : null;

      var _this3 = this;

      var transferable = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : [];
      var onEvent = arguments[2];

      return new Promise(function (res, rej) {
        var messageId = _this3._messageId++;
        _this3._messages.set(messageId, [res, rej, onEvent]);
        _this3._worker.postMessage([messageId, data], transferable || []);
      });
    }
  }, {
    key: 'emit',
    value: function emit(eventName) {
      for (var _len = arguments.length, args = Array(_len > 1 ? _len - 1 : 0), _key = 1; _key < _len; _key++) {
        args[_key - 1] = arguments[_key];
      }

      this._worker.postMessage({ eventName: eventName, args: args });
    }
  }, {
    key: '_onMessage',
    value: function _onMessage(e) {
      //if we got usual event, just emit it locally
      if (!Array.isArray(e.data) && e.data.eventName) {
        var _get2;

        return (_get2 = _get(Worker.prototype.__proto__ || Object.getPrototypeOf(Worker.prototype), 'emit', this)).call.apply(_get2, [this, e.data.eventName].concat(_toConsumableArray(e.data.args)));
      }

      var _e$data = _toArray(e.data),
          type = _e$data[0],
          args = _e$data.slice(1);

      if (type === MESSAGE_EVENT) this._onEvent.apply(this, _toConsumableArray(args));else if (type === MESSAGE_RESULT) this._onResult.apply(this, _toConsumableArray(args));else throw new Error('Wrong message type \'' + type + '\'');
    }
  }, {
    key: '_onResult',
    value: function _onResult(messageId, success, payload) {
      var _messages$get = this._messages.get(messageId),
          _messages$get2 = _slicedToArray(_messages$get, 2),
          res = _messages$get2[0],
          rej = _messages$get2[1];

      this._messages.delete(messageId);

      return success === RESULT_SUCCESS ? res(payload) : rej(payload);
    }
  }, {
    key: '_onEvent',
    value: function _onEvent(messageId, eventName, data) {
      var _messages$get3 = this._messages.get(messageId),
          _messages$get4 = _slicedToArray(_messages$get3, 3),
          onEvent = _messages$get4[2];

      if (onEvent) {
        onEvent(eventName, data);
      }
    }
  }]);

  return Worker;
}(TinyEmitter);

module.exports = Worker;

/***/ }),

/***/ 20:
/***/ (function(module, exports) {

var g;

// This works in non-strict mode
g = (function() {
	return this;
})();

try {
	// This works if eval is allowed (see CSP)
	g = g || Function("return this")() || (1,eval)("this");
} catch(e) {
	// This works if the window reference is available
	if(typeof window === "object")
		g = window;
}

// g can still be undefined, but nothing to do about it...
// We return undefined, instead of nothing here, so it's
// easier to handle this case. if(!global) { ...}

module.exports = g;


/***/ }),

/***/ 201:
/***/ (function(module, exports, __webpack_require__) {

// A library of seedable RNGs implemented in Javascript.
//
// Usage:
//
// var seedrandom = require('seedrandom');
// var random = seedrandom(1); // or any seed.
// var x = random();       // 0 <= x < 1.  Every bit is random.
// var x = random.quick(); // 0 <= x < 1.  32 bits of randomness.

// alea, a 53-bit multiply-with-carry generator by Johannes Baagøe.
// Period: ~2^116
// Reported to pass all BigCrush tests.
var alea = __webpack_require__(202);

// xor128, a pure xor-shift generator by George Marsaglia.
// Period: 2^128-1.
// Reported to fail: MatrixRank and LinearComp.
var xor128 = __webpack_require__(203);

// xorwow, George Marsaglia's 160-bit xor-shift combined plus weyl.
// Period: 2^192-2^32
// Reported to fail: CollisionOver, SimpPoker, and LinearComp.
var xorwow = __webpack_require__(204);

// xorshift7, by François Panneton and Pierre L'ecuyer, takes
// a different approach: it adds robustness by allowing more shifts
// than Marsaglia's original three.  It is a 7-shift generator
// with 256 bits, that passes BigCrush with no systmatic failures.
// Period 2^256-1.
// No systematic BigCrush failures reported.
var xorshift7 = __webpack_require__(205);

// xor4096, by Richard Brent, is a 4096-bit xor-shift with a
// very long period that also adds a Weyl generator. It also passes
// BigCrush with no systematic failures.  Its long period may
// be useful if you have many generators and need to avoid
// collisions.
// Period: 2^4128-2^32.
// No systematic BigCrush failures reported.
var xor4096 = __webpack_require__(206);

// Tyche-i, by Samuel Neves and Filipe Araujo, is a bit-shifting random
// number generator derived from ChaCha, a modern stream cipher.
// https://eden.dei.uc.pt/~sneves/pubs/2011-snfa2.pdf
// Period: ~2^127
// No systematic BigCrush failures reported.
var tychei = __webpack_require__(207);

// The original ARC4-based prng included in this library.
// Period: ~2^1600
var sr = __webpack_require__(208);

sr.alea = alea;
sr.xor128 = xor128;
sr.xorwow = xorwow;
sr.xorshift7 = xorshift7;
sr.xor4096 = xor4096;
sr.tychei = tychei;

module.exports = sr;


/***/ }),

/***/ 202:
/***/ (function(module, exports, __webpack_require__) {

/* WEBPACK VAR INJECTION */(function(module) {var __WEBPACK_AMD_DEFINE_RESULT__;// A port of an algorithm by Johannes Baagøe <baagoe@baagoe.com>, 2010
// http://baagoe.com/en/RandomMusings/javascript/
// https://github.com/nquinlan/better-random-numbers-for-javascript-mirror
// Original work is under MIT license -

// Copyright (C) 2010 by Johannes Baagøe <baagoe@baagoe.org>
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
// 
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
// 
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.



(function(global, module, define) {

function Alea(seed) {
  var me = this, mash = Mash();

  me.next = function() {
    var t = 2091639 * me.s0 + me.c * 2.3283064365386963e-10; // 2^-32
    me.s0 = me.s1;
    me.s1 = me.s2;
    return me.s2 = t - (me.c = t | 0);
  };

  // Apply the seeding algorithm from Baagoe.
  me.c = 1;
  me.s0 = mash(' ');
  me.s1 = mash(' ');
  me.s2 = mash(' ');
  me.s0 -= mash(seed);
  if (me.s0 < 0) { me.s0 += 1; }
  me.s1 -= mash(seed);
  if (me.s1 < 0) { me.s1 += 1; }
  me.s2 -= mash(seed);
  if (me.s2 < 0) { me.s2 += 1; }
  mash = null;
}

function copy(f, t) {
  t.c = f.c;
  t.s0 = f.s0;
  t.s1 = f.s1;
  t.s2 = f.s2;
  return t;
}

function impl(seed, opts) {
  var xg = new Alea(seed),
      state = opts && opts.state,
      prng = xg.next;
  prng.int32 = function() { return (xg.next() * 0x100000000) | 0; }
  prng.double = function() {
    return prng() + (prng() * 0x200000 | 0) * 1.1102230246251565e-16; // 2^-53
  };
  prng.quick = prng;
  if (state) {
    if (typeof(state) == 'object') copy(state, xg);
    prng.state = function() { return copy(xg, {}); }
  }
  return prng;
}

function Mash() {
  var n = 0xefc8249d;

  var mash = function(data) {
    data = data.toString();
    for (var i = 0; i < data.length; i++) {
      n += data.charCodeAt(i);
      var h = 0.02519603282416938 * n;
      n = h >>> 0;
      h -= n;
      h *= n;
      n = h >>> 0;
      h -= n;
      n += h * 0x100000000; // 2^32
    }
    return (n >>> 0) * 2.3283064365386963e-10; // 2^-32
  };

  return mash;
}


if (module && module.exports) {
  module.exports = impl;
} else if (__webpack_require__(14) && __webpack_require__(31)) {
  !(__WEBPACK_AMD_DEFINE_RESULT__ = (function() { return impl; }).call(exports, __webpack_require__, exports, module),
				__WEBPACK_AMD_DEFINE_RESULT__ !== undefined && (module.exports = __WEBPACK_AMD_DEFINE_RESULT__));
} else {
  this.alea = impl;
}

})(
  this,
  (typeof module) == 'object' && module,    // present in node.js
  __webpack_require__(14)   // present with an AMD loader
);



/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(25)(module)))

/***/ }),

/***/ 203:
/***/ (function(module, exports, __webpack_require__) {

/* WEBPACK VAR INJECTION */(function(module) {var __WEBPACK_AMD_DEFINE_RESULT__;// A Javascript implementaion of the "xor128" prng algorithm by
// George Marsaglia.  See http://www.jstatsoft.org/v08/i14/paper

(function(global, module, define) {

function XorGen(seed) {
  var me = this, strseed = '';

  me.x = 0;
  me.y = 0;
  me.z = 0;
  me.w = 0;

  // Set up generator function.
  me.next = function() {
    var t = me.x ^ (me.x << 11);
    me.x = me.y;
    me.y = me.z;
    me.z = me.w;
    return me.w ^= (me.w >>> 19) ^ t ^ (t >>> 8);
  };

  if (seed === (seed | 0)) {
    // Integer seed.
    me.x = seed;
  } else {
    // String seed.
    strseed += seed;
  }

  // Mix in string seed, then discard an initial batch of 64 values.
  for (var k = 0; k < strseed.length + 64; k++) {
    me.x ^= strseed.charCodeAt(k) | 0;
    me.next();
  }
}

function copy(f, t) {
  t.x = f.x;
  t.y = f.y;
  t.z = f.z;
  t.w = f.w;
  return t;
}

function impl(seed, opts) {
  var xg = new XorGen(seed),
      state = opts && opts.state,
      prng = function() { return (xg.next() >>> 0) / 0x100000000; };
  prng.double = function() {
    do {
      var top = xg.next() >>> 11,
          bot = (xg.next() >>> 0) / 0x100000000,
          result = (top + bot) / (1 << 21);
    } while (result === 0);
    return result;
  };
  prng.int32 = xg.next;
  prng.quick = prng;
  if (state) {
    if (typeof(state) == 'object') copy(state, xg);
    prng.state = function() { return copy(xg, {}); }
  }
  return prng;
}

if (module && module.exports) {
  module.exports = impl;
} else if (__webpack_require__(14) && __webpack_require__(31)) {
  !(__WEBPACK_AMD_DEFINE_RESULT__ = (function() { return impl; }).call(exports, __webpack_require__, exports, module),
				__WEBPACK_AMD_DEFINE_RESULT__ !== undefined && (module.exports = __WEBPACK_AMD_DEFINE_RESULT__));
} else {
  this.xor128 = impl;
}

})(
  this,
  (typeof module) == 'object' && module,    // present in node.js
  __webpack_require__(14)   // present with an AMD loader
);



/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(25)(module)))

/***/ }),

/***/ 204:
/***/ (function(module, exports, __webpack_require__) {

/* WEBPACK VAR INJECTION */(function(module) {var __WEBPACK_AMD_DEFINE_RESULT__;// A Javascript implementaion of the "xorwow" prng algorithm by
// George Marsaglia.  See http://www.jstatsoft.org/v08/i14/paper

(function(global, module, define) {

function XorGen(seed) {
  var me = this, strseed = '';

  // Set up generator function.
  me.next = function() {
    var t = (me.x ^ (me.x >>> 2));
    me.x = me.y; me.y = me.z; me.z = me.w; me.w = me.v;
    return (me.d = (me.d + 362437 | 0)) +
       (me.v = (me.v ^ (me.v << 4)) ^ (t ^ (t << 1))) | 0;
  };

  me.x = 0;
  me.y = 0;
  me.z = 0;
  me.w = 0;
  me.v = 0;

  if (seed === (seed | 0)) {
    // Integer seed.
    me.x = seed;
  } else {
    // String seed.
    strseed += seed;
  }

  // Mix in string seed, then discard an initial batch of 64 values.
  for (var k = 0; k < strseed.length + 64; k++) {
    me.x ^= strseed.charCodeAt(k) | 0;
    if (k == strseed.length) {
      me.d = me.x << 10 ^ me.x >>> 4;
    }
    me.next();
  }
}

function copy(f, t) {
  t.x = f.x;
  t.y = f.y;
  t.z = f.z;
  t.w = f.w;
  t.v = f.v;
  t.d = f.d;
  return t;
}

function impl(seed, opts) {
  var xg = new XorGen(seed),
      state = opts && opts.state,
      prng = function() { return (xg.next() >>> 0) / 0x100000000; };
  prng.double = function() {
    do {
      var top = xg.next() >>> 11,
          bot = (xg.next() >>> 0) / 0x100000000,
          result = (top + bot) / (1 << 21);
    } while (result === 0);
    return result;
  };
  prng.int32 = xg.next;
  prng.quick = prng;
  if (state) {
    if (typeof(state) == 'object') copy(state, xg);
    prng.state = function() { return copy(xg, {}); }
  }
  return prng;
}

if (module && module.exports) {
  module.exports = impl;
} else if (__webpack_require__(14) && __webpack_require__(31)) {
  !(__WEBPACK_AMD_DEFINE_RESULT__ = (function() { return impl; }).call(exports, __webpack_require__, exports, module),
				__WEBPACK_AMD_DEFINE_RESULT__ !== undefined && (module.exports = __WEBPACK_AMD_DEFINE_RESULT__));
} else {
  this.xorwow = impl;
}

})(
  this,
  (typeof module) == 'object' && module,    // present in node.js
  __webpack_require__(14)   // present with an AMD loader
);



/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(25)(module)))

/***/ }),

/***/ 205:
/***/ (function(module, exports, __webpack_require__) {

/* WEBPACK VAR INJECTION */(function(module) {var __WEBPACK_AMD_DEFINE_RESULT__;// A Javascript implementaion of the "xorshift7" algorithm by
// François Panneton and Pierre L'ecuyer:
// "On the Xorgshift Random Number Generators"
// http://saluc.engr.uconn.edu/refs/crypto/rng/panneton05onthexorshift.pdf

(function(global, module, define) {

function XorGen(seed) {
  var me = this;

  // Set up generator function.
  me.next = function() {
    // Update xor generator.
    var X = me.x, i = me.i, t, v, w;
    t = X[i]; t ^= (t >>> 7); v = t ^ (t << 24);
    t = X[(i + 1) & 7]; v ^= t ^ (t >>> 10);
    t = X[(i + 3) & 7]; v ^= t ^ (t >>> 3);
    t = X[(i + 4) & 7]; v ^= t ^ (t << 7);
    t = X[(i + 7) & 7]; t = t ^ (t << 13); v ^= t ^ (t << 9);
    X[i] = v;
    me.i = (i + 1) & 7;
    return v;
  };

  function init(me, seed) {
    var j, w, X = [];

    if (seed === (seed | 0)) {
      // Seed state array using a 32-bit integer.
      w = X[0] = seed;
    } else {
      // Seed state using a string.
      seed = '' + seed;
      for (j = 0; j < seed.length; ++j) {
        X[j & 7] = (X[j & 7] << 15) ^
            (seed.charCodeAt(j) + X[(j + 1) & 7] << 13);
      }
    }
    // Enforce an array length of 8, not all zeroes.
    while (X.length < 8) X.push(0);
    for (j = 0; j < 8 && X[j] === 0; ++j);
    if (j == 8) w = X[7] = -1; else w = X[j];

    me.x = X;
    me.i = 0;

    // Discard an initial 256 values.
    for (j = 256; j > 0; --j) {
      me.next();
    }
  }

  init(me, seed);
}

function copy(f, t) {
  t.x = f.x.slice();
  t.i = f.i;
  return t;
}

function impl(seed, opts) {
  if (seed == null) seed = +(new Date);
  var xg = new XorGen(seed),
      state = opts && opts.state,
      prng = function() { return (xg.next() >>> 0) / 0x100000000; };
  prng.double = function() {
    do {
      var top = xg.next() >>> 11,
          bot = (xg.next() >>> 0) / 0x100000000,
          result = (top + bot) / (1 << 21);
    } while (result === 0);
    return result;
  };
  prng.int32 = xg.next;
  prng.quick = prng;
  if (state) {
    if (state.x) copy(state, xg);
    prng.state = function() { return copy(xg, {}); }
  }
  return prng;
}

if (module && module.exports) {
  module.exports = impl;
} else if (__webpack_require__(14) && __webpack_require__(31)) {
  !(__WEBPACK_AMD_DEFINE_RESULT__ = (function() { return impl; }).call(exports, __webpack_require__, exports, module),
				__WEBPACK_AMD_DEFINE_RESULT__ !== undefined && (module.exports = __WEBPACK_AMD_DEFINE_RESULT__));
} else {
  this.xorshift7 = impl;
}

})(
  this,
  (typeof module) == 'object' && module,    // present in node.js
  __webpack_require__(14)   // present with an AMD loader
);


/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(25)(module)))

/***/ }),

/***/ 206:
/***/ (function(module, exports, __webpack_require__) {

/* WEBPACK VAR INJECTION */(function(module) {var __WEBPACK_AMD_DEFINE_RESULT__;// A Javascript implementaion of Richard Brent's Xorgens xor4096 algorithm.
//
// This fast non-cryptographic random number generator is designed for
// use in Monte-Carlo algorithms. It combines a long-period xorshift
// generator with a Weyl generator, and it passes all common batteries
// of stasticial tests for randomness while consuming only a few nanoseconds
// for each prng generated.  For background on the generator, see Brent's
// paper: "Some long-period random number generators using shifts and xors."
// http://arxiv.org/pdf/1004.3115v1.pdf
//
// Usage:
//
// var xor4096 = require('xor4096');
// random = xor4096(1);                        // Seed with int32 or string.
// assert.equal(random(), 0.1520436450538547); // (0, 1) range, 53 bits.
// assert.equal(random.int32(), 1806534897);   // signed int32, 32 bits.
//
// For nonzero numeric keys, this impelementation provides a sequence
// identical to that by Brent's xorgens 3 implementaion in C.  This
// implementation also provides for initalizing the generator with
// string seeds, or for saving and restoring the state of the generator.
//
// On Chrome, this prng benchmarks about 2.1 times slower than
// Javascript's built-in Math.random().

(function(global, module, define) {

function XorGen(seed) {
  var me = this;

  // Set up generator function.
  me.next = function() {
    var w = me.w,
        X = me.X, i = me.i, t, v;
    // Update Weyl generator.
    me.w = w = (w + 0x61c88647) | 0;
    // Update xor generator.
    v = X[(i + 34) & 127];
    t = X[i = ((i + 1) & 127)];
    v ^= v << 13;
    t ^= t << 17;
    v ^= v >>> 15;
    t ^= t >>> 12;
    // Update Xor generator array state.
    v = X[i] = v ^ t;
    me.i = i;
    // Result is the combination.
    return (v + (w ^ (w >>> 16))) | 0;
  };

  function init(me, seed) {
    var t, v, i, j, w, X = [], limit = 128;
    if (seed === (seed | 0)) {
      // Numeric seeds initialize v, which is used to generates X.
      v = seed;
      seed = null;
    } else {
      // String seeds are mixed into v and X one character at a time.
      seed = seed + '\0';
      v = 0;
      limit = Math.max(limit, seed.length);
    }
    // Initialize circular array and weyl value.
    for (i = 0, j = -32; j < limit; ++j) {
      // Put the unicode characters into the array, and shuffle them.
      if (seed) v ^= seed.charCodeAt((j + 32) % seed.length);
      // After 32 shuffles, take v as the starting w value.
      if (j === 0) w = v;
      v ^= v << 10;
      v ^= v >>> 15;
      v ^= v << 4;
      v ^= v >>> 13;
      if (j >= 0) {
        w = (w + 0x61c88647) | 0;     // Weyl.
        t = (X[j & 127] ^= (v + w));  // Combine xor and weyl to init array.
        i = (0 == t) ? i + 1 : 0;     // Count zeroes.
      }
    }
    // We have detected all zeroes; make the key nonzero.
    if (i >= 128) {
      X[(seed && seed.length || 0) & 127] = -1;
    }
    // Run the generator 512 times to further mix the state before using it.
    // Factoring this as a function slows the main generator, so it is just
    // unrolled here.  The weyl generator is not advanced while warming up.
    i = 127;
    for (j = 4 * 128; j > 0; --j) {
      v = X[(i + 34) & 127];
      t = X[i = ((i + 1) & 127)];
      v ^= v << 13;
      t ^= t << 17;
      v ^= v >>> 15;
      t ^= t >>> 12;
      X[i] = v ^ t;
    }
    // Storing state as object members is faster than using closure variables.
    me.w = w;
    me.X = X;
    me.i = i;
  }

  init(me, seed);
}

function copy(f, t) {
  t.i = f.i;
  t.w = f.w;
  t.X = f.X.slice();
  return t;
};

function impl(seed, opts) {
  if (seed == null) seed = +(new Date);
  var xg = new XorGen(seed),
      state = opts && opts.state,
      prng = function() { return (xg.next() >>> 0) / 0x100000000; };
  prng.double = function() {
    do {
      var top = xg.next() >>> 11,
          bot = (xg.next() >>> 0) / 0x100000000,
          result = (top + bot) / (1 << 21);
    } while (result === 0);
    return result;
  };
  prng.int32 = xg.next;
  prng.quick = prng;
  if (state) {
    if (state.X) copy(state, xg);
    prng.state = function() { return copy(xg, {}); }
  }
  return prng;
}

if (module && module.exports) {
  module.exports = impl;
} else if (__webpack_require__(14) && __webpack_require__(31)) {
  !(__WEBPACK_AMD_DEFINE_RESULT__ = (function() { return impl; }).call(exports, __webpack_require__, exports, module),
				__WEBPACK_AMD_DEFINE_RESULT__ !== undefined && (module.exports = __WEBPACK_AMD_DEFINE_RESULT__));
} else {
  this.xor4096 = impl;
}

})(
  this,                                     // window object or global
  (typeof module) == 'object' && module,    // present in node.js
  __webpack_require__(14)   // present with an AMD loader
);

/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(25)(module)))

/***/ }),

/***/ 207:
/***/ (function(module, exports, __webpack_require__) {

/* WEBPACK VAR INJECTION */(function(module) {var __WEBPACK_AMD_DEFINE_RESULT__;// A Javascript implementaion of the "Tyche-i" prng algorithm by
// Samuel Neves and Filipe Araujo.
// See https://eden.dei.uc.pt/~sneves/pubs/2011-snfa2.pdf

(function(global, module, define) {

function XorGen(seed) {
  var me = this, strseed = '';

  // Set up generator function.
  me.next = function() {
    var b = me.b, c = me.c, d = me.d, a = me.a;
    b = (b << 25) ^ (b >>> 7) ^ c;
    c = (c - d) | 0;
    d = (d << 24) ^ (d >>> 8) ^ a;
    a = (a - b) | 0;
    me.b = b = (b << 20) ^ (b >>> 12) ^ c;
    me.c = c = (c - d) | 0;
    me.d = (d << 16) ^ (c >>> 16) ^ a;
    return me.a = (a - b) | 0;
  };

  /* The following is non-inverted tyche, which has better internal
   * bit diffusion, but which is about 25% slower than tyche-i in JS.
  me.next = function() {
    var a = me.a, b = me.b, c = me.c, d = me.d;
    a = (me.a + me.b | 0) >>> 0;
    d = me.d ^ a; d = d << 16 ^ d >>> 16;
    c = me.c + d | 0;
    b = me.b ^ c; b = b << 12 ^ d >>> 20;
    me.a = a = a + b | 0;
    d = d ^ a; me.d = d = d << 8 ^ d >>> 24;
    me.c = c = c + d | 0;
    b = b ^ c;
    return me.b = (b << 7 ^ b >>> 25);
  }
  */

  me.a = 0;
  me.b = 0;
  me.c = 2654435769 | 0;
  me.d = 1367130551;

  if (seed === Math.floor(seed)) {
    // Integer seed.
    me.a = (seed / 0x100000000) | 0;
    me.b = seed | 0;
  } else {
    // String seed.
    strseed += seed;
  }

  // Mix in string seed, then discard an initial batch of 64 values.
  for (var k = 0; k < strseed.length + 20; k++) {
    me.b ^= strseed.charCodeAt(k) | 0;
    me.next();
  }
}

function copy(f, t) {
  t.a = f.a;
  t.b = f.b;
  t.c = f.c;
  t.d = f.d;
  return t;
};

function impl(seed, opts) {
  var xg = new XorGen(seed),
      state = opts && opts.state,
      prng = function() { return (xg.next() >>> 0) / 0x100000000; };
  prng.double = function() {
    do {
      var top = xg.next() >>> 11,
          bot = (xg.next() >>> 0) / 0x100000000,
          result = (top + bot) / (1 << 21);
    } while (result === 0);
    return result;
  };
  prng.int32 = xg.next;
  prng.quick = prng;
  if (state) {
    if (typeof(state) == 'object') copy(state, xg);
    prng.state = function() { return copy(xg, {}); }
  }
  return prng;
}

if (module && module.exports) {
  module.exports = impl;
} else if (__webpack_require__(14) && __webpack_require__(31)) {
  !(__WEBPACK_AMD_DEFINE_RESULT__ = (function() { return impl; }).call(exports, __webpack_require__, exports, module),
				__WEBPACK_AMD_DEFINE_RESULT__ !== undefined && (module.exports = __WEBPACK_AMD_DEFINE_RESULT__));
} else {
  this.tychei = impl;
}

})(
  this,
  (typeof module) == 'object' && module,    // present in node.js
  __webpack_require__(14)   // present with an AMD loader
);



/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(25)(module)))

/***/ }),

/***/ 208:
/***/ (function(module, exports, __webpack_require__) {

var __WEBPACK_AMD_DEFINE_RESULT__;/*
Copyright 2014 David Bau.

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

*/

(function (pool, math) {
//
// The following constants are related to IEEE 754 limits.
//
var global = this,
    width = 256,        // each RC4 output is 0 <= x < 256
    chunks = 6,         // at least six RC4 outputs for each double
    digits = 52,        // there are 52 significant digits in a double
    rngname = 'random', // rngname: name for Math.random and Math.seedrandom
    startdenom = math.pow(width, chunks),
    significance = math.pow(2, digits),
    overflow = significance * 2,
    mask = width - 1,
    nodecrypto;         // node.js crypto module, initialized at the bottom.

//
// seedrandom()
// This is the seedrandom function described above.
//
function seedrandom(seed, options, callback) {
  var key = [];
  options = (options == true) ? { entropy: true } : (options || {});

  // Flatten the seed string or build one from local entropy if needed.
  var shortseed = mixkey(flatten(
    options.entropy ? [seed, tostring(pool)] :
    (seed == null) ? autoseed() : seed, 3), key);

  // Use the seed to initialize an ARC4 generator.
  var arc4 = new ARC4(key);

  // This function returns a random double in [0, 1) that contains
  // randomness in every bit of the mantissa of the IEEE 754 value.
  var prng = function() {
    var n = arc4.g(chunks),             // Start with a numerator n < 2 ^ 48
        d = startdenom,                 //   and denominator d = 2 ^ 48.
        x = 0;                          //   and no 'extra last byte'.
    while (n < significance) {          // Fill up all significant digits by
      n = (n + x) * width;              //   shifting numerator and
      d *= width;                       //   denominator and generating a
      x = arc4.g(1);                    //   new least-significant-byte.
    }
    while (n >= overflow) {             // To avoid rounding up, before adding
      n /= 2;                           //   last byte, shift everything
      d /= 2;                           //   right using integer math until
      x >>>= 1;                         //   we have exactly the desired bits.
    }
    return (n + x) / d;                 // Form the number within [0, 1).
  };

  prng.int32 = function() { return arc4.g(4) | 0; }
  prng.quick = function() { return arc4.g(4) / 0x100000000; }
  prng.double = prng;

  // Mix the randomness into accumulated entropy.
  mixkey(tostring(arc4.S), pool);

  // Calling convention: what to return as a function of prng, seed, is_math.
  return (options.pass || callback ||
      function(prng, seed, is_math_call, state) {
        if (state) {
          // Load the arc4 state from the given state if it has an S array.
          if (state.S) { copy(state, arc4); }
          // Only provide the .state method if requested via options.state.
          prng.state = function() { return copy(arc4, {}); }
        }

        // If called as a method of Math (Math.seedrandom()), mutate
        // Math.random because that is how seedrandom.js has worked since v1.0.
        if (is_math_call) { math[rngname] = prng; return seed; }

        // Otherwise, it is a newer calling convention, so return the
        // prng directly.
        else return prng;
      })(
  prng,
  shortseed,
  'global' in options ? options.global : (this == math),
  options.state);
}
math['seed' + rngname] = seedrandom;

//
// ARC4
//
// An ARC4 implementation.  The constructor takes a key in the form of
// an array of at most (width) integers that should be 0 <= x < (width).
//
// The g(count) method returns a pseudorandom integer that concatenates
// the next (count) outputs from ARC4.  Its return value is a number x
// that is in the range 0 <= x < (width ^ count).
//
function ARC4(key) {
  var t, keylen = key.length,
      me = this, i = 0, j = me.i = me.j = 0, s = me.S = [];

  // The empty key [] is treated as [0].
  if (!keylen) { key = [keylen++]; }

  // Set up S using the standard key scheduling algorithm.
  while (i < width) {
    s[i] = i++;
  }
  for (i = 0; i < width; i++) {
    s[i] = s[j = mask & (j + key[i % keylen] + (t = s[i]))];
    s[j] = t;
  }

  // The "g" method returns the next (count) outputs as one number.
  (me.g = function(count) {
    // Using instance members instead of closure state nearly doubles speed.
    var t, r = 0,
        i = me.i, j = me.j, s = me.S;
    while (count--) {
      t = s[i = mask & (i + 1)];
      r = r * width + s[mask & ((s[i] = s[j = mask & (j + t)]) + (s[j] = t))];
    }
    me.i = i; me.j = j;
    return r;
    // For robust unpredictability, the function call below automatically
    // discards an initial batch of values.  This is called RC4-drop[256].
    // See http://google.com/search?q=rsa+fluhrer+response&btnI
  })(width);
}

//
// copy()
// Copies internal state of ARC4 to or from a plain object.
//
function copy(f, t) {
  t.i = f.i;
  t.j = f.j;
  t.S = f.S.slice();
  return t;
};

//
// flatten()
// Converts an object tree to nested arrays of strings.
//
function flatten(obj, depth) {
  var result = [], typ = (typeof obj), prop;
  if (depth && typ == 'object') {
    for (prop in obj) {
      try { result.push(flatten(obj[prop], depth - 1)); } catch (e) {}
    }
  }
  return (result.length ? result : typ == 'string' ? obj : obj + '\0');
}

//
// mixkey()
// Mixes a string seed into a key that is an array of integers, and
// returns a shortened string seed that is equivalent to the result key.
//
function mixkey(seed, key) {
  var stringseed = seed + '', smear, j = 0;
  while (j < stringseed.length) {
    key[mask & j] =
      mask & ((smear ^= key[mask & j] * 19) + stringseed.charCodeAt(j++));
  }
  return tostring(key);
}

//
// autoseed()
// Returns an object for autoseeding, using window.crypto and Node crypto
// module if available.
//
function autoseed() {
  try {
    var out;
    if (nodecrypto && (out = nodecrypto.randomBytes)) {
      // The use of 'out' to remember randomBytes makes tight minified code.
      out = out(width);
    } else {
      out = new Uint8Array(width);
      (global.crypto || global.msCrypto).getRandomValues(out);
    }
    return tostring(out);
  } catch (e) {
    var browser = global.navigator,
        plugins = browser && browser.plugins;
    return [+new Date, global, plugins, global.screen, tostring(pool)];
  }
}

//
// tostring()
// Converts an array of charcodes to a string
//
function tostring(a) {
  return String.fromCharCode.apply(0, a);
}

//
// When seedrandom.js is loaded, we immediately mix a few bits
// from the built-in RNG into the entropy pool.  Because we do
// not want to interfere with deterministic PRNG state later,
// seedrandom will not call math.random on its own again after
// initialization.
//
mixkey(math.random(), pool);

//
// Nodejs and AMD support: export the implementation as a module using
// either convention.
//
if ((typeof module) == 'object' && module.exports) {
  module.exports = seedrandom;
  // When in node.js, try using crypto package for autoseeding.
  try {
    nodecrypto = __webpack_require__(209);
  } catch (ex) {}
} else if (true) {
  !(__WEBPACK_AMD_DEFINE_RESULT__ = (function() { return seedrandom; }).call(exports, __webpack_require__, exports, module),
				__WEBPACK_AMD_DEFINE_RESULT__ !== undefined && (module.exports = __WEBPACK_AMD_DEFINE_RESULT__));
}

// End anonymous scope, and pass initial values.
})(
  [],     // pool: entropy pool starts empty
  Math    // math: package containing random, pow, and seedrandom
);


/***/ }),

/***/ 209:
/***/ (function(module, exports) {

/* (ignored) */

/***/ }),

/***/ 21:
/***/ (function(module, exports) {

/* Copyright (c) 2015, Brandon Jones, Colin MacKenzie IV.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE. */

/**
 * @class Common utilities
 * @name glMatrix
 */
var glMatrix = {};

// Constants
glMatrix.EPSILON = 0.000001;
glMatrix.ARRAY_TYPE = (typeof Float32Array !== 'undefined') ? Float32Array : Array;
glMatrix.RANDOM = Math.random;

/**
 * Sets the type of array used when creating new vectors and matrices
 *
 * @param {Type} type Array type, such as Float32Array or Array
 */
glMatrix.setMatrixArrayType = function(type) {
    GLMAT_ARRAY_TYPE = type;
}

var degree = Math.PI / 180;

/**
* Convert Degree To Radian
*
* @param {Number} Angle in Degrees
*/
glMatrix.toRadian = function(a){
     return a * degree;
}

module.exports = glMatrix;


/***/ }),

/***/ 210:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.newInstance = undefined;
exports.extend = extend;

var _macro = __webpack_require__(0);

var _macro2 = _interopRequireDefault(_macro);

var _FieldData = __webpack_require__(211);

var _FieldData2 = _interopRequireDefault(_FieldData);

var _Constants = __webpack_require__(212);

var _Constants2 = _interopRequireDefault(_Constants);

var _DataArray = __webpack_require__(12);

var _DataArray2 = _interopRequireDefault(_DataArray);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var AttributeTypes = _Constants2.default.AttributeTypes,
    AttributeCopyOperations = _Constants2.default.AttributeCopyOperations;
var vtkWarningMacro = _macro2.default.vtkWarningMacro;

// ----------------------------------------------------------------------------
// vtkDataSetAttributes methods
// ----------------------------------------------------------------------------

function vtkDataSetAttributes(publicAPI, model) {
  var attrTypes = ['Scalars', 'Vectors', 'Normals', 'TCoords', 'Tensors', 'GlobalIds', 'PedigreeIds'];

  function cleanAttributeType(attType) {
    // Given an integer or string, convert the result to one of the
    // strings in the "attrTypes" array above or null (if
    // no match is found)
    var cleanAttType = attrTypes.find(function (ee) {
      return AttributeTypes[ee.toUpperCase()] === attType || typeof attType !== 'number' && ee.toLowerCase() === attType.toLowerCase();
    });
    if (typeof cleanAttType === 'undefined') {
      cleanAttType = null;
    }
    return cleanAttType;
  }

  // Set our className
  model.classHierarchy.push('vtkDataSetAttributes');

  publicAPI.checkNumberOfComponents = function (x) {
    return true;
  }; // TODO

  publicAPI.setAttribute = function (arr, uncleanAttType) {
    var attType = cleanAttributeType(uncleanAttType);
    if (arr && attType.toUpperCase() === 'PEDIGREEIDS' && !arr.isA('vtkDataArray')) {
      vtkWarningMacro('Cannot set attribute ' + attType + '. The attribute must be a vtkDataArray.');
      return -1;
    }
    if (arr && !publicAPI.checkNumberOfComponents(arr, attType)) {
      vtkWarningMacro('Cannot set attribute ' + attType + '. Incorrect number of components.');
      return -1;
    }
    var currentAttribute = model['active' + attType];
    if (currentAttribute >= 0 && currentAttribute < model.arrays.length) {
      if (model.arrays[currentAttribute] === arr) {
        return currentAttribute;
      }
      publicAPI.removeArrayByIndex(currentAttribute);
    }

    if (arr) {
      currentAttribute = publicAPI.addArray(arr);
      model['active' + attType] = currentAttribute;
    } else {
      model['active' + attType] = -1;
    }
    publicAPI.modified();
    return model['active' + attType];
  };

  publicAPI.setActiveAttributeByName = function (arrayName, attType) {
    return publicAPI.setActiveAttributeByIndex(publicAPI.getArrayWithIndex(arrayName).index, attType);
  };

  publicAPI.setActiveAttributeByIndex = function (arrayIdx, uncleanAttType) {
    var attType = cleanAttributeType(uncleanAttType);
    if (arrayIdx >= 0 && arrayIdx < model.arrays.length) {
      if (attType.toUpperCase() !== 'PEDIGREEIDS') {
        var arr = publicAPI.getArrayByIndex(arrayIdx);
        if (!arr.isA('vtkDataArray')) {
          vtkWarningMacro('Cannot set attribute ' + attType + '. Only vtkDataArray subclasses can be set as active attributes.');
          return -1;
        }
        if (!publicAPI.checkNumberOfComponents(arr, attType)) {
          vtkWarningMacro('Cannot set attribute ' + attType + '. Incorrect number of components.');
          return -1;
        }
      }
      model['active' + attType] = arrayIdx;
      publicAPI.modified();
      return arrayIdx;
    } else if (arrayIdx === -1) {
      model['active' + attType] = arrayIdx;
      publicAPI.modified();
    }
    return -1;
  };

  publicAPI.getActiveAttribute = function (attType) {
    // Given an integer enum value or a string (with random capitalization),
    // find the matching string in attrTypes.
    var cleanAttType = cleanAttributeType(attType);
    return publicAPI['get' + cleanAttType]();
  };

  // Override to allow proper handling of active attributes
  publicAPI.removeAllArrays = function () {
    model.arrays = [];
    attrTypes.forEach(function (attType) {
      model['active' + attType] = -1;
    });
  };

  // Override to allow proper handling of active attributes
  publicAPI.removeArray = function (arrayName) {
    model.arrays = model.arrays.filter(function (entry, idx) {
      if (arrayName === entry.data.getName()) {
        // Found the array to remove, but is it an active attribute?
        attrTypes.forEach(function (attType) {
          if (idx === model['active' + attType]) {
            model['active' + attType] = -1;
          }
        });
        return false;
      }
      return true;
    });
  };

  // Override to allow proper handling of active attributes
  publicAPI.removeArrayByIndex = function (arrayIdx) {
    model.arrays = model.arrays.filter(function (entry, idx) {
      return idx !== arrayIdx;
    });
    attrTypes.forEach(function (attType) {
      if (arrayIdx === model['active' + attType]) {
        model['active' + attType] = -1;
      }
    });
  };

  attrTypes.forEach(function (value) {
    var activeVal = 'active' + value;
    publicAPI['get' + value] = function () {
      return publicAPI.getArrayByIndex(model[activeVal]);
    };
    publicAPI['set' + value] = function (da) {
      return publicAPI.setAttribute(da, value);
    };
    publicAPI['setActive' + value] = function (arrayName) {
      return publicAPI.setActiveAttributeByIndex(publicAPI.getArrayWithIndex(arrayName).index, value);
    };
    publicAPI['copy' + value + 'Off'] = function () {
      publicAPI.initialize();
      var attType = value.toUpperCase();
      model.copyAttributeFlags[AttributeCopyOperations.PASSDATA][AttributeTypes[attType]] = false;
    };
  });

  publicAPI.initialize = _macro2.default.chain(publicAPI.initialize, function () {
    // Default to copying all attributes in every circumstance:
    model.copyAttributeFlags = [];
    Object.keys(AttributeCopyOperations).filter(function (op) {
      return op !== 'ALLCOPY';
    }).forEach(function (attCopyOp) {
      model.copyAttributeFlags[AttributeCopyOperations[attCopyOp]] = Object.keys(AttributeTypes).filter(function (ty) {
        return ty !== 'NUM_ATTRIBUTES';
      }).reduce(function (a, b) {
        a[AttributeTypes[b]] = true;
        return a;
      }, []);
    });
    // Override some operations where we don't want to copy:
    model.copyAttributeFlags[AttributeCopyOperations.COPYTUPLE][AttributeTypes.GLOBALIDS] = false;
    model.copyAttributeFlags[AttributeCopyOperations.INTERPOLATE][AttributeTypes.GLOBALIDS] = false;
    model.copyAttributeFlags[AttributeCopyOperations.COPYTUPLE][AttributeTypes.PEDIGREEIDS] = false;
  });

  // Process dataArrays if any
  if (model.dataArrays && Object.keys(model.dataArrays).length) {
    Object.keys(model.dataArrays).forEach(function (name) {
      if (!model.dataArrays[name].ref && model.dataArrays[name].type === 'vtkDataArray') {
        publicAPI.addArray(_DataArray2.default.newInstance(model.dataArrays[name]));
      }
    });
  }
}

// ----------------------------------------------------------------------------
// Object factory
// ----------------------------------------------------------------------------

var DEFAULT_VALUES = {
  activeScalars: -1,
  activeVectors: -1,
  activeTensors: -1,
  activeNormals: -1,
  activeTCoords: -1,
  activeGlobalIds: -1,
  activePedigreeIds: -1
};

// ----------------------------------------------------------------------------

function extend(publicAPI, model) {
  var initialValues = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : {};

  Object.assign(model, DEFAULT_VALUES, initialValues);

  // Object methods
  _FieldData2.default.extend(publicAPI, model, initialValues);
  _macro2.default.setGet(publicAPI, model, ['activeScalars', 'activeNormals', 'activeTCoords', 'activeVectors', 'activeTensors', 'activeGlobalIds', 'activePedigreeIds']);

  if (!model.arrays) {
    model.arrays = {};
  }

  // Object specific methods
  vtkDataSetAttributes(publicAPI, model);
}

// ----------------------------------------------------------------------------

var newInstance = exports.newInstance = _macro2.default.newInstance(extend, 'vtkDataSetAttributes');

// ----------------------------------------------------------------------------

exports.default = Object.assign({ newInstance: newInstance, extend: extend }, _Constants2.default);

/***/ }),

/***/ 211:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.newInstance = undefined;
exports.extend = extend;

var _vtk = __webpack_require__(52);

var _vtk2 = _interopRequireDefault(_vtk);

var _macro = __webpack_require__(0);

var _macro2 = _interopRequireDefault(_macro);

var _DataArray = __webpack_require__(12);

var _DataArray2 = _interopRequireDefault(_DataArray);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

// ----------------------------------------------------------------------------
// vtkFieldData methods
// ----------------------------------------------------------------------------

function vtkFieldData(publicAPI, model) {
  model.classHierarchy.push('vtkFieldData');
  var superGetState = publicAPI.getState;

  // Decode serialized data if any
  if (model.arrays) {
    model.arrays = model.arrays.map(function (item) {
      return { data: (0, _vtk2.default)(item.data) };
    });
  }

  publicAPI.initialize = function () {
    publicAPI.initializeFields();
    publicAPI.copyAllOn();
    publicAPI.clearFieldFlags();
  };

  publicAPI.initializeFields = function () {
    model.arrays = [];
    model.copyFieldFlags = {};
    publicAPI.modified();
  };

  publicAPI.copyStructure = function (other) {
    publicAPI.initializeFields();
    model.copyFieldFlags = other.getCopyFieldFlags().map(function (x) {
      return x;
    }); // Deep-copy
    model.arrays = other.arrays().map(function (x) {
      return { array: x };
    }); // Deep-copy
    // TODO: Copy array information objects (once we support information objects)
  };

  publicAPI.getNumberOfArrays = function () {
    return model.arrays.length;
  };
  publicAPI.getNumberOfActiveArrays = function () {
    return model.arrays.length;
  };
  publicAPI.addArray = function (arr) {
    model.arrays = [].concat(model.arrays, { data: arr });
    return model.arrays.length - 1;
  };
  publicAPI.removeAllArrays = function () {
    model.arrays = [];
  };
  publicAPI.removeArray = function (arrayName) {
    model.arrays = model.arrays.filter(function (entry) {
      return arrayName !== entry.data.getName();
    });
  };
  publicAPI.removeArrayByIndex = function (arrayIdx) {
    model.arrays = model.arrays.filter(function (entry, idx) {
      return idx !== arrayIdx;
    });
  };
  publicAPI.getArrays = function () {
    return model.arrays.map(function (entry) {
      return entry.data;
    });
  };
  publicAPI.getArray = function (arraySpec) {
    return typeof arraySpec === 'number' ? publicAPI.getArrayByIndex(arraySpec) : publicAPI.getArrayByName(arraySpec);
  };
  publicAPI.getArrayByName = function (arrayName) {
    return model.arrays.reduce(function (a, b, i) {
      return b.data.getName() === arrayName ? b.data : a;
    }, null);
  };
  publicAPI.getArrayWithIndex = function (arrayName) {
    return model.arrays.reduce(function (a, b, i) {
      return b.data && b.data.getName() === arrayName ? { array: b.data, index: i } : a;
    }, { array: null, index: -1 });
  };
  publicAPI.getArrayByIndex = function (idx) {
    return idx >= 0 && idx < model.arrays.length ? model.arrays[idx].data : null;
  };
  publicAPI.hasArray = function (arrayName) {
    return publicAPI.getArrayWithIndex(arrayName).index >= 0;
  };
  publicAPI.getArrayName = function (idx) {
    var arr = model.arrays[idx];
    return arr ? arr.data.getName() : '';
  };
  publicAPI.getCopyFieldFlags = function () {
    return model.copyFieldFlags;
  };
  publicAPI.getFlag = function (arrayName) {
    return model.copyFieldFlags[arrayName];
  };
  publicAPI.passData = function (other) {
    var fromId = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : -1;
    var toId = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : -1;

    other.getArrays().forEach(function (arr) {
      var copyFlag = publicAPI.getFlag(arr.getName());
      if (copyFlag !== false && !(model.doCopyAllOff && copyFlag !== true) && arr) {
        var destArr = publicAPI.getArrayByName(arr.getName());
        if (!destArr) {
          if (fromId < 0 || fromId > arr.getNumberOfTuples()) {
            publicAPI.addArray(arr);
          } else {
            var ncomps = arr.getNumberOfComponents();
            var newSize = arr.getNumberOfValues();
            var tId = toId > -1 ? toId : fromId;
            if (newSize < tId * ncomps) {
              newSize = (tId + 1) * ncomps;
            }
            destArr = _DataArray2.default.newInstance({
              name: arr.getName(),
              dataType: arr.getDataType(),
              numberOfComponents: arr.getNumberOfComponents(),
              size: newSize
            });
            destArr.setTuple(tId, arr.getTuple(fromId));
            publicAPI.addArray(destArr);
          }
        } else if (arr.getNumberOfComponents() === destArr.getNumberOfComponents()) {
          if (fromId > -1 && fromId < arr.getNumberOfTuples()) {
            var _tId = toId > -1 ? toId : fromId;
            destArr.setTuple(_tId, arr.getTuple(fromId));
          } else {
            // if fromId and not provided, just copy all (or as much possible)
            // of arr to destArr.
            for (var i = 0; i < arr.getNumberOfTuples(); ++i) {
              destArr.setTuple(i, arr.getTuple(i));
            }
          }
        }
      }
    });
  };
  publicAPI.copyFieldOn = function (arrayName) {
    model.copyFieldFlags[arrayName] = true;
  };
  publicAPI.copyFieldOff = function (arrayName) {
    model.copyFieldFlags[arrayName] = false;
  };
  publicAPI.copyAllOn = function () {
    if (!model.doCopyAllOn || model.doCopyAllOff) {
      model.doCopyAllOn = true;
      model.doCopyAllOff = false;
      publicAPI.modified();
    }
  };
  publicAPI.copyAllOff = function () {
    if (model.doCopyAllOn || !model.doCopyAllOff) {
      model.doCopyAllOn = false;
      model.doCopyAllOff = true;
      publicAPI.modified();
    }
  };
  publicAPI.clearFieldFlags = function () {
    model.copyFieldFlags = {};
  };
  publicAPI.deepCopy = function (other) {
    model.arrays = other.getArrays().map(function (arr) {
      var arrNew = arr.newClone();
      arrNew.deepCopy(arr);
      return { data: arrNew };
    });
  };
  publicAPI.copyFlags = function (other) {
    return other.getCopyFieldFlags().map(function (x) {
      return x;
    });
  };
  // TODO: publicAPI.squeeze = () => model.arrays.forEach(entry => entry.data.squeeze());
  publicAPI.reset = function () {
    return model.arrays.forEach(function (entry) {
      return entry.data.reset();
    });
  };
  // TODO: getActualMemorySize
  publicAPI.getMTime = function () {
    return model.arrays.reduce(function (a, b) {
      return b.data.getMTime() > a ? b.data.getMTime() : a;
    }, model.mtime);
  };
  // TODO: publicAPI.getField = (ids, other) => { copy ids from other into this model's arrays }
  // TODO: publicAPI.getArrayContainingComponent = (component) => ...
  publicAPI.getNumberOfComponents = function () {
    return model.arrays.reduce(function (a, b) {
      return a + b.data.getNumberOfComponents();
    }, 0);
  };
  publicAPI.getNumberOfTuples = function () {
    return model.arrays.length > 0 ? model.arrays[0].getNumberOfTuples() : 0;
  };

  publicAPI.getState = function () {
    var result = superGetState();
    result.arrays = model.arrays.map(function (item) {
      return {
        data: item.data.getState()
      };
    });
    return result;
  };
}

var DEFAULT_VALUES = {
  arrays: [],
  copyFieldFlags: [], // fields not to copy
  doCopyAllOn: true,
  doCopyAllOff: false
};

function extend(publicAPI, model) {
  var initialValues = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : {};

  Object.assign(model, DEFAULT_VALUES, initialValues);

  _macro2.default.obj(publicAPI, model);

  vtkFieldData(publicAPI, model);
}

// ----------------------------------------------------------------------------

var newInstance = exports.newInstance = _macro2.default.newInstance(extend, 'vtkFieldData');

// ----------------------------------------------------------------------------

exports.default = { newInstance: newInstance, extend: extend };

/***/ }),

/***/ 212:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});
var AttributeTypes = exports.AttributeTypes = {
  SCALARS: 0,
  VECTORS: 1,
  NORMALS: 2,
  TCOORDS: 3,
  TENSORS: 4,
  GLOBALIDS: 5,
  PEDIGREEIDS: 6,
  EDGEFLAG: 7,
  NUM_ATTRIBUTES: 8
};

var AttributeLimitTypes = exports.AttributeLimitTypes = {
  MAX: 0,
  EXACT: 1,
  NOLIMIT: 2
};

var CellGhostTypes = exports.CellGhostTypes = {
  DUPLICATECELL: 1, // the cell is present on multiple processors
  HIGHCONNECTIVITYCELL: 2, // the cell has more neighbors than in a regular mesh
  LOWCONNECTIVITYCELL: 4, // the cell has less neighbors than in a regular mesh
  REFINEDCELL: 8, // other cells are present that refines it.
  EXTERIORCELL: 16, // the cell is on the exterior of the data set
  HIDDENCELL: 32 // the cell is needed to maintain connectivity, but the data values should be ignored.
};

var PointGhostTypes = exports.PointGhostTypes = {
  DUPLICATEPOINT: 1, // the cell is present on multiple processors
  HIDDENPOINT: 2 // the point is needed to maintain connectivity, but the data values should be ignored.
};

var AttributeCopyOperations = exports.AttributeCopyOperations = {
  COPYTUPLE: 0,
  INTERPOLATE: 1,
  PASSDATA: 2,
  ALLCOPY: 3 // all of the above
};

var ghostArrayName = exports.ghostArrayName = 'vtkGhostType';

var DesiredOutputPrecision = exports.DesiredOutputPrecision = {
  DEFAULT: 0, // use the point type that does not truncate any data
  SINGLE: 1, // use Float32Array
  DOUBLE: 2 // use Float64Array
};

exports.default = {
  AttributeCopyOperations: AttributeCopyOperations,
  AttributeLimitTypes: AttributeLimitTypes,
  AttributeTypes: AttributeTypes,
  CellGhostTypes: CellGhostTypes,
  DesiredOutputPrecision: DesiredOutputPrecision,
  PointGhostTypes: PointGhostTypes,
  ghostArrayName: ghostArrayName
};

/***/ }),

/***/ 213:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});
// Specify how data arrays can be used by data objects
var FieldDataTypes = exports.FieldDataTypes = {
  UNIFORM: 0, // data that does not vary over points/cells/etc.
  DATA_OBJECT_FIELD: 0, // to match VTK

  COORDINATE: 1, // data that specifies the location of each point
  POINT_DATA: 1, // to match VTK

  POINT: 2, // data defined at each point, but that does not specify the point location
  POINT_FIELD_DATA: 2, // to match VTK

  CELL: 3, // data defined at each cell, but that does not specify the cell
  CELL_FIELD_DATA: 3, // to match VTK

  VERTEX: 4, // data defined at each graph vertex, but that does not specify the graph vertex
  VERTEX_FIELD_DATA: 4, // to match VTK

  EDGE: 5, // data defined at each graph edge, but that does not specify the graph edge
  EDGE_FIELD_DATA: 5, // to match VTK

  ROW: 6, // data specifying a table row
  ROW_DATA: 6 // to match VTK
};

var FieldAssociations = exports.FieldAssociations = {
  FIELD_ASSOCIATION_POINTS: 0,
  FIELD_ASSOCIATION_CELLS: 1,
  FIELD_ASSOCIATION_NONE: 2,
  FIELD_ASSOCIATION_POINTS_THEN_CELLS: 3,
  FIELD_ASSOCIATION_VERTICES: 4,
  FIELD_ASSOCIATION_EDGES: 5,
  FIELD_ASSOCIATION_ROWS: 6,
  NUMBER_OF_ASSOCIATIONS: 7
};

exports.default = {
  FieldDataTypes: FieldDataTypes,
  FieldAssociations: FieldAssociations
};

/***/ }),

/***/ 214:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.getDataDescriptionFromExtent = getDataDescriptionFromExtent;

var _Constants = __webpack_require__(115);

var _Constants2 = _interopRequireDefault(_Constants);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var StructuredType = _Constants2.default.StructuredType;
function getDataDescriptionFromExtent(inExt) {
  var dataDim = 0;
  for (var i = 0; i < 3; ++i) {
    if (inExt[i * 2] < inExt[i * 2 + 1]) {
      dataDim++;
    }
  }

  if (inExt[0] > inExt[1] || inExt[2] > inExt[3] || inExt[4] > inExt[5]) {
    return StructuredType.EMPTY;
  }

  if (dataDim === 3) {
    return StructuredType.XYZ_GRID;
  } else if (dataDim === 2) {
    if (inExt[0] === inExt[1]) {
      return StructuredType.YZ_PLANE;
    } else if (inExt[2] === inExt[3]) {
      return StructuredType.XZ_PLANE;
    }
    return StructuredType.XY_PLANE;
  } else if (dataDim === 1) {
    if (inExt[0] < inExt[1]) {
      return StructuredType.X_LINE;
    } else if (inExt[2] < inExt[3]) {
      return StructuredType.Y_LINE;
    }
    return StructuredType.Z_LINE;
  }

  return StructuredType.SINGLE_POINT;
}

exports.default = Object.assign({ getDataDescriptionFromExtent: getDataDescriptionFromExtent }, _Constants2.default);

/***/ }),

/***/ 215:
/***/ (function(module, exports, __webpack_require__) {

/* Copyright (c) 2015, Brandon Jones, Colin MacKenzie IV.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE. */

var glMatrix = __webpack_require__(21);

/**
 * @class 2x2 Matrix
 * @name mat2
 */
var mat2 = {};

/**
 * Creates a new identity mat2
 *
 * @returns {mat2} a new 2x2 matrix
 */
mat2.create = function() {
    var out = new glMatrix.ARRAY_TYPE(4);
    out[0] = 1;
    out[1] = 0;
    out[2] = 0;
    out[3] = 1;
    return out;
};

/**
 * Creates a new mat2 initialized with values from an existing matrix
 *
 * @param {mat2} a matrix to clone
 * @returns {mat2} a new 2x2 matrix
 */
mat2.clone = function(a) {
    var out = new glMatrix.ARRAY_TYPE(4);
    out[0] = a[0];
    out[1] = a[1];
    out[2] = a[2];
    out[3] = a[3];
    return out;
};

/**
 * Copy the values from one mat2 to another
 *
 * @param {mat2} out the receiving matrix
 * @param {mat2} a the source matrix
 * @returns {mat2} out
 */
mat2.copy = function(out, a) {
    out[0] = a[0];
    out[1] = a[1];
    out[2] = a[2];
    out[3] = a[3];
    return out;
};

/**
 * Set a mat2 to the identity matrix
 *
 * @param {mat2} out the receiving matrix
 * @returns {mat2} out
 */
mat2.identity = function(out) {
    out[0] = 1;
    out[1] = 0;
    out[2] = 0;
    out[3] = 1;
    return out;
};

/**
 * Transpose the values of a mat2
 *
 * @param {mat2} out the receiving matrix
 * @param {mat2} a the source matrix
 * @returns {mat2} out
 */
mat2.transpose = function(out, a) {
    // If we are transposing ourselves we can skip a few steps but have to cache some values
    if (out === a) {
        var a1 = a[1];
        out[1] = a[2];
        out[2] = a1;
    } else {
        out[0] = a[0];
        out[1] = a[2];
        out[2] = a[1];
        out[3] = a[3];
    }
    
    return out;
};

/**
 * Inverts a mat2
 *
 * @param {mat2} out the receiving matrix
 * @param {mat2} a the source matrix
 * @returns {mat2} out
 */
mat2.invert = function(out, a) {
    var a0 = a[0], a1 = a[1], a2 = a[2], a3 = a[3],

        // Calculate the determinant
        det = a0 * a3 - a2 * a1;

    if (!det) {
        return null;
    }
    det = 1.0 / det;
    
    out[0] =  a3 * det;
    out[1] = -a1 * det;
    out[2] = -a2 * det;
    out[3] =  a0 * det;

    return out;
};

/**
 * Calculates the adjugate of a mat2
 *
 * @param {mat2} out the receiving matrix
 * @param {mat2} a the source matrix
 * @returns {mat2} out
 */
mat2.adjoint = function(out, a) {
    // Caching this value is nessecary if out == a
    var a0 = a[0];
    out[0] =  a[3];
    out[1] = -a[1];
    out[2] = -a[2];
    out[3] =  a0;

    return out;
};

/**
 * Calculates the determinant of a mat2
 *
 * @param {mat2} a the source matrix
 * @returns {Number} determinant of a
 */
mat2.determinant = function (a) {
    return a[0] * a[3] - a[2] * a[1];
};

/**
 * Multiplies two mat2's
 *
 * @param {mat2} out the receiving matrix
 * @param {mat2} a the first operand
 * @param {mat2} b the second operand
 * @returns {mat2} out
 */
mat2.multiply = function (out, a, b) {
    var a0 = a[0], a1 = a[1], a2 = a[2], a3 = a[3];
    var b0 = b[0], b1 = b[1], b2 = b[2], b3 = b[3];
    out[0] = a0 * b0 + a2 * b1;
    out[1] = a1 * b0 + a3 * b1;
    out[2] = a0 * b2 + a2 * b3;
    out[3] = a1 * b2 + a3 * b3;
    return out;
};

/**
 * Alias for {@link mat2.multiply}
 * @function
 */
mat2.mul = mat2.multiply;

/**
 * Rotates a mat2 by the given angle
 *
 * @param {mat2} out the receiving matrix
 * @param {mat2} a the matrix to rotate
 * @param {Number} rad the angle to rotate the matrix by
 * @returns {mat2} out
 */
mat2.rotate = function (out, a, rad) {
    var a0 = a[0], a1 = a[1], a2 = a[2], a3 = a[3],
        s = Math.sin(rad),
        c = Math.cos(rad);
    out[0] = a0 *  c + a2 * s;
    out[1] = a1 *  c + a3 * s;
    out[2] = a0 * -s + a2 * c;
    out[3] = a1 * -s + a3 * c;
    return out;
};

/**
 * Scales the mat2 by the dimensions in the given vec2
 *
 * @param {mat2} out the receiving matrix
 * @param {mat2} a the matrix to rotate
 * @param {vec2} v the vec2 to scale the matrix by
 * @returns {mat2} out
 **/
mat2.scale = function(out, a, v) {
    var a0 = a[0], a1 = a[1], a2 = a[2], a3 = a[3],
        v0 = v[0], v1 = v[1];
    out[0] = a0 * v0;
    out[1] = a1 * v0;
    out[2] = a2 * v1;
    out[3] = a3 * v1;
    return out;
};

/**
 * Creates a matrix from a given angle
 * This is equivalent to (but much faster than):
 *
 *     mat2.identity(dest);
 *     mat2.rotate(dest, dest, rad);
 *
 * @param {mat2} out mat2 receiving operation result
 * @param {Number} rad the angle to rotate the matrix by
 * @returns {mat2} out
 */
mat2.fromRotation = function(out, rad) {
    var s = Math.sin(rad),
        c = Math.cos(rad);
    out[0] = c;
    out[1] = s;
    out[2] = -s;
    out[3] = c;
    return out;
}

/**
 * Creates a matrix from a vector scaling
 * This is equivalent to (but much faster than):
 *
 *     mat2.identity(dest);
 *     mat2.scale(dest, dest, vec);
 *
 * @param {mat2} out mat2 receiving operation result
 * @param {vec2} v Scaling vector
 * @returns {mat2} out
 */
mat2.fromScaling = function(out, v) {
    out[0] = v[0];
    out[1] = 0;
    out[2] = 0;
    out[3] = v[1];
    return out;
}

/**
 * Returns a string representation of a mat2
 *
 * @param {mat2} mat matrix to represent as a string
 * @returns {String} string representation of the matrix
 */
mat2.str = function (a) {
    return 'mat2(' + a[0] + ', ' + a[1] + ', ' + a[2] + ', ' + a[3] + ')';
};

/**
 * Returns Frobenius norm of a mat2
 *
 * @param {mat2} a the matrix to calculate Frobenius norm of
 * @returns {Number} Frobenius norm
 */
mat2.frob = function (a) {
    return(Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2) + Math.pow(a[2], 2) + Math.pow(a[3], 2)))
};

/**
 * Returns L, D and U matrices (Lower triangular, Diagonal and Upper triangular) by factorizing the input matrix
 * @param {mat2} L the lower triangular matrix 
 * @param {mat2} D the diagonal matrix 
 * @param {mat2} U the upper triangular matrix 
 * @param {mat2} a the input matrix to factorize
 */

mat2.LDU = function (L, D, U, a) { 
    L[2] = a[2]/a[0]; 
    U[0] = a[0]; 
    U[1] = a[1]; 
    U[3] = a[3] - L[2] * U[1]; 
    return [L, D, U];       
}; 


module.exports = mat2;


/***/ }),

/***/ 216:
/***/ (function(module, exports, __webpack_require__) {

/* Copyright (c) 2015, Brandon Jones, Colin MacKenzie IV.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE. */

var glMatrix = __webpack_require__(21);

/**
 * @class 2x3 Matrix
 * @name mat2d
 * 
 * @description 
 * A mat2d contains six elements defined as:
 * <pre>
 * [a, c, tx,
 *  b, d, ty]
 * </pre>
 * This is a short form for the 3x3 matrix:
 * <pre>
 * [a, c, tx,
 *  b, d, ty,
 *  0, 0, 1]
 * </pre>
 * The last row is ignored so the array is shorter and operations are faster.
 */
var mat2d = {};

/**
 * Creates a new identity mat2d
 *
 * @returns {mat2d} a new 2x3 matrix
 */
mat2d.create = function() {
    var out = new glMatrix.ARRAY_TYPE(6);
    out[0] = 1;
    out[1] = 0;
    out[2] = 0;
    out[3] = 1;
    out[4] = 0;
    out[5] = 0;
    return out;
};

/**
 * Creates a new mat2d initialized with values from an existing matrix
 *
 * @param {mat2d} a matrix to clone
 * @returns {mat2d} a new 2x3 matrix
 */
mat2d.clone = function(a) {
    var out = new glMatrix.ARRAY_TYPE(6);
    out[0] = a[0];
    out[1] = a[1];
    out[2] = a[2];
    out[3] = a[3];
    out[4] = a[4];
    out[5] = a[5];
    return out;
};

/**
 * Copy the values from one mat2d to another
 *
 * @param {mat2d} out the receiving matrix
 * @param {mat2d} a the source matrix
 * @returns {mat2d} out
 */
mat2d.copy = function(out, a) {
    out[0] = a[0];
    out[1] = a[1];
    out[2] = a[2];
    out[3] = a[3];
    out[4] = a[4];
    out[5] = a[5];
    return out;
};

/**
 * Set a mat2d to the identity matrix
 *
 * @param {mat2d} out the receiving matrix
 * @returns {mat2d} out
 */
mat2d.identity = function(out) {
    out[0] = 1;
    out[1] = 0;
    out[2] = 0;
    out[3] = 1;
    out[4] = 0;
    out[5] = 0;
    return out;
};

/**
 * Inverts a mat2d
 *
 * @param {mat2d} out the receiving matrix
 * @param {mat2d} a the source matrix
 * @returns {mat2d} out
 */
mat2d.invert = function(out, a) {
    var aa = a[0], ab = a[1], ac = a[2], ad = a[3],
        atx = a[4], aty = a[5];

    var det = aa * ad - ab * ac;
    if(!det){
        return null;
    }
    det = 1.0 / det;

    out[0] = ad * det;
    out[1] = -ab * det;
    out[2] = -ac * det;
    out[3] = aa * det;
    out[4] = (ac * aty - ad * atx) * det;
    out[5] = (ab * atx - aa * aty) * det;
    return out;
};

/**
 * Calculates the determinant of a mat2d
 *
 * @param {mat2d} a the source matrix
 * @returns {Number} determinant of a
 */
mat2d.determinant = function (a) {
    return a[0] * a[3] - a[1] * a[2];
};

/**
 * Multiplies two mat2d's
 *
 * @param {mat2d} out the receiving matrix
 * @param {mat2d} a the first operand
 * @param {mat2d} b the second operand
 * @returns {mat2d} out
 */
mat2d.multiply = function (out, a, b) {
    var a0 = a[0], a1 = a[1], a2 = a[2], a3 = a[3], a4 = a[4], a5 = a[5],
        b0 = b[0], b1 = b[1], b2 = b[2], b3 = b[3], b4 = b[4], b5 = b[5];
    out[0] = a0 * b0 + a2 * b1;
    out[1] = a1 * b0 + a3 * b1;
    out[2] = a0 * b2 + a2 * b3;
    out[3] = a1 * b2 + a3 * b3;
    out[4] = a0 * b4 + a2 * b5 + a4;
    out[5] = a1 * b4 + a3 * b5 + a5;
    return out;
};

/**
 * Alias for {@link mat2d.multiply}
 * @function
 */
mat2d.mul = mat2d.multiply;

/**
 * Rotates a mat2d by the given angle
 *
 * @param {mat2d} out the receiving matrix
 * @param {mat2d} a the matrix to rotate
 * @param {Number} rad the angle to rotate the matrix by
 * @returns {mat2d} out
 */
mat2d.rotate = function (out, a, rad) {
    var a0 = a[0], a1 = a[1], a2 = a[2], a3 = a[3], a4 = a[4], a5 = a[5],
        s = Math.sin(rad),
        c = Math.cos(rad);
    out[0] = a0 *  c + a2 * s;
    out[1] = a1 *  c + a3 * s;
    out[2] = a0 * -s + a2 * c;
    out[3] = a1 * -s + a3 * c;
    out[4] = a4;
    out[5] = a5;
    return out;
};

/**
 * Scales the mat2d by the dimensions in the given vec2
 *
 * @param {mat2d} out the receiving matrix
 * @param {mat2d} a the matrix to translate
 * @param {vec2} v the vec2 to scale the matrix by
 * @returns {mat2d} out
 **/
mat2d.scale = function(out, a, v) {
    var a0 = a[0], a1 = a[1], a2 = a[2], a3 = a[3], a4 = a[4], a5 = a[5],
        v0 = v[0], v1 = v[1];
    out[0] = a0 * v0;
    out[1] = a1 * v0;
    out[2] = a2 * v1;
    out[3] = a3 * v1;
    out[4] = a4;
    out[5] = a5;
    return out;
};

/**
 * Translates the mat2d by the dimensions in the given vec2
 *
 * @param {mat2d} out the receiving matrix
 * @param {mat2d} a the matrix to translate
 * @param {vec2} v the vec2 to translate the matrix by
 * @returns {mat2d} out
 **/
mat2d.translate = function(out, a, v) {
    var a0 = a[0], a1 = a[1], a2 = a[2], a3 = a[3], a4 = a[4], a5 = a[5],
        v0 = v[0], v1 = v[1];
    out[0] = a0;
    out[1] = a1;
    out[2] = a2;
    out[3] = a3;
    out[4] = a0 * v0 + a2 * v1 + a4;
    out[5] = a1 * v0 + a3 * v1 + a5;
    return out;
};

/**
 * Creates a matrix from a given angle
 * This is equivalent to (but much faster than):
 *
 *     mat2d.identity(dest);
 *     mat2d.rotate(dest, dest, rad);
 *
 * @param {mat2d} out mat2d receiving operation result
 * @param {Number} rad the angle to rotate the matrix by
 * @returns {mat2d} out
 */
mat2d.fromRotation = function(out, rad) {
    var s = Math.sin(rad), c = Math.cos(rad);
    out[0] = c;
    out[1] = s;
    out[2] = -s;
    out[3] = c;
    out[4] = 0;
    out[5] = 0;
    return out;
}

/**
 * Creates a matrix from a vector scaling
 * This is equivalent to (but much faster than):
 *
 *     mat2d.identity(dest);
 *     mat2d.scale(dest, dest, vec);
 *
 * @param {mat2d} out mat2d receiving operation result
 * @param {vec2} v Scaling vector
 * @returns {mat2d} out
 */
mat2d.fromScaling = function(out, v) {
    out[0] = v[0];
    out[1] = 0;
    out[2] = 0;
    out[3] = v[1];
    out[4] = 0;
    out[5] = 0;
    return out;
}

/**
 * Creates a matrix from a vector translation
 * This is equivalent to (but much faster than):
 *
 *     mat2d.identity(dest);
 *     mat2d.translate(dest, dest, vec);
 *
 * @param {mat2d} out mat2d receiving operation result
 * @param {vec2} v Translation vector
 * @returns {mat2d} out
 */
mat2d.fromTranslation = function(out, v) {
    out[0] = 1;
    out[1] = 0;
    out[2] = 0;
    out[3] = 1;
    out[4] = v[0];
    out[5] = v[1];
    return out;
}

/**
 * Returns a string representation of a mat2d
 *
 * @param {mat2d} a matrix to represent as a string
 * @returns {String} string representation of the matrix
 */
mat2d.str = function (a) {
    return 'mat2d(' + a[0] + ', ' + a[1] + ', ' + a[2] + ', ' + 
                    a[3] + ', ' + a[4] + ', ' + a[5] + ')';
};

/**
 * Returns Frobenius norm of a mat2d
 *
 * @param {mat2d} a the matrix to calculate Frobenius norm of
 * @returns {Number} Frobenius norm
 */
mat2d.frob = function (a) { 
    return(Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2) + Math.pow(a[2], 2) + Math.pow(a[3], 2) + Math.pow(a[4], 2) + Math.pow(a[5], 2) + 1))
}; 

module.exports = mat2d;


/***/ }),

/***/ 217:
/***/ (function(module, exports, __webpack_require__) {

/* Copyright (c) 2015, Brandon Jones, Colin MacKenzie IV.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE. */

var glMatrix = __webpack_require__(21);

/**
 * @class 4x4 Matrix
 * @name mat4
 */
var mat4 = {};

/**
 * Creates a new identity mat4
 *
 * @returns {mat4} a new 4x4 matrix
 */
mat4.create = function() {
    var out = new glMatrix.ARRAY_TYPE(16);
    out[0] = 1;
    out[1] = 0;
    out[2] = 0;
    out[3] = 0;
    out[4] = 0;
    out[5] = 1;
    out[6] = 0;
    out[7] = 0;
    out[8] = 0;
    out[9] = 0;
    out[10] = 1;
    out[11] = 0;
    out[12] = 0;
    out[13] = 0;
    out[14] = 0;
    out[15] = 1;
    return out;
};

/**
 * Creates a new mat4 initialized with values from an existing matrix
 *
 * @param {mat4} a matrix to clone
 * @returns {mat4} a new 4x4 matrix
 */
mat4.clone = function(a) {
    var out = new glMatrix.ARRAY_TYPE(16);
    out[0] = a[0];
    out[1] = a[1];
    out[2] = a[2];
    out[3] = a[3];
    out[4] = a[4];
    out[5] = a[5];
    out[6] = a[6];
    out[7] = a[7];
    out[8] = a[8];
    out[9] = a[9];
    out[10] = a[10];
    out[11] = a[11];
    out[12] = a[12];
    out[13] = a[13];
    out[14] = a[14];
    out[15] = a[15];
    return out;
};

/**
 * Copy the values from one mat4 to another
 *
 * @param {mat4} out the receiving matrix
 * @param {mat4} a the source matrix
 * @returns {mat4} out
 */
mat4.copy = function(out, a) {
    out[0] = a[0];
    out[1] = a[1];
    out[2] = a[2];
    out[3] = a[3];
    out[4] = a[4];
    out[5] = a[5];
    out[6] = a[6];
    out[7] = a[7];
    out[8] = a[8];
    out[9] = a[9];
    out[10] = a[10];
    out[11] = a[11];
    out[12] = a[12];
    out[13] = a[13];
    out[14] = a[14];
    out[15] = a[15];
    return out;
};

/**
 * Set a mat4 to the identity matrix
 *
 * @param {mat4} out the receiving matrix
 * @returns {mat4} out
 */
mat4.identity = function(out) {
    out[0] = 1;
    out[1] = 0;
    out[2] = 0;
    out[3] = 0;
    out[4] = 0;
    out[5] = 1;
    out[6] = 0;
    out[7] = 0;
    out[8] = 0;
    out[9] = 0;
    out[10] = 1;
    out[11] = 0;
    out[12] = 0;
    out[13] = 0;
    out[14] = 0;
    out[15] = 1;
    return out;
};

/**
 * Transpose the values of a mat4
 *
 * @param {mat4} out the receiving matrix
 * @param {mat4} a the source matrix
 * @returns {mat4} out
 */
mat4.transpose = function(out, a) {
    // If we are transposing ourselves we can skip a few steps but have to cache some values
    if (out === a) {
        var a01 = a[1], a02 = a[2], a03 = a[3],
            a12 = a[6], a13 = a[7],
            a23 = a[11];

        out[1] = a[4];
        out[2] = a[8];
        out[3] = a[12];
        out[4] = a01;
        out[6] = a[9];
        out[7] = a[13];
        out[8] = a02;
        out[9] = a12;
        out[11] = a[14];
        out[12] = a03;
        out[13] = a13;
        out[14] = a23;
    } else {
        out[0] = a[0];
        out[1] = a[4];
        out[2] = a[8];
        out[3] = a[12];
        out[4] = a[1];
        out[5] = a[5];
        out[6] = a[9];
        out[7] = a[13];
        out[8] = a[2];
        out[9] = a[6];
        out[10] = a[10];
        out[11] = a[14];
        out[12] = a[3];
        out[13] = a[7];
        out[14] = a[11];
        out[15] = a[15];
    }
    
    return out;
};

/**
 * Inverts a mat4
 *
 * @param {mat4} out the receiving matrix
 * @param {mat4} a the source matrix
 * @returns {mat4} out
 */
mat4.invert = function(out, a) {
    var a00 = a[0], a01 = a[1], a02 = a[2], a03 = a[3],
        a10 = a[4], a11 = a[5], a12 = a[6], a13 = a[7],
        a20 = a[8], a21 = a[9], a22 = a[10], a23 = a[11],
        a30 = a[12], a31 = a[13], a32 = a[14], a33 = a[15],

        b00 = a00 * a11 - a01 * a10,
        b01 = a00 * a12 - a02 * a10,
        b02 = a00 * a13 - a03 * a10,
        b03 = a01 * a12 - a02 * a11,
        b04 = a01 * a13 - a03 * a11,
        b05 = a02 * a13 - a03 * a12,
        b06 = a20 * a31 - a21 * a30,
        b07 = a20 * a32 - a22 * a30,
        b08 = a20 * a33 - a23 * a30,
        b09 = a21 * a32 - a22 * a31,
        b10 = a21 * a33 - a23 * a31,
        b11 = a22 * a33 - a23 * a32,

        // Calculate the determinant
        det = b00 * b11 - b01 * b10 + b02 * b09 + b03 * b08 - b04 * b07 + b05 * b06;

    if (!det) { 
        return null; 
    }
    det = 1.0 / det;

    out[0] = (a11 * b11 - a12 * b10 + a13 * b09) * det;
    out[1] = (a02 * b10 - a01 * b11 - a03 * b09) * det;
    out[2] = (a31 * b05 - a32 * b04 + a33 * b03) * det;
    out[3] = (a22 * b04 - a21 * b05 - a23 * b03) * det;
    out[4] = (a12 * b08 - a10 * b11 - a13 * b07) * det;
    out[5] = (a00 * b11 - a02 * b08 + a03 * b07) * det;
    out[6] = (a32 * b02 - a30 * b05 - a33 * b01) * det;
    out[7] = (a20 * b05 - a22 * b02 + a23 * b01) * det;
    out[8] = (a10 * b10 - a11 * b08 + a13 * b06) * det;
    out[9] = (a01 * b08 - a00 * b10 - a03 * b06) * det;
    out[10] = (a30 * b04 - a31 * b02 + a33 * b00) * det;
    out[11] = (a21 * b02 - a20 * b04 - a23 * b00) * det;
    out[12] = (a11 * b07 - a10 * b09 - a12 * b06) * det;
    out[13] = (a00 * b09 - a01 * b07 + a02 * b06) * det;
    out[14] = (a31 * b01 - a30 * b03 - a32 * b00) * det;
    out[15] = (a20 * b03 - a21 * b01 + a22 * b00) * det;

    return out;
};

/**
 * Calculates the adjugate of a mat4
 *
 * @param {mat4} out the receiving matrix
 * @param {mat4} a the source matrix
 * @returns {mat4} out
 */
mat4.adjoint = function(out, a) {
    var a00 = a[0], a01 = a[1], a02 = a[2], a03 = a[3],
        a10 = a[4], a11 = a[5], a12 = a[6], a13 = a[7],
        a20 = a[8], a21 = a[9], a22 = a[10], a23 = a[11],
        a30 = a[12], a31 = a[13], a32 = a[14], a33 = a[15];

    out[0]  =  (a11 * (a22 * a33 - a23 * a32) - a21 * (a12 * a33 - a13 * a32) + a31 * (a12 * a23 - a13 * a22));
    out[1]  = -(a01 * (a22 * a33 - a23 * a32) - a21 * (a02 * a33 - a03 * a32) + a31 * (a02 * a23 - a03 * a22));
    out[2]  =  (a01 * (a12 * a33 - a13 * a32) - a11 * (a02 * a33 - a03 * a32) + a31 * (a02 * a13 - a03 * a12));
    out[3]  = -(a01 * (a12 * a23 - a13 * a22) - a11 * (a02 * a23 - a03 * a22) + a21 * (a02 * a13 - a03 * a12));
    out[4]  = -(a10 * (a22 * a33 - a23 * a32) - a20 * (a12 * a33 - a13 * a32) + a30 * (a12 * a23 - a13 * a22));
    out[5]  =  (a00 * (a22 * a33 - a23 * a32) - a20 * (a02 * a33 - a03 * a32) + a30 * (a02 * a23 - a03 * a22));
    out[6]  = -(a00 * (a12 * a33 - a13 * a32) - a10 * (a02 * a33 - a03 * a32) + a30 * (a02 * a13 - a03 * a12));
    out[7]  =  (a00 * (a12 * a23 - a13 * a22) - a10 * (a02 * a23 - a03 * a22) + a20 * (a02 * a13 - a03 * a12));
    out[8]  =  (a10 * (a21 * a33 - a23 * a31) - a20 * (a11 * a33 - a13 * a31) + a30 * (a11 * a23 - a13 * a21));
    out[9]  = -(a00 * (a21 * a33 - a23 * a31) - a20 * (a01 * a33 - a03 * a31) + a30 * (a01 * a23 - a03 * a21));
    out[10] =  (a00 * (a11 * a33 - a13 * a31) - a10 * (a01 * a33 - a03 * a31) + a30 * (a01 * a13 - a03 * a11));
    out[11] = -(a00 * (a11 * a23 - a13 * a21) - a10 * (a01 * a23 - a03 * a21) + a20 * (a01 * a13 - a03 * a11));
    out[12] = -(a10 * (a21 * a32 - a22 * a31) - a20 * (a11 * a32 - a12 * a31) + a30 * (a11 * a22 - a12 * a21));
    out[13] =  (a00 * (a21 * a32 - a22 * a31) - a20 * (a01 * a32 - a02 * a31) + a30 * (a01 * a22 - a02 * a21));
    out[14] = -(a00 * (a11 * a32 - a12 * a31) - a10 * (a01 * a32 - a02 * a31) + a30 * (a01 * a12 - a02 * a11));
    out[15] =  (a00 * (a11 * a22 - a12 * a21) - a10 * (a01 * a22 - a02 * a21) + a20 * (a01 * a12 - a02 * a11));
    return out;
};

/**
 * Calculates the determinant of a mat4
 *
 * @param {mat4} a the source matrix
 * @returns {Number} determinant of a
 */
mat4.determinant = function (a) {
    var a00 = a[0], a01 = a[1], a02 = a[2], a03 = a[3],
        a10 = a[4], a11 = a[5], a12 = a[6], a13 = a[7],
        a20 = a[8], a21 = a[9], a22 = a[10], a23 = a[11],
        a30 = a[12], a31 = a[13], a32 = a[14], a33 = a[15],

        b00 = a00 * a11 - a01 * a10,
        b01 = a00 * a12 - a02 * a10,
        b02 = a00 * a13 - a03 * a10,
        b03 = a01 * a12 - a02 * a11,
        b04 = a01 * a13 - a03 * a11,
        b05 = a02 * a13 - a03 * a12,
        b06 = a20 * a31 - a21 * a30,
        b07 = a20 * a32 - a22 * a30,
        b08 = a20 * a33 - a23 * a30,
        b09 = a21 * a32 - a22 * a31,
        b10 = a21 * a33 - a23 * a31,
        b11 = a22 * a33 - a23 * a32;

    // Calculate the determinant
    return b00 * b11 - b01 * b10 + b02 * b09 + b03 * b08 - b04 * b07 + b05 * b06;
};

/**
 * Multiplies two mat4's
 *
 * @param {mat4} out the receiving matrix
 * @param {mat4} a the first operand
 * @param {mat4} b the second operand
 * @returns {mat4} out
 */
mat4.multiply = function (out, a, b) {
    var a00 = a[0], a01 = a[1], a02 = a[2], a03 = a[3],
        a10 = a[4], a11 = a[5], a12 = a[6], a13 = a[7],
        a20 = a[8], a21 = a[9], a22 = a[10], a23 = a[11],
        a30 = a[12], a31 = a[13], a32 = a[14], a33 = a[15];

    // Cache only the current line of the second matrix
    var b0  = b[0], b1 = b[1], b2 = b[2], b3 = b[3];  
    out[0] = b0*a00 + b1*a10 + b2*a20 + b3*a30;
    out[1] = b0*a01 + b1*a11 + b2*a21 + b3*a31;
    out[2] = b0*a02 + b1*a12 + b2*a22 + b3*a32;
    out[3] = b0*a03 + b1*a13 + b2*a23 + b3*a33;

    b0 = b[4]; b1 = b[5]; b2 = b[6]; b3 = b[7];
    out[4] = b0*a00 + b1*a10 + b2*a20 + b3*a30;
    out[5] = b0*a01 + b1*a11 + b2*a21 + b3*a31;
    out[6] = b0*a02 + b1*a12 + b2*a22 + b3*a32;
    out[7] = b0*a03 + b1*a13 + b2*a23 + b3*a33;

    b0 = b[8]; b1 = b[9]; b2 = b[10]; b3 = b[11];
    out[8] = b0*a00 + b1*a10 + b2*a20 + b3*a30;
    out[9] = b0*a01 + b1*a11 + b2*a21 + b3*a31;
    out[10] = b0*a02 + b1*a12 + b2*a22 + b3*a32;
    out[11] = b0*a03 + b1*a13 + b2*a23 + b3*a33;

    b0 = b[12]; b1 = b[13]; b2 = b[14]; b3 = b[15];
    out[12] = b0*a00 + b1*a10 + b2*a20 + b3*a30;
    out[13] = b0*a01 + b1*a11 + b2*a21 + b3*a31;
    out[14] = b0*a02 + b1*a12 + b2*a22 + b3*a32;
    out[15] = b0*a03 + b1*a13 + b2*a23 + b3*a33;
    return out;
};

/**
 * Alias for {@link mat4.multiply}
 * @function
 */
mat4.mul = mat4.multiply;

/**
 * Translate a mat4 by the given vector
 *
 * @param {mat4} out the receiving matrix
 * @param {mat4} a the matrix to translate
 * @param {vec3} v vector to translate by
 * @returns {mat4} out
 */
mat4.translate = function (out, a, v) {
    var x = v[0], y = v[1], z = v[2],
        a00, a01, a02, a03,
        a10, a11, a12, a13,
        a20, a21, a22, a23;

    if (a === out) {
        out[12] = a[0] * x + a[4] * y + a[8] * z + a[12];
        out[13] = a[1] * x + a[5] * y + a[9] * z + a[13];
        out[14] = a[2] * x + a[6] * y + a[10] * z + a[14];
        out[15] = a[3] * x + a[7] * y + a[11] * z + a[15];
    } else {
        a00 = a[0]; a01 = a[1]; a02 = a[2]; a03 = a[3];
        a10 = a[4]; a11 = a[5]; a12 = a[6]; a13 = a[7];
        a20 = a[8]; a21 = a[9]; a22 = a[10]; a23 = a[11];

        out[0] = a00; out[1] = a01; out[2] = a02; out[3] = a03;
        out[4] = a10; out[5] = a11; out[6] = a12; out[7] = a13;
        out[8] = a20; out[9] = a21; out[10] = a22; out[11] = a23;

        out[12] = a00 * x + a10 * y + a20 * z + a[12];
        out[13] = a01 * x + a11 * y + a21 * z + a[13];
        out[14] = a02 * x + a12 * y + a22 * z + a[14];
        out[15] = a03 * x + a13 * y + a23 * z + a[15];
    }

    return out;
};

/**
 * Scales the mat4 by the dimensions in the given vec3
 *
 * @param {mat4} out the receiving matrix
 * @param {mat4} a the matrix to scale
 * @param {vec3} v the vec3 to scale the matrix by
 * @returns {mat4} out
 **/
mat4.scale = function(out, a, v) {
    var x = v[0], y = v[1], z = v[2];

    out[0] = a[0] * x;
    out[1] = a[1] * x;
    out[2] = a[2] * x;
    out[3] = a[3] * x;
    out[4] = a[4] * y;
    out[5] = a[5] * y;
    out[6] = a[6] * y;
    out[7] = a[7] * y;
    out[8] = a[8] * z;
    out[9] = a[9] * z;
    out[10] = a[10] * z;
    out[11] = a[11] * z;
    out[12] = a[12];
    out[13] = a[13];
    out[14] = a[14];
    out[15] = a[15];
    return out;
};

/**
 * Rotates a mat4 by the given angle around the given axis
 *
 * @param {mat4} out the receiving matrix
 * @param {mat4} a the matrix to rotate
 * @param {Number} rad the angle to rotate the matrix by
 * @param {vec3} axis the axis to rotate around
 * @returns {mat4} out
 */
mat4.rotate = function (out, a, rad, axis) {
    var x = axis[0], y = axis[1], z = axis[2],
        len = Math.sqrt(x * x + y * y + z * z),
        s, c, t,
        a00, a01, a02, a03,
        a10, a11, a12, a13,
        a20, a21, a22, a23,
        b00, b01, b02,
        b10, b11, b12,
        b20, b21, b22;

    if (Math.abs(len) < glMatrix.EPSILON) { return null; }
    
    len = 1 / len;
    x *= len;
    y *= len;
    z *= len;

    s = Math.sin(rad);
    c = Math.cos(rad);
    t = 1 - c;

    a00 = a[0]; a01 = a[1]; a02 = a[2]; a03 = a[3];
    a10 = a[4]; a11 = a[5]; a12 = a[6]; a13 = a[7];
    a20 = a[8]; a21 = a[9]; a22 = a[10]; a23 = a[11];

    // Construct the elements of the rotation matrix
    b00 = x * x * t + c; b01 = y * x * t + z * s; b02 = z * x * t - y * s;
    b10 = x * y * t - z * s; b11 = y * y * t + c; b12 = z * y * t + x * s;
    b20 = x * z * t + y * s; b21 = y * z * t - x * s; b22 = z * z * t + c;

    // Perform rotation-specific matrix multiplication
    out[0] = a00 * b00 + a10 * b01 + a20 * b02;
    out[1] = a01 * b00 + a11 * b01 + a21 * b02;
    out[2] = a02 * b00 + a12 * b01 + a22 * b02;
    out[3] = a03 * b00 + a13 * b01 + a23 * b02;
    out[4] = a00 * b10 + a10 * b11 + a20 * b12;
    out[5] = a01 * b10 + a11 * b11 + a21 * b12;
    out[6] = a02 * b10 + a12 * b11 + a22 * b12;
    out[7] = a03 * b10 + a13 * b11 + a23 * b12;
    out[8] = a00 * b20 + a10 * b21 + a20 * b22;
    out[9] = a01 * b20 + a11 * b21 + a21 * b22;
    out[10] = a02 * b20 + a12 * b21 + a22 * b22;
    out[11] = a03 * b20 + a13 * b21 + a23 * b22;

    if (a !== out) { // If the source and destination differ, copy the unchanged last row
        out[12] = a[12];
        out[13] = a[13];
        out[14] = a[14];
        out[15] = a[15];
    }
    return out;
};

/**
 * Rotates a matrix by the given angle around the X axis
 *
 * @param {mat4} out the receiving matrix
 * @param {mat4} a the matrix to rotate
 * @param {Number} rad the angle to rotate the matrix by
 * @returns {mat4} out
 */
mat4.rotateX = function (out, a, rad) {
    var s = Math.sin(rad),
        c = Math.cos(rad),
        a10 = a[4],
        a11 = a[5],
        a12 = a[6],
        a13 = a[7],
        a20 = a[8],
        a21 = a[9],
        a22 = a[10],
        a23 = a[11];

    if (a !== out) { // If the source and destination differ, copy the unchanged rows
        out[0]  = a[0];
        out[1]  = a[1];
        out[2]  = a[2];
        out[3]  = a[3];
        out[12] = a[12];
        out[13] = a[13];
        out[14] = a[14];
        out[15] = a[15];
    }

    // Perform axis-specific matrix multiplication
    out[4] = a10 * c + a20 * s;
    out[5] = a11 * c + a21 * s;
    out[6] = a12 * c + a22 * s;
    out[7] = a13 * c + a23 * s;
    out[8] = a20 * c - a10 * s;
    out[9] = a21 * c - a11 * s;
    out[10] = a22 * c - a12 * s;
    out[11] = a23 * c - a13 * s;
    return out;
};

/**
 * Rotates a matrix by the given angle around the Y axis
 *
 * @param {mat4} out the receiving matrix
 * @param {mat4} a the matrix to rotate
 * @param {Number} rad the angle to rotate the matrix by
 * @returns {mat4} out
 */
mat4.rotateY = function (out, a, rad) {
    var s = Math.sin(rad),
        c = Math.cos(rad),
        a00 = a[0],
        a01 = a[1],
        a02 = a[2],
        a03 = a[3],
        a20 = a[8],
        a21 = a[9],
        a22 = a[10],
        a23 = a[11];

    if (a !== out) { // If the source and destination differ, copy the unchanged rows
        out[4]  = a[4];
        out[5]  = a[5];
        out[6]  = a[6];
        out[7]  = a[7];
        out[12] = a[12];
        out[13] = a[13];
        out[14] = a[14];
        out[15] = a[15];
    }

    // Perform axis-specific matrix multiplication
    out[0] = a00 * c - a20 * s;
    out[1] = a01 * c - a21 * s;
    out[2] = a02 * c - a22 * s;
    out[3] = a03 * c - a23 * s;
    out[8] = a00 * s + a20 * c;
    out[9] = a01 * s + a21 * c;
    out[10] = a02 * s + a22 * c;
    out[11] = a03 * s + a23 * c;
    return out;
};

/**
 * Rotates a matrix by the given angle around the Z axis
 *
 * @param {mat4} out the receiving matrix
 * @param {mat4} a the matrix to rotate
 * @param {Number} rad the angle to rotate the matrix by
 * @returns {mat4} out
 */
mat4.rotateZ = function (out, a, rad) {
    var s = Math.sin(rad),
        c = Math.cos(rad),
        a00 = a[0],
        a01 = a[1],
        a02 = a[2],
        a03 = a[3],
        a10 = a[4],
        a11 = a[5],
        a12 = a[6],
        a13 = a[7];

    if (a !== out) { // If the source and destination differ, copy the unchanged last row
        out[8]  = a[8];
        out[9]  = a[9];
        out[10] = a[10];
        out[11] = a[11];
        out[12] = a[12];
        out[13] = a[13];
        out[14] = a[14];
        out[15] = a[15];
    }

    // Perform axis-specific matrix multiplication
    out[0] = a00 * c + a10 * s;
    out[1] = a01 * c + a11 * s;
    out[2] = a02 * c + a12 * s;
    out[3] = a03 * c + a13 * s;
    out[4] = a10 * c - a00 * s;
    out[5] = a11 * c - a01 * s;
    out[6] = a12 * c - a02 * s;
    out[7] = a13 * c - a03 * s;
    return out;
};

/**
 * Creates a matrix from a vector translation
 * This is equivalent to (but much faster than):
 *
 *     mat4.identity(dest);
 *     mat4.translate(dest, dest, vec);
 *
 * @param {mat4} out mat4 receiving operation result
 * @param {vec3} v Translation vector
 * @returns {mat4} out
 */
mat4.fromTranslation = function(out, v) {
    out[0] = 1;
    out[1] = 0;
    out[2] = 0;
    out[3] = 0;
    out[4] = 0;
    out[5] = 1;
    out[6] = 0;
    out[7] = 0;
    out[8] = 0;
    out[9] = 0;
    out[10] = 1;
    out[11] = 0;
    out[12] = v[0];
    out[13] = v[1];
    out[14] = v[2];
    out[15] = 1;
    return out;
}

/**
 * Creates a matrix from a vector scaling
 * This is equivalent to (but much faster than):
 *
 *     mat4.identity(dest);
 *     mat4.scale(dest, dest, vec);
 *
 * @param {mat4} out mat4 receiving operation result
 * @param {vec3} v Scaling vector
 * @returns {mat4} out
 */
mat4.fromScaling = function(out, v) {
    out[0] = v[0];
    out[1] = 0;
    out[2] = 0;
    out[3] = 0;
    out[4] = 0;
    out[5] = v[1];
    out[6] = 0;
    out[7] = 0;
    out[8] = 0;
    out[9] = 0;
    out[10] = v[2];
    out[11] = 0;
    out[12] = 0;
    out[13] = 0;
    out[14] = 0;
    out[15] = 1;
    return out;
}

/**
 * Creates a matrix from a given angle around a given axis
 * This is equivalent to (but much faster than):
 *
 *     mat4.identity(dest);
 *     mat4.rotate(dest, dest, rad, axis);
 *
 * @param {mat4} out mat4 receiving operation result
 * @param {Number} rad the angle to rotate the matrix by
 * @param {vec3} axis the axis to rotate around
 * @returns {mat4} out
 */
mat4.fromRotation = function(out, rad, axis) {
    var x = axis[0], y = axis[1], z = axis[2],
        len = Math.sqrt(x * x + y * y + z * z),
        s, c, t;
    
    if (Math.abs(len) < glMatrix.EPSILON) { return null; }
    
    len = 1 / len;
    x *= len;
    y *= len;
    z *= len;
    
    s = Math.sin(rad);
    c = Math.cos(rad);
    t = 1 - c;
    
    // Perform rotation-specific matrix multiplication
    out[0] = x * x * t + c;
    out[1] = y * x * t + z * s;
    out[2] = z * x * t - y * s;
    out[3] = 0;
    out[4] = x * y * t - z * s;
    out[5] = y * y * t + c;
    out[6] = z * y * t + x * s;
    out[7] = 0;
    out[8] = x * z * t + y * s;
    out[9] = y * z * t - x * s;
    out[10] = z * z * t + c;
    out[11] = 0;
    out[12] = 0;
    out[13] = 0;
    out[14] = 0;
    out[15] = 1;
    return out;
}

/**
 * Creates a matrix from the given angle around the X axis
 * This is equivalent to (but much faster than):
 *
 *     mat4.identity(dest);
 *     mat4.rotateX(dest, dest, rad);
 *
 * @param {mat4} out mat4 receiving operation result
 * @param {Number} rad the angle to rotate the matrix by
 * @returns {mat4} out
 */
mat4.fromXRotation = function(out, rad) {
    var s = Math.sin(rad),
        c = Math.cos(rad);
    
    // Perform axis-specific matrix multiplication
    out[0]  = 1;
    out[1]  = 0;
    out[2]  = 0;
    out[3]  = 0;
    out[4] = 0;
    out[5] = c;
    out[6] = s;
    out[7] = 0;
    out[8] = 0;
    out[9] = -s;
    out[10] = c;
    out[11] = 0;
    out[12] = 0;
    out[13] = 0;
    out[14] = 0;
    out[15] = 1;
    return out;
}

/**
 * Creates a matrix from the given angle around the Y axis
 * This is equivalent to (but much faster than):
 *
 *     mat4.identity(dest);
 *     mat4.rotateY(dest, dest, rad);
 *
 * @param {mat4} out mat4 receiving operation result
 * @param {Number} rad the angle to rotate the matrix by
 * @returns {mat4} out
 */
mat4.fromYRotation = function(out, rad) {
    var s = Math.sin(rad),
        c = Math.cos(rad);
    
    // Perform axis-specific matrix multiplication
    out[0]  = c;
    out[1]  = 0;
    out[2]  = -s;
    out[3]  = 0;
    out[4] = 0;
    out[5] = 1;
    out[6] = 0;
    out[7] = 0;
    out[8] = s;
    out[9] = 0;
    out[10] = c;
    out[11] = 0;
    out[12] = 0;
    out[13] = 0;
    out[14] = 0;
    out[15] = 1;
    return out;
}

/**
 * Creates a matrix from the given angle around the Z axis
 * This is equivalent to (but much faster than):
 *
 *     mat4.identity(dest);
 *     mat4.rotateZ(dest, dest, rad);
 *
 * @param {mat4} out mat4 receiving operation result
 * @param {Number} rad the angle to rotate the matrix by
 * @returns {mat4} out
 */
mat4.fromZRotation = function(out, rad) {
    var s = Math.sin(rad),
        c = Math.cos(rad);
    
    // Perform axis-specific matrix multiplication
    out[0]  = c;
    out[1]  = s;
    out[2]  = 0;
    out[3]  = 0;
    out[4] = -s;
    out[5] = c;
    out[6] = 0;
    out[7] = 0;
    out[8] = 0;
    out[9] = 0;
    out[10] = 1;
    out[11] = 0;
    out[12] = 0;
    out[13] = 0;
    out[14] = 0;
    out[15] = 1;
    return out;
}

/**
 * Creates a matrix from a quaternion rotation and vector translation
 * This is equivalent to (but much faster than):
 *
 *     mat4.identity(dest);
 *     mat4.translate(dest, vec);
 *     var quatMat = mat4.create();
 *     quat4.toMat4(quat, quatMat);
 *     mat4.multiply(dest, quatMat);
 *
 * @param {mat4} out mat4 receiving operation result
 * @param {quat4} q Rotation quaternion
 * @param {vec3} v Translation vector
 * @returns {mat4} out
 */
mat4.fromRotationTranslation = function (out, q, v) {
    // Quaternion math
    var x = q[0], y = q[1], z = q[2], w = q[3],
        x2 = x + x,
        y2 = y + y,
        z2 = z + z,

        xx = x * x2,
        xy = x * y2,
        xz = x * z2,
        yy = y * y2,
        yz = y * z2,
        zz = z * z2,
        wx = w * x2,
        wy = w * y2,
        wz = w * z2;

    out[0] = 1 - (yy + zz);
    out[1] = xy + wz;
    out[2] = xz - wy;
    out[3] = 0;
    out[4] = xy - wz;
    out[5] = 1 - (xx + zz);
    out[6] = yz + wx;
    out[7] = 0;
    out[8] = xz + wy;
    out[9] = yz - wx;
    out[10] = 1 - (xx + yy);
    out[11] = 0;
    out[12] = v[0];
    out[13] = v[1];
    out[14] = v[2];
    out[15] = 1;
    
    return out;
};

/**
 * Creates a matrix from a quaternion rotation, vector translation and vector scale
 * This is equivalent to (but much faster than):
 *
 *     mat4.identity(dest);
 *     mat4.translate(dest, vec);
 *     var quatMat = mat4.create();
 *     quat4.toMat4(quat, quatMat);
 *     mat4.multiply(dest, quatMat);
 *     mat4.scale(dest, scale)
 *
 * @param {mat4} out mat4 receiving operation result
 * @param {quat4} q Rotation quaternion
 * @param {vec3} v Translation vector
 * @param {vec3} s Scaling vector
 * @returns {mat4} out
 */
mat4.fromRotationTranslationScale = function (out, q, v, s) {
    // Quaternion math
    var x = q[0], y = q[1], z = q[2], w = q[3],
        x2 = x + x,
        y2 = y + y,
        z2 = z + z,

        xx = x * x2,
        xy = x * y2,
        xz = x * z2,
        yy = y * y2,
        yz = y * z2,
        zz = z * z2,
        wx = w * x2,
        wy = w * y2,
        wz = w * z2,
        sx = s[0],
        sy = s[1],
        sz = s[2];

    out[0] = (1 - (yy + zz)) * sx;
    out[1] = (xy + wz) * sx;
    out[2] = (xz - wy) * sx;
    out[3] = 0;
    out[4] = (xy - wz) * sy;
    out[5] = (1 - (xx + zz)) * sy;
    out[6] = (yz + wx) * sy;
    out[7] = 0;
    out[8] = (xz + wy) * sz;
    out[9] = (yz - wx) * sz;
    out[10] = (1 - (xx + yy)) * sz;
    out[11] = 0;
    out[12] = v[0];
    out[13] = v[1];
    out[14] = v[2];
    out[15] = 1;
    
    return out;
};

/**
 * Creates a matrix from a quaternion rotation, vector translation and vector scale, rotating and scaling around the given origin
 * This is equivalent to (but much faster than):
 *
 *     mat4.identity(dest);
 *     mat4.translate(dest, vec);
 *     mat4.translate(dest, origin);
 *     var quatMat = mat4.create();
 *     quat4.toMat4(quat, quatMat);
 *     mat4.multiply(dest, quatMat);
 *     mat4.scale(dest, scale)
 *     mat4.translate(dest, negativeOrigin);
 *
 * @param {mat4} out mat4 receiving operation result
 * @param {quat4} q Rotation quaternion
 * @param {vec3} v Translation vector
 * @param {vec3} s Scaling vector
 * @param {vec3} o The origin vector around which to scale and rotate
 * @returns {mat4} out
 */
mat4.fromRotationTranslationScaleOrigin = function (out, q, v, s, o) {
  // Quaternion math
  var x = q[0], y = q[1], z = q[2], w = q[3],
      x2 = x + x,
      y2 = y + y,
      z2 = z + z,

      xx = x * x2,
      xy = x * y2,
      xz = x * z2,
      yy = y * y2,
      yz = y * z2,
      zz = z * z2,
      wx = w * x2,
      wy = w * y2,
      wz = w * z2,
      
      sx = s[0],
      sy = s[1],
      sz = s[2],

      ox = o[0],
      oy = o[1],
      oz = o[2];
      
  out[0] = (1 - (yy + zz)) * sx;
  out[1] = (xy + wz) * sx;
  out[2] = (xz - wy) * sx;
  out[3] = 0;
  out[4] = (xy - wz) * sy;
  out[5] = (1 - (xx + zz)) * sy;
  out[6] = (yz + wx) * sy;
  out[7] = 0;
  out[8] = (xz + wy) * sz;
  out[9] = (yz - wx) * sz;
  out[10] = (1 - (xx + yy)) * sz;
  out[11] = 0;
  out[12] = v[0] + ox - (out[0] * ox + out[4] * oy + out[8] * oz);
  out[13] = v[1] + oy - (out[1] * ox + out[5] * oy + out[9] * oz);
  out[14] = v[2] + oz - (out[2] * ox + out[6] * oy + out[10] * oz);
  out[15] = 1;
        
  return out;
};

mat4.fromQuat = function (out, q) {
    var x = q[0], y = q[1], z = q[2], w = q[3],
        x2 = x + x,
        y2 = y + y,
        z2 = z + z,

        xx = x * x2,
        yx = y * x2,
        yy = y * y2,
        zx = z * x2,
        zy = z * y2,
        zz = z * z2,
        wx = w * x2,
        wy = w * y2,
        wz = w * z2;

    out[0] = 1 - yy - zz;
    out[1] = yx + wz;
    out[2] = zx - wy;
    out[3] = 0;

    out[4] = yx - wz;
    out[5] = 1 - xx - zz;
    out[6] = zy + wx;
    out[7] = 0;

    out[8] = zx + wy;
    out[9] = zy - wx;
    out[10] = 1 - xx - yy;
    out[11] = 0;

    out[12] = 0;
    out[13] = 0;
    out[14] = 0;
    out[15] = 1;

    return out;
};

/**
 * Generates a frustum matrix with the given bounds
 *
 * @param {mat4} out mat4 frustum matrix will be written into
 * @param {Number} left Left bound of the frustum
 * @param {Number} right Right bound of the frustum
 * @param {Number} bottom Bottom bound of the frustum
 * @param {Number} top Top bound of the frustum
 * @param {Number} near Near bound of the frustum
 * @param {Number} far Far bound of the frustum
 * @returns {mat4} out
 */
mat4.frustum = function (out, left, right, bottom, top, near, far) {
    var rl = 1 / (right - left),
        tb = 1 / (top - bottom),
        nf = 1 / (near - far);
    out[0] = (near * 2) * rl;
    out[1] = 0;
    out[2] = 0;
    out[3] = 0;
    out[4] = 0;
    out[5] = (near * 2) * tb;
    out[6] = 0;
    out[7] = 0;
    out[8] = (right + left) * rl;
    out[9] = (top + bottom) * tb;
    out[10] = (far + near) * nf;
    out[11] = -1;
    out[12] = 0;
    out[13] = 0;
    out[14] = (far * near * 2) * nf;
    out[15] = 0;
    return out;
};

/**
 * Generates a perspective projection matrix with the given bounds
 *
 * @param {mat4} out mat4 frustum matrix will be written into
 * @param {number} fovy Vertical field of view in radians
 * @param {number} aspect Aspect ratio. typically viewport width/height
 * @param {number} near Near bound of the frustum
 * @param {number} far Far bound of the frustum
 * @returns {mat4} out
 */
mat4.perspective = function (out, fovy, aspect, near, far) {
    var f = 1.0 / Math.tan(fovy / 2),
        nf = 1 / (near - far);
    out[0] = f / aspect;
    out[1] = 0;
    out[2] = 0;
    out[3] = 0;
    out[4] = 0;
    out[5] = f;
    out[6] = 0;
    out[7] = 0;
    out[8] = 0;
    out[9] = 0;
    out[10] = (far + near) * nf;
    out[11] = -1;
    out[12] = 0;
    out[13] = 0;
    out[14] = (2 * far * near) * nf;
    out[15] = 0;
    return out;
};

/**
 * Generates a perspective projection matrix with the given field of view.
 * This is primarily useful for generating projection matrices to be used
 * with the still experiemental WebVR API.
 *
 * @param {mat4} out mat4 frustum matrix will be written into
 * @param {number} fov Object containing the following values: upDegrees, downDegrees, leftDegrees, rightDegrees
 * @param {number} near Near bound of the frustum
 * @param {number} far Far bound of the frustum
 * @returns {mat4} out
 */
mat4.perspectiveFromFieldOfView = function (out, fov, near, far) {
    var upTan = Math.tan(fov.upDegrees * Math.PI/180.0),
        downTan = Math.tan(fov.downDegrees * Math.PI/180.0),
        leftTan = Math.tan(fov.leftDegrees * Math.PI/180.0),
        rightTan = Math.tan(fov.rightDegrees * Math.PI/180.0),
        xScale = 2.0 / (leftTan + rightTan),
        yScale = 2.0 / (upTan + downTan);

    out[0] = xScale;
    out[1] = 0.0;
    out[2] = 0.0;
    out[3] = 0.0;
    out[4] = 0.0;
    out[5] = yScale;
    out[6] = 0.0;
    out[7] = 0.0;
    out[8] = -((leftTan - rightTan) * xScale * 0.5);
    out[9] = ((upTan - downTan) * yScale * 0.5);
    out[10] = far / (near - far);
    out[11] = -1.0;
    out[12] = 0.0;
    out[13] = 0.0;
    out[14] = (far * near) / (near - far);
    out[15] = 0.0;
    return out;
}

/**
 * Generates a orthogonal projection matrix with the given bounds
 *
 * @param {mat4} out mat4 frustum matrix will be written into
 * @param {number} left Left bound of the frustum
 * @param {number} right Right bound of the frustum
 * @param {number} bottom Bottom bound of the frustum
 * @param {number} top Top bound of the frustum
 * @param {number} near Near bound of the frustum
 * @param {number} far Far bound of the frustum
 * @returns {mat4} out
 */
mat4.ortho = function (out, left, right, bottom, top, near, far) {
    var lr = 1 / (left - right),
        bt = 1 / (bottom - top),
        nf = 1 / (near - far);
    out[0] = -2 * lr;
    out[1] = 0;
    out[2] = 0;
    out[3] = 0;
    out[4] = 0;
    out[5] = -2 * bt;
    out[6] = 0;
    out[7] = 0;
    out[8] = 0;
    out[9] = 0;
    out[10] = 2 * nf;
    out[11] = 0;
    out[12] = (left + right) * lr;
    out[13] = (top + bottom) * bt;
    out[14] = (far + near) * nf;
    out[15] = 1;
    return out;
};

/**
 * Generates a look-at matrix with the given eye position, focal point, and up axis
 *
 * @param {mat4} out mat4 frustum matrix will be written into
 * @param {vec3} eye Position of the viewer
 * @param {vec3} center Point the viewer is looking at
 * @param {vec3} up vec3 pointing up
 * @returns {mat4} out
 */
mat4.lookAt = function (out, eye, center, up) {
    var x0, x1, x2, y0, y1, y2, z0, z1, z2, len,
        eyex = eye[0],
        eyey = eye[1],
        eyez = eye[2],
        upx = up[0],
        upy = up[1],
        upz = up[2],
        centerx = center[0],
        centery = center[1],
        centerz = center[2];

    if (Math.abs(eyex - centerx) < glMatrix.EPSILON &&
        Math.abs(eyey - centery) < glMatrix.EPSILON &&
        Math.abs(eyez - centerz) < glMatrix.EPSILON) {
        return mat4.identity(out);
    }

    z0 = eyex - centerx;
    z1 = eyey - centery;
    z2 = eyez - centerz;

    len = 1 / Math.sqrt(z0 * z0 + z1 * z1 + z2 * z2);
    z0 *= len;
    z1 *= len;
    z2 *= len;

    x0 = upy * z2 - upz * z1;
    x1 = upz * z0 - upx * z2;
    x2 = upx * z1 - upy * z0;
    len = Math.sqrt(x0 * x0 + x1 * x1 + x2 * x2);
    if (!len) {
        x0 = 0;
        x1 = 0;
        x2 = 0;
    } else {
        len = 1 / len;
        x0 *= len;
        x1 *= len;
        x2 *= len;
    }

    y0 = z1 * x2 - z2 * x1;
    y1 = z2 * x0 - z0 * x2;
    y2 = z0 * x1 - z1 * x0;

    len = Math.sqrt(y0 * y0 + y1 * y1 + y2 * y2);
    if (!len) {
        y0 = 0;
        y1 = 0;
        y2 = 0;
    } else {
        len = 1 / len;
        y0 *= len;
        y1 *= len;
        y2 *= len;
    }

    out[0] = x0;
    out[1] = y0;
    out[2] = z0;
    out[3] = 0;
    out[4] = x1;
    out[5] = y1;
    out[6] = z1;
    out[7] = 0;
    out[8] = x2;
    out[9] = y2;
    out[10] = z2;
    out[11] = 0;
    out[12] = -(x0 * eyex + x1 * eyey + x2 * eyez);
    out[13] = -(y0 * eyex + y1 * eyey + y2 * eyez);
    out[14] = -(z0 * eyex + z1 * eyey + z2 * eyez);
    out[15] = 1;

    return out;
};

/**
 * Returns a string representation of a mat4
 *
 * @param {mat4} mat matrix to represent as a string
 * @returns {String} string representation of the matrix
 */
mat4.str = function (a) {
    return 'mat4(' + a[0] + ', ' + a[1] + ', ' + a[2] + ', ' + a[3] + ', ' +
                    a[4] + ', ' + a[5] + ', ' + a[6] + ', ' + a[7] + ', ' +
                    a[8] + ', ' + a[9] + ', ' + a[10] + ', ' + a[11] + ', ' + 
                    a[12] + ', ' + a[13] + ', ' + a[14] + ', ' + a[15] + ')';
};

/**
 * Returns Frobenius norm of a mat4
 *
 * @param {mat4} a the matrix to calculate Frobenius norm of
 * @returns {Number} Frobenius norm
 */
mat4.frob = function (a) {
    return(Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2) + Math.pow(a[2], 2) + Math.pow(a[3], 2) + Math.pow(a[4], 2) + Math.pow(a[5], 2) + Math.pow(a[6], 2) + Math.pow(a[7], 2) + Math.pow(a[8], 2) + Math.pow(a[9], 2) + Math.pow(a[10], 2) + Math.pow(a[11], 2) + Math.pow(a[12], 2) + Math.pow(a[13], 2) + Math.pow(a[14], 2) + Math.pow(a[15], 2) ))
};


module.exports = mat4;


/***/ }),

/***/ 218:
/***/ (function(module, exports, __webpack_require__) {

/* Copyright (c) 2015, Brandon Jones, Colin MacKenzie IV.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE. */

var glMatrix = __webpack_require__(21);
var mat3 = __webpack_require__(116);
var vec3 = __webpack_require__(117);
var vec4 = __webpack_require__(118);

/**
 * @class Quaternion
 * @name quat
 */
var quat = {};

/**
 * Creates a new identity quat
 *
 * @returns {quat} a new quaternion
 */
quat.create = function() {
    var out = new glMatrix.ARRAY_TYPE(4);
    out[0] = 0;
    out[1] = 0;
    out[2] = 0;
    out[3] = 1;
    return out;
};

/**
 * Sets a quaternion to represent the shortest rotation from one
 * vector to another.
 *
 * Both vectors are assumed to be unit length.
 *
 * @param {quat} out the receiving quaternion.
 * @param {vec3} a the initial vector
 * @param {vec3} b the destination vector
 * @returns {quat} out
 */
quat.rotationTo = (function() {
    var tmpvec3 = vec3.create();
    var xUnitVec3 = vec3.fromValues(1,0,0);
    var yUnitVec3 = vec3.fromValues(0,1,0);

    return function(out, a, b) {
        var dot = vec3.dot(a, b);
        if (dot < -0.999999) {
            vec3.cross(tmpvec3, xUnitVec3, a);
            if (vec3.length(tmpvec3) < 0.000001)
                vec3.cross(tmpvec3, yUnitVec3, a);
            vec3.normalize(tmpvec3, tmpvec3);
            quat.setAxisAngle(out, tmpvec3, Math.PI);
            return out;
        } else if (dot > 0.999999) {
            out[0] = 0;
            out[1] = 0;
            out[2] = 0;
            out[3] = 1;
            return out;
        } else {
            vec3.cross(tmpvec3, a, b);
            out[0] = tmpvec3[0];
            out[1] = tmpvec3[1];
            out[2] = tmpvec3[2];
            out[3] = 1 + dot;
            return quat.normalize(out, out);
        }
    };
})();

/**
 * Sets the specified quaternion with values corresponding to the given
 * axes. Each axis is a vec3 and is expected to be unit length and
 * perpendicular to all other specified axes.
 *
 * @param {vec3} view  the vector representing the viewing direction
 * @param {vec3} right the vector representing the local "right" direction
 * @param {vec3} up    the vector representing the local "up" direction
 * @returns {quat} out
 */
quat.setAxes = (function() {
    var matr = mat3.create();

    return function(out, view, right, up) {
        matr[0] = right[0];
        matr[3] = right[1];
        matr[6] = right[2];

        matr[1] = up[0];
        matr[4] = up[1];
        matr[7] = up[2];

        matr[2] = -view[0];
        matr[5] = -view[1];
        matr[8] = -view[2];

        return quat.normalize(out, quat.fromMat3(out, matr));
    };
})();

/**
 * Creates a new quat initialized with values from an existing quaternion
 *
 * @param {quat} a quaternion to clone
 * @returns {quat} a new quaternion
 * @function
 */
quat.clone = vec4.clone;

/**
 * Creates a new quat initialized with the given values
 *
 * @param {Number} x X component
 * @param {Number} y Y component
 * @param {Number} z Z component
 * @param {Number} w W component
 * @returns {quat} a new quaternion
 * @function
 */
quat.fromValues = vec4.fromValues;

/**
 * Copy the values from one quat to another
 *
 * @param {quat} out the receiving quaternion
 * @param {quat} a the source quaternion
 * @returns {quat} out
 * @function
 */
quat.copy = vec4.copy;

/**
 * Set the components of a quat to the given values
 *
 * @param {quat} out the receiving quaternion
 * @param {Number} x X component
 * @param {Number} y Y component
 * @param {Number} z Z component
 * @param {Number} w W component
 * @returns {quat} out
 * @function
 */
quat.set = vec4.set;

/**
 * Set a quat to the identity quaternion
 *
 * @param {quat} out the receiving quaternion
 * @returns {quat} out
 */
quat.identity = function(out) {
    out[0] = 0;
    out[1] = 0;
    out[2] = 0;
    out[3] = 1;
    return out;
};

/**
 * Sets a quat from the given angle and rotation axis,
 * then returns it.
 *
 * @param {quat} out the receiving quaternion
 * @param {vec3} axis the axis around which to rotate
 * @param {Number} rad the angle in radians
 * @returns {quat} out
 **/
quat.setAxisAngle = function(out, axis, rad) {
    rad = rad * 0.5;
    var s = Math.sin(rad);
    out[0] = s * axis[0];
    out[1] = s * axis[1];
    out[2] = s * axis[2];
    out[3] = Math.cos(rad);
    return out;
};

/**
 * Adds two quat's
 *
 * @param {quat} out the receiving quaternion
 * @param {quat} a the first operand
 * @param {quat} b the second operand
 * @returns {quat} out
 * @function
 */
quat.add = vec4.add;

/**
 * Multiplies two quat's
 *
 * @param {quat} out the receiving quaternion
 * @param {quat} a the first operand
 * @param {quat} b the second operand
 * @returns {quat} out
 */
quat.multiply = function(out, a, b) {
    var ax = a[0], ay = a[1], az = a[2], aw = a[3],
        bx = b[0], by = b[1], bz = b[2], bw = b[3];

    out[0] = ax * bw + aw * bx + ay * bz - az * by;
    out[1] = ay * bw + aw * by + az * bx - ax * bz;
    out[2] = az * bw + aw * bz + ax * by - ay * bx;
    out[3] = aw * bw - ax * bx - ay * by - az * bz;
    return out;
};

/**
 * Alias for {@link quat.multiply}
 * @function
 */
quat.mul = quat.multiply;

/**
 * Scales a quat by a scalar number
 *
 * @param {quat} out the receiving vector
 * @param {quat} a the vector to scale
 * @param {Number} b amount to scale the vector by
 * @returns {quat} out
 * @function
 */
quat.scale = vec4.scale;

/**
 * Rotates a quaternion by the given angle about the X axis
 *
 * @param {quat} out quat receiving operation result
 * @param {quat} a quat to rotate
 * @param {number} rad angle (in radians) to rotate
 * @returns {quat} out
 */
quat.rotateX = function (out, a, rad) {
    rad *= 0.5; 

    var ax = a[0], ay = a[1], az = a[2], aw = a[3],
        bx = Math.sin(rad), bw = Math.cos(rad);

    out[0] = ax * bw + aw * bx;
    out[1] = ay * bw + az * bx;
    out[2] = az * bw - ay * bx;
    out[3] = aw * bw - ax * bx;
    return out;
};

/**
 * Rotates a quaternion by the given angle about the Y axis
 *
 * @param {quat} out quat receiving operation result
 * @param {quat} a quat to rotate
 * @param {number} rad angle (in radians) to rotate
 * @returns {quat} out
 */
quat.rotateY = function (out, a, rad) {
    rad *= 0.5; 

    var ax = a[0], ay = a[1], az = a[2], aw = a[3],
        by = Math.sin(rad), bw = Math.cos(rad);

    out[0] = ax * bw - az * by;
    out[1] = ay * bw + aw * by;
    out[2] = az * bw + ax * by;
    out[3] = aw * bw - ay * by;
    return out;
};

/**
 * Rotates a quaternion by the given angle about the Z axis
 *
 * @param {quat} out quat receiving operation result
 * @param {quat} a quat to rotate
 * @param {number} rad angle (in radians) to rotate
 * @returns {quat} out
 */
quat.rotateZ = function (out, a, rad) {
    rad *= 0.5; 

    var ax = a[0], ay = a[1], az = a[2], aw = a[3],
        bz = Math.sin(rad), bw = Math.cos(rad);

    out[0] = ax * bw + ay * bz;
    out[1] = ay * bw - ax * bz;
    out[2] = az * bw + aw * bz;
    out[3] = aw * bw - az * bz;
    return out;
};

/**
 * Calculates the W component of a quat from the X, Y, and Z components.
 * Assumes that quaternion is 1 unit in length.
 * Any existing W component will be ignored.
 *
 * @param {quat} out the receiving quaternion
 * @param {quat} a quat to calculate W component of
 * @returns {quat} out
 */
quat.calculateW = function (out, a) {
    var x = a[0], y = a[1], z = a[2];

    out[0] = x;
    out[1] = y;
    out[2] = z;
    out[3] = Math.sqrt(Math.abs(1.0 - x * x - y * y - z * z));
    return out;
};

/**
 * Calculates the dot product of two quat's
 *
 * @param {quat} a the first operand
 * @param {quat} b the second operand
 * @returns {Number} dot product of a and b
 * @function
 */
quat.dot = vec4.dot;

/**
 * Performs a linear interpolation between two quat's
 *
 * @param {quat} out the receiving quaternion
 * @param {quat} a the first operand
 * @param {quat} b the second operand
 * @param {Number} t interpolation amount between the two inputs
 * @returns {quat} out
 * @function
 */
quat.lerp = vec4.lerp;

/**
 * Performs a spherical linear interpolation between two quat
 *
 * @param {quat} out the receiving quaternion
 * @param {quat} a the first operand
 * @param {quat} b the second operand
 * @param {Number} t interpolation amount between the two inputs
 * @returns {quat} out
 */
quat.slerp = function (out, a, b, t) {
    // benchmarks:
    //    http://jsperf.com/quaternion-slerp-implementations

    var ax = a[0], ay = a[1], az = a[2], aw = a[3],
        bx = b[0], by = b[1], bz = b[2], bw = b[3];

    var        omega, cosom, sinom, scale0, scale1;

    // calc cosine
    cosom = ax * bx + ay * by + az * bz + aw * bw;
    // adjust signs (if necessary)
    if ( cosom < 0.0 ) {
        cosom = -cosom;
        bx = - bx;
        by = - by;
        bz = - bz;
        bw = - bw;
    }
    // calculate coefficients
    if ( (1.0 - cosom) > 0.000001 ) {
        // standard case (slerp)
        omega  = Math.acos(cosom);
        sinom  = Math.sin(omega);
        scale0 = Math.sin((1.0 - t) * omega) / sinom;
        scale1 = Math.sin(t * omega) / sinom;
    } else {        
        // "from" and "to" quaternions are very close 
        //  ... so we can do a linear interpolation
        scale0 = 1.0 - t;
        scale1 = t;
    }
    // calculate final values
    out[0] = scale0 * ax + scale1 * bx;
    out[1] = scale0 * ay + scale1 * by;
    out[2] = scale0 * az + scale1 * bz;
    out[3] = scale0 * aw + scale1 * bw;
    
    return out;
};

/**
 * Performs a spherical linear interpolation with two control points
 *
 * @param {quat} out the receiving quaternion
 * @param {quat} a the first operand
 * @param {quat} b the second operand
 * @param {quat} c the third operand
 * @param {quat} d the fourth operand
 * @param {Number} t interpolation amount
 * @returns {quat} out
 */
quat.sqlerp = (function () {
  var temp1 = quat.create();
  var temp2 = quat.create();
  
  return function (out, a, b, c, d, t) {
    quat.slerp(temp1, a, d, t);
    quat.slerp(temp2, b, c, t);
    quat.slerp(out, temp1, temp2, 2 * t * (1 - t));
    
    return out;
  };
}());

/**
 * Calculates the inverse of a quat
 *
 * @param {quat} out the receiving quaternion
 * @param {quat} a quat to calculate inverse of
 * @returns {quat} out
 */
quat.invert = function(out, a) {
    var a0 = a[0], a1 = a[1], a2 = a[2], a3 = a[3],
        dot = a0*a0 + a1*a1 + a2*a2 + a3*a3,
        invDot = dot ? 1.0/dot : 0;
    
    // TODO: Would be faster to return [0,0,0,0] immediately if dot == 0

    out[0] = -a0*invDot;
    out[1] = -a1*invDot;
    out[2] = -a2*invDot;
    out[3] = a3*invDot;
    return out;
};

/**
 * Calculates the conjugate of a quat
 * If the quaternion is normalized, this function is faster than quat.inverse and produces the same result.
 *
 * @param {quat} out the receiving quaternion
 * @param {quat} a quat to calculate conjugate of
 * @returns {quat} out
 */
quat.conjugate = function (out, a) {
    out[0] = -a[0];
    out[1] = -a[1];
    out[2] = -a[2];
    out[3] = a[3];
    return out;
};

/**
 * Calculates the length of a quat
 *
 * @param {quat} a vector to calculate length of
 * @returns {Number} length of a
 * @function
 */
quat.length = vec4.length;

/**
 * Alias for {@link quat.length}
 * @function
 */
quat.len = quat.length;

/**
 * Calculates the squared length of a quat
 *
 * @param {quat} a vector to calculate squared length of
 * @returns {Number} squared length of a
 * @function
 */
quat.squaredLength = vec4.squaredLength;

/**
 * Alias for {@link quat.squaredLength}
 * @function
 */
quat.sqrLen = quat.squaredLength;

/**
 * Normalize a quat
 *
 * @param {quat} out the receiving quaternion
 * @param {quat} a quaternion to normalize
 * @returns {quat} out
 * @function
 */
quat.normalize = vec4.normalize;

/**
 * Creates a quaternion from the given 3x3 rotation matrix.
 *
 * NOTE: The resultant quaternion is not normalized, so you should be sure
 * to renormalize the quaternion yourself where necessary.
 *
 * @param {quat} out the receiving quaternion
 * @param {mat3} m rotation matrix
 * @returns {quat} out
 * @function
 */
quat.fromMat3 = function(out, m) {
    // Algorithm in Ken Shoemake's article in 1987 SIGGRAPH course notes
    // article "Quaternion Calculus and Fast Animation".
    var fTrace = m[0] + m[4] + m[8];
    var fRoot;

    if ( fTrace > 0.0 ) {
        // |w| > 1/2, may as well choose w > 1/2
        fRoot = Math.sqrt(fTrace + 1.0);  // 2w
        out[3] = 0.5 * fRoot;
        fRoot = 0.5/fRoot;  // 1/(4w)
        out[0] = (m[5]-m[7])*fRoot;
        out[1] = (m[6]-m[2])*fRoot;
        out[2] = (m[1]-m[3])*fRoot;
    } else {
        // |w| <= 1/2
        var i = 0;
        if ( m[4] > m[0] )
          i = 1;
        if ( m[8] > m[i*3+i] )
          i = 2;
        var j = (i+1)%3;
        var k = (i+2)%3;
        
        fRoot = Math.sqrt(m[i*3+i]-m[j*3+j]-m[k*3+k] + 1.0);
        out[i] = 0.5 * fRoot;
        fRoot = 0.5 / fRoot;
        out[3] = (m[j*3+k] - m[k*3+j]) * fRoot;
        out[j] = (m[j*3+i] + m[i*3+j]) * fRoot;
        out[k] = (m[k*3+i] + m[i*3+k]) * fRoot;
    }
    
    return out;
};

/**
 * Returns a string representation of a quatenion
 *
 * @param {quat} vec vector to represent as a string
 * @returns {String} string representation of the vector
 */
quat.str = function (a) {
    return 'quat(' + a[0] + ', ' + a[1] + ', ' + a[2] + ', ' + a[3] + ')';
};

module.exports = quat;


/***/ }),

/***/ 219:
/***/ (function(module, exports, __webpack_require__) {

/* Copyright (c) 2015, Brandon Jones, Colin MacKenzie IV.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE. */

var glMatrix = __webpack_require__(21);

/**
 * @class 2 Dimensional Vector
 * @name vec2
 */
var vec2 = {};

/**
 * Creates a new, empty vec2
 *
 * @returns {vec2} a new 2D vector
 */
vec2.create = function() {
    var out = new glMatrix.ARRAY_TYPE(2);
    out[0] = 0;
    out[1] = 0;
    return out;
};

/**
 * Creates a new vec2 initialized with values from an existing vector
 *
 * @param {vec2} a vector to clone
 * @returns {vec2} a new 2D vector
 */
vec2.clone = function(a) {
    var out = new glMatrix.ARRAY_TYPE(2);
    out[0] = a[0];
    out[1] = a[1];
    return out;
};

/**
 * Creates a new vec2 initialized with the given values
 *
 * @param {Number} x X component
 * @param {Number} y Y component
 * @returns {vec2} a new 2D vector
 */
vec2.fromValues = function(x, y) {
    var out = new glMatrix.ARRAY_TYPE(2);
    out[0] = x;
    out[1] = y;
    return out;
};

/**
 * Copy the values from one vec2 to another
 *
 * @param {vec2} out the receiving vector
 * @param {vec2} a the source vector
 * @returns {vec2} out
 */
vec2.copy = function(out, a) {
    out[0] = a[0];
    out[1] = a[1];
    return out;
};

/**
 * Set the components of a vec2 to the given values
 *
 * @param {vec2} out the receiving vector
 * @param {Number} x X component
 * @param {Number} y Y component
 * @returns {vec2} out
 */
vec2.set = function(out, x, y) {
    out[0] = x;
    out[1] = y;
    return out;
};

/**
 * Adds two vec2's
 *
 * @param {vec2} out the receiving vector
 * @param {vec2} a the first operand
 * @param {vec2} b the second operand
 * @returns {vec2} out
 */
vec2.add = function(out, a, b) {
    out[0] = a[0] + b[0];
    out[1] = a[1] + b[1];
    return out;
};

/**
 * Subtracts vector b from vector a
 *
 * @param {vec2} out the receiving vector
 * @param {vec2} a the first operand
 * @param {vec2} b the second operand
 * @returns {vec2} out
 */
vec2.subtract = function(out, a, b) {
    out[0] = a[0] - b[0];
    out[1] = a[1] - b[1];
    return out;
};

/**
 * Alias for {@link vec2.subtract}
 * @function
 */
vec2.sub = vec2.subtract;

/**
 * Multiplies two vec2's
 *
 * @param {vec2} out the receiving vector
 * @param {vec2} a the first operand
 * @param {vec2} b the second operand
 * @returns {vec2} out
 */
vec2.multiply = function(out, a, b) {
    out[0] = a[0] * b[0];
    out[1] = a[1] * b[1];
    return out;
};

/**
 * Alias for {@link vec2.multiply}
 * @function
 */
vec2.mul = vec2.multiply;

/**
 * Divides two vec2's
 *
 * @param {vec2} out the receiving vector
 * @param {vec2} a the first operand
 * @param {vec2} b the second operand
 * @returns {vec2} out
 */
vec2.divide = function(out, a, b) {
    out[0] = a[0] / b[0];
    out[1] = a[1] / b[1];
    return out;
};

/**
 * Alias for {@link vec2.divide}
 * @function
 */
vec2.div = vec2.divide;

/**
 * Returns the minimum of two vec2's
 *
 * @param {vec2} out the receiving vector
 * @param {vec2} a the first operand
 * @param {vec2} b the second operand
 * @returns {vec2} out
 */
vec2.min = function(out, a, b) {
    out[0] = Math.min(a[0], b[0]);
    out[1] = Math.min(a[1], b[1]);
    return out;
};

/**
 * Returns the maximum of two vec2's
 *
 * @param {vec2} out the receiving vector
 * @param {vec2} a the first operand
 * @param {vec2} b the second operand
 * @returns {vec2} out
 */
vec2.max = function(out, a, b) {
    out[0] = Math.max(a[0], b[0]);
    out[1] = Math.max(a[1], b[1]);
    return out;
};

/**
 * Scales a vec2 by a scalar number
 *
 * @param {vec2} out the receiving vector
 * @param {vec2} a the vector to scale
 * @param {Number} b amount to scale the vector by
 * @returns {vec2} out
 */
vec2.scale = function(out, a, b) {
    out[0] = a[0] * b;
    out[1] = a[1] * b;
    return out;
};

/**
 * Adds two vec2's after scaling the second operand by a scalar value
 *
 * @param {vec2} out the receiving vector
 * @param {vec2} a the first operand
 * @param {vec2} b the second operand
 * @param {Number} scale the amount to scale b by before adding
 * @returns {vec2} out
 */
vec2.scaleAndAdd = function(out, a, b, scale) {
    out[0] = a[0] + (b[0] * scale);
    out[1] = a[1] + (b[1] * scale);
    return out;
};

/**
 * Calculates the euclidian distance between two vec2's
 *
 * @param {vec2} a the first operand
 * @param {vec2} b the second operand
 * @returns {Number} distance between a and b
 */
vec2.distance = function(a, b) {
    var x = b[0] - a[0],
        y = b[1] - a[1];
    return Math.sqrt(x*x + y*y);
};

/**
 * Alias for {@link vec2.distance}
 * @function
 */
vec2.dist = vec2.distance;

/**
 * Calculates the squared euclidian distance between two vec2's
 *
 * @param {vec2} a the first operand
 * @param {vec2} b the second operand
 * @returns {Number} squared distance between a and b
 */
vec2.squaredDistance = function(a, b) {
    var x = b[0] - a[0],
        y = b[1] - a[1];
    return x*x + y*y;
};

/**
 * Alias for {@link vec2.squaredDistance}
 * @function
 */
vec2.sqrDist = vec2.squaredDistance;

/**
 * Calculates the length of a vec2
 *
 * @param {vec2} a vector to calculate length of
 * @returns {Number} length of a
 */
vec2.length = function (a) {
    var x = a[0],
        y = a[1];
    return Math.sqrt(x*x + y*y);
};

/**
 * Alias for {@link vec2.length}
 * @function
 */
vec2.len = vec2.length;

/**
 * Calculates the squared length of a vec2
 *
 * @param {vec2} a vector to calculate squared length of
 * @returns {Number} squared length of a
 */
vec2.squaredLength = function (a) {
    var x = a[0],
        y = a[1];
    return x*x + y*y;
};

/**
 * Alias for {@link vec2.squaredLength}
 * @function
 */
vec2.sqrLen = vec2.squaredLength;

/**
 * Negates the components of a vec2
 *
 * @param {vec2} out the receiving vector
 * @param {vec2} a vector to negate
 * @returns {vec2} out
 */
vec2.negate = function(out, a) {
    out[0] = -a[0];
    out[1] = -a[1];
    return out;
};

/**
 * Returns the inverse of the components of a vec2
 *
 * @param {vec2} out the receiving vector
 * @param {vec2} a vector to invert
 * @returns {vec2} out
 */
vec2.inverse = function(out, a) {
  out[0] = 1.0 / a[0];
  out[1] = 1.0 / a[1];
  return out;
};

/**
 * Normalize a vec2
 *
 * @param {vec2} out the receiving vector
 * @param {vec2} a vector to normalize
 * @returns {vec2} out
 */
vec2.normalize = function(out, a) {
    var x = a[0],
        y = a[1];
    var len = x*x + y*y;
    if (len > 0) {
        //TODO: evaluate use of glm_invsqrt here?
        len = 1 / Math.sqrt(len);
        out[0] = a[0] * len;
        out[1] = a[1] * len;
    }
    return out;
};

/**
 * Calculates the dot product of two vec2's
 *
 * @param {vec2} a the first operand
 * @param {vec2} b the second operand
 * @returns {Number} dot product of a and b
 */
vec2.dot = function (a, b) {
    return a[0] * b[0] + a[1] * b[1];
};

/**
 * Computes the cross product of two vec2's
 * Note that the cross product must by definition produce a 3D vector
 *
 * @param {vec3} out the receiving vector
 * @param {vec2} a the first operand
 * @param {vec2} b the second operand
 * @returns {vec3} out
 */
vec2.cross = function(out, a, b) {
    var z = a[0] * b[1] - a[1] * b[0];
    out[0] = out[1] = 0;
    out[2] = z;
    return out;
};

/**
 * Performs a linear interpolation between two vec2's
 *
 * @param {vec2} out the receiving vector
 * @param {vec2} a the first operand
 * @param {vec2} b the second operand
 * @param {Number} t interpolation amount between the two inputs
 * @returns {vec2} out
 */
vec2.lerp = function (out, a, b, t) {
    var ax = a[0],
        ay = a[1];
    out[0] = ax + t * (b[0] - ax);
    out[1] = ay + t * (b[1] - ay);
    return out;
};

/**
 * Generates a random vector with the given scale
 *
 * @param {vec2} out the receiving vector
 * @param {Number} [scale] Length of the resulting vector. If ommitted, a unit vector will be returned
 * @returns {vec2} out
 */
vec2.random = function (out, scale) {
    scale = scale || 1.0;
    var r = glMatrix.RANDOM() * 2.0 * Math.PI;
    out[0] = Math.cos(r) * scale;
    out[1] = Math.sin(r) * scale;
    return out;
};

/**
 * Transforms the vec2 with a mat2
 *
 * @param {vec2} out the receiving vector
 * @param {vec2} a the vector to transform
 * @param {mat2} m matrix to transform with
 * @returns {vec2} out
 */
vec2.transformMat2 = function(out, a, m) {
    var x = a[0],
        y = a[1];
    out[0] = m[0] * x + m[2] * y;
    out[1] = m[1] * x + m[3] * y;
    return out;
};

/**
 * Transforms the vec2 with a mat2d
 *
 * @param {vec2} out the receiving vector
 * @param {vec2} a the vector to transform
 * @param {mat2d} m matrix to transform with
 * @returns {vec2} out
 */
vec2.transformMat2d = function(out, a, m) {
    var x = a[0],
        y = a[1];
    out[0] = m[0] * x + m[2] * y + m[4];
    out[1] = m[1] * x + m[3] * y + m[5];
    return out;
};

/**
 * Transforms the vec2 with a mat3
 * 3rd vector component is implicitly '1'
 *
 * @param {vec2} out the receiving vector
 * @param {vec2} a the vector to transform
 * @param {mat3} m matrix to transform with
 * @returns {vec2} out
 */
vec2.transformMat3 = function(out, a, m) {
    var x = a[0],
        y = a[1];
    out[0] = m[0] * x + m[3] * y + m[6];
    out[1] = m[1] * x + m[4] * y + m[7];
    return out;
};

/**
 * Transforms the vec2 with a mat4
 * 3rd vector component is implicitly '0'
 * 4th vector component is implicitly '1'
 *
 * @param {vec2} out the receiving vector
 * @param {vec2} a the vector to transform
 * @param {mat4} m matrix to transform with
 * @returns {vec2} out
 */
vec2.transformMat4 = function(out, a, m) {
    var x = a[0], 
        y = a[1];
    out[0] = m[0] * x + m[4] * y + m[12];
    out[1] = m[1] * x + m[5] * y + m[13];
    return out;
};

/**
 * Perform some operation over an array of vec2s.
 *
 * @param {Array} a the array of vectors to iterate over
 * @param {Number} stride Number of elements between the start of each vec2. If 0 assumes tightly packed
 * @param {Number} offset Number of elements to skip at the beginning of the array
 * @param {Number} count Number of vec2s to iterate over. If 0 iterates over entire array
 * @param {Function} fn Function to call for each vector in the array
 * @param {Object} [arg] additional argument to pass to fn
 * @returns {Array} a
 * @function
 */
vec2.forEach = (function() {
    var vec = vec2.create();

    return function(a, stride, offset, count, fn, arg) {
        var i, l;
        if(!stride) {
            stride = 2;
        }

        if(!offset) {
            offset = 0;
        }
        
        if(count) {
            l = Math.min((count * stride) + offset, a.length);
        } else {
            l = a.length;
        }

        for(i = offset; i < l; i += stride) {
            vec[0] = a[i]; vec[1] = a[i+1];
            fn(vec, vec, arg);
            a[i] = vec[0]; a[i+1] = vec[1];
        }
        
        return a;
    };
})();

/**
 * Returns a string representation of a vector
 *
 * @param {vec2} vec vector to represent as a string
 * @returns {String} string representation of the vector
 */
vec2.str = function (a) {
    return 'vec2(' + a[0] + ', ' + a[1] + ')';
};

module.exports = vec2;


/***/ }),

/***/ 236:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var TinyEmitter = function () {
  function TinyEmitter() {
    _classCallCheck(this, TinyEmitter);

    Object.defineProperty(this, '__listeners', {
      value: {},
      enumerable: false,
      writable: false
    });
  }

  _createClass(TinyEmitter, [{
    key: 'emit',
    value: function emit(eventName) {
      for (var _len = arguments.length, args = Array(_len > 1 ? _len - 1 : 0), _key = 1; _key < _len; _key++) {
        args[_key - 1] = arguments[_key];
      }

      var _iteratorNormalCompletion = true;
      var _didIteratorError = false;
      var _iteratorError = undefined;

      try {
        for (var _iterator = this.__listeners[eventName][Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
          var handler = _step.value;

          handler.apply(undefined, args);
        }
      } catch (err) {
        _didIteratorError = true;
        _iteratorError = err;
      } finally {
        try {
          if (!_iteratorNormalCompletion && _iterator.return) {
            _iterator.return();
          }
        } finally {
          if (_didIteratorError) {
            throw _iteratorError;
          }
        }
      }

      return this;
    }
  }, {
    key: 'once',
    value: function once(eventName, handler) {
      var _this = this;

      var once = function once() {
        _this.off(eventName, once);
        handler.apply(undefined, arguments);
      };

      return this.on(eventName, once);
    }
  }, {
    key: 'on',
    value: function on(eventName, handler) {
      if (!this.__listeners[eventName]) this.__listeners[eventName] = [];

      this.__listeners[eventName].push(handler);

      return this;
    }
  }, {
    key: 'off',
    value: function off(eventName, handler) {
      if (handler) this.__listeners[eventName] = this.__listeners[eventName].filter(function (h) {
        return h !== handler;
      });else this.__listeners[eventName] = [];

      return this;
    }
  }]);

  return TinyEmitter;
}();

module.exports = TinyEmitter;

/***/ }),

/***/ 25:
/***/ (function(module, exports) {

module.exports = function(module) {
	if(!module.webpackPolyfill) {
		module.deprecate = function() {};
		module.paths = [];
		// module.parent = undefined by default
		if(!module.children) module.children = [];
		Object.defineProperty(module, "loaded", {
			enumerable: true,
			get: function() {
				return module.l;
			}
		});
		Object.defineProperty(module, "id", {
			enumerable: true,
			get: function() {
				return module.i;
			}
		});
		module.webpackPolyfill = 1;
	}
	return module;
};


/***/ }),

/***/ 31:
/***/ (function(module, exports) {

/* WEBPACK VAR INJECTION */(function(__webpack_amd_options__) {/* globals __webpack_amd_options__ */
module.exports = __webpack_amd_options__;

/* WEBPACK VAR INJECTION */}.call(exports, {}))

/***/ }),

/***/ 39:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});
var DataTypeByteSize = exports.DataTypeByteSize = {
  Int8Array: 1,
  Uint8Array: 1,
  Uint8ClampedArray: 1,
  Int16Array: 2,
  Uint16Array: 2,
  Int32Array: 4,
  Uint32Array: 4,
  Float32Array: 4,
  Float64Array: 8
};

var VtkDataTypes = exports.VtkDataTypes = {
  VOID: '', // not sure to know what that shoud be
  CHAR: 'Int8Array',
  SIGNED_CHAR: 'Int8Array',
  UNSIGNED_CHAR: 'Uint8Array',
  SHORT: 'Int16Array',
  UNSIGNED_SHORT: 'Uint16Array',
  INT: 'Int32Array',
  UNSIGNED_INT: 'Uint32Array',
  FLOAT: 'Float32Array',
  DOUBLE: 'Float64Array'
};

var DefaultDataType = exports.DefaultDataType = VtkDataTypes.FLOAT;

exports.default = {
  DefaultDataType: DefaultDataType,
  DataTypeByteSize: DataTypeByteSize,
  VtkDataTypes: VtkDataTypes
};

/***/ }),

/***/ 52:
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function(global) {

Object.defineProperty(exports, "__esModule", {
  value: true
});

var _typeof = typeof Symbol === "function" && typeof Symbol.iterator === "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : typeof obj; };

exports.default = vtk;
var factoryMapping = {
  vtkObject: function vtkObject() {
    return null;
  }
};

function vtk(obj) {
  if (obj === null || obj === undefined) {
    return obj;
  }
  if (obj.isA) {
    return obj;
  }
  if (!obj.vtkClass) {
    if (global.console && global.console.error) {
      global.console.error('Invalid VTK object');
    }
    return null;
  }
  var constructor = factoryMapping[obj.vtkClass];
  if (!constructor) {
    if (global.console && global.console.error) {
      global.console.error('No vtk class found for Object of type ' + obj.vtkClass);
    }
    return null;
  }

  // Shallow copy object
  var model = Object.assign({}, obj);

  // Convert into vtkObject any nested key
  Object.keys(model).forEach(function (keyName) {
    if (model[keyName] && _typeof(model[keyName]) === 'object' && model[keyName].vtkClass) {
      model[keyName] = vtk(model[keyName]);
    }
  });

  // Return the root
  var newInst = constructor(model);
  if (newInst && newInst.modified) {
    newInst.modified();
  }
  return newInst;
}

function register(vtkClassName, constructor) {
  factoryMapping[vtkClassName] = constructor;
}

// Nest register method under the vtk function
vtk.register = register;
/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(20)))

/***/ }),

/***/ 59:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.newInstance = undefined;
exports.extend = extend;

var _macro = __webpack_require__(0);

var _macro2 = _interopRequireDefault(_macro);

var _DataSet = __webpack_require__(114);

var _DataSet2 = _interopRequireDefault(_DataSet);

var _StructuredData = __webpack_require__(214);

var _StructuredData2 = _interopRequireDefault(_StructuredData);

var _Constants = __webpack_require__(115);

var _glMatrix = __webpack_require__(15);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var vtkErrorMacro = _macro2.default.vtkErrorMacro;

// ----------------------------------------------------------------------------
// vtkImageData methods
// ----------------------------------------------------------------------------

function vtkImageData(publicAPI, model) {
  // Set our className
  model.classHierarchy.push('vtkImageData');

  publicAPI.setExtent = function () {
    for (var _len = arguments.length, inExtent = Array(_len), _key = 0; _key < _len; _key++) {
      inExtent[_key] = arguments[_key];
    }

    if (model.deleted) {
      vtkErrorMacro('instance deleted - cannot call any method');
      return;
    }

    if (!inExtent || inExtent.length !== 6) {
      return;
    }

    var changeDetected = false;
    model.extent.forEach(function (item, index) {
      if (item !== inExtent[index]) {
        if (changeDetected) {
          return;
        }
        changeDetected = true;
      }
    });

    if (changeDetected) {
      model.extent = [].concat(inExtent);
      model.dataDescription = _StructuredData2.default.getDataDescriptionFromExtent(model.extent);
      publicAPI.modified();
    }
  };

  publicAPI.setDimensions = function () {
    var i = void 0;
    var j = void 0;
    var k = void 0;

    if (model.deleted) {
      vtkErrorMacro('instance deleted - cannot call any method');
      return;
    }

    if (arguments.length === 1) {
      var array = arguments.length <= 0 ? undefined : arguments[0];
      i = array[0];
      j = array[1];
      k = array[2];
    } else if (arguments.length === 3) {
      i = arguments.length <= 0 ? undefined : arguments[0];
      j = arguments.length <= 1 ? undefined : arguments[1];
      k = arguments.length <= 2 ? undefined : arguments[2];
    } else {
      vtkErrorMacro('Bad dimension specification');
      return;
    }

    publicAPI.setExtent(0, i - 1, 0, j - 1, 0, k - 1);
  };

  publicAPI.getDimensions = function () {
    return [model.extent[1] - model.extent[0] + 1, model.extent[3] - model.extent[2] + 1, model.extent[5] - model.extent[4] + 1];
  };

  publicAPI.getNumberOfCells = function () {
    var dims = publicAPI.getDimensions();
    var nCells = 1;

    for (var i = 0; i < 3; i++) {
      if (dims[i] === 0) {
        return 0;
      }
      if (dims[i] > 1) {
        nCells *= dims[i] - 1;
      }
    }

    return nCells;
  };

  publicAPI.getNumberOfPoints = function () {
    var dims = publicAPI.getDimensions();
    return dims[0] * dims[1] * dims[2];
  };

  publicAPI.getPoint = function (index) {
    var dims = publicAPI.getDimensions();
    var ijk = _glMatrix.vec3.fromValues(0, 0, 0);
    var coords = [0, 0, 0];

    if (dims[0] === 0 || dims[1] === 0 || dims[2] === 0) {
      vtkErrorMacro('Requesting a point from an empty image.');
      return null;
    }

    switch (model.dataDescription) {
      case _Constants.StructuredType.EMPTY:
        return null;

      case _Constants.StructuredType.SINGLE_POINT:
        break;

      case _Constants.StructuredType.X_LINE:
        ijk[0] = index;
        break;

      case _Constants.StructuredType.Y_LINE:
        ijk[1] = index;
        break;

      case _Constants.StructuredType.Z_LINE:
        ijk[2] = index;
        break;

      case _Constants.StructuredType.XY_PLANE:
        ijk[0] = index % dims[0];
        ijk[1] = index / dims[0];
        break;

      case _Constants.StructuredType.YZ_PLANE:
        ijk[1] = index % dims[1];
        ijk[2] = index / dims[1];
        break;

      case _Constants.StructuredType.XZ_PLANE:
        ijk[0] = index % dims[0];
        ijk[2] = index / dims[0];
        break;

      case _Constants.StructuredType.XYZ_GRID:
        ijk[0] = index % dims[0];
        ijk[1] = index / dims[0] % dims[1];
        ijk[2] = index / (dims[0] * dims[1]);
        break;

      default:
        vtkErrorMacro('Invalid dataDescription');
        break;
    }

    var vout = _glMatrix.vec3.create();
    publicAPI.indexToWorldVec3(ijk, vout);
    _glMatrix.vec3.copy(coords, vout);
    return coords;
  };

  // vtkCell *GetCell(vtkIdType cellId) VTK_OVERRIDE;
  // void GetCell(vtkIdType cellId, vtkGenericCell *cell) VTK_OVERRIDE;
  // void GetCellBounds(vtkIdType cellId, double bounds[6]) VTK_OVERRIDE;
  // virtual vtkIdType FindPoint(double x, double y, double z)
  // {
  //   return this->vtkDataSet::FindPoint(x, y, z);
  // }
  // vtkIdType FindPoint(double x[3]) VTK_OVERRIDE;
  // vtkIdType FindCell(
  //   double x[3], vtkCell *cell, vtkIdType cellId, double tol2,
  //   int& subId, double pcoords[3], double *weights) VTK_OVERRIDE;
  // vtkIdType FindCell(
  //   double x[3], vtkCell *cell, vtkGenericCell *gencell,
  //   vtkIdType cellId, double tol2, int& subId,
  //   double pcoords[3], double *weights) VTK_OVERRIDE;
  // vtkCell *FindAndGetCell(double x[3], vtkCell *cell, vtkIdType cellId,
  //                                 double tol2, int& subId, double pcoords[3],
  //                                 double *weights) VTK_OVERRIDE;
  // int GetCellType(vtkIdType cellId) VTK_OVERRIDE;
  // void GetCellPoints(vtkIdType cellId, vtkIdList *ptIds) VTK_OVERRIDE
  //   {vtkStructuredData::GetCellPoints(cellId,ptIds,this->DataDescription,
  //                                     this->GetDimensions());}
  // void GetPointCells(vtkIdType ptId, vtkIdList *cellIds) VTK_OVERRIDE
  //   {vtkStructuredData::GetPointCells(ptId,cellIds,this->GetDimensions());}
  // void ComputeBounds() VTK_OVERRIDE;
  // int GetMaxCellSize() VTK_OVERRIDE {return 8;}; //voxel is the largest

  publicAPI.getBounds = function () {
    return publicAPI.extentToBounds(model.extent);
  };

  publicAPI.extentToBounds = function (ex) {
    // prettier-ignore
    var corners = [ex[0], ex[2], ex[4], ex[1], ex[2], ex[4], ex[0], ex[3], ex[4], ex[1], ex[3], ex[4], ex[0], ex[2], ex[5], ex[1], ex[2], ex[5], ex[0], ex[3], ex[5], ex[1], ex[3], ex[5]];

    var idx = _glMatrix.vec3.fromValues(corners[0], corners[1], corners[2]);
    var vout = _glMatrix.vec3.create();
    publicAPI.indexToWorldVec3(idx, vout);
    var bounds = [vout[0], vout[0], vout[1], vout[1], vout[2], vout[2]];
    for (var i = 3; i < 24; i += 3) {
      _glMatrix.vec3.set(idx, corners[i], corners[i + 1], corners[i + 2]);
      publicAPI.indexToWorldVec3(idx, vout);
      if (vout[0] < bounds[0]) {
        bounds[0] = vout[0];
      }
      if (vout[1] < bounds[2]) {
        bounds[2] = vout[1];
      }
      if (vout[2] < bounds[4]) {
        bounds[4] = vout[2];
      }
      if (vout[0] > bounds[1]) {
        bounds[1] = vout[0];
      }
      if (vout[1] > bounds[3]) {
        bounds[3] = vout[1];
      }
      if (vout[2] > bounds[5]) {
        bounds[5] = vout[2];
      }
    }

    return bounds;
  };

  publicAPI.computeTransforms = function () {
    var rotq = _glMatrix.quat.create();
    _glMatrix.quat.fromMat3(rotq, model.direction);
    var trans = _glMatrix.vec3.fromValues(model.origin[0], model.origin[1], model.origin[2]);
    var scale = _glMatrix.vec3.fromValues(model.spacing[0], model.spacing[1], model.spacing[2]);
    _glMatrix.mat4.fromRotationTranslationScale(model.indexToWorld, rotq, trans, scale);
    _glMatrix.mat4.invert(model.worldToIndex, model.indexToWorld);
  };

  //
  // The direction matrix is a 3x3 basis for the I, J, K axes
  // of the image. The rows of the matrix correspond to the
  // axes directions in world coordinates. Direction must
  // form an orthonormal basis, results are undefined if
  // it is not.
  //
  publicAPI.setDirection = function () {
    for (var _len2 = arguments.length, args = Array(_len2), _key2 = 0; _key2 < _len2; _key2++) {
      args[_key2] = arguments[_key2];
    }

    if (model.deleted) {
      vtkErrorMacro('instance deleted - cannot call any method');
      return false;
    }

    var array = args;
    // allow an array passed as a single arg.
    if (array.length === 1 && Array.isArray(array[0])) {
      array = array[0];
    }

    if (array.length !== 9) {
      throw new RangeError('Invalid number of values for array setter');
    }
    var changeDetected = false;
    model.direction.forEach(function (item, index) {
      if (item !== array[index]) {
        if (changeDetected) {
          return;
        }
        changeDetected = true;
      }
    });

    if (changeDetected) {
      for (var i = 0; i < 9; ++i) {
        model.direction[i] = array[i];
      }
      publicAPI.modified();
    }
    return true;
  };

  // this is the fast version, requires vec3 arguments
  publicAPI.indexToWorldVec3 = function (vin, vout) {
    _glMatrix.vec3.transformMat4(vout, vin, model.indexToWorld);
  };

  // slow version for generic arrays
  publicAPI.indexToWorld = function (ain, aout) {
    var vin = _glMatrix.vec3.fromValues(ain[0], ain[1], ain[2]);
    var vout = _glMatrix.vec3.create();
    _glMatrix.vec3.transformMat4(vout, vin, model.indexToWorld);
    _glMatrix.vec3.copy(aout, vout);
  };

  // this is the fast version, requires vec3 arguments
  publicAPI.worldToIndexVec3 = function (vin, vout) {
    _glMatrix.vec3.transformMat4(vout, vin, model.worldToIndex);
  };

  // slow version for generic arrays
  publicAPI.worldToIndex = function (ain, aout) {
    var vin = _glMatrix.vec3.fromValues(ain[0], ain[1], ain[2]);
    var vout = _glMatrix.vec3.create();
    _glMatrix.vec3.transformMat4(vout, vin, model.worldToIndex);
    _glMatrix.vec3.copy(aout, vout);
  };

  // Make sure the transform is correct
  publicAPI.onModified(publicAPI.computeTransforms);
  publicAPI.computeTransforms();
}

// ----------------------------------------------------------------------------
// Object factory
// ----------------------------------------------------------------------------

var DEFAULT_VALUES = {
  direction: null, // a mat3
  indexToWorld: null, // a mat4
  worldToIndex: null, // a mat4
  spacing: [1.0, 1.0, 1.0],
  origin: [0.0, 0.0, 0.0],
  extent: [0, -1, 0, -1, 0, -1],
  dataDescription: _Constants.StructuredType.EMPTY
};

// ----------------------------------------------------------------------------

function extend(publicAPI, model) {
  var initialValues = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : {};

  Object.assign(model, DEFAULT_VALUES, initialValues);

  // Inheritance
  _DataSet2.default.extend(publicAPI, model, initialValues);

  if (!model.direction) {
    model.direction = _glMatrix.mat3.create();
  } else if (Array.isArray(model.direction)) {
    var dvals = model.direction.slice(0);
    model.direction = _glMatrix.mat3.create();
    for (var i = 0; i < 9; ++i) {
      model.direction[i] = dvals[i];
    }
  }

  model.indexToWorld = _glMatrix.mat4.create();
  model.worldToIndex = _glMatrix.mat4.create();

  // Set/Get methods
  _macro2.default.get(publicAPI, model, ['direction', 'indexToWorld', 'worldToIndex']);
  _macro2.default.setGetArray(publicAPI, model, ['origin', 'spacing'], 3);
  _macro2.default.getArray(publicAPI, model, ['extent'], 6);

  // Object specific methods
  vtkImageData(publicAPI, model);
}

// ----------------------------------------------------------------------------

var newInstance = exports.newInstance = _macro2.default.newInstance(extend, 'vtkImageData');

// ----------------------------------------------------------------------------

exports.default = { newInstance: newInstance, extend: extend };

/***/ }),

/***/ 6:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});

var _slicedToArray = function () { function sliceIterator(arr, i) { var _arr = []; var _n = true; var _d = false; var _e = undefined; try { for (var _i = arr[Symbol.iterator](), _s; !(_n = (_s = _i.next()).done); _n = true) { _arr.push(_s.value); if (i && _arr.length === i) break; } } catch (err) { _d = true; _e = err; } finally { try { if (!_n && _i["return"]) _i["return"](); } finally { if (_d) throw _e; } } return _arr; } return function (arr, i) { if (Array.isArray(arr)) { return arr; } else if (Symbol.iterator in Object(arr)) { return sliceIterator(arr, i); } else { throw new TypeError("Invalid attempt to destructure non-iterable instance"); } }; }();

var _seedrandom = __webpack_require__(201);

var _seedrandom2 = _interopRequireDefault(_seedrandom);

var _macro = __webpack_require__(0);

var _macro2 = _interopRequireDefault(_macro);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var vtkErrorMacro = _macro2.default.vtkErrorMacro,
    vtkWarningMacro = _macro2.default.vtkWarningMacro;

// ----------------------------------------------------------------------------
/* eslint-disable camelcase                                                  */
/* eslint-disable no-cond-assign                                             */
/* eslint-disable no-bitwise                                                 */
/* eslint-disable no-multi-assign                                            */
// ----------------------------------------------------------------------------

var randomSeedValue = 0;
var VTK_MAX_ROTATIONS = 20;
var VTK_SMALL_NUMBER = 1.0e-12;

function notImplemented(method) {
  return function () {
    return vtkErrorMacro('vtkMath::' + method + ' - NOT IMPLEMENTED');
  };
}

function vtkSwapVectors3(v1, v2) {
  for (var i = 0; i < 3; i++) {
    var tmp = v1[i];
    v1[i] = v2[i];
    v2[i] = tmp;
  }
}

function createArray() {
  var size = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 3;

  var array = [];
  while (array.length < size) {
    array.push(0);
  }
  return array;
}

// ----------------------------------------------------------------------------
// Global methods
// ----------------------------------------------------------------------------

var Pi = function Pi() {
  return Math.PI;
};
var radiansFromDegrees = function radiansFromDegrees(deg) {
  return deg / 180 * Math.PI;
};
var degreesFromRadians = function degreesFromRadians(rad) {
  return rad * 180 / Math.PI;
};
var round = Math.round,
    floor = Math.floor,
    ceil = Math.ceil,
    min = Math.min,
    max = Math.max;


function arrayMin(arr) {
  var minValue = Infinity;
  for (var i = 0, len = arr.length; i < len; ++i) {
    if (arr[i] < minValue) {
      minValue = arr[i];
    }
  }

  return minValue;
}

function arrayMax(arr) {
  var maxValue = -Infinity;
  for (var i = 0, len = arr.length; i < len; ++i) {
    if (maxValue < arr[i]) {
      maxValue = arr[i];
    }
  }

  return maxValue;
}

var ceilLog2 = notImplemented('ceilLog2');
var factorial = notImplemented('factorial');

function nearestPowerOfTwo(xi) {
  var v = 1;
  while (v < xi) {
    v *= 2;
  }
  return v;
}

function isPowerOfTwo(x) {
  return x === nearestPowerOfTwo(x);
}

function binomial(m, n) {
  var r = 1;
  for (var i = 1; i <= n; ++i) {
    r *= (m - i + 1) / i;
  }
  return Math.floor(r);
}

function beginCombination(m, n) {
  if (m < n) {
    return 0;
  }

  var r = createArray(n);
  for (var i = 0; i < n; ++i) {
    r[i] = i;
  }
  return r;
}

function nextCombination(m, n, r) {
  var status = 0;
  for (var i = n - 1; i >= 0; --i) {
    if (r[i] < m - n + i) {
      var j = r[i] + 1;
      while (i < n) {
        r[i++] = j++;
      }
      status = 1;
      break;
    }
  }
  return status;
}

var randomSeed = function randomSeed(seed) {
  (0, _seedrandom2.default)('' + seed, { global: true });
  randomSeedValue = seed;
};

var getSeed = function getSeed() {
  return randomSeedValue;
};

function random() {
  var minValue = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 0;
  var maxValue = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 1;

  var delta = maxValue - minValue;
  return minValue + delta * Math.random();
}

var gaussian = notImplemented('gaussian');

// Vect3 operations
function add(a, b, out) {
  out[0] = a[0] + b[0];
  out[1] = a[1] + b[1];
  out[2] = a[2] + b[2];
}

function subtract(a, b, out) {
  out[0] = a[0] - b[0];
  out[1] = a[1] - b[1];
  out[2] = a[2] - b[2];
}

function multiplyScalar(vec, scalar) {
  vec[0] *= scalar;
  vec[1] *= scalar;
  vec[2] *= scalar;
}

function multiplyScalar2D(vec, scalar) {
  vec[0] *= scalar;
  vec[1] *= scalar;
}

function dot(x, y) {
  return x[0] * y[0] + x[1] * y[1] + x[2] * y[2];
}

function outer(x, y, out_3x3) {
  for (var i = 0; i < 3; i++) {
    for (var j = 0; j < 3; j++) {
      out_3x3[i][j] = x[i] * y[j];
    }
  }
}

function cross(x, y, out) {
  var Zx = x[1] * y[2] - x[2] * y[1];
  var Zy = x[2] * y[0] - x[0] * y[2];
  var Zz = x[0] * y[1] - x[1] * y[0];
  out[0] = Zx;
  out[1] = Zy;
  out[2] = Zz;
}

function norm(x) {
  var n = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 3;

  switch (n) {
    case 1:
      return Math.abs(x);
    case 2:
      return Math.sqrt(x[0] * x[0] + x[1] * x[1]);
    case 3:
      return Math.sqrt(x[0] * x[0] + x[1] * x[1] + x[2] * x[2]);
    default:
      {
        var sum = 0;
        for (var i = 0; i < n; i++) {
          sum += x[i] * x[i];
        }
        return Math.sqrt(sum);
      }
  }
}

function normalize(x) {
  var den = norm(x);
  if (den !== 0.0) {
    x[0] /= den;
    x[1] /= den;
    x[2] /= den;
  }
  return den;
}

function perpendiculars(x, y, z, theta) {
  var x2 = x[0] * x[0];
  var y2 = x[1] * x[1];
  var z2 = x[2] * x[2];
  var r = Math.sqrt(x2 + y2 + z2);

  var dx = void 0;
  var dy = void 0;
  var dz = void 0;

  // transpose the vector to avoid divide-by-zero error
  if (x2 > y2 && x2 > z2) {
    dx = 0;
    dy = 1;
    dz = 2;
  } else if (y2 > z2) {
    dx = 1;
    dy = 2;
    dz = 0;
  } else {
    dx = 2;
    dy = 0;
    dz = 1;
  }

  var a = x[dx] / r;
  var b = x[dy] / r;
  var c = x[dz] / r;
  var tmp = Math.sqrt(a * a + c * c);

  if (theta !== 0) {
    var sintheta = Math.sin(theta);
    var costheta = Math.cos(theta);

    if (y) {
      y[dx] = (c * costheta - a * b * sintheta) / tmp;
      y[dy] = sintheta * tmp;
      y[dz] = (-(a * costheta) - b * c * sintheta) / tmp;
    }

    if (z) {
      z[dx] = (-(c * sintheta) - a * b * costheta) / tmp;
      z[dy] = costheta * tmp;
      z[dz] = (a * sintheta - b * c * costheta) / tmp;
    }
  } else {
    if (y) {
      y[dx] = c / tmp;
      y[dy] = 0;
      y[dz] = -a / tmp;
    }

    if (z) {
      z[dx] = -a * b / tmp;
      z[dy] = tmp;
      z[dz] = -b * c / tmp;
    }
  }
}

function projectVector(a, b, projection) {
  var bSquared = dot(b, b);

  if (bSquared === 0) {
    projection[0] = 0;
    projection[1] = 0;
    projection[2] = 0;
    return false;
  }

  var scale = dot(a, b) / bSquared;

  for (var i = 0; i < 3; i++) {
    projection[i] = b[i];
  }
  multiplyScalar(projection, scale);

  return true;
}

function dot2D(x, y) {
  return x[0] * y[0] + x[1] * y[1];
}

function projectVector2D(a, b, projection) {
  var bSquared = dot2D(b, b);

  if (bSquared === 0) {
    projection[0] = 0;
    projection[1] = 0;
    return false;
  }

  var scale = dot2D(a, b) / bSquared;

  for (var i = 0; i < 2; i++) {
    projection[i] = b[i];
  }
  multiplyScalar2D(projection, scale);

  return true;
}

function distance2BetweenPoints(x, y) {
  return (x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]) + (x[2] - y[2]) * (x[2] - y[2]);
}

function angleBetweenVectors(v1, v2) {
  var crossVect = [0, 0, 0];
  cross(v1, v2, crossVect);
  return Math.atan2(norm(crossVect), dot(v1, v2));
}

function gaussianAmplitude(mean, variance, position) {
  var distanceFromMean = Math.abs(mean - position);
  return 1 / Math.sqrt(2 * Math.PI * variance) * Math.exp(-Math.pow(distanceFromMean, 2) / (2 * variance));
}

function gaussianWeight(mean, variance, position) {
  var distanceFromMean = Math.abs(mean - position);
  return Math.exp(-Math.pow(distanceFromMean, 2) / (2 * variance));
}

function outer2D(x, y, out_2x2) {
  for (var i = 0; i < 2; i++) {
    for (var j = 0; j < 2; j++) {
      out_2x2[i][j] = x[i] * y[j];
    }
  }
}

function norm2D(x2D) {
  return Math.sqrt(x2D[0] * x2D[0] + x2D[1] * x2D[1]);
}

function normalize2D(x) {
  var den = norm2D(x);
  if (den !== 0.0) {
    x[0] /= den;
    x[1] /= den;
  }
  return den;
}

function determinant2x2() {
  for (var _len = arguments.length, args = Array(_len), _key = 0; _key < _len; _key++) {
    args[_key] = arguments[_key];
  }

  if (args.length === 2) {
    return args[0][0] * args[1][1] - args[1][0] * args[0][1];
  }
  if (args.length === 4) {
    return args[0] * args[3] - args[1] * args[2];
  }
  return Number.NaN;
}

function LUFactor3x3(mat_3x3, index_3) {
  var maxI = void 0;
  var tmp = void 0;
  var largest = void 0;
  var scale = [0, 0, 0];

  // Loop over rows to get implicit scaling information
  for (var i = 0; i < 3; i++) {
    largest = Math.abs(mat_3x3[i][0]);
    if ((tmp = Math.abs(mat_3x3[i][1])) > largest) {
      largest = tmp;
    }
    if ((tmp = Math.abs(mat_3x3[i][2])) > largest) {
      largest = tmp;
    }
    scale[i] = 1 / largest;
  }

  // Loop over all columns using Crout's method

  // first column
  largest = scale[0] * Math.abs(mat_3x3[0][0]);
  maxI = 0;
  if ((tmp = scale[1] * Math.abs(mat_3x3[1][0])) >= largest) {
    largest = tmp;
    maxI = 1;
  }
  if ((tmp = scale[2] * Math.abs(mat_3x3[2][0])) >= largest) {
    maxI = 2;
  }
  if (maxI !== 0) {
    vtkSwapVectors3(mat_3x3[maxI], mat_3x3[0]);
    scale[maxI] = scale[0];
  }
  index_3[0] = maxI;

  mat_3x3[1][0] /= mat_3x3[0][0];
  mat_3x3[2][0] /= mat_3x3[0][0];

  // second column
  mat_3x3[1][1] -= mat_3x3[1][0] * mat_3x3[0][1];
  mat_3x3[2][1] -= mat_3x3[2][0] * mat_3x3[0][1];
  largest = scale[1] * Math.abs(mat_3x3[1][1]);
  maxI = 1;
  if ((tmp = scale[2] * Math.abs(mat_3x3[2][1])) >= largest) {
    maxI = 2;
    vtkSwapVectors3(mat_3x3[2], mat_3x3[1]);
    scale[2] = scale[1];
  }
  index_3[1] = maxI;
  mat_3x3[2][1] /= mat_3x3[1][1];

  // third column
  mat_3x3[1][2] -= mat_3x3[1][0] * mat_3x3[0][2];
  mat_3x3[2][2] -= mat_3x3[2][0] * mat_3x3[0][2] + mat_3x3[2][1] * mat_3x3[1][2];
  index_3[2] = 2;
}

function LUSolve3x3(mat_3x3, index_3, x_3) {
  // forward substitution
  var sum = x_3[index_3[0]];
  x_3[index_3[0]] = x_3[0];
  x_3[0] = sum;

  sum = x_3[index_3[1]];
  x_3[index_3[1]] = x_3[1];
  x_3[1] = sum - mat_3x3[1][0] * x_3[0];

  sum = x_3[index_3[2]];
  x_3[index_3[2]] = x_3[2];
  x_3[2] = sum - mat_3x3[2][0] * x_3[0] - mat_3x3[2][1] * x_3[1];

  // back substitution
  x_3[2] /= mat_3x3[2][2];
  x_3[1] = (x_3[1] - mat_3x3[1][2] * x_3[2]) / mat_3x3[1][1];
  x_3[0] = (x_3[0] - mat_3x3[0][1] * x_3[1] - mat_3x3[0][2] * x_3[2]) / mat_3x3[0][0];
}

function linearSolve3x3(mat_3x3, x_3, y_3) {
  var a1 = mat_3x3[0][0];
  var b1 = mat_3x3[0][1];
  var c1 = mat_3x3[0][2];
  var a2 = mat_3x3[1][0];
  var b2 = mat_3x3[1][1];
  var c2 = mat_3x3[1][2];
  var a3 = mat_3x3[2][0];
  var b3 = mat_3x3[2][1];
  var c3 = mat_3x3[2][2];

  // Compute the adjoint
  var d1 = +determinant2x2(b2, b3, c2, c3);
  var d2 = -determinant2x2(a2, a3, c2, c3);
  var d3 = +determinant2x2(a2, a3, b2, b3);

  var e1 = -determinant2x2(b1, b3, c1, c3);
  var e2 = +determinant2x2(a1, a3, c1, c3);
  var e3 = -determinant2x2(a1, a3, b1, b3);

  var f1 = +determinant2x2(b1, b2, c1, c2);
  var f2 = -determinant2x2(a1, a2, c1, c2);
  var f3 = +determinant2x2(a1, a2, b1, b2);

  // Compute the determinant
  var det = a1 * d1 + b1 * d2 + c1 * d3;

  // Multiply by the adjoint
  var v1 = d1 * x_3[0] + e1 * x_3[1] + f1 * x_3[2];
  var v2 = d2 * x_3[0] + e2 * x_3[1] + f2 * x_3[2];
  var v3 = d3 * x_3[0] + e3 * x_3[1] + f3 * x_3[2];

  // Divide by the determinant
  y_3[0] = v1 / det;
  y_3[1] = v2 / det;
  y_3[2] = v3 / det;
}

function multiply3x3_vect3(mat_3x3, in_3, out_3) {
  var x = mat_3x3[0][0] * in_3[0] + mat_3x3[0][1] * in_3[1] + mat_3x3[0][2] * in_3[2];
  var y = mat_3x3[1][0] * in_3[0] + mat_3x3[1][1] * in_3[1] + mat_3x3[1][2] * in_3[2];
  var z = mat_3x3[2][0] * in_3[0] + mat_3x3[2][1] * in_3[1] + mat_3x3[2][2] * in_3[2];

  out_3[0] = x;
  out_3[1] = y;
  out_3[2] = z;
}

function multiply3x3_mat3(a_3x3, b_3x3, out_3x3) {
  var tmp = [[0, 0, 0], [0, 0, 0], [0, 0, 0]];

  for (var i = 0; i < 3; i++) {
    tmp[0][i] = a_3x3[0][0] * b_3x3[0][i] + a_3x3[0][1] * b_3x3[1][i] + a_3x3[0][2] * b_3x3[2][i];
    tmp[1][i] = a_3x3[1][0] * b_3x3[0][i] + a_3x3[1][1] * b_3x3[1][i] + a_3x3[1][2] * b_3x3[2][i];
    tmp[2][i] = a_3x3[2][0] * b_3x3[0][i] + a_3x3[2][1] * b_3x3[1][i] + a_3x3[2][2] * b_3x3[2][i];
  }

  for (var j = 0; j < 3; j++) {
    out_3x3[j][0] = tmp[j][0];
    out_3x3[j][1] = tmp[j][1];
    out_3x3[j][2] = tmp[j][2];
  }
}

function multiplyMatrix(a, b, rowA, colA, rowB, colB, out_rowXcol) {
  // we need colA == rowB
  if (colA !== rowB) {
    vtkErrorMacro('Number of columns of A must match number of rows of B.');
  }

  // output matrix is rowA*colB
  // output row
  for (var i = 0; i < rowA; i++) {
    // output col
    for (var j = 0; j < colB; j++) {
      out_rowXcol[i][j] = 0;
      // sum for this point
      for (var k = 0; k < colA; k++) {
        out_rowXcol[i][j] += a[i][k] * b[k][j];
      }
    }
  }
}

function transpose3x3(in_3x3, outT_3x3) {
  var tmp = void 0;
  tmp = in_3x3[1][0];
  outT_3x3[1][0] = in_3x3[0][1];
  outT_3x3[0][1] = tmp;
  tmp = in_3x3[2][0];
  outT_3x3[2][0] = in_3x3[0][2];
  outT_3x3[0][2] = tmp;
  tmp = in_3x3[2][1];
  outT_3x3[2][1] = in_3x3[1][2];
  outT_3x3[1][2] = tmp;

  outT_3x3[0][0] = in_3x3[0][0];
  outT_3x3[1][1] = in_3x3[1][1];
  outT_3x3[2][2] = in_3x3[2][2];
}

function invert3x3(in_3x3, outI_3x3) {
  var a1 = in_3x3[0][0];
  var b1 = in_3x3[0][1];
  var c1 = in_3x3[0][2];
  var a2 = in_3x3[1][0];
  var b2 = in_3x3[1][1];
  var c2 = in_3x3[1][2];
  var a3 = in_3x3[2][0];
  var b3 = in_3x3[2][1];
  var c3 = in_3x3[2][2];

  // Compute the adjoint
  var d1 = +determinant2x2(b2, b3, c2, c3);
  var d2 = -determinant2x2(a2, a3, c2, c3);
  var d3 = +determinant2x2(a2, a3, b2, b3);

  var e1 = -determinant2x2(b1, b3, c1, c3);
  var e2 = +determinant2x2(a1, a3, c1, c3);
  var e3 = -determinant2x2(a1, a3, b1, b3);

  var f1 = +determinant2x2(b1, b2, c1, c2);
  var f2 = -determinant2x2(a1, a2, c1, c2);
  var f3 = +determinant2x2(a1, a2, b1, b2);

  // Divide by the determinant
  var det = a1 * d1 + b1 * d2 + c1 * d3;

  outI_3x3[0][0] = d1 / det;
  outI_3x3[1][0] = d2 / det;
  outI_3x3[2][0] = d3 / det;

  outI_3x3[0][1] = e1 / det;
  outI_3x3[1][1] = e2 / det;
  outI_3x3[2][1] = e3 / det;

  outI_3x3[0][2] = f1 / det;
  outI_3x3[1][2] = f2 / det;
  outI_3x3[2][2] = f3 / det;
}

function identity3x3(mat_3x3) {
  for (var i = 0; i < 3; i++) {
    mat_3x3[i][0] = mat_3x3[i][1] = mat_3x3[i][2] = 0;
    mat_3x3[i][i] = 1;
  }
}

function determinant3x3(mat_3x3) {
  return mat_3x3[0][0] * mat_3x3[1][1] * mat_3x3[2][2] + mat_3x3[1][0] * mat_3x3[2][1] * mat_3x3[0][2] + mat_3x3[2][0] * mat_3x3[0][1] * mat_3x3[1][2] - mat_3x3[0][0] * mat_3x3[2][1] * mat_3x3[1][2] - mat_3x3[1][0] * mat_3x3[0][1] * mat_3x3[2][2] - mat_3x3[2][0] * mat_3x3[1][1] * mat_3x3[0][2];
}

function quaternionToMatrix3x3(quat_4, mat_3x3) {
  var ww = quat_4[0] * quat_4[0];
  var wx = quat_4[0] * quat_4[1];
  var wy = quat_4[0] * quat_4[2];
  var wz = quat_4[0] * quat_4[3];

  var xx = quat_4[1] * quat_4[1];
  var yy = quat_4[2] * quat_4[2];
  var zz = quat_4[3] * quat_4[3];

  var xy = quat_4[1] * quat_4[2];
  var xz = quat_4[1] * quat_4[3];
  var yz = quat_4[2] * quat_4[3];

  var rr = xx + yy + zz;
  // normalization factor, just in case quaternion was not normalized
  var f = 1 / (ww + rr);
  var s = (ww - rr) * f;
  f *= 2;

  mat_3x3[0][0] = xx * f + s;
  mat_3x3[1][0] = (xy + wz) * f;
  mat_3x3[2][0] = (xz - wy) * f;

  mat_3x3[0][1] = (xy - wz) * f;
  mat_3x3[1][1] = yy * f + s;
  mat_3x3[2][1] = (yz + wx) * f;

  mat_3x3[0][2] = (xz + wy) * f;
  mat_3x3[1][2] = (yz - wx) * f;
  mat_3x3[2][2] = zz * f + s;
}

function areMatricesEqual(matA, matB) {
  if (!matA.length === matB.length) {
    return false;
  }

  function isEqual(element, index) {
    return element === matB[index];
  }
  return matA.every(isEqual);
}

function jacobiN(a, n, w, v) {
  var i = void 0;
  var j = void 0;
  var k = void 0;
  var iq = void 0;
  var ip = void 0;
  var numPos = void 0;
  var tresh = void 0;
  var theta = void 0;
  var t = void 0;
  var tau = void 0;
  var sm = void 0;
  var s = void 0;
  var h = void 0;
  var g = void 0;
  var c = void 0;
  var tmp = void 0;
  var b = createArray(n);
  var z = createArray(n);

  var vtkROTATE = function vtkROTATE(aa, ii, jj, kk, ll) {
    g = aa[ii][jj];
    h = aa[kk][ll];
    aa[ii][jj] = g - s * (h + g * tau);
    aa[kk][ll] = h + s * (g - h * tau);
  };

  // initialize
  for (ip = 0; ip < n; ip++) {
    for (iq = 0; iq < n; iq++) {
      v[ip][iq] = 0.0;
    }
    v[ip][ip] = 1.0;
  }
  for (ip = 0; ip < n; ip++) {
    b[ip] = w[ip] = a[ip][ip];
    z[ip] = 0.0;
  }

  // begin rotation sequence
  for (i = 0; i < VTK_MAX_ROTATIONS; i++) {
    sm = 0.0;
    for (ip = 0; ip < n - 1; ip++) {
      for (iq = ip + 1; iq < n; iq++) {
        sm += Math.abs(a[ip][iq]);
      }
    }
    if (sm === 0.0) {
      break;
    }

    // first 3 sweeps
    if (i < 3) {
      tresh = 0.2 * sm / (n * n);
    } else {
      tresh = 0.0;
    }

    for (ip = 0; ip < n - 1; ip++) {
      for (iq = ip + 1; iq < n; iq++) {
        g = 100.0 * Math.abs(a[ip][iq]);

        // after 4 sweeps
        if (i > 3 && Math.abs(w[ip]) + g === Math.abs(w[ip]) && Math.abs(w[iq]) + g === Math.abs(w[iq])) {
          a[ip][iq] = 0.0;
        } else if (Math.abs(a[ip][iq]) > tresh) {
          h = w[iq] - w[ip];
          if (Math.abs(h) + g === Math.abs(h)) {
            t = a[ip][iq] / h;
          } else {
            theta = 0.5 * h / a[ip][iq];
            t = 1.0 / (Math.abs(theta) + Math.sqrt(1.0 + theta * theta));
            if (theta < 0.0) {
              t = -t;
            }
          }
          c = 1.0 / Math.sqrt(1 + t * t);
          s = t * c;
          tau = s / (1.0 + c);
          h = t * a[ip][iq];
          z[ip] -= h;
          z[iq] += h;
          w[ip] -= h;
          w[iq] += h;
          a[ip][iq] = 0.0;

          // ip already shifted left by 1 unit
          for (j = 0; j <= ip - 1; j++) {
            vtkROTATE(a, j, ip, j, iq);
          }
          // ip and iq already shifted left by 1 unit
          for (j = ip + 1; j <= iq - 1; j++) {
            vtkROTATE(a, ip, j, j, iq);
          }
          // iq already shifted left by 1 unit
          for (j = iq + 1; j < n; j++) {
            vtkROTATE(a, ip, j, iq, j);
          }
          for (j = 0; j < n; j++) {
            vtkROTATE(v, j, ip, j, iq);
          }
        }
      }
    }

    for (ip = 0; ip < n; ip++) {
      b[ip] += z[ip];
      w[ip] = b[ip];
      z[ip] = 0.0;
    }
  }

  // this is NEVER called
  if (i >= VTK_MAX_ROTATIONS) {
    vtkWarningMacro('vtkMath::Jacobi: Error extracting eigenfunctions');
    return 0;
  }

  // sort eigenfunctions: these changes do not affect accuracy
  for (j = 0; j < n - 1; j++) {
    // boundary incorrect
    k = j;
    tmp = w[k];
    for (i = j + 1; i < n; i++) {
      // boundary incorrect, shifted already
      if (w[i] >= tmp) {
        // why exchange if same?
        k = i;
        tmp = w[k];
      }
    }
    if (k !== j) {
      w[k] = w[j];
      w[j] = tmp;
      for (i = 0; i < n; i++) {
        tmp = v[i][j];
        v[i][j] = v[i][k];
        v[i][k] = tmp;
      }
    }
  }
  // ensure eigenvector consistency (i.e., Jacobi can compute vectors that
  // are negative of one another (.707,.707,0) and (-.707,-.707,0). This can
  // reek havoc in hyperstreamline/other stuff. We will select the most
  // positive eigenvector.
  var ceil_half_n = (n >> 1) + (n & 1);
  for (j = 0; j < n; j++) {
    for (numPos = 0, i = 0; i < n; i++) {
      if (v[i][j] >= 0.0) {
        numPos++;
      }
    }
    //    if ( numPos < ceil(double(n)/double(2.0)) )
    if (numPos < ceil_half_n) {
      for (i = 0; i < n; i++) {
        v[i][j] *= -1.0;
      }
    }
  }
  return 1;
}

function matrix3x3ToQuaternion(mat_3x3, quat_4) {
  var tmp = [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]];

  // on-diagonal elements
  tmp[0][0] = mat_3x3[0][0] + mat_3x3[1][1] + mat_3x3[2][2];
  tmp[1][1] = mat_3x3[0][0] - mat_3x3[1][1] - mat_3x3[2][2];
  tmp[2][2] = -mat_3x3[0][0] + mat_3x3[1][1] - mat_3x3[2][2];
  tmp[3][3] = -mat_3x3[0][0] - mat_3x3[1][1] + mat_3x3[2][2];

  // off-diagonal elements
  tmp[0][1] = tmp[1][0] = mat_3x3[2][1] - mat_3x3[1][2];
  tmp[0][2] = tmp[2][0] = mat_3x3[0][2] - mat_3x3[2][0];
  tmp[0][3] = tmp[3][0] = mat_3x3[1][0] - mat_3x3[0][1];

  tmp[1][2] = tmp[2][1] = mat_3x3[1][0] + mat_3x3[0][1];
  tmp[1][3] = tmp[3][1] = mat_3x3[0][2] + mat_3x3[2][0];
  tmp[2][3] = tmp[3][2] = mat_3x3[2][1] + mat_3x3[1][2];

  var eigenvectors = [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]];
  var eigenvalues = [0, 0, 0, 0];

  // convert into format that JacobiN can use,
  // then use Jacobi to find eigenvalues and eigenvectors
  var NTemp = [0, 0, 0, 0];
  var eigenvectorsTemp = [0, 0, 0, 0];
  for (var i = 0; i < 4; i++) {
    NTemp[i] = tmp[i];
    eigenvectorsTemp[i] = eigenvectors[i];
  }
  jacobiN(NTemp, 4, eigenvalues, eigenvectorsTemp);

  // the first eigenvector is the one we want
  quat_4[0] = eigenvectors[0][0];
  quat_4[1] = eigenvectors[1][0];
  quat_4[2] = eigenvectors[2][0];
  quat_4[3] = eigenvectors[3][0];
}

function multiplyQuaternion(quat_1, quat_2, quat_out) {
  var ww = quat_1[0] * quat_2[0];
  var wx = quat_1[0] * quat_2[1];
  var wy = quat_1[0] * quat_2[2];
  var wz = quat_1[0] * quat_2[3];

  var xw = quat_1[1] * quat_2[0];
  var xx = quat_1[1] * quat_2[1];
  var xy = quat_1[1] * quat_2[2];
  var xz = quat_1[1] * quat_2[3];

  var yw = quat_1[2] * quat_2[0];
  var yx = quat_1[2] * quat_2[1];
  var yy = quat_1[2] * quat_2[2];
  var yz = quat_1[2] * quat_2[3];

  var zw = quat_1[3] * quat_2[0];
  var zx = quat_1[3] * quat_2[1];
  var zy = quat_1[3] * quat_2[2];
  var zz = quat_1[3] * quat_2[3];

  quat_out[0] = ww - xx - yy - zz;
  quat_out[1] = wx + xw + yz - zy;
  quat_out[2] = wy - xz + yw + zx;
  quat_out[3] = wz + xy - yx + zw;
}

function orthogonalize3x3(a_3x3, out_3x3) {
  // copy the matrix
  for (var i = 0; i < 3; i++) {
    out_3x3[0][i] = a_3x3[0][i];
    out_3x3[1][i] = a_3x3[1][i];
    out_3x3[2][i] = a_3x3[2][i];
  }

  // Pivot the matrix to improve accuracy
  var scale = createArray(3);
  var index = createArray(3);
  var largest = void 0;

  // Loop over rows to get implicit scaling information
  for (var _i = 0; _i < 3; _i++) {
    var _x5 = Math.abs(out_3x3[_i][0]);
    var _x6 = Math.abs(out_3x3[_i][1]);
    var _x7 = Math.abs(out_3x3[_i][2]);
    largest = _x6 > _x5 ? _x6 : _x5;
    largest = _x7 > largest ? _x7 : largest;
    scale[_i] = 1;
    if (largest !== 0) {
      scale[_i] /= largest;
    }
  }

  // first column
  var x1 = Math.abs(out_3x3[0][0]) * scale[0];
  var x2 = Math.abs(out_3x3[1][0]) * scale[1];
  var x3 = Math.abs(out_3x3[2][0]) * scale[2];
  index[0] = 0;
  largest = x1;
  if (x2 >= largest) {
    largest = x2;
    index[0] = 1;
  }
  if (x3 >= largest) {
    index[0] = 2;
  }
  if (index[0] !== 0) {
    vtkSwapVectors3(out_3x3[index[0]], out_3x3[0]);
    scale[index[0]] = scale[0];
  }

  // second column
  var y2 = Math.abs(out_3x3[1][1]) * scale[1];
  var y3 = Math.abs(out_3x3[2][1]) * scale[2];
  index[1] = 1;
  largest = y2;
  if (y3 >= largest) {
    index[1] = 2;
    vtkSwapVectors3(out_3x3[2], out_3x3[1]);
  }

  // third column
  index[2] = 2;

  // A quaternion can only describe a pure rotation, not
  // a rotation with a flip, therefore the flip must be
  // removed before the matrix is converted to a quaternion.
  var flip = 0;
  if (determinant3x3(out_3x3) < 0) {
    flip = 1;
    for (var _i2 = 0; _i2 < 3; _i2++) {
      out_3x3[0][_i2] = -out_3x3[0][_i2];
      out_3x3[1][_i2] = -out_3x3[1][_i2];
      out_3x3[2][_i2] = -out_3x3[2][_i2];
    }
  }

  // Do orthogonalization using a quaternion intermediate
  // (this, essentially, does the orthogonalization via
  // diagonalization of an appropriately constructed symmetric
  // 4x4 matrix rather than by doing SVD of the 3x3 matrix)
  var quat = createArray(4);
  matrix3x3ToQuaternion(out_3x3, quat);
  quaternionToMatrix3x3(quat, out_3x3);

  // Put the flip back into the orthogonalized matrix.
  if (flip) {
    for (var _i3 = 0; _i3 < 3; _i3++) {
      out_3x3[0][_i3] = -out_3x3[0][_i3];
      out_3x3[1][_i3] = -out_3x3[1][_i3];
      out_3x3[2][_i3] = -out_3x3[2][_i3];
    }
  }

  // Undo the pivoting
  if (index[1] !== 1) {
    vtkSwapVectors3(out_3x3[index[1]], out_3x3[1]);
  }
  if (index[0] !== 0) {
    vtkSwapVectors3(out_3x3[index[0]], out_3x3[0]);
  }
}

function diagonalize3x3(a_3x3, w_3, v_3x3) {
  var i = void 0;
  var j = void 0;
  var k = void 0;
  var maxI = void 0;
  var tmp = void 0;
  var maxVal = void 0;

  // do the matrix[3][3] to **matrix conversion for Jacobi
  var C = [createArray(3), createArray(3), createArray(3)];
  var ATemp = createArray(3);
  var VTemp = createArray(3);
  for (i = 0; i < 3; i++) {
    C[i][0] = a_3x3[i][0];
    C[i][1] = a_3x3[i][1];
    C[i][2] = a_3x3[i][2];
    ATemp[i] = C[i];
    VTemp[i] = v_3x3[i];
  }

  // diagonalize using Jacobi
  jacobiN(ATemp, 3, w_3, VTemp);

  // if all the eigenvalues are the same, return identity matrix
  if (w_3[0] === w_3[1] && w_3[0] === w_3[2]) {
    identity3x3(v_3x3);
    return;
  }

  // transpose temporarily, it makes it easier to sort the eigenvectors
  transpose3x3(v_3x3, v_3x3);

  // if two eigenvalues are the same, re-orthogonalize to optimally line
  // up the eigenvectors with the x, y, and z axes
  for (i = 0; i < 3; i++) {
    // two eigenvalues are the same
    if (w_3[(i + 1) % 3] === w_3[(i + 2) % 3]) {
      // find maximum element of the independent eigenvector
      maxVal = Math.abs(v_3x3[i][0]);
      maxI = 0;
      for (j = 1; j < 3; j++) {
        if (maxVal < (tmp = Math.abs(v_3x3[i][j]))) {
          maxVal = tmp;
          maxI = j;
        }
      }
      // swap the eigenvector into its proper position
      if (maxI !== i) {
        tmp = w_3[maxI];
        w_3[maxI] = w_3[i];
        w_3[i] = tmp;
        vtkSwapVectors3(v_3x3[i], v_3x3[maxI]);
      }
      // maximum element of eigenvector should be positive
      if (v_3x3[maxI][maxI] < 0) {
        v_3x3[maxI][0] = -v_3x3[maxI][0];
        v_3x3[maxI][1] = -v_3x3[maxI][1];
        v_3x3[maxI][2] = -v_3x3[maxI][2];
      }

      // re-orthogonalize the other two eigenvectors
      j = (maxI + 1) % 3;
      k = (maxI + 2) % 3;

      v_3x3[j][0] = 0.0;
      v_3x3[j][1] = 0.0;
      v_3x3[j][2] = 0.0;
      v_3x3[j][j] = 1.0;
      cross(v_3x3[maxI], v_3x3[j], v_3x3[k]);
      normalize(v_3x3[k]);
      cross(v_3x3[k], v_3x3[maxI], v_3x3[j]);

      // transpose vectors back to columns
      transpose3x3(v_3x3, v_3x3);
      return;
    }
  }

  // the three eigenvalues are different, just sort the eigenvectors
  // to align them with the x, y, and z axes

  // find the vector with the largest x element, make that vector
  // the first vector
  maxVal = Math.abs(v_3x3[0][0]);
  maxI = 0;
  for (i = 1; i < 3; i++) {
    if (maxVal < (tmp = Math.abs(v_3x3[i][0]))) {
      maxVal = tmp;
      maxI = i;
    }
  }
  // swap eigenvalue and eigenvector
  if (maxI !== 0) {
    tmp = w_3[maxI];
    w_3[maxI] = w_3[0];
    w_3[0] = tmp;
    vtkSwapVectors3(v_3x3[maxI], v_3x3[0]);
  }
  // do the same for the y element
  if (Math.abs(v_3x3[1][1]) < Math.abs(v_3x3[2][1])) {
    tmp = w_3[2];
    w_3[2] = w_3[1];
    w_3[1] = tmp;
    vtkSwapVectors3(v_3x3[2], v_3x3[1]);
  }

  // ensure that the sign of the eigenvectors is correct
  for (i = 0; i < 2; i++) {
    if (v_3x3[i][i] < 0) {
      v_3x3[i][0] = -v_3x3[i][0];
      v_3x3[i][1] = -v_3x3[i][1];
      v_3x3[i][2] = -v_3x3[i][2];
    }
  }
  // set sign of final eigenvector to ensure that determinant is positive
  if (determinant3x3(v_3x3) < 0) {
    v_3x3[2][0] = -v_3x3[2][0];
    v_3x3[2][1] = -v_3x3[2][1];
    v_3x3[2][2] = -v_3x3[2][2];
  }

  // transpose the eigenvectors back again
  transpose3x3(v_3x3, v_3x3);
}

function singularValueDecomposition3x3(a_3x3, u_3x3, w_3, vT_3x3) {
  var i = void 0;
  var B = [createArray(3), createArray(3), createArray(3)];

  // copy so that A can be used for U or VT without risk
  for (i = 0; i < 3; i++) {
    B[0][i] = a_3x3[0][i];
    B[1][i] = a_3x3[1][i];
    B[2][i] = a_3x3[2][i];
  }

  // temporarily flip if determinant is negative
  var d = determinant3x3(B);
  if (d < 0) {
    for (i = 0; i < 3; i++) {
      B[0][i] = -B[0][i];
      B[1][i] = -B[1][i];
      B[2][i] = -B[2][i];
    }
  }

  // orthogonalize, diagonalize, etc.
  orthogonalize3x3(B, u_3x3);
  transpose3x3(B, B);
  multiply3x3_mat3(B, u_3x3, vT_3x3);
  diagonalize3x3(vT_3x3, w_3, vT_3x3);
  multiply3x3_mat3(u_3x3, vT_3x3, u_3x3);
  transpose3x3(vT_3x3, vT_3x3);

  // re-create the flip
  if (d < 0) {
    w_3[0] = -w_3[0];
    w_3[1] = -w_3[1];
    w_3[2] = -w_3[2];
  }
}

function luFactorLinearSystem(A, index, size) {
  var i = void 0;
  var j = void 0;
  var k = void 0;
  var largest = void 0;
  var maxI = 0;
  var sum = void 0;
  var temp1 = void 0;
  var temp2 = void 0;
  var scale = createArray(size);

  //
  // Loop over rows to get implicit scaling information
  //
  for (i = 0; i < size; i++) {
    for (largest = 0.0, j = 0; j < size; j++) {
      if ((temp2 = Math.abs(A[i][j])) > largest) {
        largest = temp2;
      }
    }

    if (largest === 0.0) {
      vtkWarningMacro('Unable to factor linear system');
      return 0;
    }
    scale[i] = 1.0 / largest;
  }
  //
  // Loop over all columns using Crout's method
  //
  for (j = 0; j < size; j++) {
    for (i = 0; i < j; i++) {
      sum = A[i][j];
      for (k = 0; k < i; k++) {
        sum -= A[i][k] * A[k][j];
      }
      A[i][j] = sum;
    }
    //
    // Begin search for largest pivot element
    //
    for (largest = 0.0, i = j; i < size; i++) {
      sum = A[i][j];
      for (k = 0; k < j; k++) {
        sum -= A[i][k] * A[k][j];
      }
      A[i][j] = sum;

      if ((temp1 = scale[i] * Math.abs(sum)) >= largest) {
        largest = temp1;
        maxI = i;
      }
    }
    //
    // Check for row interchange
    //
    if (j !== maxI) {
      for (k = 0; k < size; k++) {
        temp1 = A[maxI][k];
        A[maxI][k] = A[j][k];
        A[j][k] = temp1;
      }
      scale[maxI] = scale[j];
    }
    //
    // Divide by pivot element and perform elimination
    //
    index[j] = maxI;

    if (Math.abs(A[j][j]) <= VTK_SMALL_NUMBER) {
      vtkWarningMacro('Unable to factor linear system');
      return 0;
    }

    if (j !== size - 1) {
      temp1 = 1.0 / A[j][j];
      for (i = j + 1; i < size; i++) {
        A[i][j] *= temp1;
      }
    }
  }
  return 1;
}

function luSolveLinearSystem(A, index, x, size) {
  var i = void 0;
  var j = void 0;
  var ii = void 0;
  var idx = void 0;
  var sum = void 0;
  //
  // Proceed with forward and backsubstitution for L and U
  // matrices.  First, forward substitution.
  //
  for (ii = -1, i = 0; i < size; i++) {
    idx = index[i];
    sum = x[idx];
    x[idx] = x[i];

    if (ii >= 0) {
      for (j = ii; j <= i - 1; j++) {
        sum -= A[i][j] * x[j];
      }
    } else if (sum !== 0.0) {
      ii = i;
    }

    x[i] = sum;
  }
  //
  // Now, back substitution
  //
  for (i = size - 1; i >= 0; i--) {
    sum = x[i];
    for (j = i + 1; j < size; j++) {
      sum -= A[i][j] * x[j];
    }
    x[i] = sum / A[i][i];
  }
}

function solveLinearSystem(A, x, size) {
  // if we solving something simple, just solve it
  if (size === 2) {
    var y = createArray(2);
    var det = determinant2x2(A[0][0], A[0][1], A[1][0], A[1][1]);

    if (det === 0.0) {
      // Unable to solve linear system
      return 0;
    }

    y[0] = (A[1][1] * x[0] - A[0][1] * x[1]) / det;
    y[1] = (-(A[1][0] * x[0]) + A[0][0] * x[1]) / det;

    x[0] = y[0];
    x[1] = y[1];
    return 1;
  } else if (size === 1) {
    if (A[0][0] === 0.0) {
      // Unable to solve linear system
      return 0;
    }

    x[0] /= A[0][0];
    return 1;
  }

  //
  // System of equations is not trivial, use Crout's method
  //

  // Check on allocation of working vectors
  var index = createArray(size);

  // Factor and solve matrix
  if (luFactorLinearSystem(A, index, size) === 0) {
    return 0;
  }
  luSolveLinearSystem(A, index, x, size);

  return 1;
}

function invertMatrix(A, AI, size) {
  var index = arguments.length > 3 && arguments[3] !== undefined ? arguments[3] : null;
  var column = arguments.length > 4 && arguments[4] !== undefined ? arguments[4] : null;

  var tmp1Size = index || createArray(size);
  var tmp2Size = column || createArray(size);

  // Factor matrix; then begin solving for inverse one column at a time.
  // Note: tmp1Size returned value is used later, tmp2Size is just working
  // memory whose values are not used in LUSolveLinearSystem
  if (luFactorLinearSystem(A, tmp1Size, size, tmp2Size) === 0) {
    return 0;
  }

  for (var j = 0; j < size; j++) {
    for (var i = 0; i < size; i++) {
      tmp2Size[i] = 0.0;
    }
    tmp2Size[j] = 1.0;

    luSolveLinearSystem(A, tmp1Size, tmp2Size, size);

    for (var _i4 = 0; _i4 < size; _i4++) {
      AI[_i4][j] = tmp2Size[_i4];
    }
  }

  return 1;
}

function estimateMatrixCondition(A, size) {
  var minValue = +Number.MAX_VALUE;
  var maxValue = -Number.MAX_VALUE;

  // find the maximum value
  for (var i = 0; i < size; i++) {
    for (var j = i; j < size; j++) {
      if (Math.abs(A[i][j]) > max) {
        maxValue = Math.abs(A[i][j]);
      }
    }
  }

  // find the minimum diagonal value
  for (var _i5 = 0; _i5 < size; _i5++) {
    if (Math.abs(A[_i5][_i5]) < min) {
      minValue = Math.abs(A[_i5][_i5]);
    }
  }

  if (minValue === 0.0) {
    return Number.MAX_VALUE;
  }
  return maxValue / minValue;
}

function jacobi(a_3x3, w, v) {
  return jacobiN(a_3x3, 3, w, v);
}

function solveHomogeneousLeastSquares(numberOfSamples, xt, xOrder, mt) {
  // check dimensional consistency
  if (numberOfSamples < xOrder) {
    vtkWarningMacro('Insufficient number of samples. Underdetermined.');
    return 0;
  }

  var i = void 0;
  var j = void 0;
  var k = void 0;

  // set up intermediate variables
  // Allocate matrix to hold X times transpose of X
  var XXt = createArray(xOrder); // size x by x
  // Allocate the array of eigenvalues and eigenvectors
  var eigenvals = createArray(xOrder);
  var eigenvecs = createArray(xOrder);

  // Clear the upper triangular region (and btw, allocate the eigenvecs as well)
  for (i = 0; i < xOrder; i++) {
    eigenvecs[i] = createArray(xOrder);
    XXt[i] = createArray(xOrder);
    for (j = 0; j < xOrder; j++) {
      XXt[i][j] = 0.0;
    }
  }

  // Calculate XXt upper half only, due to symmetry
  for (k = 0; k < numberOfSamples; k++) {
    for (i = 0; i < xOrder; i++) {
      for (j = i; j < xOrder; j++) {
        XXt[i][j] += xt[k][i] * xt[k][j];
      }
    }
  }

  // now fill in the lower half of the XXt matrix
  for (i = 0; i < xOrder; i++) {
    for (j = 0; j < i; j++) {
      XXt[i][j] = XXt[j][i];
    }
  }

  // Compute the eigenvectors and eigenvalues
  jacobiN(XXt, xOrder, eigenvals, eigenvecs);

  // Smallest eigenval is at the end of the list (xOrder-1), and solution is
  // corresponding eigenvec.
  for (i = 0; i < xOrder; i++) {
    mt[i][0] = eigenvecs[i][xOrder - 1];
  }

  return 1;
}

function solveLeastSquares(numberOfSamples, xt, xOrder, yt, yOrder, mt) {
  var checkHomogeneous = arguments.length > 6 && arguments[6] !== undefined ? arguments[6] : true;

  // check dimensional consistency
  if (numberOfSamples < xOrder || numberOfSamples < yOrder) {
    vtkWarningMacro('Insufficient number of samples. Underdetermined.');
    return 0;
  }

  var homogenFlags = createArray(yOrder);
  var allHomogeneous = 1;
  var hmt = void 0;
  var homogRC = 0;
  var i = void 0;
  var j = void 0;
  var k = void 0;
  var someHomogeneous = 0;

  // Ok, first init some flags check and see if all the systems are homogeneous
  if (checkHomogeneous) {
    // If Y' is zero, it's a homogeneous system and can't be solved via
    // the pseudoinverse method. Detect this case, warn the user, and
    // invoke SolveHomogeneousLeastSquares instead. Note that it doesn't
    // really make much sense for yOrder to be greater than one in this case,
    // since that's just yOrder occurrences of a 0 vector on the RHS, but
    // we allow it anyway. N

    // Initialize homogeneous flags on a per-right-hand-side basis
    for (j = 0; j < yOrder; j++) {
      homogenFlags[j] = 1;
    }
    for (i = 0; i < numberOfSamples; i++) {
      for (j = 0; j < yOrder; j++) {
        if (Math.abs(yt[i][j]) > VTK_SMALL_NUMBER) {
          allHomogeneous = 0;
          homogenFlags[j] = 0;
        }
      }
    }

    // If we've got one system, and it's homogeneous, do it and bail out quickly.
    if (allHomogeneous && yOrder === 1) {
      vtkWarningMacro('Detected homogeneous system (Y=0), calling SolveHomogeneousLeastSquares()');
      return solveHomogeneousLeastSquares(numberOfSamples, xt, xOrder, mt);
    }

    // Ok, we've got more than one system of equations.
    // Figure out if we need to calculate the homogeneous equation solution for
    // any of them.
    if (allHomogeneous) {
      someHomogeneous = 1;
    } else {
      for (j = 0; j < yOrder; j++) {
        if (homogenFlags[j]) {
          someHomogeneous = 1;
        }
      }
    }
  }

  // If necessary, solve the homogeneous problem
  if (someHomogeneous) {
    // hmt is the homogeneous equation version of mt, the general solution.
    hmt = createArray(xOrder);
    for (j = 0; j < xOrder; j++) {
      // Only allocate 1 here, not yOrder, because here we're going to solve
      // just the one homogeneous equation subset of the entire problem
      hmt[j] = [0];
    }

    // Ok, solve the homogeneous problem
    homogRC = solveHomogeneousLeastSquares(numberOfSamples, xt, xOrder, hmt);
  }

  // set up intermediate variables
  var XXt = createArray(xOrder); // size x by x
  var XXtI = createArray(xOrder); // size x by x
  var XYt = createArray(xOrder); // size x by y
  for (i = 0; i < xOrder; i++) {
    XXt[i] = createArray(xOrder);
    XXtI[i] = createArray(xOrder);

    for (j = 0; j < xOrder; j++) {
      XXt[i][j] = 0.0;
      XXtI[i][j] = 0.0;
    }

    XYt[i] = createArray(yOrder);
    for (j = 0; j < yOrder; j++) {
      XYt[i][j] = 0.0;
    }
  }

  // first find the pseudoinverse matrix
  for (k = 0; k < numberOfSamples; k++) {
    for (i = 0; i < xOrder; i++) {
      // first calculate the XXt matrix, only do the upper half (symmetrical)
      for (j = i; j < xOrder; j++) {
        XXt[i][j] += xt[k][i] * xt[k][j];
      }

      // now calculate the XYt matrix
      for (j = 0; j < yOrder; j++) {
        XYt[i][j] += xt[k][i] * yt[k][j];
      }
    }
  }

  // now fill in the lower half of the XXt matrix
  for (i = 0; i < xOrder; i++) {
    for (j = 0; j < i; j++) {
      XXt[i][j] = XXt[j][i];
    }
  }

  var successFlag = invertMatrix(XXt, XXtI, xOrder);

  // next get the inverse of XXt
  if (successFlag) {
    for (i = 0; i < xOrder; i++) {
      for (j = 0; j < yOrder; j++) {
        mt[i][j] = 0.0;
        for (k = 0; k < xOrder; k++) {
          mt[i][j] += XXtI[i][k] * XYt[k][j];
        }
      }
    }
  }

  // Fix up any of the solutions that correspond to the homogeneous equation
  // problem.
  if (someHomogeneous) {
    for (j = 0; j < yOrder; j++) {
      if (homogenFlags[j]) {
        // Fix this one
        for (i = 0; i < xOrder; i++) {
          mt[i][j] = hmt[i][0];
        }
      }
    }
  }

  if (someHomogeneous) {
    return homogRC && successFlag;
  }

  return successFlag;
}

function hex2float(hexStr) {
  var outFloatArray = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : [0, 0.5, 1];

  switch (hexStr.length) {
    case 3:
      // abc => #aabbcc
      outFloatArray[0] = parseInt(hexStr[0], 16) * 17 / 255;
      outFloatArray[1] = parseInt(hexStr[1], 16) * 17 / 255;
      outFloatArray[2] = parseInt(hexStr[2], 16) * 17 / 255;
      return outFloatArray;
    case 4:
      // #abc => #aabbcc
      outFloatArray[0] = parseInt(hexStr[1], 16) * 17 / 255;
      outFloatArray[1] = parseInt(hexStr[2], 16) * 17 / 255;
      outFloatArray[2] = parseInt(hexStr[3], 16) * 17 / 255;
      return outFloatArray;
    case 6:
      // ab01df => #ab01df
      outFloatArray[0] = parseInt(hexStr.substr(0, 2), 16) / 255;
      outFloatArray[1] = parseInt(hexStr.substr(2, 2), 16) / 255;
      outFloatArray[2] = parseInt(hexStr.substr(4, 2), 16) / 255;
      return outFloatArray;
    case 7:
      // #ab01df
      outFloatArray[0] = parseInt(hexStr.substr(1, 2), 16) / 255;
      outFloatArray[1] = parseInt(hexStr.substr(3, 2), 16) / 255;
      outFloatArray[2] = parseInt(hexStr.substr(5, 2), 16) / 255;
      return outFloatArray;
    case 9:
      // #ab01df00
      outFloatArray[0] = parseInt(hexStr.substr(1, 2), 16) / 255;
      outFloatArray[1] = parseInt(hexStr.substr(3, 2), 16) / 255;
      outFloatArray[2] = parseInt(hexStr.substr(5, 2), 16) / 255;
      outFloatArray[3] = parseInt(hexStr.substr(7, 2), 16) / 255;
      return outFloatArray;
    default:
      return outFloatArray;
  }
}

function rgb2hsv(rgb, hsv) {
  var h = void 0;
  var s = void 0;

  var _rgb = _slicedToArray(rgb, 3),
      r = _rgb[0],
      g = _rgb[1],
      b = _rgb[2];

  var onethird = 1.0 / 3.0;
  var onesixth = 1.0 / 6.0;
  var twothird = 2.0 / 3.0;

  var cmax = r;
  var cmin = r;

  if (g > cmax) {
    cmax = g;
  } else if (g < cmin) {
    cmin = g;
  }
  if (b > cmax) {
    cmax = b;
  } else if (b < cmin) {
    cmin = b;
  }
  var v = cmax;

  if (v > 0.0) {
    s = (cmax - cmin) / cmax;
  } else {
    s = 0.0;
  }
  if (s > 0) {
    if (r === cmax) {
      h = onesixth * (g - b) / (cmax - cmin);
    } else if (g === cmax) {
      h = onethird + onesixth * (b - r) / (cmax - cmin);
    } else {
      h = twothird + onesixth * (r - g) / (cmax - cmin);
    }
    if (h < 0.0) {
      h += 1.0;
    }
  } else {
    h = 0.0;
  }

  // Set the values back to the array
  hsv[0] = h;
  hsv[1] = s;
  hsv[2] = v;
}

function hsv2rgb(hsv, rgb) {
  var _hsv = _slicedToArray(hsv, 3),
      h = _hsv[0],
      s = _hsv[1],
      v = _hsv[2];

  var onethird = 1.0 / 3.0;
  var onesixth = 1.0 / 6.0;
  var twothird = 2.0 / 3.0;
  var fivesixth = 5.0 / 6.0;
  var r = void 0;
  var g = void 0;
  var b = void 0;

  // compute RGB from HSV
  if (h > onesixth && h <= onethird) {
    // green/red
    g = 1.0;
    r = (onethird - h) / onesixth;
    b = 0.0;
  } else if (h > onethird && h <= 0.5) {
    // green/blue
    g = 1.0;
    b = (h - onethird) / onesixth;
    r = 0.0;
  } else if (h > 0.5 && h <= twothird) {
    // blue/green
    b = 1.0;
    g = (twothird - h) / onesixth;
    r = 0.0;
  } else if (h > twothird && h <= fivesixth) {
    // blue/red
    b = 1.0;
    r = (h - twothird) / onesixth;
    g = 0.0;
  } else if (h > fivesixth && h <= 1.0) {
    // red/blue
    r = 1.0;
    b = (1.0 - h) / onesixth;
    g = 0.0;
  } else {
    // red/green
    r = 1.0;
    g = h / onesixth;
    b = 0.0;
  }

  // add Saturation to the equation.
  r = s * r + (1.0 - s);
  g = s * g + (1.0 - s);
  b = s * b + (1.0 - s);

  r *= v;
  g *= v;
  b *= v;

  // Assign back to the array
  rgb[0] = r;
  rgb[1] = g;
  rgb[2] = b;
}

function lab2xyz(lab, xyz) {
  // LAB to XYZ
  var _lab = _slicedToArray(lab, 3),
      L = _lab[0],
      a = _lab[1],
      b = _lab[2];

  var var_Y = (L + 16) / 116;
  var var_X = a / 500 + var_Y;
  var var_Z = var_Y - b / 200;

  if (Math.pow(var_Y, 3) > 0.008856) {
    var_Y = Math.pow(var_Y, 3);
  } else {
    var_Y = (var_Y - 16.0 / 116.0) / 7.787;
  }

  if (Math.pow(var_X, 3) > 0.008856) {
    var_X = Math.pow(var_X, 3);
  } else {
    var_X = (var_X - 16.0 / 116.0) / 7.787;
  }

  if (Math.pow(var_Z, 3) > 0.008856) {
    var_Z = Math.pow(var_Z, 3);
  } else {
    var_Z = (var_Z - 16.0 / 116.0) / 7.787;
  }
  var ref_X = 0.9505;
  var ref_Y = 1.0;
  var ref_Z = 1.089;
  xyz[0] = ref_X * var_X; // ref_X = 0.9505  Observer= 2 deg Illuminant= D65
  xyz[1] = ref_Y * var_Y; // ref_Y = 1.000
  xyz[2] = ref_Z * var_Z; // ref_Z = 1.089
}

function xyz2lab(xyz, lab) {
  var _xyz = _slicedToArray(xyz, 3),
      x = _xyz[0],
      y = _xyz[1],
      z = _xyz[2];

  var ref_X = 0.9505;
  var ref_Y = 1.0;
  var ref_Z = 1.089;
  var var_X = x / ref_X; // ref_X = 0.9505  Observer= 2 deg, Illuminant= D65
  var var_Y = y / ref_Y; // ref_Y = 1.000
  var var_Z = z / ref_Z; // ref_Z = 1.089

  if (var_X > 0.008856) {
    var_X = Math.pow(var_X, 1.0 / 3.0);
  } else var_X = 7.787 * var_X + 16.0 / 116.0;
  if (var_Y > 0.008856) {
    var_Y = Math.pow(var_Y, 1.0 / 3.0);
  } else var_Y = 7.787 * var_Y + 16.0 / 116.0;
  if (var_Z > 0.008856) {
    var_Z = Math.pow(var_Z, 1.0 / 3.0);
  } else var_Z = 7.787 * var_Z + 16.0 / 116.0;

  lab[0] = 116 * var_Y - 16;
  lab[1] = 500 * (var_X - var_Y);
  lab[2] = 200 * (var_Y - var_Z);
}

function xyz2rgb(xyz, rgb) {
  var _xyz2 = _slicedToArray(xyz, 3),
      x = _xyz2[0],
      y = _xyz2[1],
      z = _xyz2[2];

  var r = x * 3.2406 + y * -1.5372 + z * -0.4986;
  var g = x * -0.9689 + y * 1.8758 + z * 0.0415;
  var b = x * 0.0557 + y * -0.204 + z * 1.057;

  // The following performs a "gamma correction" specified by the sRGB color
  // space.  sRGB is defined by a canonical definition of a display monitor and
  // has been standardized by the International Electrotechnical Commission (IEC
  // 61966-2-1).  The nonlinearity of the correction is designed to make the
  // colors more perceptually uniform.  This color space has been adopted by
  // several applications including Adobe Photoshop and Microsoft Windows color
  // management.  OpenGL is agnostic on its RGB color space, but it is reasonable
  // to assume it is close to this one.
  if (r > 0.0031308) r = 1.055 * Math.pow(r, 1 / 2.4) - 0.055;else r *= 12.92;
  if (g > 0.0031308) g = 1.055 * Math.pow(g, 1 / 2.4) - 0.055;else g *= 12.92;
  if (b > 0.0031308) b = 1.055 * Math.pow(b, 1 / 2.4) - 0.055;else b *= 12.92;

  // Clip colors. ideally we would do something that is perceptually closest
  // (since we can see colors outside of the display gamut), but this seems to
  // work well enough.
  var maxVal = r;
  if (maxVal < g) maxVal = g;
  if (maxVal < b) maxVal = b;
  if (maxVal > 1.0) {
    r /= maxVal;
    g /= maxVal;
    b /= maxVal;
  }
  if (r < 0) r = 0;
  if (g < 0) g = 0;
  if (b < 0) b = 0;

  // Push values back to array
  rgb[0] = r;
  rgb[1] = g;
  rgb[2] = b;
}

function rgb2xyz(rgb, xyz) {
  var _rgb2 = _slicedToArray(rgb, 3),
      r = _rgb2[0],
      g = _rgb2[1],
      b = _rgb2[2];
  // The following performs a "gamma correction" specified by the sRGB color
  // space.  sRGB is defined by a canonical definition of a display monitor and
  // has been standardized by the International Electrotechnical Commission (IEC
  // 61966-2-1).  The nonlinearity of the correction is designed to make the
  // colors more perceptually uniform.  This color space has been adopted by
  // several applications including Adobe Photoshop and Microsoft Windows color
  // management.  OpenGL is agnostic on its RGB color space, but it is reasonable
  // to assume it is close to this one.


  if (r > 0.04045) r = Math.pow((r + 0.055) / 1.055, 2.4);else r /= 12.92;
  if (g > 0.04045) g = Math.pow((g + 0.055) / 1.055, 2.4);else g /= 12.92;
  if (b > 0.04045) b = Math.pow((b + 0.055) / 1.055, 2.4);else b /= 12.92;

  // Observer. = 2 deg, Illuminant = D65
  xyz[0] = r * 0.4124 + g * 0.3576 + b * 0.1805;
  xyz[1] = r * 0.2126 + g * 0.7152 + b * 0.0722;
  xyz[2] = r * 0.0193 + g * 0.1192 + b * 0.9505;
}

function rgb2lab(rgb, lab) {
  var xyz = [0, 0, 0];
  rgb2xyz(rgb, xyz);
  xyz2lab(xyz, lab);
}

function lab2rgb(lab, rgb) {
  var xyz = [0, 0, 0];
  lab2xyz(lab, xyz);
  xyz2rgb(xyz, rgb);
}

function uninitializeBounds(bounds) {
  bounds[0] = 1.0;
  bounds[1] = -1.0;
  bounds[2] = 1.0;
  bounds[3] = -1.0;
  bounds[4] = 1.0;
  bounds[5] = -1.0;
}

function areBoundsInitialized(bounds) {
  return !(bounds[1] - bounds[0] < 0.0);
}

function clampValue(value, minValue, maxValue) {
  if (value < minValue) {
    return minValue;
  }
  if (value > maxValue) {
    return maxValue;
  }
  return value;
}

function clampAndNormalizeValue(value, range) {
  var result = 0;
  if (range[0] !== range[1]) {
    // clamp
    if (value < range[0]) {
      result = range[0];
    } else if (value > range[1]) {
      result = range[1];
    } else {
      result = value;
    }
    // normalize
    result = (result - range[0]) / (range[1] - range[0]);
  }

  return result;
}

var getScalarTypeFittingRange = notImplemented('GetScalarTypeFittingRange');
var getAdjustedScalarRange = notImplemented('GetAdjustedScalarRange');

function extentIsWithinOtherExtent(extent1, extent2) {
  if (!extent1 || !extent2) {
    return 0;
  }

  for (var i = 0; i < 6; i += 2) {
    if (extent1[i] < extent2[i] || extent1[i] > extent2[i + 1] || extent1[i + 1] < extent2[i] || extent1[i + 1] > extent2[i + 1]) {
      return 0;
    }
  }

  return 1;
}

function boundsIsWithinOtherBounds(bounds1_6, bounds2_6, delta_3) {
  if (!bounds1_6 || !bounds2_6) {
    return 0;
  }
  for (var i = 0; i < 6; i += 2) {
    if (bounds1_6[i] + delta_3[i / 2] < bounds2_6[i] || bounds1_6[i] - delta_3[i / 2] > bounds2_6[i + 1] || bounds1_6[i + 1] + delta_3[i / 2] < bounds2_6[i] || bounds1_6[i + 1] - delta_3[i / 2] > bounds2_6[i + 1]) {
      return 0;
    }
  }
  return 1;
}

function pointIsWithinBounds(point_3, bounds_6, delta_3) {
  if (!point_3 || !bounds_6 || !delta_3) {
    return 0;
  }
  for (var i = 0; i < 3; i++) {
    if (point_3[i] + delta_3[i] < bounds_6[2 * i] || point_3[i] - delta_3[i] > bounds_6[2 * i + 1]) {
      return 0;
    }
  }
  return 1;
}

function solve3PointCircle(p1, p2, p3, center) {
  var v21 = createArray(3);
  var v32 = createArray(3);
  var v13 = createArray(3);
  var v12 = createArray(3);
  var v23 = createArray(3);
  var v31 = createArray(3);

  for (var i = 0; i < 3; ++i) {
    v21[i] = p1[i] - p2[i];
    v32[i] = p2[i] - p3[i];
    v13[i] = p3[i] - p1[i];
    v12[i] = -v21[i];
    v23[i] = -v32[i];
    v31[i] = -v13[i];
  }

  var norm12 = norm(v12);
  var norm23 = norm(v23);
  var norm13 = norm(v13);

  var crossv21v32 = createArray(3);
  cross(v21, v32, crossv21v32);
  var normCross = norm(crossv21v32);

  var radius = norm12 * norm23 * norm13 / (2 * normCross);

  var normCross22 = 2 * normCross * normCross;
  var alpha = norm23 * norm23 * dot(v21, v31) / normCross22;
  var beta = norm13 * norm13 * dot(v12, v32) / normCross22;
  var gamma = norm12 * norm12 * dot(v13, v23) / normCross22;

  for (var _i6 = 0; _i6 < 3; ++_i6) {
    center[_i6] = alpha * p1[_i6] + beta * p2[_i6] + gamma * p3[_i6];
  }
  return radius;
}

var inf = Infinity;
var negInf = -Infinity;

var isInf = function isInf(value) {
  return !Number.isFinite(value);
};
var isFinite = Number.isFinite,
    isNaN = Number.isNaN;

// JavaScript - add-on ----------------------

function createUninitializedBounds() {
  return [].concat([Number.MAX_VALUE, -Number.MAX_VALUE, // X
  Number.MAX_VALUE, -Number.MAX_VALUE, // Y
  Number.MAX_VALUE, -Number.MAX_VALUE] // Z
  );
}

// ----------------------------------------------------------------------------
// Only Static API
// ----------------------------------------------------------------------------

exports.default = {
  Pi: Pi,
  radiansFromDegrees: radiansFromDegrees,
  degreesFromRadians: degreesFromRadians,
  round: round,
  floor: floor,
  ceil: ceil,
  ceilLog2: ceilLog2,
  min: min,
  max: max,
  arrayMin: arrayMin,
  arrayMax: arrayMax,
  isPowerOfTwo: isPowerOfTwo,
  nearestPowerOfTwo: nearestPowerOfTwo,
  factorial: factorial,
  binomial: binomial,
  beginCombination: beginCombination,
  nextCombination: nextCombination,
  randomSeed: randomSeed,
  getSeed: getSeed,
  random: random,
  gaussian: gaussian,
  add: add,
  subtract: subtract,
  multiplyScalar: multiplyScalar,
  multiplyScalar2D: multiplyScalar2D,
  dot: dot,
  outer: outer,
  cross: cross,
  norm: norm,
  normalize: normalize,
  perpendiculars: perpendiculars,
  projectVector: projectVector,
  projectVector2D: projectVector2D,
  distance2BetweenPoints: distance2BetweenPoints,
  angleBetweenVectors: angleBetweenVectors,
  gaussianAmplitude: gaussianAmplitude,
  gaussianWeight: gaussianWeight,
  dot2D: dot2D,
  outer2D: outer2D,
  norm2D: norm2D,
  normalize2D: normalize2D,
  determinant2x2: determinant2x2,
  LUFactor3x3: LUFactor3x3,
  LUSolve3x3: LUSolve3x3,
  linearSolve3x3: linearSolve3x3,
  multiply3x3_vect3: multiply3x3_vect3,
  multiply3x3_mat3: multiply3x3_mat3,
  multiplyMatrix: multiplyMatrix,
  transpose3x3: transpose3x3,
  invert3x3: invert3x3,
  identity3x3: identity3x3,
  determinant3x3: determinant3x3,
  quaternionToMatrix3x3: quaternionToMatrix3x3,
  areMatricesEqual: areMatricesEqual,
  matrix3x3ToQuaternion: matrix3x3ToQuaternion,
  multiplyQuaternion: multiplyQuaternion,
  orthogonalize3x3: orthogonalize3x3,
  diagonalize3x3: diagonalize3x3,
  singularValueDecomposition3x3: singularValueDecomposition3x3,
  solveLinearSystem: solveLinearSystem,
  invertMatrix: invertMatrix,
  luFactorLinearSystem: luFactorLinearSystem,
  luSolveLinearSystem: luSolveLinearSystem,
  estimateMatrixCondition: estimateMatrixCondition,
  jacobi: jacobi,
  jacobiN: jacobiN,
  solveHomogeneousLeastSquares: solveHomogeneousLeastSquares,
  solveLeastSquares: solveLeastSquares,
  hex2float: hex2float,
  rgb2hsv: rgb2hsv,
  hsv2rgb: hsv2rgb,
  lab2xyz: lab2xyz,
  xyz2lab: xyz2lab,
  xyz2rgb: xyz2rgb,
  rgb2xyz: rgb2xyz,
  rgb2lab: rgb2lab,
  lab2rgb: lab2rgb,
  uninitializeBounds: uninitializeBounds,
  areBoundsInitialized: areBoundsInitialized,
  clampValue: clampValue,
  clampAndNormalizeValue: clampAndNormalizeValue,
  getScalarTypeFittingRange: getScalarTypeFittingRange,
  getAdjustedScalarRange: getAdjustedScalarRange,
  extentIsWithinOtherExtent: extentIsWithinOtherExtent,
  boundsIsWithinOtherBounds: boundsIsWithinOtherBounds,
  pointIsWithinBounds: pointIsWithinBounds,
  solve3PointCircle: solve3PointCircle,
  inf: inf,
  negInf: negInf,
  isInf: isInf,
  isNan: isNaN,
  isNaN: isNaN,
  isFinite: isFinite,

  // JS add-on
  createUninitializedBounds: createUninitializedBounds
};

/***/ }),

/***/ 992:
/***/ (function(module, exports, __webpack_require__) {

/* WEBPACK VAR INJECTION */(function(global) {if(!global["Glance"]) global["Glance"] = {};
if(!global["Glance"]["externals"]) global["Glance"]["externals"] = {};
module.exports = global["Glance"]["externals"]["ITKReader"] = __webpack_require__(993);
/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(20)))

/***/ }),

/***/ 993:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.extensions = undefined;
exports.registerToGlance = registerToGlance;

var _extensionToIO = __webpack_require__(994);

var _extensionToIO2 = _interopRequireDefault(_extensionToIO);

var _ITKImageReader = __webpack_require__(995);

var _ITKImageReader2 = _interopRequireDefault(_ITKImageReader);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var extensions = exports.extensions = Array.from(new Set(Object.keys(_extensionToIO2.default).map(function (ext) {
  return ext.toLowerCase();
})));

function registerToGlance(Glance) {
  if (Glance) {
    extensions.forEach(function (extension) {
      return Glance.registerReader({
        extension: extension,
        name: extension.toUpperCase() + ' Reader',
        vtkReader: _ITKImageReader2.default,
        binary: true,
        fileNameMethod: 'setFileName'
      });
    });
  }
}

exports.default = {
  extensions: extensions,
  vtkITKImageReader: _ITKImageReader2.default,
  registerToGlance: registerToGlance
};


var Glance = (typeof window === 'undefined' ? {} : window).Glance;
registerToGlance(Glance);

/***/ }),

/***/ 994:
/***/ (function(module, exports) {

let extensionToIO = {}

extensionToIO['bmp'] = 'itkBMPImageIOJSBinding'
extensionToIO['BMP'] = 'itkBMPImageIOJSBinding'

extensionToIO['dcm'] = 'itkDCMTKImageIOJSBinding'
extensionToIO['DCM'] = 'itkDCMTKImageIOJSBinding'

extensionToIO['gipl'] = 'itkGiplImageIOJSBinding'
extensionToIO['gipl.gz'] = 'itkGiplImageIOJSBinding'

extensionToIO['hdf5'] = 'itkHDF5ImageIOJSBinding'

extensionToIO['jpg'] = 'itkJPEGImageIOJSBinding'
extensionToIO['JPG'] = 'itkJPEGImageIOJSBinding'
extensionToIO['jpeg'] = 'itkJPEGImageIOJSBinding'
extensionToIO['JPEG'] = 'itkJPEGImageIOJSBinding'

extensionToIO['lsm'] = 'itkLSMImageIOJSBinding'

extensionToIO['mnc'] = 'itkMINCImageIOJSBinding'
extensionToIO['MNC'] = 'itkMINCImageIOJSBinding'
extensionToIO['mnc.gz'] = 'itkMINCImageIOJSBinding'
extensionToIO['MNC.GZ'] = 'itkMINCImageIOJSBinding'
extensionToIO['mnc2'] = 'itkMINCImageIOJSBinding'
extensionToIO['MNC2'] = 'itkMINCImageIOJSBinding'

extensionToIO['mgh'] = 'itkMGHImageIOJSBinding'
extensionToIO['mgz'] = 'itkMGHImageIOJSBinding'
extensionToIO['mgh.gz'] = 'itkMGHImageIOJSBinding'

extensionToIO['mha'] = 'itkMetaImageIOJSBinding'
extensionToIO['mhd'] = 'itkMetaImageIOJSBinding'

extensionToIO['mrc'] = 'itkMRCImageIOJSBinding'

extensionToIO['nia'] = 'itkNiftiImageIOJSBinding'
extensionToIO['nii'] = 'itkNiftiImageIOJSBinding'
extensionToIO['nii.gz'] = 'itkNiftiImageIOJSBinding'
extensionToIO['hdr'] = 'itkNiftiImageIOJSBinding'

extensionToIO['nrrd'] = 'itkNrrdImageIOJSBinding'
extensionToIO['NRRD'] = 'itkNrrdImageIOJSBinding'
extensionToIO['nhdr'] = 'itkNrrdImageIOJSBinding'
extensionToIO['NHDR'] = 'itkNrrdImageIOJSBinding'

extensionToIO['png'] = 'itkPNGImageIOJSBinding'
extensionToIO['PNG'] = 'itkPNGImageIOJSBinding'

extensionToIO['pic'] = 'itkBioRadImageIOJSBinding'
extensionToIO['PIC'] = 'itkBioRadImageIOJSBinding'

extensionToIO['tif'] = 'itkTIFFImageIOJSBinding'
extensionToIO['TIF'] = 'itkTIFFImageIOJSBinding'
extensionToIO['tiff'] = 'itkTIFFImageIOJSBinding'
extensionToIO['TIFF'] = 'itkTIFFImageIOJSBinding'

extensionToIO['vtk'] = 'itkVTKImageIOJSBinding'
extensionToIO['VTK'] = 'itkVTKImageIOJSBinding'

module.exports = extensionToIO


/***/ }),

/***/ 995:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.newInstance = undefined;
exports.extend = extend;

var _macro = __webpack_require__(0);

var _macro2 = _interopRequireDefault(_macro);

var _ITKHelper = __webpack_require__(996);

var _ITKHelper2 = _interopRequireDefault(_ITKHelper);

var _readImageArrayBuffer = __webpack_require__(997);

var _readImageArrayBuffer2 = _interopRequireDefault(_readImageArrayBuffer);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var convertItkToVtkImage = _ITKHelper2.default.convertItkToVtkImage;

// ----------------------------------------------------------------------------
// vtkITKImageReader methods
// ----------------------------------------------------------------------------

function vtkITKImageReader(publicAPI, model) {
  // Set our className
  model.classHierarchy.push('vtkITKImageReader');

  // Returns a promise to signal when image is ready
  publicAPI.parseAsArrayBuffer = function (arrayBuffer) {
    if (!arrayBuffer || arrayBuffer === model.rawDataBuffer) {
      return Promise.resolve();
    }

    model.rawDataBuffer = arrayBuffer;

    return (0, _readImageArrayBuffer2.default)(arrayBuffer, model.fileName).then(function (itkImage) {
      var imageData = convertItkToVtkImage(itkImage);
      model.output[0] = imageData;

      publicAPI.modified();
    });
  };

  publicAPI.requestData = function (inData, outData) {
    publicAPI.parseAsArrayBuffer(model.rawDataBuffer, model.fileName);
  };
}

// ----------------------------------------------------------------------------
// Object factory
// ----------------------------------------------------------------------------

var DEFAULT_VALUES = {
  fileName: ''
};

// ----------------------------------------------------------------------------

function extend(publicAPI, model) {
  var initialValues = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : {};

  Object.assign(model, DEFAULT_VALUES, initialValues);

  // Build VTK API
  _macro2.default.obj(publicAPI, model);
  _macro2.default.algo(publicAPI, model, 0, 1);
  _macro2.default.setGet(publicAPI, model, ['fileName']);

  // vtkITKImageReader methods
  vtkITKImageReader(publicAPI, model);
}

// ----------------------------------------------------------------------------

var newInstance = exports.newInstance = _macro2.default.newInstance(extend, 'vtkITKImageReader');

// ----------------------------------------------------------------------------

exports.default = { newInstance: newInstance, extend: extend };

/***/ }),

/***/ 996:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});

var _macro = __webpack_require__(0);

var _macro2 = _interopRequireDefault(_macro);

var _ImageData = __webpack_require__(59);

var _ImageData2 = _interopRequireDefault(_ImageData);

var _DataArray = __webpack_require__(12);

var _DataArray2 = _interopRequireDefault(_DataArray);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var vtkErrorMacro = _macro2.default.vtkErrorMacro;

/**
 * Converts an itk.js image to a vtk.js image.
 *
 * Requires an itk.js image as input.
 */

function convertItkToVtkImage(itkImage) {
  var options = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : {};

  // Make sure we can handle input pixel type
  // Refer to itk-js/src/PixelTypes.js for numerical values
  switch (itkImage.imageType.pixelType) {
    case 1: // Scalar
    case 2: // RGB
    case 3:
      // RGBA
      break;
    default:
      vtkErrorMacro('Cannot handle ITK.js pixel type ' + itkImage.imageType.pixelType);
      return null;
  }

  var vtkImage = {
    origin: [0, 0, 0],
    spacing: [1, 1, 1]
  };

  var dimensions = [1, 1, 1];
  var direction = [1, 0, 0, 0, 1, 0, 0, 0, 1];

  for (var idx = 0; idx < itkImage.imageType.dimension; ++idx) {
    vtkImage.origin[idx] = itkImage.origin[idx];
    vtkImage.spacing[idx] = itkImage.spacing[idx];
    dimensions[idx] = itkImage.size[idx];
    for (var col = 0; col < itkImage.imageType.dimension; ++col) {
      // ITK (and VTKMath) use a row-major index axis, but the direction
      // matrix on the vtkImageData is a webGL matrix, which uses a
      // column-major data layout. Transpose the direction matrix from
      // itkImage when instantiating that vtkImageData direction matrix.
      direction[col + idx * 3] = itkImage.direction.data[idx + col * itkImage.imageType.dimension];
    }
  }

  // Create VTK Image Data
  var imageData = _ImageData2.default.newInstance(vtkImage);

  // create VTK image data
  var scalars = _DataArray2.default.newInstance({
    name: options.scalarArrayName || 'Scalars',
    values: itkImage.data,
    numberOfComponents: itkImage.imageType.components
  });

  imageData.setDirection(direction);
  imageData.setDimensions.apply(imageData, dimensions);
  imageData.getPointData().setScalars(scalars);

  return imageData;
}

exports.default = {
  convertItkToVtkImage: convertItkToVtkImage
};

/***/ }),

/***/ 997:
/***/ (function(module, exports, __webpack_require__) {

const WebworkerPromise = __webpack_require__(151)

const config = __webpack_require__(998)

const worker = new window.Worker(config.webWorkersPath + '/ImageIOWorker.js')
const promiseWorker = new WebworkerPromise(worker)

/**
 * Read an image from a file ArrayBuffer in the browser.
 *
 * @param: data arrayBuffer that contains the file contents
 * @param: fileName string that contains the file name
 * @param: mimeType optional mime-type string
 */
const readImageArrayBuffer = (arrayBuffer, fileName, mimeType) => {
  return promiseWorker.postMessage({ operation: 'readImage', name: fileName, type: mimeType, data: arrayBuffer, config: config },
    [arrayBuffer])
}

module.exports = readImageArrayBuffer


/***/ }),

/***/ 998:
/***/ (function(module, exports) {

// Note: For the WASM files to be loaded, imageIOsPath must have the path
// '../ImageIOs' relative to webWorkersPath
let itkConfig = {
  webWorkersPath: '/SDR_base-portlet/js/glance/itk/WebWorkers',
  imageIOsPath: '../ImageIOs'
}

module.exports = itkConfig


/***/ })

/******/ });
});