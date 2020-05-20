<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Holo Biblioteka</h1>

	<form method="post" action="SearchBooksServlet">

		<table>
			<tr>
				<td><input type="text" name="SzukanaFraza">Wyszukaj
					fraze</td>
				<td><input type="submit" value="Wyszukaj"></td>
			</tr>
		</table>

	</form>

</body>
</html>