<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<my:layout title="All quotes">
<jsp:attribute name="body">

    <div>
        <h2>Quotes</h2>
        <c:if test="${isError}">
            <div class="alert alert-danger" role="alert">
                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                Invalid input data
            </div>
        </c:if>

        <c:forEach items="${motivationQuotes}" var="motivationQuote">
            <div>
                "<c:out value="${motivationQuote.quote}"></c:out>" (<c:out value="${motivationQuote.yearSaid}"></c:out>)<br>
                <c:out value="${motivationQuote.author}"></c:out>
            </div><br><br>
        </c:forEach>
    </div>

    <br><br>
    <form action="motivation-quotes" method="POST" modelAttribute="newQuote">
        <input type="text" class="form-control" name="author" placeholder="Author ..."/><br>
        <input type="text" class="form-control" name="quote" placeholder="Quote ..."/><br>
        <input type="text" class="form-control" name="yearSaid" placeholder="Quote said in year ... (from 1900)"/><br>
        <input type="submit" value="Add"/>
    </form>

</jsp:attribute>
</my:layout>