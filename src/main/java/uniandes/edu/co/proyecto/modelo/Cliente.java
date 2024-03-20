package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente {

    //Cliente se lleva el atributo ID de Persona
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDCliente", referencedColumnName = "ID") //en Cl "IDCliente" referenciar "ID" de persona
    @Id
    private Persona IDCliente;

    private RolC rolC;

    //Cliente no se lleva el atributo con la tabla UsuarioCliente
    @OneToOne(mappedBy = "IDCliente")
    private UsuarioCliente UsuarioCliente;

    //Cliente no se lleva el atributo con tabla Prestamo


    public Cliente(RolC rolC) {
        this.rolC = rolC;
    }

    public Cliente (){
        ;
    }
    public Persona getIDCliente() {
        return IDCliente;
    }

    public RolC getRolC() {
        return rolC;
    }

    public void setRolC(RolC rolC) {
        this.rolC = rolC;
    }

    

    
}
