package org.parul.pmp.dto;

import org.parul.pmp.entity.Documents;
import org.parul.pmp.entity.GroupDetails;

import java.time.Instant;

public class UploadDocDTO {
    private long uploaddocid;
    private Instant uploadeddate;
    private String uploadedby;
    private String docurl;
    private boolean approved;
    private String description;
    private long documents;
    private long groupDetails;
    private byte[] data;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

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

    public long getDocuments() {
        return documents;
    }

    public void setDocuments(long documents) {
        this.documents = documents;
    }

    public long getGroupDetails() {
        return groupDetails;
    }

    public void setGroupDetails(long groupDetails) {
        this.groupDetails = groupDetails;
    }
}
