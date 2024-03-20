package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Identificacion;


public interface Identificacionrepository extends JpaRepository<Identificacion, Integer>{ 

        @Query(value = "SELECT * From Identificaciones", nativeQuery = true)
        Collection<Identificacion>  darIdentificaciones();

        @Query(value = "SELECT * From Identificaciones WHERE id = :id", nativeQuery = true)
        Identificacion darIdentificacion(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO Identificaciones (identificacionId, tipoIdentificacion, DocId ) VALUES (bancandes_sequence.nextval, :tipoIdentificacion, :DocId)", nativeQuery = true)
        void insertarIdentificacion(@Param("identificacionId") int id, @Param("TipoId") String tipo, @Param("DocId") int numId);

        @Modifying
        @Transactional
        @Query(value = "Update Identificaciones SET tipoIdentificacion = :tipoIdentificacion, DocId = :DocId WHERE identificacionId = :id", nativeQuery = true)
        void actualizarIdentificacion (@Param("id") int id, @Param("tipoIdentificacion") String tipo, @Param("DocId") int numId);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM Identificaciones WHERE identificacionId = :id", nativeQuery = true)
        void eliminarIdentificacion(@Param("id") int id);
        

        
}