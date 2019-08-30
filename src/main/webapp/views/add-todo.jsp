<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login page</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
    	rel="stylesheet">
</head>
<body>
<div class="container">
<form:form method="post" modelAttribute="todo">
<fieldset class="form-group">
    <form:label path="desc">Description</form:label>
    <form:input path="desc" name="desc" type="text" class="form-control" required="required"/>
    <form:errors path="desc" cssClass="text-warning"/>
</fieldset>
  <fieldset class="form-group">
    <form:label path="targetDate">Due date : </form:label>
    <input name="targetDate" path="targetDate" type="text" class="form-control"/>
    <form:errors path="targetDate" cssClass="text-warning"/>
  </fieldset>
    <form:button type="submit" class="btn btn-success">Add</form:button>
</form:form>
</div>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>