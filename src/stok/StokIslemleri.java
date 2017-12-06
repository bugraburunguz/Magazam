package stok;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StokIslemleri extends Calisan {

    private ArrayList<Calisan> calisanListesi;

    public StokIslemleri() {


        calisanListesi = new ArrayList<>();

        JFrame frames = new JFrame("-- MAĞAZAM YÖNETİM SİSTEMİ --");

        JTextField calisanAdi, calisanCinsiyet, calisanNo, calisanTipi;
        JButton ekleButton;
        JLabel baslik, l1, l2, l3, l4;
        baslik = new JLabel("Stok Ekleyin");
        baslik.setBounds(500, 15, 250, 35);
        frames.add(baslik);


        l1 = new JLabel("Çalışan Adı");
        l1.setBounds(500, 35, 250, 35);

        calisanAdi = new JTextField("");
        calisanAdi.setBounds(500, 65, 250, 35);
        frames.add(calisanAdi);

        l2 = new JLabel("Çalışan Numarasını Girin");
        l2.setBounds(500, 87, 250, 35);

        calisanCinsiyet = new JTextField("");
        calisanCinsiyet.setBounds(500, 117, 250, 35);
        frames.add(calisanCinsiyet);

        l3 = new JLabel("Çalışan No");
        l3.setBounds(500, 140, 250, 35);

        calisanNo = new JTextField("");
        calisanNo.setBounds(500, 167, 250, 35);
        frames.add(calisanNo);


        l4 = new JLabel("Çalışan Tipi");
        l4.setBounds(500, 140, 250, 35);

        calisanTipi = new JTextField("");
        calisanTipi.setBounds(500, 167, 250, 35);
        frames.add(calisanTipi);

        frames.add(l1);
        frames.add(l2);
        frames.add(l3);
        frames.add(l4);

        ekleButton = new JButton("Çalışanı Ekle");
        ekleButton.setBounds(500, 270, 250, 35);
        frames.add(ekleButton);
        ekleButton.addActionListener(e -> {

            try {
                FileWriter fw = new FileWriter("calisanlar.txt", true);
                PrintWriter pw = new PrintWriter(fw);

                String isim = calisanAdi.getText();
                String cinsiyet = calisanCinsiyet.getText();
                int numara = Integer.parseInt(calisanNo.getText());
                String calisan_tipi = calisanTipi.getText();

                Calisan calisan = new Calisan();
                calisan.setAdi(isim);
                calisan.setCinsiyet(cinsiyet);
                calisan.setCalisanNo(numara);
                calisan.setCalisanTipi(calisan_tipi);


                calisanListesi.add(calisan);
                pw.println(calisanListesi);

                JOptionPane.showMessageDialog(null, "Öğrenci Listeye Kayıt Edildi...");

                pw.close();


            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        frames.setSize(1200, 800);
        frames.setLayout(null);
        frames.setVisible(true);

    }

}
