<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Pokemon</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>PM - Pokedex Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Pokemon</h3>
	
		<form:form action="savePokemon" modelAttribute="pokemon" method="POST">

			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Name Pokemon:</label></td>
						<td><form:input path="namePokemon" /></td>
					</tr>
				
					<tr>
						<td><label>Type:</label></td>
						<td><form:input path="type" /></td>
					</tr>

					<tr>
						<td><label>Ability:</label></td>
						<td><form:input path="ability" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/mvc/Pokemons">Back to List</a>
		</p>
	
	</div>

</body>

</html>









