/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luancv_b00973
 */
@Entity
@Table(name = "Acount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acount.findAll", query = "SELECT a FROM Acount a"),
    @NamedQuery(name = "Acount.findByEmailID", query = "SELECT a FROM Acount a WHERE a.emailID = :emailID"),
    @NamedQuery(name = "Acount.findByPasswords", query = "SELECT a FROM Acount a WHERE a.passwords = :passwords"),
    @NamedQuery(name = "Acount.findByGender", query = "SELECT a FROM Acount a WHERE a.gender = :gender"),
    @NamedQuery(name = "Acount.findByBirthday", query = "SELECT a FROM Acount a WHERE a.birthday = :birthday"),
    @NamedQuery(name = "Acount.findByFullname", query = "SELECT a FROM Acount a WHERE a.fullname = :fullname"),
    @NamedQuery(name = "Acount.findByStatus", query = "SELECT a FROM Acount a WHERE a.status = :status"),
    @NamedQuery(name = "Acount.findByAcountDate", query = "SELECT a FROM Acount a WHERE a.acountDate = :acountDate")})
public class Acount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "emailID")
    private String emailID;
    @Column(name = "passwords")
    private String passwords;
    @Column(name = "gender")
    private String gender;
    @Column(name = "birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "AcountDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acountDate;
    @JoinColumn(name = "roleid", referencedColumnName = "roleid")
    @ManyToOne(optional = false)
    private Roles roleid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emailID")
    private List<Album> albumList;

    public Acount() {
    }

    public Acount(String emailID) {
        this.emailID = emailID;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getAcountDate() {
        return acountDate;
    }

    public void setAcountDate(Date acountDate) {
        this.acountDate = acountDate;
    }

    public Roles getRoleid() {
        return roleid;
    }

    public void setRoleid(Roles roleid) {
        this.roleid = roleid;
    }

    @XmlTransient
    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailID != null ? emailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acount)) {
            return false;
        }
        Acount other = (Acount) object;
        if ((this.emailID == null && other.emailID != null) || (this.emailID != null && !this.emailID.equals(other.emailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Acount[ emailID=" + emailID + " ]";
    }
    
}
