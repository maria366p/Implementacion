package uniandes.edu.co.proyecto.modelo;

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
@Table(name = "PUNTOSATENCION")
public class PuntoAtencion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDPUNTOATENCION;
    @Enumerated(EnumType.STRING)
    private TipoA TIPO;
    private String UBICACIONGEOGRAFICA;
    private String ESTADO;

    //PA no se lleva atributo con OPPrest

    //PA se lleva atributo IDoficina
    @ManyToOne
    @JoinColumn(name = "IDOFICINA", referencedColumnName = "IDOFICINA")
    private Oficina IDOFICINA;

    public PuntoAtencion(TipoA TIPO, String UBICACIONGEOGRAFICA, String ESTADO, Oficina iDOficina) {
        this.TIPO = TIPO;
        this.UBICACIONGEOGRAFICA = UBICACIONGEOGRAFICA;
        this.ESTADO = ESTADO;
        IDOFICINA = iDOficina;
    }

    public PuntoAtencion(){
        ;
    }
    public TipoA getTipo() {
        return TIPO;
    }

    public void setTipo(TipoA TIPO) {
        this.TIPO = TIPO;
    }

    public String getUbicacionGeografica() {
        return UBICACIONGEOGRAFICA;
    }

    public void setUbicacionGeografica(String UBICACIONGEOGRAFICA) {
        this.UBICACIONGEOGRAFICA = UBICACIONGEOGRAFICA;
    }

    public String getEstado() {
        return ESTADO;
    }

    public void setEstado(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    public Oficina getIDOFICINA() {
        return IDOFICINA;
    }

    public void setIDOFICINA(Oficina iDOficina) {
        IDOFICINA = iDOficina;
    }

    public int getIdPuntoAtencion() {
        return IDPUNTOATENCION;
    }

    
}
