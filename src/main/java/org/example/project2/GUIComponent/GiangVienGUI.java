package org.example.project2.GUIComponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.example.project2.Main;
import org.example.project2.GUIComponent.Dialog.ThemGiangVienDialog;
import org.example.project2.data.CallAPI;
import org.example.project2.model.GiangVien;

import com.google.gson.Gson;

public class GiangVienGUI extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField textSearch;
	private JTable table;
	JButton btnSua;
	JButton btnThem;
	JButton btnXoa;
	JButton importQues;
    private DefaultTableModel tableModel;
	JComboBox<String> comboBox;
	Main main;
	private final Gson gson = new Gson();
	
	String[] columns = {"Mã giảng viên", "Tên giảng viên","Môn đăng ký", "Loại giảng viên"};
	String[][] questions = {
			{"1","VIet nam o dau","https://localhost","web", "de","1"}
	};
	
	String[] valueComboBox = {"Tất cả", "Câu hỏi", "Topic","Mức độ", "Trạng thái"};
	/**
	 * Create the panel.
	 */
	public GiangVienGUI(Main main) {
		this.main= main;
		initComponents();
		setColumnWidths();
		loadDataToTable();
	}

	 private void addItemToComboBox(String[] values) {
		// TODO Auto-generated method stub
		for(String item : values) {
			comboBox.addItem(item);
		}
	}

	private void loadDataToTable() {
	        tableModel.setRowCount(0); 
	        CallAPI api = new CallAPI();
	        
	        api.fetchData("http://localhost:8080/api/giangvien/all", new CallAPI.Callback() {
	            @Override
	            public void onSuccess(String data) {
	            	GiangVien[] giangViens = gson.fromJson(data, GiangVien[].class);
	                for (GiangVien gv : giangViens) {
	                tableModel.addRow(new Object[]{
	                        gv.getMaGiangVien(),
	                        gv.getTenGiangVien(),
	                        gv.getLoaiGiangVien(),
	                        gv.getPhanCongGiangDays().size()
	                    });
	                }
	            }

	            @Override
	            public void onFailure(Exception e) {
	                e.printStackTrace();
	            }
	        });
	        
	        
	    }
	 
	 private void setColumnWidths() {
		    table.getColumnModel().getColumn(0).setPreferredWidth(40);  
		    table.getColumnModel().getColumn(1).setPreferredWidth(210); 
		    table.getColumnModel().getColumn(2).setPreferredWidth(150); 
		    table.getColumnModel().getColumn(3).setPreferredWidth(100); 
		}
	 
	 private void addRowToTable() {
		    tableModel.addRow(new Object[]{
		    });
		}

	private void initComponents() {
		// TODO Auto-generated method stub
		setSize(892,563);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 21, 321, 36);
		add(panel);
		
		textSearch = new JTextField();
		textSearch.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel.add(textSearch);
		textSearch.setColumns(15);
		
		textSearch.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e) {
//                searchEvent();
            }
        });
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(479, 21, 403, 36);
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnThem = new JButton("Thêm mới");
		btnThem.setBackground(Color.WHITE);
		panel_1.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setBackground(Color.WHITE);
		panel_1.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBackground(Color.WHITE);
		panel_1.add(btnXoa);
		
		importQues = new JButton("Import");
		importQues.setBackground(Color.WHITE);
		panel_1.add(importQues);
		
		
		
		JPanel panelTable = new JPanel();
		panelTable.setBackground(new Color(255, 255, 255));
		panelTable.setBounds(10, 67, 872, 470);
		add(panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));
		tableModel = new DefaultTableModel(columns, 0);
	    table = new JTable(tableModel);
		
		JScrollPane sp = new JScrollPane(table);
		panelTable.add(sp, BorderLayout.CENTER);
		
		comboBox = new JComboBox<>(valueComboBox);
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 12));
		comboBox.setBounds(341, 21, 75, 36);
		add(comboBox);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		importQues.addActionListener(this);
	}
	
	public int getSelectedRow() {
        int index = table.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(main, "Bạn chưa chọn câu hỏi nào", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return index;
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnThem) {
        		ThemGiangVienDialog themGiangVienDialog = new ThemGiangVienDialog(main);
        		themGiangVienDialog.setVisible(true);
        }
        
        if(e.getSource() == btnXoa) {
//            int index = getSelectedRow();
//            if (index != -1) {
//                if (JOptionPane.showConfirmDialog(main, "Bạn có chắc muốn xóa câu hỏi này không?", "", JOptionPane.YES_NO_OPTION) == 0) {
//                    q_BLL.delete(allQuestion.get(index));
//                }
//                loadDataToTable(allQuestion);
//            }
            
        }
        
        if(e.getSource() == btnSua) {
//            int index = getSelectedRow();
//            if(index != -1) {
//                AddEitQuestionDialog editSpDialog = new AddEitQuestionDialog(main, true, "Thêm sản phẩm", this, "edit", allQuestion.get(index));
//                editSpDialog.setVisible(true);
//                allQuestion = q_BLL.getAllQuestion();
//                loadDataToTable(allQuestion);
//            }
        }
        
        if(e.getSource() == importQues) {
//        	WorkWithExcel wwe = new WorkWithExcel();
//            JFileChooser chooseExcel = new JFileChooser();
//            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xls", "xlsx");
//            chooseExcel.setFileFilter(filter);
//            chooseExcel.setCurrentDirectory(new File("."));
//            int response = chooseExcel.showOpenDialog(null);
//            
//            if(response == JFileChooser.APPROVE_OPTION ) {
//            	String file = new String(chooseExcel.getSelectedFile().getAbsolutePath());
//            	if(wwe.readExcel(file)) {
//            		JOptionPane.showMessageDialog(main, "Đã thêm câu hỏi thành công từ file excel\n path:" + file, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//            		allQuestion = q_BLL.getAllQuestion();
//                    loadDataToTable(allQuestion);
//            	} else {
//            		JOptionPane.showMessageDialog(main, "Import file thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
//            	}
//            }
        }
        
    }
	
//	private void searchEvent() {                                      
//        String searchText = textSearch.getText();
//        loadDataToTable(q_BLL.search(searchText, (String) comboBox.getSelectedItem()));
//    }


}
