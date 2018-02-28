import java.util.Set;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String deadline;
	private Set<Webdeveloper> webdevelopers;
	private Set<GraphicDesigner> graphicdesigners;
	private Set<Manager> managers;
	private static ArrayList<Task> tasks = new ArrayList<Task>(); //ekstensja klasy
	
	public Task() {}
	public Task(String name, String deadline) {
		setName(name);
		setDeadline(deadline);
		addTask(this);
		setWebdevelopers(new HashSet<Webdeveloper>());
		setGraphicdesigners(new HashSet<GraphicDesigner>());
		setManagers(new HashSet<Manager>());
	}
	
	public Task(String name, String deadline, Set<Webdeveloper> webdevelopers, Set<GraphicDesigner> graphicdesigners, Set<Manager> managers) {
		setName(name);
		setDeadline(deadline);
		setWebdevelopers(webdevelopers);
		setGraphicdesigners(graphicdesigners);
		setManagers(managers);
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

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	public String getDeadline() {
		return deadline;
	}

	public Set<Webdeveloper> getWebdevelopers() {
		return webdevelopers;
	}
	public static Object[] getWebdeveloperssObjects() {
		Object[] o = tasks.toArray();
		return o;
	}

	public void setWebdevelopers(Set<Webdeveloper> webdevelopers) {
		this.webdevelopers = webdevelopers;
	}

	public Set<GraphicDesigner> getGraphicdesigners() {
		return graphicdesigners;
	}

	public void setGraphicdesigners(Set<GraphicDesigner> graphics) {
		this.graphicdesigners = graphics;
	}
	
	public Set<Manager> getManagers() {
		return managers;
	}

	public void setManagers(Set<Manager> managers) {
		this.managers = managers;
	}
	
	public static void setTasks(List<Task> list) {
		tasks = (ArrayList<Task>) list;
	}
	
	public String toString() {
		StringBuffer buff = new StringBuffer("");
		buff.append(this.getName() + " - " + this.getDeadline());
		return buff.toString();
	}
	
	//Obs³uga ekstensji
	private static void addTask(Task task) {
		tasks.add(task);
	}
	
	public static Object[] getTasksObjects() {
		Object[] o = tasks.toArray();
		return o;
	}
	
	public static ArrayList<Task> getTasks() {
		return tasks;
	}
	
	public static void removeTask(Task task) {
		if(tasks != null) {
			tasks.remove(task);
		}
	}	
	public static void printTasks() {
		for(Task t : tasks) {
			System.out.println(t.toString());
		}
	}
	
}
