package uniandes.edu.co.proyecto.Repository;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.model.Oficina;

public interface OficinaRepository extends MongoRepository<Oficina, ObjectId>{
    
}
