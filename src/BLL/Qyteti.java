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
@Table(name = "Qyteti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qyteti.findAll", query = "SELECT q FROM Qyteti q")
    , @NamedQuery(name = "Qyteti.findByQytetiID", query = "SELECT q FROM Qyteti q WHERE q.qytetiID = :qytetiID")
    , @NamedQuery(name = "Qyteti.findByEmri", query = "SELECT q FROM Qyteti q WHERE q.emri = :emri")
    , @NamedQuery(name = "Qyteti.findByZipCode", query = "SELECT q FROM Qyteti q WHERE q.zipCode = :zipCode")})
public class Qyteti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Qyteti_ID")
    private Integer qytetiID;
    @Column(name = "Emri")
    private String emri;
    @Basic(optional = false)
    @Column(name = "Zip_Code")
    private int zipCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qyteti")
    private Collection<Biznesi> biznesiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qyteti")
    private Collection<Klienti> klientiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qyteti")
    private Collection<Komuna> komunaCollection;

    public Qyteti() {
    }

    public Qyteti(Integer qytetiID) {
        this.qytetiID = qytetiID;
    }

    public Qyteti(Integer qytetiID, int zipCode) {
        this.qytetiID = qytetiID;
        this.zipCode = zipCode;
    }

    public Integer getQytetiID() {
        return qytetiID;
    }

    public void setQytetiID(Integer qytetiID) {
        this.qytetiID = qytetiID;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @XmlTransient
    public Collection<Biznesi> getBiznesiCollection() {
        return biznesiCollection;
    }

    public void setBiznesiCollection(Collection<Biznesi> biznesiCollection) {
        this.biznesiCollection = biznesiCollection;
    }

    @XmlTransient
    public Collection<Klienti> getKlientiCollection() {
        return klientiCollection;
    }

    public void setKlientiCollection(Collection<Klienti> klientiCollection) {
        this.klientiCollection = klientiCollection;
    }

    @XmlTransient
    public Collection<Komuna> getKomunaCollection() {
        return komunaCollection;
    }

    public void setKomunaCollection(Collection<Komuna> komunaCollection) {
        this.komunaCollection = komunaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qytetiID != null ? qytetiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Qyteti)) {
            return false;
        }
        Qyteti other = (Qyteti) object;
        if ((this.qytetiID == null && other.qytetiID != null) || (this.qytetiID != null && !this.qytetiID.equals(other.qytetiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emri;
    }
    
}
