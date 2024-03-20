package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente {

    @Id
    private int IDCliente; // Asume que Persona también usa Long para el ID

    @MapsId  // Esto indica que estamos mapeando el ID de esta entidad al ID de la entidad asociada
    //Cliente se lleva el atributo ID de Persona
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDCliente", referencedColumnName = "ID") //en Cl "IDCliente" referenciar "ID" de persona
    private Persona persona;

    private RolC rolC;

    //Cliente no se lleva el atributo con la tabla UsuarioCliente
    @OneToOne(mappedBy = "cliente")
    private UsuarioCliente UsuarioCliente;

    //Cliente no se lleva el atributo con tabla Prestamo


    public Cliente(RolC rolC) {
        this.rolC = rolC;
    }

    public Cliente (){
        ;
    }
    public int getIDCliente() {
        return IDCliente;
    }

    public RolC getRolC() {
        return rolC;
    }

    public void setRolC(RolC rolC) {
        this.rolC = rolC;
    }

    

    
}
