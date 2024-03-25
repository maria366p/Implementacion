package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Prestamo;


public interface PrestamoRepository extends JpaRepository<Prestamo, Integer>{
     @Query(value = "SELECT * FROM PRESTAMOS", nativeQuery = true)
        Collection<Prestamo> darPrestamos();

    @Query(value = "SELECT * FROM PRESTAMOS WHERE IDPRESTAMO = :IDPRESTAMO", nativeQuery = true)
    Prestamo darPrestamo(@Param("IDPRESTAMO") int IDPRESTAMO);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PRESTAMOS (IDPRESTAMO, MONTO, INTERES, NUMEROCUOTAS, DIAPAGOCUOTA, VALORCUOTA, ESTADOP, IDCLIENTE) VALUES (operacionestransferencias_sequence.NEXTVAL, :MONTO, :INTERES, :NUMEROCUOTAS, :DIAPAGOCUOTA, :VALORCUOTA, :ESTADOP, :IDCLIENTE)", nativeQuery=true)
        void insertarPrestamo( @Param("MONTO") float MONTO, @Param("INTERES") Float  INTERES, @Param("NUMEROCUOTAS") int NUMEROCUOTAS,  @Param("DIAPAGOCUOTA") Date DIAPAGOCUOTA, @Param("VALORCUOTA") int VALORCUOTA, @Param("ESTADOP") String ESTADOP, @Param("IDCLIENTE") int IDCLIENTE);

    @Modifying
    @Transactional 
    @Query(value = "UPDATE PRESTAMOS SET  MONTO = :MONTO, INTERES = :INTERES, NUMEROCUOTAS = :NUMEROCUOTAS, DIAPAGOCUOTA =:DIAPAGOCUOTA, VALORCUOTA = :VALORCUOTA, ESTADOP = :ESTADOP, IDCLIENTE = :IDCLIENTE WHERE IDPRESTAMO = :IDPRESTAMO", nativeQuery=true)
        void actualizarPrestamo(@Param("IDPRESTAMO") int IDPRESTAMO, @Param("MONTO") float MONTO, @Param("INTERES") Float  INTERES,  @Param("NUMEROCUOTAS") int NUMEROCUOTAS, @Param("DIAPAGOCUOTA") Date DIAPAGOCUOTA, @Param("VALORCUOTA") int VALORCUOTA, @Param("ESTADOP") String ESTADOP, @Param("IDCLIENTE") int IDCLIENTE );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PRESTAMOS WHERE IDPRESTAMO = :IDPRESTAMO", nativeQuery=true)
        void eliminarPrestamo(@Param("IDPRESTAMO") int IDPRESTAMO);
}
