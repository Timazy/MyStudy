package com.timazy.learn.javaSE.Clazz.management;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/*
*	@author : Rick
*	@date : 2019年4月26日
*	
*/
public class ThreadMXBean_l {

	
	public static void main(String[] args) {
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		if (threadMXBean.isThreadCpuTimeSupported()) {
			long[] ids = threadMXBean.getAllThreadIds();
			for(long id : ids){
				ThreadInfo info = threadMXBean.getThreadInfo(id);
				System.out.println(
						"thread name:"+info.getThreadName()+
						"-thread id:"+info.getThreadId()+
						"-thread lock:"+info.getLockOwnerName()
						);
			}
		}
	}

}
