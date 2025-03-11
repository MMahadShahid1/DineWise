package ca.sheridancollege.mahad.services; // nothing to change


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ca.sheridancollege.mahad.beans.Role;
import ca.sheridancollege.mahad.beans.User;
import ca.sheridancollege.mahad.models.AuthenticationRequest;
import ca.sheridancollege.mahad.models.AuthenticationResponse;
import ca.sheridancollege.mahad.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationService {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private JwtService jwtService;
	private AuthenticationManager authenticationManager;
	
	
	// a method to register a new user in our database, and generate a JWT for them
	public AuthenticationResponse register(AuthenticationRequest request) {
		User user = User.builder()
						.email(request.getEmail())
						.password(passwordEncoder.encode(request.getPassword()))
						.role(Role.USER)
						.build();
		userRepository.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}
	
	// a method to authenticate an existing user and generate a JWT for them
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
					request.getEmail(), request.getPassword()));
		User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}
}
