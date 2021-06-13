package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.time.LocalTime;

import javax.swing.JTextField;

import controller.principale.CompanyController;
import model.common.Department;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class ModifEmp {

	/** Attributes */
	public JFrame frame;
	private JTextField firstName;
	private JTextField lastName;
	private JComboBox comboDepartment;
	private int idEmployee;
	
	private String oldFirstName;
	private String oldLastName;
	private String oldDepartment;
	
/** Getters and setters */
	public String getOldFirstName() {
		return oldFirstName;
	}

	public void setOldFirstName(String oldFirstName) {
		this.oldFirstName = oldFirstName;
	}

	public String getOldLastName() {
		return oldLastName;
	}

	public void setOldLastName(String oldLastName) {
		this.oldLastName = oldLastName;
	}

	public String getOldDepartment() {
		return oldDepartment;
	}

	public void setOldDepartment(String oldDepartment) {
		this.oldDepartment = oldDepartment;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	/**
	 * Constructor
	 */
	public ModifEmp() {
		initialize();
	}
	
	public void setIdEmployee(int idEmp){
		idEmployee = idEmp;
	}
	/**
	 * Initializer
	 */
	private void initialize() {
		
		frame = new JFrame();      /** Creating the frame of our window */
		
		frame.setResizable(false);    /** Setting resizability  */
		
		frame.setTitle("Employee management");  /** Setting title for our interface */
		
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);     /** Setting the close option to the window's frame */
		
		frame.getContentPane().setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));   /** Setting font  */
		
		frame.getContentPane().setLayout(null);    /** Setting the free layout  */
		
		frame.setLocationRelativeTo(null); /** Setting the free layout content type  for our frame */
		
        frame.addWindowListener(new java.awt.event.WindowAdapter() { /** Declaring window's opening's action listener */
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt); 
            }
        });
		
		
		JLabel lblEmployee = new JLabel("Modify Employee");    /** Declaring and setting employee's modification label for our interface */
		
		lblEmployee.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		
		lblEmployee.setBounds(168, 11, 117, 20);
		
		frame.getContentPane().add(lblEmployee);    /** Adding the label to the contentPane  */
		
		firstName = new JTextField();
		firstName.setBounds(96, 71, 138, 20);
		frame.getContentPane().add(firstName);       /** Adding the textfield to the contentPane  */
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(96, 102, 138, 20);
		frame.getContentPane().add(lastName);     /** Adding the textfield to the contentPane  */
		lastName.setColumns(10);
		
		comboDepartment = new JComboBox();
		comboDepartment.setBounds(96, 133, 200, 22);		
		frame.getContentPane().add(comboDepartment);         /** Adding the comboBox to the contentPane  */
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblFirstName.setBounds(10, 74, 76, 14);
		frame.getContentPane().add(lblFirstName);        /** Adding the label to the contentPane  */
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblLastName.setBounds(10, 105, 64, 14);
		frame.getContentPane().add(lblLastName);         /** Adding the label to the contentPane  */
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblDepartment.setBounds(10, 137, 76, 14);
		frame.getContentPane().add(lblDepartment);         /** Adding the label to the contentPane  */
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnConfirm.setBounds(180, 166, 89, 23);
		btnConfirm.addActionListener(new java.awt.event.ActionListener() { /** Declaring confirmation button action listener */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnConfirActmionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnConfirm);          /** Adding the button to the contentPane  */
		
		JButton btnDepartment = new JButton("Planning");
		btnDepartment.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnDepartment.setBounds(297, 52, 117, 70);                    
	
	    /** 
	     * Action listener for Checking planning employee button
	     * 
	     * @param ActionEvent evt (waited event)
	     */
		btnDepartment.addActionListener(new java.awt.event.ActionListener() { /** Declaring department button action listener */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnPlanningActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnDepartment);
		
		JButton btnDelete = new JButton("Delete Employee");
		btnDelete.setBounds(10, 37, 224, 23);
		btnDelete.addActionListener(new java.awt.event.ActionListener() { /** Declaring deletion button action listener */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnDeleteActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnDelete);
		frame.setBounds(100, 100, 450, 228);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	protected void btnDeleteActionPerformed(ActionEvent evt) {  /** Deletion button action listener */
		JGraphicMainServer.controller.DeleteEmployee(idEmployee);
		JOptionPane.showMessageDialog(null,"Employee has been deleted successfully !");
		frame.dispose();
	}

	protected void formWindowOpened(WindowEvent evt) { /** Opening's window button action listener */
		
		for(Department depart : JGraphicMainServer.controller.departments) 
			comboDepartment.addItem(depart.getNameDepartment());
		
		firstName.setText(oldFirstName);
		lastName.setText(oldLastName);
		comboDepartment.setSelectedItem(oldDepartment);
	}

	protected void btnConfirActmionPerformed(ActionEvent evt) { /** Confirmation button's action listener */
		if(firstName.getText().isEmpty() || lastName.getText().isEmpty())  JOptionPane.showMessageDialog(null,"Invalid information !");
		else
		{
			String fName = firstName.getText();
			String lName = lastName.getText();
			String depart = comboDepartment.getSelectedItem().toString();
			JGraphicMainServer.controller.ModifyEmployee(idEmployee,fName,lName,depart);
			JOptionPane.showMessageDialog(null,"Employee has been modified successfully !");
			frame.dispose();
		}
	}
	/** 
     * Action listener to check Planning button
     * 
     * @param ActionEvent evt (waited event)
     */
	protected void btnPlanningActionPerformed(ActionEvent evt) { /** Adding pointing button action listener */
		frame.dispose();
		MainPlanning mainP  = new MainPlanning();
		mainP.setIdEmployee(idEmployee);
		mainP.setOldFirstName(oldFirstName);
		mainP.setOldLastName(oldLastName);
		mainP.setOldDepartment(oldDepartment);
		mainP.frame.setVisible(true);
	}
}
