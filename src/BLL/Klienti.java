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
@Table(name = "Klienti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klienti.findAll", query = "SELECT k FROM Klienti k")
    , @NamedQuery(name = "Klienti.findByKId", query = "SELECT k FROM Klienti k WHERE k.kId = :kId")
    , @NamedQuery(name = "Klienti.findByEmri", query = "SELECT k FROM Klienti k WHERE k.emri = :emri")
    , @NamedQuery(name = "Klienti.findByMbiemri", query = "SELECT k FROM Klienti k WHERE k.mbiemri = :mbiemri")
    , @NamedQuery(name = "Klienti.findByMosha", query = "SELECT k FROM Klienti k WHERE k.mosha = :mosha")
    , @NamedQuery(name = "Klienti.findByGjinia", query = "SELECT k FROM Klienti k WHERE k.gjinia = :gjinia")})
public class Klienti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "K_ID")
        @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer kId;
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
    @JoinColumn(name = "Qyteti", referencedColumnName = "Qyteti_ID")
    @ManyToOne(optional = false)
    private Qyteti qyteti;
    @JoinColumn(name = "Klienti_LogIn", referencedColumnName = "U_ID")
    @ManyToOne(optional = false)
    private Users klientiLogIn;

    public Klienti() {
    }

    public Klienti(Integer kId) {
        this.kId = kId;
    }

    public Klienti(Integer kId, String emri, String mbiemri, int mosha, Character gjinia) {
        this.kId = kId;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.mosha = mosha;
        this.gjinia = gjinia;
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

    public Qyteti getQyteti() {
        return qyteti;
    }

    public void setQyteti(Qyteti qyteti) {
        this.qyteti = qyteti;
    }

    public Users getKlientiLogIn() {
        return klientiLogIn;
    }

    public void setKlientiLogIn(Users klientiLogIn) {
        this.klientiLogIn = klientiLogIn;
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
        if (!(object instanceof Klienti)) {
            return false;
        }
        Klienti other = (Klienti) object;
        if ((this.kId == null && other.kId != null) || (this.kId != null && !this.kId.equals(other.kId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Klienti[ kId=" + kId + " ]";
    }
    
}
