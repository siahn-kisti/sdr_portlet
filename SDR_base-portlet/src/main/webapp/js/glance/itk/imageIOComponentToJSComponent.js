const IntTypes = require('./IntTypes.js')
const FloatTypes = require('./FloatTypes.js')

const imageIOComponentToJSComponent = (module, ioComponentType) => {
  let componentType = null
  switch (ioComponentType) {
    case module.IOComponentType.UCHAR: {
      componentType = IntTypes.UInt8
      break
    }
    case module.IOComponentType.CHAR: {
      componentType = IntTypes.Int8
      break
    }
    case module.IOComponentType.USHORT: {
      componentType = IntTypes.UInt16
      break
    }
    case module.IOComponentType.SHORT: {
      componentType = IntTypes.Int16
      break
    }
    case module.IOComponentType.UINT: {
      componentType = IntTypes.UInt32
      break
    }
    case module.IOComponentType.INT: {
      componentType = IntTypes.Int32
      break
    }
    case module.IOComponentType.ULONG: {
      componentType = IntTypes.UInt64
      break
    }
    case module.IOComponentType.LONG: {
      componentType = IntTypes.Int64
      break
    }
    case module.IOComponentType.FLOAT: {
      componentType = FloatTypes.Float32
      break
    }
    case module.IOComponentType.DOUBLE: {
      componentType = FloatTypes.Float64
      break
    }
    default:
      throw new Error('Unknown IO component type')
  }

  return componentType
}

module.exports = imageIOComponentToJSComponent
