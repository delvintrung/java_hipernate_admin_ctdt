package org.example.project2.GUIComponent.Dialog;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JPanel;
import org.example.project2.model.ThongTinChung;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ChiTietThongTinChungDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtTenChuongTrinh;
	private JTextField txtNamBatDau;
	private JTextField txtKhoaQuanLy;
	private JTextField txtBac;
	private JTextField txtChuongTrinhDaoTao;
	private JTextField txtSoTinChi;
	private JTextField txtNgonNgu;
	private JTextField txtWebsite;

	

	/**
	 * Create the dialog.
	 */
	public ChiTietThongTinChungDialog(Frame parent, ThongTinChung thongtinchung) {
		setBackground(new Color(255, 255, 255));
		setSize(700,600);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chi Tiết Chương Trình Đào Tạo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(197, 22, 301, 35);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên chương trình:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(26, 66, 126, 24);
		
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Năm bắt đầu:");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(26, 100, 126, 24);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Khoa quản lý:");
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(26, 134, 126, 24);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Bậc:");
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(26, 168, 126, 24);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Chương trình đào tạo:");
		lblNewLabel_1_4.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(26, 202, 126, 24);
		getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Số tín chỉ tối thiểu:");
		lblNewLabel_1_5.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(26, 236, 126, 24);
		getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Ngôn ngữ:");
		lblNewLabel_1_6.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_6.setBounds(26, 281, 126, 24);
		getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Mô tả:");
		lblNewLabel_1_6_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_6_1.setBounds(26, 329, 126, 24);
		getContentPane().add(lblNewLabel_1_6_1);
		
		JLabel lblNewLabel_1_6_1_1 = new JLabel("website:");
		lblNewLabel_1_6_1_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_6_1_1.setBounds(26, 494, 126, 24);
		getContentPane().add(lblNewLabel_1_6_1_1);
		
		txtTenChuongTrinh = new JTextField();
		txtTenChuongTrinh.setBounds(162, 67, 486, 23);
		txtTenChuongTrinh.setText(thongtinchung.getTenCTDT());
		txtTenChuongTrinh.setEditable(false);
		getContentPane().add(txtTenChuongTrinh);
		txtTenChuongTrinh.setColumns(10);
		
		txtNamBatDau = new JTextField();
		txtNamBatDau.setColumns(10);
		txtNamBatDau.setBounds(162, 104, 486, 23);
		txtNamBatDau.setText(String.valueOf(thongtinchung.getNamBatDau()));
		txtNamBatDau.setEditable(false);
		getContentPane().add(txtNamBatDau);
		
		txtKhoaQuanLy = new JTextField();
		txtKhoaQuanLy.setColumns(10);
		txtKhoaQuanLy.setBounds(162, 138, 486, 23);
		txtKhoaQuanLy.setText(thongtinchung.getKhoaQuanLy());
		txtKhoaQuanLy.setEditable(false);
		getContentPane().add(txtKhoaQuanLy);
		
		txtBac = new JTextField();
		txtBac.setColumns(10);
		txtBac.setBounds(162, 172, 486, 23);
		txtBac.setText(thongtinchung.getBac());
		txtBac.setEditable(false);
		getContentPane().add(txtBac);
		
		txtChuongTrinhDaoTao = new JTextField();
		txtChuongTrinhDaoTao.setColumns(10);
		txtChuongTrinhDaoTao.setBounds(162, 206, 486, 23);
		txtChuongTrinhDaoTao.setText(thongtinchung.getLoaiHinhDaoTao());
		txtChuongTrinhDaoTao.setEditable(false);
		getContentPane().add(txtChuongTrinhDaoTao);
		
		txtSoTinChi = new JTextField();
		txtSoTinChi.setColumns(10);
		txtSoTinChi.setBounds(162, 240, 486, 23);
		txtSoTinChi.setText(String.valueOf(thongtinchung.getSoTinChiToiThieu()));
		txtSoTinChi.setEditable(false);
		getContentPane().add(txtSoTinChi);
		
		txtNgonNgu = new JTextField();
		txtNgonNgu.setColumns(10);
		txtNgonNgu.setBounds(162, 285, 486, 23);
		txtNgonNgu.setText(thongtinchung.getNgonNgu());
		txtNgonNgu.setEditable(false);
		getContentPane().add(txtNgonNgu);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(162, 330, 486, 162);
		textArea.setText(thongtinchung.getMoTa());
		textArea.setEditable(false);
		getContentPane().add(textArea);
		
		txtWebsite = new JTextField();
		txtWebsite.setColumns(10);
		txtWebsite.setBounds(162, 498, 486, 23);
		txtWebsite.setText(thongtinchung.getWebsite());
		txtWebsite.setEditable(false);
		getContentPane().add(txtWebsite);
        this.setLocationRelativeTo(null);
	}
}
