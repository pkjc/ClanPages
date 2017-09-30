package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.javafaker.Faker;
import entity.Person;

@WebServlet(urlPatterns = {"/hey"})
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Faker faker = new Faker();

		List<Person> persons = new ArrayList<>();
		String[] headlines = {"M.S. in Computer Science",
				"M.S. in Industrial Engineering",
				"M.S. in Software Engineering",
				"PHD in Embedded Systems",
				"M.S. in Software Engineering",
				"M.S. in Industrial Engineering",
				"M.S. in Software Engineering",
				"M.S. in Industrial Engineering",
				"Bach. in Computer Science",
				"Bach. in Electrical Engineering"
		};
		String[] locations = {"Pune, MH, India",
				"Nagpur, KH, India",
				"Kolhapur MH, India",
				"Delhi, Gujrat, Sri Lanka",
				"Ushabji, JG, Nepal",
				"Sneha, DU, Kkar",
				"Ahmdabad, AD, Japan",
				"Punjab, HR, Canada",
				"Ushabji, JG, Nepal",
				"Nagpur, KH, India"
		};

		for (int i = 0; i < 9; i++) {
			Person p = new Person();

			p.setName(faker.name().firstName() + " " + faker.name().lastName());
			p.setEmail(faker.internet().emailAddress());
			p.setPassword(faker.lorem().paragraph());

			persons.add(p);
		}

		req.setAttribute("personList", persons);
		req.setAttribute("headlines", headlines);
		req.setAttribute("locations", locations);
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}

}
