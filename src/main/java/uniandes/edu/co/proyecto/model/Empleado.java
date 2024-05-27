package uniandes.edu.co.proyecto.model;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Empleados")
@ToString
@Getter
@Setter
public class Empleado {
    @Id
    private ObjectId id;

    private String tipoDni;
    private String dni;
    private String nombre;
    private String nacionalidad;
    private String direccion;
    private String email;
    private String telefono;
    private String ciudad;
    private String departamento;
    private Integer codigoPostal;
    private String cargo;

    public Empleado(){;}

    public Empleado(String tipoDni, String dni, String nombre, String nacionalidad, String direccion, String email,
            String telefono, String ciudad, String departamento, Integer codigoPostal, String cargo) {
        this.tipoDni = tipoDni;
        this.dni = dni;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.codigoPostal = codigoPostal;
        this.cargo = cargo;
    } 
}
