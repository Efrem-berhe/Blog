<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<my:layout title="Create category">
<jsp:attribute name="body">

    <form method="POST" action="CreateCategory">
        <div class="row">      
            <div class="col-md-6 offset-md-3">
                <label for="name">Name</label>
                <input name="name" class="form-control" type="text" required="required">    
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