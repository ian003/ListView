package cn.zyc.test;

import java.util.List;

import cn.zyc.dao.PersonDao;
import cn.zyc.db.PersonDBHelper;
import cn.zyc.pojo.Person;
import android.test.AndroidTestCase;

public class TestDatabase extends AndroidTestCase {

	public void testDd() {
		PersonDBHelper helper = new PersonDBHelper(getContext());
		helper.getWritableDatabase();
	}

	public void testAdd() {
		PersonDao dao = new PersonDao(getContext());
		for (int i = 0; i < 50; i++) {
			dao.add("ian--" + i, "1000" + i);
		}
	}

	public void testGetAll() {
		PersonDao dao = new PersonDao(getContext());
		List<Person> persons = dao.getAll();
		for (Person p : persons) {
			System.out.println(p);
		}
	}
}
