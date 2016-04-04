package com.pba.lookup.web.asic;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pba.lookup.entities.ASICDocument;
import com.pba.lookup.exceptions.NotFoundException;
import com.pba.lookup.service.LookupService;
import com.pba.lookup.web.RestBase;

@RestController
public class CompanySearch extends RestBase {
	private static final Logger logger = Logger.getLogger(CompanySearch.class.getName());
	private static final String ERROR_MESSAGE = "General error occured while performing ASIC Company lookup";
	@Autowired
	private LookupService lookupService;

	@RequestMapping(value = "ASIC/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String searchByName(@RequestParam("name") String name,
			@RequestParam(required = false, name = "limit") Integer limit) {
		try {

			List<ASICDocument> documents = lookupService.searchByName(name, limit);
			ObjectMapper mapper = new ObjectMapper();

			String json = mapper.writeValueAsString(documents);
			return json;
		} catch (NotFoundException nf) {
			/* TODO */
			return null;
		} catch (Exception ex) {
			/* TODO */
			logger.log(Level.SEVERE, ERROR_MESSAGE, ex);
			return null;
		}

	}

	@RequestMapping(value = "ASIC/validate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String validateABN(@RequestParam("abn") String abn) {
		try {

			ASICDocument documents = lookupService.validateByABN(abn);
			ObjectMapper mapper = new ObjectMapper();

			String json = mapper.writeValueAsString(documents);
			return json;
		} catch (NotFoundException nf) {
			/* TODO */
			return null;
		} catch (Exception ex) {
			/* TODO */
			logger.log(Level.SEVERE, ERROR_MESSAGE, ex);
			return null;
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
