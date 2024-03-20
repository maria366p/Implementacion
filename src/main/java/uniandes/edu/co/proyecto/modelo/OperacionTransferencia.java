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
@Table(name = "OperacionesTransferencias")
public class OperacionTransferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDOperacionTrans;
    
    private int monto;
    private Date fecha;

    //OperacionTrans se lleva el atributo IDCuenta de Origen
    @ManyToOne
    @JoinColumn(name = "IDCuentaOrigen", referencedColumnName = "IDCuenta")
    private Cuenta IDCuentaOrigen;

    //OperacionTrans se lleva el atributo IDCuenta de Destino
    @ManyToOne
    @JoinColumn(name = "IDCuentaDestino", referencedColumnName = "IDCuenta")
    private Cuenta IDCuentaDestino;

    //OperacionTrans se lleva el atributo IDPuntoAtencion
    @ManyToOne
    @JoinColumn(name = "IDPuntoAtencion", referencedColumnName = "IDPuntoAtencion")
    private PuntoAtencion IDPuntoAtencion;

    public OperacionTransferencia(int monto, Date fecha, Cuenta iDCuentaOrigen, Cuenta iDCuentaDestino,
            PuntoAtencion iDPuntoAtencion) {
        this.monto = monto;
        this.fecha = fecha;
        IDCuentaOrigen = iDCuentaOrigen;
        IDCuentaDestino = iDCuentaDestino;
        IDPuntoAtencion = iDPuntoAtencion;
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

    public Cuenta getIDCuentaOrigen() {
        return IDCuentaOrigen;
    }

    public void setIDCuentaOrigen(Cuenta iDCuentaOrigen) {
        IDCuentaOrigen = iDCuentaOrigen;
    }

    public Cuenta getIDCuentaDestino() {
        return IDCuentaDestino;
    }

    public void setIDCuentaDestino(Cuenta iDCuentaDestino) {
        IDCuentaDestino = iDCuentaDestino;
    }

    public PuntoAtencion getIDPuntoAtencion() {
        return IDPuntoAtencion;
    }

    public void setIDPuntoAtencion(PuntoAtencion iDPuntoAtencion) {
        IDPuntoAtencion = iDPuntoAtencion;
    }

    public int getIDOperacionTrans() {
        return IDOperacionTrans;
    }

    
}
