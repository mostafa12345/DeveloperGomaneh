/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author administrator
 */
@Entity
@Table(name = "Portfolio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Portfolio.findAll", query = "SELECT p FROM Portfolio p"),
    @NamedQuery(name = "Portfolio.findById", query = "SELECT p FROM Portfolio p WHERE p.id = :id"),
    @NamedQuery(name = "Portfolio.findByTitle", query = "SELECT p FROM Portfolio p WHERE p.title = :title"),
    @NamedQuery(name = "Portfolio.findByDescribtion", query = "SELECT p FROM Portfolio p WHERE p.describtion = :describtion"),
    @NamedQuery(name = "Portfolio.findByUrl", query = "SELECT p FROM Portfolio p WHERE p.url = :url"),
    @NamedQuery(name = "Portfolio.findByVisit", query = "SELECT p FROM Portfolio p WHERE p.visit = :visit"),
    @NamedQuery(name = "Portfolio.findByFinished", query = "SELECT p FROM Portfolio p WHERE p.finished = :finished"),
    @NamedQuery(name = "Portfolio.findByPortfolioCategoryid", query = "SELECT p FROM Portfolio p WHERE p.portfolioCategoryid = :portfolioCategoryid"),
    @NamedQuery(name = "Portfolio.findByPercent", query = "SELECT p FROM Portfolio p WHERE p.percent = :percent"),
    @NamedQuery(name = "Portfolio.findByCreatedAt", query = "SELECT p FROM Portfolio p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "Portfolio.findByUpdatedAt", query = "SELECT p FROM Portfolio p WHERE p.updatedAt = :updatedAt")})
public class Portfolio implements Serializable {

    @OneToMany(mappedBy = "potfolioid")
    private Collection<ProtfolioImg> protfolioImgCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    @Size(max = 3000)
    @Column(name = "`describtion`")
    private String describtion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "`url`")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Column(name = "`visit`")
    private int visit;
    @Column(name = "finished")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finished;
    @JoinColumn(name = "PortfolioCategory_id")
    @NotNull
    private PortfolioCategory portfolioCategoryid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "`percent`")
    private int percent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "img" , nullable = false)
    private String img;

    public Collection<String> getImg() {
        List<String> list=new ArrayList<>();
        list.addAll(Arrays.asList(img.split(";")));
        return list;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Portfolio() {
    }

    public Portfolio(Integer id) {
        this.id = id;
    }

    public Portfolio(Integer id, String title, String url, int visit, int percent, Date createdAt) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.visit = visit;
        this.percent = percent;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getVisit() {
        return visit;
    }

    public void setVisit(int visit) {
        this.visit = visit;
    }

    public Date getFinished() {
        return finished;
    }

    public void setFinished(Date finished) {
        this.finished = finished;
    }

    public PortfolioCategory getPortfolioCategoryid() {
        return portfolioCategoryid;
    }

    public void setPortfolioCategoryid(PortfolioCategory portfolioCategoryid) {
        this.portfolioCategoryid = portfolioCategoryid;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
        if (!(object instanceof Portfolio)) {
            return false;
        }
        Portfolio other = (Portfolio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Portfolio[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<ProtfolioImg> getProtfolioImgCollection() {
        return protfolioImgCollection;
    }

    public void setProtfolioImgCollection(Collection<ProtfolioImg> protfolioImgCollection) {
        this.protfolioImgCollection = protfolioImgCollection;
    }

        @PrePersist
    public void SetDateTime(){
        this.createdAt = new Date();
    }
    
    @PreUpdate
    public void setDateTimeUpdate(){
        this.updatedAt = new Date();
    }
}