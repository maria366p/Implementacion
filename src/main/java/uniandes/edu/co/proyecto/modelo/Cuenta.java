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

    public TipoCuenta getTIPOCUENTA() {
        return TIPOCUENTA;
    }

    public void setTIPOCUENTA(TipoCuenta TIPOCUENTA) {
        this.TIPOCUENTA = TIPOCUENTA;
    }

    public float getSALDO() {
        return SALDO;
    }

    public void setSALDO(float SALDO) {
        this.SALDO = SALDO;
    }

    public Date getFECHAULTIMATRANSACCION() {
        return FECHAULTIMATRANSACCION;
    }

    public void setFECHAULTIMATRANSACCION(Date FECHAULTIMATRANSACCION) {
        this.FECHAULTIMATRANSACCION = FECHAULTIMATRANSACCION;
    }

    public EstadoC getESTADOCUENTA() {
        return ESTADOCUENTA;
    }

    public void setESTADOCUENTA(EstadoC ESTADOCUENTA) {
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
