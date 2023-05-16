package com.ppl.p5;

import com.ppl.p4.fDaftar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fDialog {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JButton OKButton;
    private JButton errorButton;
    private JButton keluarButton;
    private JButton yesNoKonfirmasiButton;
    private JButton yesNoCancelKonfirmasiButton;
    private JButton customYesNoCancelButton;
    private JButton pilihanListButton;
    private JButton pilihanIsianButton;

    public fDialog() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Mudahnya Belajar Java");
            }
        });
        errorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Belajar Java Harus Santai.", "Perngatan", JOptionPane.ERROR_MESSAGE);
            }
        });
        keluarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        yesNoKonfirmasiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int answer = JOptionPane.showConfirmDialog(null, "Belajar Java sangat mudah\nSetujukah Kamu ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if(answer == 0){
                    JOptionPane.showMessageDialog(null, "Kamu Memilih Yes");
                }else{
                    JOptionPane.showMessageDialog(null, "Kamu Memilih No");
                }
            }
        });
        yesNoCancelKonfirmasiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int answer = JOptionPane.showConfirmDialog(null ,
                        "Akan menghhapus data\nAnda Yakin?",
                        "Konfirmasi",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                switch(answer){
                    case 0 : JOptionPane.showMessageDialog(null, "Jawaban Yes");break;
                    case 1 : JOptionPane.showMessageDialog(null, "Jawaban No");break;
                    case 2 : JOptionPane.showMessageDialog(null, "Jawaban Cancel");break;
                    default: JOptionPane.showMessageDialog(null, "Mohon Dijawab");
                }
            }
        });
        customYesNoCancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"Ya", "Tidak", "Kirim"};
                int answer = JOptionPane.showOptionDialog(null,
                        "Anda mau munum jus + susu kental?",
                        "Pertanyaan",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[2]
                );
                String response;
                switch (answer){
                    case 0 : response = "Ini Jus + susu kental"; break;
                    case 1 : response = "Ini Jus Saja"; break;
                    case 2 : response = "Jus Siap Dikirim"; break;
                    default : response = "Mohon Dijawab";
                }
                JOptionPane.showMessageDialog(null, response);
            }
        });
        pilihanListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] answer = {"Bahasa Java", "Bahasa HTML"};
                String s = (String)JOptionPane.showInputDialog(null,
                        "Sebutkan jenis-jenis bahasa pemograman:\n" + "\"Bahasa C,...\"",
                        "Custom Dialog",
                        JOptionPane.PLAIN_MESSAGE,
                        null,answer, "Bahasa Java"
                );
                if ((s != null) && s.length() > 0){
                    JOptionPane.showMessageDialog(null, "Bahasa HTML," + s + "!");
                }
            }
        });
        pilihanIsianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String)JOptionPane.showInputDialog(null,
                        "Lengkapi jenis2 bahasa pemogrman berikut:\n" +
                                "\"Bahasa C, Java, HTML, ....\"",
                        "Custom Dialog",
                        JOptionPane.PLAIN_MESSAGE,
                        null, null, ""
                );
                if(s != null && s.length() > 0){
                    JOptionPane.showMessageDialog(null, "Bahasa C, Java, HTML, " + s + "!");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("fDialog");
        frame.setContentPane(new fDialog().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
