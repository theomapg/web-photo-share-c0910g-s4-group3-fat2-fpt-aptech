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
@Table(name = "Album")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByAlbumID", query = "SELECT a FROM Album a WHERE a.albumID = :albumID"),
    @NamedQuery(name = "Album.findByAlbumName", query = "SELECT a FROM Album a WHERE a.albumName = :albumName"),
    @NamedQuery(name = "Album.findByAlbumDate", query = "SELECT a FROM Album a WHERE a.albumDate = :albumDate"),
    @NamedQuery(name = "Album.findByAlbumQuantity", query = "SELECT a FROM Album a WHERE a.albumQuantity = :albumQuantity"),
    @NamedQuery(name = "Album.findByAlbumStatus", query = "SELECT a FROM Album a WHERE a.albumStatus = :albumStatus")})
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AlbumID")
    private Integer albumID;
    @Column(name = "AlbumName")
    private String albumName;
    @Column(name = "AlbumDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date albumDate;
    @Column(name = "AlbumQuantity")
    private Integer albumQuantity;
    @Column(name = "AlbumStatus")
    private String albumStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "albumID")
    private List<ImageUploaded> imageUploadedList;
    @JoinColumn(name = "emailID", referencedColumnName = "emailID")
    @ManyToOne(optional = false)
    private Acount emailID;

    public Album() {
    }

    public Album(Integer albumID) {
        this.albumID = albumID;
    }

    public Integer getAlbumID() {
        return albumID;
    }

    public void setAlbumID(Integer albumID) {
        this.albumID = albumID;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Date getAlbumDate() {
        return albumDate;
    }

    public void setAlbumDate(Date albumDate) {
        this.albumDate = albumDate;
    }

    public Integer getAlbumQuantity() {
        return albumQuantity;
    }

    public void setAlbumQuantity(Integer albumQuantity) {
        this.albumQuantity = albumQuantity;
    }

    public String getAlbumStatus() {
        return albumStatus;
    }

    public void setAlbumStatus(String albumStatus) {
        this.albumStatus = albumStatus;
    }

    @XmlTransient
    public List<ImageUploaded> getImageUploadedList() {
        return imageUploadedList;
    }

    public void setImageUploadedList(List<ImageUploaded> imageUploadedList) {
        this.imageUploadedList = imageUploadedList;
    }

    public Acount getEmailID() {
        return emailID;
    }

    public void setEmailID(Acount emailID) {
        this.emailID = emailID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (albumID != null ? albumID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.albumID == null && other.albumID != null) || (this.albumID != null && !this.albumID.equals(other.albumID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Album[ albumID=" + albumID + " ]";
    }
    
}
