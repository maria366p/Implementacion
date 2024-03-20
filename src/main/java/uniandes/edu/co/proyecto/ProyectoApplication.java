package uniandes.edu.co.proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Persona;
import uniandes.edu.co.proyecto.repositorio.PersonaRepository;
import java.util.Collection;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {

	@Autowired
	private PersonaRepository personaRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String...arg)
	{
		Collection<Persona> personas = personaRepository.darPersonas();
		for (Persona p: personas){
			System.out.println(p);
		}
	}

}
