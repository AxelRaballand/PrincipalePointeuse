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
		
		frame.setLocationRelativeTo(null);
						
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
		
		
		JLabel lblEmployee = new JLabel("New Employee");       
		
		lblEmployee.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		
		lblEmployee.setBounds(164, 11, 117, 20);
		
		frame.getContentPane().add(lblEmployee);    /** Adding the label to the contentPane  */
		
		firstName = new JTextField();
		firstName.setBounds(96, 42, 138, 20);
		frame.getContentPane().add(firstName);       /** Adding the textfield to the contentPane  */
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(96, 73, 138, 20);
		frame.getContentPane().add(lastName);     /** Adding the textfield to the contentPane  */
		lastName.setColumns(10);
		
		comboDepartment = new JComboBox();
		comboDepartment.setBounds(96, 104, 200, 22);		
		frame.getContentPane().add(comboDepartment);         /** Adding the comboBox to the contentPane  */
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblFirstName.setBounds(10, 45, 76, 14);
		frame.getContentPane().add(lblFirstName);        /** Adding the label to the contentPane  */
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(10, 76, 64, 14);
		frame.getContentPane().add(lblLastName);         /** Adding the label to the contentPane  */
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(10, 108, 76, 14);
		frame.getContentPane().add(lblDepartment);         /** Adding the label to the contentPane  */
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnConfirm.setBounds(164, 144, 89, 23);
		btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnConfirActmionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnConfirm);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(351, 12, 89, 23);
		btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnReturnActmionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnReturn);
		frame.setBounds(100, 100, 450, 216);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
	
	protected void btnReturnActmionPerformed(ActionEvent evt) {
		MainEMP mainEmp = new MainEMP();
		frame.dispose();
		mainEmp.frame.setVisible(true);
	}

	protected void formWindowOpened(WindowEvent evt) {
		
		for(Department depart : JGraphicMainClient.controller.departments) 
			comboDepartment.addItem(depart.getNameDepartment());
	}

	protected void btnConfirActmionPerformed(ActionEvent evt) {
		if(firstName.getText().isEmpty() || lastName.getText().isEmpty() || comboDepartment.getSelectedItem().toString().isEmpty())  JOptionPane.showMessageDialog(null,"Invalid information !");
		else
		{
			String fName = firstName.getText();
			String lName = lastName.getText();
			String depart = comboDepartment.getSelectedItem().toString();
			JGraphicMainClient.controller.AddEmployee(fName, lName, depart);
			JOptionPane.showMessageDialog(null,"New employee has been created successfully !");
			frame.dispose();
			MainEMP mainEmp = new MainEMP();
			mainEmp.frame.setVisible(true);
		}
	}

}
