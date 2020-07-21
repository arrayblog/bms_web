package cn.arrayblog.example.web.servlet;

import cn.arrayblog.example.dao.IBookTypeDao;
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
import java.util.List;

@WebServlet(urlPatterns = "/updateBook")
public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //获取后端session的值
        HttpSession session = request.getSession();
        User activeUser = (User) session.getAttribute("activeUser");

        if(activeUser != null){
            if(activeUser.getUserLevel()>1){

                //通过id获取记录内容
                IBookService bookService = new BookServiceImpl();
                int id = Integer.parseInt(request.getParameter("id"));
                Book book = bookService.findById(id);
                request.setAttribute("book",book);

                //获取图书类型，以供选择
                IBookTypeService bookTypeService = new BookTypeServiceImpl();
                List<BookType> bookTypes = bookTypeService.getBookTypeList();
                request.setAttribute("bookTypes",bookTypes);

                request.getRequestDispatcher("./update_book.jsp").forward(request,response);

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
