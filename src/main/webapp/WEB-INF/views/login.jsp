<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:tiles="http://www.thymeleaf.org">
  <head>
    <title tiles:fragment="title">Messages : Create</title>
  </head>
  <body th:include="layout :: body" th:with="content=~{::content}">
    <div tiles:fragment="content">
        <form name="f" th:action="@{/login}" method="post">               
            <fieldset>
                <legend>Please Login</legend>
                <c:if test="${param.error}">
                	<div class="alert alert-error">    
                    	Invalid username and password.
                	</div>
                </c:if>
                <c:if test="${param.logout}">
                	<div class="alert alert-success">    
                    	You have been logged out.
                	</div>
                </c:if>
                <label for="username">Username</label>
                <input type="text" id="username" name="username"/>        
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>    
                <div class="form-actions">
                    <button type="submit" class="btn">Log in</button>
                </div>
            </fieldset>
        </form>
        <a href="/formation/">Home</a>
        <a href="/formation/register">Registration</a>
    </div>
  </body>
</html>