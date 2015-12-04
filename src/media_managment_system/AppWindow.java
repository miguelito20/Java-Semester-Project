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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AppWindow {
	MP3_Player MP = new MP3_Player();//Calling the MP3_Player Class and its methods to allow the GUI to play .mp3 files
	Artist_Sort AS = new Artist_Sort();//Calling the Artist_Sort Class and its methods to sort the XML Files 
	XMLLoad MIN	= new XMLLoad();//Calling the XMLLoad Class and its methods to read and write to the XML File
	
	private JFrame frame;
	private JTextField txtArtistName;
	private JTextField txtAlbumName;
	private JTextField txtSongName;
	private JTable table;
	private String Source = "Try_To_Remeber.mp3";//Variable to store the name of the .mp3 file so the program knows what file to stream
	

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
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setBackground(Color.GREEN);
		frame.setBounds(100, 100, 644, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JList list = new JList();//possible display for XML File content
		list.setBackground(Color.BLACK);
		list.setBounds(212, 200, 137, -118);
		frame.getContentPane().add(list);
		
		txtArtistName = new JTextField();//Input source for new artist name
		txtArtistName.setBounds(10, 33, 86, 20);
		frame.getContentPane().add(txtArtistName);
		txtArtistName.setColumns(10);
		
		txtAlbumName = new JTextField();//Input source for new album name
		txtAlbumName.setBounds(123, 33, 86, 20);
		frame.getContentPane().add(txtAlbumName);
		txtAlbumName.setColumns(10);
		
		txtSongName = new JTextField();//Input source for new song name
		txtSongName.setBounds(229, 33, 86, 20);
		frame.getContentPane().add(txtSongName);
		txtSongName.setColumns(10);
		

		JLabel lblArtistName = new JLabel("Artist Name");//Label for Artist Name text field
		lblArtistName.setBounds(23, 11, 86, 14);
		frame.getContentPane().add(lblArtistName);
		
		JLabel lblAlbumName = new JLabel("Album Name");//Label for Album Name text field
		lblAlbumName.setBounds(136, 11, 86, 14);
		frame.getContentPane().add(lblAlbumName);
		
		JLabel lblSongName = new JLabel("Song Name");//Label for Song Name text field
		lblSongName.setBounds(242, 11, 86, 14);
		frame.getContentPane().add(lblSongName);
		
		
		JButton btnAddSong = new JButton("Add Song");//Button to add a new song record to the XML File
		btnAddSong.setBounds(325, 32, 107, 23);
		frame.getContentPane().add(btnAddSong);
		btnAddSong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//MIN.addSong(txtArtistName, txtAlbumName, txtSongName)
			}});
		
		
		JButton btnSortByAlbum = new JButton("Sort by Album");//Button to Sort the XML File content by Album - alphabetically 
		btnSortByAlbum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MIN.Pull();
			}});
		btnSortByAlbum.setBounds(496, 159, 107, 23);
		frame.getContentPane().add(btnSortByAlbum);
		
		
		JButton btnSortBySong = new JButton("Sort by Song");//Button to Sort the XML File content by Song - alphabetically 
		btnSortBySong.setBounds(496, 193, 107, 23);
		frame.getContentPane().add(btnSortBySong);
		btnSortBySong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			}
		});
		
		
		JButton btnSortByArtist = new JButton("Sort by Artist");//Button to Sort the XML File content by Artist - alphabetically 
		btnSortByArtist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AS.main(null);
			}
		});
		btnSortByArtist.setBounds(496, 125, 107, 23);
		frame.getContentPane().add(btnSortByArtist);
		
		
		JButton btnplay = new JButton("> (Play)");//Button to play the selected song
		btnplay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MP.Play(Source);
			}
		});
		btnplay.setBounds(263, 440, 89, 23);
		frame.getContentPane().add(btnplay);
		
		
		JButton btnLlpause = new JButton("ll (Pause)");//Button to pause the currently playing song
		btnLlpause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MP.Pause();
			}
		});
		btnLlpause.setBounds(381, 440, 89, 23);
		frame.getContentPane().add(btnLlpause);
		
		
		JButton btnstop = new JButton("[] (Stop)");//Button to stop the currently playing song
		btnstop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MP.Stop();
			}
		});
		btnstop.setBounds(136, 440, 89, 23);
		frame.getContentPane().add(btnstop);
		
		table = new JTable();
		table.setBounds(95, 129, 375, 95);
		frame.getContentPane().add(table);
	}
}
