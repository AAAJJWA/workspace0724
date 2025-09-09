package com.kh.jdbc.apple.controller;

import java.awt.*;

import javax.swing.JComponent;

public class DrawSquare extends JComponent{

	private Rectangle rect;

    public void setRectangle(Rectangle rect) {
        this.rect = rect;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (rect != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.RED);
            g2.setStroke(new BasicStroke(3)); // 두께 3px
            g2.drawRect(rect.x, rect.y, rect.width, rect.height);           // 사각형 그리기
        }
    }
	
}
