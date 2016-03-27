package com.pba.lookup.web.asic;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pba.lookup.exceptions.NotFoundException;
import com.pba.lookup.service.LookupService;

@RestController
public class CompanySearch {
	private static final Logger logger = Logger.getLogger(CompanySearch.class.getName());
	private static final String ERROR_MESSAGE = "General error occured while performing ASIC Company lookup";
	@Autowired
	private LookupService lookupService;

	@RequestMapping(value = "ASIC/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getResponse(@RequestParam("name") String name) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(lookupService.getCompanyByName(name));
			return new ResponseEntity<>(json, HttpStatus.OK);
		} catch (NotFoundException nf) {
			/* TODO */
			return new ResponseEntity<>("Resource not found", HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			/* TODO */
			logger.log(Level.SEVERE, ERROR_MESSAGE, ex);
			return new ResponseEntity<>("General Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ExceptionHandler
	public String handleTodoNotFound(Exception ex) {
		if (ex instanceof DataAccessException) {
			return "Data Acces Exception";
		}

		return ex.getMessage() + " " + ex.getClass().getName();
	}
}
