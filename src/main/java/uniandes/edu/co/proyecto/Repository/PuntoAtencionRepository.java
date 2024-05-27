package uniandes.edu.co.proyecto.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.model.PuntoAtencion;

public interface PuntoAtencionRepository extends MongoRepository<PuntoAtencion, ObjectId>{
    /*Borrar punto de atención*/

    @DeleteQuery("{_id: ?0}")
    void borrarPuntoAtencion(ObjectId id);

    @Query("{ _id: { $in: ?0 } }")
    List<PuntoAtencion> findByIds(List<ObjectId> ids);
}
