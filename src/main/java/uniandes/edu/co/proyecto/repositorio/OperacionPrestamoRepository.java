package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OperacionPrestamo;
import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.modelo.PuntoAtencion;
import uniandes.edu.co.proyecto.modelo.TipoOP;

@Repository
public interface OperacionPrestamoRepository extends JpaRepository<OperacionPrestamo, Integer>{

    @Query(value = "SELECT * From OperacionesPrestamo", nativeQuery = true)
    Collection<OperacionPrestamoRepository>  darOperacionesPrestamo();

    @Query(value = "SELECT * From OperacionesPrestamo WHERE id = :id", nativeQuery = true)
    OperacionPrestamoRepository darOperacionPrestamo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OperacionesPrestamo (id, FK_PuntoAtencion, FK_prestamo, tipoOperacion, fecha, valor) VALUES (bancandes_sequence.nextval, : :FK_PuntoAtencion, :FK_prestamo, :tipoOperacion, :fecha, :valor)", nativeQuery=true)
    void insertarOperacionPrestamo(@Param("id") int id, @Param("FK_PuntoAtencion") PuntoAtencion FK_PuntoAtencion, @Param("FK_prestamo") Prestamo FK_prestamo, @Param("tipoOperacion") TipoOP tipoOperacion, @Param("fecha") Date fecha, @Param("valor") int valor);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OperacionesPrestamo SET FK_cliente_persona = :FK_cliente_persona, FK_oficina = :FK_oficina, FK_empleado = :FK_empleado, FK_prestamo = :FK_prestamo, tipoOperacion = :tipoOperacion, fecha = :fecha, valor = :valor WHERE id = :id", nativeQuery=true)
    void actualizarOperacionPrestamo(@Param("id") int id, @Param("FK_cliente_persona") int FK_cliente_persona, @Param("FK_oficina") int FK_oficina, @Param("FK_empleado") int FK_empleado, @Param("FK_prestamo") int FK_prestamo, @Param("tipoOperacion") String tipoOperacion, @Param("fecha") Date fecha, @Param("valor") int valor);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OperacionesPrestamo WHERE id = :id", nativeQuery=true)
    void eliminarOperacionPrestamo(@Param("id") int id);
    
}

