package uniandes.edu.co.proyecto.model;
import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.bson.types.ObjectId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Operacion {
    private Double valor;
    private String tipo;
    private LocalDate fecha;
    
    private String cuentaDestino; 

    private String puntoAtencion;

    public Operacion(){;}

    public Operacion(Double valor, String tipo, LocalDate fecha, String cuentaDestino, String puntoAtencion) {
        this.valor = valor;
        this.tipo = tipo;
        this.fecha = fecha;
        this.cuentaDestino = cuentaDestino;
        this.puntoAtencion = puntoAtencion;
    }
    
}
