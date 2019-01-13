package org.parul.pmp.dto;

public class MailDTO {
    private String to;
    private String subject;
    private String link;
    private String password;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public String activationMessage()
    {
        String message="Dear "+name+",\n\n";
        message+="Thank you for selecting PMP. Your account with PMP is created.\n";
        message+="Kindly click on the following link to activate your account with us.\n";
        message+="<a href=\""+link+"\">Click Here</a>\n\n";
        message+="Your credential is as below:\n\n";
        message+="User Name:"+to+"\n";
        message+="Password="+password+"\n";
        message+="Use this credential to login into your account after activation. Please do not share the information or email";
        message+=" to any unauthorized body.\n\n\n";
        message+="Thanks and Regards\n";
        message+="PMP Team";
        return message;

    }
}
