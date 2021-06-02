package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AddModifEmp {

	public JFrame frame;
	private JTextField firstName;
	private JTextField lastName;

	/**
	 * Constructor
	 */
	public AddModifEmp() {
		initialize();
	}
	/**
	 * Initializer
	 */
	private void initialize() {
		
		frame = new JFrame();      /** Creating the frame of our window */
		
		frame.setResizable(false);    /** Setting resizability  */
		
		frame.getContentPane().setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));   /** Setting font  */
		
		frame.getContentPane().setLayout(null);    /** Setting the free layout  */
		
		JLabel lblEmployee = new JLabel("Employee");       
		
		lblEmployee.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		
		lblEmployee.setBounds(179, 11, 76, 20);
		
		frame.getContentPane().add(lblEmployee);    /** Adding the label to the contentPane  */
		
		firstName = new JTextField();
		firstName.setBounds(96, 42, 86, 20);
		frame.getContentPane().add(firstName);       /** Adding the textfield to the contentPane  */
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(96, 73, 86, 20);
		frame.getContentPane().add(lastName);     /** Adding the textfield to the contentPane  */
		lastName.setColumns(10);
		
		JComboBox comboDepartment = new JComboBox();
		comboDepartment.setBounds(96, 104, 86, 22);		
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
		frame.getContentPane().add(btnConfirm);          /** Adding the button to the contentPane  */
		
		JButton btnDepartment = new JButton("Planning");
		btnDepartment.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnDepartment.setBounds(263, 72, 89, 23);                    
	
	    /** 
	     * Action listener for Checking planning employee button
	     * 
	     * @param ActionEvent evt (waited event)
	     */
		btnDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnPlanningActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnDepartment);
		frame.setBounds(100, 100, 450, 216);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
    /** 
     * Action listener to check Planning button
     * 
     * @param ActionEvent evt (waited event)
     */
	protected void btnPlanningActionPerformed(ActionEvent evt) {
		ConsultCalendar calendar  = new ConsultCalendar();
		calendar.frame.setVisible(true);
	}

}
