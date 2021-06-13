package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JButton;

public class ModifDepartment {

	/** Attributes */
	public MoveJFrame frame;
	private JTextField newName;
	private int idDepartment;
	private String oldDepartName;
	private JTextField oldName;

/** Attributes Getters and setters */
	public void setIdDepartment(int idDepart)
	{
		idDepartment=idDepart;
	}
	
	public void setNameDepartment(String nameDepart)
	{
		oldDepartName=nameDepart;
	}
	
	/**
	 * Create the application.
	 */
	public ModifDepartment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new MoveJFrame(); /** Initializing JFrame object */
		frame.setBounds(100, 100, 450, 176); /** Setting the bounds of the frame */
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null); /** Setting layout to null */
		frame.setLocationRelativeTo(null); /** Setting center position to the window's popup */
		
        frame.addWindowListener(new java.awt.event.WindowAdapter() { /** Declaration of Window's opening's action listener*/
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
		
		JLabel PageTitle = new JLabel("Modify department"); /** Declaration and setting of department modification's label*/
		PageTitle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		PageTitle.setBounds(143, 11, 141, 21);
		frame.getContentPane().add(PageTitle);
		
		JLabel lblNewLabel = new JLabel("Departments new name : "); /** Declaration and setting of new department's label*/
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 74, 142, 14);
		frame.getContentPane().add(lblNewLabel);
		
		newName = new JTextField(); /** Declaration and setting of new department's textField*/
		newName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		newName.setBounds(172, 72, 252, 20);
		frame.getContentPane().add(newName);
		newName.setColumns(10);
		
		JButton btnConfirm = new JButton("Modify"); /** Declaration and setting of modification button */
		btnConfirm.setBounds(335, 103, 89, 23);
		btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { /** Declaration of modification action listener */
            	btnConfirmActivityActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnConfirm);
		
		JLabel lblNewLabel_1 = new JLabel("Departments old name : ");  /** Declaration and setting of old department  label*/
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 40, 142, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		oldName = new JTextField(); /** Declaration and setting of old department  textField*/
		oldName.setEditable(false);
		oldName.setBounds(172, 41, 252, 20);
		frame.getContentPane().add(oldName);
		oldName.setColumns(10);
		
		JButton btnNewButton = new JButton("Return"); /** Declaration and setting of return button */
		btnNewButton.setBounds(10, 104, 89, 23);
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { /** Declaration of return button action listener */
            	btnReturnActivityActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnNewButton);
	}

	protected void btnReturnActivityActionPerformed(ActionEvent evt) {  /** Return button action listener */
		frame.dispose();
		ConsultDepartments consult = new ConsultDepartments();
		consult.frame.setVisible(true);
		}

	protected void formWindowOpened(WindowEvent evt) { /** Window opening's button action listener */
		oldName.setText(oldDepartName);
	}

	protected void btnConfirmActivityActionPerformed(ActionEvent evt) { /** Confirmation button action listener */
		
		JGraphicMainServer.controller.ModifyDepartment(idDepartment, newName.getText());
		 JOptionPane.showMessageDialog(null,"Department has been modified successsfully !");
			ConsultDepartments consult = new ConsultDepartments();
			frame.dispose();
			consult.frame.setVisible(true);
		
	}
}
