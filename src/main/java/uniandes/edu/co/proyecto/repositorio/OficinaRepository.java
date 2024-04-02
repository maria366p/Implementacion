package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Oficina;

public interface OficinaRepository extends JpaRepository<Oficina,Integer>{

    @Query(value = "SELECT * FROM OFICINAS", nativeQuery = true)
        Collection<Oficina> darOficinas();

    @Query(value = "SELECT * FROM OFICINAS WHERE IDOFICINA = :IDOFICINA", nativeQuery = true)
    Oficina darOficina(@Param("IDOFICINA") int IDOFICINA);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OFICINAS (IDOFICINA, NOMBRE, DIRECCION, NUMEROPA, IDGERENTE ) VALUES (oficinas_sequence.NEXTVAL, :NOMBRE, :DIRECCION, :NUMEROPA, :IDGERENTE)", nativeQuery=true)
        void insertarOficina(@Param("NOMBRE") String NOMBRE, @Param("DIRECCION") String DIRECCION,  @Param("NUMEROPA") int NUMEROPA,  @Param("IDGERENTE") int IDGERENTE);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OFICINAS SET NOMBRE = :NOMBRE, DIRECCION = :DIRECCION, NUMEROPA = :NUMEROPA, IDGERENTE  = :IDGERENTE WHERE IDOFICINA = :IDOFICINA", nativeQuery=true)
        void actualizarOficina(@Param("IDOFICINA") int IDOFICINA,@Param("NOMBRE") String NOMBRE, @Param("DIRECCION") String DIRECCION, @Param("NUMEROPA") int NUMEROPA,  @Param("IDGERENTE") int IDGERENTE);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OFICINAS WHERE IDOFICINA = :IDOFICINA", nativeQuery=true)
        void eliminarOficina(@Param("IDOFICINA") int IDOFICINA);
    
}
