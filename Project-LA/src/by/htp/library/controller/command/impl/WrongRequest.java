package by.htp.library.controller.command.impl;

import by.htp.library.controller.command.Command;
import by.htp.library.controller.exeption.ControllerLibraryException;

public class WrongRequest implements Command{
	@Override
	public String execute(String request) throws ControllerLibraryException {
	
		return "wrong request";
	}

}
