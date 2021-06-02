package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import com.toedter.components.JSpinField;
import javax.swing.JButton;

public class AddModifCalendar {

	public JFrame frame;
	
	/**
	 * Constructor
	 */
	public AddModifCalendar() {
		initialize();
	}
/**
 * Initializer
 */
	private void initialize() {
		
		frame = new JFrame();
		
		frame.setBounds(100, 100, 450, 176);   /** Setting bounds for our frame */
		
		frame.setResizable(false);     /** Setting resizability for our frame */
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  /** Setting the close option for our window */
		
		frame.getContentPane().setLayout(null); /** Setting the free layout content type  for our frame */
		

		JLabel lblPlanning = new JLabel("Planning");  
		lblPlanning.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblPlanning.setBounds(182, 11, 66, 20);
		frame.getContentPane().add(lblPlanning);  /** Adding the label to the contentPane  */
		
		JComboBox comboJour = new JComboBox();
		comboJour.setBounds(10, 50, 97, 22);
		comboJour.addItem("Lundi");
		comboJour.addItem("Mardi");
		comboJour.addItem("Mercredi");
		comboJour.addItem("Jeudi");
		comboJour.addItem("Vendredi");
		frame.getContentPane().add(comboJour);  /** Adding the comobox to the contentPane  */
		
		JLabel lblHour = new JLabel("Hour");
		lblHour.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblHour.setBounds(147, 54, 46, 14);
		frame.getContentPane().add(lblHour);   /** Adding the label to the contentPane  */
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblMinutes.setBounds(288, 54, 46, 14);
		frame.getContentPane().add(lblMinutes);    /** Adding the label to the contentPane  */
		
		JSpinField spinHour = new JSpinField();
		spinHour.setBounds(192, 52, 30, 20);
		frame.getContentPane().add(spinHour);    /** Adding the spinField to the contentPane  */
		
		JSpinField spinMinutes = new JSpinField();
		spinMinutes.setBounds(344, 52, 30, 20);
		frame.getContentPane().add(spinMinutes);      /** Adding the spinfield to the contentPane  */
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnConfirm.setBounds(162, 104, 89, 23);
		frame.getContentPane().add(btnConfirm);      /** Adding the button to the contentPane  */
	}
}
