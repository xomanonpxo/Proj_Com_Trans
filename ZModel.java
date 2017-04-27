
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

//Classe mod�le personnalis�e
class ZModel extends AbstractTableModel{
private Object[][] data;
private String[] title;

//Constructeur
public ZModel(Object[][] data, String[] title){
  this.data = data;
  this.title = title;
}

//Retourne le nombre de colonnes
public int getColumnCount() {
  return this.title.length;
}

//Retourne le nombre de lignes
public int getRowCount() {
  return this.data.length;
}

//Retourne la valeur a l'emplacement spécifié
public Object getValueAt(int row, int col) {
  return this.data[row][col];
}  
public String getColumnName(int col) {
	  return this.title[col];
	}
//Retourne la classe de la donnee de la colonne
public Class getColumnClass(int col){
//On retourne le type de la cellule à la colonne demandée
//On se moque de la ligne puisque les types de donnees sont les memes quelque soit la ligne
//On choisit donc la première ligne
return this.data[0][col].getClass();
}
}
