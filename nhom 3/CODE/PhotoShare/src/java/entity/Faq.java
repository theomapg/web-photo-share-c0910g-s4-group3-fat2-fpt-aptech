/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luancv_b00973
 */
@Entity
@Table(name = "FAQ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faq.findAll", query = "SELECT f FROM Faq f"),
    @NamedQuery(name = "Faq.findByFaqID", query = "SELECT f FROM Faq f WHERE f.faqID = :faqID"),
    @NamedQuery(name = "Faq.findByFaqQuestion", query = "SELECT f FROM Faq f WHERE f.faqQuestion = :faqQuestion"),
    @NamedQuery(name = "Faq.findByFaqAnswer", query = "SELECT f FROM Faq f WHERE f.faqAnswer = :faqAnswer")})
public class Faq implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FaqID")
    private Integer faqID;
    @Column(name = "FaqQuestion")
    private String faqQuestion;
    @Column(name = "FaqAnswer")
    private String faqAnswer;

    public Faq() {
    }

    public Faq(Integer faqID) {
        this.faqID = faqID;
    }

    public Integer getFaqID() {
        return faqID;
    }

    public void setFaqID(Integer faqID) {
        this.faqID = faqID;
    }

    public String getFaqQuestion() {
        return faqQuestion;
    }

    public void setFaqQuestion(String faqQuestion) {
        this.faqQuestion = faqQuestion;
    }

    public String getFaqAnswer() {
        return faqAnswer;
    }

    public void setFaqAnswer(String faqAnswer) {
        this.faqAnswer = faqAnswer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faqID != null ? faqID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faq)) {
            return false;
        }
        Faq other = (Faq) object;
        if ((this.faqID == null && other.faqID != null) || (this.faqID != null && !this.faqID.equals(other.faqID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Faq[ faqID=" + faqID + " ]";
    }
    
}
