/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author ariboss89
 */
public class tb_login {
    private static String username;
    private static String role;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        tb_login.username = username;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        tb_login.role = role;
    }
}
