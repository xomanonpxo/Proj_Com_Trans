import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class FormBook extends JDialog {
	
	private static final long serialVersionUID = 2042665390613161694L;
	
	// Data
	private JDialog form = this;
	private String _name;
	private String _isbn;
	private double _price;
	private String _level;
	private String _section;
	private String _subject;
	
	public FormBook(WindowMain wind){
		
		// Window
		this.setTitle("Nouveau Livre");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(isAlwaysOnTop());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// Main Panel
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(7,1));
		
		// Elements of the form
		ElementSimpleForm nameFormElement = new ElementSimpleForm("Nom du livre");
		container.add(nameFormElement);
		ElementSimpleForm isbnFormElement = new ElementSimpleForm("ISBN");
		container.add(isbnFormElement);
		ElementSimpleForm priceFormElement = new ElementSimpleForm("Prix neuf");
		container.add(priceFormElement);
		ElementListForm levelFormElement = new ElementListForm("Niveau", Utils.level);
		container.add(levelFormElement);
		ElementListForm sectionFormElement = new ElementListForm("Section", Utils.section);
		container.add(sectionFormElement);
		ElementListForm subjectFormElement = new ElementListForm("Matiere", Utils.subject);
		container.add(subjectFormElement);
		
		// Button submit
		JButton submitButton = new JButton("Valider");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				_name = nameFormElement.getText();
				_isbn = isbnFormElement.getText();
				_level = (String)levelFormElement.getComboBox().getSelectedItem();
				_section = (String)sectionFormElement.getComboBox().getSelectedItem();
				_subject = (String)subjectFormElement.getComboBox().getSelectedItem();
				try {
					_price = Double.parseDouble(Utils.correctedString(priceFormElement.getText()));
				}catch (NumberFormatException n) {
					_price = -1;
					ErrorDialog err = new ErrorDialog(1);
				}			
				if(_price != -1){
					wind.setPanel(new PanelAddBookSuite(wind, _name, _isbn, _price, _level, _section, _subject ), "liste des exemplaires");
					form.dispose();
				}
				System.out.println(_name + " " +_isbn + " " + _price + " " + _level + " " + _section + " " + _subject);
			}
		});
		container.add(submitButton);
		
		// Set
		this.setContentPane(container);
		this.pack();
		this.setVisible(true);
	}

}
