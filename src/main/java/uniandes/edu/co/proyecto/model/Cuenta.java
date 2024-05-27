package uniandes.edu.co.proyecto.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Cuentas")
@ToString
@Getter
@Setter
public class Cuenta {
    
    @Id
    private ObjectId id;

    private Integer numero;
    private String tipo;
    private Double saldo;
    private String estado;
    private LocalDate ultimaTransaccion;
    private List<Operacion> operaciones;

    private String cliente;

    public Cuenta(){;}

    public Cuenta(Integer numero, String tipo, Double saldo, String estado, LocalDate ultimaTransaccion, String cliente) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = saldo;
        this.estado = estado;
        this.ultimaTransaccion = ultimaTransaccion;
        this.operaciones = new ArrayList<Operacion>();
        this.cliente = cliente;
    }
}
