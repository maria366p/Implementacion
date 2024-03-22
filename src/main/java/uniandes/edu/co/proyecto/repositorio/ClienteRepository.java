package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT IDCLIENTE, ROLC FROM CLIENTES", nativeQuery = true)
    Collection<Cliente> darClientes();

    @Query(value = "SELECT IDCLIENTE, ROLC FROM CLIENTES WHERE IDCLIENTE = :IDCLIENTE", nativeQuery = true)
    Cliente darCliente(@Param("IDCLIENTE") int IDCLIENTE);


    //Primero insertar ID de persona con sus atributos y luego el de cliente
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CLIENTES (IDCLIENTE, ROLC) VALUES (:IDCLIENTE, :ROLC)", nativeQuery=true)
        void insertarCliente(@Param("IDCLIENTE") int IDCLIENTE, @Param("ROLC") String ROLC);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CLIENTES SET ROLC = :ROLC WHERE IDCLIENTE = :IDCLIENTE", nativeQuery=true)
        void actualizarCliente(@Param("IDCLIENTE") int ID,@Param("ROLC") String ROLC);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CLIENTES WHERE IDCLIENTE = :IDCLIENTE", nativeQuery=true)
        void eliminarCliente(@Param("IDCLIENTE") int ID);

    
} 
