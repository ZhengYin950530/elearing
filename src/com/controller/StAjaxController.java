package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.St;
import com.mapper.StMapper;

@Controller
public class StAjaxController {
	@Autowired
	private StMapper stMapper;
	@RequestMapping("view/selectstudent.do")
	public void getstrCourseInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		St yin = new St();
		HttpSession session = request.getSession();
		yin.setSt_name(request.getParameter("stname"));
		yin.setSt_age(request.getParameter("stage"));
		
		St student = stMapper.getSt(yin);
		//break point for test data was download successfully or not;
		System.out.println(student.getSt_name());
		System.out.println(student.getSt_age());
		
		//request.setAttribute("studentresult", student);
		session.setAttribute("studentresult", student);
		
		PrintWriter out = response.getWriter();
		
		out.print(student.getSt_name());
	}
	
	@RequestMapping("view/insertstudent.do")
	public void insertst(HttpServletRequest request, HttpServletResponse response) throws IOException {
		St yin = new St();
		HttpSession session = request.getSession();
		yin.setSt_id(request.getParameter("stid"));
		yin.setSt_name(request.getParameter("stname"));
		yin.setSt_sex(request.getParameter("stsex"));
		yin.setSt_age(request.getParameter("stage"));
		yin.setSt_tel(request.getParameter("sttel"));
		yin.setSt_address(request.getParameter("staddress"));
		yin.setSt_email(request.getParameter("stemail"));
		St student = stMapper.saveSt(yin);
		//equals a break point for testing the data was inserted to the database successfully or not;
		System.out.println(student.getSt_name());
		System.out.println(student.getSt_age());
		session.setAttribute("studentresult", student);
	}
	
	@RequestMapping("view/updatestudent.do")
	public void updatest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		St yin = new St();
		HttpSession session = request.getSession();
		
		
		yin.setSt_id(request.getParameter("stid"));
		yin.setSt_name(request.getParameter("stname"));
		yin.setSt_sex(request.getParameter("stsex"));
		yin.setSt_age(request.getParameter("stage"));
		yin.setSt_tel(request.getParameter("sttel"));
		yin.setSt_address(request.getParameter("staddress"));
		yin.setSt_email(request.getParameter("stemail"));
		
		
		St student = stMapper.updateSt(yin);

		session.setAttribute("studentresult", student);
	}
	
	@RequestMapping("view/deletestudent.do")
	public void deletest(HttpServletResponse response,HttpServletRequest request) {
		St yin = new St();
		HttpSession session = request.getSession();
		
		yin.setSt_id(request.getParameter("st_id"));
		
		St student = stMapper.deleteSt(yin);
		
		session.setAttribute("studentresult", student);
		
		
	}
}
