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
@Table(name = "Prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDPrestamo;
    
    private float monto;
    private int interes;
    private int numeroCuotas;
    private Date diaPago;
    private float valorCuota;
    private EstadoP estadoP;

    //Prestamo se lleva el atributo IDCliente
    @ManyToOne
    @JoinColumn(name = "IDCliente", referencedColumnName = "IDCliente")
    private Cliente IDCliente;

    public Prestamo(float monto, int interes, int numeroCuotas, Date diaPago, float valorCuota,
            EstadoP estadoP, Cliente iDCliente) {
        this.monto = monto;
        this.interes = interes;
        this.numeroCuotas = numeroCuotas;
        this.diaPago = diaPago;
        this.valorCuota = valorCuota;
        this.estadoP = estadoP;
        IDCliente = iDCliente;
    }

    public Prestamo(){
        ;
    }
    
    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }

    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public Date getDiaPago() {
        return diaPago;
    }

    public void setDiaPago(Date diaPago) {
        this.diaPago = diaPago;
    }

    public float getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(float valorCuota) {
        this.valorCuota = valorCuota;
    }

    public EstadoP getEstadoP() {
        return estadoP;
    }

    public void setEstadoP(EstadoP estadoP) {
        this.estadoP = estadoP;
    }

    public Cliente getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(Cliente iDCliente) {
        IDCliente = iDCliente;
    }


    public int getIDPrestamo() {
        return IDPrestamo;
    }


}
