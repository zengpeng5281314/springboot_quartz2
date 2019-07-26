package com.channel.zengpeng.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class TestQuartz implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// 获取任务名
		String taskName = context.getJobDetail().getKey().getName();
		// 处理执行任务之后的业务
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(taskName +"   " + sdf.format(new Date()));
	}
}
