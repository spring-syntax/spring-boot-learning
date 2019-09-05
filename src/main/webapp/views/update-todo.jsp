<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<form:form method="post" modelAttribute="todo">
<fieldset class="form-group">
    <form:label path="desc">Description</form:label>
    <form:input path="desc" name="desc" type="text" class="form-control" required="required"/>
    <form:errors path="desc" cssClass="text-warning"/>
</fieldset>
  <fieldset class="form-group">
    <form:label path="targetDate">Due date : </form:label>
    <form:input name="targetDate" path="targetDate" type="text" class="form-control"/>
    <form:errors path="targetDate" cssClass="text-warning"/>
  </fieldset>
    <form:button type="submit" class="btn btn-success">Update</form:button>
</form:form>
</div>
<%@ include file="common/footer.jspf" %>