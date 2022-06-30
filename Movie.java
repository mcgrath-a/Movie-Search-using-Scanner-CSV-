package homework6;

import java.util.ArrayList;




public class Movie {
	//instance variables
	public int id;
	public String title;
	public int year;
	public ArrayList<String> genres;  
	
	//constructor
	public Movie(int id, String title, int year) {
		this.id = id;
		this.title = title;
		this.year = year;
		genres = new ArrayList<>();
		
	
	}
	public void addGenre(String genre) {
				genres.add(genre);
			}
		
	
	}
	
	

	

// last end bracket
