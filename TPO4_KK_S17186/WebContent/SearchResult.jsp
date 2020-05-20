<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Biblioteka.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Lista znalezionych ksiazek</title>
</head>
<body>
	<h1>Wyniki wyszukiwania:</h1>

	<table border="1" width="500" align="center">
		<tr bgcolor="00FF7F">
			<th><b>Tytul</b></th>
			<th><b>Imie autora</b></th>
			<th><b>Nazwisko autora</b></th>
		</tr>
		<%-- Fetching the attributes of the request object 
             which was previously set by the servlet  
              "Search.java" 
        --%>
		<%
			ArrayList<Book> books = (ArrayList<Book>) request.getAttribute("data");
			for (Book b : books) {
		%>
		<%-- Arranging data in tabular form 
        --%>
		<tr>
			<td><%=b.getTitle()%></td>
			<td><%=b.getAuthor().getFirstname()%></td>
			<td><%=b.getAuthor().getSurname()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<hr />
</body>
</html>