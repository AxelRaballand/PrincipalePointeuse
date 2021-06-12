package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.time.LocalTime;

import javax.swing.JComboBox;

import com.toedter.components.JSpinField;

import model.common.Time;

import javax.swing.JButton;

public class AddCalendar {

	/** Attributes */
	public JFrame frame;
	private JSpinField spinHourStart;
	private JSpinField spinMinutesStart;
	private JComboBox comboJour;
	private JSpinField spinHourEnd;
	private JSpinField spinMinutesEnd;
	private JTextField textJob;
	private JLabel lblJob;
	private int idEmployee;
	
	
	/**
	 * Constructor
	 */
	public AddCalendar() {
		initialize();
	}
	
	/** Employee Id Getters and Setters */
	public int getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}
	
/**
 * Initializer
 */
	private void initialize() {
		
		frame = new JFrame();   /** Initializing JFrame object */
		
		frame.setBounds(100, 100, 450, 213);   /** Setting bounds for our frame */
		
		frame.setResizable(false);     /** Setting resizability for our frame */
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  /** Setting the close option for our window */
		
		frame.getContentPane().setLayout(null); /** Setting the free layout content type  for our frame */
		
		
		JLabel lblPlanning = new JLabel("Planning");   /** Creating and setting planning title for our interface */
		lblPlanning.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14)); 
		lblPlanning.setBounds(182, 11, 66, 20);
		frame.getContentPane().add(lblPlanning);  /** Adding the label to the contentPane  */
		
		 comboJour = new JComboBox();
		comboJour.setBounds(10, 12, 97, 22);
		comboJour.addItem("Monday");
		comboJour.addItem("Tuesday");
		comboJour.addItem("Wednesday");
		comboJour.addItem("Thursday");
		comboJour.addItem("Friday");
		frame.getContentPane().add(comboJour);  /** Adding the combobox to the contentPane  */
		
		JLabel lblHourStart = new JLabel("Hour");
		lblHourStart.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblHourStart.setBounds(147, 54, 46, 14);
		frame.getContentPane().add(lblHourStart);   /** Adding the label to the contentPane  */
		
		JLabel lblMinutesStart = new JLabel("Minutes");
		lblMinutesStart.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblMinutesStart.setBounds(288, 54, 46, 14);
		frame.getContentPane().add(lblMinutesStart);    /** Adding the label to the contentPane  */
		
		spinHourStart = new JSpinField();   /** Spinfield of Checkin's hour  */
		spinHourStart.setBounds(192, 52, 30, 20);
		frame.getContentPane().add(spinHourStart);    /** Adding the spinField to the contentPane  */
		
		spinMinutesStart = new JSpinField();     /** Spinfield of Checkin's minutes  */
		spinMinutesStart.setBounds(344, 52, 30, 20);
		frame.getContentPane().add(spinMinutesStart);      /** Adding the spinfield to the contentPane  */
		
		
		 /** Creating and setting JButton object for our interface's confirmation action */
		JButton btnConfirm = new JButton("Confirm");  
		btnConfirm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnConfirm.setBounds(170, 151, 89, 23);
		frame.getContentPane().add(btnConfirm);   
		
		
		JLabel lblHourEnd = new JLabel("Hour");     /** Label of Checkin's hour */
		lblHourEnd.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblHourEnd.setBounds(147, 88, 46, 14);
		frame.getContentPane().add(lblHourEnd);

		JLabel lblMinutes = new JLabel("Minutes"); 		 /** Label of minutes */
		lblMinutes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblMinutes.setBounds(288, 89, 46, 14);
		frame.getContentPane().add(lblMinutes);
		JLabel Startlbl = new JLabel("(Start)"); 		/** Label of Checkin timing */
		Startlbl.setBounds(79, 55, 46, 14);
		frame.getContentPane().add(Startlbl);
		JLabel End = new JLabel("(End)"); 		/** Label of Checkout timing */

		End.setBounds(79, 89, 46, 14);
		frame.getContentPane().add(End);
		spinHourEnd = new JSpinField();		/** Spinfield of Checkout's hour  */

		spinHourEnd.setBounds(202, 86, 30, 20);
		frame.getContentPane().add(spinHourEnd);   
		
		spinMinutesEnd = new JSpinField();     /** Spinfield of Checkout's minutes  */
		spinMinutesEnd.setBounds(354, 86, 30, 20);
		frame.getContentPane().add(spinMinutesEnd);
		
		textJob = new JTextField();    /** Textfield of pointing mission : "the mission that will be done during the checkInOut */
		textJob.setBounds(311, 123, 102, 20);
		frame.getContentPane().add(textJob);
		textJob.setColumns(10);
		
		 lblJob = new JLabel("Mission title :");  /** Label of mission title */
		 lblJob.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblJob.setBounds(221, 126, 80, 14);
		frame.getContentPane().add(lblJob);/** Adding the button to the contentPane  */
		btnConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	btnConfirmActionListener(evt);   /**Confirmation button's action listener's declaration */
            }
        });

	}
	

	
	protected void btnConfirmActionListener(MouseEvent evt) { /**Interface's Confirmation button's actionListener */
		
		/**CheckInOut Conditions */
		
		if(spinHourEnd.getValue() < spinHourStart.getValue() ) JOptionPane.showMessageDialog(null,"Invalide date : ShiftIn > ShiftOut !");
		else if(spinHourEnd.getValue()<0 ||  spinHourStart.getValue()<0  )JOptionPane.showMessageDialog(null,"Invalide date : Date less than 0 !");
		else if(spinHourEnd.getValue()==spinHourStart.getValue() && spinMinutesEnd.getValue()==spinMinutesStart.getValue() ) JOptionPane.showMessageDialog(null,"Invalide date : ShiftIn = ShiftOut !");
		else if(spinHourEnd.getValue()>24 ||  spinHourStart.getValue()>24 ) JOptionPane.showMessageDialog(null,"Invalide date : Heure > 23 ?!");
		else if(spinMinutesEnd.getValue()>59 ||  spinMinutesStart.getValue()>59 ) JOptionPane.showMessageDialog(null,"Invalide date : Minutes > 59 ?!");
		else
			{
			String jour = comboJour.getSelectedItem().toString();
			LocalTime debut = LocalTime.of(spinHourStart.getValue(), spinMinutesStart.getValue());
			LocalTime end = LocalTime.of(spinHourEnd.getValue(), spinMinutesEnd.getValue());
			
			Time rounding = new Time();
			
			debut = rounding.getRoundedHour(debut);
			end = rounding.getRoundedHour(end);
			
			String job = textJob.getText();
			JGraphicMainClient.controller.AddEmployeePlanning(idEmployee, jour, debut, end, job,null);
			frame.dispose();
			JOptionPane.showMessageDialog(null,"Pointing has been added successfully !");
			}
	}
}

