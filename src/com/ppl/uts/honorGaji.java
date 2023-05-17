package com.ppl.uts;

import javax.swing.*;
import java.awt.event.*;

public class honorGaji {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel Perusahaan;
    private JTextField inputNamaKaryawan;
    private JTextField inputTempatLahir;
    private JTextField inputTanggalLahir;
    private JTextField inputAlamat;
    private JRadioButton kontrakRadioButton;
    private JRadioButton tetapRadioButton;
    private JRadioButton harianRadioButton;
    private JComboBox inputJabatan;
    private JTextField viewNamaKaryawan;
    private JTextField viewPosisiJabatan;
    private JTextField inputHariKerja;
    private JTextField viewUpahPerhari;
    private JTextField inputJumlahLembur;
    private JTextField viewUpahLembur;
    private JTextField inputHutang;
    private JTextField viewPPH;
    private JTextField rp100000TextField;
    private JTextField viewGajiKotor;
    private JTextField viewGajiBersih;
    private JButton keluarDanPrintButton;
    private JComboBox viewJabatan;
    private JLabel Logo;

    public double gaji, lembur, gajiKotor, gajiBersih, hariKerja, jamLembur, hutang, pph;
    public honorGaji() {
        gaji = 1000000;
        lembur = 100000;
        hariKerja = 1;
        jamLembur = 0;
        hutang = 0;

        calculate();

        inputNamaKaryawan.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String namaKaryawan = inputNamaKaryawan.getText();
                viewNamaKaryawan.setText(namaKaryawan);
            }
        });
        inputJabatan.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                viewJabatan.setSelectedItem(e.getItem());
                switch (e.getItem().toString()){
                    case "Direksi" : gaji = 1000000; lembur = 100000; break;
                    case "Marketing" : gaji = 300000; lembur = 65000; break;
                    case "Produksi" : gaji = 120000; lembur = 55000; break;
                    case "Teknisi" : gaji = 110000; lembur = 50000; break;
                    case "HRD" : gaji = 100000; lembur = 55000; break;
                    case "Purchasing" : gaji = 80000; lembur = 40000; break;
                    case "Umum" : gaji = 90000; lembur = 35000; break;
                    case "Pemeliharaan" : gaji = 85000; lembur = 40000; break;
                    default: gaji = 0;
                }
                calculate();
            }
        });

        inputHariKerja.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try{
                    hariKerja = Integer.parseInt(inputHariKerja.getText());
                    calculate();
                }catch (NumberFormatException err){
                    hariKerja = 0;
                    viewGajiBersih.setText("Jumlah Hari Kerja Tidak Valid");
                    viewGajiKotor.setText("Jumlah Hari Kerja Tidak Valid");
                }
            }
        });

        inputJumlahLembur.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try{
                    jamLembur = Integer.parseInt(inputJumlahLembur.getText());
                    calculate();
                }catch (NumberFormatException err){
                    jamLembur = 0;
                    viewGajiBersih.setText("Jumlah Jam Lembur Tidak Valid");
                    viewGajiKotor.setText("Jumlah Jam Lembur Tidak Valid");
                }
            }
        });
        inputHutang.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try{
                    hutang = Double.parseDouble(inputHutang.getText());
                    calculate();
                }catch (NumberFormatException err){
                    hutang = 0;
                    viewGajiBersih.setText("Jumlah Hutang Tidak Valid");
                    viewGajiKotor.setText("Jumlah Hutang Tidak Valid");
                }
            }
        });
    }

    private void calculate(){
        gajiKotor = (gaji * hariKerja) + (lembur * jamLembur);
        pph = gajiKotor * 0.04;
        gajiBersih = gajiKotor - hutang - pph - 100000;

        viewPPH.setText("Rp. " + pph);
        viewUpahLembur.setText("Rp. "+ lembur);
        viewUpahPerhari.setText("Rp. " + gaji);
        viewGajiKotor.setText("Rp. " + gajiKotor);
        viewGajiBersih.setText("Rp. " + gajiBersih);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("honorGaji");
        frame.setContentPane(new honorGaji().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
