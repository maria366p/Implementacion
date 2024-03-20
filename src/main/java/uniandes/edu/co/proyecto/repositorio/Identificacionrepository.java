package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Identificacion;

public interface IdentificacionRepository extends JpaRepository<Identificacion, Integer> {

    @Query(value = "SELECT * FROM IDENTIFICACIONES", nativeQuery = true)
    Collection<Identificacion> darIdentificaciones();

    @Query(value = "SELECT * FROM IDENTIFICACIONES WHERE NUMERO = :NUMERO", nativeQuery = true)
    Identificacion darIdentificacion(@Param("NUMERO") int NUMERO);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO IDENTIFICACIONES (NUMERO, TIPO) VALUES (:NUMERO, :TIPO)", nativeQuery=true)
        void insertarIdentificacion(@Param("NUMERO") int NUMERO, @Param("TIPO") String TIPO);

    @Modifying
    @Transactional
    @Query(value = "UPDATE IDENTIFICACIONES SET TIPO = :TIPO WHERE NUMERO = :NUMERO", nativeQuery=true)
        void actualizarIdentificacion(@Param("NUMERO") int NUMERO,@Param("TIPO") String TIPO);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM IDENTIFICACIONES WHERE NUMERO = :NUMERO", nativeQuery=true)
        void eliminarIdentificacion(@Param("NUMERO") int NUMERO);

    
} 