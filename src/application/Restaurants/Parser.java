package application.Restaurants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import application.Item;

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
			Restaurant temp = new Restaurant(name, type, address, city, state, zip, phone, price);
			do{
				String[] itemArray = nextLine.split(";");
				System.out.println(itemArray[0]);
				System.out.println(itemArray.length);
				Item item = new Item(itemArray[0], itemArray[2], Double.valueOf(itemArray[1]));
				temp.addItem(item);
				nextLine = file.nextLine();
			}while(!nextLine.equals("---"));
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
