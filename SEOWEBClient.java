import java.util.ArrayList;
import java.util.List;

import helpers.WEBInterface;

public class SEOWEBClient extends SEOClient implements WEBInterface {

	private static ArrayList<SEOWEBClient> seowebclients = new ArrayList<SEOWEBClient>(); //ekstensja klasy
	
	public SEOWEBClient() {
		
	}
	public SEOWEBClient(String name){
		super(name);
		addSEOWEBClient(this);
	}

	//Metoda wo³ana polimorficznie
	public void work() {
		System.out.println("Pe³ne wsparcie klienta " + getName() + " (ranga Premium).");
	}

	@Override
	public void aktualizujNowaStrone() {
		System.out.println("Aktualizacja strony klienta " + getName() + " (ranga Premium).");
	}

	@Override
	public void tworzNowaStrone() {
		System.out.println("Tworzenie nowej strony klienta " + getName() + " (ranga Premium).");
	}
	
	//Obs³uga ekstensji
	private static void addSEOWEBClient(SEOWEBClient s) {
		seowebclients.add(s);
	}
				
	public static Object[] getSEOWEBClientsObjects() {
		Object[] o = seowebclients.toArray();
		return o;
	}
				
	public static ArrayList<SEOWEBClient> getSEOWEBClientss() {
		return seowebclients;
	}
				
	public static void removeSEOWEBClient(SEOWEBClient s) {
		if(seowebclients != null) {
			seowebclients.remove(s);
		}
	}	
	
	public static void printSEOWEBClients() {
		for(SEOWEBClient s : seowebclients) {
			System.out.println(s.toString());
		}
	}
	
	public static void setSEOWEBClients(List<SEOWEBClient> list) {
		seowebclients = (ArrayList<SEOWEBClient>) list;
	}
				
}
