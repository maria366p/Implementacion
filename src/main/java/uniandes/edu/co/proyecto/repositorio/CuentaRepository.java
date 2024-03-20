package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.TipoCuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{

    
    @Query(value = "SELECT * From Cuentas", nativeQuery = true)
    Collection<Cuenta>  darCuentas();
    
    @Query(value = "SELECT * From Cuentas WHERE IDCuenta = :IDCuenta", nativeQuery = true)
    Cuenta darCuenta(@Param("IDCuenta")int IDCuenta);

    @Query(value = "SELECT * From Cuentas WHERE IDCliente = :IDCliente", nativeQuery = true)
    Collection<Cuenta> darCuentasCliente(@Param("IDCliente")int IDCliente);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Cuentas (IDCuenta, IDCliente, saldo, tipo) VALUES (bancandes_sequence.nextval, :IDCliente, :saldo, :tipo)", nativeQuery=true) 
    void insertarCuenta(@Param("IDCuenta") int IDCuenta, @Param("IDCliente") int IDCliente, @Param("saldo") float saldo, @Param("tipo") TipoCuenta tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Cuentas SET IDCliente = :IDCliente, saldo = :saldo, tipo = :tipo WHERE IDCuenta = :IDCuenta", nativeQuery=true)
    void actualizarCuenta(@Param("IDCuenta") int IDCuenta, @Param("IDCliente") int IDCliente, @Param("saldo") float saldo, @Param("tipo") TipoCuenta tipo);



    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Cuentas WHERE IDCuenta = :IDCuenta", nativeQuery=true)
    void eliminarCuenta(@Param("IDCuenta") int IDCuenta);

}
