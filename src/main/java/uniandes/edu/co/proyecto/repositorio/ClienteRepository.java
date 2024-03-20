package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Persona;
import uniandes.edu.co.proyecto.modelo.RolC;

public interface ClienteRepository extends JpaRepository<Cliente, Persona>{

    @Query(value = "SELECT * From Clientes", nativeQuery = true)
    Collection<Cliente>  darClientes();
    
    @Query(value = "SELECT * From Clientes WHERE ID = :ID", nativeQuery = true) 
    Cliente darCliente(@Param("ID") int ID);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Clientes (ID, FK_cliente_persona, rolC) VALUES (banc_andes.nextval, :FK_cliente_persona, :rolC)", nativeQuery = true)
    void insertarCliente(@Param("ID") int ID, @Param("FK_cliente_persona") int FK_cliente_persona, @Param("rolC") RolC rolC);

    @Modifying
    @Transactional
    @Query(value = "Update Clientes SET FK_cliente_persona = :FK_cliente_persona, rolC = :rolC WHERE ID = :ID", nativeQuery = true)
    void actualizarCliente (@Param("ID") int ID, @Param("FK_cliente_persona") int FK_cliente_persona, @Param("rolC") RolC rolC);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Clientes WHERE ID = :ID", nativeQuery = true)
    void eliminarCliente(@Param("ID") int ID);

    
}