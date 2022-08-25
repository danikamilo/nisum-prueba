package co.com.prueba.app.nisum.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.prueba.app.nisum.entities.User;


public interface IUsersModel extends JpaRepository<User, Long>  {
	
	public List<User> findByEmail(String email);

}
