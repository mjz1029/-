package com.mjz.entity;/*
 *@program:subject
 *@author: MaoJizhou
 *@Time: 2021/12/30  16:18
 */

public class Subject
{
    private int id;//题目编号
    private String name;//题目名
    private String teacher;//老师姓名
    private String contact;//联系方式
    private String s_id;//学号
    private String s_name;//学生姓名

    public Subject(int id, String name, String teacher, String contact, String s_id, String s_name, int status)
    {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.contact = contact;
        this.s_id = s_id;
        this.s_name = s_name;
        this.status = status;
    }

    public Subject()
    {
    }

    public String getTeacher()
    {
        return teacher;
    }

    public void setTeacher(String teacher)
    {
        this.teacher = teacher;
    }

    public String getContact()
    {
        return contact;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public String getS_id()
    {
        return s_id;
    }

    public void setS_id(String s_id)
    {
        this.s_id = s_id;
    }

    public String getS_name()
    {
        return s_name;
    }

    public void setS_name(String s_name)
    {
        this.s_name = s_name;
    }

    private int status;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }
}
