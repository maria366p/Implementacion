package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTES")
public class Cliente {

    @Id
    private int IDCLIENTE; // Asume que Persona también usa int para el ID

    @MapsId  // Esto indica que estamos mapeando el ID de esta entidad al ID de la entidad asociada
    //Cliente se lleva el atributo ID de Persona
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "ID") //en Cl "IDCLIENTE" referenciar "ID" de persona
    private Persona persona;


    @Enumerated(EnumType.STRING)
    private RolC ROLC;

    //Cliente no se lleva el atributo con la tabla UsuarioCliente
    @OneToOne(mappedBy = "cliente")
    private UsuarioCliente UsuarioCliente;

    //Cliente no se lleva el atributo con tabla Prestamo


    public Cliente(RolC ROLC) {
        this.ROLC = ROLC;
    }

    public Cliente (){
        ;
    }
    public int getIDCLIENTE() {
        return IDCLIENTE;
    }

    public RolC getRolC() {
        return ROLC;
    }

    public void setRolC(RolC ROLC) {
        this.ROLC = ROLC;
    }

    

    
}
