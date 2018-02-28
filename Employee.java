import java.util.HashSet;
import java.util.Set;
import helpers.NotUniqueValue;
import helpers.WrongFormat;

public abstract class Employee {
	
	private Long id;
	private String pesel;
	private String name;
	private String surname;
	protected float wages;
	private static Set<String> pesels = new HashSet<String>();
	
	//Konstruktory
	public Employee() {}
	public Employee(String pesel, String name, String surname, float wages) {
        setPesel(pesel);
		setName(name);
		setSurname(surname);
		setWages(wages);
    }
	
	//Gettery i settery
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) throws NotUniqueValue, WrongFormat {
		if(peselUsed(pesel)) {
			//throw new NotUniqueValue();	
			pesel = "12345678901";
		}	
		else if(!pesel.matches("\\d{11}"))
			throw new WrongFormat();
		else{
			this.pesel = pesel;
			pesels.add(pesel);
		}		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public abstract float getWages(); //metoda abstrakcyjna
	
	public void setWages(float wages) {
		this.wages = wages;
	}
		
	private static boolean peselUsed(String pesel) {
		return pesels.contains(pesel);
	}
		
	
}
