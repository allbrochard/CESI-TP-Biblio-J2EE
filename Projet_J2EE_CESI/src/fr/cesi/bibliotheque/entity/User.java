package fr.cesi.bibliotheque.entity;

public class User {
	private String nom;
	private String login;
	private String password;
	private Long id;

	public User(String nom, String login, String password) {
		super();
		this.nom = nom;
		this.login = login;
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
