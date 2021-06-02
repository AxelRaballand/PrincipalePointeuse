package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class JGraphicMainClient {

	public JFrame frame;

	/**
	 * Constructor.
	 */
	public JGraphicMainClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 401, 262);
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Welcome !");
		lblTitle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblTitle.setBounds(143, 11, 87, 20);
		frame.getContentPane().add(lblTitle);
		
		JButton bntEmployees = new JButton("Employees management");
		bntEmployees.setBounds(46, 42, 284, 34);
		frame.getContentPane().add(bntEmployees);
		bntEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnEmpManagementActionPerformed(evt);
            }
        });
		
		JButton btnHistoricActivity = new JButton("Historics activity ");
		btnHistoricActivity.setBounds(45, 87, 285, 34);
		frame.getContentPane().add(btnHistoricActivity);
		btnHistoricActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnHistoricActivityActionPerformed(evt);
            }
        });
		
		JButton btnSettings = new JButton("Advanced Settings");
		btnSettings.setBounds(46, 132, 284, 34);
		frame.getContentPane().add(btnSettings);
		btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnSettingsActionPerformed(evt);
            }
        });
		
		JButton btnFAQ = new JButton("FAQ");
		btnFAQ.setBounds(306, 14, 69, 23);
		frame.getContentPane().add(btnFAQ);
		btnFAQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnFAQActionPerformed(evt);
            }
        });
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(46, 177, 284, 36);
		frame.getContentPane().add(btnQuit);
		btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnQuitActivityActionPerformed(evt);
            }
        });
	}

	protected void btnQuitActivityActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	protected void btnFAQActionPerformed(ActionEvent evt) {
		frame.dispose();
		FAQ faq =new FAQ();
		faq.setVisible(true);
	}

	protected void btnSettingsActionPerformed(ActionEvent evt) {
		frame.dispose();
		SettingsServer settings =new SettingsServer();
		settings.setVisible(true);
	}
	
	protected void btnHistoricActivityActionPerformed(ActionEvent evt) {
		HistoricActivity history =new HistoricActivity();
		history.frame.setVisible(true);
	}

	protected void btnEmpManagementActionPerformed(ActionEvent evt) {
		frame.dispose();
		MainEMP mainEmp =new MainEMP();
		mainEmp.frame.setVisible(true);
	}
}
