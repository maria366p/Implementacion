package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Cargo;


public interface CargoRepository extends JpaRepository<Cargo,Integer>{

    @Query(value = "SELECT * FROM CARGOS", nativeQuery = true)
        Collection<Cargo> darCargos();

    @Query(value = "SELECT * FROM CARGOS WHERE IDCARGO = :IDCARGO", nativeQuery = true)
    Cargo darCargo(@Param("IDCARGO") int ID);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CARGOS (IDCARGO, NOMBRE) VALUES (cargos_sequence.NEXTVAL, :NOMBRE)", nativeQuery=true)
        void insertarCargo(@Param("NOMBRE") String NOMBRE);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CARGOS SET NOMBRE = :NOMBRE WHERE IDCARGO = :IDCARGO", nativeQuery=true)
        void actualizarCargo(@Param("IDCARGO") int ID,@Param("NOMBRE") String NOMBRE);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CARGOS WHERE IDCARGO = :IDCARGO", nativeQuery=true)
        void eliminarCargo(@Param("IDCARGO") int ID);

    
}
