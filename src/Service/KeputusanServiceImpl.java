/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Interface.IKeputusanService;
import Koneksi.Koneksi;
import Models.tb_minat;
import Models.tb_rules;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ariboss89
 */
public class KeputusanServiceImpl implements IKeputusanService {

    private Koneksi con;
    private Statement st;
    private ResultSet res;
    private String query;

    @Override
    public String idKeputusan() {
        con = new Koneksi();
        String idSiswa = "";
        try {
            res = st.executeQuery("SELECT *FROM tb_siswa ORDER BY id DESC");
            
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_idkeputusan ORDER BY id_keputusan DESC");
            if (res.first() == false) {
                idSiswa = "K-0001";
            } else {
                res.first();
                System.out.println("COT: " + res.getString("id_keputusan").substring(2, 6));
                int nokirim = Integer.valueOf(res.getString("id_keputusan").substring(2, 6)) + 1;
                System.out.println(nokirim);
                if (nokirim < 10) {
                    idSiswa = ("K-000" + nokirim);
                } else if (nokirim >= 10 && nokirim < 100) {
                    idSiswa = ("K-00" + nokirim);
                } else if (nokirim >= 100 && nokirim < 1000) {
                    idSiswa = ("K-0" + nokirim);
                } else if (nokirim >= 1000 && nokirim < 10000) {
                    idSiswa = ("K-" + nokirim);
                }
            }
            res.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }

        return idSiswa;

    }

    @Override
    public String[][] ShowData() {
        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(id_keputusan) AS Jumlah FROM tb_keputusan";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_keputusan";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][5];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("id_keputusan");
                data[r][1] = res.getString("id_siswa");
                data[r][2] = res.getString("nama_siswa");
                data[r][3] = res.getString("minat");
                data[r][4] = res.getString("jurusan");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][5];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 5; c++) {
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
    public ArrayList<tb_rules> listAturan() {
        ArrayList<tb_rules> list = new ArrayList<tb_rules>();
        tb_rules tbr = new tb_rules();

        con = new Koneksi();

        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_rules");
            while (res.next()) {
                
                tbr = new tb_rules();
                tbr.setId_rules(res.getString("id_rules"));
                tbr.setRules(res.getString("rules"));
                tbr.setJurusan(res.getString("jurusan"));
                list.add(tbr);
                
            }
        } catch (SQLException ex) {

        }

        return list;
    }

    @Override
    public ArrayList<String> listIdSiswa() {
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
    public void Save(String idKeputusan, String idSiswa, String namaSiswa, String minat, String jurusan, Date tanggal) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_keputusan(id_keputusan, id_siswa, nama_siswa, minat, jurusan, tanggal)values('" + idKeputusan + "', '" + idSiswa + "','" + namaSiswa + "','" + minat + "','" + jurusan + "','" + tanggal + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            //JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public ArrayList<tb_minat> listMinat() {
        ArrayList<tb_minat> list = new ArrayList<>();
        tb_minat tbr = new tb_minat();

        con = new Koneksi();

        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_minat");
            while (res.next()) {
                
                tbr = new tb_minat();
                tbr.setNama_siswa(res.getString("nama_siswa"));
                tbr.setAtribut(res.getString("atribut"));
                tbr.setNilai_angka(res.getInt("nilai_angka"));
                tbr.setNilai_huruf(res.getString("nilai_huruf"));
                tbr.setMinat(res.getString("minat"));
                tbr.setIdSiswa(res.getString("id_siswa"));
                list.add(tbr);
            }
        } catch (SQLException ex) {

        }

        return list;
    }

    @Override
    public void SaveId(String idKeputusan) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_idkeputusan(id_keputusan)values('" + idKeputusan + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            
        } catch (SQLException e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
