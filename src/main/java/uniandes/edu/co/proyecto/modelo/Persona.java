package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERSONAS")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    private String NOMBRE;
    private String DATOSCONTACTO;
    private String DIRECCIONFISICA; 
    private String DIRECCIONELECTRONICA;
    private int TELEFONO;
    private String CIUDAD;
    private String DEPARTAMENTO;

    @Column(name = "CODIGOPOSTAL")
    private int CODIGOPOSTAL;

    private Date FECHAREGISTRO;


    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Empleado empleado;

    //Persona no se lleva el atributo con la tabla Cliente
    @OneToOne(mappedBy = "persona")
    private Cliente cliente;


    //Persona se lleva el atributo DOCID de identificación en la tabla
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DOCID", referencedColumnName = "numero") //en la columna de persona DOCID referenciar "numero" de identificacion
    private Identificacion DOCID;
    //Falta referenciar tipoId como PK



    public Persona(String NOMBRE, String DATOSCONTACTO, String DIRECCIONFISICA, String DIRECCIONELECTRONICA, int TELEFONO, String CIUDAD, String DEPARTAMENTO, int codigoPostal, Date FECHAREGISTRO, Identificacion DOCID) { //Identificacion tipoId, 
        this.NOMBRE = NOMBRE;
        this.DATOSCONTACTO = DATOSCONTACTO;
        this.DIRECCIONFISICA = DIRECCIONFISICA;
        this.DIRECCIONELECTRONICA = DIRECCIONELECTRONICA;
        this.TELEFONO = TELEFONO;
        this.CIUDAD = CIUDAD;
        this.DEPARTAMENTO = DEPARTAMENTO;
        this.CODIGOPOSTAL = codigoPostal;
        this.FECHAREGISTRO = FECHAREGISTRO;
        this.DOCID = DOCID;
    }


    public Persona(){
        ;
    }


    public int ID() {
        return ID;
    }


    public void setID(int iD) {
        ID = iD;
    }


    public String getNOMBRE() {
        return NOMBRE;
    }


    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getDATOSCONTACTO() {
        return DATOSCONTACTO;
    }


    public void setDATOSCONTACTO(String DATOSCONTACTO) {
        this.DATOSCONTACTO = DATOSCONTACTO;
    }


    public String getDIRECCIONFISICA() {
        return DIRECCIONFISICA;
    }


    public void setDIRECCIONFISICA (String DIRECCIONFISICA) {
        this.DIRECCIONFISICA = DIRECCIONFISICA;
    }


    public String getDIRECCIONELECTRONICA() {
        return DIRECCIONELECTRONICA;
    }


    public void setDIRECCIONELECTRONICA(String DIRECCIONELECTRONICA) {
        this.DIRECCIONELECTRONICA = DIRECCIONELECTRONICA;
    }


    public int getTELEFONO() {
        return TELEFONO;
    }


    public void setTELEFONO(int TELEFONO) {
        this.TELEFONO = TELEFONO;
    }


    public String getCIUDAD() {
        return CIUDAD;
    }


    public void setCIUDAD(String CIUDAD) {
        this.CIUDAD = CIUDAD;
    }


    public String getDEPARTAMENTO() {
        return DEPARTAMENTO;
    }


    public void setDEPARTAMENTO(String DEPARTAMENTO) {
        this.DEPARTAMENTO = DEPARTAMENTO;
    }


    public int getCODIGOPOSTAL() {
        return CODIGOPOSTAL;
    }


    public void setCODIGOPOSTAL(int codigoPostal) {
        this.CODIGOPOSTAL = codigoPostal;
    }


    public Date getFECHAREGISTRO() {
        return FECHAREGISTRO;
    }


    public void setFECHAREGISTRO(Date FECHAREGISTRO) {
        this.FECHAREGISTRO = FECHAREGISTRO;
    }



    public Identificacion getDOCID() {
        return DOCID;
    }


    public void setDOCID(Identificacion DOCID) {
        this.DOCID = DOCID;
    }

    
}
