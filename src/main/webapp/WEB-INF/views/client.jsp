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
                                <h4 class="col-md-10 title">Profil client</h4>
                                <a class="col-md-2 btn btn-info btn-fill btn-wd" href="<%=request.getContextPath()%>/modify/client">Modifier le profil</a>
                            </div>

                            <div class="content">
                            
                            	<form>
	                           <h4 class="title text-info">Coordonnées</h4>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Nom</label>
                                                <p><c:out value="${client.lastName}"/></p>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Prénom</label>
                                                <p><c:out value="${client.firstName}"/></p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label>Adresse</label>
                                                <p><c:out value="${client.adress}"/></p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Code Postal</label>
                                                <p><c:out value="${client.zipCode}"/></p>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Ville</label>
                                                <p><c:out value="${client.city}"/></p>
                                            </div>
                                        </div>
                                    </div>
                                    
								<br />
                                <h4 class="title text-info">Contact</h4>
                                    <div class="row">
                                        <div class="col-md-1">
                                                <p><i class="fa fa-phone"></i></p>
                                        </div>
                                        <div class="col-md-7">
                                                <p><c:out value="${client.phoneNumber}"/></p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-1">
                                                <p><i class="fa fa-envelope-o"></i></p>
                                        </div>
                                        <div class="col-md-7">
                                                <p>email@gmail.com</p>
                                        </div>
                                    </div>

								<br />
                                <h4 class="title text-info">Comptes bancaires</h4>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Numéro de compte courant</label>
                                                <p><c:out value="${client.currentAccount.accountNumber}"/></p>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Solde</label>
                                                <p><c:out value="${client.currentAccount.sold}"/> Euros</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Numéro de compte épargne</label>
                                                <p><c:out value="${client.savingAccount.accountNumber}"/></p>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Solde</label>
                                                <p><c:out value="${client.savingAccount.sold}"/> Euros</p>
                                            </div>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>

<%@include file="jspf/footer.jspf" %>
