package view.principale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.MouseEvent;

public class ConsultCalendar {

	public JFrame frame;
	private JTable calendarTable;


	public ConsultCalendar() {
		initialize();
	}

	/**
	 * Initializer
	 */
	private void initialize() {
		
		frame = new JFrame();            /** Setting the frame to the contentPane  */
		
		frame.setBounds(100, 100, 450, 300);     /** Setting the bounds(x,y,length,width) of the frame  */
		
		frame.setResizable(false);  /** Setting the resizability of the frame  */
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.getContentPane().setLayout(new BorderLayout(0, 0));  /** Setting the borderLayout to the contentPane  */
		
		JLabel lblPlanning = new JLabel("                                               Planning");
		lblPlanning.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		frame.getContentPane().add(lblPlanning, BorderLayout.NORTH);    /** Adding the label to the north of the contentPane  */
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);   /** Adding the scrollPane to the center of the contentPane  */
		
		calendarTable = new JTable();     /** Creating  a JTable  */
		 /** Setting the model of the jTable 
		  * 
		  *  @param 2D array : 1st Array of objects - 2nd Array of header Strings
		  */
		calendarTable.setModel(new DefaultTableModel(      
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
				"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		 /** Actionlistener method to the mouse listener
		  * 
		  *  @param  mouse waited event
		  */
	       calendarTable.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                jTableMouseClicked(evt);
	            }
	        });
		scrollPane.setViewportView(calendarTable);
	}
    /** 
     * Action listener to wait clicks on current jtable
     * 
     * @param ActionEvent evt (waited event)
     */
	protected void jTableMouseClicked(MouseEvent evt) {
		AddModifCalendar add = new AddModifCalendar();
		add.frame.setVisible(true);
	}

}
