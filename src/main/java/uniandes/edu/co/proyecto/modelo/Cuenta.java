package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUENTAS")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDCUENTA;

    @Enumerated(EnumType.STRING)
    private TipoCuenta TIPOCUENTA;
    private float SALDO;
    private Date FECHAULTIMATRANSACCION;
    
    @Enumerated(EnumType.STRING)
    private EstadoC ESTADOCUENTA;

    //Cuenta se lleva el atributo IDCLIENTE
    @ManyToOne
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE")
    private Cliente IDCLIENTE;

    public Cuenta(TipoCuenta TIPOCUENTA, float SALDO, Date FECHAULTIMATRANSACCION, EstadoC ESTADOCUENTA,
            Cliente iDCliente) {
        this.TIPOCUENTA = TIPOCUENTA;
        this.SALDO = SALDO;
        this.FECHAULTIMATRANSACCION = FECHAULTIMATRANSACCION;
        this.ESTADOCUENTA = ESTADOCUENTA;
        IDCLIENTE = iDCliente;
    }

    public Cuenta(){
        ;
    }

    public TipoCuenta getTipoCuenta() {
        return TIPOCUENTA;
    }

    public void setTipoCuenta(TipoCuenta TIPOCUENTA) {
        this.TIPOCUENTA = TIPOCUENTA;
    }

    public float getSaldo() {
        return SALDO;
    }

    public void setSaldo(float SALDO) {
        this.SALDO = SALDO;
    }

    public Date getFechaUltimaTransaccion() {
        return FECHAULTIMATRANSACCION;
    }

    public void setFechaUltimaTransaccion(Date FECHAULTIMATRANSACCION) {
        this.FECHAULTIMATRANSACCION = FECHAULTIMATRANSACCION;
    }

    public EstadoC getEstadoCuenta() {
        return ESTADOCUENTA;
    }

    public void setEstadoCuenta(EstadoC ESTADOCUENTA) {
        this.ESTADOCUENTA = ESTADOCUENTA;
    }

    public Cliente getIDCLIENTE() {
        return IDCLIENTE;
    }

    public void setIDCLIENTE(Cliente iDCliente) {
        IDCLIENTE = iDCliente;
    }

    public int getIDCUENTA() {
        return IDCUENTA;
    }

    


    
}
