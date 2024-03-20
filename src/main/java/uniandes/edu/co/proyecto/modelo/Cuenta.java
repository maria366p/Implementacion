package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDCuenta;

    private TipoCuenta tipoCuenta;
    private float saldo;
    private Date fechaUltimaTransaccion;
    private EstadoC estadoCuenta;

    //Cuenta se lleva el atributo IDCliente
    @ManyToOne
    @JoinColumn(name = "IDCliente", referencedColumnName = "IDCliente")
    private Cliente IDCliente;

    public Cuenta(TipoCuenta tipoCuenta, float saldo, Date fechaUltimaTransaccion, EstadoC estadoCuenta,
            Cliente iDCliente) {
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.fechaUltimaTransaccion = fechaUltimaTransaccion;
        this.estadoCuenta = estadoCuenta;
        IDCliente = iDCliente;
    }

    public Cuenta(){
        ;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Date getFechaUltimaTransaccion() {
        return fechaUltimaTransaccion;
    }

    public void setFechaUltimaTransaccion(Date fechaUltimaTransaccion) {
        this.fechaUltimaTransaccion = fechaUltimaTransaccion;
    }

    public EstadoC getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(EstadoC estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public Cliente getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(Cliente iDCliente) {
        IDCliente = iDCliente;
    }

    public int getIDCuenta() {
        return IDCuenta;
    }

    


    
}
