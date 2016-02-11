    <%@ taglib uri="/struts-tags" prefix="s" %>  
        <jsp:include page="index.jsp"></jsp:include> 
        
        <h2>User Registration Page for update </h2> <br>
        
    <s:form action="registerUserUpdate">  
    
    <s:textfield name="userId"  label="UserID"></s:textfield>
    <s:textfield name="firstName" label="FirstName"></s:textfield> 
    <s:textfield name="middleName" label="MiddleName"></s:textfield>  
    <s:textfield name="lastName" label="LastName"></s:textfield>
    <s:textfield name="age" label="Age" required=""></s:textfield>
    <s:textfield name="dob" label="Date of Birth"></s:textfield>
    <s:textfield name="address" label="Address"></s:textfield>  
    
     
    <s:submit value=" update"></s:submit>  
    		
		<s:iterator value="userList">
			<tr>
				<s:property value="userId" />
				<s:property value="firstName" />
				<s:property value="MiddleName" />				
				<s:property value="lastName" />
				<s:property value="age" />
				<s:property value="dob" />
				<s:property value="address" />
			</tr>
		</s:iterator>
    
          
    </s:form> 
     
    
   