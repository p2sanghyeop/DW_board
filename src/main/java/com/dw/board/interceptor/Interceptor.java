package com.dw.board.interceptor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dw.board.service.LogService;
import com.dw.board.vo.LogVO;
//Component : 내가 직접 작성한 클래스를 스프링에게 빈(스프링이 관리하는 클래스)으로 등록하라는 뜻
@Component
public class Interceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);
	
	
	@Autowired 
	private LogService logservice;
	
	@Override
	//preHandle 컨트롤러에 도착하기 전에 요청을 가로채는 함수
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		String ip = request.getHeader("X-forwarded-For");
		String httpMethod = request.getMethod();
		if(ip == null) ip = request.getRemoteAddr();
		
		logger.info("client IP->"+ip);
		logger.info("client url->"+url);
		logger.info("client http method->"+httpMethod);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);//한국시간으로 강제로 맞춤
		String time = formatter.format(Calendar.getInstance().getTime());
		logger.info("time->"+time);
		LogVO vo = new LogVO();
		vo.setUrl(url);
		vo.setIp(ip);
		vo.setHttpMethod(httpMethod);
		vo.setCreateAt(time);
		vo.setLatitude("36.3286904");
		vo.setLongitude("127.4229992");
		logservice.setLog(vo);
		
		//세션체크
		HttpSession session = request.getSession();
		if(session.getAttribute("studentsId") != null) {
		int studentsId = (int)session.getAttribute("studentsId");
		String studentName = (String)session.getAttribute("studentsName");
		System.out.println("id-->"+studentsId);
		System.out.println("name-->"+studentName);
		}
		
		if(session.getAttribute("studentsId") == null) {
			response.sendRedirect("/login");//세션에 값이 없으면 login 다시 실행
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
	
	
}
