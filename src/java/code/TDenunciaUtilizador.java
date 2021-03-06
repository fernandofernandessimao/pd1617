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
@Table(name = "t_denuncia_utilizador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TDenunciaUtilizador.findAll", query = "SELECT t FROM TDenunciaUtilizador t"),
    @NamedQuery(name = "TDenunciaUtilizador.findById", query = "SELECT t FROM TDenunciaUtilizador t WHERE t.id = :id"),
    @NamedQuery(name = "TDenunciaUtilizador.findByRazao", query = "SELECT t FROM TDenunciaUtilizador t WHERE t.razao = :razao"),
    @NamedQuery(name = "TDenunciaUtilizador.findByDataDen", query = "SELECT t FROM TDenunciaUtilizador t WHERE t.dataDen = :dataDen")})
public class TDenunciaUtilizador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "razao")
    private String razao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_den")
    @Temporal(TemporalType.DATE)
    private Date dataDen;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private TUtilizador username;

    public TDenunciaUtilizador() {
    }

    public TDenunciaUtilizador(Integer id) {
        this.id = id;
    }

    public TDenunciaUtilizador(Integer id, String razao, Date dataDen) {
        this.id = id;
        this.razao = razao;
        this.dataDen = dataDen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public Date getDataDen() {
        return dataDen;
    }

    public void setDataDen(Date dataDen) {
        this.dataDen = dataDen;
    }

    public TUtilizador getUsername() {
        return username;
    }

    public void setUsername(TUtilizador username) {
        this.username = username;
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
        if (!(object instanceof TDenunciaUtilizador)) {
            return false;
        }
        TDenunciaUtilizador other = (TDenunciaUtilizador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "local.TDenunciaUtilizador[ id=" + id + " ]";
    }
    
}
