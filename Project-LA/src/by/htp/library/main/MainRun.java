package by.htp.library.main;

import java.time.Year;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import by.htp.library.bean.AgeTypeUser;
import by.htp.library.bean.Book;
import by.htp.library.bean.StatusUser;
import by.htp.library.bean.TypeBookProtecred;
import by.htp.library.bean.User;
import by.htp.library.controller.Controller;
import by.htp.library.controller.OpenThreadActualUsers;
import by.htp.library.dao.UserDAO;
import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.impl.TXTBookDAO;
import by.htp.library.dao.impl.TXTUserDAO;

public class MainRun {
	final static TXTUserDAO txtUserDAO = new TXTUserDAO();
	final static TXTBookDAO txtBookDAO = new TXTBookDAO();
	final static Controller controller = new Controller();

	public static void main(String[] args) {
		User expectedUser = new User(3, "Khodokevich_Oleg1", "112aaa", "Oleg1", StatusUser.ADMIN, AgeTypeUser.PARENT);
//		SIGN_IN, GET_ALL_USERS, REGISTRATION, EDIT_USER, REMOVE_USER, SIGN_OUT, WRONG_REQUEST

//		txtUserDAO.registration(expectedUser);
		User actualUser = new User(3, "Khodokevich_Oleg", "111aaa", "Oleg", StatusUser.ADMIN, AgeTypeUser.PARENT);

		OpenThreadActualUsers openThreadActualUsers = OpenThreadActualUsers.getOpenThreadActualUsers();

		String request = "sign_In Khodokevich_Oleg 111aaa";
		System.out.println(controller.executeTask(request));


		request = "sign_In Khodokevich_Safina 333ccc";
		System.out.println(controller.executeTask(request));		

		request = "GET_ALL_USERS Khodokevich_Oleg 111aaa";
		System.out.println(controller.executeTask(request));
		
		
		request = "sign_OUT Khodokevich_Safina";
		System.out.println(controller.executeTask(request));
		
		
	}
}