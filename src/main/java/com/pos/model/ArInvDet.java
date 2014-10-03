/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author faheem
 */
@Entity
@Table(name = "ar_inv_det")
public class ArInvDet extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "ar_id", nullable = false)
    private ArInv arInv;
    
    
    @ManyToOne
    @JoinColumn(name = "id_item")
    private Item item;
    
    private Double qty;
    
    private BigDecimal harga;
    @Column(length = 30)
    private String  diskon; //diskon bisa bertingkat seperti 10+5+10
    
    @ManyToOne
    @JoinColumn(name = "id_satuan")
    private Satuan satuan;
    
    private Integer konversi;

    public ArInv getArInv() {
        return arInv;
    }

    public void setArInv(ArInv arInv) {
        this.arInv = arInv;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public String getDiskon() {
        return diskon;
    }

    public void setDiskon(String diskon) {
        this.diskon = diskon;
    }

    public Satuan getSatuan() {
        return satuan;
    }

    public void setSatuan(Satuan satuan) {
        this.satuan = satuan;
    }

    public Integer getKonversi() {
        return konversi;
    }

    public void setKonversi(Integer konversi) {
        this.konversi = konversi;
    }
    
    
    
}
