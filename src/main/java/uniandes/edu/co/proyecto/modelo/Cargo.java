package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CARGOS")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDCARGO;

    //Cargo no se lleva el atributo con la tabla Empleado
    
    @Enumerated(EnumType.STRING)
    private RolE NOMBRE;

    public Cargo( RolE NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public Cargo(){
        ;
    }

    public int getIDCARGO() {
        return IDCARGO;
    }

    public void setIDCARGO(int IDCARGO) {
        this.IDCARGO = IDCARGO;
    }

    public RolE getNombre() {
        return NOMBRE;
    }

    public void setNombre(RolE NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    
}
