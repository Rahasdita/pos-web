/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.CreditCardNumber;

/**
 *
 * @author faheem
 */
@Entity
@Table(name = "ar_inv")
public class ArInv extends BaseEntity {

    @Column(name = "invoice_no", unique = true)
    private String invoiceNo;

    private String description;
    @Column(name = "invoice_date")
    private Date invoiceDate;

    private Short top=new Short("0");

    private BigDecimal amount;

    @Column(name = "item_amount")
    private BigDecimal itemAmount=BigDecimal.ZERO;

    @Column(name = "paid_amount")
    private BigDecimal paidAmount=BigDecimal.ZERO;

    private BigDecimal owing=BigDecimal.ZERO;

    @Column(name = "ar_disc", length = 30)
    private String arDisc;

    @Column(name = "biaya_lain")
    private BigDecimal biayaLain;

    @Column(name = "time_ins")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeIns;

    @Column(name = "user_ins", length = 30)
    private String userIns;

    @Column(name = "time_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeUpd;

    @Column(name = "user_upd", length = 30)
    private String userUpd;

    @Column(name = "ket_pembayaran")
    private String ketPembayaran;

    @Column(name = "retur_dari")
    private String returDari; //diisi jika transaksi retur

    @Column(name = "close_id")
    private String closeId;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "jenis_bayar")
    private JenisBayar jenisBayar;

    @ManyToOne
    @JoinColumn(name = "id_relasi")
    private Relasi relasi;

    @ManyToOne
    @JoinColumn(name = "id_gudang")
    private Gudang gudang;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "trx_type")
    private TrxType trxType;

    @Cascade(CascadeType.ALL)
    @OneToMany(mappedBy = "arInv", orphanRemoval = true)
    @OrderBy("id asc")
    private List<ArInvDet> arInvDet;
    
    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Short getTop() {
        return top;
    }

    public void setTop(Short top) {
        this.top = top;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(BigDecimal itemAmount) {
        this.itemAmount = itemAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public BigDecimal getOwing() {
        return owing;
    }

    public void setOwing(BigDecimal owing) {
        this.owing = owing;
    }

    public String getArDisc() {
        return arDisc;
    }

    public void setArDisc(String arDisc) {
        this.arDisc = arDisc;
    }

    public BigDecimal getBiayaLain() {
        return biayaLain;
    }

    public void setBiayaLain(BigDecimal biayaLain) {
        this.biayaLain = biayaLain;
    }

    public Date getTimeIns() {
        return timeIns;
    }

    public void setTimeIns(Date timeIns) {
        this.timeIns = timeIns;
    }

    public String getUserIns() {
        return userIns;
    }

    public void setUserIns(String userIns) {
        this.userIns = userIns;
    }

    public Date getTimeUpd() {
        return timeUpd;
    }

    public void setTimeUpd(Date timeUpd) {
        this.timeUpd = timeUpd;
    }

    public String getUserUpd() {
        return userUpd;
    }

    public void setUserUpd(String userUpd) {
        this.userUpd = userUpd;
    }

    public String getKetPembayaran() {
        return ketPembayaran;
    }

    public void setKetPembayaran(String ketPembayaran) {
        this.ketPembayaran = ketPembayaran;
    }

    public String getReturDari() {
        return returDari;
    }

    public void setReturDari(String returDari) {
        this.returDari = returDari;
    }

    public String getCloseId() {
        return closeId;
    }

    public void setCloseId(String closeId) {
        this.closeId = closeId;
    }

    public JenisBayar getJenisBayar() {
        return jenisBayar;
    }

    public void setJenisBayar(JenisBayar jenisBayar) {
        this.jenisBayar = jenisBayar;
    }

    public Relasi getRelasi() {
        return relasi;
    }

    public void setRelasi(Relasi relasi) {
        this.relasi = relasi;
    }

    public Gudang getGudang() {
        return gudang;
    }

    public void setGudang(Gudang gudang) {
        this.gudang = gudang;
    }

    public TrxType getTrxType() {
        return trxType;
    }

    public void setTrxType(TrxType trxType) {
        this.trxType = trxType;
    }

    public List<ArInvDet> getArInvDet() {
        return arInvDet;
    }

    public void setArInvDet(List<ArInvDet> arInvDet) {
        this.arInvDet = arInvDet;
    }

    
}
