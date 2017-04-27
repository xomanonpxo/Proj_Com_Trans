import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Element of a form that handle a simple field
 */

public class ElementSimpleForm extends JPanel {
	
	// Data
	JLabel _label;
	JTextField _textField;
	
	// Constructor
	public ElementSimpleForm(String line){
		_label = new JLabel(line);
		_textField = new JTextField("");
		_textField.setPreferredSize(new Dimension(200, 30));
		this.add(_label);
		this.add(_textField);
	}
	
	// Constructor
	public ElementSimpleForm(String line, String field){
		_label = new JLabel(line);
		_textField = new JTextField(field);
		_textField.setPreferredSize(new Dimension(200, 30));
		this.add(_label);
		this.add(_textField);
	}
	
	// Accessors
	public JLabel getLabel(){
		return _label;
	}

	public JTextField getTextField(){
		return _textField;
	}
	
	public String getText(){
		return _textField.getText();
	}
	
	public void setText(String s){
		_textField.setText(s);
	}
	
}
