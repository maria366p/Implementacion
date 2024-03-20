package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;
import uniandes.edu.co.proyecto.modelo.TipoOc;

public interface OperacionCuentaRepository extends JpaRepository<OperacionCuenta, Integer>{
    

    @Query(value = "SELECT * From OperacionesCuenta", nativeQuery = true)
    Collection<OperacionCuenta> darOperacionesCuenta();
    
    @Query(value = "SELECT * From OperacionesCuenta WHERE idOperacion = :idOperacion", nativeQuery = true)
    OperacionCuenta darOperacionCuenta(@Param("idOperacion")int idOperacion);
    

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OperacionesCuenta (idOperacion, FK_cuenta, tipo, valor, Fecha) VALUES (banc_andes.nextval, :FK_cuenta, :tipo, :valor, :fecha)", nativeQuery=true)
    void insertarOperacionCuenta(@Param("idOperacion") int idOperacion, @Param("FK_cuenta") int FK_cuenta, @Param("tipo") TipoOc tipo, @Param("valor") int valor, @Param("Fecha") Date fecha);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE OperacionesCuenta SET FK_cuenta = :FK_cuenta, tipo = :tipo, valor = :valor, Fecha = :fecha  WHERE idOperacion = :idOperacion", nativeQuery=true)
    void actualizarOperacionCuenta(@Param("idOperacion") int idOperacion, @Param("FK_cuenta") int FK_cuenta, @Param("tipo") TipoOc tipo, @Param("valor") int valor, @Param("Fecha") Date fecha);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OperacionesCuenta WHERE idOperacion = :idOperacion", nativeQuery=true)
    void eliminarOperacionCuenta(@Param("idOperacion") int idOperacion);
}
