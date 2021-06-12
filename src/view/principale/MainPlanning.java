package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class MainPlanning {

	/** Attributes */
	public MoveJFrame frame;
	private int idEmployee;
	private String oldFirstName;
	private String oldLastName;
	private String oldDepartment;
	private JLabel titleName;
	private JLabel titleID;
	private JLabel titleDepartment;
	

	/** Getters and setters */
	public String getOldFirstName() {
		return oldFirstName;
	}

	public void setOldFirstName(String oldFirstName) {
		this.oldFirstName = oldFirstName;
	}

	public String getOldLastName() {
		return oldLastName;
	}

	public void setOldLastName(String oldLastName) {
		this.oldLastName = oldLastName;
	}

	public String getOldDepartment() {
		return oldDepartment;
	}

	public void setOldDepartment(String oldDepartment) {
		this.oldDepartment = oldDepartment;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}
	
	/**
	 * Create the application.
	 */
	public MainPlanning() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new MoveJFrame();  /** Initializing JFrame object */
		frame.setBounds(100, 100, 423, 187); /** Setting bounds for our frame */
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); /** Setting resizability for our frame */
		frame.getContentPane().setLayout(null); /** Setting the close option for our window */
		frame.setLocationRelativeTo(null); /** Setting the free layout content type  for our frame */
		
        frame.addWindowListener(new java.awt.event.WindowAdapter() { /** Declaring window's opening's action listener */
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
		
		JLabel titlePage = new JLabel("Planning"); /** Declaring and setting window's title's label */
		titlePage.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		titlePage.setBounds(168, 5, 82, 31);
		frame.getContentPane().add(titlePage); /** Adding window's title's label to the contentPane */
		JButton btnConsult = new JButton("Consult Planning");
		btnConsult.addActionListener(new java.awt.event.ActionListener() { /** Declaring planning's consulting's actionListener */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnConsultActionPerformed(evt); 
            }
        });
		btnConsult.setBounds(80, 103, 244, 31);
		frame.getContentPane().add(btnConsult); /** Adding planning's consulting's button to the contentPane */
		
		JButton btnAddPlanning = new JButton("Add new Pointing"); /** Declaring and setting adding pointing's button */
		btnAddPlanning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { /** Declaring adding pointing's button's action listener */
            	btnAddPlanningActionPerformed(evt);
            }
        });
		btnAddPlanning.setBounds(80, 145, 244, 31);
		frame.getContentPane().add(btnAddPlanning); /** Adding planning's adding button to the contentPane */
		
		JButton btnReturn = new JButton("Return"); /** Declaring and setting planning's return button */
		btnReturn.setBounds(308, 11, 89, 23);
		btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnReturnActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnReturn); /** Adding planning's return button to the contentPane */
		
		titleName = new JLabel();  /** Declaring and setting employee's title name's label */
		titleName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		titleName.setBounds(10, 52, 342, 23);
		frame.getContentPane().add(titleName);  /**Adding empoyee's title name's label to the contentPane */
		
		titleID = new JLabel("");  /** Declaring and setting employee's title ID's label */
		titleID.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		titleID.setBounds(10, 32, 201, 20);
		frame.getContentPane().add(titleID); /**Adding employee's title ID's label to the contentPane */
		
		titleDepartment = new JLabel(""); /** Declaring and setting employee's title department label */
		titleDepartment.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		titleDepartment.setBounds(10, 77, 292, 23);
		frame.getContentPane().add(titleDepartment); /**Adding employee's title department label to the contentPane */
	}

	protected void formWindowOpened(WindowEvent evt) { /**window's oppening action listener */
 		titleName.setText("Name : "+oldLastName.toUpperCase()+" "+oldFirstName.toLowerCase());
		titleID.setText("ID : "+idEmployee);
		titleDepartment.setText("Department : "+oldDepartment.toUpperCase());
	}

	protected void btnReturnActionPerformed(ActionEvent evt) {  /**return button's action listener */
		frame.dispose();
		ModifEmp emp = new ModifEmp();
		emp.setIdEmployee(idEmployee);
		emp.setOldFirstName(oldFirstName);
		emp.setOldLastName(oldLastName);
		emp.setOldDepartment(oldDepartment);
		
		emp.frame.setVisible(true);
	}

	protected void btnConsultActionPerformed(ActionEvent evt) {  /**Consulting button's action listener */
		ConsultCalendar calendar = new ConsultCalendar();
		calendar.setIdEmployee(idEmployee);
		calendar.frame.setVisible(true);
		}

	protected void btnAddPlanningActionPerformed(ActionEvent evt) {  /**Adding button's action listener */
		AddCalendar planning = new AddCalendar();
		planning.setIdEmployee(idEmployee);
		planning.frame.setVisible(true);
	}
}
