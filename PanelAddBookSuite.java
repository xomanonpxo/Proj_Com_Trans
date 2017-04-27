
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.rmi.CORBA.Util;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

public class PanelAddBookSuite extends JPanel {

	public PanelAddBookSuite(WindowMain window, String _name, String _isbn, double _price, String _level, String _section, String _subject ){

		// Buttons
	    JButton buttonMainPage = new JButton("<< Liste des stocks");
		buttonMainPage.setHorizontalAlignment(JButton.CENTER);
		buttonMainPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setPanel(new PanelStock(window), "Accueil");
			}
		});
		
	    JButton buttonAddBook = new JButton("Ajouter Exemplaire");
	    buttonAddBook.setHorizontalAlignment(JButton.CENTER);
	    buttonAddBook.setPreferredSize(new Dimension(100, 30));
	    buttonAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jop = new JOptionPane();
			    String nbexemplaires = jop.showInputDialog(null, "Combien d'exemplairevoulez vous ajouter ?", "", JOptionPane.QUESTION_MESSAGE);
				int nb =Integer.parseInt(nbexemplaires);
				Datas.dataBooks[Datas.idBooks-1][6]= String.valueOf(nb);
				String today = new String(); 

				Date date = new Date();
				Calendar c = Calendar.getInstance(); 
				c.setTime(date); 

				today += c.get(Calendar.DATE); 
				today += "/" + c.get(Calendar.MONTH); 
				today += "/" + c.get(Calendar.YEAR); 
				if (nb > 1){
					Utils.dataCopyNull[0][0] = "1";
					Utils.dataCopyNull[0][1] = today;
					Utils.dataCopyNull[0][2] = "neuf";
					System.out.println(Utils.dataCopyNull[0][2]);
				}
				for(int i =1; i<nb; i++){
					Utils.dataCopyNull[i][0] = Integer.toString(i+1);
					Utils.dataCopyNull[i][1] = today;
					Utils.dataCopyNull[i][2] = "neuf";
				}
				
	
			}
		});
	    JLabel name = new JLabel("Titre : "+_name);
	    JLabel isbn = new JLabel("ISBN : "+_isbn);
	    JLabel price = new JLabel("Prix : "+String.valueOf(_price));
	    JLabel section = new JLabel("Niveau : "+_section);	    
	    JLabel subject  = new JLabel(_subject);


		
		// Table
	    ZModel model = new ZModel(Utils.dataCopyNull, Utils.titleCopy);
	    JTable tableau = new JTable(model);
	    tableau.setDefaultRenderer(JButton.class, new TableComponents());
	    JScrollPane scroll = new JScrollPane(tableau);
	    
	    // Interface   
	    
	    GridLayout gl = new GridLayout();
	    gl.setColumns(2);
	    gl.setRows(4);
	    this.setLayout(gl);
	    
		//this.setLayout(new BorderLayout());
	    this.add(buttonMainPage);
	    this.add(buttonAddBook);
		this.add(name);
		this.add(isbn);
		this.add(price);
		this.add(subject);
		this.add(section);
		
		
		Datas.dataBooks[Datas.idBooks][0]= _name;
		Datas.dataBooks[Datas.idBooks][1]= _isbn;
		Datas.dataBooks[Datas.idBooks][2]= String.valueOf(_price);
		Datas.dataBooks[Datas.idBooks][3]= _level;
		Datas.dataBooks[Datas.idBooks][4]= _section;
		Datas.dataBooks[Datas.idBooks][5]= _subject;
		Datas.idBooks ++;

		
		this.add(buttonAddBook);
		this.add(scroll);
		//System.out.println(_name+ _isbn+ _section+ _subject);
	}
	
}