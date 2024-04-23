package kr.or.ddit.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;

@WebServlet("/notice/hit.do")
public class NoticeHitUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	int noticeNo = Integer.parseInt(request.getParameter("noticeNo")); // 파라미터 이름 수정

        INoticeService service = NoticeServiceImpl.getInstance();

        int hitUpdateResult = service.updateHits(noticeNo);

        // JSON 형태로 응답하기 위해 Content Type 설정
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 응답 정보를 JSON으로 작성
        PrintWriter out = response.getWriter();
        if (hitUpdateResult > 0) {
            // 조회수 업데이트 성공 시 'success'를 응답으로 보냄
            out.print("{\"result\": \"success\"}");
        } else {
            // 조회수 업데이트 실패 시 'fail'을 응답으로 보냄
            out.print("{\"result\": \"fail\"}");
        }
        out.flush();
    	
	}

}
