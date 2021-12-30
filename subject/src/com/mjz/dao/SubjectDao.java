package com.mjz.dao;/*
 *@program:subject
 *@author: MaoJizhou
 *@Time: 2021/12/30  16:15
 */

import com.mjz.entity.Subject;
import com.mjz.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao
{
    public void update(Subject subject)
    {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        int subId = subject.getId();
        String s_id = subject.getS_id();
        String s_name = subject.getS_name();
        int status = subject.getStatus();
        String sql = "update subject.t_subject set s_id=? , s_name=? , status = ? where id=?";
        try
        {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, s_id);
            preparedStatement.setString(2, s_name);
            preparedStatement.setInt(3, status);
            preparedStatement.setInt(4, subId);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        } finally
        {
            JDBCUtil.close(connection, preparedStatement);
        }
    }

    public Subject getById(int id)
    {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "select * from subject.t_subject where id = ?";
        Subject subject = null;
        ResultSet resultSet = null;
        try
        {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                subject = new Subject();
                subject.setId(resultSet.getInt("id"));//题目编号
                subject.setName(resultSet.getString("name"));//题目名
                subject.setTeacher(resultSet.getString("teacher"));//老师姓名
                subject.setContact(resultSet.getString("contact"));//联系方式
                subject.setS_id(resultSet.getString("s_id"));//学号
                subject.setS_name(resultSet.getString("s_name"));//学生姓名
                subject.setStatus(resultSet.getInt("status"));//选课状态
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        } finally
        {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
        return subject;
    }

    public List<Integer> getFreeIds()
    {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "select * from subject.t_subject where status = 0";
        List<Integer> list = new ArrayList<Integer>();
        ResultSet resultSet = null;
        try
        {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                list.add(resultSet.getInt("id"));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        } finally
        {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
        return list;
    }

    public Subject getByS_id(String s_id)
    {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "select * from subject.t_subject where s_id = ?";
        ResultSet resultSet = null;
        Subject subject = null;
        try
        {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, s_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                subject = new Subject();
                subject.setId(resultSet.getInt("id"));
                subject.setName(resultSet.getString("name"));
                subject.setTeacher(resultSet.getString("teacher"));
                subject.setContact(resultSet.getString("contact"));
                subject.setS_id(resultSet.getString("s_id"));
                subject.setS_name(resultSet.getString("s_name"));
                subject.setStatus(resultSet.getInt("status"));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        } finally
        {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
        return subject;
    }

    public List<Subject> QueryAll()
    {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "select * from subject.t_subject";
        ResultSet resultSet = null;
        Subject subject = null;
        List<Subject> list = new ArrayList<Subject>();
        try
        {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                subject = new Subject();
                subject.setId(resultSet.getInt("id"));
                subject.setName(resultSet.getString("name"));
                subject.setTeacher(resultSet.getString("teacher"));
                subject.setContact(resultSet.getString("contact"));
                subject.setS_id(resultSet.getString("s_id"));
                subject.setS_name(resultSet.getString("s_name"));
                subject.setStatus(resultSet.getInt("status"));
                list.add(subject);
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        } finally
        {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
        return list;
    }
}
