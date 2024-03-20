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
@Table(name = "Personas")
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
    private int codigoPostal;

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
        this.codigoPostal = codigoPostal;
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


    public String getNombre() {
        return NOMBRE;
    }


    public void setNombre(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }


    public String getDatosContacto() {
        return DATOSCONTACTO;
    }


    public void setDatosContacto(String DATOSCONTACTO) {
        this.DATOSCONTACTO = DATOSCONTACTO;
    }


    public String getDireccionFisica() {
        return DIRECCIONFISICA;
    }


    public void setDireccionFisica(String DIRECCIONFISICA) {
        this.DIRECCIONFISICA = DIRECCIONFISICA;
    }


    public String getDireccionElectronica() {
        return DIRECCIONELECTRONICA;
    }


    public void setDireccionElectronica(String DIRECCIONELECTRONICA) {
        this.DIRECCIONELECTRONICA = DIRECCIONELECTRONICA;
    }


    public int getTelefono() {
        return TELEFONO;
    }


    public void setTelefono(int TELEFONO) {
        this.TELEFONO = TELEFONO;
    }


    public String getCiudad() {
        return CIUDAD;
    }


    public void setCiudad(String CIUDAD) {
        this.CIUDAD = CIUDAD;
    }


    public String getDepartamento() {
        return DEPARTAMENTO;
    }


    public void setDepartamento(String DEPARTAMENTO) {
        this.DEPARTAMENTO = DEPARTAMENTO;
    }


    public int getCodigoPostal() {
        return codigoPostal;
    }


    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }


    public Date getFechaRegistro() {
        return FECHAREGISTRO;
    }


    public void setFechaRegistro(Date FECHAREGISTRO) {
        this.FECHAREGISTRO = FECHAREGISTRO;
    }



    public Identificacion getDocId() {
        return DOCID;
    }


    public void setDocId(Identificacion DOCID) {
        this.DOCID = DOCID;
    }

    
}
