/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaxxi.cinemaxxi_layout.services;

import com.cinemaxxi.cinemaxxi_layout.domain.Tiket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Yusup
 */
public class TiketService {
    
    public void select_menu(List<Tiket> listKursi){
        Scanner pilihMenu = new Scanner(System.in);
        String menu;
        System.out.println("");
        System.out.println("========== Pilih Salah Satu Menu Dibawah Ini ==========");
        System.out.println("A) Pemesanan Kursi");
        System.out.println("B) Batalkan Kursi");
        System.out.println("C) Laporan Denah");
        System.out.println("D) Laporan Transaksi");
        System.out.println("Masukkan 'Exit' untuk keluar");
        System.out.print("Masukkan Menu (A/B/C/D/Exit) : ");
        menu = pilihMenu.nextLine();
        
        if(menu.equalsIgnoreCase("A")){
            confirm_menu(book_seat(listKursi));
        } else if(menu.equalsIgnoreCase("B")){
            confirm_menu(cancel_seat(listKursi));
        } else if(menu.equalsIgnoreCase("C")){
            seats_status(listKursi);
        } else if(menu.equalsIgnoreCase("D")){
            transaction_status(listKursi);
        } else if(menu.equalsIgnoreCase("Exit")){
            System.exit(0);
        } else {
            System.out.println("Menu Yang Dimasukkan Tidak Ada");
            confirm_menu(listKursi);
        }
    }
    
    private List<Tiket> book_seat(List<Tiket> listKursi){
        DateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss");
        Scanner pesanKursi = new Scanner(System.in);
        String kursi;
        boolean statusKursi = false;
        System.out.println("========== Menu Pesan Kursi ==========");
        System.out.print("Pesan Kursi : ");
        kursi = pesanKursi.nextLine();
        
        for (Tiket tiket : listKursi) {
            if(kursi.equalsIgnoreCase(tiket.getLabel())){
                if(tiket.getStatus().equalsIgnoreCase("Free")){
                    tiket.setStatus("Sold");
                    tiket.setTglPesan(dateFormat.format(new Date()));
                    System.out.println("Berhasil Melakukan Pemesanan Kursi");
                } else {
                    System.out.println("Kursi Sudah Pernah Dipesan");
                }
                statusKursi = true;
            }
        }
        
        if(!statusKursi){
            System.out.println("Kursi Tidak Ditemukan");
        }
        return listKursi;
    }
    
    private List<Tiket> cancel_seat(List<Tiket> listKursi) {
        Scanner pesanKursi = new Scanner(System.in);
        String kursi;
        boolean statusKursi = false;
        System.out.println("========== Menu Batalkan Kursi ==========");
        System.out.print("Batalkan Pesanan Untuk Kursi : ");
        kursi = pesanKursi.nextLine();
        
        for (Tiket tiket : listKursi) {
            if(kursi.equalsIgnoreCase(tiket.getLabel())){
                if(tiket.getStatus().equalsIgnoreCase("Sold")){
                    tiket.setStatus("Free");
                    tiket.setTglPesan("");
                    System.out.println("Berhasil Membatalkan Pesanan");
                } else {
                    System.out.println("Kursi Belum Ada Yang Memesan");
                }
                statusKursi = true;
            }
        }
        if(!statusKursi){
            System.out.println("Kursi Tidak Ditemukan");
        }
        return listKursi;
    }
    
    private void seats_status(List<Tiket> listKursi){
        System.out.println("========== Menu Laporan Denah ==========");
        for (Tiket tiket : listKursi) {
            System.out.println(tiket.getLabel()+" - "+tiket.getStatus());
        }
        confirm_menu(listKursi);
    }
    
    private void transaction_status(List<Tiket> listKursi){
        int jmlSold = 0;
        int jmlFree = 0;
        
        System.out.println("========== Menu Laporan Transaksi ==========");
        for (Tiket tiket : listKursi) {
            if(tiket.getStatus().equalsIgnoreCase("Sold")){
                jmlSold = jmlSold + 1;
            } else {
                jmlFree = jmlFree + 1;
            }
        }
        
        System.out.println("Total "+jmlFree+" Free, "+jmlSold+" Sold");
        
        for (Tiket tiket : listKursi) {
            if(tiket.getStatus().equalsIgnoreCase("Sold"))
                System.out.println(tiket.getLabel()+", "+tiket.getTglPesan());
        }
        confirm_menu(listKursi);
    }
    
    private void confirm_menu(List<Tiket> listKursi){
        Scanner textConfirm = new Scanner(System.in);
        char confirm;
        
        System.out.print("Apakah ingin kembali ke menu? (Y/N) : ");
        confirm = textConfirm.next().charAt(0);
        if(confirm == 'Y' || confirm == 'y') {
            select_menu(listKursi);
        } else if (confirm == 'N' || confirm == 'n'){
            System.exit(0);
        } else {
            confirm_menu(listKursi);
        }
    }
}
