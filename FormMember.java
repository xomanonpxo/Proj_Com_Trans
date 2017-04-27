import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMember extends JDialog {

	private static final long serialVersionUID = 3062996325912097644L;
	
	// Data
	private JDialog form = this;
	
	// Constructor
	public FormMember(){
		
		// Window
		this.setTitle("Nouveau Adherent");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(isAlwaysOnTop());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// Main Panel
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(6,1));
		
		// Elements of the form
		ElementSimpleForm nameFormElement = new ElementSimpleForm("Nom");
		container.add(nameFormElement);
		ElementSimpleForm firstNameFormElement = new ElementSimpleForm("Prenom");
		container.add(firstNameFormElement);
		ElementSimpleForm emailFormElement = new ElementSimpleForm("Email");
		container.add(emailFormElement);
		ElementSimpleForm landlineNumberFormElement = new ElementSimpleForm("Tel. fixe");
		container.add(landlineNumberFormElement);
		ElementSimpleForm mobileNumberFormElement = new ElementSimpleForm("Tel. portable");
		container.add(mobileNumberFormElement);
		
		// Button submit
		JButton submitButton = new JButton("Valider");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Datas.dataMember[Datas.idMember][0] = nameFormElement.getText();
				Datas.dataMember[Datas.idMember][1] = firstNameFormElement.getText();
				Datas.dataMember[Datas.idMember][2] = emailFormElement.getText();
				Datas.dataMember[Datas.idMember][3] = landlineNumberFormElement.getText();
				Datas.dataMember[Datas.idMember][4] = mobileNumberFormElement.getText();
				Datas.idMember += 1;
				form.dispose();
				form.setVisible(false);
				//System.out.println(_name + " " +_firstName + " " + _email + " " + _landlineNumber + " " + _mobileNumber);
			}
		});
		container.add(submitButton);
		
		// Set
		this.setContentPane(container);
		this.pack();
		this.setVisible(true);
	}
	
}

