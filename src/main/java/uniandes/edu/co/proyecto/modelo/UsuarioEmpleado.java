package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "USUARIOSEMPLEADOS")
public class UsuarioEmpleado {
    
    @Id
    private int ID; // Asume que Persona también usa int para el ID

    private String PASSWORD;

    @MapsId  // Esto indica que estamos mapeando el ID de esta entidad al ID de la entidad asociada
    //UsuarioEmpleado se lleva el atributo ID de Persona
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID", referencedColumnName = "IDEMPLEADO") //en UsuarioEm "IDEMPLEADO" referenciar "IDEMPLEADO " de Empleado
    private Empleado empleado;

    public UsuarioEmpleado(String password) {
        PASSWORD = password;
    }

    public UsuarioEmpleado(){
        ;
    }


    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String password) {
        PASSWORD = password;
    }

    public int getID() {
        return ID;
    }


    
    


}
