import java.awt.Dimension;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

/*
 * Element of a form that handle a date
 */

public class ElementDateForm extends JPanel {
	
	// Data
	JLabel _label;
	JFormattedTextField _textField = new JFormattedTextField();
	LocalDate _date;

	// Constructor
	public ElementDateForm(String line, String format){
		_label = new JLabel(line);
		try{
			MaskFormatter mf = new MaskFormatter(format);
			_textField = new JFormattedTextField(mf);
		} catch (ParseException e){
			e.printStackTrace();
		}
		_textField.setPreferredSize(new Dimension(80, 30));
		this.add(_label);
		this.add(_textField);
	}
	
	public ElementDateForm(String line, String s, String format){
		_label = new JLabel(line);
		try{
			MaskFormatter mf = new MaskFormatter(format);
			_textField = new JFormattedTextField(mf);
		} catch (ParseException e){
			e.printStackTrace();
		}
		_textField.setPreferredSize(new Dimension(80, 30));
		this.add(_label);
		this.add(_textField);
	}
	
	// Accessors
	public JLabel getLabel(){
		return _label;
	}

	public JFormattedTextField getTextField(){
		return _textField;
	}
	
	public String getText(){
		return _textField.getText();
	}
	
	public void setText(String s){
		_textField.setText(s);
	}
	
	public String getDate(){
		return _textField.getText();
	}
	
	//Methods
	public LocalDate getDateFromField(){
		if(_textField.getText() == "  /  /    "){
			_textField.setText("00/00/0000");
		}
		try{
			_date = LocalDate.parse(_textField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		} catch (NumberFormatException e) {
			ErrorDialog err = new ErrorDialog(0);			
		} catch (DateTimeParseException d) {
			ErrorDialog err = new ErrorDialog(0);			
		}
		_textField.setText("  /  /    ");
		return _date;
	}
	
}