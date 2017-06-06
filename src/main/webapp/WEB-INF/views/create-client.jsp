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
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Modification des informations client</h4>
                            </div>
                            <div class="content">
                                <f:form modelAttribute="client" method="post">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <f:label path="lastName">Lastname :</f:label> 
                                                <f:input class="form-control" path="lastName" />
                                                <f:errors path="lastName" />
                                                
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                            	<f:label path="firstName">FirstName :</f:label>
                                                <f:input class="form-control" path="firstName" />
                                                <f:errors path="firstName" />
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                            	<f:label path="adress">Adress :</f:label>
                                                <f:input class="form-control" path="adress" />
                                                <f:errors path="adress" />
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                            	<f:label path="city">City :</f:label>
                                                <f:input class="form-control" path="city" />
                                                <f:errors path="city" />
                                            </div>
                                        </div>

                                        <div class="col-md-4">
                                            <div class="form-group">
                                            	<f:label path="zipCode">ZipCode :</f:label>
                                                <f:input class="form-control" path="zipCode" />
                                                <f:errors path="zipCode" />
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                            	<f:label path="phoneNumber">Phone number :</f:label>
                                                <f:input class="form-control" path="phoneNumber" />
                                                <f:errors path="phoneNumber" />
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                            	<label for="current">Current Account</label>
                                            	<input id="current" type="checkbox" name="current" checked="checked">
                                            	<label for="saving">Saving Account</label>
                                            	<input id="saving" type="checkbox" name="saving">
                                            	<f:errors path="" />
                                            </div>
                                        </div>
                                    </div>

                                    <button type="submit" class="btn btn-info btn-fill pull-right">Create</button>
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
