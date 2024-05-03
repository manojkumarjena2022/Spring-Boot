package com.mj.inteceptor;

import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TimeoutCheckInteceptor implements HandlerInterceptor {
	public TimeoutCheckInteceptor() {
		System.out.println("TimeoutCheckInteceptor.TimeoutCheckInteceptor()");
	}
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		//check the timing
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		if (hour < 9 || hour > 17) {
			RequestDispatcher rd=req.getRequestDispatcher("/timeout.jsp");
			rd.forward(req, res);
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("TimeoutCheckInteceptor.postHandle()");
		// Log information about the request or manipulate the model
		// Adding additional model attributes
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("TimeoutCheckInteceptor.afterCompletion()");
		// Log information or perform cleanup tasks
		// Release resources if any
	}
}
