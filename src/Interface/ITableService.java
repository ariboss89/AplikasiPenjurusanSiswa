/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JTable;

/**
 *
 * @author ariboss89
 */
public interface ITableService {
    void SetTable(JTable tabel, String [][] data, String [] namaKolom, int jmlKolom, int [] lebar);
}
