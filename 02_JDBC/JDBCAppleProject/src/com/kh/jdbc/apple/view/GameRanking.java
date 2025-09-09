package com.kh.jdbc.apple.view;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.kh.jdbc.apple.model.vo.Member;

public class GameRanking extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public GameRanking(List<Member> rankingList) {
        setTitle("랭킹");
        setSize(400, 300);
        setLocationRelativeTo(null);

        String[] columnNames = {"순위", "이름", "점수", "등록일"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        int rank = 1;
        for (Member m : rankingList) {
            model.addRow(new Object[]{
                rank++,
                m.getUserName(),
                m.getScore(),
                m.getEnrollDate() != null ? m.getEnrollDate().format(format) : ""
            });
        }

        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton closeBtn = new JButton("닫기");
        closeBtn.addActionListener(e -> dispose());
        add(closeBtn, BorderLayout.SOUTH);

        setVisible(true);
    }
}