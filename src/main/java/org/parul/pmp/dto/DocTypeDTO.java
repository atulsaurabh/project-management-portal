package org.parul.pmp.dto;

public class DocTypeDTO {
    private long doctypeid;
    private String documentname;

    public long getDoctypeid() { return doctypeid; }

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
