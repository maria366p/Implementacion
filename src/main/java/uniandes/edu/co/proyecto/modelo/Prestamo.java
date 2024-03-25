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
@Table(name = "PRESTAMOS")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDPRESTAMO;
    
    private float MONTO;
    private int INTERES;
    private int NUMEROCUOTAS;
    private Date DIAPAGOCUOTA;
    private float VALORCUOTA;
    @Enumerated(EnumType.STRING)
    private EstadoP ESTADOP;

    //Prestamo se lleva el atributo IDCLIENTE
    @ManyToOne
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE")
    private Cliente IDCLIENTE;

    public Prestamo(float MONTO, int INTERES, int NUMEROCUOTAS, Date DIAPAGOCUOTA, float VALORCUOTA,
            EstadoP ESTADOP, Cliente iDCliente) {
        this.MONTO = MONTO;
        this.INTERES = INTERES;
        this.NUMEROCUOTAS = NUMEROCUOTAS;
        this.DIAPAGOCUOTA = DIAPAGOCUOTA;
        this.VALORCUOTA = VALORCUOTA;
        this.ESTADOP = ESTADOP;
        IDCLIENTE = iDCliente;
    }

    public Prestamo(){
        ;
    }
    
    public float getMonto() {
        return MONTO;
    }

    public void setMonto(float MONTO) {
        this.MONTO = MONTO;
    }

    public int getInteres() {
        return INTERES;
    }

    public void setInteres(int INTERES) {
        this.INTERES = INTERES;
    }

    public int getNumeroCuotas() {
        return NUMEROCUOTAS;
    }

    public void setNumeroCuotas(int NUMEROCUOTAS) {
        this.NUMEROCUOTAS = NUMEROCUOTAS;
    }

    public Date getDiaPagoCuota() {
        return DIAPAGOCUOTA;
    }

    public void setDiaPagoCuota(Date DIAPAGOCUOTA) {
        this.DIAPAGOCUOTA = DIAPAGOCUOTA;
    }

    public float getValorCuota() {
        return VALORCUOTA;
    }

    public void setValorCuota(float VALORCUOTA) {
        this.VALORCUOTA = VALORCUOTA;
    }

    public EstadoP getEstadoP() {
        return ESTADOP;
    }

    public void setEstadoP(EstadoP ESTADOP) {
        this.ESTADOP = ESTADOP;
    }

    public Cliente getIDCLIENTE() {
        return IDCLIENTE;
    }

    public void setIDCLIENTE(Cliente iDCliente) {
        IDCLIENTE = iDCliente;
    }


    public int getIDPRESTAMO() {
        return IDPRESTAMO;
    }


}
