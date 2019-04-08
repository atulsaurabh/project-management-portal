package org.parul.pmp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "Documents")
public class Documents {
    private long documentid;
    private Instant startuploaddate;
    private Instant enduploaddate;
    private Department department;
    private DocType docType;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="doctypeid")
    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptid")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getDocumentid() {
        return documentid;
    }

    public void setDocumentid(long documentid) {
        this.documentid = documentid;
    }

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    public Instant getStartuploaddate() {
        return startuploaddate;
    }

    public void setStartuploaddate(Instant startuploaddate) {
        this.startuploaddate = startuploaddate;
    }

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    public Instant getEnduploaddate() {
        return enduploaddate;
    }

    public void setEnduploaddate(Instant enduploaddate) {
        this.enduploaddate = enduploaddate;
    }
}
