/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.denemeproject.DAL;

import com.example.denemeproject.Entities.Jobs;
import java.util.ArrayList;

/**
 *
 * @author Ibrahim
 */
public interface IJobsDal {
    ArrayList<Jobs> getJobs();
    ArrayList<Jobs> getJobsById(int id);
    void add(Jobs job);
    void delete(int jobid);
    void update(Jobs job);
    
}
