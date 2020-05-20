package Biblioteka;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchBooksServlet
 */
@WebServlet("/SearchBooksServlet")
public class SearchBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchBooksServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		init();

		String fraza = request.getParameter("SzukanaFraza");

		if (fraza.isEmpty())
			response.sendRedirect("Index.jsp");
		else {
			// Wyszukaj w bazie
			List<Book> ksiazki = wyszukaj(fraza);
			// Wyslij ksiazki w odpowiedzi
			request.setAttribute("data", ksiazki);

			RequestDispatcher rd = request.getRequestDispatcher("SearchResult.jsp");

			rd.forward(request, response);
			// response.sendRedirect("SearchResult.jsp");
		}

		doGet(request, response);
	}

	public void init() {
		// 1. Load JDBC driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Book> wyszukaj(String fraza) {
		List<Book> result = new ArrayList<>();

		String url = "jdbc:mysql://localhost:3306/db_biblioteka?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Warsaw";
		String dbUsername = "s17186";
		String dbPassword = "";
		String query = "select b.title, a.firstname, a.surname \r\n" + 
				"from book as b \r\n" + 
				"join author as a \r\n" + 
				"on b.author_id=a.author_id\r\n" + 
				"where b.title like '%"+fraza+"%'\r\n" +
				"or a.surname like '%" +fraza +"%'\r\n" +
				"or a.firstname like '%" +fraza +"%'; ";
		try {

			// 2. Create a connection
			Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);

			// 3. Create a statement
			Statement st = con.createStatement();

			// 4. Create a ResultSet
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Book book = new Book(rs.getString("title"),
						new Author(rs.getString("firstname"), rs.getString("surname")));

				result.add(book);
			}
			// 5. Close all connections
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;

	}

}
