package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.UsuarioEmpleado;


public interface UsuarioEmpleadoRepository extends JpaRepository<UsuarioEmpleado, Integer>{

    @Query(value = "SELECT * FROM USUARIOSEMPLEADOS", nativeQuery = true)
        Collection<UsuarioEmpleado> darUsuarioEmpleados();

    @Query(value = "SELECT * FROM USUARIOSEMPLEADOS WHERE ID = :ID", nativeQuery = true)
    UsuarioEmpleado darUsuarioEmpleado(@Param("ID") int ID);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USUARIOSEMPLEADOS (ID, PASSWORD) VALUES (:ID, :PASSWORD)", nativeQuery=true)
        void insertarUsuarioEmpleado(@Param("ID") int ID, @Param("PASSWORD") String PASSWORD);

    @Modifying
    @Transactional
    @Query(value = "UPDATE USUARIOSEMPLEADOS SET PASSWORD = :PASSWORD WHERE ID = :ID", nativeQuery=true)
        void actualizarUsuarioEmpleado(@Param("ID") int ID,@Param("PASSWORD") String PASSWORD);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM USUARIOSEMPLEADOS WHERE ID = :ID", nativeQuery=true)
        void eliminarUsuarioEmpleado(@Param("ID") int ID);

    
}
