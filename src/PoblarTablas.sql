-- Insert para la tabla Cargos
INSERT INTO Cargos (IDCargo, Nombre) VALUES (1, 'GerenteGeneral');
INSERT INTO Cargos (IDCargo, Nombre) VALUES (2, 'GerenteOficina');
INSERT INTO Cargos (IDCargo, Nombre) VALUES (3, 'Cajero');
INSERT INTO Cargos (IDCargo, Nombre) VALUES (4, 'Asistente');
INSERT INTO Cargos (IDCargo, Nombre) VALUES (5, 'Analista Financiero');
INSERT INTO Cargos (IDCargo, Nombre) VALUES (4, 'Cajero');
INSERT INTO Cargos (IDCargo, Nombre) VALUES (5, 'GerenteOficina');


-- Insert para la tabla Identificaciones
INSERT INTO Identificaciones (tipo, numero) VALUES ('cc', 123456789);
INSERT INTO Identificaciones (tipo, numero) VALUES ('cc', 987654321);
INSERT INTO Identificaciones (tipo, numero) VALUES ('cc', 246810121);
INSERT INTO Identificaciones (tipo, numero) VALUES ('ti', 135791113);
INSERT INTO Identificaciones (tipo, numero) VALUES ('cc', 121212121);
INSERT INTO Identificaciones (tipo, numero) VALUES ('cc', 343434343);
INSERT INTO Identificaciones (tipo, numero) VALUES ('cc', 454545454);


-- Insert para la tabla Personas
INSERT INTO Personas (ID, nombre, datosContacto, direccionFisica, direccionElectronica, telefono, ciudad, departamento, codigoPostal, fechaRegistro, docId) VALUES (1, 'Juan Perez', 'juan.perez@example.com', 'Calle 123', 'juan.perez@example.com', 123456789, 'Bogotá', 'Cundinamarca', 11001, TO_DATE('2022-01-01', 'YYYY-MM-DD'), 123456789);
INSERT INTO Personas (ID, nombre, datosContacto, direccionFisica, direccionElectronica, telefono, ciudad, departamento, codigoPostal, fechaRegistro, docId) VALUES (2, 'Maria Lopez', 'maria.lopez@example.com', 'Avenida 45', 'maria.lopez@example.com', 987654321, 'Medellín', 'Antioquia', 50001, TO_DATE('2022-02-01', 'YYYY-MM-DD'), 987654321);
INSERT INTO Personas (ID, nombre, datosContacto, direccionFisica, direccionElectronica, telefono, ciudad, departamento, codigoPostal, fechaRegistro, docId) VALUES (3, 'Carlos Gomez', 'carlos.gomez@example.com', 'Diagonal 76', 'carlos.gomez@example.com', 654321987, 'Cali', 'Valle del Cauca', 76001, TO_DATE('2022-03-01', 'YYYY-MM-DD'), 246810121);
INSERT INTO Personas (ID, nombre, datosContacto, direccionFisica, direccionElectronica, telefono, ciudad, departamento, codigoPostal, fechaRegistro, docId) VALUES (4, 'Ana Torres', 'ana.torres@example.com', 'Carrera 80', 'ana.torres@example.com', 321654987, 'Barranquilla', 'Atlántico', 08001, TO_DATE('2022-04-01', 'YYYY-MM-DD'), 135791113);
INSERT INTO Personas (ID, nombre, datosContacto, direccionFisica, direccionElectronica, telefono, ciudad, departamento, codigoPostal, fechaRegistro, docId) VALUES (5, 'Luis Mendez', 'luis.mendez@example.com', 'Transversal 92', 'luis.mendez@example.com', 258963147, 'Bucaramanga', 'Santander', 68001, TO_DATE('2022-05-01', 'YYYY-MM-DD'), 121212121);
INSERT INTO Personas (ID, nombre, datosContacto, direccionFisica, direccionElectronica, telefono, ciudad, departamento, codigoPostal, fechaRegistro, docId) VALUES (6, 'Carlos Ruiz', 'carlos.ruiz@example.com', 'Avenida 30', 'carlos.ruiz@example.com', 477854321, 'Cali', 'Valle del Cauca', 76001, TO_DATE('2021-10-22', 'YYYY-MM-DD'), 343434343);
INSERT INTO Personas (ID, nombre, datosContacto, direccionFisica, direccionElectronica, telefono, ciudad, departamento, codigoPostal, fechaRegistro, docId) VALUES (7, 'Diana Gómez', 'diana.gomez@example.com', 'Carrera 5', 'diana.gomez@example.com', 589631474, 'Cartagena', 'Bolivar', 13001, TO_DATE('2022-01-30', 'YYYY-MM-DD'), 454545454);

