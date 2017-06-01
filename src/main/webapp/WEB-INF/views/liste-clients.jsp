<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Liste des clients</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!-- Bootstrap core CSS -->
    <link href="assets/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Light Bootstrap Table core CSS -->
    <link href="assets/common/css/light-bootstrap-dashboard.css" rel="stylesheet"/>

    <!-- Mon style CSS -->
    <link href="assets/common/css/style.css" rel="stylesheet"/>

    <!-- Fonts and icons -->
    <link href="assets/common/css/pe-icon-7-stroke.css" rel="stylesheet" />
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>

</head>
<body>

<div class="wrapper">

    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
        </nav>

		<%@include file="jspf/sidebar.jspf" %>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                      <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="col-md-10 title">Clients</h4>
                                <button class="col-md-2 btn btn-success btn-fill btn-wd">Nouveau client</button>
                            </div>
                        
							<content>
                                <div class="content table-responsive table-full-width">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                            <tr>
                                                <th>Nom</th>
                                                <th>Prenom</th>
                                                <th>Ville</th>
                                                <th>A Decouvert</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach var="client" items="${clients}">
                                            <tr>
                                                <td><c:out value="${client.lastName}"/></td>
                                                <td><c:out value="${client.firstName}"/></td>
                                                <td><c:out value="${client.city}"/></td>
                                                <td>
                                                	<c:choose>
                                                		<c:when test="${client.currentAccount.sold < -1000 || client.savingAccount.sold < 0}"><c:out value="ok"/></c:when>
                                                		<c:otherwise><c:out value="ko"/></c:otherwise>
                                                	</c:choose>
                                                </td>
                                                <td class="td-actions text-right" style="">
                                                    <a class="btn btn-post-action btn-simple btn-info btn-icon table-action view" href="javascript:void(0)" rel="tooltip" title="" data-original-title="View">
                                                        <i class="fa fa-external-link"></i>
                                                    </a>
                                                    <a class="btn btn-post-action btn-simple btn-success btn-icon table-action edit" href="javascript:void(0)" rel="tooltip" title="" data-original-title="Edit">
                                                        <i class="fa fa-edit"></i>
                                                    </a>
                                                    <a class="btn btn-post-action btn-simple btn-danger btn-icon table-action remove" href="javascript:void(0)" rel="tooltip" title="" data-original-title="Remove">
                                                        <i class="fa fa-remove"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                            </c:forEach>
                                       </tbody>
                                    </table>

							
								
							
							</content>
                        
                        </div>
                    </div>

                </div>
            </div>
        </div>
        
    </div>
</div>


<%@include file="jspf/footer.jspf" %>
