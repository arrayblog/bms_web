package cn.arrayblog.example.web.servlet;

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
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/execReturnBookServlet")
public class ExecReturnBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        PrintWriter out=response.getWriter();

        User activeUser = (User) session.getAttribute("activeUser");


        if(activeUser != null){
            if(activeUser.getUserLevel()==3){

                IRecordService recordService = new RecordServiceImpl();
                IBookService bookService = new BookServiceImpl();

                int recordId = Integer.parseInt(request.getParameter("recordId"));
                int bookId=Integer.parseInt(request.getParameter("bookId"));

                //删一条借阅记录
                recordService.removeRecord(recordId);
                //修改图书存在状态
                bookService.existence(bookId);
                response.sendRedirect("./queryRecord");
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
