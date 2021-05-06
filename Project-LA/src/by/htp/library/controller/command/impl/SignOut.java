package by.htp.library.controller.command.impl;

import by.htp.library.controller.OpenThreadActualUsers;
import by.htp.library.controller.command.Command;
import by.htp.library.controller.exeption.ControllerLibraryException;

public class SignOut implements Command {

	@Override
	public String execute(String request) throws ControllerLibraryException {
		String login = request;

		OpenThreadActualUsers openThreadActualUsers = OpenThreadActualUsers.getOpenThreadActualUsers();
		openThreadActualUsers.revomeUser(login);

		StringBuilder responce = new StringBuilder();
		responce.append("User ");
		responce.append(login);
		responce.append(" has signed out.");

		return responce.toString();
	}

}
