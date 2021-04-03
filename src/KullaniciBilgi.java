/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mert
 */
public class KullaniciBilgi {
    
    
    private int kullanici_no;
    private String kullanici_ad;
    private int kullanici_puan;

    public int getKullanici_no() {
        return kullanici_no;
    }

    public void setKullanici_no(int kullanici_no) {
        this.kullanici_no = kullanici_no;
    }

    public String getKullanici_ad() {
        return kullanici_ad;
    }

    public void setKullanici_ad(String kullanici_ad) {
        this.kullanici_ad = kullanici_ad;
    }

    public int getKullanici_puan() {
        return kullanici_puan;
    }

    public void setKullanici_puan(int kullanici_puan) {
        this.kullanici_puan = kullanici_puan;
    }

    public KullaniciBilgi(int kullanici_no, String kullanici_ad, int kullanici_puan) {
        this.kullanici_no = kullanici_no;
        this.kullanici_ad = kullanici_ad;
        this.kullanici_puan = kullanici_puan;
    }
    
    
}
