/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Service.SiswaServiceImpl;

/**
 *
 * @author ariboss89
 */
public class tb_siswa extends SiswaServiceImpl {
    public String id;
    public String nama_siswa;
    public String atribut;
    public int nilai_angka;
    public String nilai_huruf;
    public String minat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_siswa() {
        return nama_siswa;
    }

    public void setNama_siswa(String nama_siswa) {
        this.nama_siswa = nama_siswa;
    }

    public String getAtribut() {
        return atribut;
    }

    public void setAtribut(String atribut) {
        this.atribut = atribut;
    }

    public int getNilai_angka() {
        return nilai_angka;
    }

    public void setNilai_angka(int nilai_angka) {
        this.nilai_angka = nilai_angka;
    }

    public String getNilai_huruf() {
        return nilai_huruf;
    }

    public void setNilai_huruf(String nilai_huruf) {
        this.nilai_huruf = nilai_huruf;
    }

    public String getMinat() {
        return minat;
    }

    public void setMinat(String minat) {
        this.minat = minat;
    }
    
    
}
