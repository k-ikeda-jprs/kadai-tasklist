package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TaskDto;
import utils.DBUtils;

/**
 * Servlet implementation class DestroyServlet
 */
@WebServlet("/destroy")
public class DestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String _token = (String)request.getParameter("_token");
        if( _token != null && _token.contentEquals(request.getSession().getId())){

            // EntityManagerオブジェクト生成
            EntityManager em = DBUtils.createEntityManager();

            // 指定IDよりインスタンス生成
            TaskDto m = em.find(TaskDto.class, (Integer)(request.getSession().getAttribute("tasks_id")));

            // データベースから削除
            em.getTransaction().begin();
            em.remove(m);
            em.getTransaction().commit();
            em.close();

            // 不要データ削除
            request.getSession().removeAttribute("tasks_id");

            response.sendRedirect(request.getContextPath() + "/index");
        }

    }

}
