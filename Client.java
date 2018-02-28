import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Client {
	
	private static int count = 0;
	
	private int id;
	private String name;
	private int lataWspolpracy;
	private Set<Order> orders = orders = new HashSet<Order>(); //Asocjacja
	private static ArrayList<Client> clients = new ArrayList<Client>(); //ekstensja klasy
	
	public Client() {}
	public Client(String name) {
		count++;
		this.id = count;
		this.name = name;
		addClient(this);
	}
	
	//Gettery i settery
	public static int getCount() {
		return count;
	}
	public int getId() {
		return this.id;
	}
	private void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLataWspolpracy() {
		return this.lataWspolpracy;
	}
	public void setLataWspolpracy(int lataWspolpracy) {
		this.lataWspolpracy = lataWspolpracy;
	}
	public Set<Order> getOrders(){
		return this.orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	//Metoda wo³ana polimorficznie
	public void work() {
		System.out.println("Obs³uga klienta " + getName());
	}
	
	//Obs³uga ekstensji
	private static void addClient(Client c) {
		clients.add(c);
	}
		
	public static Object[] getClientsObjects() {
		Object[] o = clients.toArray();
		return o;
	}	
		
	public static ArrayList<Client> getClients() {
		return clients;
	}
		
	public static void removeClient(Client c) {
		if(clients != null) {
			clients.remove(c);
		}
	}
		
	public static void printClients() {
		for(Client c : clients) {
			System.out.println(c.toString());
		}
	}
	
	public static void setClients(List<Client> list) {
		clients = (ArrayList<Client>) list;
	}
	
}
