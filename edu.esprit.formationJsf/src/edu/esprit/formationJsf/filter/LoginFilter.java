package edu.esprit.formationJsf.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.esprit.formationJsf.validator.LoginBean;

//@WebFilter(urlPatterns="/filterPage/*")
@WebFilter("/filterPage/*")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		

	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		
		System.out.println(" url = "+ ((HttpServletRequest) servletRequest).getRequestURL());
		
		HttpServletRequest request=(HttpServletRequest) servletRequest;
		HttpServletResponse response=(HttpServletResponse) servletResponse;
		
		LoginBean loginBean=(LoginBean) request.getSession().getAttribute("loginBean");
		if(loginBean!=null&&loginBean.isLoggedIn()){
			filterChain.doFilter(request, response);
		}
		else if (request.getRequestURL().toString().contains("login.jsf")) {
			filterChain.doFilter(request, response);
			
		}
		else {
			response.sendRedirect(request.getContextPath()+"/filterPage/login.jsf");
		}

//		System.out.println(" url = "
//				+ ((HttpServletRequest) servletRequest).getRequestURL());
//
//		if (((HttpServletRequest) servletRequest).getSession().getAttribute(
//				"connectedUser") != null) {
//
//			if (((HttpServletRequest) servletRequest).getRequestURL()
//					.toString().contains("login.xhtml"))
//				((HttpServletResponse) servletResponse)
//						.sendRedirect("/edu.esprit.formationJsf/filterPage/welcomePage.xhtml");
//			else
//				filterChain.doFilter(servletRequest, servletResponse);
//
//		} else if (!((HttpServletRequest) servletRequest).getRequestURL()
//				.toString().contains("login.xhtml"))
//			((HttpServletResponse) servletResponse)
//					.sendRedirect("/edu.esprit.formationJsf/filterPage/login.xhtml");
//		else
//			filterChain.doFilter(servletRequest, servletResponse);

		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
