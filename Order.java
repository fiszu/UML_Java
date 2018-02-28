import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String deliveryTime;
	private Client client;
	private Manager manager;
	private static ArrayList<Order> orders = new ArrayList<Order>(); //ekstensja klasy
	
	public Order() {}
	
	public Order(String name, String deliveryTime, Client client, Manager manager) {
		setName(name);
		setDeliveryTime(deliveryTime);
		setClient(client);
		setManager(manager);
		addOrder(this);
	}

	//Gettery i settery
	public Long getId() {
		return this.id;
	}
	private void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	public String getDeliveryTime() {
		return deliveryTime;
	}

	public Client getClient() {
		return this.client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	//Obs³uga ekstensji
	private static void addOrder(Order o) {
		orders.add(o);
	}
		
	public static Object[] getOrdersObjects() {
		Object[] o = orders.toArray();
		return o;
	}
		
	public static ArrayList<Order> getOrders() {
		return orders;
	}
		
	public static void removeOrder(Order o) {
		if(orders != null) {
			orders.remove(o);
		}
	}	
	public static void printOrders() {
		for(Order o : orders) {
			System.out.println(o.toString());
		}
	}
	
	public static void setOrders(List<Order> list) {
		orders = (ArrayList<Order>) list;
	}
}
