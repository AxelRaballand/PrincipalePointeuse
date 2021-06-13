package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.common.Department;
import model.common.Employee;


public class ConsultEmp extends JFrame {
	
	
    /**Attributes*/
	private JTable table;
	
	
	
/**
 * Constructor
 */
	public ConsultEmp() {
		initialize();
	}

	/**
	 * Initializer
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);     /** Setting the bounds of the frame */
		setResizable(false);        /** Setting the resizability of the frame */
		setTitle("Employees management");  /** Setting title for our interface */
		setLocationRelativeTo(null); /** Setting center position to the window's popup */
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);     /** Setting the close option to the window's frame */
		
        addWindowListener(new java.awt.event.WindowAdapter() {  /** Declaring Window opening action listener*/
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        
		getContentPane().setLayout(new BorderLayout(0, 0));  /** Setting the borderLayout to the frame's contentPane */
		
		JLabel lblEmployee = new JLabel("                                               Employee");
		lblEmployee.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		getContentPane().add(lblEmployee, BorderLayout.NORTH);  /** Setting the north borderLayout to the label */
		
		JButton btnActualiser = new JButton("Update"); /**Adding interface update label */
		btnActualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {   /**Declaring update's button action listener  */
            	btnActualiserActionPerformed(evt);
            }
        });
		getContentPane().add(btnActualiser, BorderLayout.SOUTH);   /** Setting the south borderLayout to the label */
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);   /** Setting the center borderLayout to the label */
		
		table = new JTable();
	    /** 
	     * Setting the model of jtable for current window
	     * 
	     * @param 2D array ( Objects array and Header strings array for the table )
	     */
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "FirstName", "LastName", "Department"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
	       table.addMouseListener(new java.awt.event.MouseAdapter() {  /**Declaring  Mouse clicking on table's action listener  */
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                jTableMouseClicked(evt);
	            }
	        });
		/**
		 * Put the jtable in scrollPane
		 */
		scrollPane.setViewportView(table);  /**Setting  view port of the table's scrollPane  */
	}
	
	
	protected void btnActualiserActionPerformed(ActionEvent evt) {   /**Refresh button's action listener */
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"ID", "FirstName", "LastName", "Department"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class, String.class
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
                        j = 0;
                        table.setValueAt(emp.getIdEmployee(), i, j);
                        j++;
                        table.setValueAt(emp.getName(), i, j);
                        j++;
                        table.setValueAt( emp.getSurname(), i, j);
                        j++;
                        table.setValueAt(emp.getDepartment().getNameDepartment(), i, j);
                        j++;
                  i++;
            }
		}
        
	}

	protected void formWindowOpened(WindowEvent evt) {   /**Window opening action listener  */

		int i=0,j=0;
		for(Department depart : JGraphicMainServer.controller.departments)
		{
			for(Employee emp : depart.getEmployeeList())
			{
                        j = 0;
                        table.setValueAt(emp.getIdEmployee(), i, j);
                        j++;
                        table.setValueAt(emp.getName(), i, j);
                        j++;
                        table.setValueAt( emp.getSurname(), i, j);
                        j++;
                        table.setValueAt(emp.getDepartment().getNameDepartment(), i, j);
                        j++;
                  i++;
            }
		}
     }
	
	protected void jTableMouseClicked(MouseEvent evt) {   /**Mouse clicking on table's action listener  */

		ModifEmp modifEmp = new ModifEmp();
		
        int i= table.getSelectedRow();
        int idEmp =  Integer.parseInt(table.getValueAt(i, 0).toString());
        String fName =   table.getValueAt(i, 1).toString();
        String lName =   table.getValueAt(i, 2).toString();
        String nameDepart =  table.getValueAt(i, 3).toString();
        modifEmp.setIdEmployee(idEmp);
        modifEmp.setOldFirstName(fName);
        modifEmp.setOldLastName(lName);
        modifEmp.setOldDepartment(nameDepart);
        dispose();
		modifEmp.frame.setVisible(true);

	}

}
