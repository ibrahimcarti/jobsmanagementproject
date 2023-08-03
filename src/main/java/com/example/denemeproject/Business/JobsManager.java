/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.denemeproject.Business;
import com.example.denemeproject.DAL.*;
import com.example.denemeproject.Entities.Jobs;
import java.util.ArrayList;

/**
 *
 * @author Ibrahim
 */
public class JobsManager implements IJobsService{

    private IJobsDal jobsdal;
    
    public JobsManager(IJobsDal jobsdal){
    this.jobsdal=jobsdal;
    }
    @Override
    public ArrayList<Jobs> getJobs() {
        return (ArrayList<Jobs>) jobsdal.getJobs();
    }

    @Override
    public ArrayList<Jobs> getJobsById(int id) {
        return (ArrayList<Jobs>) jobsdal.getJobsById(id);
    }

    @Override
    public void add(Jobs job) {
        jobsdal.add(job);
    }

    @Override
    public void delete(int jobid) {
        jobsdal.delete(jobid);
    }

    @Override
    public void update(Jobs job) {
        jobsdal.update(job);
    }
    
}
