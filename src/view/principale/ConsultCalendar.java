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

	public JFrame frame;
	private JTable table;
	private int idEmployee;
	
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Calendar management");  /** Setting title for our interface */
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
		
		JLabel lblNewLabel = new JLabel("                                              Planning");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnUpdateActionPerformed(evt);
            }
        });
		frame.getContentPane().add(btnUpdate, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
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
	                jTableMouseClicked(evt);
	            }
	        });
	       
		scrollPane.setViewportView(table);
	}

	protected void btnUpdateActionPerformed(ActionEvent evt) {
		
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
		
		int i=0,j=0;
		for(Department depart : JGraphicMainClient.controller.departments)
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

	protected void formWindowOpened(WindowEvent evt) {
		
		int i=0,j=0;
		for(Department depart : JGraphicMainClient.controller.departments)
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

	protected void jTableMouseClicked(MouseEvent evt) {
		
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
