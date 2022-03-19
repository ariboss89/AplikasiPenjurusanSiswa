/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Interface.ILaporanService;
import Koneksi.Koneksi;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ariboss89
 */
public class LaporanServiceImpl implements ILaporanService {

    Koneksi con;
    Statement st;
    ResultSet rs;
    
    @Override
    public void CetakKeputusanById(String idKeputusan) {
     
        con = new Koneksi();

        try {
            HashMap parameter = new HashMap();
            File file = new File("src/Laporan/LaporanKeputusan.jasper");
            parameter.put("id", idKeputusan);
            JasperReport jp = (JasperReport) JRLoader.loadObject(file);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jp, parameter, con.connect());
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
}
