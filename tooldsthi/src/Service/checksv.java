package Service;

import DAOduan.DAOkehoach;
import DAOduan.DAOkehoachthiimprements;
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

    public void ktramondauvao(String namefile) throws Exception {
        List<Integer> dscolumndiem = new ArrayList<>();
        XSSFSheet sheet = createSheet(namefile);
        Iterator<Row> iterator = createiterator(sheet);
        sheet.getRow(6).forEach(cell -> {
            if (cell.getStringCellValue().equalsIgnoreCase("Bài học online")) {
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
            } else if (cell.getStringCellValue().equalsIgnoreCase("Quiz online")) {

            }
        });

        if (lstsv.size() == 0) {
            sheet.getRow(6).forEach(cellcheck -> {
                if (cellcheck.getStringCellValue().equalsIgnoreCase("Quiz online 1") || cellcheck.getStringCellValue().equalsIgnoreCase("Quiz online 2")
                        || cellcheck.getStringCellValue().equalsIgnoreCase("Quiz online 3") || cellcheck.getStringCellValue().equalsIgnoreCase("Quiz online 4")
                        || cellcheck.getStringCellValue().equalsIgnoreCase("Quiz online 5") || cellcheck.getStringCellValue().equalsIgnoreCase("Quiz online 6")
                        || cellcheck.getStringCellValue().equalsIgnoreCase("Quiz online 7") || cellcheck.getStringCellValue().equalsIgnoreCase("Quiz online 8")) {
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
            });

        }

        if (lstsv.size() == 0) {
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
    }

    private void checkdiemonl(ArrayList<Sinhvien> lst) {
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).getDiemonl() < 7.5 || lst.get(i).getTinhtrang().equalsIgnoreCase("Attendance failed")) {
                lstcamthi.add(new Sinhvien(lst.get(i).getDiemonl(), lst.get(i).getTensv(), lst.get(i).getMasv(), "cấm thi"));
            } else {
                lstthi.add(new Sinhvien(lst.get(i).getDiemonl(), lst.get(i).getTensv(), lst.get(i).getMasv(), ""));
            }
        }
        System.out.println(lstthi.size());
    }

    private void checkdiemquiz(ArrayList<Sinhvien> ds) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getDiemonl() < 80 || ds.get(i).getTinhtrang().equalsIgnoreCase("Attendance failed")) {
                lstcamthi.add(new Sinhvien(ds.get(i).getDiemonl(), ds.get(i).getTensv(), ds.get(i).getMasv(), "cấm thi"));
            } else {
                lstthi.add(new Sinhvien(ds.get(i).getDiemonl(), ds.get(i).getTensv(), ds.get(i).getMasv(), ""));
            }
        }
    }

    private void checkmondiemdanh(ArrayList<Sinhvien> ds) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getTinhtrang().equalsIgnoreCase("Attendance failed")) {
                lstcamthi.add(new Sinhvien(ds.get(i).getDiemonl(), ds.get(i).getTensv(), ds.get(i).getMasv(), "cấm thi"));
            } else {
                lstthi.add(new Sinhvien(ds.get(i).getDiemonl(), ds.get(i).getTensv(), ds.get(i).getMasv(), ""));
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

    public void xuatdssthi(String namefile, String lanthi,String block) throws Exception {
        checksophong();
        String linkfolder=namefile+"danhsachthi/";
       System.out.println(linkfolder);
       File f = new File(linkfolder);
       if(f.exists()){
           ds.xuatdssthifileword(f.getAbsolutePath() + "/"+mafile + ".docx", count, lstthi);
        ds.xuatlichthi(f.getAbsolutePath() + "/"+mafile +".xlsx", lanthi, count, lstthi, lstcamthi,block);
       }else{
           if(f.mkdir()){
               ds.xuatdssthifileword(f.getAbsolutePath() +"/"+ mafile + ".docx", count, lstthi);
               ds.xuatlichthi(f.getAbsolutePath() + "/"+mafile + ".xlsx", lanthi, count, lstthi, lstcamthi,block);
           }
       }
    }
    public int xuatdssvthi() {
        return this.lstthi.size();
    }

}
