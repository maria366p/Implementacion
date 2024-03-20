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

    @Query(value = "SELECT * FROM Personas", nativeQuery = true)
        Collection<Persona> darPersonas();

    @Query(value = "SELECT * FROM Personas WHERE ID = :ID", nativeQuery = true)
    Persona darPersona(@Param("ID") int ID);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Personas (ID, nombre, datosContacto, direccionFisica, direccionElectronica, telefono, ciudad, departamento, codigoPostal, fechaRegistro, identificacion) VALUES (bancandes_sequence.nextval, :nombre, :datosContacto, :direccionFisica, :direccionElectronica, :telefono, :ciudad, :departamento, :codigoPostal, :fechaRegistro, :identificacion)", nativeQuery=true)
        void insertarPersona(@Param("nombre") String nombre, @Param("datosContacto") String datosContacto, @Param("direccionFisica") String direccionFisica,@Param("direccionElectronica") String direccionElectronica, @Param("telefono") int telefono,@Param("ciudad") String ciudad,@Param("departamento") String departamento,@Param("codigoPostal") int codigoPostal,@Param("fechaRegistro") Date fechaRegistro, @Param("identificacion") Identificacion identificacion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Personas SET nombre = :nombre, datosContacto = :datosContacto, direccionFisica = :direccionFisica, direccionElectronica = :direccionElectronica, telefono = :telefono, ciudad = :ciudad, departamento = :departamento, codigoPostal = :codigoPostal, fechaRegistro = :fechaRegistro, identificacion = :identificacion WHERE ID = :ID", nativeQuery=true)
    void actualizarPersona(@Param("ID") int ID,@Param("nombre") String nombre, @Param("datosContacto") String datosContacto, @Param("direccionFisica") String direccionFisica,@Param("direccionElectronica") String direccionElectronica, @Param("telefono") int telefono,@Param("ciudad") String ciudad,@Param("departamento") String departamento,@Param("codigoPostal") int codigoPostal,@Param("fechaRegistro") Date fechaRegistro, @Param("identificacion") Identificacion identificacion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Personas WHERE ID = :ID", nativeQuery=true)
    void eliminarPersona(@Param("ID") int ID);

}
