package cn.zyc.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.zyc.db.PersonDBHelper;
import cn.zyc.pojo.Person;

public class PersonDao {

	private PersonDBHelper helper;

	public PersonDao(Context context) {
		this.helper = new PersonDBHelper(context);
	}

	public void add(String name, String phone) {
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("phone", phone);
		db.insert("person", null, values);
		db.close();
	}

	public List<Person> getAll() {
		List<Person> persons = new ArrayList<Person>();
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.query("person",
				new String[] { "id", "name", "phone" }, null, null, null, null,
				null);
		while (cursor.moveToNext()) {
			int id = cursor.getInt(0);
			String name = cursor.getString(1);
			String phone = cursor.getString(2);
			Person person = new Person(id, name, phone);
			persons.add(person);

		}
		db.close();
		return persons;
	}

}
