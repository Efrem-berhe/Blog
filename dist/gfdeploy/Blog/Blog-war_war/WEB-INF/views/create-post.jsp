<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<my:layout title="Create post">
<jsp:attribute name="body">

    <form method="POST" action="CreatePost">
        <div class="row">      
            <div class="col-md-6 offset-md-3">
                <label for="text">Text</label>
                <input name="text" class="form-control" type="text" required="required">    
            </div>  
        </div>
        <div class="row">      
            <div class="col-md-6 offset-md-3">
                <label for="firstName">First name</label>
                <input name="firstName" class="form-control" required="required" type="text">    
            </div>            
        </div>
        <div class="row">      
            <div class="col-md-6 offset-md-3">
                <label for="lastName">Last name</label>
                <input name="lastName" class="form-control" required="required" type="text">    
            </div>            
        </div>
        <div class="row">      
            <div class="col-md-6 offset-md-3">
                <label for="importance">Importance</label>
                <select name="importance" class="form-control">
                    <option value="CRITICAL">Critical</option>
                    <option value="IMPORTANT">Important</option>
                    <option value="NONIMPORTANT">Not important</option>
                </select> 
            </div>            
        </div>
        <div class="row">
            <div class="col-md-6 offset-md-3">
                Categories<br>
                <c:forEach items="${categories}" var="category">
                    <input type="checkbox" name="categories" value="${category.id}"> <c:out value="${category.name}"></c:out> <br>
                </c:forEach>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <button class="btn btn-default regbutton">Create</button>
            </div>

        </div>
    </form>

</jsp:attribute>
</my:layout>