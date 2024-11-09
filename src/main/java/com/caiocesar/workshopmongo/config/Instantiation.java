package com.caiocesar.workshopmongo.config;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.caiocesar.workshopmongo.domain.Post;
import com.caiocesar.workshopmongo.domain.User;
import com.caiocesar.workshopmongo.dto.AuthorDTO;
import com.caiocesar.workshopmongo.repository.PostRepository;
import com.caiocesar.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		// Apagar o que tiver no banco de dados (coleção)
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com"); 
		User alex = new User(null, "Alex Green", "alex@gmail.com"); 
		User bob = new User(null, "Bob Grey", "bob@gmail.com"); 
	
		// Persistência dos dados do tipo User
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, LocalDate.parse("21/03/2018", form).atStartOfDay(ZoneId.of("GMT")).toInstant(), "Partiu viagem", "Vou viajar para São Paulo", new AuthorDTO(maria));
		Post post2 = new Post(null, LocalDate.parse("23/03/2018", form).atStartOfDay(ZoneId.of("GMT")).toInstant(), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		// Salvar os objetos como dados no banco de dados MongoDB
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(maria);
	}
}
