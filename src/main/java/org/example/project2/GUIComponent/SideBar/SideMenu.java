package org.example.project2.GUIComponent.SideBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.example.project2.Main;

public class SideMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	Main main;
	SideMenuItem menuItems[];
	Color selectedItemBgColor = new Color(190, 215, 220);
	Color itemBgColor = new Color(255, 255, 255);
    Color itemFontColor = new Color(0, 0, 0);
    Color selectedItemFontColor = new Color(0, 0, 0);
    JPanel centerPanel = new JPanel();
	String[][] menu = {
	        {"Thông tin chung", "dashboard", "business.png"},
	        {"Giảng Viên", "lecturer", "business.png"}
	    };

	/**
	 * Create the panel.
	 */
	public SideMenu(Main main) {
		centerPanel.setLayout(new GridLayout(menu.length, 1));
		initComponents();
        this.main = main;
        menuItems = new SideMenuItem[menu.length];
        for(int i=0; i<menu.length; i++) {
            menuItems[i] = new SideMenuItem(main, menu[i][0], menu[i][1], menu[i][2]);
            menuItems[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent evt) {
                    selectingMenuItem(evt);
                }
            });
            centerPanel.add(menuItems[i]);
            if(i == 0) {
                centerPanel.add(menuItems[i]);
                continue;
            }
            if(i==4)
                continue;
            
        }
        menuItems[0].isSelected = true;
        menuItems[0].setBackground(selectedItemBgColor);
        menuItems[0].nameLabel.setForeground(selectedItemFontColor);
        centerPanel.setBackground(new Color(240, 240, 240));
        centerPanel.setBounds(10, 5, 180, 585);
        add(centerPanel, BorderLayout.CENTER);
	}

	protected void selectingMenuItem(MouseEvent evt) {
		// TODO Auto-generated method stub
		for (int i = 0; i < menu.length; i++) {
            if (evt.getSource() == menuItems[i]) {
                menuItems[i].isSelected = true;
                menuItems[i].setBackground(selectedItemBgColor);
                menuItems[i].nameLabel.setForeground(selectedItemFontColor);
            } else {
                menuItems[i].isSelected = false;
                menuItems[i].setBackground(itemBgColor);
                menuItems[i].nameLabel.setForeground(itemFontColor);
            }
        }
		
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(250, 700));
		setBackground(new Color(255, 255, 255));
	}

}
