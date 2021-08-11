/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Multithread implements Runnable{
    private checksv sv=new checksv();
    private String namefile,savefile,lanthi,block;
    public Multithread(String namefile,String savefile,String lanthi,String block)throws Exception{
        this.namefile=namefile;
        this.savefile=savefile;
        this.lanthi=lanthi;
        this.block=block;
    }

    
    @Override
    public void run(){
        try {
            sv.ktramondauvao(namefile);
            sv.xuatdssthi(savefile, lanthi,block);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
