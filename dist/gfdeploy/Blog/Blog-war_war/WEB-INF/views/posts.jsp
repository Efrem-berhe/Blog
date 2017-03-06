<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<my:layout title="All posts">
<jsp:attribute name="body">
    
    <div>
        This page was visited <c:out value="${visits}"/> times
    </div>
    
    <div>
        <a href="Posts">All</a>
        <c:forEach items="${categories}" var="category">
             | <span><a href="Posts?category=${category.id}"><c:out value="${category.name}"></c:out></a></span>
        </c:forEach>
    </div>
    
    <a href="CreatePost">Create new Post</a>
    <br>
    <a href="CreateCategory">Create new Category</a>
    <br><br>
    <c:forEach items="${posts}" var="post">
        <div>
            <h3><c:out value="${post.user.firstName}"/> <c:out value="${post.user.lastName}"/></h3>
            <c:out value="${post.publishedDate}"/> - <c:out value="${post.importance}"/><br>
            <c:out value="${post.text}"/><br>
            <c:out value="${post.likes}"/> Likes
            <a href="LikePost?postId=${post.id}">Like this post</a><br>
            <a href="DeletePost?postId=${post.id}">Delete this post</a><br>
            <c:forEach items="${post.comments}" var="comment">
                <span>&nbsp; &nbsp; - &nbsp; &nbsp; <c:out value="${comment.text}"/></span><br>
            </c:forEach>
            <c:forEach items="${post.categories}" var="category">
                <span><c:out value="${category.name}"></c:out> | </span>
            </c:forEach>
            
            <form action="CreateComment" method="POST">
                <input type="hidden" name="postId" value="${post.id}">
                <input type="text" name="text" placeholder="Write a comment ...">
                <input type="submit" value="Send">
            </form>
        </div>
        <hr>
    </c:forEach>
    
</jsp:attribute>
</my:layout>