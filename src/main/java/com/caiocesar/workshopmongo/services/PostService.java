package com.caiocesar.workshopmongo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiocesar.workshopmongo.domain.Post;
import com.caiocesar.workshopmongo.repository.PostRepository;
import com.caiocesar.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}
	
	public List<Post> findByTitle(String text) {
		return postRepository.searchTitle(text);
	}

	public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
		// Acrescentar um dia na data final, para o programa considerar o dia original
		maxDate = maxDate.plusDays(1);
		return postRepository.fullSearch(text, minDate, maxDate);
	}
}
