<%@include file="jspf/header.jspf" %>

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
                                                		<c:when test="${client.currentAccount.sold < 0 || client.savingAccount.sold < 0}"><c:out value="ko"/></c:when>
                                                		<c:otherwise><c:out value="ok"/></c:otherwise>
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
                                    <div>
                                    	<p>
                                    	<c:forEach begin="1" end="${maxPages}" step="1" var="nPage">
                                    		<c:choose>
                                    			<c:when test="${nPage != currentPage + 1}">
                                    				<a href="clients?pageNumber=${nPage}">${nPage}</a>
                                    			</c:when>
                                    			<c:otherwise>
                                    				<span>${nPage}</span>
                                    			</c:otherwise>
                                    		</c:choose>
                                    	</c:forEach>
                                    	</p>
                                    </div>
							</content>
                        </div>
                    </div>
                </div>
            </div>
        </div>  
    </div>
</div>

<%@include file="jspf/footer.jspf" %>
