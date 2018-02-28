import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public class GUIMain {

	JFrame frmFirmaSeoweb;
	JButton btnPrzydzielZlecenie, btnPokaWszystkieZlecenia, btnDodajPracownika, btnDodajZadanie;

	/**
	 * Create the application.
	 */
	public GUIMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFirmaSeoweb = new JFrame();
		frmFirmaSeoweb.setResizable(false);
		frmFirmaSeoweb.setTitle("Firma SEOWEB");
		frmFirmaSeoweb.setBounds(100, 100, 450, 300);
		frmFirmaSeoweb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFirmaSeoweb.getContentPane().setLayout(new MigLayout("", "[151px]", "[14px][23px][23px][][][][][][][][]"));
		
		JLabel lblWitajKierowniku = new JLabel("Witaj kierowniku!");
		frmFirmaSeoweb.getContentPane().add(lblWitajKierowniku, "cell 0 1,alignx left,aligny center");
		
		btnDodajPracownika = new JButton("Dodaj pracownika");
		frmFirmaSeoweb.getContentPane().add(btnDodajPracownika, "cell 0 3,alignx left,aligny center");
		
		btnDodajZadanie = new JButton("Dodaj zadanie");
		frmFirmaSeoweb.getContentPane().add(btnDodajZadanie, "cell 0 5,alignx left,aligny top");
		
		btnPokaWszystkieZlecenia = new JButton("Poka\u017C przydzielone zadania");
		frmFirmaSeoweb.getContentPane().add(btnPokaWszystkieZlecenia, "cell 0 9");
		
		btnPrzydzielZlecenie = new JButton("Przydziel zadanie");
		frmFirmaSeoweb.getContentPane().add(btnPrzydzielZlecenie, "cell 0 7");
	}
	
	

}
