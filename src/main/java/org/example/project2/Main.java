package org.example.project2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import org.example.project2.GUIComponent.GiangVienGUI;
import org.example.project2.GUIComponent.ThongTinChungGUI;
import org.example.project2.GUIComponent.SideBar.SideMenu;
import org.example.project2.model.GiangVienHocPhan;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main extends JFrame {

	
	private JPanel contentPane;
	private JTextArea textArea;
	private static final long serialVersionUID = 1L;
	public JPanel Content = new JPanel();
	public CardLayout cardLayout;
	public SideMenu sideMenu;
	private ThongTinChungGUI thongtinchungPanel;
	private GiangVienGUI giangvienPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		getContentPane().setBackground(Color.WHITE);
		initCompponents();
	}
	
	private void initCompponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		setTitle("Admin");
		setSize(1200,700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		thongtinchungPanel = new ThongTinChungGUI(this);
		giangvienPanel = new GiangVienGUI(this);
		
		cardLayout = new CardLayout();
	    Content.setLayout(cardLayout);
	    Content.setBounds(248, 0, 938, 563);
	    
	    Content.add(thongtinchungPanel, "dashboard");
	    Content.add(giangvienPanel, "lecturer");
	    getContentPane().add(Content);
	    
	    
	    JPanel panel = new SideMenu(this); 
	    panel.setBounds(0, 0, 250, 563);
	    getContentPane().add(panel);
	}
	
	
	public void switchCard(String panelName) {
        cardLayout.show(Content, panelName);
    }
	
	

}