-- Insert para la tabla Clientes
INSERT INTO Clientes (IDCliente, rolC) VALUES (1, 'Natural');
INSERT INTO Clientes (IDCliente, rolC) VALUES (2, 'Juridico');
INSERT INTO Clientes (IDCliente, rolC) VALUES (3, 'Natural');
INSERT INTO Clientes (IDCliente, rolC) VALUES (4, 'Juridico');
INSERT INTO Clientes (IDCliente, rolC) VALUES (5, 'Natural');


-- Insert para la tabla Oficinas
INSERT INTO Oficinas (IDOficina, Nombre, Direccion) VALUES (1, 'Oficina Principal', 'Calle Principal 123');
INSERT INTO Oficinas (IDOficina, Nombre, Direccion) VALUES (2, 'Sucursal Norte', 'Avenida Norte 456');
INSERT INTO Oficinas (IDOficina, Nombre, Direccion) VALUES (3, 'Sucursal Sur', 'Carrera Sur 789');
INSERT INTO Oficinas (IDOficina, Nombre, Direccion) VALUES (4, 'Sucursal Este', 'Diagonal Este 101');
INSERT INTO Oficinas (IDOficina, Nombre, Direccion) VALUES (5, 'Sucursal Oeste', 'Transversal Oeste 202');

-- Insert para la tabla Empleados
INSERT INTO Empleados (IDEMPLEADO, IDCargo, IDOficina) VALUES (1, 1, 1);
INSERT INTO Empleados (IDEMPLEADO, IDCargo, IDOficina) VALUES (2, 2, 1);
INSERT INTO Empleados (IDEMPLEADO, IDCargo, IDOficina) VALUES (3, 3, 1);
INSERT INTO Empleados (IDEMPLEADO, IDCargo, IDOficina) VALUES (6, 4, 2);
INSERT INTO Empleados (IDEMPLEADO, IDCargo, IDOficina) VALUES (7, 5, 2);

-- Insert para la tabla UsuariosEmpleados
INSERT INTO UsuariosEmpleados (ID, password) VALUES (1, 'clave123');
INSERT INTO UsuariosEmpleados (ID, password) VALUES (2, 'clave456');
INSERT INTO UsuariosEmpleados (ID, password) VALUES (3, 'clave789');
INSERT INTO UsuariosEmpleados (ID, password) VALUES (6, 'clave887');
INSERT INTO UsuariosEmpleados (ID, password) VALUES (7, 'clave907');


-- Insert para la tabla UsuariosClientes
INSERT INTO UsuariosClientes (id, password) VALUES (4, 'pass012');
INSERT INTO UsuariosClientes (id, password) VALUES (5, 'pass345');



-- Insert para la tabla PuntosAtencion
INSERT INTO PuntosAtencion (IDPuntoAtencion, Tipo, UbicacionGeografica, Estado, IDOficina) VALUES (1, 'Personalizada', 'Centro Comercial 1', 'en revision', 1);
INSERT INTO PuntosAtencion (IDPuntoAtencion, Tipo, UbicacionGeografica, Estado, IDOficina) VALUES (2, 'CajeroAutomatico', 'Calle 50 con 10', 'mantenimiento', 1);
INSERT INTO PuntosAtencion (IDPuntoAtencion, Tipo, UbicacionGeografica, Estado, IDOficina) VALUES (3, 'Digital', 'Internet', 'funcionando', NULL);
INSERT INTO PuntosAtencion (IDPuntoAtencion, Tipo, UbicacionGeografica, Estado, IDOficina) VALUES (4, 'Personalizada', 'Centro Comercial 2', 'funcionando', 2);
INSERT INTO PuntosAtencion (IDPuntoAtencion, Tipo, UbicacionGeografica, Estado, IDOficina) VALUES (5, 'CajeroAutomatico', 'Calle 90 con 15', 'funcionando', 2);

