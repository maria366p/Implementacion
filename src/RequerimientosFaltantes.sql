--Crear CUENTA -- 
INSERT INTO Cuentas (IDCuenta, TipoCuenta, Saldo, FechaUltimaTransaccion, idCliente, EstadoCuenta) VALUES (cuentas_sequence.nextval, 'Ahorros', 5000.00, TO_DATE('2024-03-10', 'YYYY-MM-DD'), 1, 'Activa');

--Para cambiar el estado a CUENTA "Cerrada"-

UPDATE Cuentas
SET Saldo = 0
WHERE IDCuenta = 101;

UPDATE Cuentas
SET EstadoCuenta = 'Cerrada'
WHERE IDCuenta = 101 AND Saldo = 0 AND EstadoCuenta = 'Activa';

--Para cambiar el estado a "Desactivada"
UPDATE Cuentas 
SET EstadoCuenta = 'Desactivada'
WHERE IDCuenta = 102 AND EstadoCuenta = 'Activa';

--REGISTRAR OPERACIÓN SOBRE CUENTA -
--Insertar un registro de operacion---

INSERT INTO OperacionesCuentas (IDOperacionCu, Monto, Fecha, TipoOC, idCuenta, idPuntoAtencion)
VALUES (operacionescuentas_sequence.nextval, 500.00, SYSDATE, 'Consignar', 101, 1);

--Actualizar cuenta consignacion--
UPDATE Cuentas
SET Saldo = Saldo + 500.00
WHERE IDCuenta = 101;

--Actualizar cuenta retiro--
UPDATE Cuentas
SET Saldo = Saldo - 200.00
WHERE IDCuenta = 102 AND Saldo >= 200.00;

--CREAR PRÉSTAMO--
--Insertar nuevo prestamo--
INSERT INTO Prestamos (IDPrestamo, Monto, Interes, NumeroCuotas, DiaPagoCuota, ValorCuota, EstadoP, IDCliente)
VALUES (prestamos_sequence.nextval, 25000, 0.07, 36, TO_DATE('2024-04-20', 'YYYY-MM-DD'), 950, 'Aprobado', 5);


--REGISTRO DE OPERACIÓN SOBRE PRÉSTAMO--
--Registrar la operación de préstamo--
INSERT INTO OperacionesPrestamos (IDOperacionPrestamo, Tipo, Monto, Fecha, IDPrestamo, IDPuntoAtencion)
VALUES (operacionesprestamos_sequence.nextval, 'PagarCuotaOrdinaria', 950, TO_DATE('2024-04-20', 'YYYY-MM-DD'), 5, 1);

--Actualizar el saldo del préstamo--
UPDATE Prestamos
SET Monto = Monto - 950
WHERE IDPrestamo = 5;

--Actualizar el saldo del préstamo a 0--
UPDATE Prestamos
SET Monto = 0 
WHERE IDPrestamo = 5;


--ACTUALIZAR PRÉSTAMO A CERRADO --
UPDATE Prestamos
SET EstadoP = 'Cerrado'
WHERE IDPrestamo = 5 AND Monto = 0;


--CONSULTAR LAS CUENTAS EN BANCANDES  --

--Por un cliente--
SELECT c.IDCuenta, c.TipoCuenta, c.Saldo, c.FechaUltimaTransaccion, c.EstadoCuenta
FROM Cuentas c
WHERE c.idCliente = 1;

--Gerente de Oficina --
SELECT IDOficina 
FROM Empleados 
WHERE IDEmpleado = 2;

--gerente trabaja en IDOFICINA = 1, obtener las cuentas--
SELECT DISTINCT c.IDCuenta, c.TipoCuenta, c.Saldo, c.FechaUltimaTransaccion, c.EstadoCuenta
FROM Cuentas c
JOIN OperacionesCuentas oc ON c.IDCuenta = oc.idCuenta
JOIN PuntosAtencion pa ON oc.idPuntoAtencion = pa.IDPuntoAtencion
WHERE pa.IDOficina = (SELECT IDOficina 
FROM Empleados 
WHERE IDEmpleado = 2)

--Gerente General--
--El gerente general puede ver todas las cuentas sin restricciones. Dado que el gerente general tiene un IDCargo = 1--
SELECT c.IDCuenta, c.TipoCuenta, c.Saldo, c.FechaUltimaTransaccion, c.EstadoCuenta
FROM Cuentas c;
--todas las cuentas disponibles en la base de datos sin restricciones--

--CONSULTAR UN CLIENTE--
--Asumir IDCLIENTE = 1--
--Obtener info basica del cliente--
SELECT cli.IDCliente, cli.rolC, p.nombre, p.datosContacto, p.direccionFisica, p.direccionElectronica, p.telefono, p.ciudad, p.departamento, p.codigoPostal, p.fechaRegistro
FROM Clientes cli
JOIN Personas p ON cli.IDCliente = p.ID
WHERE cli.IDCliente = 1;

--Cuentas del cliente--
SELECT c.IDCuenta, c.TipoCuenta, c.Saldo, c.FechaUltimaTransaccion, c.EstadoCuenta
FROM Cuentas c
WHERE c.idCliente = 1;

--Oficinas donde cliente tiene las cuentas--
SELECT DISTINCT o.IDOficina, o.Nombre, o.Direccion
FROM Oficinas o
JOIN PuntosAtencion pa ON o.IDOficina = pa.IDOficina
JOIN OperacionesCuentas oc ON pa.IDPuntoAtencion = oc.idPuntoAtencion
JOIN Cuentas c ON oc.idCuenta = c.IDCuenta
WHERE c.idCliente = 1;

--Prestamos del cliente--
SELECT pr.IDPrestamo, pr.Monto, pr.Interes, pr.NumeroCuotas, pr.DiaPagoCuota, pr.ValorCuota, pr.EstadoP
FROM Prestamos pr
WHERE pr.IDCliente = 1;






