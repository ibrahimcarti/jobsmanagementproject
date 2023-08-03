/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.denemeproject.Entities;

import java.time.Instant;
import java.sql.Date;

/**
 *
 * @author Ibrahim
 */
public class Jobs {
    
    private int id;
    private String jobtitle;
    private int giverid;
    private int givenid;
    private Date deadline;
    private String givername;
    private String givenname;
    private int isDone;

    
    public Jobs(){};
    
    public Jobs(int id, String jobtitle,int giverid,int givenid, Date deadline, String givername,String givenname,int isdone){
    this.id=id;
    this.jobtitle=jobtitle;
    this.giverid=giverid;
    this.givenid=givenid;
    this.deadline=deadline;
    this.givername=givername;
    this.givenname=givenname;
    this.isDone=isdone;
    }
    
    //public Jobs(int id, String jobtitle,int giverid,int givenid, Date deadline){
    //this.id=id;
    //this.jobtitle=jobtitle;
    //this.giverid=giverid;
    //this.givenid=givenid;
    //this.deadline=deadline;
    //}
    /**
     * @return the givenid
     */
    public int getGivenid() {
        return givenid;
    }

    /**
     * @return the giverid
     */
    public int getGiverid() {
        return giverid;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the jobtitle
     */
    public String getJobtitle() {
        return jobtitle;
    }

    /**
     * @param givenid the givenid to set
     */
    public void setGivenid(int givenid) {
        this.givenid = givenid;
    }

    /**
     * @param giverid the giverid to set
     */
    public void setGiverid(int giverid) {
        this.giverid = giverid;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param jobtitle the jobtitle to set
     */
    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    /**
     * @return the givennmae
     */
    public String getGivenname() {
        return givenname;
    }

    /**
     * @return the givername
     */
    public String getGivername() {
        return givername;
    }

    /**
     * @param givennmae the givennmae to set
     */
    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    /**
     * @param givername the givername to set
     */
    public void setGivername(String givername) {
        this.givername = givername;
    }

    /**
     * @return the deadline
     */
    public Date getDeadline() {
        return deadline;
    }

    /**
     * @param deadline the deadline to set
     */
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    /**
     * @return the isDone
     */
    public int getIsDone() {
        return isDone;
    }

    /**
     * @param isDone the isDone to set
     */
    public void setIsDone(int isDone) {
        this.isDone = isDone;
    }
    
    
    
    
}
