package cn.arrayblog.example.web.servlet;

import cn.arrayblog.example.domain.Book;
import cn.arrayblog.example.domain.BookType;
import cn.arrayblog.example.domain.User;
import cn.arrayblog.example.service.IBookService;
import cn.arrayblog.example.service.IBookTypeService;
import cn.arrayblog.example.service.impl.BookServiceImpl;
import cn.arrayblog.example.service.impl.BookTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/execAddBookTypeServlet")
public class ExecAddBookTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //获取后端session的值
        HttpSession session = request.getSession();
        User activeUser = (User) session.getAttribute("activeUser");

        if(activeUser != null){
            if(activeUser.getUserLevel()>1){
                // 1. 获取表单提交过来的数据
                BookType bookType = new BookType();
                bookType.setBookTypeName(request.getParameter("bookTypeName"));
                bookType.setBookTypeDesc(request.getParameter("bookTypeDesc"));

                // 2.调用Service层
                IBookTypeService bookTypeService = new BookTypeServiceImpl();
                int i = bookTypeService.addBookType(bookType);

                //判断是否操作成功，若成功重定向
                if(i>0){
                    response.sendRedirect("./manageBook");
                }
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
