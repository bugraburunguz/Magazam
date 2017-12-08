package personal;

import mainapp.MainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CalisanIslemleri extends Calisan implements ActionListener {
    JFrame frames;
    JTextField calisanAdi, calisanCinsiyet, calisanNo, calisanTipi, calisaniSil;
    JRadioButton rb3;
    JButton ekleButton, silButton, listeleButton, geriButton;
    JLabel ekleBaslik, calisanAdiBasligi, calisanNoBasligi, calisanCinsiyetBasligi, calisanTipiBasligi, silBaslik, calisanSilBasligi;
    private ArrayList<Calisan> calisanListesi;

    public CalisanIslemleri() {


        calisanListesi = new ArrayList<>();

        frames = new JFrame("-- MAĞAZAM YÖNETİM SİSTEMİ --");


        ekleBaslik = new JLabel("Çalışan Ekleyin");
        ekleBaslik.setBounds(50, 15, 250, 35);
        frames.add(ekleBaslik);


        calisanAdiBasligi = new JLabel("Çalışan Adı");
        calisanAdiBasligi.setBounds(50, 35, 250, 35);

        calisanAdi = new JTextField("");
        calisanAdi.setBounds(50, 60, 250, 35);
        frames.add(calisanAdi);

        calisanCinsiyetBasligi = new JLabel("Çalışan Cinsiyetini Girin");
        calisanCinsiyetBasligi.setBounds(50, 95, 250, 35);

        calisanCinsiyet = new JTextField("");
        calisanCinsiyet.setBounds(50, 120, 250, 35);
        frames.add(calisanCinsiyet);

        calisanNoBasligi = new JLabel("Çalışan No");
        calisanNoBasligi.setBounds(50, 155, 250, 35);

        calisanNo = new JTextField("");
        calisanNo.setBounds(50, 185, 250, 35);
        frames.add(calisanNo);


        calisanTipiBasligi = new JLabel("Çalışan Tipi");
        calisanTipiBasligi.setBounds(50, 225, 250, 35);

        calisanTipi = new JTextField("");
        calisanTipi.setBounds(50, 255, 250, 35);
        frames.add(calisanTipi);
        ///////////////////////////////////////////////////////
        silBaslik = new JLabel("Çalışan Silin");
        silBaslik.setBounds(400, 15, 250, 35);
        frames.add(silBaslik);

        calisanSilBasligi = new JLabel("Çalışan Numarasıyla Silin");
        calisanSilBasligi.setBounds(400, 95, 250, 35);

        calisaniSil = new JTextField("");
        calisaniSil.setBounds(400, 120, 250, 35);
        frames.add(calisaniSil);
        ////////////////////////////////////////////////////

        rb3 = new JRadioButton(" Listele");
        rb3.setBounds(750, 190, 300, 30);
        frames.add(rb3);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb3);

        listeleButton = new JButton("Uygula");
        listeleButton.setBounds(750, 295, 250, 35);
        frames.add(listeleButton);

        listeleButton.addActionListener((ActionEvent e) -> {

            if (bg.isSelected(null)) {
                JOptionPane.showMessageDialog(null, "Lütfen Seçim Yapınız");

            } else if (rb3.isSelected()) {
                new CalisanListeleme();
            }
        });


        frames.add(calisanAdiBasligi);
        frames.add(calisanCinsiyetBasligi);
        frames.add(calisanNoBasligi);
        frames.add(calisanTipiBasligi);
        frames.add(calisanSilBasligi);

        geriButton = new JButton("<--");
        geriButton.setBounds(50, 500, 250, 35);
        frames.add(geriButton);
        geriButton.addActionListener(this);

        silButton = new JButton("Çalışanı Sil");
        silButton.setBounds(400, 295, 250, 35);
        frames.add(silButton);
        silButton.addActionListener(this);

        ekleButton = new JButton("Çalışanı Ekle");
        ekleButton.setBounds(50, 295, 250, 35);
        frames.add(ekleButton);
        ekleButton.addActionListener(this);


        frames.setSize(1024, 768);
        frames.setLayout(null);
        frames.setVisible(true);


    }

    private void silButtonEvent() {
        try {

            FileWriter fw = new FileWriter("calisanlar.txt", false);
            PrintWriter pw = new PrintWriter(fw);

            calisanListesi.removeIf(user -> String.valueOf(user.getCalisanNo()).equalsIgnoreCase(calisaniSil.getText()));

            pw.println(calisanListesi);

            JOptionPane.showMessageDialog(null, "Çalışan Silindi");

            pw.close();


        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void geriButtonEvent() {

        MainMenu.createFrame();
        frames.setVisible(false);
    }

    private void ekleButtonEvent() {

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

            JOptionPane.showMessageDialog(null, "Çalışan Listeye Kayıt Edildi...");

            pw.close();


        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ekleButton) {
            ekleButtonEvent();
        } else if (e.getSource() == silButton) {
            silButtonEvent();
        } else if (e.getSource() == geriButton) {
            geriButtonEvent();
        }

    }
}