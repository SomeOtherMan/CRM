package by.kustarev.crm.servlet;

import by.kustarev.crm.model.User;
import by.kustarev.crm.service.CheckAuthService;
import by.kustarev.crm.service.TokenService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "checkAuth", value = "/check-auth")
public class CheckAuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = CheckAuthService.getUserByLoginAndPassword(login, password);

        if (user != null) {
            getServletContext().setAttribute("user", user);

            String token = TokenService.createToken(user.getId());
            resp.addCookie(new Cookie("userID", String.valueOf(user.getId())));
            resp.addCookie(new Cookie("token", token));

            String URLToForward = "";
            switch (user.getRole()) {
                case ADMIN : URLToForward = "/admin"; break;
                case BA : URLToForward = "/ba"; break;
                case DEV : URLToForward = "/dev"; break;
                case PM: URLToForward = "/pm";
            }

            resp.sendRedirect(req.getContextPath() + URLToForward);
        } else {
            resp.setContentType("text/html");

            resp.getWriter().println("Пока!");
        }
    }
}
