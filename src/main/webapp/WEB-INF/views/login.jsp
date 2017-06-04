<%@include file="jspf/header.jspf" %>

<div class="wrapper login">
    <div class="full-page">
        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 col-sm-6 col-md-offset-4 col-sm-offset-3">
                    
                    	<form method="post" action="login">
                            <div class="card login">
                                <div class="content">
                                
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
                                
                                    <div class="form-group">
                                        <input type="text"  id="username" name="username" placeholder="Login" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" id="password" name="password" placeholder="Password" class="form-control">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="footer text-center">
                                        <button type="submit" class="btn btn-fill btn-success btn-wd">Login</button>
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

<%@include file="jspf/footer.jspf" %>
