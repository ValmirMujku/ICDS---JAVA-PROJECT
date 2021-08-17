/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "Porosia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Porosia.findAll", query = "SELECT p FROM Porosia p")
    , @NamedQuery(name = "Porosia.findByPorosiaID", query = "SELECT p FROM Porosia p WHERE p.porosiaID = :porosiaID")
    , @NamedQuery(name = "Porosia.findBySasia", query = "SELECT p FROM Porosia p WHERE p.sasia = :sasia")
    , @NamedQuery(name = "Porosia.findByAdresa", query = "SELECT p FROM Porosia p WHERE p.adresa = :adresa")
    , @NamedQuery(name = "Porosia.findByTotali", query = "SELECT p FROM Porosia p WHERE p.totali = :totali")})
public class Porosia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Porosia_ID")
        @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer porosiaID;
    @Basic(optional = false)
    @Column(name = "Sasia")
    private int sasia;
    @Basic(optional = false)
    @Column(name = "Adresa")
    private String adresa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Totali")
    private BigDecimal totali;
    @JoinColumn(name = "Biznesi_ID", referencedColumnName = "Biznesi_ID")
    @ManyToOne(optional = false)
    private Biznesi biznesiID;
    @JoinColumn(name = "Produkti_ID", referencedColumnName = "Produkti_ID")
    @ManyToOne(optional = false)
    private Produkti produktiID;

    public Porosia() {
    }

    public Porosia(Integer porosiaID) {
        this.porosiaID = porosiaID;
    }

    public Porosia(Integer porosiaID, int sasia, String adresa, BigDecimal totali) {
        this.porosiaID = porosiaID;
        this.sasia = sasia;
        this.adresa = adresa;
        this.totali = totali;
    }

    public Integer getPorosiaID() {
        return porosiaID;
    }

    public void setPorosiaID(Integer porosiaID) {
        this.porosiaID = porosiaID;
    }

    public int getSasia() {
        return sasia;
    }

    public void setSasia(int sasia) {
        this.sasia = sasia;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public BigDecimal getTotali() {
        return totali;
    }

    public void setTotali(BigDecimal totali) {
        this.totali = totali;
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
        hash += (porosiaID != null ? porosiaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Porosia)) {
            return false;
        }
        Porosia other = (Porosia) object;
        if ((this.porosiaID == null && other.porosiaID != null) || (this.porosiaID != null && !this.porosiaID.equals(other.porosiaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Porosia[ porosiaID=" + porosiaID + " ]";
    }
    
}
