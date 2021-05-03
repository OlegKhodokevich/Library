package by.htp.library.controller.command.impl;

import by.htp.library.bean.User;
import by.htp.library.controller.CreatorForController;
import by.htp.library.controller.command.Command;
import by.htp.library.controller.exeption.ControllerLibraryException;
import by.htp.library.controller.parser.ParserRequest;
import by.htp.library.controller.validator.ValidateAdmin;
import by.htp.library.controller.validator.ValidatorRequestOfStringUser;
import by.htp.library.dao.creator.UserCreator;
import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.service.ClientService;
import by.htp.library.service.exception.ServiceLibraryException;

public class Registration implements Command {

	@Override
	public String execute(String request) throws ControllerLibraryException {
		if (request == null || !ValidatorRequestOfStringUser.validateStringForCreateUser(request)) {
			throw new ControllerLibraryException("Request for registration not correct.");
		}

		String responce = null;

		CreatorForController creator = CreatorForController.getInstanceCreator();
		boolean permission = ValidateAdmin.validateAdmin(request);

		ParserRequest parserRequest = creator.getParserRequest();
		request = parserRequest.parseAndDeliteParamAdminFromRequest(request);

		if (permission) {
			User user = null;
			UserCreator userCreator = creator.getUserCreator();

			try {
				user = userCreator.createUserByString(request);
			} catch (DAOLibraryException e1) {
				throw new ControllerLibraryException(e1);
			}

			ClientService clientService = creator.getClientService();
			boolean result = false;

			try {
				result = clientService.registration(user);
			} catch (ServiceLibraryException e) {
				throw new ControllerLibraryException(e);
			}

			if (result) {
				responce = "User" + user.getLogin() + " has registreted.";
			} else {
				responce = "User with login " + user.getLogin() + " is exist.";
			}
		} else {
			responce = "You did not sign in as admin. ";
		}

		return responce;
	}

}
