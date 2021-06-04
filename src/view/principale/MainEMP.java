package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class MainEMP {

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
		frame = new MoveJFrame();
		frame.setBounds(100, 100, 385, 181);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Employee's Management");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel.setBounds(100, 24, 167, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnConsultEmployees = new JButton("Consult Employees");
		btnConsultEmployees.setBounds(23, 55, 315, 34);
		btnConsultEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	ConsultEmpActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnConsultEmployees);


		
		JButton btnAddNewEmployee = new JButton("Add new Employee");
		btnAddNewEmployee.setBounds(23, 100, 315, 32);
		btnAddNewEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                   AddEmpActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnAddNewEmployee);
		
		JButton btnRetourner = new JButton("Return");
		btnRetourner.setBounds(261, 0, 98, 23);
		btnRetourner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                   RetournerActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnRetourner);
	}

	protected void RetournerActionPerformed(ActionEvent evt) {
		frame.dispose();
		JGraphicMainClient add = new JGraphicMainClient();
		add.frame.setVisible(true);
	}

	protected void AddEmpActionPerformed(ActionEvent evt) {
		AddEmp add = new AddEmp();
		frame.dispose();
		add.frame.setVisible(true);
	}

	protected void ConsultEmpActionPerformed(ActionEvent evt) {
		ConsultEmp consult = new ConsultEmp();
		consult.setVisible(true);
	}

}
