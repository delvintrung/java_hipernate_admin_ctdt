package org.example.project2.GUIComponent.Dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class ThemGiangVienDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtEmail;
	private JTextField txtTen;
	private JComboBox cbbLoai;


	/**
	 * Create the dialog.
	 */
	public ThemGiangVienDialog(Frame parent) {
		super(parent);
		setSize(700,600);
		getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(null);
        
        JLabel lblTitle = new JLabel("Loại giảng viên:");
        lblTitle.setFont(new Font("Verdana", Font.PLAIN, 12));
        lblTitle.setBounds(87, 127, 137, 39);
        getContentPane().add(lblTitle);
        
        JLabel lblHTn = new JLabel("Tên giảng viên");
        lblHTn.setFont(new Font("Verdana", Font.PLAIN, 12));
        lblHTn.setBounds(87, 75, 137, 39);
        getContentPane().add(lblHTn);
        
        JLabel lblNewLabel = new JLabel("Thêm Giảng Viên");
        lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(236, 23, 217, 33);
        getContentPane().add(lblNewLabel);
        
        cbbLoai = new JComboBox();
        cbbLoai.setBackground(Color.WHITE);
        cbbLoai.setForeground(Color.BLACK);
        cbbLoai.setFont(new Font("Verdana", Font.PLAIN, 14));
        cbbLoai.setModel(new DefaultComboBoxModel(new String[] {"Cơ hữu", "Thỉnh giảng"}));
        cbbLoai.setBounds(234, 127, 306, 39);
        getContentPane().add(cbbLoai);
        
        JLabel lblMTiKhon = new JLabel("Email:");
        lblMTiKhon.setFont(new Font("Verdana", Font.PLAIN, 12));
        lblMTiKhon.setBounds(87, 220, 137, 39);
        getContentPane().add(lblMTiKhon);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(235, 217, 306, 33);
        getContentPane().add(txtEmail);
        txtEmail.setColumns(10);
        
        txtTen = new JTextField();
        txtTen.setColumns(10);
        txtTen.setBounds(234, 75, 306, 33);
        getContentPane().add(txtTen);
        
        JButton btnThem = new JButton("Them");
        btnThem.setBackground(Color.WHITE);
        btnThem.setFont(new Font("Verdana", Font.PLAIN, 14));
        btnThem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		themGiangVien();
        	}
        });
        btnThem.setBounds(251, 318, 132, 39);
        getContentPane().add(btnThem);
        
        
        this.setLocationRelativeTo(null);
	}

	private void themGiangVien() {
		
            try {
                String tenGiangVien = txtTen.getText();
                String loaiGiangVien = (String) cbbLoai.getSelectedItem();
                String email = txtEmail.getText();

                
                String json = String.format(
                        "{\"tenGiangVien\": \"%s\", \"loaiGiangVien\": \"%s\", \"email\": \"%s\"}",
                        tenGiangVien, loaiGiangVien, email
                );

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:8080/api/giangvien"))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(json))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println("Phản hồi từ server: " + response.body());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Lỗi: " + e.getMessage());
            }
        
}
}
