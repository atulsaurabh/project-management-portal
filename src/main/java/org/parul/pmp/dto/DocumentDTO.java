package org.parul.pmp.dto;

import org.parul.pmp.entity.Department;
import org.parul.pmp.entity.DocType;

import java.time.Instant;

public class DocumentDTO {
    private long documentid;
    private Instant startuploaddate;
    private Instant enduploaddate;
    private long department;
    private long docType;

    public long getDocumentid() {
        return documentid;
    }

    public void setDocumentid(long documentid) {
        this.documentid = documentid;
    }

    public Instant getStartuploaddate() {
        return startuploaddate;
    }

    public void setStartuploaddate(Instant startuploaddate) {
        this.startuploaddate = startuploaddate;
    }

    public Instant getEnduploaddate() {
        return enduploaddate;
    }

    public void setEnduploaddate(Instant enduploaddate) {
        this.enduploaddate = enduploaddate;
    }

    public long getDepartment() {
        return department;
    }

    public void setDepartment(long department) {
        this.department = department;
    }

    public long getDocType() {
        return docType;
    }

    public void setDocType(long docType) {
        this.docType = docType;
    }
}
