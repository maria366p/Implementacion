package uniandes.edu.co.proyecto.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "PuntosAtencion")
@ToString
@Getter
@Setter
public class PuntoAtencion {
    @Id
    private ObjectId id;
    private String tipo;
    private String latitud;
    private String longitud;

    public PuntoAtencion(){;}

    public PuntoAtencion(String tipo, String latitud, String longitud) {
        this.tipo = tipo;
        this.latitud = latitud;
        this.longitud = longitud;
    }    
}
