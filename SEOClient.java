import java.util.ArrayList;
import java.util.List;

public class SEOClient extends Client {

	private String domena;
	private String slowaKluczowe;
	private static ArrayList<SEOClient> seoclients = new ArrayList<SEOClient>(); //ekstensja klasy
	
	public SEOClient() {}
	public SEOClient(String name) {
		super(name);
		addSEOClient(this);
	}
	
	public void setDomena(String domena) {
		this.domena = domena;
	}
	public String getDomena() {
		return domena;
	}
	
	public void setSlowaKluczowe(String slowaKluczowe) {
		this.slowaKluczowe = slowaKluczowe;
	}
	public String getSlowaKluczowe() {
		return slowaKluczowe;
	}

	//Metoda wywo³ana polimorficznie
	public void work() {
		System.out.println("Obs³uga klienta " + getName() + " w zakresie SEO.");
	}
	
	//Obs³uga ekstensji
	private static void addSEOClient(SEOClient s) {
		seoclients.add(s);
	}
				
	public static Object[] getSEOClientsObjects() {
		Object[] o = seoclients.toArray();
		return o;
	}
				
	public static ArrayList<SEOClient> getSEOClients() {
		return seoclients;
	}
				
	public static void removeSEOClient(SEOClient s) {
		if(seoclients != null) {
			seoclients.remove(s);
		}
	}	
		
	public static void printSEOClients() {
		for(SEOClient s : seoclients) {
			System.out.println(s.toString());
		}
	}
	
	public static void setSEOClients(List<SEOClient> list) {
		seoclients = (ArrayList<SEOClient>) list;
	}
				
}
