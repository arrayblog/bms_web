package cn.arrayblog.example.web.servlet;

import cn.arrayblog.example.dao.IRecordDao;
import cn.arrayblog.example.domain.BookType;
import cn.arrayblog.example.domain.User;
import cn.arrayblog.example.service.IBookService;
import cn.arrayblog.example.service.IBookTypeService;
import cn.arrayblog.example.service.IRecordService;
import cn.arrayblog.example.service.impl.BookServiceImpl;
import cn.arrayblog.example.service.impl.BookTypeServiceImpl;
import cn.arrayblog.example.service.impl.RecordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/execBorrowBookServlet")
public class ExecBorrowBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        PrintWriter out=response.getWriter();

        User activeUser = (User) session.getAttribute("activeUser");
        int bookId=Integer.parseInt(request.getParameter("bookId"));

        if(activeUser != null){
            if(activeUser.getUserLevel()==3){

                IRecordService recordService = new RecordServiceImpl();
                IBookService bookService = new BookServiceImpl();

                //借阅数量是否超出限度，三本上限
                int i = recordService.userRecordNumber(activeUser.getId());
                if(i<3){
                    //增加一条借阅记录
                    recordService.addRecord(activeUser.getId(),bookId);
                    //修改图书存在状态
                    bookService.noExistence(bookId);
                    response.sendRedirect("./queryBook");
                }else{
                    out.print("<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>Title</title>\n" +
                            "</head>\n" +
                            "   <script>alert('借阅禁止超过三本！');\n" +
                            "   location.href=\"./queryBook\";\n" +
                            "</script>\n");
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
