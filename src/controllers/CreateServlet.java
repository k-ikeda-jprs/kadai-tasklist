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
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
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

            // インスタンス生成
            TaskDto m = new TaskDto();

            // content取得
            String content = request.getParameter("content");
            m.setContent(content);

            // 生成時間&更新時間取得
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            m.setCreate_date(currentTime);
            m.setUpdate_date(currentTime);

            // データベース格納
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
            em.close();

            response.sendRedirect(request.getContextPath() + "/index");
        }

    }

}
