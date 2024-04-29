--SESION 1
SET AUTOCOMMIT OFF;

--t1
SET TRANSACTION ISOLATION LEVEL READ COMMITTED;

-- Actualizar saldo sumando 1 millón de pesos a la cuenta específica
--t2
UPDATE Cuentas
SET Saldo = Saldo + 1000000.00
WHERE IDCuenta = 101;

--Operacion Cuentas
--t3
INSERT INTO OperacionesCuentas (IDOperacionCu, Monto, Fecha, TipoOC, idCuenta, idPuntoAtencion) VALUES (11,1000000, TO_DATE('2024-04-28', 'YYYY-MM-DD'),'Consignar',101,4 )


--Actualizacion 
--t4
UPDATE Cuentas
SET Saldo = Saldo - 50000
WHERE IDCuenta = 104;

--t5
--Operacion Cuentas
INSERT INTO OperacionesCuentas (IDOperacionCu, Monto, Fecha, TipoOC, idCuenta, idPuntoAtencion) VALUES (12,50000, TO_DATE('2024-04-28', 'YYYY-MM-DD'),'Retirar',104,5 )

--t7
COMMIT

--t11
SELECT SALDO
FROM CUENTAS 
WHERE IDCUENTA = 101

SELECT SALDO
FROM CUENTAS 
WHERE IDCUENTA = 104

--t13
SELECT SALDO
FROM CUENTAS 
WHERE IDCUENTA = 101

SELECT SALDO
FROM CUENTAS 
WHERE IDCUENTA = 104