/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author PC
 */
public class Sinhvien {
    private double diemonl;
    private String tensv,masv,tinhtrang;
    public Sinhvien() {
    }

    public Sinhvien(double diemonl, String tensv, String masv,String tinhtrang) {
        this.diemonl = diemonl;
        this.tensv = tensv;
        this.masv = masv;
        this.tinhtrang=tinhtrang;
    }

    
    public void setDiemonl(double diemonl) {
        this.diemonl = diemonl;
    }

    public double getDiemonl() {
        return diemonl;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public String getMasv() {
        return masv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }
    
    
}
