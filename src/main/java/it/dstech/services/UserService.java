package it.dstech.services;

import it.dstech.models.User;

public interface UserService {

	
	User saveUser(User user);

	User deleteUser(int id);
	
	User login(String username, String password);
}
