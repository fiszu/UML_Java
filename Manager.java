import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Manager extends Employee {
	
	private static final long serialVersionUID = 1L;
	private Set<Order> orders = orders = new HashSet<Order>(); //Asocjacja
	private Set<Task> tasks = tasks = new HashSet<Task>(); //Asocjacja
	private static ArrayList<Manager> managers = new ArrayList<Manager>(); //ekstensja klasy
	
	//Konstruktor
	public Manager(){}
	public Manager(String pesel, String name, String surname, float wages) throws RuntimeException {
		super(pesel, name, surname, wages);
		addManager(this);
	}
	
	public Set<Order> getOrders(){
		return this.orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	public Set<Task> getTasks(){
		return this.tasks;
	}
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
	@Override
	public float getWages() {
		return (float) (wages*2);
	}
	
	public String toString() {
		return getName() + " " + getSurname() + ", pesel = " + getPesel();
	}
	
	//Obs³uga ekstensji
	private static void addManager(Manager m) {
		managers.add(m);
	}
	
	public static Object[] getManagersObjects() {
		Object[] o = managers.toArray();
		return o;
	}	
	
	public static ArrayList<Manager> getManagers() {
		return managers;
	}
	
	public static void removeManager(Manager m) {
		if(managers != null) {
			managers.remove(m);
		}
	}
	
	public static void printManagers() {
		for(Manager m : managers) {
			System.out.println(m.toString());
		}
	}
	
	public static void setManagers(List<Manager> list) {
		managers = (ArrayList<Manager>) list;
	}
}
