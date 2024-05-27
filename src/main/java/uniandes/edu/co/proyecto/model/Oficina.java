package uniandes.edu.co.proyecto.model;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Oficinas")
@ToString
@Getter
@Setter
public class Oficina {
    @Id
    private ObjectId id;
    private String nombre;
    private String direccion;
    private Integer numPuntos;

    @DBRef
    private List<ObjectId> puntosAtencion;

    @DBRef
    private List<ObjectId> empleados;

    private String gerente;

    public Oficina(){;}

    public Oficina(String nombre, String direccion, Integer numPuntos, String gerente) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numPuntos = numPuntos;
        this.puntosAtencion = new ArrayList<ObjectId>();
        this.empleados = new ArrayList<ObjectId>();
        this.gerente = gerente;
    }
}
