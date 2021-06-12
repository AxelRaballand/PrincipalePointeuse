package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class MainEMP {

	/** Attributes */
	public MoveJFrame frame;

	/**
	 * Constructor.
	 */
	public MainEMP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new MoveJFrame(); /** Setting the bounds of the frame */
		frame.setBounds(100, 100, 385, 181);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null); /** Setting center position to the window's popup */
		
		JLabel lblNewLabel = new JLabel("Employee's Management");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel.setBounds(100, 24, 167, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnConsultEmployees = new JButton("Consult Employees"); /** Declaring  and setting employees consulting button*/
		btnConsultEmployees.setBounds(23, 55, 315, 34);
		btnConsultEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { /** Declaring employees consulting button's action listener*/
            	ConsultEmpActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnConsultEmployees); /** Adding employees consulting button to the contentPane*/


		
		JButton btnAddNewEmployee = new JButton("Add new Employee"); /** Declaring  and setting employees adding button*/
		btnAddNewEmployee.setBounds(23, 100, 315, 32);
		btnAddNewEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { /** Declaring employees adding button's action listener*/
                   AddEmpActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnAddNewEmployee);  /** Adding employees adding button to the contentPane*/
		
		JButton btnRetourner = new JButton("Return"); /** Declaring  and setting employees return button*/
		btnRetourner.setBounds(261, 0, 98, 23);
		btnRetourner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { /** Declaring employees return button's action listener*/
                   RetournerActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnRetourner); /** Adding employees adding button to the contentPane*/
	}

	protected void RetournerActionPerformed(ActionEvent evt) { /** Return button action listener*/
		frame.dispose();
		JGraphicMainClient add = new JGraphicMainClient();
		add.frame.setVisible(true);
	}

	protected void AddEmpActionPerformed(ActionEvent evt) {  /** Adding employees button action listener*/
		AddEmp add = new AddEmp();
		frame.dispose();
		add.frame.setVisible(true);
	}

	protected void ConsultEmpActionPerformed(ActionEvent evt) {  /** Consulting button action listener*/
		ConsultEmp consult = new ConsultEmp(); 
		consult.setVisible(true);
	}

}
