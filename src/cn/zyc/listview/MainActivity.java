package cn.zyc.listview;

import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import cn.zyc.dao.PersonDao;
import cn.zyc.pojo.Person;

public class MainActivity extends Activity {

	private PersonDao dao;
	private List<Person> persons;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dao = new PersonDao(this);
		persons = dao.getAll();
		ListView view = (ListView) findViewById(R.id.lv);
		view.setAdapter(new MyAdaper());
	}

	private class MyAdaper extends BaseAdapter {
		public static final String TAG = "MyAdaper";

		@Override
		public int getCount() {
			return persons.size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Log.i(TAG, "位置为：" + position);
			Person p = persons.get(position);
			/*
			 * TextView view = new TextView(getApplicationContext());
			 * view.setTextSize(20); view.setText(p.toString());
			 */
			View view = View.inflate(MainActivity.this, R.layout.list_item,
					null);
			TextView tv_id = (TextView) view.findViewById(R.id.pid);
			tv_id.setText("ID: " + p.getId());
			TextView tv_name = (TextView) view.findViewById(R.id.pname);
			tv_name.setText("姓名: " + p.getName());
			TextView tv_phone = (TextView) view.findViewById(R.id.pphone);
			tv_phone.setText("电话: " + p.getPhone());
			return view;
		}

	}
}
