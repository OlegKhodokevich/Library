package by.htp.library.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp.library.controller.command.Command;
import by.htp.library.controller.command.impl.AddBook;
import by.htp.library.controller.command.impl.DeleteBook;
import by.htp.library.controller.command.impl.EditUser;
import by.htp.library.controller.command.impl.EditeBook;
import by.htp.library.controller.command.impl.GetAllUsers;
import by.htp.library.controller.command.impl.GetInfoAllBooks;
import by.htp.library.controller.command.impl.GetInfoAllBooksByAutor;
import by.htp.library.controller.command.impl.GetInfoBook;
import by.htp.library.controller.command.impl.Registration;
import by.htp.library.controller.command.impl.RemoveUser;
import by.htp.library.controller.command.impl.SignIn;
import by.htp.library.controller.command.impl.SignOut;
import by.htp.library.controller.command.impl.WrongRequest;

public class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<CommandName, Command>();

	public CommandProvider() {
		repository.put(CommandName.SIGN_IN, new SignIn());
		repository.put(CommandName.GET_ALL_USERS, new GetAllUsers());
		repository.put(CommandName.REGISTRATION, new Registration());
		repository.put(CommandName.EDIT_USER, new EditUser());
		repository.put(CommandName.REMOVE_USER, new RemoveUser());
		repository.put(CommandName.SIGN_OUT, new SignOut());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
		repository.put(CommandName.GET_INFO_BOOK, new GetInfoBook());
		repository.put(CommandName.GET_ALL_BOOKS, new GetInfoAllBooks());
		repository.put(CommandName.GET_INFO_ALL_BOOK_BY_AUTOR, new GetInfoAllBooksByAutor());
		repository.put(CommandName.ADD_BOOK, new AddBook());
		repository.put(CommandName.EDITE_BOOK, new EditeBook());
		repository.put(CommandName.DELETE_BOOK, new DeleteBook());
	}

	Command getComand(String name) {
		CommandName commandName = null;
		Command command = null;
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}
}
