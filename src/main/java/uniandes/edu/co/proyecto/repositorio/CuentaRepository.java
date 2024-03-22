package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta,Integer> {

    @Query(value = "SELECT * FROM CUENTAS", nativeQuery = true)
        Collection<Cuenta> darCuentas();

    @Query(value = "SELECT * FROM CUENTAS WHERE IDCUENTA = :IDCUENTA", nativeQuery = true)
    Cuenta darCuenta(@Param("IDCUENTA") int IDCUENTA);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CUENTAS (IDCUENTA, TIPOCUENTA, SALDO, FECHAULTIMATRANSACCION, IDCLIENTE, ESTADOCUENTA) VALUES (cuentas_sequence.NEXTVAL, :TIPOCUENTA, :SALDO, :FECHAULTIMATRANSACCION, :IDCLIENTE, :ESTADOCUENTA)", nativeQuery=true)
        void insertarCuenta(@Param("TIPOCUENTA") String TIPOCUENTA, @Param("SALDO") Float SALDO, @Param("FECHAULTIMATRANSACCION") Date  FECHAULTIMATRANSACCION,  @Param("IDCLIENTE") int IDCLIENTE, @Param("ESTADOCUENTA") String ESTADOCUENTA);

    @Modifying
    @Transactional 
    @Query(value = "UPDATE CUENTAS SET TIPOCUENTA = :TIPOCUENTA, SALDO = :SALDO, FECHAULTIMATRANSACCION = :FECHAULTIMATRANSACCION, IDCLIENTE = :IDCLIENTE, ESTADOCUENTA = :ESTADOCUENTA WHERE IDCUENTA = :IDCUENTA", nativeQuery=true)
        void actualizarCuenta(@Param("IDCUENTA") int IDCUENTA,@Param("TIPOCUENTA") String TIPOCUENTA, @Param("SALDO") Float SALDO, @Param("FECHAULTIMATRANSACCION") Date  FECHAULTIMATRANSACCION,  @Param("IDCLIENTE") int IDCLIENTE, @Param("ESTADOCUENTA") String ESTADOCUENTA);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CUENTAS WHERE IDCUENTA = :IDCUENTA", nativeQuery=true)
        void eliminarCuenta(@Param("IDCUENTA") int IDCUENTA);
    
} 