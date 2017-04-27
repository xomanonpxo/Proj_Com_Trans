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

public class PanelMember extends JPanel {

	PanelMember pm = this;
	
	public PanelMember(WindowMain window){

		// Buttons
	    JButton buttonMainPage = new JButton("<< Accueil");
		buttonMainPage.setHorizontalAlignment(JButton.CENTER);
		buttonMainPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setPanel(new PanelMainPage(window), "Accueil");
			}
		});
		
	    JButton buttonAddBook = new JButton("Ajouter Adherent");
	    buttonAddBook.setHorizontalAlignment(JButton.CENTER);
	    buttonAddBook.setPreferredSize(new Dimension(100, 30));
	    buttonAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormMember newMember = new FormMember();
			}
		});
		
	    ZModel model = new ZModel(Datas.dataMember, Datas.titleMember);
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
		ModifyMember mod = new ModifyMember(table.getSelectedRow());
	}
	
}
