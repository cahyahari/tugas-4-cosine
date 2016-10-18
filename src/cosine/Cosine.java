/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosine;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;


/**
 *
 * @author Cahya HS
 */public class Cosine {

   public static Vector <String> kata1 = new Vector();
   public static Vector <String> kata2 = new Vector();
   public static Vector <String> teks1 = new Vector();
   public static Vector <String> teks2 = new Vector();
   public static Vector <Integer> jmlteks1 = new Vector();
   public static Vector <Integer> jmlteks2 = new Vector();
   
    public static boolean cekKata(int n, String x) {
        // inisialisasi
        boolean find = false;

        for (int i = 0; i < n; i++) {
            // jika ada yg sama
            if (kata1.get(i).equalsIgnoreCase(x)) {
                find = true;
                break;
            }
        }
        return find ;
    }
    public static void tes(String teks) {
        StringTokenizer sa = new StringTokenizer(teks, " ");
        while(sa.hasMoreElements()){
            //dri potongan tdi dmasukin vec1 buat total kta dmasukin kta1 smua kata gabungan dr kal1 kal2
            kata1.add(sa.nextToken());
        }
        String temp = "";
        boolean ketemu = false;
        int a, k, n, m, count = 0, jum;
        n = count + 1;// banyaknya kata dlm suatu kalimat
        k = 0;
        a = 0;
        for (int i = 0; i < kata1.size(); i++) {
            if (!cekKata(a, kata1.get(i))) {
                //bentuk kata baru dlm array
                //klo ada kta sama g dmasukkin kata2
                kata2.add( kata1.get(i)) ;
                k++;
            }
            a++;
        }

        //  System.out.println(jumlahtotalkata);
//        System.out.println("hasil :" + jumlahkataterpilih / jumlahtotalkata);
    }

    public static void main(String args[]) {
        System.out.println("masukkan kalimat ke 1");
         Scanner a = new Scanner(System.in);
        String teks = a.nextLine();
       // String teks = "saya saya sedang kuliah ";
        //class stringtkn buat motong + spasi,ktm spasi dpotong
        StringTokenizer sa = new StringTokenizer(teks, " ");
        while(sa.hasMoreElements()){
            //ktm spasi di loop lg
            teks1.add(sa.nextToken());
        }
        System.out.println("  "); 
        System.out.println("masukkan kalimat ke 2");
//        String teks22 = "saya tidak akan pergi kuliah";
          String teks22 = a.nextLine();
        StringTokenizer d = new StringTokenizer(teks22, " ");
        while(d.hasMoreElements()){
            teks2.add(d.nextToken());
        }
        // isi kata2 = saya sedang kuliah tidak akan pergi
        String teks3 = teks + " " + teks22;
        tes(teks3);
        int batas = 0;
        //
        for (int i = 0; i < kata2.size(); i++) {
            int jml = 0;
            for (int j = 0; j < teks1.size(); j++) {
                if (teks1.get(j).equalsIgnoreCase(kata2.get(i))) {
                    jml +=1;
                }
            }
            batas += 1;
            jmlteks1.add(jml); //hasil pencocokan kata2 dengan vector teks1 disimpan di jmlteks1
        }
        for (int i = 0; i < kata2.size(); i++) {
            int jml = 0;
            for (int j = 0; j < teks2.size(); j++) {
                if (teks2.get(j).equalsIgnoreCase(kata2.get(i))) {
                    jml +=1;
                }
            }
//            batas += 1;
            jmlteks2.add(jml);
        }
        System.out.println("    ");
        for (int i = 0; i < kata2.size(); i++) {
            System.out.print(kata2.get(i)+" ");
        }
        System.out.println("");
        for (int i = 0; i < jmlteks1.size(); i++) {
            System.out.print(jmlteks1.get(i)+" ");
        }
        System.out.println("");
        
        for (int i = 0; i < jmlteks2.size(); i++) {
            System.out.print(jmlteks2.get(i)+" ");
        }
        //cari pembialng
        
        System.out.println("");
        double jumlah = 0;
        for (int i = 0; i < jmlteks1.size(); i++) {
            //indeks / banyaknya atas bawah sama, dikali disimpan di doubl kali
            double kali = jmlteks1.get(i)*jmlteks2.get(i);
            jumlah = jumlah + kali ;
            //kali=0 supaya pas di loop balik jd nol lg
            kali = 0;
        }
        System.out.println("===============================");
        System.out.println("Pembilangnya adalah = "+jumlah);
        
        //cri pnyebut
        double jumlah_satu = 0;
        for (int i = 0; i < jmlteks1.size(); i++) {
            double simpan = jmlteks1.get(i) * jmlteks1.get(i); //untk kuadrat
            jumlah_satu = jumlah_satu + simpan ;//dijumlahkan dg sampingnya
            simpan = 0;
        }
        double jumlah_dua = 0;
        for (int i = 0; i < jmlteks2.size(); i++) {
            double simpan = jmlteks2.get(i) * jmlteks2.get(i);
            jumlah_dua = jumlah_dua + simpan;
        }
        double total = jumlah_dua* jumlah_satu;
        
        double penyebut = Math.sqrt(total);//AKAR
        System.out.println("penyebutnya adalah = "+penyebut);
        System.out.println("========================");
        System.out.println("Hasil = "+ jumlah/penyebut);
    }
}
