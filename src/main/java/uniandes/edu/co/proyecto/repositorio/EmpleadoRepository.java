package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.Persona;


public interface EmpleadoRepository extends JpaRepository<Empleado, Persona>{


    @Query(value = "SELECT * From Empleados", nativeQuery = true)
    Collection<Empleado>  darEmpleados();
    
    @Query(value = "SELECT * From Empleados WHERE id = :id", nativeQuery = true) 
    Empleado darEmpleado(@Param("id") int id);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Empleados (id, FK_empleado_persona, idCargo) VALUES (banc_andes.nextval, :FK_empleado_persona, :idCargo)", nativeQuery = true)
    void insertarEmpleado(@Param("id") int id, @Param("FK_cliente_persona") int FK_empleado_persona, @Param("idCargo") int idCargo );

    @Modifying
    @Transactional
    @Query(value = "Update Empleados SET FK_empleado_persona = :FK_cliente_persona, rolC = :rolC WHERE id = :id", nativeQuery = true)
    void actualizarEmpleado (@Param("id") int id, @Param("FK_cliente_persona") int FK_empleado_persona, @Param("idCargo") int idCargo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Empleados WHERE id = :id", nativeQuery = true)
    void eliminarEmpleado(@Param("id") int id);
    
}
