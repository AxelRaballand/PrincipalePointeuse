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

	public MoveJFrame frame;
	private int idEmployee;
	private String oldFirstName;
	private String oldLastName;
	private String oldDepartment;
	private JLabel titleName;
	private JLabel titleID;
	private JLabel titleDepartment;
	

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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPlanning window = new MainPlanning();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		frame = new MoveJFrame();
		frame.setBounds(100, 100, 423, 187);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
		
		JLabel titlePage = new JLabel("Planning");
		titlePage.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		titlePage.setBounds(168, 5, 82, 31);
		frame.getContentPane().add(titlePage);
		JButton btnConsult = new JButton("Consult Planning");
		btnConsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnConsultActionPerformed(evt);
            }
        });
		btnConsult.setBounds(80, 103, 244, 31);
		frame.getContentPane().add(btnConsult);
		
		JButton btnAddPlanning = new JButton("Add new Pointing");
		btnAddPlanning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnAddPlanningActionPerformed(evt);
            }
        });
		btnAddPlanning.setBounds(80, 145, 244, 31);
		frame.getContentPane().add(btnAddPlanning);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(308, 11, 89, 23);
		btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnReturnActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnReturn);
		
		titleName = new JLabel();
		titleName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		titleName.setBounds(10, 52, 342, 23);
		frame.getContentPane().add(titleName);
		
		titleID = new JLabel("");
		titleID.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		titleID.setBounds(10, 32, 201, 20);
		frame.getContentPane().add(titleID);
		
		titleDepartment = new JLabel("");
		titleDepartment.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		titleDepartment.setBounds(10, 77, 292, 23);
		frame.getContentPane().add(titleDepartment);
	}

	protected void formWindowOpened(WindowEvent evt) {
 		titleName.setText("Name : "+oldLastName.toUpperCase()+" "+oldFirstName.toLowerCase());
		titleID.setText("ID : "+idEmployee);
		titleDepartment.setText("Department : "+oldDepartment.toUpperCase());
	}

	protected void btnReturnActionPerformed(ActionEvent evt) {
		frame.dispose();
		ModifEmp emp = new ModifEmp();
		emp.setIdEmployee(idEmployee);
		emp.setOldFirstName(oldFirstName);
		emp.setOldLastName(oldLastName);
		emp.setOldDepartment(oldDepartment);
		
		emp.frame.setVisible(true);
	}

	protected void btnConsultActionPerformed(ActionEvent evt) {
		ConsultCalendar calendar = new ConsultCalendar();
		calendar.setIdEmployee(idEmployee);
		calendar.frame.setVisible(true);
		}

	protected void btnAddPlanningActionPerformed(ActionEvent evt) {
		AddCalendar planning = new AddCalendar();
		planning.setIdEmployee(idEmployee);
		planning.frame.setVisible(true);
	}
}
