<%@ taglib uri="/struts-tags" prefix="s" %>  
     
     <jsp:include page="index.jsp"></jsp:include> 
      <h2> Add new User </h2>
       
    <s:form action="userData" method="post">  
    <s:textfield name="userName"  label="UserName"></s:textfield>  
    <s:password name="userPass"  label="Password"></s:password>  
    <s:submit value="Add New User"></s:submit>  
    </s:form>  
    
    