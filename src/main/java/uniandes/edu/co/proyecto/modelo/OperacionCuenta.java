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
@Table(name = "OperacionesCuentas")
public class OperacionCuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDOperacionCu;
    
    private int monto;
    private Date fecha;
    private TipoOc tipoOc;

    //Operacioncuenta se lleva el atributo IDCuenta
    @ManyToOne
    @JoinColumn(name = "IDCuenta", referencedColumnName = "IDCuenta")
    private Cuenta IDCuenta;

    //Operacioncuenta se lleva el atributo IDPuntoAtencion
    @ManyToOne
    @JoinColumn(name = "IDPuntoAtencion", referencedColumnName = "IDPuntoAtencion")
    private PuntoAtencion IDPuntoAtencion;

    public OperacionCuenta( int monto, Date fecha, TipoOc tipoOc, Cuenta iDCuenta,
            PuntoAtencion iDPuntoAtencion) {
        this.monto = monto;
        this.fecha = fecha;
        this.tipoOc = tipoOc;
        IDCuenta = iDCuenta;
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

    public TipoOc getTipoOc() {
        return tipoOc;
    }

    public void setTipoOc(TipoOc tipoOc) {
        this.tipoOc = tipoOc;
    }

    public Cuenta getIDCuenta() {
        return IDCuenta;
    }

    public void setIDCuenta(Cuenta iDCuenta) {
        IDCuenta = iDCuenta;
    }

    public PuntoAtencion getIDPuntoAtencion() {
        return IDPuntoAtencion;
    }

    public void setIDPuntoAtencion(PuntoAtencion iDPuntoAtencion) {
        IDPuntoAtencion = iDPuntoAtencion;
    }

    public int getIDOperacionCu() {
        return IDOperacionCu;
    }

    
}
