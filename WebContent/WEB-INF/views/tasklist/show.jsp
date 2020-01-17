<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">

        <h2>${tasks.id}のタスク</h2>
        <p>タスク内容：<c:out value="${tasks.content}" /></p>
        <p>作成日時：<fmt:formatDate value="${tasks.create_date}" pattern="yyyy-MM-dd HH:mm:ss" /></p>
        <p>更新日時：<fmt:formatDate value="${tasks.update_date}" pattern="yyyy-MM-dd HH:mm:ss" /></p>

        <p><a href="${pageContext.request.contextPath}/edit?id=${tasks.id}">タスク内容の修正</a></p>

        <p><a href="#" onclick="taskFinished();">タスクの完了</a></p>
        <form method="POST" action="${pageContext.request.contextPath}/destroy">
            <input type="hidden" name="_token" value="${_token}" />
        </form>

        <script>
        function taskFinished() {
            if(confirm("本当に完了しましたか？")) {
                document.forms[0].submit();
            }
        }
        </script>

        <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p>

    </c:param>
</c:import>