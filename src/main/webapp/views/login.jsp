<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<font color="RED">${errorMessage}</font>
<form method="post">
    Username: <input name="name" type="text"/>
    Password: <input name="password" type="password"/>
    <input type="submit">
</form>
<%@ include file="common/footer.jspf" %>