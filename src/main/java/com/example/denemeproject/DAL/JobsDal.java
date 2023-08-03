/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.denemeproject.DAL;

import com.example.denemeproject.Entities.Jobs;
import com.example.denemeproject.Entities.Users;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ibrahim
 */
public class JobsDal implements IJobsDal {

    private Connection connection;

    public JobsDal() {
        connection = DbHelper.getConnection();
    }

    @Override
    public ArrayList<Jobs> getJobs() {
        String query = "SELECT j.id, j.jobtitle, j.giverid, j.givenid,j.deadline,j.givername,j.givenname, ugiver.username AS givername, ugiven.username AS givenname, j.isDone "
                + "FROM jobs j "
                + "INNER JOIN users ugiver ON j.giverid = ugiver.id "
                + "INNER JOIN users ugiven ON j.givenid = ugiven.id "
                ;
        ResultSet resultSet;
        ArrayList<Jobs> jobs = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            jobs = new ArrayList<Jobs>();
            while (resultSet.next()) {
                jobs.add(new Jobs(resultSet.getInt("ID"),
                        resultSet.getString("jobtitle"),
                        resultSet.getInt("giverid"),
                        resultSet.getInt("givenid"),
                        resultSet.getDate("deadline"),
                        resultSet.getString("givenname"),
                        resultSet.getString("givername"),
                        resultSet.getInt("isDone")
                ));
            }
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return jobs;
    }

    @Override
    public ArrayList<Jobs> getJobsById(int id) {
        ArrayList<Jobs> jobs = new ArrayList<>();
        String query = "SELECT j.id, j.jobtitle, j.giverid, j.givenid,j.deadline,j.givername,j.givenname, ugiver.username AS givername, ugiven.username AS givenname, j.isDone "
                + "FROM jobs j "
                + "INNER JOIN users ugiver ON j.giverid = ugiver.id "
                + "INNER JOIN users ugiven ON j.givenid = ugiven.id "
                + "WHERE j.givenid = ? ";
        ResultSet resultSet;

        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int jobid = resultSet.getInt("id");
                String jobtitle = resultSet.getString("jobtitle");
                int giverid = resultSet.getInt("giverid");
                int givenid = resultSet.getInt("givenid");
                Date deadline = resultSet.getDate("deadline");
                String givername = resultSet.getString("givername");
                String givenname = resultSet.getString("givenname");
                int isdone = resultSet.getInt("isDone");

                jobs.add(new Jobs(jobid, jobtitle, giverid, givenid, deadline, givername,givenname, isdone));
            }
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return jobs;
    }

    @Override
    public void add(Jobs job) {
        String query = "INSERT INTO jobs (jobtitle, giverid, givenid, deadline, givername,givenname,isDone) VALUES (?,?,?,?,?,?,0)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, job.getJobtitle());
            statement.setInt(2,job.getGiverid());
            statement.setInt(3, job.getGivenid());
            statement.setDate(4, (Date) job.getDeadline());
            statement.setString(5, job.getGivername());
            statement.setString(6, job.getGivenname());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(int jobid) {
        String query = "DELETE FROM jobs WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, jobid);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Jobs job) {
        String query = "UPDATE jobs SET jobtitle = ?, giverid = ?, givenid=?, deadline=?, givername=?,givenname=?,isDone=? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, job.getJobtitle());
            statement.setInt(2,job.getGiverid());
            statement.setInt(3, job.getGivenid());
            statement.setDate(4, (Date) job.getDeadline());
            statement.setString(5, job.getGivername());
            statement.setString(6, job.getGivenname());
            statement.setInt(7, job.getIsDone());
            statement.setInt(8, job.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
