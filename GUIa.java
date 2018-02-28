import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.query.Query;

import helpers.HibernateHelper;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;

public class GUIa extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public GUIa() {
		
	}
	
	public GUIa(GUIMain window) {
		
		setResizable(false);
		setTitle("Firma SEOWEB - aktualnie przydzielone zadania");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[grow 0,left][grow][grow]", "[][][][50px:n][][][][][][]"));
		
		JLabel lblWybierzZadanie = new JLabel("Wybierz zadanie");
		getContentPane().add(lblWybierzZadanie, "cell 0 0,alignx left");
		
		JComboBox comboBox = new JComboBox();
		getContentPane().add(comboBox, "cell 0 1,growx");
		
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
		
		JButton btnPokaPrzydzielonychPracownikw = new JButton("Poka\u017C przydzielonych pracownik\u00F3w");
		getContentPane().add(btnPokaPrzydzielonychPracownikw, "cell 0 2");
		
		JLabel lblPrzydzieleniWebdeveloperzy = new JLabel("Przydzieleni webdeveloperzy");
		getContentPane().add(lblPrzydzieleniWebdeveloperzy, "cell 0 5");
		
		JComboBox comboBox_1 = new JComboBox();
		getContentPane().add(comboBox_1, "cell 0 6,growx,aligny top");
		
		JLabel lblGraficy = new JLabel("Graficy");
		getContentPane().add(lblGraficy, "cell 0 7");
		
		JComboBox comboBox_2 = new JComboBox();
		getContentPane().add(comboBox_2, "cell 0 8,growx,aligny top");
		
		JButton btnPowrt = new JButton("Powr\u00F3t");
		getContentPane().add(btnPowrt, "cell 2 9,alignx right");
		
		btnPowrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				window.frmFirmaSeoweb.setLocationRelativeTo(null);
				window.frmFirmaSeoweb.setVisible(true);
			}
		});
		
		btnPokaPrzydzielonychPracownikw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Task wybranyTask = (Task) comboBox.getSelectedItem();
				
				//Combobox1
				Set<Webdeveloper> webdevelopers = wybranyTask.getWebdevelopers();
				Object[] w = webdevelopers.toArray();
				comboBox_1.setModel(new DefaultComboBoxModel(w));
				comboBox_1.setRenderer(new DefaultListCellRenderer() {
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
				
				//Combobox2
				Set<GraphicDesigner> graphics = wybranyTask.getGraphicdesigners();
				Object[] g = graphics.toArray();
				comboBox_2.setModel(new DefaultComboBoxModel(g));
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
				
			}
		});
		
	}
}
