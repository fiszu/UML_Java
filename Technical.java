import java.util.ArrayList;
import java.util.List;

import helpers.PartWithoutWhole;

public class Technical extends Employee {

	private Long id;
	private String wyksztalcenie;
	private static ArrayList<Technical> technicals; //ekstensja klasy
	
	//Konstruktor
	public Technical() {}
	public Technical(String pesel, String name, String surname, float wages) throws PartWithoutWhole {
		super(pesel, name, surname, wages);
		addTechnical(this);
	}
	public Technical(String pesel, String name, String surname, float wages, String wyksztalcenie) throws PartWithoutWhole {
		super(pesel, name, surname, wages);
		setWyksztalcenie(wyksztalcenie);
		addTechnical(this);
	}
	
	public void setWyksztalcenie(String wyksztalcenie) {
		this.wyksztalcenie = wyksztalcenie;
	}
	public String getWyksztalcenie() {
		return wyksztalcenie;
	}
	
	public String toString() {
		return this.getName() + " " + this.getSurname() + ", pesel = " + this.getPesel();
	}
	@Override
	public float getWages() {
		return wages; //zwracam zwyk³¹ pensjê
	}
	
	//Obs³uga ekstensji
	private static void addTechnical(Technical t) {
		if(technicals == null) {
			technicals = new ArrayList<Technical>();
		}
		technicals.add(t);
	}
	public static void removeTechnical(Technical t) {
		if(technicals != null) {
			technicals.remove(t);
		}
	}
	public static ArrayList<Technical> getTechnicals() {
		return technicals;
	}
	public static void printTechnicals() {
		for(Technical w : technicals) {
			System.out.println(w.toString());
		}
	}
	
	public static void setTechnicals(List<Technical> list) {
		technicals = (ArrayList<Technical>) list;
	}
	
}
