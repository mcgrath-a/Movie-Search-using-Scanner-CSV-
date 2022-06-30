package homework6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Redbox {
	
	public static void main(String[] args) {
		
	
	ArrayList<Movie> Movies = new ArrayList<Movie>();
	File file = new File("moviedatabase.csv");
		
	
		try (Scanner fileScan = new Scanner(file)) {
			//read in each line of the file 
			while (fileScan.hasNextLine()) {
				
				
				//store the line
				String line = fileScan.nextLine();
				//System.out.println(line);
				String values[] = line.split(",");
				
				//store values  of ID
				int id = Integer.parseInt(values[0]);
				//System.out.println(id);
				
				//store values  of title
				String name = values[1];
				
				String title = values[1].substring(0, name.length() - 6);
				//System.out.println(title);
				
				//substring of ID to get the year 
				int year = Integer.parseInt(values[1].substring(name.length() - 5,name.length() - 1));
				//System.out.println(year);
				
				//replacing all dividers with commas
				String oldGenres = values[2].replace("|", ",");;
				String newGenres[] = oldGenres.split(",");
				
				
				List<String> genres = new ArrayList<String>();
				genres = Arrays.asList(newGenres);
				//System.out.println(genres);
				
				
				
				//Create instance of Movie class and assign values to its constructor
                Movie movie = new Movie(id, title, year);
                Movies.add(movie);
              
                 
                for(int i = 0; i < genres.size(); i++) {
					if(genres.get(i) != null) {
						movie.addGenre(genres.get(i));
					}
					if (genres.get(i).equals("(no genres listed)")) {
					//System.out.println(movie.title);
					continue;
					
					}
                
                //System.out.println(movie.genres);
			
                }
                
			}
			fileScan.close();
			
			try (//scanner opens
			Scanner scan = new Scanner(System.in)) {
				String messageTitle = "Here are the movies we found:\n\n"; 
				String messageTitle2 = "No movies found";
				boolean hasTitle = false;
				boolean hasYear = false;
				boolean hasGenre = false;
				int count = 0;
				String userNumber = "";
				

				
      //beginning of loop 
				 //System.out.println("Size of movies list " +  Movies.size());
				
				 System.out.println("Welcome to Redbox! \n"
				    		+ " Enter 1 to rent by movie title. \n"
				    		+ " Enter 2 to rent by year. \n"
				    		+ " Enter 3 to rent by genre. \n"
				    		+ " Enter q to quit.\n"
				    		+ "");
				 
				
      while(!userNumber.equals("q"))  {
				   
					//while user number does not equal q
				    userNumber = scan.nextLine();//move outside
				   
				    //if the user wants to exit the loop 
				   if(userNumber.equals("q")) {
				    	System.out.println("Good bye");
				    	 
				    	System.exit(0);
				    	break;
				    }
				   //this block of else if the same for all other else-if's
				    else if(userNumber.equals("1")) {
				    	  System.out.println("Enter the movie title:\n");
				    	  String movieTitle = scan.nextLine().trim(); 
				    	  count = 0;
				    	  messageTitle = "Here are the movies we found:\n\n";
				    	  if (movieTitle != "") {
							 for(Movie movie : Movies){
								 
								 if(movie.title.toLowerCase().contains(movieTitle.toLowerCase())){
								  messageTitle += movie.title +  "\n";
								  count = count + 1;
								  hasTitle = true;
								 }
							 }
							 }
							 System.out.println(hasTitle? messageTitle : messageTitle2 );
							 //System.out.println(count);
							 System.out.println( " \n Enter 1 to rent by movie title. \n"
						        		+ " Enter 2 to rent by year. \n"
						        		+ " Enter 3 to rent by genre. \n"
						        		+ " Enter q to quit.\n"
						        		+ "");
							 //continue;
				    	  }
				    else if(userNumber.equals("2")) {
				    	count = 0;
				    	
				    	  System.out.println("Enter the movie year:\n");
				    	  
				    	  //try when the user inputs a number 
				    	  try {
				    		  int movieYear = Integer.parseInt(scan.nextLine()) ; 
				    		 
				        	  messageTitle = "Here are the movies we found:\n\n";
								 for(Movie movie : Movies){  
									 if(movie.year == (movieYear)){
									  messageTitle += movie.title +  "\n";
									  count = count + 1;
									  hasYear = true;
									 }
								 }
								
								 System.out.println(hasYear? messageTitle : messageTitle2 );
								 //System.out.println(count);
								 System.out.println( " \n Enter 1 to rent by movie title. \n"
							        		+ " Enter 2 to rent by year. \n"
							        		+ " Enter 3 to rent by genre. \n"
							        		+ " Enter q to quit.\n"
							        		+ "");
								 
						// catch if the user does not input a number 
						//and prompts them to enter one  
				    	  } catch(NumberFormatException ex) {
				    		  System.out.println("\n Enter only digits for movie year.\nRe-enter (1-3) or q to quit.");
				    		  continue;
				    	  }
				    	  
				    	 
				    	  }
				    else if(userNumber.equals("3")) {
				    	count = 0;
				    	  System.out.println("Enter the movie genre:\n");
				    	  
				   
				    	  
				    	  String movieGenre= scan.nextLine().trim(); 
				    	  messageTitle = "Here are the movies we found:\n\n";
				    	  //count is testing code
				    	  
							 for(Movie movie : Movies){ 
								 for(int i = 0; i < movie.genres.size(); i++) {
									 if(movie.genres.get(i).toLowerCase().contains(movieGenre.toLowerCase())) {
										 
								  messageTitle += movie.title +  "\n";
								  count = count + 1;
								  hasGenre = true;
								 }
							 
							 }
							 }
							 System.out.println(hasGenre? messageTitle : messageTitle2 );
							 //testing count
							 //System.out.println(count);
							 System.out.println(" \n Enter 1 to rent by movie title. \n"
						        		+ " Enter 2 to rent by year. \n"
						        		+ " Enter 3 to rent by genre. \n"
						        		+ " Enter q to quit.\n"
						        		+ "");
							 
							
							 
							 }
				  //else if the user inputs anything other than 1-3 or q 
				else {
					System.out.println("Invalid option.");
					
					} 
      			}
			}
	   }
		

catch (FileNotFoundException e) {
        System.out.println("File not found!");
		}
		
		

	}} //last end bracket

