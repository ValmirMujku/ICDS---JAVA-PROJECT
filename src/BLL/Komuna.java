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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "Komuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Komuna.findAll", query = "SELECT k FROM Komuna k")
    , @NamedQuery(name = "Komuna.findByKId", query = "SELECT k FROM Komuna k WHERE k.kId = :kId")
    , @NamedQuery(name = "Komuna.findByEmri", query = "SELECT k FROM Komuna k WHERE k.emri = :emri")})
public class Komuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "K_ID")
    private Integer kId;
    @Column(name = "Emri")
    private String emri;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "komuna")
    private Collection<Biznesi> biznesiCollection;
    @JoinColumn(name = "Qyteti", referencedColumnName = "Qyteti_ID")
    @ManyToOne(optional = false)
    private Qyteti qyteti;

    public Komuna() {
    }

    public Komuna(Integer kId) {
        this.kId = kId;
    }

    public Integer getKId() {
        return kId;
    }

    public void setKId(Integer kId) {
        this.kId = kId;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    @XmlTransient
    public Collection<Biznesi> getBiznesiCollection() {
        return biznesiCollection;
    }

    public void setBiznesiCollection(Collection<Biznesi> biznesiCollection) {
        this.biznesiCollection = biznesiCollection;
    }

    public Qyteti getQyteti() {
        return qyteti;
    }

    public void setQyteti(Qyteti qyteti) {
        this.qyteti = qyteti;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kId != null ? kId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Komuna)) {
            return false;
        }
        Komuna other = (Komuna) object;
        if ((this.kId == null && other.kId != null) || (this.kId != null && !this.kId.equals(other.kId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emri;
    }
    
}
