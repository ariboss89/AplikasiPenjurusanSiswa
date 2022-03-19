/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Models.tb_minat;
import java.util.ArrayList;

/**
 *
 * @author ariboss89
 */
public interface IMinatService {
    
    void Save(String nama, String atribut, int nilaiAngka, String nilaiHuruf, String minat, String idSiswa);
    void Update(int id, String nama, String atribut, int nilaiAngka, String nilaiHuruf, String minat, String idSiswa);
    void Delete(int idSiswa);
    
    String[][] Show();
    
    ArrayList<String> listSiswa();
    
    ArrayList<tb_minat> listSiswaById(String idSiswa);
}
