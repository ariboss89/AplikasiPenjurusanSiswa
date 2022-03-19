/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Koneksi.Koneksi;
import Models.tb_minat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Interface.IMinatService;
import Interface.ISiswaService;

/**
 *
 * @author ariboss89
 */
public class MinatServiceImpl implements IMinatService {

    private Koneksi con;
    private Statement st;
    private ResultSet res;
    private String query;
    
    @Override
    public void Save(String nama, String atribut, int nilaiAngka, String nilaiHuruf, String minat, String idSiswa) {
    
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_minat(nama_siswa, atribut, nilai_angka, nilai_huruf, minat, id_siswa)values('" + nama + "', '" + atribut + "','" + nilaiAngka + "','" + nilaiHuruf + "','" + minat + "','" + idSiswa + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    }

    @Override
    public void Update(int id, String nama, String atribut, int nilaiAngka, String nilaiHuruf, String minat, String idSiswa) {
        
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_minat SET nama_siswa='" + nama + "', atribut ='" + atribut + "', nilai_angka='" + nilaiAngka + "', nilai_huruf ='" + nilaiHuruf + "', minat ='" + minat + "', id_siswa ='" + idSiswa + "' where id = '" + id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        }
        
    }

    @Override
    public void Delete(int id) {
        
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_minat where id = '" + id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Hapus");
        } catch (SQLException e) {

            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }

    @Override
    public String[][] Show() {
    
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
    public ArrayList<String> listSiswa() {
        
        ArrayList<String> list = new ArrayList<String>();

        con = new Koneksi();

        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_siswa");
            while (res.next()) {
                list.add(res.getString("id"));
            }
        } catch (SQLException ex) {

        }

        return list;
    }

    @Override
    public ArrayList<tb_minat> listSiswaById(String idSiswa) {
        
        ArrayList<tb_minat> list = new ArrayList<tb_minat>();

        con = new Koneksi();

        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_siswa WHERE id = '"+idSiswa+"'");
            while (res.next()) {
                
                String namaSiswa = res.getString("nama");
                String minat = res.getString("minat");
                
                
                tb_minat tbm  = new tb_minat();
                tbm.setNama_siswa(namaSiswa);
                tbm.setMinat(minat);
                
                list.add(tbm);
            }
        } catch (SQLException ex) {

        }

        return list;
        
    }
        
    
}
