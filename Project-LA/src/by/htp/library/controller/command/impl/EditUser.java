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

public class EditUser implements Command {
	private static final String DELIMITER = " ";

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

			User user = null;

			int lastIndex = request.indexOf(DELIMITER);
			login = request.substring(0, lastIndex);
			request = request.substring(lastIndex + 1);

			lastIndex = request.indexOf(DELIMITER);
			password = request.substring(0, lastIndex);
			request = request.substring(lastIndex + 1);

			UserCreator userCreator = creator.getUserCreator();

			try {
				user = userCreator.createUserByString(request);
			} catch (DAOLibraryException e1) {
				throw new ControllerLibraryException(e1);
			}

			ClientService clientService = creator.getClientService();
			boolean result = false;

			try {
				result = clientService.editUser(login, password, user);
			} catch (ServiceLibraryException e) {
				throw new ControllerLibraryException(e);
			}

			if (result) {
				responce = "User " + login + " has edited to " + user.getLogin();
			} else {
				responce = "User with that login = " + login + " and password = " + password + "  is not exist.";
			}

		} else {
			responce = "You did not sign in as admin. ";
		}

		return responce;
	}

}
