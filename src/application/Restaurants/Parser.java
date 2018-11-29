package application.Restaurants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import application.Restaurant;

public class Parser {
// Parses through text files and creates new Restaurant objects
	
	public Parser(){
		
	}
	
	public String rParse(String fileName){
		try {
			Scanner file = new Scanner(new FileReader("src/application/Restaurants/" + fileName));
			String name = file.nextLine();
			String type = file.nextLine();
			String address = file.nextLine();
			String city = file.nextLine();
			String state = file.nextLine();
			int zip = file.nextInt();
			String phone = file.nextLine();
			String price = file.nextLine();
			
			String nextLine;
			Restaurant temp = new Restaurant(name, type, address, city, state, zip, phone, price);
			do{
				nextLine = file.nextLine();
				String[] item = nextLine.split(";");
			}while(nextLine != "---");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
