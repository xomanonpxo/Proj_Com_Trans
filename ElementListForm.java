import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Element of a form that handle a list
 */

public class ElementListForm extends JPanel {
	
	// Data
	JLabel _label;
	JComboBox _combo;
	
	// Constructor
	public ElementListForm(String line, String... choices){
		_label = new JLabel(line);
		_combo = new JComboBox();
		for(int i = 0; i < choices.length; ++i)
			_combo.addItem(choices[i]);
		//_combo.setPreferredSize(new Dimension(200, 30));
		this.add(_label);
		this.add(_combo);
	}
	
	public ElementListForm(String line, Object s, String... choices){
		_label = new JLabel(line);
		_combo = new JComboBox();
		for(int i = 0; i < choices.length; ++i)
			_combo.addItem(choices[i]);
		_combo.setSelectedItem(s);
		//_combo.setPreferredSize(new Dimension(200, 30));
		this.add(_label);
		this.add(_combo);
	}
	
	// Accessors
	public JLabel getLabel(){
		return _label;
	}

	public JComboBox getComboBox(){
		return _combo;
	}
	
	public void setText(String s){
		_combo.setSelectedItem(s);
	}
	
}
