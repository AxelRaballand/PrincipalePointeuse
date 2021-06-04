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

	public MoveJFrame frame;
	private JTextField newName;
	private int idDepartment;
	private String oldDepartName;
	private JTextField oldName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifDepartment window = new ModifDepartment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame = new MoveJFrame();
		frame.setBounds(100, 100, 450, 176);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
		
		JLabel PageTitle = new JLabel("Modify department");
		PageTitle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		PageTitle.setBounds(143, 11, 141, 21);
		frame.getContentPane().add(PageTitle);
		
		JLabel lblNewLabel = new JLabel("Departments new name : ");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 74, 142, 14);
		frame.getContentPane().add(lblNewLabel);
		
		newName = new JTextField();
		newName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		newName.setBounds(172, 72, 252, 20);
		frame.getContentPane().add(newName);
		newName.setColumns(10);
		
		JButton btnConfirm = new JButton("Modify");
		btnConfirm.setBounds(335, 103, 89, 23);
		btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnConfirmActivityActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnConfirm);
		
		JLabel lblNewLabel_1 = new JLabel("Departments old name : ");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 40, 142, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		oldName = new JTextField();
		oldName.setEditable(false);
		oldName.setBounds(172, 41, 252, 20);
		frame.getContentPane().add(oldName);
		oldName.setColumns(10);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.setBounds(10, 104, 89, 23);
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnReturnActivityActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnNewButton);
	}

	protected void btnReturnActivityActionPerformed(ActionEvent evt) {
		frame.dispose();
		ConsultDepartments consult = new ConsultDepartments();
		consult.frame.setVisible(true);
		}

	protected void formWindowOpened(WindowEvent evt) {
		oldName.setText(oldDepartName);
	}

	protected void btnConfirmActivityActionPerformed(ActionEvent evt) {
		
		JGraphicMainClient.controller.ModifyDepartment(idDepartment, newName.getText());
		 JOptionPane.showMessageDialog(null,"Department has been modified successsfully !");
			ConsultDepartments consult = new ConsultDepartments();
			frame.dispose();
			consult.frame.setVisible(true);
		
	}
}
