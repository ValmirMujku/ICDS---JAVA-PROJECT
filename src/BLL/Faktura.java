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
@Table(name = "Faktura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faktura.findAll", query = "SELECT f FROM Faktura f")
    , @NamedQuery(name = "Faktura.findByFakturaID", query = "SELECT f FROM Faktura f WHERE f.fakturaID = :fakturaID")
    , @NamedQuery(name = "Faktura.findByCmimimeTVSH", query = "SELECT f FROM Faktura f WHERE f.cmimimeTVSH = :cmimimeTVSH")
    , @NamedQuery(name = "Faktura.findByCmimi", query = "SELECT f FROM Faktura f WHERE f.cmimi = :cmimi")
    , @NamedQuery(name = "Faktura.findByData", query = "SELECT f FROM Faktura f WHERE f.data = :data")
    , @NamedQuery(name = "Faktura.findByBarkodi", query = "SELECT f FROM Faktura f WHERE f.barkodi = :barkodi")
    , @NamedQuery(name = "Faktura.findBySasia", query = "SELECT f FROM Faktura f WHERE f.sasia = :sasia")})
public class Faktura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Faktura_ID")
        @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer fakturaID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Cmimi_me_TVSH")
    private BigDecimal cmimimeTVSH;
    @Basic(optional = false)
    @Column(name = "Cmimi")
    private BigDecimal cmimi;
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @Column(name = "Barkodi")
    private int barkodi;
    @Basic(optional = false)
    @Column(name = "Sasia")
    private BigDecimal sasia;
    @JoinColumn(name = "Biznesi_ID", referencedColumnName = "Biznesi_ID")
    @ManyToOne(optional = false)
    private Biznesi biznesiID;
    @JoinColumn(name = "Produkti_ID", referencedColumnName = "Produkti_ID")
    @ManyToOne(optional = false)
    private Produkti produktiID;

    public Faktura() {
    }

    public Faktura(Integer fakturaID) {
        this.fakturaID = fakturaID;
    }

    public Faktura(Integer fakturaID, BigDecimal cmimimeTVSH, BigDecimal cmimi, int barkodi, BigDecimal sasia) {
        this.fakturaID = fakturaID;
        this.cmimimeTVSH = cmimimeTVSH;
        this.cmimi = cmimi;
        this.barkodi = barkodi;
        this.sasia = sasia;
    }

    public Integer getFakturaID() {
        return fakturaID;
    }

    public void setFakturaID(Integer fakturaID) {
        this.fakturaID = fakturaID;
    }

    public BigDecimal getCmimimeTVSH() {
        return cmimimeTVSH;
    }

    public void setCmimimeTVSH(BigDecimal cmimimeTVSH) {
        this.cmimimeTVSH = cmimimeTVSH;
    }

    public BigDecimal getCmimi() {
        return cmimi;
    }

    public void setCmimi(BigDecimal cmimi) {
        this.cmimi = cmimi;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getBarkodi() {
        return barkodi;
    }

    public void setBarkodi(int barkodi) {
        this.barkodi = barkodi;
    }

    public BigDecimal getSasia() {
        return sasia;
    }

    public void setSasia(BigDecimal sasia) {
        this.sasia = sasia;
    }

    public Biznesi getBiznesiID() {
        return biznesiID;
    }

    public void setBiznesiID(Biznesi biznesiID) {
        this.biznesiID = biznesiID;
    }

    public Produkti getProduktiID() {
        return produktiID;
    }

    public void setProduktiID(Produkti produktiID) {
        this.produktiID = produktiID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fakturaID != null ? fakturaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faktura)) {
            return false;
        }
        Faktura other = (Faktura) object;
        if ((this.fakturaID == null && other.fakturaID != null) || (this.fakturaID != null && !this.fakturaID.equals(other.fakturaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Faktura[ fakturaID=" + fakturaID + " ]";
    }
    
}
