/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Models.tb_siswa;
import java.util.ArrayList;

/**
 *
 * @author ariboss89
 */
public interface ISiswaService{
    String IdSiswa();
    void Save(String idSiswa, String nama, String alamat, String kontak, String minat);
    void Update(String idSiswa, String nama, String alamat, String kontak, String minat);
    void Delete(String idSiswa);
    
    String[][] Show();
}
