    <%@ taglib uri="/struts-tags" prefix="s" %>  
        <jsp:include page="index.jsp"></jsp:include> 
        
        <h2>User Registration Page</h2> <br>
        
    <s:form action="registerUser">  
    <s:textfield name="firstName" label="FirstName" ></s:textfield> 
    <s:textfield name="middleName" label="MiddleName"></s:textfield>  
    <s:textfield name="lastName" label="LastName"></s:textfield>
    <s:textfield name="age" label="Age"></s:textfield>
    <s:textfield name="dob" label="Date of Birth"></s:textfield>
    <s:textfield name="address" label="Address"></s:textfield>  
    
     
    <s:submit value="Register"></s:submit>  
      
    </s:form>  
    


	
    

    