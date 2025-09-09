package com.kh.jdbc.apple.view;

import javax.swing.*;
import java.awt.*;

public class AppleButton extends JPanel {
    private static final int ROW = 17;
    private static final int COL = 10;

    private JButton[][] buttons = new JButton[ROW][COL];
    
    private ImageIcon icon;

    public AppleButton() {
        setLayout(new GridLayout(ROW, COL, 2, 2));
        addAppleButton();
    }

    private void addAppleButton() {
        for(int row = 0; row < ROW; row++) {
            for(int col = 0; col < COL; col++) {
                JButton btn = new JButton();
                btn.setPreferredSize(new Dimension(60, 30));
               
                icon = new ImageIcon("resources/Apple.png");
                Image img = icon.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);
                btn.setIcon(new ImageIcon(img));
                
                btn.setHorizontalTextPosition(SwingConstants.CENTER); // 수평 가운데
                btn.setVerticalTextPosition(SwingConstants.CENTER);   // 수직 가운데
                btn.setForeground(Color.WHITE); // 숫자를 흰색으로
                btn.setFont(new Font("Arial", Font.BOLD, 14));
                
                buttons[row][col] = btn;
                add(btn);					// add Swing 함수 창에 버튼 추가
            }
        }
    }

    public JButton[][] getButtons() {
        return buttons;
    }
}

