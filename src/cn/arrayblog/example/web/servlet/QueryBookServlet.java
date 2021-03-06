package cn.arrayblog.example.web.servlet;

import cn.arrayblog.example.domain.User;
import cn.arrayblog.example.service.IBookService;
import cn.arrayblog.example.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/queryBook")
public class QueryBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //获取后端session的值
        HttpSession session = request.getSession();
        User activeUser = (User) session.getAttribute("activeUser");

        if(activeUser != null){
            if(activeUser.getUserLevel()>0){
                //获取前端传递的值
                String keyWord = request.getParameter("keyWord");

                IBookService bookService = new BookServiceImpl();

                //设置共享域
                List books = bookService.getBookList(keyWord);
                request.setAttribute("books", books);

                //转发请求和相应对象到页面
                request.getRequestDispatcher("./query_book.jsp").forward(request, response);
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
