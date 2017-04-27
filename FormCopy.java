import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class FormCopy extends JDialog {
	
	private static final long serialVersionUID = 5627435249704245054L;
	
	// Data
	JDialog form = this;
	private LocalDate _dateAdded;
	private String _currentCondition;
	
	public FormCopy(){
		
		// Window
		this.setTitle("Nouvel exemplaire");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(isAlwaysOnTop());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	
		// Main Panel
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(3,1));

		// Elements of the form
		ElementDateForm dateAddedFormElement = new ElementDateForm("Date d'ajout", "##/##/####");
		container.add(dateAddedFormElement);
		ElementListForm currentConditionFormElement = new ElementListForm("Etat actuel", Utils.currentCondition);
		container.add(currentConditionFormElement);
		
		// Button submit
		JButton submitButton = new JButton("Valider");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				_dateAdded = dateAddedFormElement.getDateFromField();
				_currentCondition = (String)currentConditionFormElement.getComboBox().getSelectedItem();
				if(_dateAdded != null){
					form.dispose();
					form.setVisible(false);
				}
				System.out.println(_dateAdded + " "+ _currentCondition);
			}
		});
		container.add(submitButton);
		
		// Set
		this.setContentPane(container);
		this.pack();
		this.setVisible(true);
	}
	
}
