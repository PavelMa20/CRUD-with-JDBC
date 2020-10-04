package servlet;

import model.User;
import service.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {
    UserServiceImpl userServiceImpl = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        User upUser = new User(Integer.parseInt(request.getParameter("id")),
                (request.getParameter("name")), request.getParameter("password"),
                request.getParameter("login"));
        userServiceImpl.updateUser(upUser);
        response.sendRedirect("list");
    }
}
