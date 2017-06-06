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

									<div class="col-md-">
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
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<%@include file="jspf/footer.jspf" %>
