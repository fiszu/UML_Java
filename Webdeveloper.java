import helpers.PartWithoutWhole;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Webdeveloper implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Technical technical; //Kompozycja
	private Set<Task> tasks = tasks = new HashSet<Task>(); //Asocjacja
	private static ArrayList<Webdeveloper> webdevelopers; //ekstensja klasy
	
	public Webdeveloper() {}
	public Webdeveloper(Technical technical) throws PartWithoutWhole {
		setTechnical(technical);
		tasks = new HashSet<Task>();
		addWebdeveloper(this);
	}
	
	//Gettery i settery
	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}
	
	public Technical getTechnical() {
		return technical;
	}
	public void setTechnical(Technical technical) throws PartWithoutWhole {
		if(technical == null)
			throw new PartWithoutWhole();
		this.technical = technical;
	}
	public Set<Task> getTasks(){
		return this.tasks;
	}
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
	public String toString() {
		StringBuffer buff = new StringBuffer("");
		buff.append(technical.getName() + " " + technical.getSurname());
		return buff.toString();
	}
	
	//Obs³uga ekstensji
	private static void addWebdeveloper(Webdeveloper webdev) {
		if(webdevelopers == null) {
			webdevelopers = new ArrayList<Webdeveloper>();
		}
		webdevelopers.add(webdev);
	}
	public static void removeWebdeveloper(Webdeveloper webdev) {
		if(webdevelopers != null) {
			webdevelopers.remove(webdev);
		}
	}
	
	public static void setWebdevelopers(List<Webdeveloper> list) {
		webdevelopers = (ArrayList<Webdeveloper>) list;
	}
	
	public static ArrayList<Webdeveloper> getWebdevelopers() {
		return webdevelopers;
	}
	public static Object[] getWebdevelopersObjects() {
		Object[] o = webdevelopers.toArray();
		return o;
	}	
	public static void printWebdevelopers() {
		for(Webdeveloper w : webdevelopers) {
			System.out.println(w.toString());
		}
	}
	

}
