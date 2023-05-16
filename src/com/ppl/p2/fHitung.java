package com.ppl.p2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fHitung {
    private JPanel panel;
    private JTextField namaField;
    private JButton hitungButton;
    private JButton keluarButton;
    private JTextField hargaField;
    private JTextField qtyField;
    private JTextField totalField;

    public fHitung() {
        hitungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total = Integer.parseInt(hargaField.getText()) * Integer.parseInt(qtyField.getText());
                totalField.setText(String.valueOf(total));
            }
        });
        keluarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Termia kasih sudah membeli "+ namaField.getText());
                System.exit(0);
            }
        });
    }

    public static void main(String[]args){
        JFrame frame = new JFrame();
        frame.setContentPane(new fHitung().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
