package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TaskDto;
import utils.DBUtils;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        // EntityManagerオブジェクト生成
        EntityManager em = DBUtils.createEntityManager();

        // 該当するIDのデータをDBより取得
        TaskDto m = em.find(TaskDto.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("tasks", m);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasklist/show.jsp");
        rd.forward(request, response);

    }

}
