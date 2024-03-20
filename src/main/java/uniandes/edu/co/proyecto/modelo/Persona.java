package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    private String nombre;
    private String datosContacto;
    private String direccionFisica; 
    private String direccionElectronica;
    private int telefono;
    private String ciudad;
    private String departamento;
    private int codigoPostal;
    private Date fechaRegistro;


    //Persona no se lleva el atributo con la tabla Empleado
    @OneToOne(mappedBy = "IDEmpleado")
    private Empleado empleado;

    //Persona no se lleva el atributo con la tabla Cliente
    @OneToOne(mappedBy = "IDCliente")
    private Cliente cliente;


    //Persona se lleva el atributo docId de identificación en la tabla
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "docId", referencedColumnName = "numero") //en la columna de persona docId referenciar "numero" de identificacion
    private Identificacion docId;
    //Falta referenciar tipoId como PK



    public Persona(String nombre, String datosContacto, String direccionFisica, String direccionElectronica, int telefono, String ciudad, String departamento, int codigoPostal, Date fechaRegistro, Identificacion docId) { //Identificacion tipoId, 
        this.nombre = nombre;
        this.datosContacto = datosContacto;
        this.direccionFisica = direccionFisica;
        this.direccionElectronica = direccionElectronica;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.codigoPostal = codigoPostal;
        this.fechaRegistro = fechaRegistro;
        this.docId = docId;
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
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDatosContacto() {
        return datosContacto;
    }


    public void setDatosContacto(String datosContacto) {
        this.datosContacto = datosContacto;
    }


    public String getDireccionFisica() {
        return direccionFisica;
    }


    public void setDireccionFisica(String direccionFisica) {
        this.direccionFisica = direccionFisica;
    }


    public String getDireccionElectronica() {
        return direccionElectronica;
    }


    public void setDireccionElectronica(String direccionElectronica) {
        this.direccionElectronica = direccionElectronica;
    }


    public int getTelefono() {
        return telefono;
    }


    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


    public String getCiudad() {
        return ciudad;
    }


    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    public String getDepartamento() {
        return departamento;
    }


    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }


    public int getCodigoPostal() {
        return codigoPostal;
    }


    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }


    public Date getFechaRegistro() {
        return fechaRegistro;
    }


    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }



    public Identificacion getDocId() {
        return docId;
    }


    public void setDocId(Identificacion docId) {
        this.docId = docId;
    }

    
}
