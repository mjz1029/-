package com.mjz.util;/*
 *@program:subject
 *@author: MaoJizhou
 *@Time: 2021/12/30  14:28
 */

import java.sql.*;

public class JDBCUtil
{
    static
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/subject?useUnicode=true","root","mysql123");
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection, PreparedStatement preparedStatement)
    {
        if (connection != null)
        {
            try
            {
                connection.close();
            } catch (SQLException throwable)
            {
                throwable.printStackTrace();
            }
        }
        if (preparedStatement != null)
        {
            try
            {
                preparedStatement.close();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet)
    {
        if (resultSet != null)
        {
            try
            {
                resultSet.close();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }
        close(connection, preparedStatement);
    }

}
