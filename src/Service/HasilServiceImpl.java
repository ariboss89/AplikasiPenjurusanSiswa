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

/**
 *
 * @author ariboss89
 */
public class HasilServiceImpl implements Interface.IHasilService{

    private Koneksi con;
    private Statement st;
    private ResultSet res;
    private String query;
    
    @Override
    public String IdRules() {
        con = new Koneksi();
        String idSiswa = "";
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_rules ORDER BY id_rules DESC");
            if (res.first() == false) {
                idSiswa = "R-001";
            } else {
                res.first();
                System.out.println("COT: " + res.getString("id_rules").substring(2, 5));
                int nokirim = Integer.valueOf(res.getString("id_rules").substring(2, 5)) + 1;
                System.out.println(nokirim);
                if (nokirim < 10) {
                    idSiswa = ("R-00" + nokirim);
                } else if (nokirim >= 10 && nokirim < 100) {
                    idSiswa = ("R-0" + nokirim);
                } else if (nokirim >= 100 && nokirim < 1000) {
                    idSiswa = ("R-" + nokirim);
                }
            }
            res.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }

        return idSiswa;
    }

    @Override
    public void Save(String idRules, String rules, String jurusan) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_rules(id_rules, rules, jurusan) values('" + idRules + "', '" + rules + "','" + jurusan + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public void Update(String idRules, String rules, String jurusan) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_rules SET rules='" + rules + "', jurusan ='" + jurusan + "' where id_rules = '" + idRules + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        }
    }

    @Override
    public void Delete(String idRules) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_rules where id_rules = '" + idRules + "'";
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
            query = "SELECT COUNT(id_rules) AS Jumlah FROM tb_rules";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_rules";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][3];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("id_rules");
                data[r][1] = res.getString("rules");
                data[r][2] = res.getString("jurusan");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][3];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 3; c++) {
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
