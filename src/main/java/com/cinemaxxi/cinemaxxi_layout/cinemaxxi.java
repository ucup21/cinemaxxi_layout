/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaxxi.cinemaxxi_layout;

import com.cinemaxxi.cinemaxxi_layout.domain.Tiket;
import com.cinemaxxi.cinemaxxi_layout.services.TiketService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Yusup
 */
public class cinemaxxi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inputKode = new Scanner(System.in);
        Scanner inputJmlKursi = new Scanner(System.in);
        char labelCode, kursi;
        int jmlKursi = 0;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        System.out.println("========== Selamat Datang (Cinema XXI), Silahkan Masukkan Konfigurasi Denah ==========");
        System.out.print("Masukkan Label Kursi : ");
        labelCode = inputKode.next().charAt(0);
        
        if(labelCode >= 'a' && labelCode <= 'z' || labelCode >= 'A' && labelCode <= 'Z'){
            System.out.print("Masukkan Jumlah Kursi : ");
            jmlKursi = inputJmlKursi.nextInt();
            if(jmlKursi > 20){
                System.out.println("Jumlah Kursi Tidak Boleh Lebih Dari 20");
                main(args);
            }
            List<Tiket> kursiBioskop = new ArrayList<>();
            for(int i=1; i<=jmlKursi; i++){
                Tiket tiket = new Tiket();
                tiket.setLabel(Character.toUpperCase(labelCode)+""+i);
                tiket.setStatus("Free");
                tiket.setTglPesan(dateFormat.format(new Date()));
                kursiBioskop.add(tiket);
            }

            TiketService service = new TiketService();
            service.select_menu(kursiBioskop);
        } else {
            System.out.println("Label Kursi Harus Huruf");
            main(args);
        }
    }
    
}
