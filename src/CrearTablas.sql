create sequence personas_sequence start with 6;
create sequence cargos_sequence start with 6;
create sequence cuentas_sequence start with 106;
create sequence oficinas_sequence start with 6;
create sequence operacionescuentas_sequence start with 6;
create sequence operacionesprestamos_sequence start with 6;
create sequence operacionestransferencias_sequence start with 6;
create sequence prestamos_sequence start with 6;
create sequence puntoatencion_sequence start with 6;

CREATE TABLE Cargos (
    IDCargo INTEGER NOT NULL,
    Nombre  VARCHAR2(80) NOT NULL,
    CONSTRAINT cargo_pk PRIMARY KEY ( IDCargo ),
    CONSTRAINT tipo_cargo CHECK (Nombre in ('Cajero','GerenteOficina', 'GerenteGeneral'))
    
);


CREATE TABLE Personas (
    ID INTEGER NOT NULL,
    nombre VARCHAR2(150) NOT NULL,
    datosContacto VARCHAR2(150) NOT NULL,
    direccionFisica VARCHAR2(150) NOT NULL,
    direccionElectronica VARCHAR2(150) NOT NULL,
    telefono NUMBER (15) NOT NULL,
    ciudad VARCHAR2(80) NOT NULL,
    departamento VARCHAR2(80) NOT NULL, 
    codigoPostal NUMBER (15) NOT NULL,
    fechaRegistro DATE NOT NULL,
    docId INTEGER NOT NULL,
    CONSTRAINT idpersona_pk PRIMARY KEY (ID),
    CONSTRAINT FK_persona_identificacion FOREIGN KEY (docId) REFERENCES Identificaciones (numero),
    CONSTRAINT docId_unique UNIQUE (docId)
);


CREATE TABLE Clientes (
    IDCliente INTEGER,
    rolC VARCHAR2(80) NOT NULL,
    CONSTRAINT FK_cliente_persona FOREIGN KEY (IDCliente) REFERENCES Personas (ID),
    CONSTRAINT PK_Cliente PRIMARY KEY (IDCliente),
    CONSTRAINT tipo_rolC check(RolC in ('Natural', 'Juridico'))
);


CREATE TABLE Cuentas (
    IDCuenta INTEGER PRIMARY KEY, 
    TipoCuenta VARCHAR2(10) NOT NULL,
    Saldo Float NOT NULL,
    FechaUltimaTransaccion DATE NOT NULL,
    idCliente INTEGER NOT NULL,
    EstadoCuenta VARCHAR2(30) NOT NULL,
    IDGERENTE INTEGER NOT NULL,
    CONSTRAINT TipoCuenta CHECK (TipoCuenta in ('Ahorros', 'Corriente', 'AFC')),
    CONSTRAINT EstadoCuenta CHECK (EstadoCuenta in ('Activa', 'Cerrada', 'Desactivada')),
    CONSTRAINT IDCliente FOREIGN KEY (IDCliente) REFERENCES Clientes (IDCliente)
);


CREATE TABLE Oficinas (
    IDOficina INTEGER PRIMARY KEY,
    Nombre VARCHAR2(80) NOT NULL,
    Direccion VARCHAR2(100) NOT NULL,
    NUMEROPA NUMBER(20) NOT NULL,
    IDGERENTE NUMBER(30) NOT NULL,
    CONSTRAINT IDGerente_unique UNIQUE (IDGerente)
);


CREATE TABLE Empleados (
    IDEmpleado INTEGER  NOT NULL PRIMARY KEY,
    IDCargo INTEGER NOT NULL,
    IDOficina INTEGER NOT NULL,
    CONSTRAINT EMPLEADO_CARGO_FK FOREIGN KEY (IDCargo) REFERENCES Cargos (IDCargo),
    CONSTRAINT EMPLEADO_OFICINA_FK FOREIGN KEY (IDOficina) REFERENCES Oficinas (IDOficina),
    CONSTRAINT EMPLEADO_PERSONA_FK FOREIGN KEY (IDEmpleado) REFERENCES Personas (ID)
);



CREATE TABLE UsuariosEmpleados (
    ID Number PRIMARY KEY,
    password VARCHAR2(10) NOT NULL,
    CONSTRAINT FK_empleado_usuarioEmpleado FOREIGN KEY (ID) REFERENCES Empleados (IDEmpleado)
);

CREATE TABLE UsuariosClientes(
    ID Number PRIMARY KEY,
    password VARCHAR2(10) NOT NULL,
    CONSTRAINT CLIENTE_PERSONA_FK FOREIGN KEY (ID) REFERENCES Clientes (IDCliente)
);

CREATE TABLE Identificaciones (
    tipo VARCHAR2(10) ,
    numero INTEGER NOT NULL,
    PRIMARY KEY (numero )
);

