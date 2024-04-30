package uniandes.edu.co.proyecto.servicios;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.repositorio.CuentaRepository;
import uniandes.edu.co.proyecto.repositorio.OperacionCuentaRepository;

@Service
public class operacionCuentasServicio {
    private OperacionCuentaRepository operacionCuentaRepository;
    public operacionCuentasServicio(OperacionCuentaRepository operacionCuentaRepository)
    {
        this.operacionCuentaRepository = operacionCuentaRepository;
    }

    // Método para actualizar
    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = true)
    public void actualizar(  String TIPOOC, Float MONTO, Date FECHA, int IDCUENTA, int IDPUNTOATENCION ) throws InterruptedException {
        try {
        operacionCuentaRepository.insertarOperacionCuenta( TIPOOC, MONTO, FECHA, IDCUENTA, IDPUNTOATENCION);
        Thread.sleep(5000); // Simular operación larga para mantener el bloqueo.
        }
        catch (Exception e) {
            System.out.println(e.getMessage()); // Manejo de excepciones.
        }
        
    }




}
