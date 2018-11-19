package application;
import java.util.ArrayList;
import application.Lists.ArrayIndexedList;

public class RestaurantArrayList {
	private static ArrayList<Restaurant> restaurantList;
	public RestaurantArrayList() {
		restaurantList=new ArrayList<Restaurant>();
	}
	public void addRestaurant(Restaurant toAdd) {
		restaurantList.add(toAdd);
	}
	public ArrayList<Restaurant> getList(){
		return restaurantList;
	}
	public int getSize() {
		return restaurantList.size();
	}
}
