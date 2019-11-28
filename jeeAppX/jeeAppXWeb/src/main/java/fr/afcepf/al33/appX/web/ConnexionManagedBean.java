package fr.afcepf.al33.appX.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.afcepf.al33.appX.entity.User;
import fr.afcepf.al33.appX.service.UserService;
import lombok.Getter;
import lombok.Setter;

@Named("mbConnect") //ou bien @ManagedBean("mbConnect")
@SessionScoped //en version entreprise/cdi ou bien jsf/faces
@Getter @Setter
public class ConnexionManagedBean implements Serializable{
	//@EJB //depuis EJB 3.0
	@Inject //possible à la place de @EJB si WEB-INF/beans.xml est present
	private UserService ejbUserService;
	
	private List<User> userList; //pour <h:dataTable coté .xhtml

	private User user; //à saisir
	private String message;
	
	public ConnexionManagedBean() {
		super();
		user = new User();
	}
	
	public String voirTousLesUsers() {
		System.out.println("ça marche");
		userList=ejbUserService.findAllUsers();
		return "touslesusers.xhtml";
	}
	
	public String createUser() {
		message="";
		user.setId(null);//NB: mbConnect.user est réutilisé car @SessionScoped sur mbConnect
		user=ejbUserService.createUser(user);
		message="user " + user.getLogin() + "ajouté avec id="+user.getId();
		System.out.println(message);
		//return "ajouterUser.xhtml";
		return null; //rester sur meme page
	}

	
	
	
}
