/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Models.ipa;
import Models.tb_rules;
import java.util.ArrayList;

/**
 *
 * @author ariboss89
 */
public interface IAturanService {
    String[][] ShowDataMinat();
    int Kasus(String atribut, String huruf, String minat);
    int TotalKasus(String minat);
    int CountKasus(String atribut1, String atribut2, String minat);
    int CountKasus3(String atribut1, String atribut2, String atribut3, String minat);
    void DeleteRules(String idRules);
}
