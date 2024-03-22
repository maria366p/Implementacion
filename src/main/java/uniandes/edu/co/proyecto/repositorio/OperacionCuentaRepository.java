package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;

public interface OperacionCuentaRepository  extends JpaRepository<OperacionCuenta, Integer>{

    @Query(value = "SELECT * FROM OPERACIONESCUENTAS", nativeQuery = true)
        Collection<OperacionCuenta> darOperacionCuentas();

    @Query(value = "SELECT * FROM OPERACIONESCUENTAS WHERE IDOPERACIONCU = :IDOPERACIONCU", nativeQuery = true)
    OperacionCuenta darOperacionCuenta(@Param("IDOPERACIONCU") int IDOPERACIONCU);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OPERACIONESCUENTAS (IDOPERACIONCU, TIPOOC, MONTO, FECHA, IDCUENTA, IDPUNTOATENCION) VALUES (operacionescuentas_sequence.NEXTVAL, :TIPOOC, :MONTO, :FECHA, :IDCUENTA, :IDPUNTOATENCION)", nativeQuery=true)
        void insertarOperacionCuenta(@Param("TIPOOC") String TIPOOC, @Param("MONTO") Float MONTO, @Param("FECHA") Date  FECHA, @Param("IDCUENTA") int IDCUENTA,  @Param("IDPUNTOATENCION") int IDPUNTOATENCION);

    @Modifying
    @Transactional 
    @Query(value = "UPDATE OPERACIONESCUENTAS SET TIPOOC = :TIPOOC, MONTO = :MONTO, FECHA = :FECHA, IDCUENTA = :IDCUENTA, IDPUNTOATENCION = :IDPUNTOATENCION WHERE IDOPERACIONCU = :IDOPERACIONCU", nativeQuery=true)
        void actualizarOperacionCuenta(@Param("IDOPERACIONCU") int IDOPERACIONCU,@Param("TIPOOC") String TIPOOC, @Param("MONTO") Float MONTO, @Param("FECHA") Date  FECHA,  @Param("IDCUENTA") int IDCUENTA, @Param("IDPUNTOATENCION") int IDPUNTOATENCION);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OPERACIONESCUENTAS WHERE IDOPERACIONCU = :IDOPERACIONCU", nativeQuery=true)
        void eliminarOperacionCuenta(@Param("IDOPERACIONCU") int IDOPERACIONCU);
    
}
