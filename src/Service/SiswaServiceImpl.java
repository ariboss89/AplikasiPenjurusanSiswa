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
import javax.swing.JOptionPane;
import Interface.ISiswaService;

/**
 *
 * @author ariboss89
 */
public class SiswaServiceImpl implements ISiswaService {

    private Koneksi con;
    private Statement st;
    private ResultSet res;
    private String query;

    @Override
    public String IdSiswa() {
        con = new Koneksi();
        String idSiswa = "";
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_siswa ORDER BY id DESC");
            if (res.first() == false) {
                idSiswa = "S-00001";
            } else {
                res.first();
                System.out.println("COT: " + res.getString("id").substring(2, 7));
                int nokirim = Integer.valueOf(res.getString("id").substring(2, 7)) + 1;
                System.out.println(nokirim);
                if (nokirim < 10) {
                    idSiswa = ("S-0000" + nokirim);
                } else if (nokirim >= 10 && nokirim < 100) {
                    idSiswa = ("S-000" + nokirim);
                } else if (nokirim >= 100 && nokirim < 1000) {
                    idSiswa = ("S-00" + nokirim);
                } else if (nokirim >= 1000 && nokirim < 10000) {
                    idSiswa = ("S-0" + nokirim);
                } else if (nokirim >= 10000 && nokirim < 100000) {
                    idSiswa = ("S-" + nokirim);
                }
            }
            res.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }

        return idSiswa;
    }

    @Override
    public void Save(String nis, String nisn, String idSiswa, String nama, String alamat, String kontak, String minat) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_siswa(id, nama, alamat,kontak, minat, nis, nisn)values('" + idSiswa + "', '" + nama + "','" + alamat + "','" + kontak + "','" + minat + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public void Update(String nis, String nisn, String idSiswa, String nama, String alamat, String kontak, String minat) {

        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_siswa SET nama='" + nama + "', alamat ='" + alamat + "', kontak='" + kontak + "', minat ='" + minat + "', nis ='" + nis + "', nisn ='" + nisn + "' where id = '" + idSiswa + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        }
    }

    @Override
    public void Delete(String idSiswa) {

        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_siswa where id = '" + idSiswa + "'";
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
            query = "SELECT COUNT(id) AS Jumlah FROM tb_siswa";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_siswa";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][7];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("nis");
                data[r][1] = res.getString("nisn");
                data[r][2] = res.getString("id");
                data[r][3] = res.getString("nama");
                data[r][4] = res.getString("alamat");
                data[r][5] = res.getString("kontak");
                data[r][6] = res.getString("minat");
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

}
