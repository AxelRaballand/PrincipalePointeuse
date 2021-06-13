package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.principale.CompanyController;
import controller.principale.CentralAppMain;
import controller.principale.TCPServerControler;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;

public class JGraphicMainServer {

	/**Atributes*/
	public JFrame frame;
	public static CompanyController controller = new CompanyController();

	/**
	 * Constructor.
	 */
	public JGraphicMainServer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(); /** Initializing JFrame object */
		frame.setBounds(100, 100, 401, 262); /** Setting bounds for our frame */
		frame.setUndecorated(true); /** Setting frame's undecoration to be enabled*/
		frame.setResizable(false); /** Setting frame's resizability */
		frame.setLocationRelativeTo(null); /** Setting center position to the window's popup */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /** Setting the close option for our window */
		frame.getContentPane().setLayout(null); /** Setting layout to null */
		
		
		JLabel lblTitle = new JLabel("Welcome !");  /** Declaring and setting window's title label*/
		lblTitle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblTitle.setBounds(143, 11, 87, 20);
		frame.getContentPane().add(lblTitle); /** Adding label to the contentPane*/
		
		JButton bntEmployees = new JButton("Employees management");  /** Declaring and setting button of employees management*/
		bntEmployees.setBounds(46, 42, 284, 34);
		frame.getContentPane().add(bntEmployees); /** Adding button to the contentPane*/
		bntEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {  /** Declaring employees management button's action listener*/
            	btnEmpManagementActionPerformed(evt);
            }
        });
		
		JButton btnHistoricActivity = new JButton("Historics activity ");  /** Declaring and setting history's activity  label*/
		btnHistoricActivity.setBounds(46, 116, 285, 34);
		frame.getContentPane().add(btnHistoricActivity); /** Adding button to the contentPane*/
		btnHistoricActivity.addActionListener(new java.awt.event.ActionListener() { /** Declaring history's activity button's action listener*/
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnHistoricActivityActionPerformed(evt);
            }
        });
		
		JButton btnSettings = new JButton("Advanced Settings");  /** Declaring and setting advanced settings title label*/
		btnSettings.setBounds(46, 155, 284, 34);
		frame.getContentPane().add(btnSettings); /** Adding button to the contentPane*/
		btnSettings.addActionListener(new java.awt.event.ActionListener() {  /** Declaring advanced settings button's action listener*/
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnSettingsActionPerformed(evt);
            }
        });
		
		JButton btnFAQ = new JButton("FAQ"); /** Declaring and setting FAQ  title label*/
		btnFAQ.setBounds(306, 14, 69, 23);
		frame.getContentPane().add(btnFAQ); /** Adding button to the contentPane*/
		btnFAQ.addActionListener(new java.awt.event.ActionListener() { /** Declaring FAQ button's action listener*/
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnFAQActionPerformed(evt);
            }
        });
		
		/**/
		
		JButton btnQuit = new JButton("Quit"); /** Declaring and setting Quit  title label*/
		btnQuit.setBounds(46, 191, 284, 36);
		frame.getContentPane().add(btnQuit); /** Adding button to the contentPane*/
		btnQuit.addActionListener(new java.awt.event.ActionListener() { /** Declaring Quit button's action listener*/
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					CentralAppMain.CloseAppli();
					TCPServerControler.closeServer();
					System.out.println("... TCPServer closed."); 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					btnQuitActivityActionPerformed(evt);
					//e.printStackTrace();
				}
				btnQuitActivityActionPerformed(evt);
			}
		});
		 
		JButton btnDepartments = new JButton("Departments management");  /** Declaring and setting Departments management  title label*/
		frame.getContentPane().add(btnDepartments);
		btnDepartments.setBounds(46, 80, 284, 34);
		btnDepartments.addActionListener(new java.awt.event.ActionListener() {  /** Declaring Department management button's action listener*/
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnDepartmentsActivityActionPerformed(evt);
            }
        });
	}


	protected void btnDepartmentsActivityActionPerformed(ActionEvent evt) {  /** Department management button's action listener*/
		frame.dispose();
		ConsultDepartments depart = new ConsultDepartments();
		depart.frame.setVisible(true);
	}

	protected void btnQuitActivityActionPerformed(ActionEvent evt) { /** Quitting button's action listener*/
		System.exit(0);
	}

	protected void btnFAQActionPerformed(ActionEvent evt) { /** FAQ button's action listener*/
		frame.dispose();
		FAQ faq =new FAQ();
		faq.setVisible(true);
	}

	protected void btnSettingsActionPerformed(ActionEvent evt) {  /** Advanced setting  button's action listener*/
		frame.dispose();
		SettingsServer settings =new SettingsServer();
		settings.setVisible(true);
	}
	
	protected void btnHistoricActivityActionPerformed(ActionEvent evt) { /** History's button's action listener*/
		HistoricActivity history =new HistoricActivity();
		history.frame.setVisible(true);
	}

	protected void btnEmpManagementActionPerformed(ActionEvent evt) { /** Employees managements button's action listener*/
		frame.dispose();
		MainEMP mainEmp =new MainEMP();
		mainEmp.frame.setVisible(true);
	}
}
