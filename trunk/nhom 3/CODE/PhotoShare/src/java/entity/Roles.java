/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
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

/**
 *
 * @author luancv_b00973
 */
@Entity
@Table(name = "Roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByRoleid", query = "SELECT r FROM Roles r WHERE r.roleid = :roleid"),
    @NamedQuery(name = "Roles.findByRoleName", query = "SELECT r FROM Roles r WHERE r.roleName = :roleName")})
public class Roles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "roleid")
    private Integer roleid;
    @Column(name = "roleName")
    private String roleName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleid")
    private List<Acount> acountList;

    public Roles() {
    }

    public Roles(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @XmlTransient
    public List<Acount> getAcountList() {
        return acountList;
    }

    public void setAcountList(List<Acount> acountList) {
        this.acountList = acountList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleid != null ? roleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.roleid == null && other.roleid != null) || (this.roleid != null && !this.roleid.equals(other.roleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Roles[ roleid=" + roleid + " ]";
    }
    
}
