package by.htp.library.controller;

import by.htp.library.controller.command.Command;
import by.htp.library.controller.exeption.ControllerLibraryException;

public final class Controller {
	private final CommandProvider provider = new CommandProvider();

	private final char paramDelimiter = ' ';

	public String executeTask(String request) {
		String commandName;
		Command actualCommand = null;

		if (request.contains(String.valueOf(paramDelimiter))) {
			commandName = request.substring(0, request.indexOf(paramDelimiter));
			actualCommand = provider.getComand(commandName);
			request = request.substring(request.indexOf(paramDelimiter)).trim();
		} else {
			actualCommand = provider.getComand(request);
			request = "";
		}

		String responce = null;

		try {
			responce = actualCommand.execute(request);
		} catch (ControllerLibraryException e) {
			e.printStackTrace();
		}

		return responce;
	}

}
