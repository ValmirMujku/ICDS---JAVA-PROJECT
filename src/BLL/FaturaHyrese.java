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
@Table(name = "FaturaHyrese")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaturaHyrese.findAll", query = "SELECT f FROM FaturaHyrese f")
    , @NamedQuery(name = "FaturaHyrese.findByFaturaHID", query = "SELECT f FROM FaturaHyrese f WHERE f.faturaHID = :faturaHID")
    , @NamedQuery(name = "FaturaHyrese.findByCmimi", query = "SELECT f FROM FaturaHyrese f WHERE f.cmimi = :cmimi")
    , @NamedQuery(name = "FaturaHyrese.findByData", query = "SELECT f FROM FaturaHyrese f WHERE f.data = :data")
    , @NamedQuery(name = "FaturaHyrese.findByPalete", query = "SELECT f FROM FaturaHyrese f WHERE f.palete = :palete")
    , @NamedQuery(name = "FaturaHyrese.findByPaketa", query = "SELECT f FROM FaturaHyrese f WHERE f.paketa = :paketa")
    , @NamedQuery(name = "FaturaHyrese.findByCope", query = "SELECT f FROM FaturaHyrese f WHERE f.cope = :cope")
    , @NamedQuery(name = "FaturaHyrese.findByDataeSkadences", query = "SELECT f FROM FaturaHyrese f WHERE f.dataeSkadences = :dataeSkadences")})
public class FaturaHyrese implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FaturaH_ID")
        @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer faturaHID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Cmimi")
    private BigDecimal cmimi;
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @Column(name = "Palete")
    private BigDecimal palete;
    @Basic(optional = false)
    @Column(name = "Paketa")
    private BigDecimal paketa;
    @Basic(optional = false)
    @Column(name = "Cope")
    private BigDecimal cope;
    @Basic(optional = false)
    @Column(name = "Data_e_Skadences")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataeSkadences;
    @JoinColumn(name = "Produkti_ID", referencedColumnName = "Produkti_ID")
    @ManyToOne(optional = false)
    private Produkti produktiID;

    public FaturaHyrese() {
    }

    public FaturaHyrese(Integer faturaHID) {
        this.faturaHID = faturaHID;
    }

    public FaturaHyrese(Integer faturaHID, BigDecimal cmimi, BigDecimal palete, BigDecimal paketa, BigDecimal cope, Date dataeSkadences) {
        this.faturaHID = faturaHID;
        this.cmimi = cmimi;
        this.palete = palete;
        this.paketa = paketa;
        this.cope = cope;
        this.dataeSkadences = dataeSkadences;
    }

    public Integer getFaturaHID() {
        return faturaHID;
    }

    public void setFaturaHID(Integer faturaHID) {
        this.faturaHID = faturaHID;
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

    public BigDecimal getPalete() {
        return palete;
    }

    public void setPalete(BigDecimal palete) {
        this.palete = palete;
    }

    public BigDecimal getPaketa() {
        return paketa;
    }

    public void setPaketa(BigDecimal paketa) {
        this.paketa = paketa;
    }

    public BigDecimal getCope() {
        return cope;
    }

    public void setCope(BigDecimal cope) {
        this.cope = cope;
    }

    public Date getDataeSkadences() {
        return dataeSkadences;
    }

    public void setDataeSkadences(Date dataeSkadences) {
        this.dataeSkadences = dataeSkadences;
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
        hash += (faturaHID != null ? faturaHID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FaturaHyrese)) {
            return false;
        }
        FaturaHyrese other = (FaturaHyrese) object;
        if ((this.faturaHID == null && other.faturaHID != null) || (this.faturaHID != null && !this.faturaHID.equals(other.faturaHID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.FaturaHyrese[ faturaHID=" + faturaHID + " ]";
    }
    
}
