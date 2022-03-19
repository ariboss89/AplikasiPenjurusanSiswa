/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Koneksi.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Interface.IAturanService;
import Models.ipa;
import java.util.ArrayList;

/**
 *
 * @author ariboss89
 */
public class AturanServiceImpl implements IAturanService{

    private Koneksi con;
    private Statement st;
    private ResultSet res;
    private String query;
    
    @Override
    public String[][] ShowDataMinat() {
        
    res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(id) AS Jumlah FROM tb_minat";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_minat";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][7];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("id");
                data[r][1] = res.getString("nama_siswa");
                data[r][2] = res.getString("atribut");
                data[r][3] = res.getString("nilai_angka");
                data[r][4] = res.getString("nilai_huruf");
                data[r][5] = res.getString("minat");
                data[r][6] = res.getString("id_siswa");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][7];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 7; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    
    }    

    @Override
    public int Kasus(String atribut, String huruf, String minat) {
        
        con = new Koneksi();
        int count = 0;

        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT count(id_siswa) AS countAtr FROM tb_minat WHERE atribut = '"+atribut+"' AND nilai_huruf='"+huruf+"' AND minat = '"+minat+"'");
            while (res.next()) {
                count = res.getInt("countAtr");
            }
        } catch (SQLException ex) {

        }
        
        return count;
        
    }    

    @Override
    public int TotalKasus(String minat) {
    
        con = new Koneksi();
        int count = 0;

        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT count(minat) AS countAtr FROM tb_siswa WHERE minat = '"+minat+"' ");
            while (res.next()) {
                count = res.getInt("countAtr");
            }
        } catch (SQLException ex) {

        }
        
        return count;
    
    }

    @Override
    public int CountKasus(String atribut1, String atribut2, String minat) {
        
        con = new Koneksi();
        int count = 0;
        ipa atr = new ipa();
        
        String SQL = "SELECT SUM(COUNT(Distinct nama_siswa)) OVER() AS total_count FROM tb_minat WHERE nilai_huruf IN('"+atribut1+"', '"+atribut2+"')"
                    + " AND minat='"+minat+"' GROUP BY nama_siswa HAVING COUNT(*) = 2";
        
        try {
            st = con.connect().createStatement();
            res = st.executeQuery(SQL);
            
            if (res.first()) {
                count = res.getInt("total_count");
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        return count;
        
    }
    
    @Override
    public int CountKasus3(String atribut1, String atribut2, String atribut3, String minat) {
    
        con = new Koneksi();
        int count = 0;
        ipa atr = new ipa();
        
        String SQL = "SELECT SUM(COUNT(Distinct nama_siswa)) OVER() AS total_count FROM tb_minat WHERE nilai_huruf IN('"+atribut1+"', '"+atribut2+"', '"+atribut3+"')"
                    + " AND minat='"+minat+"' GROUP BY nama_siswa HAVING COUNT(*) = 3";
        
        try {
            st = con.connect().createStatement();
            res = st.executeQuery(SQL);
            
            if (res.first()) {
                count = res.getInt("total_count");
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        return count;
    
    }
}
