package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Empleados")
public class Empleado {


    @Id
    private int IDEmpleado; // Asume que Persona también usa int para el ID

    @MapsId  // Esto indica que estamos mapeando el ID de esta entidad al ID de la entidad asociada
    //Empleado se lleva el atributo ID de Persona
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDEmpleado", referencedColumnName = "ID") //en Em "IDEmpleado" referenciar "ID" de persona
    private Persona persona;

    //Empleado no se lleva el atributo con la tabla UsuarioEMpleado
    @OneToOne(mappedBy = "empleado")
    private UsuarioEmpleado UsuarioEmpleado;


    //Empleado se lleva el atributo de IDOficina de Oficina
    @ManyToOne
    @JoinColumn(name = "IDOficina", referencedColumnName = "IDOficina")
    private Oficina IDOficina;

     //Empleado se lleva el atributo de IDCargo de Cargo
     @ManyToOne
     @JoinColumn(name = "IDCargo", referencedColumnName = "IDCargo")
     private Cargo IDCargo;
    
    
    public Empleado(int iDEmpleado, Oficina iDOficina,
            Cargo iDCargo) {
        IDEmpleado = iDEmpleado;
        IDOficina = iDOficina;
        IDCargo = iDCargo;
    }
    
    public Empleado(){
        ;
    }

    public int getIDEmpleado() {
        return IDEmpleado;
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
