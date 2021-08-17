/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
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
@Table(name = "Punetori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Punetori.findAll", query = "SELECT p FROM Punetori p")
    , @NamedQuery(name = "Punetori.findByPId", query = "SELECT p FROM Punetori p WHERE p.pId = :pId")
    , @NamedQuery(name = "Punetori.findByEmri", query = "SELECT p FROM Punetori p WHERE p.emri = :emri")
    , @NamedQuery(name = "Punetori.findByMbiemri", query = "SELECT p FROM Punetori p WHERE p.mbiemri = :mbiemri")
    , @NamedQuery(name = "Punetori.findByMosha", query = "SELECT p FROM Punetori p WHERE p.mosha = :mosha")
    , @NamedQuery(name = "Punetori.findByGjinia", query = "SELECT p FROM Punetori p WHERE p.gjinia = :gjinia")
    , @NamedQuery(name = "Punetori.findByAdresa", query = "SELECT p FROM Punetori p WHERE p.adresa = :adresa")})
public class Punetori implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "P_ID")
        @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer pId;
    @Basic(optional = false)
    @Column(name = "Emri")
    private String emri;
    @Basic(optional = false)
    @Column(name = "Mbiemri")
    private String mbiemri;
    @Basic(optional = false)
    @Column(name = "Mosha")
    private int mosha;
    @Basic(optional = false)
    @Column(name = "Gjinia")
    private Character gjinia;
    @Basic(optional = false)
    @Column(name = "Adresa")
    private String adresa;
    @JoinColumn(name = "Pozita", referencedColumnName = "Pozita_ID")
    @ManyToOne(optional = false)
    private Pozitat pozita;
    @JoinColumn(name = "Punetori_LogIn", referencedColumnName = "U_ID")
    @ManyToOne
    private Users punetoriLogIn;

    public Punetori() {
    }

    public Punetori(Integer pId) {
        this.pId = pId;
    }

    public Punetori(Integer pId, String emri, String mbiemri, int mosha, Character gjinia, String adresa) {
        this.pId = pId;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.mosha = mosha;
        this.gjinia = gjinia;
        this.adresa = adresa;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public int getMosha() {
        return mosha;
    }

    public void setMosha(int mosha) {
        this.mosha = mosha;
    }

    public Character getGjinia() {
        return gjinia;
    }

    public void setGjinia(Character gjinia) {
        this.gjinia = gjinia;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Pozitat getPozita() {
        return pozita;
    }

    public void setPozita(Pozitat pozita) {
        this.pozita = pozita;
    }

    public Users getPunetoriLogIn() {
        return punetoriLogIn;
    }

    public void setPunetoriLogIn(Users punetoriLogIn) {
        this.punetoriLogIn = punetoriLogIn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pId != null ? pId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Punetori)) {
            return false;
        }
        Punetori other = (Punetori) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Punetori[ pId=" + pId + " ]";
    }
    
}
