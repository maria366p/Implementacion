package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLEADOS")
public class Empleado {


    @Id
    private int IDEMPLEADO; // Asume que Persona también usa int para el ID

    @MapsId  // Esto indica que estamos mapeando el ID de esta entidad al ID de la entidad asociada
    //Empleado se lleva el atributo ID de Persona
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDEMPLEADO", referencedColumnName = "ID") //en Em "IDEMPLEADO" referenciar "ID" de persona
    private Persona persona;

    //Empleado no se lleva el atributo con la tabla UsuarioEMpleado
    @OneToOne(mappedBy = "empleado")
    private UsuarioEmpleado UsuarioEmpleado;


    //Empleado se lleva el atributo de IDOFICINA de Oficina
    @ManyToOne
    @JoinColumn(name = "IDOFICINA", referencedColumnName = "IDOFICINA")
    private Oficina IDOFICINA;

     //Empleado se lleva el atributo de IDCARGO de Cargo
     @ManyToOne
     @JoinColumn(name = "IDCARGO", referencedColumnName = "IDCARGO")
     private Cargo IDCARGO;
    
    
    public Empleado(int iDEmpleado, Oficina iDOficina,
            Cargo iDCargo) {
        IDEMPLEADO = iDEmpleado;
        IDOFICINA = iDOficina;
        IDCARGO = iDCargo;
    }
    
    public Empleado(){
        ;
    }

    public int getIDEMPLEADO() {
        return IDEMPLEADO;
    }


    public Oficina getIDOFICINA() {
        return IDOFICINA;
    }


    public void setIDOFICINA(Oficina iDOficina) {
        IDOFICINA = iDOficina;
    }


    public Cargo getIDCARGO() {
        return IDCARGO;
    }


    public void setIDCARGO(Cargo iDCargo) {
        IDCARGO = iDCargo;
    }

    
}
