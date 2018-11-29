package application.Restaurants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import application.Item;
import application.Review.Review;

public class Parser {
// Parses through text files and creates new Restaurant objects
	
	public Parser(){
		
	}
	
	public Restaurant rParse(String fileName){
		try {
			Scanner file = new Scanner(new FileReader("src/application/Restaurants/" + fileName));
			String name = file.nextLine();
			String type = file.nextLine();
			String address = file.nextLine();
			String city = file.nextLine();
			String state = file.nextLine();
			int zip = Integer.valueOf(file.nextLine());
			String phone = file.nextLine();
			String price = file.nextLine();
			
			String nextLine = file.nextLine();
			Restaurant temp = new Restaurant(name, type, address, city, state, zip, phone, price, fileName);
			do{
				String[] itemArray = nextLine.split(";");
				Item item = new Item(itemArray[0], itemArray[2], Double.valueOf(itemArray[1]));
				temp.addItem(item);
				nextLine = file.nextLine();
			}while(!nextLine.equals("---"));
			
			
			while(file.hasNextLine()){
				String[] reviewArray = file.nextLine().split(";");
				Review review = new Review(Double.valueOf(reviewArray[1]), reviewArray[2], reviewArray[0]);
				temp.addReview(review);
			}
			
			return temp;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
