import java.util.ArrayList;
import java.util.List;

public class CustomerService extends Employee {
	
	private static ArrayList<CustomerService> poks = new ArrayList<CustomerService>(); //ekstensja klasy
	
	//Konstruktor
	public CustomerService(){}
	public CustomerService(String pesel, String name, String surname, float wages) throws RuntimeException {
		super(pesel, name, surname, wages);
		addCustomerService(this);
	}
	
	@Override
	public float getWages() {
		return (float) (wages*1.3);
	}
	
	public String toString() {
		return getName() + " " + getSurname() + ", pesel = " + getPesel();
	}
	
	//Obs³uga ekstensji
	private static void addCustomerService(CustomerService p) {
		poks.add(p);
	}
			
	public static Object[] getCustomerServicesObjects() {
		Object[] o = poks.toArray();
		return o;
	}
			
	public static ArrayList<CustomerService> getCustomerServices() {
		return poks;
	}
			
	public static void removeCustomerService(CustomerService p) {
		if(poks != null) {
			poks.remove(p);
		}
	}	
	public static void printCustomerServices() {
		for(CustomerService p : poks) {
			System.out.println(p.toString());
		}
	}
	
	public static void setCustomerServices(List<CustomerService> list) {
		poks = (ArrayList<CustomerService>) list;
	}
}
