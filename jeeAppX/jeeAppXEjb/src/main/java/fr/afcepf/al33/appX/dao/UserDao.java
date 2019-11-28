package fr.afcepf.al33.appX.dao;

import java.util.List;

import javax.ejb.Local;

import fr.afcepf.al33.appX.entity.User;

@Local
public interface UserDao {
	User insertUser(User user);
	void updateUser(User user);
	void deleteUser(Integer userId);
	User getUserById(Integer userId);
	List<User> getAllUsers();
	
}
