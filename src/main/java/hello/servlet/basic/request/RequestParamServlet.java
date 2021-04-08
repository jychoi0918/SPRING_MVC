package hello.servlet.basic.request;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* 1. 파라미터 전송기능
 * http://localhost:8080/request-param?username=hello&age=20
*/
@WebServlet(name ="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start ");
 
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName +"= " + request.getParameter(paramName)));
                                                                //username에 속한 hello 와 같은 이름을 구하려면 getparameter
        System.out.println("[전체 파라미터 조회] - end ");
        System.out.println();
        System.out.println("[단일파라미터 조회]");
        String username = request.getParameter("username");
        String age = request.getParameter("age");


        System.out.println("username = " + username);
        System.out.println("age = " + age);

        //파라미터의 네임은 username하나고 값이 여러개 =>getParameterValues로 꺼내 보아요
        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("name = " + name);

        }
        String[] userages = request.getParameterValues("age");
        for (String ages : userages) {
            System.out.println("ages = " + ages);

        }
        response.getWriter().write("Everything is okay:)");

    }

}
