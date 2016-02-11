<%@ taglib uri="/struts-tags" prefix="s" %>  
       <jsp:include page="index.jsp"></jsp:include> 
      <h2>User Login </h2>
      
    <s:form action="loginprocess" method="post">  
    <s:textfield name="userName"  label="UserName"></s:textfield>  
    <s:password name="userPass"  label="Password"></s:password>  
    <s:submit value="Login"></s:submit> 

<s:if test="hasActionErrors()">
	      <s:actionerror/>
         
	  </s:if>
    
    </s:form>  
    
    						