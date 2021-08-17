/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "Biznesi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Biznesi.findAll", query = "SELECT b FROM Biznesi b")
    , @NamedQuery(name = "Biznesi.findByBiznesiID", query = "SELECT b FROM Biznesi b WHERE b.biznesiID = :biznesiID")
    , @NamedQuery(name = "Biznesi.findByEmri", query = "SELECT b FROM Biznesi b WHERE b.emri = :emri")})
public class Biznesi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Biznesi_ID")
        @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer biznesiID;
    @Basic(optional = false)
    @Column(name = "Emri")
    private String emri;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "biznesiID")
    private Collection<Shitjet> shitjetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "biznesiID")
    private Collection<Porosite> porositeCollection;
    @JoinColumn(name = "Komuna", referencedColumnName = "K_ID")
    @ManyToOne(optional = false)
    private Komuna komuna;
    @JoinColumn(name = "Lloji", referencedColumnName = "LL_ID")
    @ManyToOne(optional = false)
    private LlojiiBiznesit lloji;
    @JoinColumn(name = "Qyteti", referencedColumnName = "Qyteti_ID")
    @ManyToOne(optional = false)
    private Qyteti qyteti;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "biznesiID")
    private Collection<Faktura> fakturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "biznesiID")
    private Collection<Porosia> porosiaCollection;

    public Biznesi() {
    }

    public Biznesi(Integer biznesiID) {
        this.biznesiID = biznesiID;
    }

    public Biznesi(Integer biznesiID, String emri) {
        this.biznesiID = biznesiID;
        this.emri = emri;
    }

    public Integer getBiznesiID() {
        return biznesiID;
    }

    public void setBiznesiID(Integer biznesiID) {
        this.biznesiID = biznesiID;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    @XmlTransient
    public Collection<Shitjet> getShitjetCollection() {
        return shitjetCollection;
    }

    public void setShitjetCollection(Collection<Shitjet> shitjetCollection) {
        this.shitjetCollection = shitjetCollection;
    }

    @XmlTransient
    public Collection<Porosite> getPorositeCollection() {
        return porositeCollection;
    }

    public void setPorositeCollection(Collection<Porosite> porositeCollection) {
        this.porositeCollection = porositeCollection;
    }

    public Komuna getKomuna() {
        return komuna;
    }

    public void setKomuna(Komuna komuna) {
        this.komuna = komuna;
    }

    public LlojiiBiznesit getLloji() {
        return lloji;
    }

    public void setLloji(LlojiiBiznesit lloji) {
        this.lloji = lloji;
    }

    public Qyteti getQyteti() {
        return qyteti;
    }

    public void setQyteti(Qyteti qyteti) {
        this.qyteti = qyteti;
    }

    @XmlTransient
    public Collection<Faktura> getFakturaCollection() {
        return fakturaCollection;
    }

    public void setFakturaCollection(Collection<Faktura> fakturaCollection) {
        this.fakturaCollection = fakturaCollection;
    }

    @XmlTransient
    public Collection<Porosia> getPorosiaCollection() {
        return porosiaCollection;
    }

    public void setPorosiaCollection(Collection<Porosia> porosiaCollection) {
        this.porosiaCollection = porosiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (biznesiID != null ? biznesiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biznesi)) {
            return false;
        }
        Biznesi other = (Biznesi) object;
        if ((this.biznesiID == null && other.biznesiID != null) || (this.biznesiID != null && !this.biznesiID.equals(other.biznesiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emri;
    }
    
}
