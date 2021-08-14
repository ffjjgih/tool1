/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Inputkehoachthi;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Multithread implements Runnable{
    private checksv sv=new checksv();
    private String namefile,savefile,loaimon;
    private ArrayList<Inputkehoachthi>ds;
    public Multithread(String namefile,String savefile,String loaimon,ArrayList<Inputkehoachthi> ds)throws Exception{
        this.namefile=namefile;
        this.savefile=savefile;
        this.loaimon=loaimon;
        this.ds=ds;
    }

    @Override
    public void run() {
        try {
            sv.ktramondauvao(namefile,loaimon);
            sv.xuatdssthi(savefile,ds);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
