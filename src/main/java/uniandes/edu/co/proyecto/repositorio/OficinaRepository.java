package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Oficina;

public interface OficinaRepository extends JpaRepository<Oficina, Integer>{

    @Query(value = "SELECT * From Oficinas", nativeQuery = true)
    Collection<Oficina>  darOficinas();

    @Query(value = "SELECT * From Oficinas WHERE idOficina = :idOficina", nativeQuery = true)
    Oficina darOficina(@Param("idOficina")int idOficina);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Oficinas (idOficina, nombre, direccion) VALUES (banc_andes.nextval, :nombre, :direccion)", nativeQuery=true)
    void insertarOficina(@Param("idOficina") int idOficina, @Param("nombre") String nombre, @Param("direccion") String direccion);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE Oficinas SET nombre = :nombre, direccion = :direccion WHERE idOficina = :idOficina", nativeQuery=true)
    void actualizarOficina(@Param("idOficina") int idOficina, @Param("nombre") String nombre, @Param("direccion") String direccion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Oficinas WHERE idOficina = :idOficina", nativeQuery=true)
    void eliminarOficina(@Param("idOficina") int idOficina);
    
}