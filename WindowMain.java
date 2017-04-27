import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowMain extends JFrame {
		
	public WindowMain(String s){
	    this.setTitle(s);
	    this.setSize(800, 400);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
	}
	
	public void setPanel(JPanel panel, String s){
	    this.setTitle(s);
		this.getContentPane().removeAll();
		this.getContentPane().invalidate();
		this.getContentPane().add(panel);
		this.getContentPane().revalidate();
	}
}
