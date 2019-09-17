package com.hz.dao;

import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;


public class Test {
	public static void main(String[] args) {
		Properties p=new Properties();
		try {
			Reader r=new FileReader("C:/Users/Administrator/Workspaces/MyEclipse Professional 2014/book/db.properties");
			p.load(r);
			System.out.println(p.get("db_driver"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
