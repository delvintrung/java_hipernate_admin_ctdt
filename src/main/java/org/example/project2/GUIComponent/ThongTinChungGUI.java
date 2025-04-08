package org.example.project2.GUIComponent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.example.project2.Main;
import org.example.project2.GUIComponent.Dialog.ChiTietThongTinChungDialog;
import org.example.project2.data.CallAPI;
import org.example.project2.model.ThongTinChung;

import com.google.gson.Gson;

import java.awt.Font;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JComboBox;

public class ThongTinChungGUI extends JPanel implements ActionListener  {

	private static final long serialVersionUID = 1L;
	private JTextField textSearch;
	private JTable table;
	JButton editQues;
	JButton addQues;
	JButton removeQues;
	JButton importQues;
    private DefaultTableModel tableModel;
	JComboBox<String> comboBox;
	Main main;
	private final Gson gson = new Gson();
	
	String[] columns = {"Mã chương trình", "Mô tả", "Tên CTDT", "Khoa quản lý", "Số tín tối thiểu", "Thời gian", "Website"};
	ThongTinChung[] thongTinChungs;
	
	String[] valueComboBox = {"Tất cả", "Câu hỏi", "Topic","Mức độ", "Trạng thái"};
	/**
	 * Create the panel.
	 */
	public ThongTinChungGUI(Main main) {
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
	        
	        api.fetchData("http://localhost:8080/api/thongtinchung/", new CallAPI.Callback() {
	            @Override
	            public void onSuccess(String data) {
	            	thongTinChungs = gson.fromJson(data, ThongTinChung[].class);
	                for (ThongTinChung gv : thongTinChungs) {
	                tableModel.addRow(new Object[]{
	                        gv.getMaCTDT(),
	                        gv.getMoTa(),
	                        gv.getTenCTDT(),
	                        gv.getKhoaQuanLy(),
	                        gv.getSoTinChiToiThieu(),
	                        gv.getThoiGian(),
	                        gv.getWebsite()
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
		    table.getColumnModel().getColumn(0).setPreferredWidth(20);  
		    table.getColumnModel().getColumn(1).setPreferredWidth(210); 
		    table.getColumnModel().getColumn(2).setPreferredWidth(150); 
		    table.getColumnModel().getColumn(3).setPreferredWidth(100); 
		    table.getColumnModel().getColumn(4).setPreferredWidth(80);  
		    table.getColumnModel().getColumn(5).setPreferredWidth(80);  
		}
	 
//	 private void addRowToTable(Question_DTO question) {
//		    tableModel.addRow(new Object[]{
//		        question.getqID(), 
//		        question.getqContent(), 
//		        question.getqPicture(), 
//		        question.getqTopicID(), 
//		        question.getqLevel(), 
//		        question.getqStatus()
//		    });
//		}

	private void initComponents() {
		// TODO Auto-generated method stub
		setSize(938,563);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 21, 226, 36);
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
		panel_1.setBounds(493, 21, 435, 36);
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Xem chi tiết");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = getSelectedRow();
				System.out.println(index);
				if( index != -1) {
					
					ChiTietThongTinChungDialog chiTietThongTinChungDialog = new ChiTietThongTinChungDialog(main,thongTinChungs[index] );
					chiTietThongTinChungDialog.setVisible(true);
				}
			}
		});
		panel_1.add(btnNewButton);
		
		addQues = new JButton("Thêm mới");
		addQues.setBackground(Color.WHITE);
		panel_1.add(addQues);
		
		editQues = new JButton("Sửa");
		editQues.setBackground(Color.WHITE);
		panel_1.add(editQues);
		
		removeQues = new JButton("Xóa");
		removeQues.setBackground(Color.WHITE);
		panel_1.add(removeQues);
		
		importQues = new JButton("Import");
		importQues.setBackground(Color.WHITE);
		panel_1.add(importQues);
		
		
		
		JPanel panelTable = new JPanel();
		panelTable.setBackground(new Color(255, 255, 255));
		panelTable.setBounds(10, 67, 918, 470);
		add(panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));
		tableModel = new DefaultTableModel(columns, 0);
	    table = new JTable(tableModel);
		
		JScrollPane sp = new JScrollPane(table);
		panelTable.add(sp, BorderLayout.CENTER);
		
		comboBox = new JComboBox<>(valueComboBox);
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 12));
		comboBox.setBounds(233, 21, 75, 36);
		add(comboBox);
		editQues.addActionListener(this);
		addQues.addActionListener(this);
		removeQues.addActionListener(this);
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
        if(e.getSource() == addQues) {
//            AddEitQuestionDialog addSpDialog = new AddEitQuestionDialog(main, true, "Thêm câu hỏi", this, "add", null);
//            addSpDialog.setVisible(true);
//            allQuestion = q_BLL.getAllQuestion();
//            q_BLL = new Question_BLL();
//            loadDataToTable(allQuestion);
        }
        
        if(e.getSource() == removeQues) {
//            int index = getSelectedRow();
//            if (index != -1) {
//                if (JOptionPane.showConfirmDialog(main, "Bạn có chắc muốn xóa câu hỏi này không?", "", JOptionPane.YES_NO_OPTION) == 0) {
//                    q_BLL.delete(allQuestion.get(index));
//                }
//                loadDataToTable(allQuestion);
//            }
            
        }
        
        if(e.getSource() == editQues) {
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
}
