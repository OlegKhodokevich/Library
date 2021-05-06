package by.htp.library.controller;

import java.util.ArrayList;
import java.util.List;

import by.htp.library.bean.User;

public class OpenThreadActualUsers {
	private static OpenThreadActualUsers instance;

	private List<User> activeListUsers;

	public OpenThreadActualUsers() {
		activeListUsers = new ArrayList<User>();
	}

	public static OpenThreadActualUsers getOpenThreadActualUsers() {
		if (instance == null) {
			synchronized (OpenThreadActualUsers.class) {
				if (instance == null) {
					instance = new OpenThreadActualUsers();
				}
			}
		}
		return instance;
	}

	public void addUser(User user) {
		activeListUsers.add(user);
	}

	public void revomeUser(String login) {

		int i = 0;
		while (i < activeListUsers.size()) {
			if (activeListUsers.get(i).getLogin().equals(login)) {
				activeListUsers.remove(i);
				i = activeListUsers.size();
			}
			i++;
		}
	}

	public List<User> getActiveListUsers() {
		List<User> newUserList = new ArrayList<User>();

		for (int i = 0; i < activeListUsers.size(); i++) {
			newUserList.add(activeListUsers.get(i));
		}

		return newUserList;
	}
}
