package hello.servlet.web.servlet;


import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//회원등록 용 이름과 나이 만!
@WebServlet(name = "memberFormServlet",urlPatterns = "/servlet/members/new-form")
public class MemberFormServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //HTTP 메세지 응답으로 HTML이 나올 것이니깐 content body잡아주기!

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        //불편해 불편해 불편해!! 왜냐고? 자바코드로 입력해야해서 그래!!!
        PrintWriter w = response.getWriter();
        w.write("<!DOCTYPE html>\n" +

                "<html>\n" +

                "<head>\n" +

                " <meta charset=\"UTF-8\">\n" +
                " <title>Title</title>\n" +

                "</head>\n" +

                "<body>\n" +

                "<form action=\"/servlet/members/save\" method=\"post\">\n" +

                " username: <input type=\"text\" name=\"username\" />\n" +

                " age: <input type=\"text\" name=\"age\" />\n" +

                " <button type=\"submit\">전송</button>\n" +

                "</form>\n" +

                "</body>\n" +

                "</html>\n");

    }
}
