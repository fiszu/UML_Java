import org.hibernate.Session;
import helpers.*;
import java.util.Set;

import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Startujemy");
		Main main = new Main();
		
		//Dodanie przyk³adowanych danych
		//DodajDane(main);
		
		//Odczyt danych z bazy
		odczytDanych();
		
		/*
		 * GUI
		 */
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain window = new GUIMain();
					
					//Okno pokazuj¹ce przydzielone zadania
					window.btnPokaWszystkieZlecenia.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							window.frmFirmaSeoweb.setVisible(false);
							GUIa newWindow = new GUIa(window);
							newWindow.setLocationRelativeTo(null);
							newWindow.setVisible(true);
						}
					});
					
					//Okno umo¿liwiaj¹ce przydzielanie zadañ
					window.btnPrzydzielZlecenie.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							window.frmFirmaSeoweb.setVisible(false);
							GUIb newWindow = new GUIb(window);
							newWindow.setLocationRelativeTo(null);
							newWindow.setVisible(true);
							
							newWindow.btnPrzydziel.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									Task wybranyTask = (Task) newWindow.comboBox.getSelectedItem();
									Webdeveloper wybranyWebdev = (Webdeveloper) newWindow.comboBox_1.getSelectedItem();
									GraphicDesigner wybranyGrafik = (GraphicDesigner) newWindow.comboBox_2.getSelectedItem();
									main.assignTask(wybranyTask, wybranyWebdev, wybranyGrafik);
									newWindow.dispose();
									window.frmFirmaSeoweb.setLocationRelativeTo(null);
									window.frmFirmaSeoweb.setVisible(true);
								}
							});
							
							
						}
					});
					
					
					//Okno umo¿liwiaj¹ce dodania pracownika
					window.btnDodajPracownika.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							window.frmFirmaSeoweb.setVisible(false);
							GUIc newWindow = new GUIc(window);
							newWindow.setLocationRelativeTo(null);
							newWindow.setVisible(true);
							
							newWindow.btnDodajPracownika.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
									String pesel, name, surname, wyksztalcenie;
									float wages;
									
									pesel = newWindow.textField.getText();
									name = newWindow.textField_1.getText();
									surname = newWindow.textField_2.getText();
									wyksztalcenie = newWindow.textField_4.getText();
									wages = Float.parseFloat(newWindow.textField_3.getText());
								
									Technical tech = main.createTechnical(pesel, name, surname, wages, wyksztalcenie);
									if(newWindow.comboBox.getSelectedItem() == "Webdeveloper") {
										main.createWebdeveloper(tech);
									} else {
										main.createGraphicDesigner(tech);
									}
									
									newWindow.dispose();
									window.frmFirmaSeoweb.setLocationRelativeTo(null);
									window.frmFirmaSeoweb.setVisible(true);
								}
							});
						}
					});
					
					//Okno umo¿liwiaj¹ce dodania zadania
					window.btnDodajZadanie.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							window.frmFirmaSeoweb.setVisible(false);
							GUId newWindow = new GUId(window);
							newWindow.setLocationRelativeTo(null);
							newWindow.setVisible(true);
							
							newWindow.btnDodajZadanie.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
									String name, deadline;
									name = newWindow.textField.getText();
									deadline = newWindow.textField_1.getText();
									
									ArrayList<Manager> managers = Manager.getManagers();
									Manager manager = managers.get(0);
									main.createTask(name, deadline, manager);
									
									newWindow.dispose();
									window.frmFirmaSeoweb.setLocationRelativeTo(null);
									window.frmFirmaSeoweb.setVisible(true);
								}
							});
						}
					});
					
					window.frmFirmaSeoweb.setLocationRelativeTo(null);
					window.frmFirmaSeoweb.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}
	
	/**********************************************/

	/*
	 * Globalne funkcje
	 */
	
	//funkcja odpowiadaj¹ca za tworzenie zadania
	private Task createTask(String name, String deadline, Manager manager) {
		Session sess = HibernateHelper.getSessionFactory().getCurrentSession();
		if(!sess.isOpen())
			sess = HibernateHelper.getSessionFactory().openSession();
		sess.beginTransaction();
				
		Task task = new Task(name, deadline);	
		sess.save(task);
		
		/* Asocjacja Manager -- Task (* do * ) */
		Set<Task> taskiManagera = manager.getTasks();
		taskiManagera.add(task);
		manager.setTasks(taskiManagera);
		sess.update(manager);

		sess.getTransaction().commit();
		System.out.println("Zadanie zosta³o dodane do bazy.");
		return task;
	}
	
	//funkcja odpowiadaj¹ca za tworzenie pracownika technicznego
	private Technical createTechnical(String pesel, String name, String surname, float wages, String wyksztalcenie) {
		Session sess = HibernateHelper.getSessionFactory().getCurrentSession();
		if(!sess.isOpen())
			sess = HibernateHelper.getSessionFactory().openSession();
		sess.beginTransaction();
					
		Technical tech = new Technical(pesel, name, surname, wages, wyksztalcenie);	
        
		sess.save(tech);
				
		sess.getTransaction().commit();
		System.out.println("Osoba zosta³a dodana do bazy.");
		return tech;
	}
	
	//funkcja odpowiadaj¹ca za tworzenie webdevelopera
	private Webdeveloper createWebdeveloper(Technical technical) {
		Session sess = HibernateHelper.getSessionFactory().getCurrentSession();
		if(!sess.isOpen())
			sess = HibernateHelper.getSessionFactory().openSession();
		sess.beginTransaction();
						
		Webdeveloper webdev = new Webdeveloper(technical);	
		sess.save(webdev);	
		sess.getTransaction().commit();
		
		System.out.println("Webdeveloper zosta³ dodany do bazy.");
		return webdev;
	}
	
	//funkcja odpowiadaj¹ca za tworzenie grafika
	private GraphicDesigner createGraphicDesigner(Technical technical) {
		Session sess = HibernateHelper.getSessionFactory().getCurrentSession();
		if(!sess.isOpen())
			sess = HibernateHelper.getSessionFactory().openSession();
		sess.beginTransaction();
							
		GraphicDesigner g = new GraphicDesigner(technical);	
		sess.save(g);
		sess.getTransaction().commit();
				
		System.out.println("Grafik zosta³ dodany do bazy.");
		return g;
	}
	
	//funkcja odpowiadaj¹ca za tworzenie kierownika
	private Manager createManager(String pesel, String name, String surname, float wages) {
		Session sess = HibernateHelper.getSessionFactory().getCurrentSession();
		if(!sess.isOpen())
			sess = HibernateHelper.getSessionFactory().openSession();
		sess.beginTransaction();
								
		Manager m = new Manager(pesel, name, surname, wages);	
		sess.save(m);
		sess.getTransaction().commit();
				
		System.out.println("Kierownik zosta³ dodany do bazy.");
		return m;
	}
	
	//funkcja odpowiadaj¹ca za przydzielenie zadania do grafika i webdevelopera
	private void assignTask(Task task, Webdeveloper webdev, GraphicDesigner graphic) {
		Session sess = HibernateHelper.getSessionFactory().getCurrentSession();
		if(!sess.isOpen())
			sess = HibernateHelper.getSessionFactory().openSession();
		sess.beginTransaction();
					
		/* Asocjacja Webdeveloper -- Task (* do *) */
		Set<Task> taskiWebdeva = webdev.getTasks();
		taskiWebdeva.add(task);
		webdev.setTasks(taskiWebdeva);
		Set<Webdeveloper> webdevyTaska = task.getWebdevelopers();
		webdevyTaska.add(webdev);
		task.setWebdevelopers(webdevyTaska);
		
		/* Asocjacja GraphicDesigner -- Task (* do *) */
		Set<Task> taskiGrafika = graphic.getTasks();
		taskiGrafika.add(task);
		graphic.setTasks(taskiGrafika);
		Set<GraphicDesigner> graphicyTaska = task.getGraphicdesigners();
		graphicyTaska.add(graphic);
		task.setGraphicdesigners(graphicyTaska);
	
		sess.update(webdev);
		sess.update(graphic);
		sess.update(task);
		
		sess.getTransaction().commit();
				
		System.out.println("Zadanie zosta³o przydzielone do wykonania.");
	}
	//funkcja odpowiadaj¹ca za tworzenie zamówienia
	private Order createOrder(String name, String deliveryTime, Client client, Manager manager) {
		Session sess = HibernateHelper.getSessionFactory().getCurrentSession();
		if(!sess.isOpen())
			sess = HibernateHelper.getSessionFactory().openSession();
		sess.beginTransaction();
					
		Order order = new Order(name, deliveryTime, client, manager);	
		sess.save(order);
				
		sess.getTransaction().commit();
		System.out.println("Zamówienie zosta³o dodane do bazy.");
		return order;
	}
	
	//funkcja odpowiadaj¹ca za tworzenie pracownika POK
	private CustomerService createCustomerService(String pesel, String name, String surname, float wages) {
		Session sess = HibernateHelper.getSessionFactory().getCurrentSession();
		if(!sess.isOpen())
			sess = HibernateHelper.getSessionFactory().openSession();
		sess.beginTransaction();
									
		CustomerService pok = new CustomerService(pesel, name, surname, wages);	
		sess.save(pok);
				
		sess.getTransaction().commit();
		System.out.println("Pracownik POK zosta³ dodany do bazy.");
		return pok;
	}
	
	
	//funkcja odpowiadaj¹ca za tworzenie klienta
	private Client createClient(String name) {
		Session sess = HibernateHelper.getSessionFactory().getCurrentSession();
		if(!sess.isOpen())
			sess = HibernateHelper.getSessionFactory().openSession();
		sess.beginTransaction();
										
		Client c = new Client(name);	
		sess.save(c);
				
		sess.getTransaction().commit();
		System.out.println("Klient zosta³ dodany do bazy.");
		return c;
	}
	
	//funkcja odpowiadaj¹ca za tworzenie seo klienta
	private SEOClient createSEOClient(String name) {
		Session sess = HibernateHelper.getSessionFactory().getCurrentSession();
		if(!sess.isOpen())
			sess = HibernateHelper.getSessionFactory().openSession();
		sess.beginTransaction();
										
		SEOClient c = new SEOClient(name);	
		sess.save(c);
				
		sess.getTransaction().commit();
		System.out.println("Klient zosta³ dodany do bazy.");
		return c;
	}
	
	//funkcja odpowiadaj¹ca za tworzenie web klienta
	private WEBInterface createWEBClient(String name) {
		Session sess = HibernateHelper.getSessionFactory().getCurrentSession();
		if(!sess.isOpen())
			sess = HibernateHelper.getSessionFactory().openSession();
		sess.beginTransaction();
											
		WEBClient c = new WEBClient(name);	
		sess.save(c);
				
		sess.getTransaction().commit();
		System.out.println("Klient zosta³ dodany do bazy.");
		return c;
	}
		
	//funkcja odpowiadaj¹ca za tworzenie webseo klienta
	private WEBInterface createSEOWEBClient(String name) {
		Session sess = HibernateHelper.getSessionFactory().getCurrentSession();
		if(!sess.isOpen())
			sess = HibernateHelper.getSessionFactory().openSession();
		sess.beginTransaction();
											
		SEOWEBClient c = new SEOWEBClient(name);	
		sess.save(c);
				
		sess.getTransaction().commit();
		System.out.println("Klient zosta³ dodany do bazy.");
		return c;
	}
	
	private static void DodajDane(Main main) {
		//Tworzenie kierownika - dziedziczenie disjoint po klasie abstrakcyjnej Employee 
		Manager manager1 = main.createManager("76092310013", "Zbigniew", "Wysoki", 4500);
        
		 /*	
		  * Przyk³adowi klienci
		  * Dziedziczenie disjoint
		  * Client <---- {SEOClient, WEBClient}
		  * Dziedziczenie wielokrotne - interfejsy
		  * SEOClient <---- SEOWEBClient (mechanizm dziedziczenia jêzyka Java)
		  * WEBClient <---- SEOWEBClient (implementacja przy pomocy interfejsu) 
		  */
				
		Client client1 = main.createClient("TVN24");
		SEOClient client2 = main.createSEOClient("Ziaja");
		WEBInterface client3 = main.createWEBClient("Polsat");
		WEBInterface client4 = main.createSEOWEBClient("Allegro");
			
		/* 
		 * Tworzenie przyk³adowe zamówienia klienta
		 * Asocjacja Client -- Order (1 do *)
		 * Asocjacja Manager -- Order (1 do *)
		*/
		
		main.createOrder("Nowa strona","01.01.2019", client1, manager1);
				
		/* Tworzenie pracowników technicznych - dziedziczenie disjoint po klasie abstrakcyjnej Employee 
		 * ograniczenie atrybutu w³asne - pesel musi sk³adaæ siê z 11 cyfr 
		*/
		Technical tech1 = main.createTechnical("94111202145", "Filip", "Ruprich", 3500, "wyzsze");
		Technical tech2 = main.createTechnical("89083110352", "Jan", "Kowalski", 2700, "srednie");
		Technical tech3 = main.createTechnical("86100918452", "Hubert", "Malicki", 3800, "podstawowe");
		Technical tech4 = main.createTechnical("84062303442", "Anna", "Wysocka", 4200, "srednie");
		Technical tech5 = main.createTechnical("84011205719", "Henryk", "Rejent", 2900, "wyzsze");
		 
		//Tworzenie pracownika POK - dziedziczenie disjoint po klasie abstrakcyjnej Employee 
		main.createCustomerService("76110512702","Anita","Zielona",2200);
				
		/* 
		 * Dziedziczenie zrealizowane przy pomocy kompozycji - czêœæ nie mo¿e istnieæ bez ca³oœci: 
		 * Technical <- Webdeveloper; 
		 * Technical <- GraphicDesigner 
		*/
		main.createWebdeveloper(tech1);
		main.createWebdeveloper(tech3);
		main.createWebdeveloper(tech5);
		        
		main.createGraphicDesigner(tech2);
		main.createGraphicDesigner(tech4);
		
				
		//Tworzenie przyk³adowych zadañ
		main.createTask("Modyfikacja strony","10.10.2018", manager1);
		main.createTask("Aktualizacja silnika strony","12.04.2018", manager1);
		main.createTask("Nowa szata graficzna","06.09.2018", manager1);
		main.createTask("Stworzenie nowego layoutu","05.07.2018", manager1);
		main.createTask("Wgranie nowego logo strony","14.06.2018", manager1);
		main.createTask("Podmiana grafik produktowych","23.05.2018", manager1);
		main.createTask("Nowa kampania reklamowa","01.04.2018", manager1);		
        
		System.out.println("Dane za³adowane."); 
	
	}
	
	public static void odczytDanych() {
		
		Session sess = HibernateHelper.getSessionFactory().getCurrentSession();
		if(!sess.isOpen())
			sess = HibernateHelper.getSessionFactory().openSession();
		sess.beginTransaction();
		
		TypedQuery<Manager> query1 = sess.createQuery("FROM Manager");
	    List<Manager> managers = query1.getResultList();
	    Manager.setManagers(managers);
	    
		TypedQuery<Technical> query2 = sess.createQuery("FROM Technical");
	    List<Technical> technicals = query2.getResultList();
	    Technical.setTechnicals(technicals);

		TypedQuery<Webdeveloper> query3 = sess.createQuery("FROM Webdeveloper");
	    List<Webdeveloper> webdevelopers = query3.getResultList();
	    Webdeveloper.setWebdevelopers(webdevelopers);
		
		TypedQuery<GraphicDesigner> query4 = sess.createQuery("FROM GraphicDesigner");
	    List<GraphicDesigner> graphics = query4.getResultList();
	    GraphicDesigner.setGraphicDesigners(graphics);
		
		TypedQuery<Task> query5 = sess.createQuery("FROM Task");
	    List<Task> tasks = query5.getResultList();
	    Task.setTasks(tasks);
	    
		TypedQuery<Client> query6 = sess.createQuery("FROM Client");
	    List<Client> clients = query6.getResultList();
	    Client.setClients(clients);
		
		TypedQuery<SEOClient> query7 = sess.createQuery("FROM SEOClient");
	    List<SEOClient> seoclients = query7.getResultList();
	    SEOClient.setSEOClients(seoclients);
		
		TypedQuery<WEBClient> query8 = sess.createQuery("FROM WEBClient");
	    List<WEBClient> webclients = query8.getResultList();
	    WEBClient.setWEBClients(webclients);
		
		TypedQuery<SEOWEBClient> query9 = sess.createQuery("FROM SEOWEBClient");
	    List<SEOWEBClient> seowebclients = query9.getResultList();
	    SEOWEBClient.setSEOWEBClients(seowebclients);

		TypedQuery<Order> query10 = sess.createQuery("FROM Order");
	    List<Order> orders = query10.getResultList();
	    Order.setOrders(orders);
		
	    TypedQuery<CustomerService> query11 = sess.createQuery("FROM CustomerService");
	    List<CustomerService> poks2 = query11.getResultList();
	    CustomerService.setCustomerServices(poks2);
	    
		sess.getTransaction().commit();
	
	}
	
}