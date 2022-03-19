/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author ariboss89
 */
public interface IHasilService {
    
    String IdRules();
    void Save(String idRules, String rules, String then);
    void Update(String idRules, String rules, String then);
    void Delete(String idRules);
    String[][] Show();
    
}
