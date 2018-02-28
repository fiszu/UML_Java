import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.query.Query;

import helpers.HibernateHelper;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

public class GUIb extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JButton btnPrzydziel;
	JComboBox comboBox;
	JComboBox comboBox_1, comboBox_2;
	JPanel panel;

	/**
	 * Create the dialog.
	 */
	public GUIb() {
		
	}
	public GUIb(GUIMain window) {
		setResizable(false);
		setTitle("Firma SEOWEB - Przydziel zadanie");
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Powr\u00F3t");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						window.frmFirmaSeoweb.setLocationRelativeTo(null);
						window.frmFirmaSeoweb.setVisible(true);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblWitajKierowniku = new JLabel("Przydziel zadanie");
				lblWitajKierowniku.setBounds(29, 15, 122, 14);
				lblWitajKierowniku.setVerticalAlignment(SwingConstants.TOP);
				panel.add(lblWitajKierowniku);
			}
			
			//Combobox wyboru zadania
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(Task.getTasksObjects()));
			comboBox.setRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                if(value instanceof Task && value != null){
	                    Task task = (Task) value;
	                    setText(task.toString());
	                }
	                return this;
	            }
	        } );
			comboBox.setBounds(29, 84, 272, 20);
			panel.add(comboBox);
			
			JLabel lblNewLabel = new JLabel("Wybierz zadanie");
			lblNewLabel.setBounds(29, 59, 106, 14);
			panel.add(lblNewLabel);
			{
				JLabel lblWybierzPracownika = new JLabel("Wybierz webdevelopera");
				lblWybierzPracownika.setBounds(29, 130, 152, 14);
				panel.add(lblWybierzPracownika);
			}
			{
				comboBox_1 = new JComboBox();
				comboBox_2 = new JComboBox();
			}
			
			//Combobox wyboru webdevelopera
			comboBox_1.setModel(new DefaultComboBoxModel(Webdeveloper.getWebdevelopersObjects()));
			comboBox_1.setRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                if(value instanceof Technical){
	                    Webdeveloper webdev = (Webdeveloper) value;
	                    setText(webdev.toString());
	                }
	                return this;
	            }
	        } );
			comboBox_1.setBounds(29, 155, 200, 20);
			panel.add(comboBox_1);
			
			//Combobox wyboru grafika
			comboBox_2.setModel(new DefaultComboBoxModel(GraphicDesigner.getGraphicDesignersObjects()));
			comboBox_2.setRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                if(value instanceof Technical){
	                	GraphicDesigner graphic = (GraphicDesigner) value;
	                    setText(graphic.toString());
	                }
	                return this;
	            }
	        } );
			comboBox_2.setBounds(29, 230, 200, 20);
			panel.add(comboBox_2);
			
			btnPrzydziel = new JButton("Przydziel");
			btnPrzydziel.setBounds(29, 271, 89, 23);
			panel.add(btnPrzydziel);
			
			JLabel lblWybierzGrafika = new JLabel("Wybierz grafika");
			lblWybierzGrafika.setBounds(29, 205, 122, 14);
			panel.add(lblWybierzGrafika);

		}
	}

}
