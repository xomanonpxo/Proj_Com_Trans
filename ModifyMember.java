import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyMember extends JDialog {

	private static final long serialVersionUID = 3062996325912097644L;

	private ModifyMember form = this;
	
	// Constructor
	public ModifyMember(int i){
		
		// Window
		this.setTitle("Modifier Adherent");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(isAlwaysOnTop());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// Main Panel
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(6,1));
				
		// Elements of the form
		ElementSimpleForm nameFormElement = new ElementSimpleForm("Nom", Datas.dataMember[i][0]);
		container.add(nameFormElement);
		ElementSimpleForm firstNameFormElement = new ElementSimpleForm("Prenom", Datas.dataMember[i][1]);
		container.add(firstNameFormElement);
		ElementSimpleForm emailFormElement = new ElementSimpleForm("Email", Datas.dataMember[i][2]);
		container.add(emailFormElement);
		ElementSimpleForm landlineNumberFormElement = new ElementSimpleForm("Tel. fixe", Datas.dataMember[i][3]);
		container.add(landlineNumberFormElement);
		ElementSimpleForm mobileNumberFormElement = new ElementSimpleForm("Tel. port", Datas.dataMember[i][4]);
		container.add(mobileNumberFormElement);
		
		// Button submit
		JButton submitButton = new JButton("Valider");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Datas.dataMember[i][0] = nameFormElement.getText();
				Datas.dataMember[i][1] = firstNameFormElement.getText();
				Datas.dataMember[i][2] = emailFormElement.getText();
				Datas.dataMember[i][3] = landlineNumberFormElement.getText();
				Datas.dataMember[i][4] = mobileNumberFormElement.getText();
				form.dispose();
				form.setVisible(false);
			}
		});
		container.add(submitButton);
		
		// Set
		this.setContentPane(container);
		this.pack();
		this.setVisible(true);
	}
	
}

