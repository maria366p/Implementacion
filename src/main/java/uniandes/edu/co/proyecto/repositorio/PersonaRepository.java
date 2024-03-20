package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Identificacion;
import uniandes.edu.co.proyecto.modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    @Query(value = "SELECT * FROM PERSONAS", nativeQuery = true)
        Collection<Persona> darPersonas();

    @Query(value = "SELECT * FROM PERSONAS WHERE ID = :ID", nativeQuery = true)
    Persona darPersona(@Param("ID") int ID);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PERSONAS (ID, NOMBRE, DATOSCONTACTO, DIRECCIONFISICA, DIRECCIONELECTRONICA, TELEFONO, CIUDAD, DEPARTAMENTO, CODIGOPOSTAL, FECHAREGISTRO, DOCID ) VALUES (bancandes_sequence.nextval, :NOMBRE, :DATOSCONTACTO, :DIRECCIONFISICA, :DIRECCIONELECTRONICA, :TELEFONO, :CIUDAD, :DEPARTAMENTO, :CODIGOPOSTAL, :FECHAREGISTRO, :DOCID)", nativeQuery=true)
        void insertarPersona(@Param("NOMBRE") String NOMBRE, @Param("DATOSCONTACTO") String DATOSCONTACTO, @Param("DIRECCIONFISICA") String DIRECCIONFISICA,@Param("DIRECCIONELECTRONICA") String DIRECCIONELECTRONICA, @Param("TELEFONO") int TELEFONO,@Param("CIUDAD") String CIUDAD,@Param("DEPARTAMENTO") String DEPARTAMENTO,@Param("CODIGOPOSTAL") int codigoPostal,@Param("FECHAREGISTRO") Date FECHAREGISTRO, @Param("DOCID") Identificacion DOCID);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PERSONAS SET NOMBRE = :NOMBRE, DATOSCONTACTO = :DATOSCONTACTO, DIRECCIONFISICA = :DIRECCIONFISICA, DIRECCIONELECTRONICA = :DIRECCIONELECTRONICA, TELEFONO = :TELEFONO, CIUDAD = :CIUDAD, DEPARTAMENTO = :DEPARTAMENTO, CODIGOPOSTAL = :CODIGOPOSTAL, FECHAREGISTRO = :FECHAREGISTRO, DOCID = :DOCID WHERE ID = :ID", nativeQuery=true)
    void actualizarPersona(@Param("ID") int ID,@Param("NOMBRE") String NOMBRE, @Param("DATOSCONTACTO") String DATOSCONTACTO, @Param("DIRECCIONFISICA") String DIRECCIONFISICA,@Param("DIRECCIONELECTRONICA") String DIRECCIONELECTRONICA, @Param("TELEFONO") int TELEFONO,@Param("CIUDAD") String CIUDAD,@Param("DEPARTAMENTO") String DEPARTAMENTO,@Param("CODIGOPOSTAL") int codigoPostal,@Param("FECHAREGISTRO") Date FECHAREGISTRO, @Param("DOCID") Identificacion DOCID);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PERSONAS WHERE ID = :ID", nativeQuery=true)
    void eliminarPersona(@Param("ID") int ID);

}
