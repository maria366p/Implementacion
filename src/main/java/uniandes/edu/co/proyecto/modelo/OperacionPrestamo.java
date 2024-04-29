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
@Table(name = "OPERACIONESPRESTAMOS")
public class OperacionPrestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDOPERACIONPRESTAMO;

    @Enumerated(EnumType.STRING)
    private TipoOP TIPO;
    private int MONTO;
    private Date FECHA;

    //OperacionPrestamo se lleva el atributo IDPRESTAMO
    @ManyToOne
    @JoinColumn(name = "IDPRESTAMO", referencedColumnName = "IDPRESTAMO")
    private Prestamo IDPRESTAMO;

    //Operacionprestamo se lleva el atributo IDPUNTOATENCION
    @ManyToOne
    @JoinColumn(name = "IDPUNTOATENCION", referencedColumnName = "IDPUNTOATENCION")
    private PuntoAtencion IDPUNTOATENCION;

    public OperacionPrestamo(int iDOperacionPrestamo, TipoOP TIPO, int MONTO, Date FECHA, Prestamo iDPrestamo,
            PuntoAtencion iDPuntoAtencion) {
        IDOPERACIONPRESTAMO = iDOperacionPrestamo;
        this.TIPO = TIPO;
        this.MONTO = MONTO;
        this.FECHA = FECHA;
        IDPRESTAMO = iDPrestamo;
        IDPUNTOATENCION = iDPuntoAtencion;
    }

    public OperacionPrestamo(){
        ;
    }

    public int getIDOPERACIONPRESTAMO() {
        return IDOPERACIONPRESTAMO;
    }


    public TipoOP getTIPO() {
        return TIPO;
    }

    public void setTIPO(TipoOP TIPO) {
        this.TIPO = TIPO;
    }

    public int getMONTO() {
        return MONTO;
    }

    public void setMONTO(int MONTO) {
        this.MONTO = MONTO;
    }

    public Date getFECHA() {
        return FECHA;
    }

    public void setFECHA(Date FECHA) {
        this.FECHA = FECHA;
    }

    public Prestamo getIDPRESTAMO() {
        return IDPRESTAMO;
    }

    public void setIDPRESTAMO(Prestamo iDPrestamo) {
        IDPRESTAMO = iDPrestamo;
    }

    public PuntoAtencion getIDPUNTOATENCION() {
        return IDPUNTOATENCION;
    }

    public void setIDPUNTOATENCION(PuntoAtencion iDPuntoAtencion) {
        IDPUNTOATENCION = iDPuntoAtencion;
    }

    

}