-- Insert para la tabla OperacionesCuentas
INSERT INTO OperacionesCuentas (IDOperacionCu, Monto, Fecha, TipoOC, idCuenta, idPuntoAtencion) VALUES (1, 500.00, TO_DATE('2023-03-15', 'YYYY-MM-DD'), 'Consignar', 101, 1);
INSERT INTO OperacionesCuentas (IDOperacionCu, Monto, Fecha, TipoOC, idCuenta, idPuntoAtencion) VALUES (2, 200.00, TO_DATE('2023-03-16', 'YYYY-MM-DD'), 'Retirar', 102, 2);
INSERT INTO OperacionesCuentas (IDOperacionCu, Monto, Fecha, TipoOC, idCuenta, idPuntoAtencion) VALUES (3, 1000.00, TO_DATE('2023-03-17', 'YYYY-MM-DD'), 'Consignar', 103, 1);
INSERT INTO OperacionesCuentas (IDOperacionCu, Monto, Fecha, TipoOC, idCuenta, idPuntoAtencion) VALUES (4, 300.00, TO_DATE('2023-03-18', 'YYYY-MM-DD'), 'Retirar', 104, 2);
INSERT INTO OperacionesCuentas (IDOperacionCu, Monto, Fecha, TipoOC, idCuenta, idPuntoAtencion) VALUES (5, 1500.00, TO_DATE('2023-03-19', 'YYYY-MM-DD'), 'Consignar', 105, 1);

-- Insert para la tabla Prestamos
INSERT INTO Prestamos (IDPrestamo, Monto, Interes, NumeroCuotas, DiaPagoCuota, ValorCuota, EstadoP, IDCliente) VALUES (1, 10000, 0.05, 12, TO_DATE('2023-01-15', 'YYYY-MM-DD'), 850, 'Aprobado', 1);
INSERT INTO Prestamos (IDPrestamo, Monto, Interes, NumeroCuotas, DiaPagoCuota, ValorCuota, EstadoP, IDCliente) VALUES (2, 20000, 0.05, 24, TO_DATE('2023-02-15', 'YYYY-MM-DD'), 900, 'Aprobado', 2);
INSERT INTO Prestamos (IDPrestamo, Monto, Interes, NumeroCuotas, DiaPagoCuota, ValorCuota, EstadoP, IDCliente) VALUES (3, 15000, 0.05, 12, TO_DATE('2023-03-15', 'YYYY-MM-DD'), 1300, 'Aprobado', 3);
INSERT INTO Prestamos (IDPrestamo, Monto, Interes, NumeroCuotas, DiaPagoCuota, ValorCuota, EstadoP, IDCliente) VALUES (4, 5000, 0.05, 6, TO_DATE('2023-04-15', 'YYYY-MM-DD'), 850, 'Aprobado', 4);
INSERT INTO Prestamos (IDPrestamo, Monto, Interes, NumeroCuotas, DiaPagoCuota, ValorCuota, EstadoP, IDCliente) VALUES (5, 8000, 0.05, 10, TO_DATE('2023-05-15', 'YYYY-MM-DD'), 820, 'Aprobado', 5);

