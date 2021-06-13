package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.time.LocalTime;

import javax.swing.JTextField;

import controller.principale.CompanyController;
import model.common.Department;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class AddEmp {

	/** Attributes */
	public MoveJFrame frame;
	private JTextField firstName;
	private JTextField lastName;
	private JComboBox comboDepartment;
	private int idEmployee;

	/**
	 * Constructor
	 */
	public AddEmp() {
		initialize();
	}
	
	public void setIdEmployee(int idEmp){
		idEmployee = idEmp;
	}
	/**
	 * Initializer
	 */
	private void initialize() {
		
		frame = new MoveJFrame();      /** Creating the frame of our window */
		
		frame.setResizable(false);    /** Setting resizability  */
		
		frame.getContentPane().setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));   /** Setting font  */
		
		frame.getContentPane().setLayout(null);    /** Setting the free layout  */
		
		frame.setLocationRelativeTo(null);  /** Setting the free layout content type  for our frame */
						
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);  /** Declaring the window opening listener */
            }
        });
		
		
		JLabel lblEmployee = new JLabel("New Employee"); /** Creating and setting new employees title for our interface */     
		
		lblEmployee.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		
		lblEmployee.setBounds(164, 11, 117, 20);
		
		frame.getContentPane().add(lblEmployee);    /** Adding the label to the contentPane  */
		
		firstName = new JTextField();       /** Creating and setting a JTextField */
		firstName.setBounds(96, 42, 138, 20);
		frame.getContentPane().add(firstName);       /** Adding the textfield to the contentPane  */
		firstName.setColumns(10);
		
		lastName = new JTextField();       /** Creating and setting a TextField */
		lastName.setBounds(96, 73, 138, 20);
		frame.getContentPane().add(lastName);     /** Adding the textfield to the contentPane  */
		lastName.setColumns(10);
		
		comboDepartment = new JComboBox();    /** Creating and setting a comboBox */
		comboDepartment.setBounds(96, 104, 200, 22);		
		frame.getContentPane().add(comboDepartment);         /** Adding the comboBox to the contentPane  */
		
		JLabel lblFirstName = new JLabel("First name");          /** Creating and setting a textField */
		lblFirstName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblFirstName.setBounds(10, 45, 76, 14);
		frame.getContentPane().add(lblFirstName);        /** Adding the label to the contentPane  */
		
		JLabel lblLastName = new JLabel("Last name");         /** Creating and setting a textField */
		lblLastName.setBounds(10, 76, 64, 14);
		frame.getContentPane().add(lblLastName);         /** Adding the label to the contentPane  */
		
		JLabel lblDepartment = new JLabel("Department");       /** Creating and setting a textField */
		lblDepartment.setBounds(10, 108, 76, 14);
		frame.getContentPane().add(lblDepartment);         /** Adding the label to the contentPane  */
		
		JButton btnConfirm = new JButton("Confirm");           /** Creating and setting confirmation button */
		btnConfirm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnConfirm.setBounds(164, 144, 89, 23);
		btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnConfirActmionPerformed(evt);   /** Declaring confirmation buttton's action listener */
            }
        });
		frame.getContentPane().add(btnConfirm);  /** Adding the confirmation buttin to the contentPane  */
		
		JButton btnReturn = new JButton("Return");  /** Creating and setting return button */
		btnReturn.setBounds(351, 12, 89, 23);
		btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnReturnActmionPerformed(evt);  /** Return button's action listener */
            }
        });
		frame.getContentPane().add(btnReturn);  /** Adding the return button to the contentPane  */
		frame.setBounds(100, 100, 450, 216); /** Setting bounds for our frame */
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); /** Setting resizability for our frame */
		frame.setLocationRelativeTo(null);  /** Setting the free layout content type  for our frame */
		
	}
	
	protected void btnReturnActmionPerformed(ActionEvent evt) { /** Return button's action listener */
		MainEMP mainEmp = new MainEMP();
		frame.dispose();
		mainEmp.frame.setVisible(true);
	}

	protected void formWindowOpened(WindowEvent evt) { /** Window's opening action listener */
		
		for(Department depart : JGraphicMainServer.controller.departments) 
			comboDepartment.addItem(depart.getNameDepartment());
	}

	protected void btnConfirActmionPerformed(ActionEvent evt) {  /** Confirmation button's action listener */
		
		/** Confirmation button's condition */
		
		if(firstName.getText().isEmpty() || lastName.getText().isEmpty() || comboDepartment.getSelectedItem().toString().isEmpty())  JOptionPane.showMessageDialog(null,"Invalid information !");
		else
		{
			String fName = firstName.getText();
			String lName = lastName.getText();
			String depart = comboDepartment.getSelectedItem().toString();
			JGraphicMainServer.controller.AddEmployee(fName, lName, depart);
			JOptionPane.showMessageDialog(null,"New employee has been created successfully !");
			frame.dispose();
			MainEMP mainEmp = new MainEMP();
			mainEmp.frame.setVisible(true);
		}
	}

}
