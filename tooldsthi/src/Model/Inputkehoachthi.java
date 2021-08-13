/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Inputkehoachthi {
    private int id,cathi;
    private String mamon,phongthi,lop,loaithi,block;
    private Date ngaythi;

    public Inputkehoachthi() {
    }

    public Inputkehoachthi(int id, int cathi, String mamon, String phongthi, String lop, Date ngaythi,String loaithi,String block) {
        this.id = id;
        this.cathi = cathi;
        this.mamon = mamon;
        this.phongthi = phongthi;
        this.lop = lop;
        this.ngaythi = ngaythi;
        this.loaithi=loaithi;
        this.block=block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public void setLoaithi(String loaithi) {
        this.loaithi = loaithi;
    }

    public String getBlock() {
        return block;
    }

    public String getLoaithi() {
        return loaithi;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public void setCathi(int cathi) {
        this.cathi = cathi;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public void setPhongthi(String phongthi) {
        this.phongthi = phongthi;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setNgaythi(Date ngaythi) {
        this.ngaythi = ngaythi;
    }

    public int getId() {
        return id;
    }

    public int getCathi() {
        return cathi;
    }

    public String getMamon() {
        return mamon;
    }

    public String getPhongthi() {
        return phongthi;
    }

    public String getLop() {
        return lop;
    }

    public Date getNgaythi() {
        return ngaythi;
    }
    
    public String giothi(){
        if(cathi==1){
            return "7:15 đến 9:15";
        }else if(cathi==2){
            return "9:25 đến 11:25";
        }else if(cathi==3){
            return "12:00 đến 14:00";
        }else if(cathi==4){
            return "14:10 đến 16:10 ";
        }else if(cathi==5){
         return "16:20 đến 18:20";
        }else{
            return "18:30 đến 20:30";
        }
    }
}
