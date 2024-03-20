package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "UsuariosClientes")
public class UsuarioCliente {
    private String Password;

    @Id
    private int ID; // Asume que Persona también usa Long para el ID

    @MapsId  // Esto indica que estamos mapeando el ID de esta entidad al ID de la entidad asociada
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID", referencedColumnName = "IDCliente") //en UsuarioCl "IDCliente" referenciar "IDCliente " de Cliente
    private Cliente cliente;

    public UsuarioCliente(String password) {
        Password = password;
    }

    public UsuarioCliente(){
        ;
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
