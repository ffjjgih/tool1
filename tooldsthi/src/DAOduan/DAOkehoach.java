/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOduan;

import Model.Sinhvien;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author PC
 */
public interface DAOkehoach {

    public void docexcel(String namefile) throws Exception;

    public void luudb() throws Exception;

    public ArrayList<Sinhvien> docexcelloai1(Iterator<Row> iterquiz,List<Integer> lstcell) throws Exception;

    public void xuatlichthi(String namefile, String lanthi, int count,ArrayList<Sinhvien> svthi,ArrayList<Sinhvien> svcthi,String block) throws Exception;

    public void xuatkehoachthi(String lop, String ma) throws Exception;

    public ArrayList<Sinhvien> docexcelloai2(Iterator<Row> iterquiz,List<Integer> lstcell) throws Exception;
    
    public ArrayList<Sinhvien> docexceldiemdanh(Iterator<Row> iterquiz,List<Integer> lstcell) throws Exception;
    
    public void xuatdssthifileword(String namefile,int count,ArrayList<Sinhvien> svthi) throws Exception;
    
    public void xuatfileonlmau(String name)throws Exception;
    public void xuatfilequizmau(String name)throws Exception;
    public void xuatfilemau(String name)throws Exception;
    public String tenfilethi();
}
