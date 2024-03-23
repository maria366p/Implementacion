package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.OperacionPrestamo;

public interface OperacionPrestamoRepository extends JpaRepository<OperacionPrestamo, Integer>  {

    @Query(value = "SELECT * FROM OPERACIONESPRESTAMOS", nativeQuery = true)
        Collection<OperacionPrestamo> darOperacionPrestamos();

    @Query(value = "SELECT * FROM OPERACIONESPRESTAMOS WHERE IDOPERACIONPRESTAMO = :IDOPERACIONPRESTAMO", nativeQuery = true)
    OperacionPrestamo darOperacionPrestamo(@Param("IDOPERACIONPRESTAMO") int IDOPERACIONPRESTAMO);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OPERACIONESPRESTAMOS (IDOPERACIONPRESTAMO, TIPO, MONTO, FECHA, IDPRESTAMO, IDPUNTOATENCION) VALUES (operacionesprestamos_sequence.NEXTVAL, :TIPO, :MONTO, :FECHA, :IDPRESTAMO, :IDPUNTOATENCION)", nativeQuery=true)
        void insertarOperacionPrestamo(@Param("TIPO") String TIPO, @Param("MONTO") float MONTO, @Param("FECHA") Date  FECHA, @Param("IDPRESTAMO") int IDPRESTAMO,  @Param("IDPUNTOATENCION") int IDPUNTOATENCION);

    @Modifying
    @Transactional 
    @Query(value = "UPDATE OPERACIONESPRESTAMOS SET TIPO = :TIPO, MONTO = :MONTO, FECHA = :FECHA, IDPRESTAMO = :IDPRESTAMO, IDPUNTOATENCION = :IDPUNTOATENCION WHERE IDOPERACIONPRESTAMO = :IDOPERACIONPRESTAMO", nativeQuery=true)
        void actualizarOperacionPrestamo(@Param("IDOPERACIONPRESTAMO") int IDOPERACIONPRESTAMO,@Param("TIPO") String TIPO, @Param("MONTO") float MONTO, @Param("FECHA") Date  FECHA,  @Param("IDPRESTAMO") int IDPRESTAMO, @Param("IDPUNTOATENCION") int IDPUNTOATENCION);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OPERACIONESPRESTAMOS WHERE IDOPERACIONPRESTAMO = :IDOPERACIONPRESTAMO", nativeQuery=true)
        void eliminarOperacionPrestamo(@Param("IDOPERACIONPRESTAMO") int IDOPERACIONPRESTAMO);
    
}
