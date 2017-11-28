package com.github.liurui.springdemo.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean ok;
    private Date createDate;
    private Date updateDate;

    public Log() {
    }

    public Log(boolean ok, Date createDate, Date updateDate) {
        this.ok = ok;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", ok=" + ok +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
