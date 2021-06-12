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

	/** Attributes */
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
		frame = new JFrame(); /** Creating the frame of our window */
		frame.setBounds(100, 100, 450, 238);  /** Setting bounds for our frame */
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);     /** Setting the close option to the window's frame */
		frame.getContentPane().setLayout(null);  /** Setting the free layout content type  for our frame */
		frame.setResizable(false);        /** Setting resizability for our frame */
		frame.setLocationRelativeTo(null); /** Setting the free layout content type  for our frame */
		frame.setUndecorated(true);  /** Setting frame's undercoration to be enabled*/
		
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
		
		JLabel titlePage = new JLabel("Departments management"); /** Creating and setting interface title */
		titlePage.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		titlePage.setBounds(129, 11, 176, 22);
		frame.getContentPane().add(titlePage); /** Adding interface title to the frame */
		
		comboBoxDepartmentChoice = new JComboBox(); /** Creating and setting department consulting combobox  */
		comboBoxDepartmentChoice.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		comboBoxDepartmentChoice.setBounds(10, 88, 226, 36);
		frame.getContentPane().add(comboBoxDepartmentChoice); /**Adding interface title to the contentPane */
		
		JButton btnModifyDepartment = new JButton("Modify"); /** Creating and setting modification button */
		btnModifyDepartment.setBounds(246, 88, 89, 36);
		btnModifyDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnModifyDepartmentActivityActionPerformed(evt); /**Declaring modification's button action listener*/
            }
        });
		frame.getContentPane().add(btnModifyDepartment);  /**Adding modification button to the contentPane */
		
		JButton btnDeleteDepartment = new JButton("Delete");  /**Adding interface deletion button */
		btnDeleteDepartment.setBounds(345, 88, 89, 36);
		btnDeleteDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnDeleteDepartmentActivityActionPerformed(evt); /**Declaring deletion's button action listener*/
            }
        });
		frame.getContentPane().add(btnDeleteDepartment);  /**Adding deletion button to the contentPane */
		
		JLabel lblNewLabel = new JLabel("Select to manage a department :");  /**Declaring and setting selection of manager label*/
		lblNewLabel.setBounds(10, 64, 202, 14);
		frame.getContentPane().add(lblNewLabel); /**Adding selection of manager label to the contentPane*/
		
		JButton btnAddDepartment = new JButton("Add new department");  /**Declaring and setting adding  button of a new department */
		btnAddDepartment.setBounds(140, 153, 165, 36);
		btnAddDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnAddDepartmentActivityActionPerformed(evt);  /**Declaring and setting adding  button's action listener of a new department */
            }
        });
		frame.getContentPane().add(btnAddDepartment); /**Adding adding button of department to the contentPane*/
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(345, 13, 89, 23);
		btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnReturnActivityActionPerformed(evt);   /**Declaring return button's action listener*/
            }
        });
		frame.getContentPane().add(btnReturn); /**Adding return's button to the contentPane*/
	}

	
	protected void btnDeleteDepartmentActivityActionPerformed(ActionEvent evt) { /**Deletion action listener*/
		int idDepart = JGraphicMainClient.controller.SearchDepartmentId(comboBoxDepartmentChoice.getSelectedItem().toString());
		if(JGraphicMainClient.controller.DeleteDepartment(idDepart)) JOptionPane.showMessageDialog(null,"Department deleted successfully");
		else JOptionPane.showMessageDialog(null,"Department deletion failed !");
		
		comboBoxDepartmentChoice.removeAllItems();
		for(Department depart : JGraphicMainClient.controller.departments) 
			comboBoxDepartmentChoice.addItem(depart.getNameDepartment());
	}

	
	protected void formWindowOpened(WindowEvent evt) { /**window opening action listener*/
		
		for(Department depart : JGraphicMainClient.controller.departments) 
			comboBoxDepartmentChoice.addItem(depart.getNameDepartment());
	}

	
	protected void btnModifyDepartmentActivityActionPerformed(ActionEvent evt) { /**Modification's button action listener*/
		ModifDepartment modif = new ModifDepartment();
		frame.dispose();
		int idDepart = JGraphicMainClient.controller.SearchDepartmentId(comboBoxDepartmentChoice.getSelectedItem().toString());
		modif.setIdDepartment(idDepart);
		modif.setNameDepartment(comboBoxDepartmentChoice.getSelectedItem().toString());
		modif.frame.setVisible(true);
	}

	
	protected void btnAddDepartmentActivityActionPerformed(ActionEvent evt) { /**Adding department's button action listener*/
		AddDepartment add = new AddDepartment();
		frame.dispose();
		add.frame.setVisible(true);
	}
	
	
	protected void btnReturnActivityActionPerformed(ActionEvent evt) { /**Return button action listener*/
		frame.dispose();
		JGraphicMainClient main = new JGraphicMainClient();
		main.frame.setVisible(true);
	}
}
