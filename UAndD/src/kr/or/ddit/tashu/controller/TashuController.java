package kr.or.ddit.tashu.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/tashu/tashuTest.do")
public class TashuController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String apiURL = "https://bikeapp.tashu.or.kr:50041/v1/openapi/station?format=json"; 
		HttpURLConnection con = null;
		
		// 전송하기용 변수
//		OutputStream outputStream = null;
		
		// 수신하기용 변수
		BufferedReader br = null;
        int responseCode;
        
		try {
			URL url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("GET");   // GET방식으로 처리...
			
			con.setUseCaches(false);
			con.setDoOutput(true);
			con.setDoInput(true);

			
			//---------------------------------------------------------------------------------
			// 요청 헤더 작성

	        con.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			con.setRequestProperty("api-token", "fd8aod859twd00ha");

			
			//------------------------------------------------------------------------------------
            // 응답 수신
            responseCode = con.getResponseCode();
			if(responseCode==200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {  // 에러 발생
				System.out.println("error!!!!!!! responseCode= " + responseCode);
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			String inputLine;
			if(br != null) {
				StringBuffer resBuffer = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					resBuffer.append(inputLine);
				}
				br.close();
//				System.out.println(resBuffer.toString());
				response.setCharacterEncoding("utf-8");
				response.setContentType("application/json; charset=utf-8");
				response.getWriter().write(resBuffer.toString());
				response.flushBuffer();
			}
            
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		startOpenAPI(response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void startOpenAPI(HttpServletResponse response) {
		
	}
}
