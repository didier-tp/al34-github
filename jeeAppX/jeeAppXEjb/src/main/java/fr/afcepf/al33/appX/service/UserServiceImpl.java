package fr.afcepf.al33.appX.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import fr.afcepf.al33.appX.dao.UserDao;
import fr.afcepf.al33.appX.entity.User;

//@Stateless
@Singleton
//@TransactionManagement(TransactionManagementType.CONTAINER) par défaut
// transactions gérées automatiquement par le contenueur d'EJB (partie de Jboss)
//@TransactionAttribute(TransactionAttributeType.REQUIRED) par défaut
// REQUIRED signifie besoin de .beginTransaction() et .commit()/.rollback()
public class UserServiceImpl implements UserService {
	
	@EJB //depuis EJB 3.0
	//@Inject //depuis EJB3.1 necessite META-INF/beans.xml
	private UserDao userDao;

	@Override
	public User createUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public void modifyUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void removeUser(Integer userId) {
		userDao.deleteUser(userId);
	}

	@Override
	public User findUserById(Integer userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.getAllUsers();
	}

}
