--SESION 2
SET AUTOCOMMIT OFF;

--t4
SET TRANSACTION ISOLATION LEVEL READ COMMITTED;

--t6
UPDATE Cuentas
SET Saldo = Saldo - 30000
WHERE IDCuenta = 101;

--t8
INSERT INTO OperacionesCuentas (IDOperacionCu, Monto, Fecha, TipoOC, idCuenta, idPuntoAtencion) VALUES 
(operacionescuentas_sequence.nextval,30000, TO_DATE('2024-04-28', 'YYYY-MM-DD'),'Retirar',101,4 )

--t9
UPDATE Cuentas
SET Saldo = Saldo - 5000
WHERE IDCuenta = 104;

--t10
INSERT INTO OperacionesCuentas (IDOperacionCu, Monto, Fecha, TipoOC, idCuenta, idPuntoAtencion) VALUES (operacionescuentas_sequence.nextval,
5000, TO_DATE('2024-04-28', 'YYYY-MM-DD'),'Consignar',104,5 )

--t12
COMMIT

--t13
SELECT SALDO
FROM CUENTAS 
WHERE IDCUENTA = 101

SELECT SALDO
FROM CUENTAS 
WHERE IDCUENTA = 104