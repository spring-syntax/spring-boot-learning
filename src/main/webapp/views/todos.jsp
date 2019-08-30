<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="container">
		<table class="table table-striped">
			<caption>Your todos are</caption>
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it Done?</th>
					<th/>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td>
						<a href="/update-todo/${todo.id}" type="button" class="btn btn-warning">Update</a>
						<a href="/delete-todo/${todo.id}" type="button" class="btn btn-danger">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="button"> <a href="/add-todo">Add a Todo</a></div>
	</div>
			<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>