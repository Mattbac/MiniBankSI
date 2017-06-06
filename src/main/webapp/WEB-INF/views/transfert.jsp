<%@include file="jspf/header.jspf" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<div class="wrapper">

	<%@include file="jspf/sidebar.jspf" %>

    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
			<%@include file="jspf/navbar.jspf" %>
        </nav>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card">
                        
                            <div class="header">
                                <h4 class="title">Virement bancaire</h4>
                            </div>
                        
                            <div class="content">
                                <f:form method="post">
                                
                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label path="debitAccount">Compte débiteur</label> 
                                                <input class="form-control" name="debitAccount" />
                                                <f:errors path="debitAccount" />
                                            </div>
                                        </div>
                                      </div>
                                      	
									<div class="row">
                                        <div class="col-md-8">
                                            <div class="form-group">
                                            	<label path="creditAccount">Compte créditeur</label>
                                                <input class="form-control" name="creditAccount" />
                                                <f:errors path="creditAccount" />
                                            </div>
                                        </div>
                                    </div>

									<div class="row">
                                        <div class="col-md-8">
                                            <div class="form-group">
                                            	<label path="sum">Somme à transférer</label>
                                                <input class="form-control" name="sum" />
                                                <f:errors path="sum" />
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <br />
									<div class="row">
                                        <div class="col-md-8">
                                    		<button type="submit" class="btn btn-info btn-fill pull-right">Valider le transfert</button>
                                    	</div>
                                    </div>
                                    <div class="clearfix"></div>
                                </f:form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        
    </div>
</div>

<%@include file="jspf/footer.jspf" %>
