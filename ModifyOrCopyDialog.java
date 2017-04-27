import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ModifyOrCopyDialog extends JDialog {
	
	ModifyOrCopyDialog mOrC = this;
	
	public ModifyOrCopyDialog(int i, WindowMain wind){
		
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
        
        JButton modify = new JButton("Modifier Livre");
	    modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyBook mod = new ModifyBook(i);
				mOrC.dispose();
			}
		});
        cs.gridx = 0;
        cs.gridy = 0;
        cs.ipady = 2;
        panel.add(modify, cs);
	    
        JButton listCopy = new JButton("Liste des exemplaires");
	    listCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wind.setPanel(new PanelCopy(wind), "Liste des exemplaires");
				mOrC.dispose();
			}
		});
        cs.gridx = 0;
        cs.gridy = 1;
        cs.ipady = 2;
        panel.add(listCopy, cs);
        
        panel.setBorder(new LineBorder(Color.GRAY));

        setContentPane(panel);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
}
