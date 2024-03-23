package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.OperacionTransferencia;

public interface OperacionTransferenciaRepository  extends JpaRepository<OperacionTransferencia, Integer>{
    @Query(value = "SELECT * FROM OPERACIONESTRANSFERENCIAS", nativeQuery = true)
        Collection<OperacionTransferencia> darOperacionTransferencias();

    @Query(value = "SELECT * FROM OPERACIONESTRANSFERENCIAS WHERE IDOPERACIONTRANS = :IDOPERACIONTRANS", nativeQuery = true)
    OperacionTransferencia darOperacionTransferencia(@Param("IDOPERACIONTRANS") int IDOPERACIONTRANS);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OPERACIONESTRANSFERENCIAS (IDOPERACIONTRANS, MONTO, FECHA, IDCUENTAORIGEN, IDCUENTADESTINO, IDPUNTOATENCION) VALUES (operacionestransferencias_sequence.NEXTVAL, :TIPO, :MONTO, :FECHA, :IDCUENTAORIGEN, :IDCUENTADESTINO, :IDPUNTOATENCION)", nativeQuery=true)
        void insertarOperacionTransferencia( @Param("MONTO") float MONTO, @Param("FECHA") Date  FECHA, @Param("IDCUENTAORIGEN") int IDCUENTAORIGEN,  @Param("IDCUENTADESTINO") int IDCUENTADESTINO, @Param("IDPUNTOATENCION") int IDPUNTOATENCION);

    @Modifying
    @Transactional 
    @Query(value = "UPDATE OPERACIONESTRANSFERENCIAS SET  MONTO = :MONTO, FECHA = :FECHA, IDCUENTAORIGEN = :IDCUENTAORIGEN, IDCUENTADESTINO =:IDCUENTADESTINO, IDPUNTOATENCION = :IDPUNTOATENCION WHERE IDOPERACIONTRANS = :IDOPERACIONTRANS", nativeQuery=true)
        void actualizarOperacionTransferencia(@Param("IDOPERACIONTRANS") int IDOPERACIONTRANS, @Param("MONTO") float MONTO, @Param("FECHA") Date  FECHA,  @Param("IDCUENTAORIGEN") int IDCUENTAORIGEN, @Param("IDCUENTADESTINO") int IDCUENTADESTINO, @Param("IDPUNTOATENCION") int IDPUNTOATENCION);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OPERACIONESTRANSFERENCIAS WHERE IDOPERACIONTRANS = :IDOPERACIONTRANS", nativeQuery=true)
        void eliminarOperacionTransferencia(@Param("IDOPERACIONTRANS") int IDOPERACIONTRANS);
    
    
} 
