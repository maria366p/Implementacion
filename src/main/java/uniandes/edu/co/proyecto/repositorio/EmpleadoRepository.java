package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {

    @Query(value = "SELECT * FROM EMPLEADOS", nativeQuery = true)
        Collection<Empleado> darEmpleados();

    @Query(value = "SELECT * FROM EMPLEADOS WHERE IDEMPLEADO = :IDEMPLEADO", nativeQuery = true)
    Empleado darEmpleado(@Param("IDEMPLEADO") int IDEMPLEADO);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO EMPLEADOS (IDEMPLEADO, IDCARGO, IDOFICINA) VALUES (:IDEMPLEADO, :IDCARGO, :IDOFICINA)", nativeQuery=true)
        void insertarEmpleado(@Param("IDEMPLEADO") int IDEMPLEADO, @Param("IDCARGO") int IDCARGO, @Param("IDOFICINA") int IDOFICINA );

    @Modifying
    @Transactional
    @Query(value = "UPDATE EMPLEADOS SET IDCARGO = :IDCARGO, IDOFICINA = :IDOFICINA WHERE IDEMPLEADO = :IDEMPLEADO", nativeQuery=true)
        void actualizarEmpleado(@Param("IDEMPLEADO") int IDEMPLEADO,@Param("IDCARGO") int IDCARGO, @Param("IDOFICINA") int IDOFICINA);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM EMPLEADOS WHERE IDEMPLEADO = :IDEMPLEADO", nativeQuery=true)
        void eliminarEmpleado(@Param("IDEMPLEADO") int IDEMPLEADO);
    
    
}
