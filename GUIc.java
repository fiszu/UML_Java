import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;

public class GUIc extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private JFrame frmFirmaSeoweb;
	public JButton btnDodajPracownika;
	public JTextField textField, textField_1, textField_2, textField_3, textField_4;
	public JComboBox comboBox;

	/**
	 * Create the application.
	 */
	
	public GUIc() {
		
	}
	
	public GUIc(GUIMain window) {
		
		setResizable(false);
		setTitle("Firma SEOWEB - dodawanie pracownika");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][grow][]"));
		
		JLabel lblDodawaniePracownika = new JLabel("Dodawanie pracownika");
		getContentPane().add(lblDodawaniePracownika, "cell 0 0");
		
		JLabel lblPesel = new JLabel("Pesel");
		getContentPane().add(lblPesel, "cell 0 2,alignx trailing");
		
		textField = new JTextField();
		getContentPane().add(textField, "cell 1 2,growx");
		textField.setColumns(10);
		
		JLabel lblImi = new JLabel("Imi\u0119");
		getContentPane().add(lblImi, "cell 0 3,alignx trailing");
		
		textField_1 = new JTextField();
		getContentPane().add(textField_1, "cell 1 3,growx");
		textField_1.setColumns(10);
		
		JLabel lblNazwisko = new JLabel("Nazwisko");
		getContentPane().add(lblNazwisko, "cell 0 4,alignx trailing");
		
		textField_2 = new JTextField();
		getContentPane().add(textField_2, "cell 1 4,growx");
		textField_2.setColumns(10);
		
		JLabel lblPensja = new JLabel("Pensja");
		getContentPane().add(lblPensja, "cell 0 5,alignx trailing");
		
		textField_3 = new JTextField();
		getContentPane().add(textField_3, "cell 1 5,growx");
		textField_3.setColumns(10);
		
		JLabel lblWyksztacenie = new JLabel("Wykszta\u0142cenie");
		getContentPane().add(lblWyksztacenie, "cell 0 6,alignx trailing");
		
		textField_4 = new JTextField();
		getContentPane().add(textField_4, "cell 1 6,growx");
		textField_4.setColumns(10);
		
		JLabel lblZawd = new JLabel("Zaw\u00F3d");
		getContentPane().add(lblZawd, "cell 0 7,alignx trailing");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Webdeveloper", "Grafik"}));
		getContentPane().add(comboBox, "cell 1 7,growx");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "cell 1 9,grow");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnDodajPracownika = new JButton("Dodaj pracownika");
		panel.add(btnDodajPracownika);
		
		JButton btnPowrt = new JButton("Powr\u00F3t");
		panel.add(btnPowrt);
		btnPowrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				window.frmFirmaSeoweb.setLocationRelativeTo(null);
				window.frmFirmaSeoweb.setVisible(true);
			}
		});
		
	}


}
