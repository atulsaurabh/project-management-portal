package org.parul.pmp.entity;

import javax.persistence.*;

@Entity
@Table(name = "docType")
public class DocType {
    private long doctypeid;
    private String documentname;
    /*private Documents documents;

    @OneToOne
    @JoinColumn(name = "documentid")
    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getDoctypeid() {
        return doctypeid;
    }

    public void setDoctypeid(long doctypeid) {
        this.doctypeid = doctypeid;
    }


    public String getDocumentname() {
        return documentname;
    }

    public void setDocumentname(String documentname) {
        this.documentname = documentname;
    }
}
