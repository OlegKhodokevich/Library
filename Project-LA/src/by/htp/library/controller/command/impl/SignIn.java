package by.htp.library.controller.command.impl;

import java.util.List;
import java.util.Optional;

import by.htp.library.bean.User;
import by.htp.library.controller.CreatorForController;
import by.htp.library.controller.OpenThreadActualUsers;
import by.htp.library.controller.command.Command;
import by.htp.library.controller.exeption.ControllerLibraryException;
import by.htp.library.controller.parser.ParserRequest;
import by.htp.library.controller.validator.ParamUserValidator;
import by.htp.library.service.ClientService;
import by.htp.library.service.exception.ServiceLibraryException;

public class SignIn implements Command {

	@Override
	public String execute(String request) throws ControllerLibraryException {		
		if (request == null || !ParamUserValidator.validateDataForSignIn(request)) {
			throw new ControllerLibraryException("Request for sign in not correct.");
		}

		String login = null;
		String password = null;
		String responce = null;
		Optional<User> user = null;

		CreatorForController creator = CreatorForController.getInstanceCreator();
		ParserRequest parserRequest = creator.getParserRequest();
		List<String> paramsRequest = parserRequest.parseParamsFromRequest(request);

		login = paramsRequest.get(0);
		password = paramsRequest.get(1);

		ClientService clientService = creator.getClientService();
		try {
			user = clientService.signIn(login, password);
		} catch (ServiceLibraryException e) {
			throw new ControllerLibraryException(e);
		}

		if (user != null && user.isPresent()) {
			responce = "Wellcom!" + user.get().toString();
			
			OpenThreadActualUsers openThreadActualUsers = OpenThreadActualUsers.getOpenThreadActualUsers();
			openThreadActualUsers.addUser(user.get());			

		} else {
			responce = "User with that login = " + login + " and password = " + password + "  is not exist.";
		}
		
		System.out.println();
		return responce;
	}

}
