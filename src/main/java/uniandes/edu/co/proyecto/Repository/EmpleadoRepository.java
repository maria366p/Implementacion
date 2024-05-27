package uniandes.edu.co.proyecto.Repository;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.proyecto.model.Empleado;

public interface EmpleadoRepository extends MongoRepository<Empleado, ObjectId>{

    @Query("{ _id: { $in: ?0 } }")
    List<Empleado> findByIds(List<ObjectId> ids);

    List<Empleado> findByCargo(String cargo);
}
