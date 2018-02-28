import helpers.PartWithoutWhole;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphicDesigner {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Technical technical; //Kompozycja
	private Set<Task> tasks = tasks = new HashSet<Task>(); //Asocjacja
	private static ArrayList<GraphicDesigner> graphics; //ekstensja klasy
	
	public GraphicDesigner() {}
	public GraphicDesigner(Technical technical) throws PartWithoutWhole {
		setTechnical(technical);
		tasks = new HashSet<Task>();
		addGraphicDesigner(this);
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
	
	public void przygotujRaporty() {
		
	}
	
	public String toString() {
		StringBuffer buff = new StringBuffer("");
		buff.append(technical.getName() + " " + technical.getSurname());
		return buff.toString();
	}
	
	//Obs³uga ekstensji
	private static void addGraphicDesigner(GraphicDesigner g) {
		if(graphics == null) {
			graphics = new ArrayList<GraphicDesigner>();
		}
		graphics.add(g);
	}
	public static void removeGraphicDesigner(GraphicDesigner g) {
		if(graphics != null) {
			graphics.remove(g);
		}
	}
	public static Object[] getGraphicDesignersObjects() {
		Object[] o = graphics.toArray();
		return o;
	}	
	public static ArrayList<GraphicDesigner> getGraphicDesigners() {
		return graphics;
	}
	public static void printGraphicDesigners() {
		for(GraphicDesigner g : graphics) {
			System.out.println(g.toString());
		}
	}
	
	public static void setGraphicDesigners(List<GraphicDesigner> list) {
		graphics = (ArrayList<GraphicDesigner>) list;
	}

}
