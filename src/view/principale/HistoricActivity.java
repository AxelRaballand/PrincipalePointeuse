package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.common.Department;
import model.common.Employee;
import model.common.Planning;
import javax.swing.JButton;


public class HistoricActivity {

	/**Attributes*/
	public JFrame frame;
	private JTable historicActivityTable;

	/**
	 * Create the application.
	 */
	public HistoricActivity() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(); /** Initializing JFrame object */
		frame.setBounds(100, 100, 450, 300);  /** Setting bounds for our frame */
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); /** Setting the close option for our window */
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setTitle("History management");  /** Setting title for our interface */
		JLabel lblTitle = new JLabel("                                ChekingOut Historics Activity");
		lblTitle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		frame.getContentPane().add(lblTitle, BorderLayout.NORTH);
		
		JButton btnToday = new JButton("Filtre by Today's history");
		btnToday.addActionListener(new java.awt.event.ActionListener() { /** Declaring button of today's history action listener*/
            public void actionPerformed(java.awt.event.ActionEvent evt) { 
            	btnTodayActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnToday, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		historicActivityTable = new JTable();  /** Declaring jtable*/
		historicActivityTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "FirstName", "LastName", "Department", "CheckIn", "CheckOut"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(historicActivityTable);
		
        frame.addWindowListener(new java.awt.event.WindowAdapter() {  /** Declaring window opening action listener*/
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
	}

	protected void btnTodayActionPerformed(ActionEvent evt) {  /** Today's history action listener*/
		
		historicActivityTable.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				},
				new String[] {
					"ID", "FirstName", "LastName", "Department", "CheckIn", "CheckOut"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		
		int i=0,j=0;
		for(Department depart : JGraphicMainServer.controller.departments)
		{
			for(Employee emp : depart.getEmployeeList())
			{
					  for(Planning pl : emp.getPlanningList())
                      {
						  if(pl.getToday().toString().equals(LocalDate.now().toString()))
						  {
                   	   j = 0;
                   	historicActivityTable.setValueAt(emp.getIdEmployee(), i, j);
                          j++;
                    historicActivityTable.setValueAt(emp.getName(), i, j);
                          j++;
                    historicActivityTable.setValueAt(emp.getSurname(), i, j);
                          j++;
                    historicActivityTable.setValueAt(emp.getDepartment().getNameDepartment(), i, j);
                          j++;
                    historicActivityTable.setValueAt(pl.getStartTime(), i, j);
                          j++;
                    historicActivityTable.setValueAt(pl.getEndTime(), i, j);
                          j++;
                      i++;
						  }
                      }
            }
		}
		
		
		
	}

	protected void formWindowOpened(WindowEvent evt) {  /** Window Opening"s action listener*/
		int i=0,j=0;
		for(Department depart : JGraphicMainServer.controller.departments)
		{
			for(Employee emp : depart.getEmployeeList())
			{
					  for(Planning pl : emp.getPlanningList())
                      {
                   	   j = 0;
                   	historicActivityTable.setValueAt(emp.getIdEmployee(), i, j);
                          j++;
                    historicActivityTable.setValueAt(emp.getName(), i, j);
                          j++;
                    historicActivityTable.setValueAt(emp.getSurname(), i, j);
                          j++;
                    historicActivityTable.setValueAt(emp.getDepartment().getNameDepartment(), i, j);
                          j++;
                    historicActivityTable.setValueAt(pl.getStartTime(), i, j);
                          j++;
                    historicActivityTable.setValueAt(pl.getEndTime(), i, j);
                          j++;
                    i++;
                      }
            }
		}
	}

}
