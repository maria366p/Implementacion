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
@Table(name = "OPERACIONESCUENTAS")
public class OperacionCuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDOPERACIONCU;
    
    private int MONTO;
    private Date FECHA;
    @Enumerated(EnumType.STRING)
    private TipoOc TIPOOC;

    //Operacioncuenta se lleva el atributo IDCUENTA
    @ManyToOne
    @JoinColumn(name = "IDCUENTA", referencedColumnName = "IDCUENTA")
    private Cuenta IDCUENTA;

    //Operacioncuenta se lleva el atributo IDPUNTOATENCION
    @ManyToOne
    @JoinColumn(name = "IDPUNTOATENCION", referencedColumnName = "IDPUNTOATENCION")
    private PuntoAtencion IDPUNTOATENCION;

    public OperacionCuenta( int MONTO, Date FECHA, TipoOc TIPOOC, Cuenta iDCuenta,
            PuntoAtencion iDPuntoAtencion) {
        this.MONTO = MONTO;
        this.FECHA = FECHA;
        this.TIPOOC = TIPOOC;
        IDCUENTA = iDCuenta;
        IDPUNTOATENCION = iDPuntoAtencion;
    }

    public OperacionCuenta(){
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

    public TipoOc getTipoOc() {
        return TIPOOC;
    }

    public void setTipoOc(TipoOc TIPOOC) {
        this.TIPOOC = TIPOOC;
    }

    public Cuenta getIDCUENTA() {
        return IDCUENTA;
    }

    public void setIDCUENTA(Cuenta iDCuenta) {
        IDCUENTA = iDCuenta;
    }

    public PuntoAtencion getIDPUNTOATENCION() {
        return IDPUNTOATENCION;
    }

    public void setIDPUNTOATENCION(PuntoAtencion iDPuntoAtencion) {
        IDPUNTOATENCION = iDPuntoAtencion;
    }

    public int getIDOPERACIONCU() {
        return IDOPERACIONCU;
    }

    
}
