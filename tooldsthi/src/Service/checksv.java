package Service;

import DAOduan.DAOkehoach;
import DAOduan.DAOkehoachthiimprements;
import Model.Inputkehoachthi;
import Model.Sinhvien;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class checksv {

    private DAOkehoach ds;
    private ArrayList<Sinhvien> lstsv;
    private ArrayList<Sinhvien> lstthi;
    private ArrayList<Sinhvien> lstcamthi;
    private String mafile;
    private int count=0;

    public checksv() {
        this.ds = new DAOkehoachthiimprements();
        this.lstsv = new ArrayList<>();
        this.lstcamthi = new ArrayList<>();
        this.lstthi = new ArrayList<>();
    }

    private XSSFSheet createSheet(String namefile) throws Exception {
        FileInputStream excel = new FileInputStream(namefile);
        XSSFWorkbook workbook = new XSSFWorkbook(excel);
        XSSFSheet sheet = workbook.getSheetAt(0);
        return sheet;
    }

    private Iterator createiterator(XSSFSheet sheet) throws Exception {
        Iterator<Row> iterator = sheet.iterator();
        return iterator;
    }

    private void mononl(String namefile) throws Exception {
        List<Integer> dscolumndiem = new ArrayList<>();
        XSSFSheet sheet = createSheet(namefile);
        Iterator<Row> iterator = createiterator(sheet);
                sheet.getRow(6).forEach(cellonl -> {
                    if (cellonl.getStringCellValue().equalsIgnoreCase("MSSV") || cellonl.getStringCellValue().equalsIgnoreCase("Họ và tên")
                            || cellonl.getStringCellValue().equalsIgnoreCase("Bài học online") || cellonl.getStringCellValue().equalsIgnoreCase("Trạng thái")) {
                        dscolumndiem.add(cellonl.getColumnIndex());
                    }
                });
                try {
                    lstsv = ds.docexcelloai1(iterator, dscolumndiem);
                    mafile = ds.tenfilethi().trim();
                    checkdiemonl(lstsv);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }

    private void monquiz(String namefile)throws Exception{
        List<Integer> dscolumndiem = new ArrayList<>();
        XSSFSheet sheet = createSheet(namefile);
        Iterator<Row> iterator = createiterator(sheet);
        sheet.getRow(6).forEach(cellquiz -> {
                        if (cellquiz.getStringCellValue().equalsIgnoreCase("MSSV") || cellquiz.getStringCellValue().equalsIgnoreCase("Họ và tên")
                                || cellquiz.getStringCellValue().equalsIgnoreCase("Quiz online 1") || cellquiz.getStringCellValue().equalsIgnoreCase("Quiz online 2")
                                || cellquiz.getStringCellValue().equalsIgnoreCase("Quiz online 3") || cellquiz.getStringCellValue().equalsIgnoreCase("Quiz online 4")
                                || cellquiz.getStringCellValue().equalsIgnoreCase("Quiz online 5") || cellquiz.getStringCellValue().equalsIgnoreCase("Quiz online 6")
                                || cellquiz.getStringCellValue().equalsIgnoreCase("Quiz online 7") || cellquiz.getStringCellValue().equalsIgnoreCase("Quiz online 8")
                                || cellquiz.getStringCellValue().equalsIgnoreCase("Trạng thái")) {
                            dscolumndiem.add(cellquiz.getColumnIndex());
                        }
                    });
                    try {
                        lstsv = ds.docexcelloai2(iterator, dscolumndiem);
                        checkdiemquiz(lstsv);
                        mafile = ds.tenfilethi().trim();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
    }
    private void monloai3(String namefile)throws Exception{
        List<Integer> dscolumndiem = new ArrayList<>();
        XSSFSheet sheet = createSheet(namefile);
        Iterator<Row> iterator = createiterator(sheet);
        sheet.getRow(6).forEach(cellonl -> {
                if (cellonl.getStringCellValue().equalsIgnoreCase("MSSV") || cellonl.getStringCellValue().equalsIgnoreCase("Họ và tên")
                        || cellonl.getStringCellValue().equalsIgnoreCase("Trạng thái")) {
                    dscolumndiem.add(cellonl.getColumnIndex());
                }
            });
            try {
                lstsv = ds.docexceldiemdanh(iterator, dscolumndiem);
                checkmondiemdanh(lstsv);
                mafile = ds.tenfilethi().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    private void checkdiemonl(ArrayList<Sinhvien> lst) {
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).getDiemonl() < 7.5 || lst.get(i).getTinhtrang().equalsIgnoreCase("Attendance failed")) {
                lstcamthi.add(new Sinhvien(lst.get(i).getDiemonl(), lst.get(i).getTensv(), lst.get(i).getMasv(), "cấm thi",lst.get(i).getLop(),lst.get(i).getMonhoc()));
            } else {
                lstthi.add(new Sinhvien(lst.get(i).getDiemonl(), lst.get(i).getTensv(), lst.get(i).getMasv(), "",lst.get(i).getLop(),lst.get(i).getMonhoc()));
            }
        }
    }

    private void checkdiemquiz(ArrayList<Sinhvien> ds) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getDiemonl() < 80 || ds.get(i).getTinhtrang().equalsIgnoreCase("Attendance failed")) {
                lstcamthi.add(new Sinhvien(ds.get(i).getDiemonl(), ds.get(i).getTensv(), ds.get(i).getMasv(), "cấm thi",ds.get(i).getLop(),ds.get(i).getMonhoc()));
            } else {
                lstthi.add(new Sinhvien(ds.get(i).getDiemonl(), ds.get(i).getTensv(), ds.get(i).getMasv(), "",ds.get(i).getLop(),ds.get(i).getMonhoc()));
            }
        }
    }

    private void checkmondiemdanh(ArrayList<Sinhvien> ds) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getTinhtrang().equalsIgnoreCase("Attendance failed")) {
                lstcamthi.add(new Sinhvien(ds.get(i).getDiemonl(), ds.get(i).getTensv(), ds.get(i).getMasv(), "cấm thi",ds.get(i).getLop(),ds.get(i).getMonhoc()));
            } else {
                lstthi.add(new Sinhvien(ds.get(i).getDiemonl(), ds.get(i).getTensv(), ds.get(i).getMasv(), "",ds.get(i).getLop(),ds.get(i).getMonhoc()));
            }
        }
    }
    private void checksophong(){
        if (lstthi.size() < 27) {
                    count = 2;
                } else {
                    count = 3;
                }
    }

    public void xuatdssthi(String namefile,ArrayList<Inputkehoachthi> dskht) throws Exception {
        checksophong();
        String linkfolder=namefile+"danhsachthi/";
        System.out.println(dskht.size());
       File f = new File(linkfolder);
       if(f.exists()){
           ds.checklichthi(f.getAbsolutePath() + "/"+mafile +".xlsx", count, lstthi, lstcamthi,dskht);
        ds.checklichthi(f.getAbsolutePath() + "/"+mafile +".xlsx", count, lstthi, lstcamthi,dskht);
       }else{
           if(f.mkdir()){
               ds.checklichthi(f.getAbsolutePath() + "/"+mafile +".xlsx", count, lstthi, lstcamthi,dskht);
           }
       }
    }
    public int xuatdssvthi() {
        return this.lstthi.size();
    }
    
    public void ktramondauvao(String namefile,String loaimon)throws Exception{
        if(loaimon.equalsIgnoreCase("môn online")){
            mononl(namefile);
        }else if(loaimon.equalsIgnoreCase("môn quiz")){
            monquiz(namefile);
        }else{
            monloai3(namefile);
        }
    }
}
