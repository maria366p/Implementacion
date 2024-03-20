package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIOSCLIENTES")
public class UsuarioCliente {
    private String PASSWORD;

    @Id
    private int ID; // Asume que Persona también usa Long para el ID

    @MapsId  // Esto indica que estamos mapeando el ID de esta entidad al ID de la entidad asociada
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID", referencedColumnName = "IDCLIENTE") //en UsuarioCl "IDCLIENTE" referenciar "IDCLIENTE " de Cliente
    private Cliente cliente;

    public UsuarioCliente(String password) {
        PASSWORD = password;
    }

    public UsuarioCliente(){
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
