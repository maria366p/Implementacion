package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Persona;
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

    //QUERY QUE de el nombre y busque POR ID Y CONTRASEÑA DEL EMPLEADO
    @Query(value = "SELECT P.NOMBRE\r\n"+ 
                    "FROM USUARIOSEMPLEADOS E \r\n"+
                    "INNER JOIN PERSONAS P ON E.ID = P.ID\r\n"+
                    "WHERE E.ID = :ID  AND E.PASSWORD = :PASSWORD\r\n", nativeQuery = true)
    String darNombrePconIDyPas(@Param("ID") Integer ID, @Param("PASSWORD") String PASSWORD);

    // Query que de el cargo y busque por ID Y CONTRASEÑA DEL EMPLEADO
    @Query(value = "SELECT C.NOMBRE\r\n"+ 
                    "FROM USUARIOSEMPLEADOS UE \r\n"+
                    "INNER JOIN EMPLEADOS E ON UE.ID = E.IDEMPLEADO\r\n"+
                    "INNER JOIN CARGOS C ON E.IDEMPLEADO = C.IDCARGO\r\n" + 
                    "WHERE UE.ID = :ID \r\n", nativeQuery = true)
    String darCargoconID(@Param("ID") Integer ID);

    //QUERY que da los empleados que tienen cargo de gerente
    @Query(value = "SELECT P.ID\r\n"+ 
    "FROM PERSONAS P \r\n"+
    "INNER JOIN EMPLEADOS E ON P.ID = E.IDEMPLEADO\r\n"+
    "INNER JOIN CARGOS C ON E.IDCARGO = C.IDCARGO\r\n" + 
    "WHERE C.NOMBRE = 'GerenteOficina' \r\n", nativeQuery = true)
    List<Integer> darPersdeGerenteO();






}
