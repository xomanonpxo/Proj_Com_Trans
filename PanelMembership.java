import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelMembership extends JPanel {

	public PanelMembership(WindowMain window){

		// Buttons
	    JButton buttonMainPage = new JButton("<< Accueil");
		buttonMainPage.setHorizontalAlignment(JButton.CENTER);
		buttonMainPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setPanel(new PanelMainPage(window), "Accueil");
			}
		});
		
	    JButton buttonAddBook = new JButton("Ajouter Adhesion");
	    buttonAddBook.setHorizontalAlignment(JButton.CENTER);
	    buttonAddBook.setPreferredSize(new Dimension(100, 30));
	    buttonAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormMembership newMembership = new FormMembership();
			}
		});
		
		// Table
	    ZModel model = new ZModel(Datas.dataMembership, Datas.titleMembership);
	    JTable table = new JTable(model);
	    table.setDefaultRenderer(JButton.class, new TableComponents());
	    table.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e){
	    		if(e.getClickCount() == 2 && table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()) != "")
	    			modify(table);
	    	}
		});
	    JScrollPane scroll = new JScrollPane(table);
	    
	    // Interface    
		this.setLayout(new BorderLayout());
		this.add(buttonMainPage, BorderLayout.NORTH);
		this.add(buttonAddBook, BorderLayout.SOUTH);
		this.add(scroll, BorderLayout.CENTER);
	}
	
	public void modify(JTable table){
		ModifyMembership mod = new ModifyMembership(table.getSelectedRow());
	}
	
}