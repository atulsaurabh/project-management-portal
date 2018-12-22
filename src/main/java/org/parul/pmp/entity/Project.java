package org.parul.pmp.entity;

import javax.persistence.*;

@Entity
@Table(name = "ProjectDetails")
public class Project {
    private int project_id;
    private String project_name;
    private String project_keywords;
    private String project_members;
    private String project_type;
    private String project_stage;
    private String project_language;
    private String project_description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_keywords() {
        return project_keywords;
    }

    public void setProject_keywords(String project_keywords) {
        this.project_keywords = project_keywords;
    }

    public String getProject_members() {
        return project_members;
    }

    public void setProject_members(String project_members) {
        this.project_members = project_members;
    }

    public String getProject_type() {
        return project_type;
    }

    public void setProject_type(String project_type) {
        this.project_type = project_type;
    }

    public String getProject_stage() {
        return project_stage;
    }

    public void setProject_stage(String project_stage) {
        this.project_stage = project_stage;
    }

    public String getProject_language() {
        return project_language;
    }

    public void setProject_language(String project_language) {
        this.project_language = project_language;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }
}
