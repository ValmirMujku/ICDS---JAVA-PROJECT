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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "Pozitat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pozitat.findAll", query = "SELECT p FROM Pozitat p")
    , @NamedQuery(name = "Pozitat.findByPozitaID", query = "SELECT p FROM Pozitat p WHERE p.pozitaID = :pozitaID")
    , @NamedQuery(name = "Pozitat.findByEmri", query = "SELECT p FROM Pozitat p WHERE p.emri = :emri")})
public class Pozitat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Pozita_ID")
        @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer pozitaID;
    @Basic(optional = false)
    @Column(name = "Emri")
    private String emri;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pozita")
    private Collection<Punetori> punetoriCollection;

    public Pozitat() {
    }

    public Pozitat(Integer pozitaID) {
        this.pozitaID = pozitaID;
    }

    public Pozitat(Integer pozitaID, String emri) {
        this.pozitaID = pozitaID;
        this.emri = emri;
    }

    public Integer getPozitaID() {
        return pozitaID;
    }

    public void setPozitaID(Integer pozitaID) {
        this.pozitaID = pozitaID;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    @XmlTransient
    public Collection<Punetori> getPunetoriCollection() {
        return punetoriCollection;
    }

    public void setPunetoriCollection(Collection<Punetori> punetoriCollection) {
        this.punetoriCollection = punetoriCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pozitaID != null ? pozitaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pozitat)) {
            return false;
        }
        Pozitat other = (Pozitat) object;
        if ((this.pozitaID == null && other.pozitaID != null) || (this.pozitaID != null && !this.pozitaID.equals(other.pozitaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emri;
    }
    
}
