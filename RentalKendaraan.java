package com.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentalKendaraan extends javax.swing.JFrame {
    private JPanel base, paneljenis, panelid, panelnama, panelmerek, panelharga;
    private JLabel judul, jenis, id, nama, merek, harga;
    private JComboBox comboBoxJenis, comboBoxID;
    private JTextField textFieldNama, textFieldMerek, textFieldHarga;
    private JButton submitButton, clearButton;
    private JTextArea Arealog;

    public RentalKendaraan() {
        // implementasi modul 4 Function and Method
        Disable();

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a;
                //implementasi modul 2 Pengkondisian
                if (comboBoxJenis.getSelectedItem() == "" || comboBoxID.getSelectedItem() == ""){
                    a = 0;
                } else{
                    a = 1;
                }
                if (a==1) {
                    if (comboBoxJenis.getSelectedItem() == "Motor") {
                        Arealog.setText("Motor : " + textFieldNama.getText() +
                                "\nMerek : " + textFieldMerek.getText() +
                                "\nHarga : " + textFieldHarga.getText() +
                                "\nAplikasi telah disubmit!");
                    } else if (comboBoxJenis.getSelectedItem() == "Mobil") {
                        Arealog.setText("Mobil : " + textFieldNama.getText() +
                                "\nMerek : " + textFieldMerek.getText() +
                                "\nHarga : " + textFieldHarga.getText() +
                                "\nAplikasi telah disubmit!");
                    }
                } else {
                    Arealog.setText("Pilih Jenis dan ID kendaraan terlebih dahulu!");
                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Arealog.setText("Clear!");
                comboBoxJenis.setSelectedIndex(0);
                comboBoxID.setSelectedIndex(0);
                textFieldNama.setText("");
                textFieldHarga.setText("");
                textFieldMerek.setText("");
                Disable();
            }
        });
        comboBoxID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data();
            }
        });
        comboBoxJenis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data();
            }
        });
    }
    public void data(){
        if (comboBoxID.getSelectedItem() == "01" & comboBoxJenis.getSelectedItem()=="Mobil") {
            datamobil(0);
        } else if (comboBoxID.getSelectedItem() == "02" & comboBoxJenis.getSelectedItem() == "Mobil"){
            datamobil(1);
        } else if (comboBoxID.getSelectedItem() == "03" & comboBoxJenis.getSelectedItem() == "Mobil"){
            datamobil(2);
        } else if (comboBoxID.getSelectedItem() == "01" & comboBoxJenis.getSelectedItem() == "Motor"){
            datamotor(0);
        } else if (comboBoxID.getSelectedItem() == "02" & comboBoxJenis.getSelectedItem() == "Motor"){
            datamotor(1);
        } else if (comboBoxID.getSelectedItem() == "03" & comboBoxJenis.getSelectedItem() == "Motor"){
            datamotor(2);
        }
    }

    public void Enable(){
        textFieldNama.enable();
        textFieldMerek.enable();
        textFieldHarga.enable();
    }

    public void Disable(){
        textFieldNama.disable();
        textFieldMerek.disable();
        textFieldHarga.disable();
    }
    public void datamobil(int no){
        //implementasi modul 1 Variabel, Tipe Data, dan Array
        String [] namamobil = {"RX7 FD3S", "GTR R34", "AE86"};
        String [] merekmobil = {"Mazda", "Nissan", "Toyota"};
        String [] hargamobil  = {"2.000.000", "1.500.000", "800.000"};
        //Implementasi modul 6 OOP II Setter Getter
        textFieldNama.setText(namamobil[no]);
        textFieldMerek.setText(merekmobil[no]);
        textFieldHarga.setText("Rp. " + hargamobil[no] + "/bulan");
        Enable();
    }
    public void datamotor(int on){
        String [] namamotor = {"Beat POP", "Nmax", "Vortex 250"};
        String [] merekmotor = {"Honda", "Yamaha", "Viar"};
        String [] hargamotor = {"400.000", "500.000", "800.000"};
        textFieldNama.setText(namamotor[on]);
        textFieldMerek.setText(merekmotor[on]);
        textFieldHarga.setText("Rp. " + hargamotor[on] + "/bulan");
        Enable();
    }
    public static void main(String[] args) {
        //implementasi modul 5 OOP I constructor
        JFrame frame = new JFrame("Aplikasi Rental Kendaraan");
        frame.setContentPane(new RentalKendaraan().base);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 300);
        frame.setResizable(true);
    }
}