<%@ taglib uri="/struts-tags" prefix="s" %>  
     
     <jsp:include page="index.jsp"></jsp:include> 
      <h2> changePassword </h2>
       
    <s:form action="changePassAction" method="post">  
    <s:textfield name="userId"  label="UserID"></s:textfield>  
    <s:password name="userPass"  label="Password"></s:password>  
    <s:submit value="changePass"></s:submit>  
    </s:form>  
    
    