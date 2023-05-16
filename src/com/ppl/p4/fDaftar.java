package com.ppl.p4;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class fDaftar{
    private JList listKuliah;
    private JList listPilih;
    private JButton copyButton;
    private JButton removeButton;
    private JTextField kuliahTerpilih;
    private JTextField banyakKuliahTerpilih;
    private JComboBox pilihAngkatan;
    private JButton hitungBiayaButton;
    private JTextArea textResume;
    private JPanel Pane;

    public fDaftar() {
        DefaultListModel terpilih = new DefaultListModel<>();

        listKuliah.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = listKuliah.getSelectedIndex();
                String kuliah = listKuliah.getSelectedValue().toString();
                kuliahTerpilih.setText(kuliah);
            }
        });

        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                terpilih.addElement(listKuliah.getSelectedValue());
                listPilih.setModel(terpilih);
                banyakKuliahTerpilih.setText(Integer.toString(terpilih.getSize()));
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                terpilih.removeElement(listPilih.getSelectedValue());
                listPilih.setModel(terpilih);
                banyakKuliahTerpilih.setText(Integer.toString(terpilih.getSize()));
            }
        });

        hitungBiayaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int jumlahTerpilih = terpilih.getSize();
                int nilaiKuliah = 0;
                switch (pilihAngkatan.getSelectedIndex()) {
                    case 0: nilaiKuliah = 1000000;
                    break;
                    case 1: nilaiKuliah = 900000;
                    break;
                    case 2: nilaiKuliah = 800000;
                    break;
                    default: nilaiKuliah = 500000;
                }
                int totalBiaya = jumlahTerpilih * nilaiKuliah;
                String resume = "Anda angkatan : " + pilihAngkatan.getSelectedItem().toString() +
                        "\n Banyak mata kuliah terpilih : " + jumlahTerpilih +
                        "\n Biaya per mata kuliah : " + nilaiKuliah +
                        "\n Total biaya : " + totalBiaya;
                textResume.setText(resume);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("fDaftar");
        frame.setContentPane(new fDaftar().Pane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }



}
