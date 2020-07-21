package cn.arrayblog.example.web.servlet;

import cn.arrayblog.example.domain.Record;
import cn.arrayblog.example.domain.User;
import cn.arrayblog.example.service.IBookService;
import cn.arrayblog.example.service.IRecordService;
import cn.arrayblog.example.service.impl.BookServiceImpl;
import cn.arrayblog.example.service.impl.RecordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/queryRecord")
public class QueryRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //获取后端session的值
        HttpSession session = request.getSession();
        User activeUser = (User) session.getAttribute("activeUser");

        if(activeUser != null){
            if(activeUser.getUserLevel()>0){

                IRecordService recordService = new RecordServiceImpl();

                //设置共享域
                List<Record> records = recordService.getUserRecordList(activeUser.getId());
                request.setAttribute("records", records);

                //转发请求和相应对象到页面
                request.getRequestDispatcher("./query_record.jsp").forward(request, response);
            }else{
                response.sendRedirect("./login.jsp");
            }
        }else{
            response.sendRedirect("./login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
