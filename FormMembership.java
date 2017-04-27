import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class FormMembership extends JDialog {
	
	private static final long serialVersionUID = 2422346856931000100L;
	
	private JDialog form = this;
	
	// Constructor
	public FormMembership(){
		
		// Window
		this.setTitle("Nouvelle Adhesion");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(isAlwaysOnTop());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// Main Panel
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(5,3));
		
		// String Array of names
		String[] fullName = new String[Datas.idMember];
		String[] firstName = new String[Datas.idMember];
		for(int i = 0; i < Datas.idMember; ++i){
			fullName[i] = Datas.dataMember[i][0] + " " + Datas.dataMember[i][1] ;
		}

		// Elements of the form
		ElementListForm fullNameListElement = new ElementListForm("Adh�rent", fullName);
		container.add(fullNameListElement);
		ElementListForm typeFormElement = new ElementListForm("Type d'adhesion", "Base", "Soutien", "Bienfaiteur");
		container.add(typeFormElement);
		ElementDateForm startDateFormElement = new ElementDateForm("Date de debut", "##/##/####");
		container.add(startDateFormElement);
		ElementDateForm endDateFormElement = new ElementDateForm("Date de fin", "##/##/####");
		container.add(endDateFormElement);
		
		// Submit
		JButton submitButton = new JButton("Valider");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				LocalDate start, end;
				start = startDateFormElement.getDateFromField();
				end = endDateFormElement.getDateFromField();
				if(start != null && end != null){
					Datas.dataMembership[Datas.idMembership][0] = String.valueOf(Datas.idMembership);
					Datas.dataMembership[Datas.idMembership][1] = Datas.dataMember[fullNameListElement.getComboBox().getSelectedIndex()][1];
					Datas.dataMembership[Datas.idMembership][2] = Datas.dataMember[fullNameListElement.getComboBox().getSelectedIndex()][0];
					Datas.dataMembership[Datas.idMembership][3] = (String)typeFormElement.getComboBox().getSelectedItem();
					Datas.dataMembership[Datas.idMembership][4] = startDateFormElement.getDate();
					Datas.dataMembership[Datas.idMembership][5] = endDateFormElement.getDate();
					Datas.idMembership += 1;
					form.dispose();
					form.setVisible(false);
				}
				System.out.println(Datas.dataMembership[Datas.idMembership][0] + " "+ Datas.dataMembership[Datas.idMembership][1] + " " + Datas.dataMembership[Datas.idMembership][2]);
			}

		});
		
		container.add(submitButton);
		
		// Set
		this.setContentPane(container);
		this.pack();
		this.setVisible(true);
	}
	
}
