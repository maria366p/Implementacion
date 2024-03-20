package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Identificaciones")
public class Identificacion {
    
    @Id
    private int numero; // numero es la primary key de identificacion
    private String tipo;

    @OneToOne(mappedBy = "DOCID")
    private Persona persona;

    public Identificacion(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public Identificacion(){;}

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    

    
}
