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
    private String tensv,masv,tinhtrang,lop,monhoc;
    public Sinhvien() {
    }

    public Sinhvien(double diemonl, String tensv, String masv,String tinhtrang,String lop,String monhoc) {
        this.diemonl = diemonl;
        this.tensv = tensv;
        this.masv = masv;
        this.tinhtrang=tinhtrang;
        this.lop=lop;
        this.monhoc=monhoc;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getLop() {
        return lop;
    }

    public String getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(String monhoc) {
        this.monhoc = monhoc;
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
