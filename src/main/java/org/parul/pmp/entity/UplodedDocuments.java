package org.parul.pmp.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class UplodedDocuments {
    private long uploaddocid;
    private Instant uploadeddate;
    private String uploadedby;
    private String docurl;
    private boolean approved;
    private String description;
    private Documents documents;
    private GroupDetails groupDetails;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectGroup")
    public GroupDetails getGroupDetails() {
        return groupDetails;
    }

    public void setGroupDetails(GroupDetails groupDetails) {
        this.groupDetails = groupDetails;
    }

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "documentType")
    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getUploaddocid() {
        return uploaddocid;
    }

    public void setUploaddocid(long uploaddocid) {
        this.uploaddocid = uploaddocid;
    }

    public Instant getUploadeddate() {
        return uploadeddate;
    }

    public void setUploadeddate(Instant uploadeddate) {
        this.uploadeddate = uploadeddate;
    }

    public String getUploadedby() {
        return uploadedby;
    }

    public void setUploadedby(String uploadedby) {
        this.uploadedby = uploadedby;
    }

    public String getDocurl() {
        return docurl;
    }

    public void setDocurl(String docurl) {
        this.docurl = docurl;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
