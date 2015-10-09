import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

	public class GUI extends JFrame {
		private JLabel mediaplayer;
		public GUI(){
		// Essential base setup to the GUI
		int framewidth = 700;
		int frameheight = 800;
		JFrame frame = new JFrame();
		frame.setSize(framewidth, frameheight);
		frame.setTitle("Media Player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
	}
