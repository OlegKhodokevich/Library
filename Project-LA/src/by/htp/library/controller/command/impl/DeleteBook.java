package by.htp.library.controller.command.impl;

import java.util.List;

import by.htp.library.controller.CreatorForController;
import by.htp.library.controller.command.Command;
import by.htp.library.controller.exeption.ControllerLibraryException;
import by.htp.library.controller.parser.ParserRequest;
import by.htp.library.controller.validator.ValidateAdmin;
import by.htp.library.service.LibraryService;
import by.htp.library.service.exception.ServiceLibraryException;

public class DeleteBook implements Command {

	@Override
	public String execute(String request) throws ControllerLibraryException {

		String responce = null;

		CreatorForController creator = CreatorForController.getInstanceCreator();
		boolean permission = ValidateAdmin.validateAdmin(request);

		ParserRequest parserRequest = creator.getParserRequest();
		request = parserRequest.parseAndDeliteParamAdminFromRequest(request);

		if (permission) {
			String name = null;
			String autor = null;

			boolean result = false;

			List<String> paramsRequest = parserRequest.parseParamsFromRequest(request);

			name = paramsRequest.get(0);
			autor = paramsRequest.get(1);

			LibraryService libraryService = creator.getLibraryService();
			try {
				result = libraryService.deleteBook(name, autor);
			} catch (ServiceLibraryException e) {
				throw new ControllerLibraryException(e);
			}

			if (result) {
				responce = "Book " + name + " has deleted.";
			} else {
				responce = "Book with that name = " + name + " and autor = " + autor + "  is not exist.";
			}
		} else {
			responce = "You did not sign in as admin. ";
		}

		return responce;
	}

}
