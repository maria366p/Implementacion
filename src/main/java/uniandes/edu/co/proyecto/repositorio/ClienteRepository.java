package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.List;

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

    @Query(value = "SELECT " +
                   "P.nombre AS NombrePersona, " +
                   "C.rolC AS TipoCliente, " +
                   "CU.IDCuenta, " +
                   "CU.TipoCuenta, " +
                   "CU.Saldo AS SaldoCuenta, " +
                   "O.Nombre AS NombreOficina " +
                   "FROM Personas P " +
                   "JOIN Clientes C ON P.ID = C.IDCliente " +
                   "JOIN Cuentas CU ON C.IDCliente = CU.idCliente " +
                   "LEFT JOIN Oficinas O ON CU.IDGERENTE = O.IDGERENTE " +
                   "WHERE C.IDCliente = :IDCLIENTE", nativeQuery = true)
    List<Object[]> obtenerInfoCliente(@Param("IDCLIENTE") int IDCLIENTE);

    @Query(value = "SELECT " +
                   "P.nombre AS NombrePersona, " +
                   "C.rolC AS TipoCliente, " +
                   "PR.IDPrestamo, " +
                   "PR.Monto AS MontoPrestamo, " +
                   "PR.EstadoP AS EstadoPrestamo " +
                   "FROM Personas P " +
                   "JOIN Clientes C ON P.ID = C.IDCliente " +
                   "LEFT JOIN Prestamos PR ON C.IDCliente = PR.IDCliente " +
                   "WHERE C.IDCliente = :IDCLIENTE", nativeQuery = true)
    List<Object[]> obtenerPrestamosCliente(@Param("IDCLIENTE") int IDCLIENTE);

    @Query(value = "SELECT " +
               "P.nombre AS NombrePersona, " +
               "C.rolC AS TipoCliente, " +
               "CU.IDCuenta, " +
               "CU.TipoCuenta, " +
               "CU.Saldo AS SaldoCuenta, " +
               "O.Nombre AS NombreOficina, " + 
               "O.IDGERENTE AS IDGERENTE " +  
               "FROM Personas P " +
               "JOIN Clientes C ON P.ID = C.IDCliente " +
               "JOIN Cuentas CU ON C.IDCliente = CU.idCliente " +
               "JOIN Oficinas O ON CU.IDGERENTE = O.IDGERENTE " +
               "WHERE O.IDGERENTE = :IDGERENTE", nativeQuery = true)
        List<Object[]> obtenerInfoCuentasPorGerenteOficina(@Param("IDGERENTE") int IDGERENTE);


    @Query(value = "SELECT " +
               "P.nombre AS NombrePersona, " +
               "C.rolC AS TipoCliente, " +
               "PR.IDPrestamo, " +
               "PR.Monto AS MontoPrestamo, " +
               "PR.EstadoP AS EstadoPrestamo, " +
               "O.IDGERENTE AS GERENTE "+
               "FROM Personas P " +
               "JOIN Clientes C ON P.ID = C.IDCliente " +
               "JOIN Cuentas CU ON C.IDCliente = CU.idCliente " +
               "JOIN Oficinas O ON CU.IDGERENTE = O.IDGERENTE " +
               "LEFT JOIN Prestamos PR ON C.IDCliente = PR.IDCliente " +
               "WHERE O.IDGERENTE = :IDGERENTE", nativeQuery = true)
List<Object[]> obtenerPrestamosPorGerenteOficina(@Param("IDGERENTE") int IDGERENTE);


    @Query(value = "SELECT " +
                "P.nombre AS NombrePersona, " +
                "C.rolC AS TipoCliente, " +
                "CU.IDCuenta, " +
                "CU.TipoCuenta, " +
                "CU.Saldo AS SaldoCuenta, " +
                "O.Nombre AS NombreOficina, " +  
                "O.IDGERENTE AS IDGERENTE " +
                "FROM Personas P " +
                "JOIN Clientes C ON P.ID = C.IDCliente " +
                "JOIN Cuentas CU ON C.IDCliente = CU.idCliente " +
                "JOIN Oficinas O ON CU.IDGERENTE = O.IDGERENTE", nativeQuery = true)
    List<Object[]> obtenerInfoCuentasParaGerenteGeneral();


        @Query(value = "SELECT " +
        "P.nombre AS NombrePersona, " +
        "C.rolC AS TipoCliente, " +
        "PR.IDPrestamo, " +
        "PR.Monto AS MontoPrestamo, " +
        "PR.EstadoP AS EstadoPrestamo, " +
        "O.IDGERENTE AS IDGERENTE " +  
        "FROM Personas P " +
        "JOIN Clientes C ON P.ID = C.IDCliente " +
        "JOIN Cuentas CU ON C.IDCliente = CU.idCliente " +  
        "JOIN Oficinas O ON CU.IDGERENTE = O.IDGERENTE " +  
        "LEFT JOIN Prestamos PR ON C.IDCliente = PR.IDCliente", nativeQuery = true)
        List<Object[]> obtenerInfoPrestamosParaGerenteGeneral();


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
