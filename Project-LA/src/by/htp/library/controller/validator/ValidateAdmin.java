package by.htp.library.controller.validator;

import java.util.List;

import by.htp.library.bean.StatusUser;
import by.htp.library.bean.User;
import by.htp.library.controller.OpenThreadActualUsers;

public class ValidateAdmin {
	private static final String DELIMITER = " ";

	public static boolean validateAdmin(String request) {
		boolean permission = false;

		String loginAdmin = null;
		String passwordAdmin = null;
		int lastindex = request.indexOf(DELIMITER);
		loginAdmin = request.substring(0, lastindex);
		request = request.substring(lastindex + 1).trim();

		lastindex = request.indexOf(DELIMITER);
		if (lastindex == -1) {
			passwordAdmin = request.substring(0);
		} else {
			passwordAdmin = request.substring(0, lastindex);
		}

		request = request.substring(lastindex + 1);

		OpenThreadActualUsers openThreadActualUsers = OpenThreadActualUsers.getOpenThreadActualUsers();
		List<User> activeUsers = openThreadActualUsers.getActiveListUsers();

		for (int i = 0; i < activeUsers.size(); i++) {
			if (activeUsers.get(i).getLogin().equals(loginAdmin)
					&& activeUsers.get(i).getPassword().equals(passwordAdmin)
					&& activeUsers.get(i).getStatus() == StatusUser.ADMIN) {
				permission = true;
			}
		}

		return permission;
	}
}
