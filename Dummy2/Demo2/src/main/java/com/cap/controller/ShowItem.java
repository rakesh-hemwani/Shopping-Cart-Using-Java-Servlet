package com.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//@WebServlet("/ShowItem")
public class ShowItem extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 	
	{
		PrintWriter pw=response.getWriter();	
		
		HttpSession hs=request.getSession(true);
		
		
		Enumeration e=hs.getAttributeNames();
		pw.println("<h1 align='center'>Total Items In Cart</h1>");
		pw.println("<table border=2 align='center'>");
		pw.println("<tr><th>ItemName</th><th>Quantity</th></tr>");
		
		if(e.hasMoreElements()){
			TreeMap<String,String> tm=new  TreeMap<String,String>(); 
			Set set;
			Iterator itr;
		
			while(e.hasMoreElements())
		{		
			String key=(String)e.nextElement();
			String value=(String)hs.getAttribute(key);
			tm.put(key, value);	 
			//System.out.println(tm);
		}
			 set=tm.entrySet();
				itr=set.iterator();
				while(itr.hasNext())//(map->key,value)
				{
				Map.Entry e1= (Map.Entry)itr.next();
				pw.println("<tr><td>"+e1.getKey()+"</td>");
				pw.println("<td>"+e1.getValue()+"</td></tr>");
		}
		}
		else
		{
			pw.println("Add items first");
		}
	}
}