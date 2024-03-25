package uniandes.edu.co.proyecto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.OperacionPrestamo;
import uniandes.edu.co.proyecto.modelo.OperacionTransferencia;
import uniandes.edu.co.proyecto.repositorio.OperacionPrestamoRepository;
import uniandes.edu.co.proyecto.repositorio.OperacionTransferenciaRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import org.slf4j.Logger;


@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ProyectoApplication.class);

	@Autowired
	private OperacionTransferenciaRepository operacionTransferenciaRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String...arg)
	{
		/* 
		logger.info("Iniciando consulta de vars");
		Collection<OperacionTransferencia> vars = operacionTransferenciaRepository.darOperacionTransferencias();
		logger.info("Consulta finalizada, var: {}", vars.size());
		for(OperacionTransferencia c:vars){
			logger.info("var: {}", c.getFecha());
		}
		*/

		/* 
		logger.info("Iniciando consulta de var");
		OperacionPrestamo var = operacionPrestamoRepository.darOperacionPrestamo(2);
		logger.info("Consulta finalizada, Var: {}", var.getFecha());
		*/

		/* 
		logger.info("Iniciando insercion de var");
		// Insertar el nuevo cargo utilizando el nombre del rol
		LocalDate fechaRegistroLocal = LocalDate.now(); // Usa la fecha actual o la que necesites
        Date fechaRegistro = Date.valueOf(fechaRegistroLocal);
		operacionPrestamoRepository.insertarOperacionPrestamo("PagarCuotaExtraordinaria", 200.2f, fechaRegistro, 1, 2);
		logger.info("var creado: {}",operacionPrestamoRepository.darOperacionPrestamo(8));
		*/
		
		/* 
		logger.info("Iniciando update de var");
		operacionPrestamoRepository.actualizarOperacionPrestamo(8, "PagarCuotaExtraordinaria", 200.2f, fechaRegistro, 1, 3);
		OperacionPrestamo var2 = operacionPrestamoRepository.darOperacionPrestamo(8);
		logger.info("Actualizacion finalizada, cargo: {}", var2.getMonto());
		*/
		
		/* 
		logger.info("Iniciando delete de var");
		operacionPrestamoRepository.eliminarOperacionPrestamo(8);
		logger.info("Eliminación completa");
		*/


		//Importante para persona 
		/*
		 		// Crear la fecha de registro como un objeto java.sql.Date
        LocalDate fechaRegistroLocal = LocalDate.now(); // Usa la fecha actual o la que necesites
        Date fechaRegistro = Date.valueOf(fechaRegistroLocal);

        // Asegúrate de que este objeto identificacion ya exista en tu base de datos
        Identificacion docId = identificacionRepository.darIdentificacion(887654567); 
		logger.info("Consulta finalizada, Var: {}", docId.getNumero());

		logger.info("Iniciando insercion de var");
		// Insertar el nuevo cargo utilizando el nombre del rol
		personaRepository.insertarPersona("NombrePersona", "contacto@example.com", "Calle 123", "persona@example.com", 123456789, "Ciudad", "Departamento", 12345, fechaRegistro, docId.getNumero());
		logger.info("Inserción finalizada");
		 */

	}

}
