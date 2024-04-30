package uniandes.edu.co.proyecto.servicios;

import java.sql.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.repositorio.OperacionTransferenciaRepository;



@Service
public class operacionTransferenciasServicio {
    private OperacionTransferenciaRepository operacionTransferenciaRepository;
    public operacionTransferenciasServicio(OperacionTransferenciaRepository operacionTransferenciaRepository)
    {
        this.operacionTransferenciaRepository = operacionTransferenciaRepository;
    }

    // Método para actualizar
    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = true)
    public void actualizar( int MONTO, Date FECHA, int IDCUENTAORIGEN, int IDCUENTADESTINO, int IDPUNTOATENCION ) throws InterruptedException {
        try {
        operacionTransferenciaRepository.insertarOperacionTransferencia(MONTO, FECHA, IDCUENTAORIGEN, IDCUENTADESTINO, IDPUNTOATENCION);
        Thread.sleep(5000); // Simular operación larga para mantener el bloqueo.
        }
        catch (Exception e) {
            System.out.println(e.getMessage()); // Manejo de excepciones.
        }
        
    }

}
