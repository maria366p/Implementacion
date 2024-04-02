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

   //Oficina no se lleva el atributo con la tabla Empleado


    public Oficina(String NOMBRE, String DIRECCION) {
        this.NOMBRE = NOMBRE;
        this.DIRECCION = DIRECCION;
        
    }

    public Oficina() {
        ;
    }

    public int getIDOFICINA() {
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
}
