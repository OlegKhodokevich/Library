package by.htp.library.controller.command;

import by.htp.library.controller.exeption.ControllerLibraryException;

public interface Command {
	public String execute(String request) throws ControllerLibraryException;

}
