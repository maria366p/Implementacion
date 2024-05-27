package uniandes.edu.co.proyecto.Repository;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.model.Cuenta;
import uniandes.edu.co.proyecto.model.Operacion;

public interface CuentaRepository extends MongoRepository<Cuenta, ObjectId>{
    /*Sacar todas las cuentas*/
    @Query("{ _id: { $in: ?0 } }")
    List<Cuenta> findByIds(List<ObjectId> ids);

    /*Cambiar estado de cuenta*/
    @Query("{_id: ?0}")
    @Update("{ $set:  {estado: ?1}}")
    void estadoCerrado(ObjectId id, String estado);

    @Query(value = "{ _id: ?0 }", fields = "{ saldo: 1 }")
    Cuenta findSaldoById(ObjectId id);

    /*Registrar operación sobre cuenta*/
    @Query("{_id: ?0}")
    @Update("{$push:{operaciones:{valor:?1, tipo:?2, fecha:?3, puntoAtencion:?4}}}")
    void registrarOperacion(ObjectId id, Double valor, String tipo, LocalDate fecha, String puntoAtencion);

    /*Registrar transacción*/
    @Query("{_id: ?0}")
    @Update("{$push:{operaciones:{valor:?1, tipo:?2, fecha:?3, puntoAtencion:?4, cuentaDestino:?5}}}")
    void registrarTransaccion(ObjectId id, Double valor, String tipo, LocalDate fecha, String puntoAtencion, String cuentaDestino);

    /*Actualizar última fecha de transaccion*/
    @Query("{_id: ?0}")
    @Update("{ $set:  {ultimaTransaccion: ?1}}")
    void actualizarUltima(ObjectId id, LocalDate fecha);

    /*Actualizar última fecha de transaccion*/
    @Query("{_id: ?0}")
    @Update("{ $set:  {saldo: ?1}}")
    void actualizarSaldo(ObjectId id, Double valor);

    /*Consultar bancandes*/
       // Filtro por tipo de cuenta
        @Query("{ tipo: ?0 }")
        List<Cuenta> findByTipo(String tipo);

        // Filtro por rango de saldos
        @Query("{ saldo: { $gte: ?0, $lte: ?1 } }")
        List<Cuenta> findBySaldoBetween(Double saldoMin, Double saldoMax);

        // Filtro por fecha del último movimiento
        @Query("{ultimaTransaccion: { $gte: ?0} }")
        List<Cuenta> findByFechaUltimaTransaccionBetween(LocalDate fechaInicio);

    @Query("{numero: ?0} }")
    Cuenta findByNumber(Integer number);
    
}
