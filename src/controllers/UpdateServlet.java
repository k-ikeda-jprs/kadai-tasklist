package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TaskDto;
import utils.DBUtils;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
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

            // content取得
            String content = request.getParameter("content");
            m.setContent(content);

            // 更新時間取得
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            m.setUpdate_date(currentTime);

            // データベース格納
            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();

            // 不要データ削除
            request.getSession().removeAttribute("tasks_id");

            response.sendRedirect(request.getContextPath() + "/index");
        }

    }

}
