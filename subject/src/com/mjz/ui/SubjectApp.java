package com.mjz.ui;/*
 *@program:subject
 *@author: MaoJizhou
 *@Time: 2021/12/30  16:46
 */

import com.mjz.service.SubjectService;

import java.util.Scanner;

public class SubjectApp
{
    public static void main(String[] args)
    {
        SubjectService subjectService = new SubjectService();
        subjectService.printAll();
        System.out.print("输入你的学号：");
        Scanner scanner = new Scanner(System.in);
        String s_id = scanner.next();
        System.out.print("输入你的姓名：");
        String s_name = scanner.next();
        subjectService.extract(s_id, s_name);
    }
}
