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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "Shitjet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shitjet.findAll", query = "SELECT s FROM Shitjet s")
    , @NamedQuery(name = "Shitjet.findByShitjetID", query = "SELECT s FROM Shitjet s WHERE s.shitjetID = :shitjetID")
    , @NamedQuery(name = "Shitjet.findByData", query = "SELECT s FROM Shitjet s WHERE s.data = :data")
    , @NamedQuery(name = "Shitjet.findByCmimimeTvsh", query = "SELECT s FROM Shitjet s WHERE s.cmimimeTvsh = :cmimimeTvsh")
    , @NamedQuery(name = "Shitjet.findByCmimipaTvsh", query = "SELECT s FROM Shitjet s WHERE s.cmimipaTvsh = :cmimipaTvsh")
    , @NamedQuery(name = "Shitjet.findByTotali", query = "SELECT s FROM Shitjet s WHERE s.totali = :totali")
    , @NamedQuery(name = "Shitjet.findBySasiaPaket", query = "SELECT s FROM Shitjet s WHERE s.sasiaPaket = :sasiaPaket")})
public class Shitjet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Shitjet_ID")
        @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer shitjetID;
    @Basic(optional = false)
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Cmimi_me_Tvsh")
    private BigDecimal cmimimeTvsh;
    @Basic(optional = false)
    @Column(name = "Cmimi_pa_Tvsh")
    private BigDecimal cmimipaTvsh;
    @Basic(optional = false)
    @Column(name = "Totali")
    private BigDecimal totali;
    @Basic(optional = false)
    @Column(name = "SasiaPaket")
    private BigDecimal sasiaPaket;
    @JoinColumn(name = "Biznesi_ID", referencedColumnName = "Biznesi_ID")
    @ManyToOne(optional = false)
    private Biznesi biznesiID;

    public Shitjet() {
    }

    public Shitjet(Integer shitjetID) {
        this.shitjetID = shitjetID;
    }

    public Shitjet(Integer shitjetID, Date data, BigDecimal cmimimeTvsh, BigDecimal cmimipaTvsh, BigDecimal totali, BigDecimal sasiaPaket) {
        this.shitjetID = shitjetID;
        this.data = data;
        this.cmimimeTvsh = cmimimeTvsh;
        this.cmimipaTvsh = cmimipaTvsh;
        this.totali = totali;
        this.sasiaPaket = sasiaPaket;
    }

    public Integer getShitjetID() {
        return shitjetID;
    }

    public void setShitjetID(Integer shitjetID) {
        this.shitjetID = shitjetID;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getCmimimeTvsh() {
        return cmimimeTvsh;
    }

    public void setCmimimeTvsh(BigDecimal cmimimeTvsh) {
        this.cmimimeTvsh = cmimimeTvsh;
    }

    public BigDecimal getCmimipaTvsh() {
        return cmimipaTvsh;
    }

    public void setCmimipaTvsh(BigDecimal cmimipaTvsh) {
        this.cmimipaTvsh = cmimipaTvsh;
    }

    public BigDecimal getTotali() {
        return totali;
    }

    public void setTotali(BigDecimal totali) {
        this.totali = totali;
    }

    public BigDecimal getSasiaPaket() {
        return sasiaPaket;
    }

    public void setSasiaPaket(BigDecimal sasiaPaket) {
        this.sasiaPaket = sasiaPaket;
    }

    public Biznesi getBiznesiID() {
        return biznesiID;
    }

    public void setBiznesiID(Biznesi biznesiID) {
        this.biznesiID = biznesiID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shitjetID != null ? shitjetID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shitjet)) {
            return false;
        }
        Shitjet other = (Shitjet) object;
        if ((this.shitjetID == null && other.shitjetID != null) || (this.shitjetID != null && !this.shitjetID.equals(other.shitjetID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Shitjet[ shitjetID=" + shitjetID + " ]";
    }
    
}
