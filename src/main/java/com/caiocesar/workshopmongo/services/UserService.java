package com.caiocesar.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiocesar.workshopmongo.domain.User;
import com.caiocesar.workshopmongo.dto.UserDTO;
import com.caiocesar.workshopmongo.repository.UserRepository;
import com.caiocesar.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}
	
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public void delete(String id) {
		// Verificar se existe um objeto com o Id passado como argumento
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