-- Insert para la tabla OperacionesPrestamos
INSERT INTO OperacionesPrestamos (IDOperacionPrestamo, Tipo, Monto, Fecha, IDPrestamo, IDPuntoAtencion) VALUES (1, 'PagarCuota', 850, TO_DATE('2023-04-15', 'YYYY-MM-DD'), 1, 1);
INSERT INTO OperacionesPrestamos (IDOperacionPrestamo, Tipo, Monto, Fecha, IDPrestamo, IDPuntoAtencion) VALUES (2, 'PagarCuota', 900, TO_DATE('2023-04-15', 'YYYY-MM-DD'), 2, 2);
INSERT INTO OperacionesPrestamos (IDOperacionPrestamo, Tipo, Monto, Fecha, IDPrestamo, IDPuntoAtencion) VALUES (3, 'PagarCuota', 1300, TO_DATE('2023-04-15', 'YYYY-MM-DD'), 3, 3);
INSERT INTO OperacionesPrestamos (IDOperacionPrestamo, Tipo, Monto, Fecha, IDPrestamo, IDPuntoAtencion) VALUES (4, 'PagarCuota', 850, TO_DATE('2023-04-15', 'YYYY-MM-DD'), 4, 4);


-- Insert para la tabla Cuentas
INSERT INTO Cuentas (IDCuenta, TipoCuenta, Saldo, FechaUltimaTransaccion, idCliente, EstadoCuenta) VALUES (101, 'Ahorros', 5000.00, TO_DATE('2024-03-10', 'YYYY-MM-DD'), 1, 'Activa');
INSERT INTO Cuentas (IDCuenta, TipoCuenta, Saldo, FechaUltimaTransaccion, idCliente, EstadoCuenta) VALUES (102, 'Corriente', 10000.00, TO_DATE('2024-03-11', 'YYYY-MM-DD'), 2, 'Activa');
INSERT INTO Cuentas (IDCuenta, TipoCuenta, Saldo, FechaUltimaTransaccion, idCliente, EstadoCuenta) VALUES (103, 'AFC', 20000.00, TO_DATE('2024-03-12', 'YYYY-MM-DD'), 3, 'Activa');
INSERT INTO Cuentas (IDCuenta, TipoCuenta, Saldo, FechaUltimaTransaccion, idCliente, EstadoCuenta) VALUES (104, 'Ahorros', 15000.00, TO_DATE('2024-03-13', 'YYYY-MM-DD'), 4, 'Desactivada');
INSERT INTO Cuentas (IDCuenta, TipoCuenta, Saldo, FechaUltimaTransaccion, idCliente, EstadoCuenta) VALUES (105, 'Corriente', 30000.00, TO_DATE('2024-03-14', 'YYYY-MM-DD'), 5, 'Cerrada');

-- Insert para la tabla OperacionesTransferencias
INSERT INTO OperacionesTransferencias (IDOperacionTrans, Monto, Fecha, IDCuentaOrigen, IDCuentaDestino, IDPuntoAtencion) VALUES (1, 100.50, TO_DATE('2024-03-22', 'YYYY-MM-DD'), 101, 102, 3);
INSERT INTO OperacionesTransferencias (IDOperacionTrans, Monto, Fecha, IDCuentaOrigen, IDCuentaDestino, IDPuntoAtencion) VALUES (2, 250.00, TO_DATE('2024-03-20', 'YYYY-MM-DD'), 102, 103, 4);
INSERT INTO OperacionesTransferencias (IDOperacionTrans, Monto, Fecha, IDCuentaOrigen, IDCuentaDestino, IDPuntoAtencion) VALUES (3, 75.25, TO_DATE('2024-03-21', 'YYYY-MM-DD'), 103, 104, 5);
INSERT INTO OperacionesTransferencias (IDOperacionTrans, Monto, Fecha, IDCuentaOrigen, IDCuentaDestino, IDPuntoAtencion) VALUES (4, 500.00, TO_DATE('2024-03-19', 'YYYY-MM-DD'), 104, 105, 1);
INSERT INTO OperacionesTransferencias (IDOperacionTrans, Monto, Fecha, IDCuentaOrigen, IDCuentaDestino, IDPuntoAtencion) VALUES (5, 200.00, TO_DATE('2024-03-18', 'YYYY-MM-DD'), 105, 101, 2);