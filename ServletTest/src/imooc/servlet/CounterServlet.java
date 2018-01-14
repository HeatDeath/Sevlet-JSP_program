package imooc.servlet;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;


public class CounterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        Integer number_1 = Integer.valueOf(request.getParameter("number_1"));
        Integer number_2 = Integer.valueOf(request.getParameter("number_2"));
        Integer number_3 = number_1 + number_2;

        // 调用 PrintWriter 对象，将结果打印在一个 html 页面上
        if (request.getParameter("display_method").equals("1")) {

            PrintWriter writer = response.getWriter();
            writer.println("<HTML>");
            writer.println("<BODY>");
            writer.println("<hr/>");
            writer.println("result is ：" + number_3);
            writer.println("<br/>");
            writer.println("</BODY>");
            writer.println("</HTML>");
            writer.flush();
            writer.close();

            // servlet 获取 request 请求，并将 request 请求转发到 forward_page.jsp 页面上
        } else if (request.getParameter("display_method").equals("2")) {

            request.getRequestDispatcher("/forward_page.jsp").forward(request, response);

            // servlet 获取 传递过来的数据，并将 数据保存在 ServletContext 实例 context 中
            // 重定向到 redirect_page.jsp 页面
        } else if (request.getParameter("display_method").equals("3")) {

            ServletContext context = this.getServletContext();

            context.setAttribute("result", number_3);

            response.sendRedirect("/redirect_page.jsp");

            // 在控制台直接输出 计算结果
        } else if (request.getParameter("display_method").equals("0")) {
            System.out.print("计算结果是：" + number_3);
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.print("访问 http://localhost:8080/CounterServlet 将在控制台看到此信息");
    }
}

