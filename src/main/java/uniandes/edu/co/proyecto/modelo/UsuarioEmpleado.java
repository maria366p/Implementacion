package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "UsuariosEmpleados")
public class UsuarioEmpleado {
    
    
    private String Password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDEmpleado", referencedColumnName = "IDEmpleado") //en UsuarioEm "IDEmpleado" referenciar "IDEmpleado " de Empleado
    @Id
    private Empleado IDEmpleado;

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

    public Empleado getIDEmpleado() {
        return IDEmpleado;
    }



    public void setIDEmpleado(Empleado iDEmpleado) {
        IDEmpleado = iDEmpleado;
    }

    
    


}
