package uniandes.edu.co.proyecto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Persona;
import uniandes.edu.co.proyecto.repositorio.PersonaRepository;
import java.util.Collection;
import org.slf4j.Logger;


@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ProyectoApplication.class);

	@Autowired
	private PersonaRepository personaRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String...arg)
	{
		logger.info("Iniciando consulta de personas");
		Collection<Persona> personas = personaRepository.darPersonas();
		logger.info("Consulta finalizada, número de personas: {}", personas.size());
		for (Persona p: personas){
			logger.info("Persona: {}", p);
		}
	}

}
