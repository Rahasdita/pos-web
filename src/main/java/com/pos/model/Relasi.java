/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author faheem
 */
@Entity
@Table(name = "m_relasi")
public class Relasi {
    @Id
    @GeneratedValue
    private Integer id;
    
    @NotBlank
    @NotEmpty
    @Column(unique = true, nullable = false)
    private String kode;
    
    private String nama;
    private String alamat;
    
    private String kontak;
    
    @Column(length = 50)
    private String telp;

    @Column(length = 50)
    private String fax;
    
    @Column(length = 50)
    private String hp;
    
    @Column(length = 50)
    private String email;
    
    private Integer top;
    @Column(length = 50)
    private String no_npwp;
    
    private Boolean active;
    
    private Boolean is_cust;
    private Boolean is_supp;

    @ManyToOne
    @JoinColumn(name = "id_kota", nullable = false)
    
    private Kota kota;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public String getNo_npwp() {
        return no_npwp;
    }

    public void setNo_npwp(String no_npwp) {
        this.no_npwp = no_npwp;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean isIs_cust() {
        return is_cust;
    }

    public void setIs_cust(Boolean is_cust) {
        this.is_cust = is_cust;
    }

    public Boolean isIs_supp() {
        return is_supp;
    }

    public void setIs_supp(Boolean is_supp) {
        this.is_supp = is_supp;
    }
    
    
}
