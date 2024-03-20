package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "UsuariosClientes")
public class UsuarioCliente {
    private String Password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDCliente", referencedColumnName = "IDCliente") //en UsuarioCl "IDCliente" referenciar "IDCliente " de Cliente
    @Id
    private Cliente IDCliente;

    public UsuarioCliente(String password) {
        Password = password;
    }

    public UsuarioCliente(){

    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Cliente getIDCliente() {
        return IDCliente;
    }


    
}
