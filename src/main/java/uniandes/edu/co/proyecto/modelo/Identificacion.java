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
    private int tipo;

    @OneToOne(mappedBy = "docId")
    private Persona persona;

    public Identificacion(int numero, int tipo) {
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    

    
}
