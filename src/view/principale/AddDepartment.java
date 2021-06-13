package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import controller.principale.CompanyController;

import javax.swing.JButton;

public class AddDepartment {

	/** Attributes */
	public MoveJFrame frame;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public AddDepartment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new MoveJFrame();  /** Initializing JFrame object */
		frame.setBounds(100, 100, 450, 127);    /** Setting bounds for our frame */
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   /** Setting resizability for our frame */
		frame.getContentPane().setLayout(null);   /** Setting the close option for our window */
		frame.setLocationRelativeTo(null);  /** Setting the free layout content type  for our frame */
		
		JLabel PageTitle = new JLabel("New department");  /** Creating and setting department title for our interface */
		PageTitle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		PageTitle.setBounds(153, 11, 117, 21);
		frame.getContentPane().add(PageTitle);  /** Adding the label to the contentPane  */
		
		JLabel lblNewLabel = new JLabel("Department name : ");  /** Creating and setting department name's title for our interface */
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12)); 
		lblNewLabel.setBounds(21, 46, 117, 14);
		frame.getContentPane().add(lblNewLabel);   /** Adding the label to the contentPane  */
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField.setBounds(130, 44, 141, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JButton btnConfirm = new JButton("Add ");
		btnConfirm.setBounds(293, 43, 89, 23);
		btnConfirm.addActionListener(new java.awt.event.ActionListener() { /** Declaration of Confirmation button action listener */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnConfirmActivityActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnConfirm);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(10, 93, 89, 23);
		btnReturn.addActionListener(new java.awt.event.ActionListener() {  /**   Declaration of  Adding button action listener */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnReturnActivityActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnReturn);
	}

	protected void btnReturnActivityActionPerformed(ActionEvent evt) {  /** Return button action listener */
		ConsultDepartments consult = new ConsultDepartments();
		frame.dispose();
		consult.frame.setVisible(true);
	}

	protected void btnConfirmActivityActionPerformed(ActionEvent evt) {  /** Confirmation button action listener */
		
		JGraphicMainServer.controller.AddDepartment(textField.getText());
		 JOptionPane.showMessageDialog(null,"New department has been created successsfully !");
			ConsultDepartments consult = new ConsultDepartments();
			frame.dispose();
			consult.frame.setVisible(true);
	}
}
