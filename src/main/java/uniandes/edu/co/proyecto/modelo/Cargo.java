package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cargos")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDCargo;

    //Cargo no se lleva el atributo con la tabla Empleado

    private RolE nombre;

    public Cargo(int IDCargo, RolE nombre) {
        this.IDCargo = IDCargo;
        this.nombre = nombre;
    }

    public Cargo(){
        ;
    }

    public int getIDCargo() {
        return IDCargo;
    }

    public void setIDCargo(int IDCargo) {
        this.IDCargo = IDCargo;
    }

    public RolE getNombre() {
        return nombre;
    }

    public void setNombre(RolE nombre) {
        this.nombre = nombre;
    }

    
}
