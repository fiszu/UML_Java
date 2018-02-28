import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class GUId extends JDialog {

	private JFrame frmFirmaSeoweb;
	public JTextField textField, textField_1;
	public JButton btnDodajZadanie;

	/**
	 * Create the application.
	 */
	public GUId() {
		
	}
	public GUId(GUIMain window) {
		setTitle("Firma SEOWEB - dodawanie zadania");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][grow][grow][grow]"));
		
		JLabel lblDodawanieZadania = new JLabel("Dodawanie zadania");
		getContentPane().add(lblDodawanieZadania, "cell 0 0");
		
		JLabel lblZadanie = new JLabel("Zadanie");
		getContentPane().add(lblZadanie, "cell 0 2,alignx trailing");
		
		textField = new JTextField();
		getContentPane().add(textField, "cell 1 2,growx");
		textField.setColumns(10);
		
		JLabel lblDeadline = new JLabel("Deadline");
		getContentPane().add(lblDeadline, "cell 0 3,alignx trailing");
		
		textField_1 = new JTextField();
		getContentPane().add(textField_1, "cell 1 3,growx");
		textField_1.setColumns(10);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "cell 1 6,grow");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnDodajZadanie = new JButton("Dodaj zadanie");
		panel.add(btnDodajZadanie);
		
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
