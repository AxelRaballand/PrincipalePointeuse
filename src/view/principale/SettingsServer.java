package view.principale;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.principale.SetUpServer;


public class SettingsServer extends MoveJFrame {

		public JFrame frame;
		private JTextField textIPadr;
		private JTextField textPort;
		/**
		 * Constructor
		 */
		public SettingsServer() {
			initialize();
		}
		/**
		 * Initializer
		 */
		private void initialize() {
			
			 setBounds(100, 100, 450, 146);  /** Setting bounds(x,y,height,width) to the window */
			 
			 setResizable(false);    /** Setting resizability to the window */
			 
			 setLocationRelativeTo(null);  /** Setting a relative location to the popupping of the window */
			 
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);     /** Setting the close option to the window's frame */
			 
			 getContentPane().setLayout(null);    /** Setting the free layout to the frame */
			
			JLabel lblIPAdresse = new JLabel("IP Adresse");
			lblIPAdresse.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
			lblIPAdresse.setBounds(10, 55, 71, 14);
			getContentPane().add(lblIPAdresse);  /** Adding a label to the contentPane */
			
			
			JLabel lblPort = new JLabel("Port");
			lblPort.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
			lblPort.setBounds(225, 56, 28, 14);
			getContentPane().add(lblPort);      /** Adding a label to the contentPane */
			
			
			JLabel lblTitle = new JLabel("Advanced Settings");
			lblTitle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
			lblTitle.setBounds(154, 11, 153, 20);
			getContentPane().add(lblTitle);  /** Adding a label to the contentPane */
			
			
			textIPadr = new JTextField();
			textIPadr.setBounds(81, 54, 134, 20);
			getContentPane().add(textIPadr);   /** Adding a textField to the contentPane */
			textIPadr.setColumns(10);
			
			
			textPort = new JTextField();
			textPort.setBounds(263, 54, 134, 20);
			getContentPane().add(textPort);   /** Adding a textField to the contentPane */
			textPort.setColumns(10);
			
			
			JButton btnConfirm = new JButton("Confirm");
			btnConfirm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
			btnConfirm.setBounds(175, 85, 89, 23);
			getContentPane().add(btnConfirm);
			
			btnConfirm.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	try 
	            	{
	            		SetUpServer config = new SetUpServer();
	            		try 
	            		{
							config.SaveConfig(textIPadr.getText(), Integer.parseInt(textPort.getText()));
						}
	            		catch (IOException e) 
	            		{
							e.printStackTrace();
						}
	            		RtrnEmpActionPerformed(evt);
	            	} 
	            	catch (NumberFormatException e) 
	            	{
	            		e.printStackTrace();
	            	}           
	            }
			});
			
			JButton btnReturn = new JButton("Return");
			btnReturn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
			btnReturn.setBounds(355, 0, 89, 23);
			getContentPane().add(btnReturn);  /** Adding a return button the contentPane */
			
			
			btnReturn.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	RtrnEmpActionPerformed(evt);
	            }
	        });
		}
		/**
		 * action listener to return button
		 */
		protected void RtrnEmpActionPerformed(ActionEvent evt) {
			dispose();
			JGraphicMainClient mn = new JGraphicMainClient();
			mn.frame.setVisible(true);
		}

	}
