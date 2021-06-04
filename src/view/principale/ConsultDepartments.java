package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.common.Department;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class ConsultDepartments {

	public JFrame frame;
	private JComboBox comboBoxDepartmentChoice;
	
	/**
	 * Create the application.
	 */
	public ConsultDepartments() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 238);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);     /** Setting the close option to the window's frame */
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);        /** Setting the resizability of the frame */
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
		
		JLabel titlePage = new JLabel("Departments management");
		titlePage.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		titlePage.setBounds(129, 11, 176, 22);
		frame.getContentPane().add(titlePage);
		
		comboBoxDepartmentChoice = new JComboBox();
		comboBoxDepartmentChoice.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		comboBoxDepartmentChoice.setBounds(10, 88, 226, 36);
		frame.getContentPane().add(comboBoxDepartmentChoice);
		
		JButton btnModifyDepartment = new JButton("Modify");
		btnModifyDepartment.setBounds(246, 88, 89, 36);
		btnModifyDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnModifyDepartmentActivityActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnModifyDepartment);
		
		JButton btnDeleteDepartment = new JButton("Delete");
		btnDeleteDepartment.setBounds(345, 88, 89, 36);
		btnDeleteDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnDeleteDepartmentActivityActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnDeleteDepartment);
		
		JLabel lblNewLabel = new JLabel("Select to manage a department :");
		lblNewLabel.setBounds(10, 64, 202, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAddDepartment = new JButton("Add new department");
		btnAddDepartment.setBounds(140, 153, 165, 36);
		btnAddDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnAddDepartmentActivityActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnAddDepartment);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(345, 13, 89, 23);
		btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnReturnActivityActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnReturn);
	}

	protected void btnDeleteDepartmentActivityActionPerformed(ActionEvent evt) {
		int idDepart = JGraphicMainClient.controller.SearchDepartmentId(comboBoxDepartmentChoice.getSelectedItem().toString());
		if(JGraphicMainClient.controller.DeleteDepartment(idDepart)) JOptionPane.showMessageDialog(null,"Department deleted successfully");
		else JOptionPane.showMessageDialog(null,"Department deletion failed !");
		
		comboBoxDepartmentChoice.removeAllItems();
		for(Department depart : JGraphicMainClient.controller.departments) 
			comboBoxDepartmentChoice.addItem(depart.getNameDepartment());
	}

	protected void formWindowOpened(WindowEvent evt) {
		
		for(Department depart : JGraphicMainClient.controller.departments) 
			comboBoxDepartmentChoice.addItem(depart.getNameDepartment());
	}

	protected void btnModifyDepartmentActivityActionPerformed(ActionEvent evt) {
		ModifDepartment modif = new ModifDepartment();
		frame.dispose();
		int idDepart = JGraphicMainClient.controller.SearchDepartmentId(comboBoxDepartmentChoice.getSelectedItem().toString());
		modif.setIdDepartment(idDepart);
		modif.setNameDepartment(comboBoxDepartmentChoice.getSelectedItem().toString());
		modif.frame.setVisible(true);
	}

	protected void btnAddDepartmentActivityActionPerformed(ActionEvent evt) {
		AddDepartment add = new AddDepartment();
		frame.dispose();
		add.frame.setVisible(true);
	}

	protected void btnReturnActivityActionPerformed(ActionEvent evt) {
		frame.dispose();
		JGraphicMainClient main = new JGraphicMainClient();
		main.frame.setVisible(true);
	}
}
