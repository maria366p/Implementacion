package uniandes.edu.co.proyecto.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, ObjectId>{

}
