package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Cargo;
import uniandes.edu.co.proyecto.modelo.RolE;


public interface CargoRepository extends JpaRepository<Cargo, Integer> {

    @Query(value = "SELECT * From Cargos", nativeQuery = true)
    Collection<Cargo>  darCargos();
    
    @Query(value = "SELECT * From Cargos WHERE ID = :ID", nativeQuery = true) 
    Cargo darCargo(@Param("ID") int ID);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Cargos (ID, nombre, descripcion) VALUES (banc_andes.nextval, :nombre, :descripcion)", nativeQuery = true)
    void insertarCargo(@Param("nombre") RolE nombre);

    @Modifying
    @Transactional
    @Query(value = "Update Cargos SET nombre = :nombre, descripcion = :descripcion WHERE ID = :ID", nativeQuery = true)
    void actualizarCargo (@Param("ID") int ID, @Param("nombre") RolE nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Cargos WHERE ID = :ID", nativeQuery = true)
    void eliminarCargo(@Param("ID") int ID);
}
