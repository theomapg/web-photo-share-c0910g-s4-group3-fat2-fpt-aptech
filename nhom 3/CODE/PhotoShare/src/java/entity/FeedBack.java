/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luancv_b00973
 */
@Entity
@Table(name = "FeedBack")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FeedBack.findAll", query = "SELECT f FROM FeedBack f"),
    @NamedQuery(name = "FeedBack.findByFeedBackID", query = "SELECT f FROM FeedBack f WHERE f.feedBackID = :feedBackID"),
    @NamedQuery(name = "FeedBack.findByFeedBack", query = "SELECT f FROM FeedBack f WHERE f.feedBack = :feedBack"),
    @NamedQuery(name = "FeedBack.findByFeedBackStatus", query = "SELECT f FROM FeedBack f WHERE f.feedBackStatus = :feedBackStatus"),
    @NamedQuery(name = "FeedBack.findByFeedBackDate", query = "SELECT f FROM FeedBack f WHERE f.feedBackDate = :feedBackDate"),
    @NamedQuery(name = "FeedBack.findByEmail", query = "SELECT f FROM FeedBack f WHERE f.email = :email")})
public class FeedBack implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FeedBackID")
    private Integer feedBackID;
    @Column(name = "FeedBack")
    private String feedBack;
    @Column(name = "FeedBackStatus")
    private Boolean feedBackStatus;
    @Column(name = "FeedBackDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feedBackDate;
    @Column(name = "email")
    private String email;

    public FeedBack() {
    }

    public FeedBack(Integer feedBackID) {
        this.feedBackID = feedBackID;
    }

    public Integer getFeedBackID() {
        return feedBackID;
    }

    public void setFeedBackID(Integer feedBackID) {
        this.feedBackID = feedBackID;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public Boolean getFeedBackStatus() {
        return feedBackStatus;
    }

    public void setFeedBackStatus(Boolean feedBackStatus) {
        this.feedBackStatus = feedBackStatus;
    }

    public Date getFeedBackDate() {
        return feedBackDate;
    }

    public void setFeedBackDate(Date feedBackDate) {
        this.feedBackDate = feedBackDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feedBackID != null ? feedBackID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FeedBack)) {
            return false;
        }
        FeedBack other = (FeedBack) object;
        if ((this.feedBackID == null && other.feedBackID != null) || (this.feedBackID != null && !this.feedBackID.equals(other.feedBackID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FeedBack[ feedBackID=" + feedBackID + " ]";
    }
    
}
