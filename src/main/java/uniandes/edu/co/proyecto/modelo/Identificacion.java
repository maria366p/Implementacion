package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "IDENTIFICACIONES")
public class Identificacion {
    
    @Id
    private int NUMERO; // NUMERO es la primary key de identificacion
    private String TIPO;

    @OneToOne(mappedBy = "DOCID")
    private Persona persona;

    public Identificacion(int NUMERO, String TIPO) {
        this.NUMERO = NUMERO;
        this.TIPO = TIPO;
    }

    public Identificacion(){;}

    public int getNumero() {
        return NUMERO;
    }

    public void setNumero(int NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getTipo() {
        return TIPO;
    }

    public void setTipo(String TIPO) {
        this.TIPO = TIPO;
    }

    

    
}
