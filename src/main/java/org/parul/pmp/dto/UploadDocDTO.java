package org.parul.pmp.dto;

import org.parul.pmp.entity.Documents;
import org.parul.pmp.entity.GroupDetails;

import java.net.URL;
import java.time.Instant;

public class UploadDocDTO {

    private long uploaddocid;
    private String uploadedby;
    private URL docurl;
    private String description;


    public long getUploaddocid() {
        return uploaddocid;
    }

    public void setUploaddocid(long uploaddocid) {
        this.uploaddocid = uploaddocid;
    }


    public String getUploadedby() {
        return uploadedby;
    }

    public void setUploadedby(String uploadedby) {
        this.uploadedby = uploadedby;
    }

    public URL getDocurl() {
        return docurl;
    }

    public void setDocurl(URL docurl) {
        this.docurl = docurl;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   }
