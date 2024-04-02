package uniandes.edu.co.proyecto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Identificacion;
import uniandes.edu.co.proyecto.modelo.OperacionPrestamo;
import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.repositorio.IdentificacionRepository;
import uniandes.edu.co.proyecto.repositorio.OperacionPrestamoRepository;
import uniandes.edu.co.proyecto.repositorio.PrestamoRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import org.slf4j.Logger;


@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ProyectoApplication.class);

	@Autowired
	private IdentificacionRepository identificacionRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String...arg)
	{
		/* 
		logger.info("Iniciando consulta de vars");
		Collection<Prestamo> vars = prestamoRepository.darPrestamos();
		logger.info("Consulta finalizada, var: {}", vars.size());
		for(Prestamo c:vars){
			logger.info("var: {}", c.getValorCuota());
		}
		*/

		/* 
		logger.info("Iniciando consulta de var");
		Identificacion var = identificacionRepository.darIdentificacion(454545454);
		logger.info("Consulta finalizada, Var: {}", var.getTIPO());
		*/

		/*
		logger.info("Iniciando insercion de var");
		// Insertar el nuevo cargo utilizando el nombre del rol
		LocalDate fechaRegistroLocal = LocalDate.now(); // Usa la fecha actual
        Date fechaRegistro = Date.valueOf(fechaRegistroLocal);
		prestamoRepository.insertarPrestamo(2000.5f, 0.05f, 15, fechaRegistro, 1200, "Pagado", 1);
		 */
		
		//logger.info("var creado: {}",prestamoRepository.darPrestamo(7));
		
		
		/* 
		logger.info("Iniciando update de var");
		LocalDate fechaRegistroLocal = LocalDate.now(); // Usa la fecha actual 
        Date fechaRegistro = Date.valueOf(fechaRegistroLocal);
		prestamoRepository.actualizarPrestamo(7,2000.5f, 0.05f, 15, fechaRegistro, 4000, "Pagado", 1);
		Prestamo var2 = prestamoRepository.darPrestamo(7);
		logger.info("Actualizacion finalizada, cargo: {}", var2.getValorCuota());
		
		
		
		logger.info("Iniciando delete de var");
		prestamoRepository.eliminarPrestamo(7);
		logger.info("Eliminación completa");
		*/


		//Importante para persona 
		/*
		 		// Crear la fecha de registro como un objeto java.sql.Date
        LocalDate fechaRegistroLocal = LocalDate.now();
        Date fechaRegistro = Date.valueOf(fechaRegistroLocal);

        Identificacion docId = identificacionRepository.darIdentificacion(887654567); 
		logger.info("Consulta finalizada, Var: {}", docId.getNumero());

		logger.info("Iniciando insercion de var");
		// Insertar el nuevo cargo utilizando el nombre del rol
		personaRepository.insertarPersona("NombrePersona", "contacto@example.com", "Calle 123", "persona@example.com", 123456789, "Ciudad", "Departamento", 12345, fechaRegistro, docId.getNumero());
		logger.info("Inserción finalizada");
		 */

	}

}
