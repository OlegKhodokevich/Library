package by.htp.library.controller.command.impl;

import java.util.ArrayList;
import java.util.List;

import by.htp.library.bean.User;
import by.htp.library.controller.CreatorForController;
import by.htp.library.controller.command.Command;
import by.htp.library.controller.exeption.ControllerLibraryException;
import by.htp.library.controller.parser.ParserRequest;
import by.htp.library.controller.validator.ValidateAdmin;
import by.htp.library.controller.validator.ValidatorRequestOfStringUser;
import by.htp.library.service.ClientService;
import by.htp.library.service.exception.ServiceLibraryException;

public class GetAllUsers implements Command {

	@Override
	public String execute(String request) throws ControllerLibraryException {
		if (request == null || !ValidatorRequestOfStringUser.validateStringForGetAllUser(request)) {
			throw new ControllerLibraryException("Request for registration not correct.");
		}
		String responce = null;

		CreatorForController creator = CreatorForController.getInstanceCreator();
		boolean permission = ValidateAdmin.validateAdmin(request);

		ParserRequest parserRequest = creator.getParserRequest();
		request = parserRequest.parseAndDeliteParamAdminFromRequest(request);

		List<User> users = new ArrayList<User>();

		System.out.println(permission); 								//TODO
		if (permission) {

			ClientService clientService = creator.getClientService();

			try {
				users = clientService.getAllUsers();
			} catch (ServiceLibraryException e) {
				throw new ControllerLibraryException(e);
			}

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("The following users are registered: \n");

			for (int i = 0; i < users.size(); i++) {
				stringBuilder.append(users.toString());
				if (i != users.size() - 1) {
					stringBuilder.append("\n");
				}
			}
			responce = stringBuilder.toString();

		} else {
			responce = "You did not sign in as admin. ";
		}

		return responce;
	}

}
