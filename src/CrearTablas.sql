create sequence bancandes;

CREATE TABLE Cargos (
    IDCargo INTEGER NOT NULL,
    Nombre  VARCHAR2(80) NOT NULL,
    CONSTRAINT cargo_pk PRIMARY KEY ( IDCargo ),
    CONSTRAINT tipo_cargo CHECK (Nombre in ('Cajero','Gerente Oficina', 'Gerente General'))
    
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
    CONSTRAINT FK_persona_identificacion FOREIGN KEY (docId) REFERENCES Identificaciones (numero)
);


CREATE TABLE Clientes (
    ID INTEGER,
    rolC VARCHAR2(80) NOT NULL,
    CONSTRAINT FK_cliente_persona FOREIGN KEY (ID) REFERENCES Personas (ID),
    CONSTRAINT PK_Cliente PRIMARY KEY (ID),
    CONSTRAINT tipo_rolC check(RolC in ('Natural', 'Juridico'))

);


CREATE TABLE Cuentas (
    IDCuenta INTEGER PRIMARY KEY, 
    TipoCuenta VARCHAR2(3) NOT NULL,
    Saldo Float NOT NULL,
    FechaUltimaTransaccion DATE NOT NULL,
    idCliente INTEGER NOT NULL,
    EstadoCuenta VARCHAR2(30) NOT NULL,
    CONSTRAINT TipoCuenta CHECK (TipoCuenta in ('Ahorros', 'Corriente', 'AFC')),
    CONSTRAINT EstadoCuenta CHECK (EstadoCuenta in ('Activada', 'Cerrada', 'Desactivada')),
    CONSTRAINT IDCliente FOREIGN KEY (IDCliente) REFERENCES Clientes (ID)
);


CREATE TABLE Oficinas (
    IDOficina INTEGER PRIMARY KEY,
    Nombre VARCHAR2(80) NOT NULL,
    Direccion VARCHAR2(100) NOT NULL
);


CREATE TABLE Empleados (
    id INTEGER  NOT NULL PRIMARY KEY,
    IDCargo INTEGER NOT NULL,
    IDOficina INTEGER NOT NULL,
    CONSTRAINT EMPLEADO_CARGO_FK FOREIGN KEY (IDCargo) REFERENCES Cargos (IDCargo),
    CONSTRAINT EMPLEADO_OFICINA_FK FOREIGN KEY (IDOficina) REFERENCES Oficinas (IDOficina),
    CONSTRAINT EMPLEADO_PERSONA_FK FOREIGN KEY (ID) REFERENCES Personas (ID)
);



CREATE TABLE UsuariosEmpleados (
    id Number PRIMARY KEY,
    password VARCHAR2(10) NOT NULL,
    usuario VARCHAR2(80) NOT NULL,
    CONSTRAINT FK_empleado_usuarioEmpleado FOREIGN KEY (ID) REFERENCES Empleados (ID)
);

CREATE TABLE UsuariosClientes(
    id Number PRIMARY KEY,
    password VARCHAR2(10) NOT NULL,
    usuario VARCHAR2(80) NOT NULL,
    CONSTRAINT CLIENTE_PERSONA_FK FOREIGN KEY (ID) REFERENCES Clientes (ID)
);


CREATE TABLE Identificaciones (
    tipo VARCHAR2(10) ,
    numero INTEGER,
    PRIMARY KEY (numero )
);

CREATE TABLE PuntosAtencion (
    IDPuntoAtencion Integer PRIMARY KEY,
    Tipo VARCHAR2(50),
    UbicacionGeografica VARCHAR2(500),
    Estado INTEGER,
    IDOficina INTEGER,
    CONSTRAINT PUNTOATENCION_OFICINA_FK FOREIGN KEY (IDOficina) REFERENCES oficinas (IDOficina),
    CONSTRAINT tipoA CHECK(Tipo in ('Personalizada', 'CajeroAutomatico', 'Digital'))
);


CREATE TABLE OperacionesCuentas (
    IDOperacionCu Integer PRIMARY KEY,
    Monto float,
    Fecha Date,
    TipoOC VARCHAR2(20),
    idCuenta integer,
    idPuntoAtencion integer,
    CONSTRAINT TipoOC CHECK (TipoOC in ('Consignar', 'Retirar', 'Abrir Cuenta')),
    CONSTRAINT OperacionCuenta_CUENTA_FK FOREIGN KEY (idCuenta) REFERENCES Cuentas (idCuenta),
    CONSTRAINT OperacionCuenta_PUNTOATENCION_FK FOREIGN KEY (idPuntoAtencion) REFERENCES PuntosAtencion (idPuntoAtencion)
   
);

CREATE TABLE Prestamos (
    IDPrestamo INTEGER PRIMARY KEY,
    Monto INTEGER,
    Interes Float,
    NumeroCuotas INTEGER,
    DiaPagoCuota INTEGER,
    ValorCuota INTEGER,
    EstadoPrestamo VARCHAR2 (50),
    CONSTRAINT estadoP CHECK ( EstadoPrestamo in ('Solicitado', 'Aprobado', 'Rechazado', 'Pagado')),
    IDCliente Integer,
    CONSTRAINT PRESTAMO_CLIENTE_FK FOREIGN KEY (IDCliente) REFERENCES Clientes (ID)
    
);


CREATE TABLE OperacionesPrestamos(
    IDOperacionPrestamo INTEGER PRIMARY KEY,
    Tipo VARCHAR2 (50),
    CONSTRAINT tipoP CHECK (Tipo in ('Solicitar', 'Aprobar', 'Rechazar', 'Pagar Cuota', ' Pagar Cuota Extraordinaria', 'Pagar Cuota Ordinaria', 'Cerrar')),
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

/*DROP TABLE usuariosempleados;
DROP TABLE usuariosclientes;
DROP TABLE identificaciones;
DROP TABLE puntosatencion;
DROP TABLE operacionescuentas;
DROP TABLE prestamos;
DROP TABLE operacionesprestamos;
DROP TABLE operacionestransferencias;
DROP TABLE clientes;
DROP TABLE empleados;
DROP TABLE cargos;
DROP TABLE oficinas;
DROP TABLE personas;
DROP TABLE cuentas; */