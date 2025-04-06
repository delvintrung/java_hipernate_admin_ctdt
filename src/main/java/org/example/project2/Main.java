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

import org.example.project2.GUIComponent.ThongTinChung;
import org.example.project2.GUIComponent.SideBar.SideMenu;

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
	private ThongTinChung thongtinchungPanel;
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
		setSize(1000,600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		thongtinchungPanel = new ThongTinChung(this);
		
		cardLayout = new CardLayout();
	    Content.setLayout(cardLayout);
	    Content.setBounds(248, 0, 738, 563);
	    
	    Content.add(thongtinchungPanel, "Thong Tin Chung");
	    getContentPane().add(Content);
	    
	    
	    JPanel panel = new SideMenu(this); 
	    panel.setBounds(0, 0, 250, 563);
	    getContentPane().add(panel);
	}
	
	
	public void switchCard(String panelName) {
        cardLayout.show(Content, panelName);
    }
	
	private void fetchData(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        new Thread(() -> {
            try (Response response = client.newCall(request).execute()) {
                String result = response.body().string();
                SwingUtilities.invokeLater(() -> textArea.setText(result));
            } catch (Exception e) {
                e.printStackTrace();
                SwingUtilities.invokeLater(() -> textArea.setText("Lỗi gọi API"));
            }
        }).start();
    }

}
