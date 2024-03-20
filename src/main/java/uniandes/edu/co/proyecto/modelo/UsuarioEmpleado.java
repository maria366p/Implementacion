package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "UsuariosEmpleados")
public class UsuarioEmpleado {
    
    @Id
    private int ID; // Asume que Persona también usa int para el ID

    private String Password;

    @MapsId  // Esto indica que estamos mapeando el ID de esta entidad al ID de la entidad asociada
    //UsuarioEmpleado se lleva el atributo ID de Persona
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID", referencedColumnName = "IDEmpleado") //en UsuarioEm "IDEmpleado" referenciar "IDEmpleado " de Empleado
    private Empleado empleado;

    public UsuarioEmpleado(String password) {
        Password = password;
    }

    public UsuarioEmpleado(){

    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getID() {
        return ID;
    }


    
    


}
