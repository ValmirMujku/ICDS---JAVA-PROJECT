/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "Hyrjet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hyrjet.findAll", query = "SELECT h FROM Hyrjet h")
    , @NamedQuery(name = "Hyrjet.findByHyrjetID", query = "SELECT h FROM Hyrjet h WHERE h.hyrjetID = :hyrjetID")
    , @NamedQuery(name = "Hyrjet.findByTotali", query = "SELECT h FROM Hyrjet h WHERE h.totali = :totali")
    , @NamedQuery(name = "Hyrjet.findByData", query = "SELECT h FROM Hyrjet h WHERE h.data = :data")
    , @NamedQuery(name = "Hyrjet.findByPalete", query = "SELECT h FROM Hyrjet h WHERE h.palete = :palete")
    , @NamedQuery(name = "Hyrjet.findByPaketa", query = "SELECT h FROM Hyrjet h WHERE h.paketa = :paketa")
    , @NamedQuery(name = "Hyrjet.findByCope", query = "SELECT h FROM Hyrjet h WHERE h.cope = :cope")})
public class Hyrjet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Hyrjet_ID")
        @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer hyrjetID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Totali")
    private BigDecimal totali;
    @Basic(optional = false)
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @Column(name = "Palete")
    private BigDecimal palete;
    @Basic(optional = false)
    @Column(name = "Paketa")
    private BigDecimal paketa;
    @Basic(optional = false)
    @Column(name = "Cope")
    private BigDecimal cope;

    public Hyrjet() {
    }

    public Hyrjet(Integer hyrjetID) {
        this.hyrjetID = hyrjetID;
    }

    public Hyrjet(Integer hyrjetID, BigDecimal totali, Date data, BigDecimal palete, BigDecimal paketa, BigDecimal cope) {
        this.hyrjetID = hyrjetID;
        this.totali = totali;
        this.data = data;
        this.palete = palete;
        this.paketa = paketa;
        this.cope = cope;
    }

    public Integer getHyrjetID() {
        return hyrjetID;
    }

    public void setHyrjetID(Integer hyrjetID) {
        this.hyrjetID = hyrjetID;
    }

    public BigDecimal getTotali() {
        return totali;
    }

    public void setTotali(BigDecimal totali) {
        this.totali = totali;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getPalete() {
        return palete;
    }

    public void setPalete(BigDecimal palete) {
        this.palete = palete;
    }

    public BigDecimal getPaketa() {
        return paketa;
    }

    public void setPaketa(BigDecimal paketa) {
        this.paketa = paketa;
    }

    public BigDecimal getCope() {
        return cope;
    }

    public void setCope(BigDecimal cope) {
        this.cope = cope;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hyrjetID != null ? hyrjetID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hyrjet)) {
            return false;
        }
        Hyrjet other = (Hyrjet) object;
        if ((this.hyrjetID == null && other.hyrjetID != null) || (this.hyrjetID != null && !this.hyrjetID.equals(other.hyrjetID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Hyrjet[ hyrjetID=" + hyrjetID + " ]";
    }
    
}
