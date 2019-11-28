package fr.afcepf.al33.appX.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import fr.afcepf.al33.appX.entity.User;
import fr.afcepf.al33.appX.service.UserService;
import lombok.Getter;
import lombok.Setter;

@Named("mbConnect") //ou bien @ManagedBean("mbConnect")
@SessionScoped //en viersion entreprise/cdi ou bien jsf/faces
@Getter @Setter
public class ConnexionManagedBean implements Serializable{
	@EJB //depuis EJB 3.0
	//ou bien @Inject 
	private UserService ejbUserService;
	
	private List<User> userList; //pour <h:dataTable coté .xhtml

	private User user; //à saisir
	
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
		System.out.println("user " + user.getLogin() + "ajouté");
		return "ajouterUser.xhtml";
	}

	
	
	
}
