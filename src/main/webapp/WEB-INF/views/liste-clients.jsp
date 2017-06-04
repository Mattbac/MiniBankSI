<%@include file="jspf/header.jspf" %>

<div class="wrapper">
	<%@include file="jspf/sidebar.jspf" %>

    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
			<%@include file="jspf/navbar.jspf" %>
        </nav>


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                      <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="col-md-10 title">Liste des clients</h4>
                                <a class="col-md-2 btn btn-success btn-fill btn-wd" href="<%=request.getContextPath()%>/create/client">Nouveau client</a>
                            </div>
                            
                            <div class="content">
                                
                                <div class="content table-responsive table-full-width">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                            <tr>
                                                <th>Nom</th>
                                                <th>Prénom</th>
                                                <th class="text-center">Compte Courant</th>
                                                <th class="text-center">Compte Epargne</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach var="client" items="${clients}">
                                            <tr>
                                                <td><a href="<%=request.getContextPath()%>/see/client/<c:out value="${client.id}"/>"><c:out value="${client.lastName}"/></a></td>
                                                <td><c:out value="${client.firstName}"/></td>
                                                <td class="text-center">
                                                	<c:choose>
                                                		<c:when test="${client.currentAccount.sold > 0}">
                                                			<i class="fa fa-check text-success"></i>
                                                		</c:when>
                                                		<c:otherwise>
                                                			<i class="fa fa-times text-danger"></i>
                                                		</c:otherwise>
                                                	</c:choose>
                                                </td>
                                                <td class="text-center">
                                                	<c:choose>
                                                		<c:when test="${client.savingAccount.sold > 0}">
                                                			<i class="fa fa-check text-success"></i>
                                                		</c:when>
                                                		<c:otherwise>
                                                			<i class="fa fa-times text-danger"></i>
                                                		</c:otherwise>
                                                	</c:choose>
                                                </td>
                                                <td class="td-actions text-right" style="">
                                                    <a class="btn btn-post-action btn-simple btn-info btn-icon table-action view" href="<%=request.getContextPath()%>/see/client/<c:out value="${client.id}"/>" rel="tooltip" data-original-title="Voir profil">
                                                        <i class="fa fa-external-link"></i>
                                                    </a>
                                                    <a class="btn btn-post-action btn-simple btn-success btn-icon table-action edit" href="javascript:void(0)" rel="tooltip" title="" data-original-title="Modifier">
                                                        <i class="fa fa-edit"></i>
                                                    </a>
                                                    <a class="btn btn-post-action btn-simple btn-danger btn-icon table-action remove" href="javascript:void(0)" rel="tooltip" title="" data-original-title="Supprimer">
                                                        <i class="fa fa-remove"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                      <div>
                                    	<div class="content">
                                        	<ul class="pagination">
		                                    	<c:forEach begin="1" end="${maxPages}" step="1" var="nPage">
		                                    		<c:choose>
		                                    			<c:when test="${nPage != currentPage + 1}">
		                                    				<li><a href="clients?pageNumber=${nPage}">${nPage}</a></li>
		                                    			</c:when>
		                                    			<c:otherwise>
		                                    				<li class="active"><a href="">${nPage}</a></li>
		                                    			</c:otherwise>
		                                    		</c:choose>
		                                    	</c:forEach>
                                    		</ul>
                                    	</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        
    </div>
</div>

<%@include file="jspf/footer.jspf" %>
