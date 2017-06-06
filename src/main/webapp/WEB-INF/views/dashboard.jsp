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
                            <div class="content">
								<div class="row">
									<div class="col-md-4">
										<div class="card">
											<div class="header">
												<div class="row">
													<div class="col-md-12">
														<h4 class="title">Nombre de clients</h4>
													</div>
													<div class="col-md-12">
														<div class="row">
															<div class="col-md-12">
																<div class="form-group">
																	<label>en gestion</label>
																	<h2>
																		<c:out value="${nbClients}" />
																	</h2>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
		                            </div>
	
									<div class="col-md-4">
										<div class="card">
											<div class="header">
												<div class="row">
													<div class="col-md-12">
														<h4 class="title">Total en gestion</h4>
													</div>
													<div class="col-md-12">
														<div class="row">
															<div class="col-md-12">
																<div class="form-group">
																	<label>Comptes courants</label>
																	<h2>
																		<c:out value="${sumCurrentAccount}" />
																	</h2>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
		                            </div>
	
									<div class="col-md-4">
									<div class="card">
										<div class="header">
											<div class="row">
												<div class="col-md-12">
													<h4 class="title">Total en gestion</h4>
												</div>
												<div class="col-md-12">
													<div class="row">
														<div class="col-md-12">
															<div class="form-group">
																<label>Comptes épargnes</label>
																<h2>
																	<c:out value="${sumSavingAccount}" />
																</h2>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
	                            </div>
								</div>
								
								<div class="row">
									<div class="col-md-6">
										<div class="card">
											<div class="header">
												<div class="row">
													<div class="col-md-12">
														<h4 class="title">Clients à contacter</h4>
													</div>
													<div class="col-md-12">
														<div class="row">
															<div class="col-md-12">
																<div class="form-group">
																	<label>Comptes débiteurs</label>
																	
										                                <div class="content table-responsive table-full-width">
										                                    <table class="table table-hover table-striped">
										                                        <thead>
										                                            <tr>
										                                                <th>Nom</th>
										                                                <th>Prénom</th>
										                                                <th class="text-center">Compte Courant</th>
										                                            </tr>
										                                        </thead>
										                                        <tbody>
										                                        	<c:forEach var="client" items="${listClientNegativ}">
										                                            <tr>
										                                                <td><a href="<%=request.getContextPath()%>/see/client/<c:out value="${client.id}"/>"><c:out value="${client.lastName}"/></a></td>
										                                                <td><c:out value="${client.firstName}"/></td>
										                                                <td class="text-center">
										                                                	<i class="fa fa-times text-danger"></i>
										                                                </td>
										                                            </tr>
										                                            </c:forEach>
										                                        </tbody>
										                                    </table>
										                                </div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
		                            </div>
	
									<div class="col-md-6">
										<div class="card">
											<div class="header">
												<div class="row">
													<div class="col-md-12">
														<h4 class="title">Comptes </h4>
													</div>
													<div class="col-md-12">
														<div class="row">
															<div class="col-md-12">
																<div class="form-group">
																	<label>Prévoir la gestion de patrimoine</label>
																	
										                                <div class="content table-responsive table-full-width">
										                                    <table class="table table-hover table-striped">
										                                        <thead>
										                                            <tr>
										                                                <th>Nom</th>
										                                                <th>Prénom</th>
										                                                <th class="text-center">Compte Epargne</th>
										                                            </tr>
										                                        </thead>
										                                        <tbody>
										                                        	<c:forEach var="client" items="${listClientSavingOver500000}">
										                                            <tr>
										                                                <td><a href="<%=request.getContextPath()%>/see/client/<c:out value="${client.id}"/>"><c:out value="${client.lastName}"/></a></td>
										                                                <td><c:out value="${client.firstName}"/></td>
										                                                <td class="text-center">
										                                                	<i class="fa fa-times text-success"></i>
										                                                </td>
										                                            </tr>
										                                            </c:forEach>
										                                        </tbody>
										                                    </table>
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
                    	</div>
                </div>
            </div>
        </div>
    </div>

</div>

<%@include file="jspf/footer.jspf" %>
