package by.kustarev.crm.servlet;

import by.kustarev.crm.service.TokenService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "admin", value = "/admin")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        String userID = "0", token = "";

        for (Cookie cookie : req.getCookies())
            if ("userID".equals(cookie.getName()))
                userID = cookie.getValue();
            else if ("token".equals(cookie.getName()))
                token = cookie.getValue();

        String bufferedToken = TokenService.createToken(Long.parseLong(userID));
        resp.getWriter().println("I'm " + (bufferedToken.equals(token) ? "" : "not") + "an admin");
    }
}
