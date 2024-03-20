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
@Table(name = "OPERACIONESTRANSFERENCIAS")
public class OperacionTransferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDOPERACIONTRANS;
    
    private int MONTO;
    private Date FECHA;

    //OperacionTrans se lleva el atributo IDCuenta de Origen
    @ManyToOne
    @JoinColumn(name = "IDCUENTAORIGEN", referencedColumnName = "IDCuenta")
    private Cuenta IDCUENTAORIGEN;

    //OperacionTrans se lleva el atributo IDCuenta de Destino
    @ManyToOne
    @JoinColumn(name = "IDCUENTADESTINO", referencedColumnName = "IDCuenta")
    private Cuenta IDCUENTADESTINO;

    //OperacionTrans se lleva el atributo IDPUNTOATENCION
    @ManyToOne
    @JoinColumn(name = "IDPUNTOATENCION", referencedColumnName = "IDPUNTOATENCION")
    private PuntoAtencion IDPUNTOATENCION;

    public OperacionTransferencia(int MONTO, Date FECHA, Cuenta iDCuentaOrigen, Cuenta iDCuentaDestino,
            PuntoAtencion iDPuntoAtencion) {
        this.MONTO = MONTO;
        this.FECHA = FECHA;
        IDCUENTAORIGEN = iDCuentaOrigen;
        IDCUENTADESTINO = iDCuentaDestino;
        IDPUNTOATENCION = iDPuntoAtencion;
    }

    public OperacionTransferencia(){
        ;
    }

    public int getMonto() {
        return MONTO;
    }

    public void setMonto(int MONTO) {
        this.MONTO = MONTO;
    }

    public Date getFecha() {
        return FECHA;
    }

    public void setFecha(Date FECHA) {
        this.FECHA = FECHA;
    }

    public Cuenta getIDCUENTAORIGEN() {
        return IDCUENTAORIGEN;
    }

    public void setIDCUENTAORIGEN(Cuenta iDCuentaOrigen) {
        IDCUENTAORIGEN = iDCuentaOrigen;
    }

    public Cuenta getIDCUENTADESTINO() {
        return IDCUENTADESTINO;
    }

    public void setIDCUENTADESTINO(Cuenta iDCuentaDestino) {
        IDCUENTADESTINO = iDCuentaDestino;
    }

    public PuntoAtencion getIDPUNTOATENCION() {
        return IDPUNTOATENCION;
    }

    public void setIDPUNTOATENCION(PuntoAtencion iDPuntoAtencion) {
        IDPUNTOATENCION = iDPuntoAtencion;
    }

    public int getIDOPERACIONTRANS() {
        return IDOPERACIONTRANS;
    }

    
}
