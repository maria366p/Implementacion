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

    @Query(value = "SELECT * \r\n" + //
                "FROM CUENTAS C\r\n" + //
                "WHERE C.IDGERENTE = :IDGERENTE", nativeQuery = true)
        Collection<Cuenta> darCuentasIDGer(@Param("IDGERENTE") Integer IDGERENTE);

    @Query(value = "SELECT * \r\n" + //
        "FROM CUENTAS C\r\n"+
        "WHERE IDCLIENTE = :IDCLIENTE" //
        , nativeQuery = true)
        Collection<Cuenta> darCuentasC(@Param("IDCLIENTE") int IDCLIENTE);

    @Query(value = "SELECT * \r\n" + //
    "FROM CUENTAS C\r\n"
    , nativeQuery = true)
    Collection<Cuenta> darCuentas();    
    

    @Query(value = "SELECT * FROM CUENTAS C WHERE  C.IDCLIENTE = :ID AND C.TIPOCUENTA = :TIPOC AND C.SALDO >= :saldoMin AND C.SALDO <= :saldoMax AND C.FECHAULTIMATRANSACCION <= :fechaUltima", nativeQuery = true)
    Collection<Cuenta> darCuentasCF( @Param("ID") int ID, @Param("TIPOC") String TIPOC, @Param("saldoMin") int saldoMin, @Param("saldoMax") int saldoMax, @Param("fechaUltima") Date fechaUltima);

    @Query(value = "SELECT * FROM CUENTAS C WHERE  C.IDGERENTE = :ID AND C.TIPOCUENTA = :TIPOC AND C.SALDO >= :saldoMin AND C.SALDO <= :saldoMax AND C.FECHAULTIMATRANSACCION <= :fechaUltima", nativeQuery = true)
    Collection<Cuenta> darCuentasEF( @Param("ID") int ID, @Param("TIPOC") String TIPOC, @Param("saldoMin") int saldoMin, @Param("saldoMax") int saldoMax, @Param("fechaUltima") Date fechaUltima);


    

    @Query(value = "SELECT * FROM CUENTAS WHERE IDCUENTA = :IDCUENTA", nativeQuery = true)
    Cuenta darCuenta(@Param("IDCUENTA") int IDCUENTA);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CUENTAS (IDCUENTA, TIPOCUENTA, SALDO, FECHAULTIMATRANSACCION, IDCLIENTE, ESTADOCUENTA, IDGERENTE) VALUES (cuentas_sequence.NEXTVAL, :TIPOCUENTA, :SALDO, :FECHAULTIMATRANSACCION, :IDCLIENTE, :ESTADOCUENTA, :IDGERENTE)", nativeQuery=true)
        void insertarCuenta(@Param("TIPOCUENTA") String TIPOCUENTA, @Param("SALDO") Float SALDO, @Param("FECHAULTIMATRANSACCION") Date  FECHAULTIMATRANSACCION,  @Param("IDCLIENTE") int IDCLIENTE, @Param("ESTADOCUENTA") String ESTADOCUENTA,  @Param("IDGERENTE") int IDGERENTE);

    @Modifying
    @Transactional 
    @Query(value = "UPDATE CUENTAS SET TIPOCUENTA = :TIPOCUENTA, SALDO = :SALDO, FECHAULTIMATRANSACCION = :FECHAULTIMATRANSACCION, IDCLIENTE = :IDCLIENTE, ESTADOCUENTA = :ESTADOCUENTA, IDGERENTE = :IDGERENTE WHERE IDCUENTA = :IDCUENTA", nativeQuery=true)
        void actualizarCuenta(@Param("IDCUENTA") int IDCUENTA,@Param("TIPOCUENTA") String TIPOCUENTA, @Param("SALDO") Float SALDO, @Param("FECHAULTIMATRANSACCION") Date  FECHAULTIMATRANSACCION,  @Param("IDCLIENTE") int IDCLIENTE, @Param("ESTADOCUENTA") String ESTADOCUENTA, @Param("IDGERENTE") int IDGERENTE);

    @Modifying
    @Transactional 
    @Query(value = "UPDATE CUENTAS SET  SALDO = :SALDO, ESTADOCUENTA = :ESTADOCUENTA WHERE IDCUENTA = :IDCUENTA", nativeQuery=true)
        void actualizarCuentaP(@Param("IDCUENTA") int IDCUENTA, @Param("SALDO") Float SALDO,  @Param("ESTADOCUENTA") String ESTADOCUENTA);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CUENTAS SET SALDO = SALDO + :SALDO WHERE IDCUENTA = :IDCUENTA ", nativeQuery = true)
    void consignarSaldo(@Param("IDCUENTA") Integer IDCUENTA, @Param("SALDO") Float SALDO) ;


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CUENTAS WHERE IDCUENTA = :IDCUENTA", nativeQuery=true)
        void eliminarCuenta(@Param("IDCUENTA") int IDCUENTA);

    @Query(value = "SELECT c.SALDO\r\n" + //
        "FROM CUENTAS C\r\n" + //
        "WHERE C.IDCUENTA = :IDCUENTA ", nativeQuery = true)
    int darSaldo(@Param("IDCUENTA") Integer IDCUENTA);



    @Modifying
    @Transactional 
    @Query(value = "UPDATE cuentas\r\n" + //
        "SET SALDO = SALDO - :SALDO\r\n" + //
        "WHERE IDCUENTA = :IDCUENTA ", nativeQuery = true)
    void retirarSaldo(@Param("IDCUENTA") Integer IDCUENTA, @Param("SALDO") Float SALDO) ;





    
} 