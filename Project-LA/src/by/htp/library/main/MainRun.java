package by.htp.library.main;

import by.htp.library.controller.Controller;
import by.htp.library.dao.impl.TXTBookDAO;
import by.htp.library.dao.impl.TXTUserDAO;

public class MainRun {
	final static TXTUserDAO txtUserDAO = new TXTUserDAO();
	final static TXTBookDAO txtBookDAO = new TXTBookDAO();
	final static Controller controller = new Controller();

	public static void main(String[] args) {

		String request = "sign_In Khodokevich_Oleg 111aaa";
		System.out.println(controller.executeTask(request));

		request = "sign_In Khodokevich_Safina 333ccc";
		System.out.println(controller.executeTask(request));

		request = "GET_ALL_USERS Khodokevich_Oleg 111aaa";
		System.out.println(controller.executeTask(request));

		request = "sign_OUT Khodokevich_Safina";
		System.out.println(controller.executeTask(request));

		request = "REMOVE_rSER Khodokevich_Oleg 111aaa Khodokevich_Safina 334ccc";
		System.out.println(controller.executeTask(request));

		request = "REMOVE_USER Khodokevich_Oleg 111aaa Khodokevich_Safina 334ccc";
		System.out.println(controller.executeTask(request));

		request = "REMOVE_USER Khodokevich_Oleg 111aaa Khodokevich_Safina 333ccc";
		System.out.println(controller.executeTask(request));

		request = "GET_ALL_USERS Khodokevich_Oleg 111aaa";
		System.out.println(controller.executeTask(request));

		request = "REGISTRATION Khodokevich_Oleg 111aaa Khodokevich_Safina 333ccc Safina guest child";
		System.out.println(controller.executeTask(request));

		request = "GET_ALL_USERS Khodokevich_Oleg 111aaa";
		System.out.println(controller.executeTask(request));

		// 2/John Marrs/The One/detective/2020/paper/no_baby/Peter
		// GET_INFO_BOOK, GET_ALL_BOOKS, GET_INFO_ALL_BOOK_BY_AUTOR, ADD_BOOK,
		// EDITE_BOOK, DELETE_BOOK, CHANGE_BOOKKEEPER
		request = "GET_INFO_BOOK Wild of palin/Aleksey Pehov";
		System.out.println(controller.executeTask(request));

		request = "GET_ALL_BOOKS";
		System.out.println(controller.executeTask(request));

		request = "GET_INFO_ALL_BOOK_BY_AUTOR John Marrs";
		System.out.println(controller.executeTask(request));

		request = "ADD_BOOK Khodokevich_Oleg 111aaa Koil/France/detective/2020/paper/no_baby/Peter";
		System.out.println(controller.executeTask(request));

		request = "EDITE_BOOK Khodokevich_Oleg 111aaa John Marrs/The One/Johngr Marrs/The Two/detective/2020/paper/no_baby/Peter";
		System.out.println(controller.executeTask(request));

		request = "DELETE_BOOK Khodokevich_Oleg 111aaa John Marrs/The One";
		System.out.println(controller.executeTask(request));
	}
}