import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMainPage extends JPanel {
	
	public PanelMainPage(WindowMain window){
		
		// Header
		JPanel header = new JPanel();
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		this.add(new JPanel(), BorderLayout.CENTER);
		this.add(header);
		
		// Title
		JLabel label = new JLabel("Gestion/Informations/recherche");
		Font police = new Font("Tahoma", Font.BOLD, 16);
	    label.setFont(police);
	    label.setForeground(Color.blue);
	    label.setHorizontalAlignment(JLabel.CENTER);
	    this.add(label, BorderLayout.NORTH);
	    
	    // Buttons
	    JPanel buttons = new JPanel();
	    JButton bookList = new JButton("Liste des stocks");
	    bookList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setPanel(new PanelStock(window), "Liste des stocks");
			}
		});
	    buttons.add(bookList);
	    JButton memberList = new JButton("Liste des adherent");
	    memberList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setPanel(new PanelMember(window), "Liste des adherent");
			}
		});
	    buttons.add(memberList);
	    JButton membershipList = new JButton("Stock des adhesions");
	    membershipList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setPanel(new PanelMembership(window), "Liste des adhesions");
			}
		});
	    buttons.add(membershipList);
	    this.add(buttons, BorderLayout.CENTER);
	}
	
}
