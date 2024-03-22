package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.PuntoAtencion;

public interface PuntoAtencionRepository extends JpaRepository<PuntoAtencion, Integer> {

    @Query(value = "SELECT * FROM PUNTOSATENCION", nativeQuery = true)  //PuntoAtencion con oficina Null genera error cuando se quiere traer la oficina 
        Collection<PuntoAtencion> darPuntoAtencions();

    @Query(value = "SELECT * FROM PUNTOSATENCION WHERE IDPUNTOATENCION = :IDPUNTOATENCION", nativeQuery = true)
    PuntoAtencion darPuntoAtencion(@Param("IDPUNTOATENCION") int IDPUNTOATENCION);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PUNTOSATENCION (IDPUNTOATENCION, TIPO, UBICACIONGEOGRAFICA, ESTADO, IDOFICINA) VALUES (puntoatencion_sequence.NEXTVAL, :TIPO, :UBICACIONGEOGRAFICA, :ESTADO, :IDOFICINA)", nativeQuery=true)
        void insertarPuntoAtencion(@Param("TIPO") String TIPO, @Param("UBICACIONGEOGRAFICA") String UBICACIONGEOGRAFICA, @Param("ESTADO") String  ESTADO,  @Param("IDOFICINA") int IDOFICINA);

    @Modifying
    @Transactional 
    @Query(value = "UPDATE PUNTOSATENCION SET TIPO = :TIPO, UBICACIONGEOGRAFICA = :UBICACIONGEOGRAFICA, ESTADO = :ESTADO, IDOFICINA = :IDOFICINA WHERE IDPUNTOATENCION = :IDPUNTOATENCION", nativeQuery=true)
        void actualizarPuntoAtencion(@Param("IDPUNTOATENCION") int IDPUNTOATENCION,@Param("TIPO") String TIPO, @Param("UBICACIONGEOGRAFICA") String UBICACIONGEOGRAFICA, @Param("ESTADO") String  ESTADO,  @Param("IDOFICINA") int IDOFICINA);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PUNTOSATENCION WHERE IDPUNTOATENCION = :IDPUNTOATENCION", nativeQuery=true)
        void eliminarPuntoAtencion(@Param("IDPUNTOATENCION") int IDPUNTOATENCION);
    
}
