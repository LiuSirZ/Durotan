package com.zherke.template.servlet;

import com.zherke.template.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lwb
 * @create 2018-07-11 10:14
 * @desc a demo from servlet
 **/
@WebServlet(urlPatterns="/demoServlet/*", description="SpringBoot Servlet Demo")
public class DemoServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(">>>>>>>>>>doGet()<<<<<<<<<<<");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(">>>>>>>>>>doPost()<<<<<<<<<<<");
        //TODO 业务逻辑处理
        req.getSession().setAttribute("1111111","111");
        resp.getWriter().write("11111");
    }

}
