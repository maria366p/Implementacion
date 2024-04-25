package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OFICINAS")
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDOFICINA;

    private String NOMBRE;
    private String DIRECCION;
    //TODO: Hacer relacion cardinalidad del gerente
    private int IDGERENTE;
    private int NUMEROPA;

   //Oficina no se lleva el atributo con la tabla Empleado


    public Oficina(String NOMBRE, String DIRECCION,  int IDGERENTE,int NUMEROPA ) {
        this.NOMBRE = NOMBRE;
        this.DIRECCION = DIRECCION;
        this.IDGERENTE = IDGERENTE;
        this.NUMEROPA = NUMEROPA;
        
    }

    public Oficina() {
        ;
    }

    public Integer getIDOFICINA() {
        return IDOFICINA;
    }

    public void setIDOFICINA(int idOficina) {
        this.IDOFICINA = idOficina;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public int getIDGERENTE() {
        return IDGERENTE;
    }

    public void setIDGERENTE(int IDGERENTE) {
        IDGERENTE = IDGERENTE;
    }

    public int getNUMEROPA() {
        return NUMEROPA;
    }

    public void setNUMEROPA(int nUMEROPA) {
        NUMEROPA = nUMEROPA;
    }
    
}
