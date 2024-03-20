package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OFICINAS")
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDOFICINA;

    private String NOMBRE;
    private String DIRECCION;

   //Oficina no se lleva el atributo con la tabla Empleado


    public Oficina(String NOMBRE, String DIRECCION) {
        this.NOMBRE = NOMBRE;
        this.DIRECCION = DIRECCION;
        
    }

    public Oficina() {
        ;
    }

    public int getIdOficina() {
        return IDOFICINA;
    }

    public void setIdOficina(int idOficina) {
        this.IDOFICINA = idOficina;
    }

    public String getNombre() {
        return NOMBRE;
    }

    public void setNombre(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getDireccion() {
        return DIRECCION;
    }

    public void setDireccion(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }
}
