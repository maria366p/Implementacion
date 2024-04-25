package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
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

    public int getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(int NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    

    
}
