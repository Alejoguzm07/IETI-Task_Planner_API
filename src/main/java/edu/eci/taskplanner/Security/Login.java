package edu.eci.taskplanner.Security;

import edu.eci.taskplanner.model.User;
import edu.eci.taskplanner.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.Date;

@RestController
@RequestMapping("/login")
public class Login {

	@Autowired UserService userService;

	@PostMapping()
	public Token login( @RequestBody User login)
			throws ServletException
	{

		String jwtToken = "";

		if ( login.getFullname() == null || login.getPassword() == null )
		{
			throw new ServletException( "Please fill in username and password" );
		}

		String username = login.getEmail();
		String password = login.getPassword();

		User user = userService.getByEmail(username);

		if ( user == null )
		{
			throw new ServletException( "User username not found." );
		}

		String pwd = user.getPassword();

		if ( !password.equals( pwd ) )
		{
			throw new ServletException( "Invalid login. Please check your name and password." );
		}

		jwtToken = Jwts.builder().setSubject(username).claim("roles", "user").setIssuedAt(new Date()).signWith(
				SignatureAlgorithm.HS256, "secretkey").compact();

		return new Token( jwtToken );
	}
}
