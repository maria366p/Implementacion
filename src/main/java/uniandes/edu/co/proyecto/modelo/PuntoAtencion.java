package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PuntosAtencion")
public class PuntoAtencion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPuntoAtencion;
    private TipoA tipo;
    private String ubicacionGeografica;
    private String estado;

    //PA no se lleva atributo con OPPrest

    //PA se lleva atributo IDoficina
    @ManyToOne
    @JoinColumn(name = "IDOficina", referencedColumnName = "IDOficina")
    private Oficina IDOficina;

    public PuntoAtencion(TipoA tipo, String ubicacionGeografica, String estado, Oficina iDOficina) {
        this.tipo = tipo;
        this.ubicacionGeografica = ubicacionGeografica;
        this.estado = estado;
        IDOficina = iDOficina;
    }

    public PuntoAtencion(){
        ;
    }
    public TipoA getTipo() {
        return tipo;
    }

    public void setTipo(TipoA tipo) {
        this.tipo = tipo;
    }

    public String getUbicacionGeografica() {
        return ubicacionGeografica;
    }

    public void setUbicacionGeografica(String ubicacionGeografica) {
        this.ubicacionGeografica = ubicacionGeografica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Oficina getIDOficina() {
        return IDOficina;
    }

    public void setIDOficina(Oficina iDOficina) {
        IDOficina = iDOficina;
    }

    public int getIdPuntoAtencion() {
        return idPuntoAtencion;
    }

    
}
