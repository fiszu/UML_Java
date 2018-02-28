import java.util.ArrayList;
import java.util.List;

import helpers.WEBInterface;

public class WEBClient extends Client implements WEBInterface {

	private String stronaWWW;
	private static ArrayList<WEBClient> webclients = new ArrayList<WEBClient>(); //ekstensja klasy
	
	public WEBClient() {}
	public WEBClient(String name){
		super(name);
		addWEBClient(this);
	}
	
	public void setStronaWWW(String stronaWWWa) {
		this.stronaWWW = stronaWWW;
	}
	public String getStronaWWW() {
		return stronaWWW;
	}

	//Metoda wywo³ana polimorficznie
	public void work() {
		System.out.println("Obs³uga klienta " + getName() + " w zakresie webdevelopingu.");
	}
	
	@Override
	public void aktualizujNowaStrone() {
		System.out.println("Aktualizacja strony klienta " + getName() + ".");
	}

	@Override
	public void tworzNowaStrone() {
		System.out.println("Tworzenie nowej strony klienta " + getName() + ".");
	}
	
	//Obs³uga ekstensji
	private static void addWEBClient(WEBClient w) {
		webclients.add(w);
	}
				
	public static Object[] getWEBClientsObjects() {
		Object[] o = webclients.toArray();
		return o;
	}
				
	public static ArrayList<WEBClient> getWEBClients() {
		return webclients;
	}
				
	public static void removeWEBClient(WEBClient w) {
		if(webclients != null) {
			webclients.remove(w);
		}
	}	
	
	public static void printWEBClients() {
		for(WEBClient w : webclients) {
			System.out.println(w.toString());
		}
	}
	
	public static void setWEBClients(List<WEBClient> list) {
		webclients = (ArrayList<WEBClient>) list;
	}
}
