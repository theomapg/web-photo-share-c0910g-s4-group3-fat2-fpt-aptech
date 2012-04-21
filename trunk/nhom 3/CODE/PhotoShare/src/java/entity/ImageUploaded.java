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
@Table(name = "ImageUploaded")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImageUploaded.findAll", query = "SELECT i FROM ImageUploaded i"),
    @NamedQuery(name = "ImageUploaded.findByImageID", query = "SELECT i FROM ImageUploaded i WHERE i.imageID = :imageID"),
    @NamedQuery(name = "ImageUploaded.findByImageName", query = "SELECT i FROM ImageUploaded i WHERE i.imageName = :imageName"),
    @NamedQuery(name = "ImageUploaded.findByImageDescription", query = "SELECT i FROM ImageUploaded i WHERE i.imageDescription = :imageDescription"),
    @NamedQuery(name = "ImageUploaded.findByImageSize", query = "SELECT i FROM ImageUploaded i WHERE i.imageSize = :imageSize"),
    @NamedQuery(name = "ImageUploaded.findByImagePath", query = "SELECT i FROM ImageUploaded i WHERE i.imagePath = :imagePath"),
    @NamedQuery(name = "ImageUploaded.findByImageDate", query = "SELECT i FROM ImageUploaded i WHERE i.imageDate = :imageDate"),
    @NamedQuery(name = "ImageUploaded.findByImageStatus", query = "SELECT i FROM ImageUploaded i WHERE i.imageStatus = :imageStatus")})
public class ImageUploaded implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ImageID")
    private Integer imageID;
    @Column(name = "ImageName")
    private String imageName;
    @Column(name = "ImageDescription")
    private String imageDescription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ImageSize")
    private Double imageSize;
    @Column(name = "ImagePath")
    private String imagePath;
    @Column(name = "ImageDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date imageDate;
    @Column(name = "ImageStatus")
    private Boolean imageStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imageID")
    private List<Comments> commentsList;
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    @ManyToOne(optional = false)
    private Category categoryID;
    @JoinColumn(name = "AlbumID", referencedColumnName = "AlbumID")
    @ManyToOne(optional = false)
    private Album albumID;

    public ImageUploaded() {
    }

    public ImageUploaded(Integer imageID) {
        this.imageID = imageID;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public Double getImageSize() {
        return imageSize;
    }

    public void setImageSize(Double imageSize) {
        this.imageSize = imageSize;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getImageDate() {
        return imageDate;
    }

    public void setImageDate(Date imageDate) {
        this.imageDate = imageDate;
    }

    public Boolean getImageStatus() {
        return imageStatus;
    }

    public void setImageStatus(Boolean imageStatus) {
        this.imageStatus = imageStatus;
    }

    @XmlTransient
    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public Category getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Category categoryID) {
        this.categoryID = categoryID;
    }

    public Album getAlbumID() {
        return albumID;
    }

    public void setAlbumID(Album albumID) {
        this.albumID = albumID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageID != null ? imageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImageUploaded)) {
            return false;
        }
        ImageUploaded other = (ImageUploaded) object;
        if ((this.imageID == null && other.imageID != null) || (this.imageID != null && !this.imageID.equals(other.imageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ImageUploaded[ imageID=" + imageID + " ]";
    }
    
}
