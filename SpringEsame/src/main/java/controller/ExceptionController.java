package controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import eccezioni.ErrorRequestException;

@Controller
public class ExceptionController {
	@ExceptionHandler(ErrorRequestException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Errore richiesta!")
	public String gestoreEccezioni(ErrorRequestException ex) {
		return "errorView";
	}
	@RequestMapping(value="/") 
	public String handler() throws ErrorRequestException {
		throw new ErrorRequestException("C'è un problema");
	}
}
