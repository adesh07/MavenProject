package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestClass {

	public static void main(String[] args) throws Exception {

		// testSearch();
		testAdd();
	}

	private static void testAdd() throws Exception{

		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setFirstName("AAA");
		bean.setLastName("ZZZ");
		bean.setLoginId("aaa@kkk.com");
		bean.setPassword("123");
		bean.setDob(new java.sql.Date(122, 12, 30));
		model.add(bean);
	}

	private static void testSearch() throws Exception {

		UserModel model = new UserModel();
		List list = model.search();

		Iterator itr = list.iterator();

		while (itr.hasNext()) {
			UserBean bean = (UserBean) itr.next();
			System.out.print(bean.getId());
			System.out.print(bean.getFirstName());
			System.out.print(bean.getLastName());
			System.out.print(bean.getLoginId());
			System.out.print(bean.getPassword());
			System.out.println(bean.getDob());
		}
	}
}
