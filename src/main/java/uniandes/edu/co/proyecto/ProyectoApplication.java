package uniandes.edu.co.proyecto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Cargo;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.Identificacion;
import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;
import uniandes.edu.co.proyecto.modelo.Persona;
import uniandes.edu.co.proyecto.modelo.PuntoAtencion;
import uniandes.edu.co.proyecto.modelo.RolE;
import uniandes.edu.co.proyecto.repositorio.CargoRepository;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;
import uniandes.edu.co.proyecto.repositorio.EmpleadoRepository;
import uniandes.edu.co.proyecto.repositorio.IdentificacionRepository;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;
import uniandes.edu.co.proyecto.repositorio.OperacionCuentaRepository;
import uniandes.edu.co.proyecto.repositorio.PersonaRepository;
import uniandes.edu.co.proyecto.repositorio.PuntoAtencionRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import org.slf4j.Logger;


@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ProyectoApplication.class);

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private OperacionCuentaRepository operacionCuentaRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String...arg)
	{
		/*
		logger.info("Iniciando consulta de vars");
		Collection<OperacionCuenta> vars = operacionCuentaRepository.darOperacionCuentas();
		logger.info("Consulta finalizada, var: {}", vars.size());
		for(OperacionCuenta c:vars){
			logger.info("var: {}", c.getIDCUENTA().getTipoCuenta());
		}
		 */

		
		logger.info("Iniciando consulta de var");
		OperacionCuenta var = operacionCuentaRepository.darOperacionCuenta(2);
		logger.info("Consulta finalizada, Var: {}", var.getIDCUENTA());
	

		/* 
		logger.info("Iniciando insercion de var");
		// Insertar el nuevo cargo utilizando el nombre del rol
		LocalDate fechaRegistroLocal = LocalDate.now(); // Usa la fecha actual o la que necesites
        Date fechaRegistro = Date.valueOf(fechaRegistroLocal);
		operacionCuentaRepository.insertarOperacionCuenta("Abrir", 300f, fechaRegistro  , 4);
		logger.info("var creado: {}",operacionCuentaRepository.darOperacionCuenta(8));
		*/
		
		



		logger.info("Iniciando update de var");
		LocalDate fechaRegistroLocal = LocalDate.now(); // Usa la fecha actual o la que necesites
        Date fechaRegistro = Date.valueOf(fechaRegistroLocal);
		operacionCuentaRepository.actualizarOperacionCuenta(8, "Cerrar", 300f, fechaRegistro , 102, 4);
		OperacionCuenta var2 = operacionCuentaRepository.darOperacionCuenta(8);
		logger.info("Actualizacion finalizada, cargo: {}", var2.getTipoOc());
		
		
		
		logger.info("Iniciando delete de var");
		operacionCuentaRepository.eliminarOperacionCuenta(8);
		logger.info("Eliminación completa");
		


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
