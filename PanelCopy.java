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

public class PanelCopy extends JPanel {

	PanelCopy pm = this;
	
	public PanelCopy(WindowMain window){

		// Buttons
	    JButton buttonMainPage = new JButton("<< Accueil");
		buttonMainPage.setHorizontalAlignment(JButton.CENTER);
		buttonMainPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setPanel(new PanelStock(window), "Accueil");
			}
		});
		
	    ZModel model = new ZModel(Utils.dataCopyNull, Utils.titleCopy);
	    JTable table = new JTable(model);
	    table.setDefaultRenderer(JButton.class, new TableComponents());
	    JScrollPane scroll = new JScrollPane(table);
	    
	    // Interface    
		this.setLayout(new BorderLayout());
		this.add(buttonMainPage, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
	}
}