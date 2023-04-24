package com.dboard.myproj.config.interceptor;

import com.dboard.myproj.config.AuthConst;
import com.dboard.myproj.data.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class AdminCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();

        log.info("Admin 체크 인터셉터 실행 {}", requestURI);

        HttpSession session = request.getSession();

        Object attribute = session.getAttribute(AuthConst.LOGIN_MEMBER);
        if (session == null || attribute == null) {
            log.info("미인증 사용자 요청");
            //로그인으로 redirect;

            response.sendRedirect("/?redirectURL=" + requestURI);
            return false;
        }
        Member attribute1 = (Member) attribute;

        log.info("login session 정보 입니다 1~ {}", session);
        log.info("login session 정보 입니다 2~ {}", attribute1.getMember_id());

        if(attribute1.getGrade_id() != AuthConst.ADMIN_MEMBER){
            log.info("권한이 없는 일반 USER 입니다.");
            response.sendRedirect("/?redirectURL=" + requestURI);
            return false;
        }

        return true;

    }
}
