package cn.arrayblog.example.web.servlet;

import cn.arrayblog.example.domain.User;
import cn.arrayblog.example.service.IUserService;
import cn.arrayblog.example.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/execLoginServlet")
public class ExecLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码格式
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //声明session引用
        HttpSession session=request.getSession();
        //声明out引用
        PrintWriter out=response.getWriter();

        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        IUserService userService = new UserServiceImpl();
        User activeUser = userService.login(user);

        if(activeUser != null ){
            int activeUserLevel = activeUser.getUserLevel();
            session.setAttribute("activeUser",activeUser);
            switch (activeUserLevel){
                case 1:
                    response.sendRedirect("./index_root.jsp");
                    break;
                case 2:
                    response.sendRedirect("./index_admin.jsp");
                    break;
                case 3:
                    response.sendRedirect("./index_user.jsp");
                    break;
            }
        }else{
            out.print("<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "   <script>alert('用户名或者密码错误！');\n" +
                    "   location.href=\"./login.jsp\";\n" +
                    "</script>\n");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
