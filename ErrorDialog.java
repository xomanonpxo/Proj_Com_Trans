import javax.swing.JDialog;
import javax.swing.JOptionPane;

/*
 * Show a Dialog with a message error
 * @param id  	0 date error
 * 				1 double error
 */

public class ErrorDialog extends JDialog {

	public ErrorDialog(int id){
	
		this.setLocationRelativeTo(null);
		JOptionPane.showMessageDialog(null, idError(id));
		
        setResizable(false);
		this.setVisible(true);
	}
	
	private String idError(int id){
		String s = "";
		switch(id){
		case 0:
			s = "Veuillez renseigner toutes les dates\navec le format suivant :\njj//mm//aaaa\nCes dates doivent respecter le calendrier.\n";
			break;
		case 1:
			s = "Veuillez entrez une valeur correcte.\nLe format est le suivant :\n19.99\n24.90\n12.0\n";
		}
		return s.toString();
	}
	
}
