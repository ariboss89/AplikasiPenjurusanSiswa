/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Models.tb_minat;
import Models.tb_rules;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author ariboss89
 */
public interface IKeputusanService {
    public String idKeputusan();
    String[][] ShowData();
    ArrayList<tb_rules> listAturan();
    ArrayList<String> listIdSiswa();
    public void Save(String idKeputusan, String idSiswa, String namaSiswa, String minat, String jurusan, Date tanggal);
    ArrayList<tb_minat> listMinat();
    public void SaveId(String idKeputusan);
}
