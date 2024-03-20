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
@Table(name = "OperacionesPrestamos")
public class OperacionPrestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDOperacionPrestamo;

    private TipoOP tipo;
    private int monto;
    private Date fecha;

    //OperacionPrestamo se lleva el atributo IDPrestamo
    @ManyToOne
    @JoinColumn(name = "IDPrestamo", referencedColumnName = "IDPrestamo")
    private Prestamo IDPrestamo;

    //Operacionprestamo se lleva el atributo IDPuntoAtencion
    @ManyToOne
    @JoinColumn(name = "IDPuntoAtencion", referencedColumnName = "IDPuntoAtencion")
    private PuntoAtencion IDPuntoAtencion;

    public OperacionPrestamo(int iDOperacionPrestamo, TipoOP tipo, int monto, Date fecha, Prestamo iDPrestamo,
            PuntoAtencion iDPuntoAtencion) {
        IDOperacionPrestamo = iDOperacionPrestamo;
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
        IDPrestamo = iDPrestamo;
        IDPuntoAtencion = iDPuntoAtencion;
    }

    public int getIDOperacionPrestamo() {
        return IDOperacionPrestamo;
    }


    public TipoOP getTipo() {
        return tipo;
    }

    public void setTipo(TipoOP tipo) {
        this.tipo = tipo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Prestamo getIDPrestamo() {
        return IDPrestamo;
    }

    public void setIDPrestamo(Prestamo iDPrestamo) {
        IDPrestamo = iDPrestamo;
    }

    public PuntoAtencion getIDPuntoAtencion() {
        return IDPuntoAtencion;
    }

    public void setIDPuntoAtencion(PuntoAtencion iDPuntoAtencion) {
        IDPuntoAtencion = iDPuntoAtencion;
    }

    

}
