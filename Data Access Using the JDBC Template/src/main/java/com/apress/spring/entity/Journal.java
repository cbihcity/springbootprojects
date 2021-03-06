package com.apress.spring.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ihhe0417 on 4/26/2017.
 */
public class Journal {

    private Long id;
    private String title;
    private Date created;
    private String summary;

    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    public Journal(Long id, String title, Date created, String summary) {
        this.id = id;
        this.title = title;
        this.created = created;
        this.summary = summary;
    }

    public Journal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCreatedAsShort(){
        return format.format(created);
    }
    public String toString(){
        StringBuilder value = new StringBuilder("* JournalEntry(");
        value.append("Id: ");
        value.append(id);
        value.append(",Title: ");
        value.append(title);
        value.append(",Summary: ");
        value.append(summary);
        value.append(",Created: ");
        value.append(getCreatedAsShort());
        value.append(")");
        return value.toString();
    }
}
