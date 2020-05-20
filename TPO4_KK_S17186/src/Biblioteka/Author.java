package Biblioteka;

public class Author {

	private final String firstname; 
	private final String surname; 
	
	public Author (String firstname, String surname) {
		this.firstname=firstname; 
		this.surname=surname; 
	}
	
	public String toString() {
		return firstname + " " + surname; 
	}

	public String getFirstname() {
		return firstname;
	}

	public String getSurname() {
		return surname;
	}
}
