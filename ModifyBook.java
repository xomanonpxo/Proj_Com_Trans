import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class ModifyBook extends JDialog {
	
	private static final long serialVersionUID = 2042665390613161694L;
	
	// Data
	private JDialog form = this;
	private String _name;
	private String _isbn;
	private double _price;
	private String _level;
	private String _section;
	private String _subject;
	
	public ModifyBook(int i){
		
		// Window
		this.setTitle("Modifier Livre");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(isAlwaysOnTop());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// Main Panel
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(7,1));
		
		// Value Data
		_name = Datas.dataBooks[i][0];
		_isbn = Datas.dataBooks[i][1];
		_price = Double.parseDouble(Datas.dataBooks[i][2]);
		_level = Datas.dataBooks[i][3];
		_section = Datas.dataBooks[i][4];
		_subject = Datas.dataBooks[i][5];
		
		// Elements of the form
		ElementSimpleForm nameFormElement = new ElementSimpleForm("Nom du livre", _name);
		container.add(nameFormElement);
		ElementSimpleForm isbnFormElement = new ElementSimpleForm("ISBN", _isbn);
		container.add(isbnFormElement);
		ElementSimpleForm priceFormElement = new ElementSimpleForm("Prix neuf", Double.toString(_price));
		container.add(priceFormElement);
		ElementListForm levelFormElement = new ElementListForm("Niveau", (Object)_level, Utils.level);
		container.add(levelFormElement);
		ElementListForm sectionFormElement = new ElementListForm("Section", (Object)_section, Datas.section);
		container.add(sectionFormElement);
		ElementListForm subjectFormElement = new ElementListForm("Matiere", (Object)_subject, Datas.subject);
		container.add(subjectFormElement);
		
		// Button submit
		JButton submitButton = new JButton("Valider");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Datas.dataBooks[i][0] = nameFormElement.getText();
				Datas.dataBooks[i][1] = isbnFormElement.getText();
				Datas.dataBooks[i][3] = (String)levelFormElement.getComboBox().getSelectedItem();
				Datas.dataBooks[i][4] = (String)sectionFormElement.getComboBox().getSelectedItem();
				Datas.dataBooks[i][5] = (String)subjectFormElement.getComboBox().getSelectedItem();
				try {
					_price = Double.valueOf(priceFormElement.getText());
					Datas.dataBooks[i][2] = Utils.correctedString(priceFormElement.getText());
				}catch (NumberFormatException n) {
					_price = -1;
					Datas.dataBooks[i][2] = Double.toString(-1);
					ErrorDialog err = new ErrorDialog(1);
				}			
				if(_price != -1){
					form.dispose();
					form.setVisible(false);
				}
				System.out.println(Datas.dataBooks[i][0] + " " + Utils.dataBooks[i][1] + " " + Utils.dataBooks[i][2] + " " + Utils.dataBooks[i][3] + " " + Utils.dataBooks[i][4] + " " + Utils.dataBooks[i][5]);
			}
		});
		container.add(submitButton);
		
		// Set
		this.setContentPane(container);
		this.pack();
		this.setVisible(true);
	}

}
