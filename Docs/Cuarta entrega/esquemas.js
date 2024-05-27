// Esquema de oficina
db.createCollection("Oficinas", {validator: {
  $jsonSchema: {
    bsonType: 'object',
    required: [
      'nombre',
      'direccion',
      'numPuntos',
      'gerente'
    ],
    properties: {
      nombre: {
        bsonType: 'string'
      },
      direccion: {
        bsonType: 'string'
      },
      numPuntos: {
        bsonType: 'int'
      },
      puntosAtencion: {
        bsonType: 'array',
        items: {
          bsonType: 'objectId'
        }
      },
      empleados: {
        bsonType: 'array',
        items: {
          bsonType: 'objectId'
        }
      },
      gerente: {
        bsonType: 'objectId'
      }
    }
  }
}})

//Esquema de empleados
db.createCollection("Empleados", {validator: {
  $jsonSchema: {
    bsonType: 'object',
    required: [
      'tipoDni',
      'dni',
      'nombre',
      'nacionalidad',
      'direccion',
      'email',
      'telefono',
      'ciudad',
      'departamento',
      'codigoPostal',
      'cargo'
    ],
    properties: {
      tipoDni: {
        bsonType: 'string'
      },
      dni: {
        bsonType: 'string'
      },
      nombre: {
        bsonType: 'string'
      },
      nacionalidad: {
        bsonType: 'string'
      },
      direccion: {
        bsonType: 'string'
      },
      email: {
        bsonType: 'string'
      },
      telefono: {
        bsonType: 'string'
      },
      ciudad: {
        bsonType: 'string'
      },
      departamento: {
        bsonType: 'string'
      },
      codigoPostal: {
        bsonType: 'int'
      },
      cargo: {
        'enum': [
          'Gerente general',
          'Gerente de oficina',
          'Cajero'
        ]
      }
    }
  }
}})

// Esquema de Clientes
db.createCollection("Clientes", {validator: {
  $jsonSchema: {
    bsonType: 'object',
    required: [
      'tipoDni',
      'dni',
      'nombre',
      'nacionalidad',
      'direccion',
      'email',
      'telefono',
      'ciudad',
      'departamento',
      'codigoPostal',
      'tipo'
    ],
    properties: {
      tipoDni: {
        bsonType: 'string'
      },
      dni: {
        bsonType: 'string'
      },
      nombre: {
        bsonType: 'string'
      },
      nacionalidad: {
        bsonType: 'string'
      },
      direccion: {
        bsonType: 'string'
      },
      email: {
        bsonType: 'string'
      },
      telefono: {
        bsonType: 'string'
      },
      ciudad: {
        bsonType: 'string'
      },
      departamento: {
        bsonType: 'string'
      },
      codigoPostal: {
        bsonType: 'int'
      },
      tipo: {
        'enum': [
          'Natural',
          'Jurídica'
        ]
      },
      cuentas: {
        bsonType: 'array',
        items: {
          bsonType: 'objectId'
        }
      }
    }
  }
}})

// Esquema de Cuentas
db.createCollection("Cuentas", {validator: {
  jsonSchema: {
    bsonType: 'object',
    required: [
      'numero',
      'tipo',
      'saldo',
      'estado',
      'ultimaTransaccion'
    ],
    properties: {
      numero: {
        bsonType: 'int'
      },
      tipo: {
        bsonType: 'string',
        'enum': [
          'ahorros',
          'coriente',
          'AFC'
        ]
      },
      saldo: {
        bsonType: 'double'
      },
      estado: {
        bsonType: 'string',
        'enum': [
          'activa',
          'cerrada',
          'desactivada'
        ]
      },
      ultimaTransaccion: {
        bsonType: 'date'
      },
      operaciones: {
        bsonType: 'array',
        items: {
          bsonType: 'object',
          required: [
            'valor',
            'tipo',
            'fecha',
            'puntoAtencion'
          ],
          properties: {
            valor: {
              bsonType: 'double'
            },
            tipo: {
              bsonType: 'string',
              'enum': [
                'Abrir cuenta',
                'Cerrar cuenta',
                'Consignar',
                'Retirar',
                'Transferir'
              ]
            },
            fecha: {
              bsonType: 'date'
            },
            puntoAtencion: {
              bsonType: 'objectId'
            },
            cuentaDestino: {
              bsonType: 'objectId'
            }
          }
        }
      }
    }
  }
}})

//Esquema de Punto de Atención
db.createCollection("PuntosAtencion", {validator: {
  $jsonSchema: {
    bsonType: 'object',
    required: [
      'tipo',
      'latitud',
      'longitud'
    ],
    properties: {
      tipo: {
        bsonType: 'string',
        enum: [
          'Atención personalizada',
          'Cajero automático',
          'Digital'
        ]
      },
      latitud: {
        bsonType: 'string'
      },
      longitud: {
        bsonType: 'string'
      }
    }
  }
}})