CREATE TABLE PuntosAtencion (
    IDPuntoAtencion INTEGER PRIMARY KEY,
    Tipo VARCHAR2(50) NOT NULL,
    UbicacionGeografica VARCHAR2(500) NOT NULL,
    Estado VARCHAR(100) NOT NULL,
    IDOficina INTEGER,
    CONSTRAINT PUNTOATENCION_OFICINA_FK FOREIGN KEY (IDOficina) REFERENCES Oficinas (IDOficina),
    CONSTRAINT tipoA CHECK (Tipo IN ('Personalizada', 'CajeroAutomatico', 'Digital'))
);


CREATE TABLE OperacionesCuentas (
    IDOperacionCu Integer PRIMARY KEY,
    Monto float,
    Fecha Date,
    TipoOC VARCHAR2(20),
    idCuenta integer,
    idPuntoAtencion integer,
    CONSTRAINT TipoOC CHECK (TipoOC in ('Consignar', 'Retirar', 'Abrir', 'Cerrar')),
    CONSTRAINT OperacionCuenta_CUENTA_FK FOREIGN KEY (idCuenta) REFERENCES Cuentas (idCuenta),
    CONSTRAINT OperacionCuenta_PUNTOATENCION_FK FOREIGN KEY (idPuntoAtencion) REFERENCES PuntosAtencion (idPuntoAtencion)
   
);

CREATE TABLE Prestamos (
    IDPrestamo INTEGER PRIMARY KEY,
    Monto Integer,
    Interes Float,
    NumeroCuotas INTEGER,
    DiaPagoCuota DATE,
    ValorCuota FLOAT,
    EstadoP VARCHAR2 (50),
    CONSTRAINT estadoP CHECK ( EstadoP in ('Solicitado', 'Aprobado', 'Rechazado', 'Pagado', 'Cerrado')),
    IDCliente Integer,
    CONSTRAINT PRESTAMO_CLIENTE_FK FOREIGN KEY (IDCliente) REFERENCES Clientes (IDCliente)
    
);



CREATE TABLE OperacionesPrestamos(
    IDOperacionPrestamo INTEGER PRIMARY KEY,
    Tipo VARCHAR2 (50),
    CONSTRAINT tipoP CHECK (Tipo in ('Solicitar', 'Aprobar', 'Rechazar', 'PagarCuota', ' PagarCuotaExtraordinaria', 'PagarCuotaOrdinaria', 'Cerrar')),
    Monto float,
    Fecha Date,
    IDPrestamo INTEGER, 
    CONSTRAINT OPERACIONPRESTAMO_PRESTAMO_FK FOREIGN KEY (IDPrestamo) REFERENCES Prestamos (IDPrestamo),
    IDPuntoAtencion INTEGER,
    CONSTRAINT OPERACIONPRESTAMO_PUNTOATENCION_FK FOREIGN KEY (IDPuntoAtencion) REFERENCES PuntosAtencion(IDPuntoAtencion)
);

CREATE TABLE OperacionesTransferencias (
    IDOperacionTrans INTEGER PRIMARY KEY,
    Monto FLOAT,
    Fecha Date,
    IDCuentaOrigen INTEGER,
    CONSTRAINT OPERACIONTRANSFERENCIA_CUENTA_FK FOREIGN KEY (IDCuentaOrigen) REFERENCES Cuentas (IDCuenta),
    IDCuentaDestino INTEGER,
    CONSTRAINT OPERACIONTRANSFERENCIA_CUENTA_FKv2 FOREIGN KEY (IDCuentaDestino) REFERENCES Cuentas (IDCuenta),
    IDPuntoAtencion INTEGER,
    CONSTRAINT OPERACIONTRANSFERENCIA_PUNTOATENCION_FK FOREIGN KEY (IDPuntoAtencion) REFERENCES PuntosAtencion (IDPuntoAtencion)
);


DROP SEQUENCE personas_sequence;
DROP SEQUENCE cargos_sequence;
DROP SEQUENCE cuentas_sequence;
DROP SEQUENCE oficinas_sequence;
DROP SEQUENCE operacionescuentas_sequence;
DROP SEQUENCE operacionesprestamos_sequence;
DROP SEQUENCE operacionestransferencias_sequence;
DROP SEQUENCE prestamos_sequence;
DROP SEQUENCE puntoatencion_sequence;

DROP TABLE OperacionesTransferencias;
DROP TABLE OperacionesPrestamos;
DROP TABLE OperacionesCuentas;
DROP TABLE UsuariosClientes;
DROP TABLE UsuariosEmpleados;
DROP TABLE Prestamos;
DROP TABLE Cuentas;
DROP TABLE Clientes;
DROP TABLE Empleados;
DROP TABLE PuntosAtencion;
DROP TABLE Personas;
DROP TABLE Oficinas;
DROP TABLE Cargos;
DROP TABLE Identificaciones;