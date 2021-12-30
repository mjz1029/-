package com.mjz.service;/*
 *@program:subject
 *@author: MaoJizhou
 *@Time: 2021/12/30  16:19
 */

import com.mjz.dao.SubjectDao;
import com.mjz.entity.Subject;

import java.util.Collections;
import java.util.List;

public class SubjectService
{
    private final SubjectDao subjectDao = new SubjectDao();

    public void printAll()
    {
        List<Subject> list = subjectDao.QueryAll();
        System.out.println("所有题目如下：");
        for (int i = 0; i < list.size(); i++)
        {
            Subject subject = list.get(i);
            System.out.println(subject.getId() + "\t" + subject.getName() + "\t" + subject.getTeacher() + "\t");
        }
    }

    public void extract(String s_id, String name)
    {
        Subject subject = subjectDao.getByS_id(s_id);
        if (subject != null)
        {
            System.out.println("欢迎你，" + subject.getS_id());
            System.out.println("你被分配到的课题编号为：" + subject.getId() + " 课题名为：" + subject.getName());
            System.out.println("出题老师为：" + subject.getTeacher() + " 老师联系方式为：" + subject.getContact());
        } else
        {
            List<Integer> freeIds = subjectDao.getFreeIds();
            if (freeIds.size() == 0)
            {
                System.out.println("没有课程可选！");
                return;
            }
            int maxId = Collections.max(freeIds);
            int randomNumber = 0;   //随机数
            while (true)
            {
                randomNumber = (int) (Math.random() * maxId + 1);
                if (freeIds.contains(randomNumber))
                {
                    break;
                }
            }
            subject = subjectDao.getById(randomNumber);
            subject.setS_id(s_id);
            subject.setS_name(name);
            subject.setStatus(1);
            System.out.println("你被分配到的课题编号为：" + subject.getId() + " 课题名为：" + subject.getName());
            System.out.println("出题老师为：" + subject.getTeacher() + " 老师联系方式为：" + subject.getContact());
            subjectDao.update(subject);
        }
    }
}
