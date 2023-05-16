package com.ppl.p3;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fWarteg {
    private JCheckBox sotoBanjarCheck;
    private JTextField sotoBanjarCount;
    private JCheckBox sateMaduraCheckBox;
    private JCheckBox esJerukCheckBox;
    private JCheckBox esTehCheckBox;
    private JTextField sateMaduraCount;
    private JTextField esJerukCount;
    private JTextField esTehCount;
    private JTextField total;
    private JRadioButton bniRadio;
    private JRadioButton muamalatRadio;
    private JRadioButton cashRadio;
    private JButton hitungButton;
    private JButton kosongkanButton;
    private JPanel panel;
    private JLabel caraBayar;

    public fWarteg() {
        sotoBanjarCheck.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sotoBanjarCount.setText((sotoBanjarCheck.isSelected()) ? "1" : "0");
                sotoBanjarCount.setEditable(sotoBanjarCheck.isSelected());
            }
        });
        sateMaduraCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sateMaduraCount.setText((sateMaduraCheckBox.isSelected()) ? "1" : "0");
                sateMaduraCount.setEditable(sateMaduraCheckBox.isSelected());
            }
        });
        esJerukCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                esJerukCount.setText((esJerukCheckBox.isSelected()) ? "1" : "0");
                esJerukCount.setEditable(esJerukCheckBox.isSelected());
            }
        });
        esTehCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                esTehCount.setText((esTehCheckBox.isSelected()) ? "1" : "0");
                esTehCount.setEditable(esTehCheckBox.isSelected());
            }
        });
        hitungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int Total = 0;
                Total += (sotoBanjarCheck.isSelected()) ? (8000 * Integer.parseInt(sotoBanjarCount.getText())) : 0;
                Total += (sateMaduraCheckBox.isSelected()) ? (10000 * Integer.parseInt(sateMaduraCount.getText())) : 0;
                Total += (esJerukCheckBox.isSelected()) ? (4000 * Integer.parseInt(esJerukCount.getText())) : 0;
                Total += (esTehCheckBox.isSelected()) ? (3500 * Integer.parseInt(esTehCount.getText())) : 0;
                total.setText("" + Total);

                if(muamalatRadio.isSelected()) caraBayar.setText(muamalatRadio.getActionCommand());
                if(bniRadio.isSelected()) caraBayar.setText(bniRadio.getActionCommand());
                if(cashRadio.isSelected()) caraBayar.setText(cashRadio.getActionCommand());
            }
        });
        kosongkanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sotoBanjarCheck.setSelected(false);
                sateMaduraCheckBox.setSelected(false);
                esJerukCheckBox.setSelected(false);
                esTehCheckBox.setSelected(false);
                total.setText("");
            }
        });
    }

    public static void main(String[]args){
        JFrame frame = new JFrame("Warteg");
        frame.setContentPane(new fWarteg().panel);
        frame.pack();
        frame.setVisible(true);
    }
}
