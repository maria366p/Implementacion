package uniandes.edu.co.proyecto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Cargo;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Identificacion;
import uniandes.edu.co.proyecto.modelo.Persona;
import uniandes.edu.co.proyecto.modelo.RolE;
import uniandes.edu.co.proyecto.repositorio.CargoRepository;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.IdentificacionRepository;
import uniandes.edu.co.proyecto.repositorio.PersonaRepository;

import java.sql.Date;
import java.util.Collection;
import org.slf4j.Logger;


@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ProyectoApplication.class);

	@Autowired
	private ClienteRepository clienteRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String...arg)
	{
		
		logger.info("Iniciando consulta de cargos");
		Collection<Cliente> var = clienteRepository.darClientes();
		logger.info("Consulta finalizada, var: {}", var.size());
		for(Cliente c:var){
			logger.info("var: {}", c.getRolC());
		}
	

		/* 
		logger.info("Iniciando consulta de ident");
		Identificacion identificacion = identificacionRepository.darIdentificacion(123456789);
		logger.info("Consulta finalizada, Ident: {}", identificacion.getNumero());
		*/

		/* 
		logger.info("Iniciando insercion de var");
		// Insertar el nuevo cargo utilizando el nombre del rol
		identificacionRepository.insertarIdentificacion(986543256, "ti");
		logger.info("var creado: {}",identificacionRepository.darIdentificacion(986543256));
		*/

		/* 
		logger.info("Iniciando update de var");
		identificacionRepository.actualizarIdentificacion(986543256, "cc");
		Identificacion var2 = identificacionRepository.darIdentificacion(986543256);
		logger.info("Actualizacion finalizada, cargo: {}", var2.getTipo());
		*/
		
		/* 
		logger.info("Iniciando delete de cargo");
		cargoRepository.eliminarCargo(2);
		logger.info("Eliminación completa");
		*/

	}

}
