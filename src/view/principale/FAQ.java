/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.principale;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class FAQ  extends MoveJFrame{

/**
 * Constructor
 */
    public FAQ() {
    	getContentPane().setBackground(UIManager.getColor("Button.darkShadow"));   /** Setting the background color to the contentPane */
        initComponents();   /** Calling the initializer window's method  */
         setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setResizable(false);  /** Setting window's resizability option */
    }
    
    /**
     *  Initializer of components
     */
    private void initComponents() {
        scrollPane = new javax.swing.JScrollPane();   
        textArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); /** Setting the dispose closing option to the frame */
        setTitle("FAQ");   
        setBounds(new java.awt.Rectangle(70, 150, 0, 0));  /** Setting bounds(x,y,height,width) to the window */
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        textArea.setEditable(false); 
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Courier New", 0, 20)); // NOI18N
        textArea.setRows(5);
        scrollPane.setViewportView(textArea);
        
        btnRetourner = new JButton("Retourner");
        btnRetourner.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        btnRetourner.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {  /** Action listener function to the adding button */
				dispose();
				JGraphicMainServer main =new JGraphicMainServer();
				main.frame.setVisible(true);
        	}
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(24, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnRetourner)
        				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 778, GroupLayout.PREFERRED_SIZE))
        			.addGap(27))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(38)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnRetourner)
        			.addContainerGap(20, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }
    /** 
     * method work when openning the current window
     * 
     * @param evt (waited event)
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        String s="Cette application realisee pour un but non lucratif par les eleves ingenieurs CHOKRI Marouane - RABALLAND Axel - MOREAU Clement - AUGIER Jean pour un projet tutore en matiere de Java \nCette application est pour objectif de calculer les heures de travail des employees d une entreprise et calculer leurs heures de pointages." +"\nRemerciement a notre prof : Mr.Esswin"+"\nRemerciement a notre ecole : POLYTECH Tours\n"+ "\nEmail :marouane.chokri@etu.univ-tours.fr\nEmail :axel.raballand@etu.univ-tours.fr\nEmail :clement.moreau@etu.univ-tours.fr\nEmail :jean.augier@etu.univ-tours.fr\n";
        textArea.setText(s);
        
    }
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextArea textArea;
    private JButton btnRetourner;
}
