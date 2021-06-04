package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.time.LocalTime;

import javax.swing.JComboBox;
import com.toedter.components.JSpinField;
import javax.swing.JButton;

public class ModifCalendar {

	public JFrame frame;
	private JSpinField spinHourStart;
	private JSpinField spinMinutesStart;
	private JComboBox comboJour;
	private JSpinField spinHourEnd;
	private JSpinField spinMinutesEnd;
	private JTextField textJob;
	private JLabel lblJob;
	
	private int idEmployee;
	private int idPlanning;
	private String jour;
	private String mission;
	
	public int getIdEmployee() {
		return idEmployee;
	}


	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}


	public int getIdPlanning() {
		return idPlanning;
	}


	public void setIdPlanning(int idPlanning) {
		this.idPlanning = idPlanning;
	}

	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public String getMission() {
		return mission;
	}
	public void setMission(String mission) {
		this.mission = mission;
	}
	/**
	 * Constructor
	 */
	public ModifCalendar() {
		initialize();
	}
/**
 * Initializer
 */
	private void initialize() {
		
		frame = new JFrame();
		
		frame.setBounds(100, 100, 450, 213);   /** Setting bounds for our frame */
		
		frame.setResizable(false);     /** Setting resizability for our frame */
		
		frame.setTitle("Calendar management");  /** Setting title for our interface */
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  /** Setting the close option for our window */
		
		frame.getContentPane().setLayout(null); /** Setting the free layout content type  for our frame */
		
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
	
		JLabel lblPlanning = new JLabel("Planning");  
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
		frame.getContentPane().add(comboJour);  /** Adding the comobox to the contentPane  */
		
		JLabel lblHourStart = new JLabel("Hour");
		lblHourStart.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblHourStart.setBounds(147, 54, 46, 14);
		frame.getContentPane().add(lblHourStart);   /** Adding the label to the contentPane  */
		
		JLabel lblMinutesStart = new JLabel("Minutes");
		lblMinutesStart.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblMinutesStart.setBounds(288, 54, 46, 14);
		frame.getContentPane().add(lblMinutesStart);    /** Adding the label to the contentPane  */
		
		spinHourStart = new JSpinField();
		spinHourStart.setBounds(192, 52, 30, 20);
		frame.getContentPane().add(spinHourStart);    /** Adding the spinField to the contentPane  */
		
		spinMinutesStart = new JSpinField();
		spinMinutesStart.setBounds(344, 52, 30, 20);
		frame.getContentPane().add(spinMinutesStart);      /** Adding the spinfield to the contentPane  */
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnConfirm.setBounds(170, 151, 89, 23);
		frame.getContentPane().add(btnConfirm);      
		
		JLabel lblHourEnd = new JLabel("Hour");
		lblHourEnd.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblHourEnd.setBounds(147, 88, 46, 14);
		frame.getContentPane().add(lblHourEnd);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblMinutes.setBounds(288, 89, 46, 14);
		frame.getContentPane().add(lblMinutes);
		
		JLabel Startlbl = new JLabel("(Start)");
		Startlbl.setBounds(79, 55, 46, 14);
		frame.getContentPane().add(Startlbl);
		
		JLabel End = new JLabel("(End)");
		End.setBounds(79, 89, 46, 14);
		frame.getContentPane().add(End);
		
		spinHourEnd = new JSpinField();
		spinHourEnd.setBounds(202, 86, 30, 20);
		frame.getContentPane().add(spinHourEnd);
		
		spinMinutesEnd = new JSpinField();
		spinMinutesEnd.setBounds(354, 86, 30, 20);
		frame.getContentPane().add(spinMinutesEnd);
		
		textJob = new JTextField();
		textJob.setBounds(311, 123, 102, 20);
		frame.getContentPane().add(textJob);
		textJob.setColumns(10);
		
		 lblJob = new JLabel("Mission title :");
		 lblJob.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblJob.setBounds(221, 126, 80, 14);
		frame.getContentPane().add(lblJob);
		
		JButton btnDelete = new JButton("Delete Pointing");
		btnDelete.setBounds(288, 12, 125, 23);
		btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	btnDeleteActionListener(evt);
            }
        });
		frame.getContentPane().add(btnDelete);/** Adding the button to the contentPane  */
		btnConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	btnConfirmActionListener(evt);
            }
        });

	}
	protected void btnDeleteActionListener(MouseEvent evt) {
		JGraphicMainClient.controller.DeleteEmployeePlanning(idEmployee, idPlanning);
		frame.dispose();
		JOptionPane.showMessageDialog(null,"Pointing has been deleted successfully !");
}


	protected void formWindowOpened(WindowEvent evt) {
		comboJour.setSelectedItem(jour);
		textJob.setText(mission);
}
	protected void btnConfirmActionListener(MouseEvent evt) {
		if(spinHourEnd.getValue() < spinHourStart.getValue() ) JOptionPane.showMessageDialog(null,"Invalide date : ShiftIn > ShiftOut !");
		else if(spinHourEnd.getValue()<0 ||  spinHourStart.getValue()<0  )JOptionPane.showMessageDialog(null,"Invalide date : Date less than 0 !");
		else if(spinHourEnd.getValue()==spinHourStart.getValue() && spinMinutesEnd.getValue()==spinMinutesStart.getValue() ) JOptionPane.showMessageDialog(null,"Invalide date : ShiftIn = ShiftOut !");
		else if(spinHourEnd.getValue()>24 ||  spinMinutesEnd.getValue()>24 ) JOptionPane.showMessageDialog(null,"Invalide date : Heure > 23 ?!");
		else if(spinMinutesEnd.getValue()>59 ||  spinMinutesStart.getValue()>59 ) JOptionPane.showMessageDialog(null,"Invalide date : Minutes > 59 ?!");
		else
		{
		String jour = comboJour.getSelectedItem().toString();
		LocalTime debut = LocalTime.of(spinHourStart.getValue(), spinMinutesStart.getValue());
		LocalTime end = LocalTime.of(spinHourEnd.getValue(), spinMinutesEnd.getValue());
		String job = textJob.getText();
		JGraphicMainClient.controller.ModifEmployeePlanning(idEmployee,idPlanning ,jour, debut, end, job);
		frame.dispose();
		JOptionPane.showMessageDialog(null,"Pointing has been modified successfully !");
		}
	}
}


