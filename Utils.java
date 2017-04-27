public class Utils {
	public static int idBooks = 24;
	//Tabs
	public static String[] titleBooks = {"Nom du livre", "ISBN", "Prix Neuf", "Niveau", "Section", "Matière"};
	public static String[][] dataBooks = {
		      {"Manuel d'histoire", "9782868890061", "25€", "Terminale", "S", "Histoire"},
		      {"Manuel de géographie", "9782868890062", "27€", "Terminale", "S", "Géographie"},
		      {"Manuel de français", "9782868890063", "35€", "Terminale", "S", "Français"},
		      {"Manuel d'anglais", "9782868890064", "19€", "Terminale", "S", "Anglais"},
		      {"Manuel d'espagnol", "9782868890065", "19€", "Terminale", "S", "Espagnol"},
		      {"Manuel de physique", "9782868890066", "27€", "Terminale", "S", "Physique"},
		      {"Manuel de chime", "9782868890067", "27€", "Terminale", "S", "Chimie"},
		      {"Manuel de svt", "9782868890068", "20€", "Terminale", "S", "SVT"},
		      {"Manuel d'histoire", "9782868890061", "25€", "Première", "ES", "Histoire"},
		      {"Manuel de géographie", "9782868890062", "27€", "Première", "ES", "Géographie"},
		      {"Manuel de français", "9782868890063", "35€", "Première", "ES", "Français"},
		      {"Manuel d'anglais", "9782868890064", "19€", "Première", "ES", "Anglais"},
		      {"Manuel d'espagnol", "9782868890065", "19€", "Première", "ES", "Espagnol"},
		      {"Manuel de physique", "9782868890066", "27€", "Première", "ES", "Physique"},
		      {"Manuel de chimie", "9782868890067", "27€", "Première", "ES", "Chimie"},
		      {"Manuel de svt", "9782868890068", "20€", "Première", "ES", "SVT"},
		      {"Manuel d'histoire", "9782868890061", "25€", "Seconde", "L", "Histoire"},
		      {"Manuel de géographie", "9782868890062", "27€", "Seconde", "L", "Géographie"},
		      {"Manuel de français", "9782868890063", "35€", "Seconde", "L", "Français"},
		      {"Manuel d'anglais", "9782868890064", "19€", "Seconde", "L", "Anglais"},
		      {"Manuel d'espagnol", "9782868890065", "19€", "Seconde", "L", "Espagnol"},
		      {"Manuel de physique", "9782868890066", "27€", "Seconde", "L", "Physique"},
		      {"Manuel de chimie", "9782868890067", "27€", "Seconde", "L", "Chimie"},
		      {"Manuel de  svt", "9782868890068", "20€", "Seconde", "L", "SVT"},
		      {"","","","","",""},
		      {"","","","","",""},
		      {"","","","","",""},
		      {"","","","","",""},
		    };
	public static String[] titleCopy = {"id", "Date d'ajout", "Etat Actuel"};
	public static String[][] dataCopy = {
			{"14", "12/06/2015", "neuf"},
			{"18", "21/05/2016", "occasion1"},
			{"2","12/01/2017","occasion2"},
	};
	public static String [][] dataCopyNull = {
			{"","",""},
			{"","",""},
			{"","",""},
			{"","",""},
			{"","",""},
			{"","",""},
			{"","",""},
			{"","",""},
			{"","",""},
			{"","",""},
			{"","",""},
			{"","",""},
			{"","",""},
			{"","",""},
			{"","",""},
			{"","",""},
	};
	public static String[] titleMember = {"Nom", "Prénom", "Email", "Tél. fixe", "Tél. port"};
	public static String[][] dataMember = {
		      {"Alice", "Willis", "alice.willis@gmail.com", "0578963425", "0618956434"},
		      {"Raven", "Reyes", "raven.reyes@gmail.com", "0579941219", "0619487658"},
		      {"Thomas", "Labat", "thomas.labat@gmail.com", "0509184851", "0636291847"},
		    };
	
	public static String[] titleMembership = {"Id", "Nom", "Prénom", "Type d'adhésion", "Date de début", "Date de fin"};
	public static String[][] dataMembership = {
		      {"57", "Alice", "Willis", "Base", "30/01/2015", "05/07/2016"},
		      {"85", "Raven", "Reyes", "Soutien", "19/08/2016", "05/07/2017"},
		      {"32", "Thomas", "Labat", "Bienfaiteur", "21/09/2016", "05/07/2017"},
    };

	// Forms
	public static String[] currentCondition = {"Neuf", "Occasion Niveau 2", "Occasion Niveau 3", "Occasion Niveau 4", "Occasion Niveau 5"};
	public static String[] level = {"Seconde", "Première", "Terminale"};
	public static String[] section = {"Générale", "L", "ES", "S"};
	public static String[] subject = {"Histoire", "Géographie", "Français", "Anglais", "Espagnol", "Physique", "Chimie", "SVT"};

	/*
	 * Correct input int or double
	 */
	public static String correctedString(String s){
		char[] temp = s.toCharArray();
		StringBuffer str = new StringBuffer("");
		for(int i = 0; i < temp.length; ++i){
			if(temp[i] == ',')
				temp[i] = '.';
			str.append(temp[i]);
		}
		return str.toString();
	}
	
}
