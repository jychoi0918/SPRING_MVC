package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJasonServlet", urlPatterns = "/response-json")
public class ResponseJasonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setHeader("content-type","application/json");
    response.setCharacterEncoding("utf-8");

    HelloData helloData = new HelloData();
    helloData.setUsername("GGomi");
    helloData.setAge(11);

    //{"username" : "ggomi", "age" : 11}
        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);


    }
}
