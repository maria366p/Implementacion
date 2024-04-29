package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.UsuarioCliente;


public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Integer> {

    @Query(value = "SELECT * FROM USUARIOSCLIENTES", nativeQuery = true)
        Collection<UsuarioCliente> darUsuarioClientes();

    @Query(value = "SELECT * FROM USUARIOSCLIENTES WHERE ID = :ID", nativeQuery = true)
    UsuarioCliente darUsuarioCliente(@Param("ID") int ID);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USUARIOSCLIENTES (ID, PASSWORD) VALUES (:ID, :PASSWORD)", nativeQuery=true)
        void insertarUsuarioCliente(@Param("ID") int ID, @Param("PASSWORD") String PASSWORD);

    @Modifying
    @Transactional
    @Query(value = "UPDATE USUARIOSCLIENTES SET PASSWORD = :PASSWORD WHERE ID = :ID", nativeQuery=true)
        void actualizarUsuarioCliente(@Param("ID") int ID,@Param("PASSWORD") String PASSWORD);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM USUARIOSCLIENTES WHERE ID = :ID", nativeQuery=true)
        void eliminarUsuarioCliente(@Param("ID") int ID);

    //QUERY QUE de el nombre y busque POR ID Y CONTRASEÑA DEL CLIENTE
    @Query(value = "SELECT P.NOMBRE\r\n"+ 
                    "FROM USUARIOSCLIENTES E \r\n"+
                    "INNER JOIN PERSONAS P ON E.ID = P.ID\r\n"+
                    "WHERE E.ID = :ID  AND E.PASSWORD = :PASSWORD\r\n", nativeQuery = true)
    String darNombrePconIDyPas(@Param("ID") Integer ID, @Param("PASSWORD") String PASSWORD);



} 