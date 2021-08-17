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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "Lloji_i_Biznesit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LlojiiBiznesit.findAll", query = "SELECT l FROM LlojiiBiznesit l")
    , @NamedQuery(name = "LlojiiBiznesit.findByLlId", query = "SELECT l FROM LlojiiBiznesit l WHERE l.llId = :llId")
    , @NamedQuery(name = "LlojiiBiznesit.findByEmri", query = "SELECT l FROM LlojiiBiznesit l WHERE l.emri = :emri")})
public class LlojiiBiznesit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LL_ID")
    private Integer llId;
    @Basic(optional = false)
    @Column(name = "Emri")
    private String emri;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lloji")
    private Collection<Biznesi> biznesiCollection;

    public LlojiiBiznesit() {
    }

    public LlojiiBiznesit(Integer llId) {
        this.llId = llId;
    }

    public LlojiiBiznesit(Integer llId, String emri) {
        this.llId = llId;
        this.emri = emri;
    }

    public Integer getLlId() {
        return llId;
    }

    public void setLlId(Integer llId) {
        this.llId = llId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (llId != null ? llId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LlojiiBiznesit)) {
            return false;
        }
        LlojiiBiznesit other = (LlojiiBiznesit) object;
        if ((this.llId == null && other.llId != null) || (this.llId != null && !this.llId.equals(other.llId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emri;
    }
    
}
