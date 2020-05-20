package Biblioteka;

public class Book {

	public final String title; 
	public final Author author; 
	
	public Book (String title, Author author) {
		this.title = title; 
		this.author = author; 
	}
	

	public String toSTring() {
		return title + " " + author; 
	}


	public String getTitle() {
		return title;
	}


	public Author getAuthor() {
		return author;
	}
	
}
