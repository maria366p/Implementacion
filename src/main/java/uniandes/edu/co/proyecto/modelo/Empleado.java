package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Empleados")
public class Empleado {


    //Empleado se lleva el atributo ID de Persona
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDEmpleado", referencedColumnName = "ID") //en Em "IDEmpleado" referenciar "ID" de persona
    @Id
    private Persona IDEmpleado;

    //Empleado no se lleva el atributo con la tabla UsuarioEMpleado
    @OneToOne(mappedBy = "IDEmpleado")
    private UsuarioEmpleado UsuarioEmpleado;


    //Empleado se lleva el atributo de IDOficina de Oficina
    @ManyToOne
    @JoinColumn(name = "IDOficina", referencedColumnName = "IDOficina")
    private Oficina IDOficina;

     //Empleado se lleva el atributo de IDCargo de Cargo
     @ManyToOne
     @JoinColumn(name = "IDCargo", referencedColumnName = "IDCargo")
     private Cargo IDCargo;
    
    public Empleado(Persona iDEmpleado, uniandes.edu.co.proyecto.modelo.UsuarioEmpleado usuarioEmpleado,
            Oficina iDOficina, Cargo iDCargo) {
        IDEmpleado = iDEmpleado;
        UsuarioEmpleado = usuarioEmpleado;
        IDOficina = iDOficina;
        IDCargo = iDCargo;
    }

    public Empleado(){
        
    }
    
    public Persona getIDEmpleado() {
        return IDEmpleado;
    }

    public void setIDEmpleado(Persona iDEmpleado) {
        IDEmpleado = iDEmpleado;
    }

    public UsuarioEmpleado getUsuarioEmpleado() {
        return UsuarioEmpleado;
    }

    public void setUsuarioEmpleado(UsuarioEmpleado usuarioEmpleado) {
        UsuarioEmpleado = usuarioEmpleado;
    }

    public Oficina getIDOficina() {
        return IDOficina;
    }

    public void setIDOficina(Oficina iDOficina) {
        IDOficina = iDOficina;
    }

    public Cargo getIDCargo() {
        return IDCargo;
    }

    public void setIDCargo(Cargo iDCargo) {
        IDCargo = iDCargo;
    }

    
}
