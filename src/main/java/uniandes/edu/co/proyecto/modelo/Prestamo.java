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
    
    private int MONTO;
    private Float INTERES;
    private int NUMEROCUOTAS;
    private Date DIAPAGOCUOTA;
    private float VALORCUOTA;
    @Enumerated(EnumType.STRING)
    private EstadoP ESTADOP;

    //Prestamo se lleva el atributo IDCLIENTE
    @ManyToOne
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE")
    private Cliente IDCLIENTE;

    public Prestamo(int MONTO, Float INTERES, int NUMEROCUOTAS, Date DIAPAGOCUOTA, float VALORCUOTA,
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
    
    public int getMONTO() {
        return MONTO;
    }

    public void setMONTO(int MONTO) {
        this.MONTO = MONTO;
    }

    public Float getINTERES() {
        return INTERES;
    }

    public void setINTERES(Float INTERES) {
        this.INTERES = INTERES;
    }

    public int getNUMEROCUOTAS() {
        return NUMEROCUOTAS;
    }

    public void setNUMEROCUOTAS(int NUMEROCUOTAS) {
        this.NUMEROCUOTAS = NUMEROCUOTAS;
    }

    public Date getDIAPAGOCUOTA() {
        return DIAPAGOCUOTA;
    }

    public void setDIAPAGOCUOTA(Date DIAPAGOCUOTA) {
        this.DIAPAGOCUOTA = DIAPAGOCUOTA;
    }

    public float getVALORCUOTA() {
        return VALORCUOTA;
    }

    public void setVALORCUOTA(float VALORCUOTA) {
        this.VALORCUOTA = VALORCUOTA;
    }

    public EstadoP getESTADOP() {
        return ESTADOP;
    }

    public void setESTADOP(EstadoP ESTADOP) {
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
