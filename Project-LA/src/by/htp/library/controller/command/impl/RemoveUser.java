package by.htp.library.controller.command.impl;

import java.util.List;

import by.htp.library.controller.CreatorForController;
import by.htp.library.controller.command.Command;
import by.htp.library.controller.exeption.ControllerLibraryException;
import by.htp.library.controller.parser.ParserRequest;
import by.htp.library.controller.validator.ValidateAdmin;
import by.htp.library.controller.validator.ValidatorRequestOfStringUser;
import by.htp.library.service.ClientService;
import by.htp.library.service.exception.ServiceLibraryException;

public class RemoveUser implements Command {

	@Override
	public String execute(String request) throws ControllerLibraryException {
		if (request == null || !ValidatorRequestOfStringUser.validateStringForEditeUser(request)) {
			throw new ControllerLibraryException("Request for registration not correct.");
		}

		String responce = null;

		CreatorForController creator = CreatorForController.getInstanceCreator();
		boolean permission = ValidateAdmin.validateAdmin(request);

		ParserRequest parserRequest = creator.getParserRequest();
		request = parserRequest.parseAndDeliteParamAdminFromRequest(request);

		if (permission) {
			String login = null;
			String password = null;

			boolean result = false;

			List<String> paramsRequest = parserRequest.parseParamsFromRequest(request);

			login = paramsRequest.get(0);
			password = paramsRequest.get(1);

			ClientService clientService = creator.getClientService();
			try {
				result = clientService.removeUser(login, password);
			} catch (ServiceLibraryException e) {
				throw new ControllerLibraryException(e);
			}

			if (result) {
				responce = "User " + login + " has removed.";
			} else {
				responce = "User with that login = " + login + " and password = " + password + "  is not exist.";
			}
		} else {
			responce = "You did not sign in as admin. ";
		}

		return responce;
	}

}
