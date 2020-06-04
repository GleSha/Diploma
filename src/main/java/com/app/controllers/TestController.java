package com.app.controllers;

import com.app.repository.StudentRepository;
import com.app.repository.UserRepository;
import com.app.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private StudentRepository studentRepository;


	//запрос вида "api/test/all?date=2020-04-05"
	@GetMapping("/all")
	public String allAccess(@RequestParam("date")
								@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
		String strDate = "03.06.2020";
		String strDate1 = "20.06.2020";
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		String error = "";
		java.sql.Date date2 = null;
		java.sql.Date date1 = null;
		try {
			date2 = new java.sql.Date(sdf.parse(strDate).getTime());
			date1 = new java.sql.Date(sdf.parse(strDate1).getTime());
		}
		catch (ParseException parseException) {
			error = parseException.getLocalizedMessage();
		}
		
		if (date2 != null) {

			return date2.before(date) + " " + date2.toString() + date.toString();

		}
		else {
			return "Public Content.";
		}

	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}



	@PostMapping("/upload")
	public byte[] uploadFile(@RequestParam("file") MultipartFile multipartFile) {

		byte[] bytes = null;

		try {
			bytes = multipartFile.getBytes();

			File file = new File("asd");
			multipartFile.transferTo(file);

		}
		catch (IOException e) {
			e.printStackTrace();
			bytes = null;
		}
		return bytes;
	}

}
