package com.channel.zengpeng.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.channel.zengpeng.job.TestQuartz;
import com.channel.zengpeng.service.QuartzJobManager;

@Controller
@RequestMapping("/job")
public class JobController {

	 @Autowired
	    QuartzJobManager quartzJobManager;


	    @GetMapping("/add")
	    public void add(HttpServletRequest request) {
	    	//任务名称
	        String name = request.getParameter("name");
	        //任务组名称
	        String groupName = "task";
	        //cron表达式
	        String cron = "0 0/1 * * * ?";
	        //需要给任务携带的参数
	        Map<String, Object> map = new HashMap<>();
	        map.put("name", "张三");
	        map.put("sex", "0");
	        quartzJobManager.addJob(TestQuartz.class, name, groupName, cron, map);
	    }

	    @GetMapping("/del")
	    public void del(HttpServletRequest request) {
	        String name = request.getParameter("name");
	        String groupName = "task";
	        quartzJobManager.deleteJob(name, groupName);
	    }    
}
