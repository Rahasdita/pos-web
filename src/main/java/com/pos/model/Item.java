/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author faheem
 */
@Entity
@Table(name = "m_item")
public class Item extends BaseEntity{
    @NotNull
    @NotEmpty
    @Column(name = "kode", length = 15, unique = true)
    private String kode;

    @Column(name = "barcode", length = 15, unique = true)
    private String barcode;
    
    @NotEmpty
    @NotNull
    @Column(name = "nama_barang", length = 100, unique = true, nullable = false)
    private String nama;
    
    @ManyToOne
    @JoinColumn(name = "id_kategori")
    private ItemKategori itemKategori;        
    
    @ManyToOne
    @JoinColumn(name = "id_satuan")
    private Satuan satuan; //satuan kecil
    
    private Boolean active;

    private String keterangan;
    
    @Column(name = "harga_jual")
    private BigDecimal hargaJual;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "item_type")
    private ItemType itemType;
    
    @Column(name = "reorder_level")
    private Integer reorderLevel;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ItemKategori getItemKategori() {
        return itemKategori;
    }

    public void setItemKategori(ItemKategori itemKategori) {
        this.itemKategori = itemKategori;
    }

    public Satuan getSatuan() {
        return satuan;
    }

    public void setSatuan(Satuan satuan) {
        this.satuan = satuan;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public BigDecimal getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(BigDecimal hargaJual) {
        this.hargaJual = hargaJual;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }
  
    
}
