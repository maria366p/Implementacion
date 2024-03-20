package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Oficinas")
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDOficina;

    private String nombre;
    private String direccion;

   //Oficina no se lleva el atributo con la tabla Empleado


    public Oficina(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        
    }

    public Oficina() {
        ;
    }

    public int getIdOficina() {
        return IDOficina;
    }

    public void setIdOficina(int idOficina) {
        this.IDOficina = idOficina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
