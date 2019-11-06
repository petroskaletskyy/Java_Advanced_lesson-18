<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<title>Lesson-18</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div style="margin: 15px; font-size: 14px; color: green;" class="navbar-header" >Spring MVC -Logos</div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">All participants</a></li>
            <li><a href="new">new Participants</a></li>
        </ul>
    </div>
</nav>

	<div class="container">

		<c:choose>
			<c:when test="${mode == 'PARTISIPANT_VIEW'}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Email</th>
							<th>Level</th>
							<th>Primary skill</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="partisipant" items="${partisipants}">
							<tr>
								<td>${partisipant.id}</td>
								<td>${partisipant.name}</td>
								<td>${partisipant.email}</td>
								<td>${partisipant.level}</td>
								<td>${partisipant.primarySkill}</td>
								<td><a href="update?id= ${partisipant.id}">Edit</a></td>
								<td><a href="delete?id= ${partisipant.id}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>

			<c:when test="${mode == 'PARTISIPANT_EDIT' || mode == 'PARTISIPANT_CREATE'}">
				<form action="save" method="POST">
				
				<input type="hidden" value="${partisipant.id}" class="form-control" id="id" name="id">
				
					<div class="form-group">
						<label for="name">Partisipant Name:</label> <input type="text"
							class="form-control" id="name" name="name"
							value="${partisipant.name}">
					</div>


					<div class="form-group">
						<label for="email">Partisipant Email:</label> <input type="text"
							class="form-control" id="email" name="email"
							value="${partisipant.email}">
					</div>
					
					 <div class="form-group">
                    <label for="level">Level:</label>
                    <select class="form-control" id="level" name="level" value="${participant.level}">
                        <option disabled>Choose level</option>
                        <option selected>L1</option>
                        <option>L2</option>
                        <option>L3</option>
                        <option>L4</option>
                        <option>L5</option>
                    </select>
                </div>
					
					<div class="form-group">
						<label for="primarySkill">Primary Skill:</label> <input type="text"
							class="form-control" id="primarySkill" name="primarySkill"
							value="${partisipant.primarySkill}">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</c:when>

		</c:choose>
	</div>
</body>
</html>