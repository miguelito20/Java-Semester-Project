package media_managment_system;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppWindow {
	MP3_Player MP = new MP3_Player();
	
	
	private JFrame frame;
	private JTextField txtArtistName;
	private JTextField txtAlbumName;
	private JTextField txtSongName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow window = new AppWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 644, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSortByArtist = new JButton("Sort by Artist");
		btnSortByArtist.setBounds(496, 125, 107, 23);
		frame.getContentPane().add(btnSortByArtist);
		
		JList list = new JList();
		list.setBackground(Color.BLACK);
		list.setBounds(212, 200, 137, -118);
		frame.getContentPane().add(list);
		
		txtArtistName = new JTextField();
		txtArtistName.setBounds(10, 33, 86, 20);
		frame.getContentPane().add(txtArtistName);
		txtArtistName.setColumns(10);
		
		JLabel lblArtistName = new JLabel("Artist Name");
		lblArtistName.setBounds(23, 11, 86, 14);
		frame.getContentPane().add(lblArtistName);
		
		txtAlbumName = new JTextField();
		txtAlbumName.setBounds(123, 33, 86, 20);
		frame.getContentPane().add(txtAlbumName);
		txtAlbumName.setColumns(10);
		
		txtSongName = new JTextField();
		txtSongName.setBounds(229, 33, 86, 20);
		frame.getContentPane().add(txtSongName);
		txtSongName.setColumns(10);
		
		JLabel lblAlbumName = new JLabel("Album Name");
		lblAlbumName.setBounds(136, 11, 86, 14);
		frame.getContentPane().add(lblAlbumName);
		
		JLabel lblSongName = new JLabel("Song Name");
		lblSongName.setBounds(242, 11, 86, 14);
		frame.getContentPane().add(lblSongName);
		
		JButton btnAddSong = new JButton("Add Song");
		btnAddSong.setBounds(325, 32, 107, 23);
		frame.getContentPane().add(btnAddSong);
		
		JButton btnSortByAlbum = new JButton("Sort by Album");
		btnSortByAlbum.setBounds(496, 159, 107, 23);
		frame.getContentPane().add(btnSortByAlbum);
		
		JButton btnSortBySong = new JButton("Sort by Song");
		btnSortBySong.setBounds(496, 193, 107, 23);
		frame.getContentPane().add(btnSortBySong);
		
		JButton btnplay = new JButton("> (Play)");
		btnplay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MP.Play("G:\\Music\\ASAP Ferg - Ferg Forever(DatPiff.com)\\Hood Tales.mp3");
			}
		});
		btnplay.setBounds(263, 440, 89, 23);
		frame.getContentPane().add(btnplay);
		
		JButton btnLlpause = new JButton("ll (Pause)");
		btnLlpause.setBounds(381, 440, 89, 23);
		frame.getContentPane().add(btnLlpause);
		
		JButton btnstop = new JButton("[] (Stop)");
		btnstop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MP.Stop();
			}
		});
		btnstop.setBounds(136, 440, 89, 23);
		frame.getContentPane().add(btnstop);
	}
}
