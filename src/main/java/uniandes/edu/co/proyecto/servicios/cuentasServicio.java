package uniandes.edu.co.proyecto.servicios;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;

import jakarta.persistence.LockModeType;

import java.lang.Thread;
import java.util.List;
import java.util.Map;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@Service
public class cuentasServicio {
    private CuentaRepository cuentaRepository;

    public cuentasServicio(CuentaRepository cuentaRepository)
    {
        this.cuentaRepository = cuentaRepository;
    }

    // Método para consultar una cuenta y bloquear la tabla de cuentas usando el nivel de aislamiento SERIALIZABLE.
    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = true)
    public List<Object[]> consultarConsu(int IDCUENTA, Date fechaInicio, Date fechaFin) throws InterruptedException {
        List<Object[]> consignaciones = cuentaRepository.obtenerOperacionesConsignacionRetiro(IDCUENTA, fechaInicio, fechaFin); // Consultar Consignaciones.
        System.out.println("Tamaño Consignaciones" + consignaciones.size());
        Thread.sleep(20000); // Simular operación larga para mantener el bloqueo.
        consignaciones = cuentaRepository.obtenerOperacionesConsignacionRetiro(IDCUENTA, fechaInicio, fechaFin); // Consultar Consignaciones.


        return consignaciones; // Devolver el bar consultado.
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = true)
    public List<Object[]> consultarTrans(int IDCUENTA,Date fechaInicio, Date fechaFin) throws InterruptedException {
        
        
        List<Object[]> transferencias = cuentaRepository.obtenerOperacionesTransferencias(IDCUENTA, fechaInicio, fechaFin);
       
        System.out.println("Tamaño Transferencias" + transferencias.size());
        Thread.sleep(10000); // Simular operación larga para mantener el bloqueo.
        transferencias = cuentaRepository.obtenerOperacionesTransferencias(IDCUENTA, fechaInicio, fechaFin); // Consultar Consignaciones


        return transferencias; // Devolver el bar consultado.
    }

    // Método para consultar una cuenta y bloquear la tabla de cuentas usando el nivel de aislamiento SERIALIZABLE.
    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<Object[]> consultarConsuR(int IDCUENTA, Date fechaInicio, Date fechaFin) throws InterruptedException {
        List<Object[]> consignaciones = cuentaRepository.obtenerOperacionesConsignacionRetiro(IDCUENTA, fechaInicio, fechaFin); // Consultar Consignaciones.
        System.out.println("Tamaño Consignaciones" + consignaciones.size());
        Thread.sleep(20000); // Simular operación larga para mantener el bloqueo.
        consignaciones = cuentaRepository.obtenerOperacionesConsignacionRetiro(IDCUENTA, fechaInicio, fechaFin); // Consultar Consignaciones.


        return consignaciones; // Devolver el bar consultado.
    }


    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<Object[]> consultarTransR(int IDCUENTA,Date fechaInicio, Date fechaFin) throws InterruptedException {
        
        
        List<Object[]> transferencias = cuentaRepository.obtenerOperacionesTransferencias(IDCUENTA, fechaInicio, fechaFin);
       
        System.out.println("Tamaño Transferencias" + transferencias.size());
        Thread.sleep(10000); // Simular operación larga para mantener el bloqueo.
        transferencias = cuentaRepository.obtenerOperacionesTransferencias(IDCUENTA, fechaInicio, fechaFin); // Consultar Consignaciones


        return transferencias; // Devolver el bar consultado.
    }

    // Método para consignar 
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void consignar(Integer IDCUENTA, Float SALDO) throws InterruptedException {
        try {
            cuentaRepository.consignarSaldo(IDCUENTA,SALDO);
            Thread.sleep(100); // Simular operación larga para mantener el bloqueo.
        }
        catch (Exception e) {
            System.out.println(e.getMessage()); // Manejo de excepciones.
        }
        
    }

    // Método para retirar 
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void retirar(Integer IDCUENTA, Float SALDO) throws InterruptedException {
        try {
            cuentaRepository.retirarSaldo(IDCUENTA,SALDO);
            Thread.sleep(100); // Simular operación larga para mantener el bloqueo.
        }
        catch (Exception e) {
            System.out.println(e.getMessage()); // Manejo de excepciones.
        }
        
    }

    
}
