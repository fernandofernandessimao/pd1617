/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fernando
 */
@Entity
@Table(name = "t_reactivacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TReactivacao.findAll", query = "SELECT t FROM TReactivacao t"),
    @NamedQuery(name = "TReactivacao.findById", query = "SELECT t FROM TReactivacao t WHERE t.id = :id"),
    @NamedQuery(name = "TReactivacao.findByPendente", query = "SELECT t FROM TReactivacao t WHERE t.pendente = :pendente"),
    @NamedQuery(name = "TReactivacao.findByAceite", query = "SELECT t FROM TReactivacao t WHERE t.aceite = :aceite"),
    @NamedQuery(name = "TReactivacao.findByDataProc", query = "SELECT t FROM TReactivacao t WHERE t.dataProc = :dataProc"),
    @NamedQuery(name = "TReactivacao.findByRazaoRej", query = "SELECT t FROM TReactivacao t WHERE t.razaoRej = :razaoRej")})
public class TReactivacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pendente")
    private boolean pendente;
    @Column(name = "aceite")
    private Boolean aceite;
    @Column(name = "data_proc")
    @Temporal(TemporalType.DATE)
    private Date dataProc;
    @Size(max = 200)
    @Column(name = "razao_rej")
    private String razaoRej;
    @JoinColumn(name = "utilizadorid", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private TUtilizador utilizadorid;

    public TReactivacao() {
    }

    public TReactivacao(Integer id) {
        this.id = id;
    }

    public TReactivacao(Integer id, boolean pendente) {
        this.id = id;
        this.pendente = pendente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getPendente() {
        return pendente;
    }

    public void setPendente(boolean pendente) {
        this.pendente = pendente;
    }

    public Boolean getAceite() {
        return aceite;
    }

    public void setAceite(Boolean aceite) {
        this.aceite = aceite;
    }

    public Date getDataProc() {
        return dataProc;
    }

    public void setDataProc(Date dataProc) {
        this.dataProc = dataProc;
    }

    public String getRazaoRej() {
        return razaoRej;
    }

    public void setRazaoRej(String razaoRej) {
        this.razaoRej = razaoRej;
    }

    public TUtilizador getUtilizadorid() {
        return utilizadorid;
    }

    public void setUtilizadorid(TUtilizador utilizadorid) {
        this.utilizadorid = utilizadorid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TReactivacao)) {
            return false;
        }
        TReactivacao other = (TReactivacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "local.TReactivacao[ id=" + id + " ]";
    }
    
}
