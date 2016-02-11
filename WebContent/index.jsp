<hr/>

<%@ taglib uri="/struts-tags" prefix="s" %>

    <a href="${pageContext.request.contextPath}/login.jsp" >Login</a><br>

    <a href="${pageContext.request.contextPath}/addNewUser.jsp">AddNewUser</a> <br>

    <a href="${pageContext.request.contextPath}/userRegistration.jsp">User REgistration</a><br> 
    
    <a href="${pageContext.request.contextPath}/changePassword.jsp" >ChangePass</a><br>     
     
    <a href="${pageContext.request.contextPath}/registrationPageUpdate.jsp" >RegisterPageUpdate</a><br>   
    
    <a href="logout">logout</a>|
    
    
    	<s:if test="hasActionMessages()">
	      <s:actionmessage/>         
	  </s:if>
    
    <s:if test="hasActionErrors()">
	      <s:actionerror/>         
	  </s:if>
    
      
    
    
    <s:form action="viewRecord" method="post"> 
    
      <s:if test="userList.size() > 0">
	
	<table>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Mid name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Dob</th>
			<th>Address</th>
		</tr>
	
		<s:iterator value="userList">
			<tr>
				
				<td><s:property value="userId" /></td>
				<td><s:property value="firstName" /></td>
				<td><s:property value="middleName" /></td>
				<td><s:property value="lastName" /></td>
				<td><s:property value="age" /></td>
				<td><s:property value="dob" /></td>
				<td><s:property value="address" /></td>
				
				
				
				<%-- <td><s:url id="editURL" action="editUser">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{editURL}">Edit</s:a></td>
				<td><s:url id="deleteURL" action="deleteUser">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Delete</s:a></td> --%>
			</tr>
		</s:iterator>
			</table>	
</s:if> 
<s:submit value="ViewRecord"></s:submit>  
    
    </s:form>
    
    


