Cara running program melalui cmd:
1. download dan install jdk terlebih dahulu
2. Update PATH Environment Variable (start -> Edit the system environment variables -> Environtment Variables ->
   Pada System Variables, cari variable Path, kemudian klik Edit -> pilih new lalu input lokasi jdk bin seperti : C:\Program Files\Java\jdk1.8.0_102\bin -> OK -> Finish
2. buka cmd
3. pindah ke drive tempat disimpan folder project contoh D:
4. masuk ke folder cinemaxxi_layout (D:\>cd cinemaxxi_layout)
5. ketik dir lalu enter (D:\cinemaxxi_layout>dir)
6. kemudian ketik cd target/classes (cd target/classes)
7. lalu ketik perintah (D:\cinemaxxi_layout\target\classes>java com.cinemaxxi.cinemaxxi_layout.cinemaxxi)
8. program sudah berhasil running 

Cara menggunakan program
1. saat pertama kali program berjalan akan diminta untuk memasukan label kursi dan jumlah kursi
2. setelah itu akan muncul 4 menu, A untuk pesan kursi, B untuk batalkan kursi, C untuk laporan denah, D untuk laporan transaksi, dan exit jika ingin keluar dari program
3. akan diminta memasukan Huruf sesuai dengan menu yang di inginkan. contoh (Masukkan Menu (A/B/C/D/Exit) : A)
4. lalu akan masuk ke menu pesan tiket. lalu diminta memasukan label kursi yang ingin dipesan contoh (A1) 
   kemudian akan ada pengecekan kursi tersebut sudah ada yang memesan atau belum
5. begitu juga dengan menu yang lain
6. setiap selesai melakukan proses pada suatu menu akan ada pertanyaan konfirmasi untuk kembali ke menu awal atau tidak (Y/N)
   Jika pilih Y akan kembali ke menu awal, jikan pilih N akan keluar dari program