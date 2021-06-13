package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.common.Department;
import model.common.Employee;
import model.common.Planning;

public class ConsultCalendar {

	/** Attributes */
	public JFrame frame;
	private JTable table;
	private int idEmployee;
	
	
	/** Employee Id Getters and Setters */
	public int getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	/**
	 * Create the application.
	 */
	public ConsultCalendar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();  /** Creating the frame of our window */
		frame.setBounds(100, 100, 450, 300);   /** Setting bounds for our frame */
		frame.setTitle("Calendar management");  /** Setting title for our interface */
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); /** Setting resizability for our frame */
		
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt); /** Declaring the window opening listener */
            }
        });
		
		JLabel lblNewLabel = new JLabel("                                              Planning"); /** Creating and setting planning title for our interface */
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);  /** Adding the label to the contentPane  */
		
		JButton btnUpdate = new JButton("Update");  /** Creating and initializing the table's update button to the contentPane  */
		btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnUpdateActionPerformed(evt);  
            }
        });
		frame.getContentPane().add(btnUpdate, BorderLayout.SOUTH);  /** Adding the update's button to the contentPane  */
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(); /** Declaring and setting a jTable */
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Jour", "De", "Jusqu'a", "Mission"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
	       table.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                jTableMouseClicked(evt);   /** Mouse clicking action on table's listener's declaration  */
	            }
	        });
	       
		scrollPane.setViewportView(table); /** setting the view port of the table's scroll pane  */
	}

	/** Update table's button action listener  */
	protected void btnUpdateActionPerformed(ActionEvent evt) {
		
		table.setModel(new DefaultTableModel( /** Remodeling the jTable  in order to remove all old data */
				new Object[][] {
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
				},
				new String[] {
					"ID", "Jour", "De", "Jusqu'a", "Mission"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class, String.class, String.class
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
                    	   j = 0;
                           table.setValueAt(pl.getIdPlanning(), i, j);
                           j++;
                           table.setValueAt(pl.getDay_planning(), i, j);
                           j++;
                           table.setValueAt( pl.getStartTime(), i, j);
                           j++;
                           table.setValueAt(pl.getEndTime(), i, j);
                           j++;
                           table.setValueAt(pl.getTaskType(), i, j);
                           j++;
                     i++;
                       }
            }
		}
		
		
	}

	
	protected void formWindowOpened(WindowEvent evt) { /** Window opening action listener  */
		 
		int i=0,j=0;
		for(Department depart : JGraphicMainServer.controller.departments)
		{
			for(Employee emp : depart.getEmployeeList())
			{
				if(emp.getIdEmployee()==idEmployee)
				{
					  for(Planning pl : emp.getPlanningList())
                      {
                   	   j = 0;
                       table.setValueAt(pl.getIdPlanning(), i, j);
                       j++;
                       table.setValueAt(pl.getDay_planning(), i, j);
                       j++;
                       table.setValueAt( pl.getStartTime(), i, j);
                       j++;
                       table.setValueAt(pl.getEndTime(), i, j);
                       j++;
                       table.setValueAt(pl.getTaskType(), i, j);
                          j++;
                    i++;
                      }
				}
            }
		}
	}

	
	protected void jTableMouseClicked(MouseEvent evt) { /** Mouse clicking on table action listener  */
		
		ModifCalendar modifCalendar = new ModifCalendar();
		
        int i= table.getSelectedRow();
        
        int idPlanning =  Integer.parseInt(table.getValueAt(i, 0).toString());
        String jourPlanning =   table.getValueAt(i, 1).toString();
        String mission =  table.getValueAt(i, 4).toString();
       
        modifCalendar.setIdPlanning(idPlanning);
        modifCalendar.setJour(jourPlanning);
        modifCalendar.setMission(mission);
        modifCalendar.setIdEmployee(idEmployee);
        frame.dispose();
        modifCalendar.frame.setVisible(true);
		
	}

}
