package com.example.sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Bundle;
import android.provider.SyncStateContract.Columns;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//每个程序都有自己的数据库 默认的情况下是各自互相不干扰
		//创建一个数据库 并且打开
		//SQLiteDatabase db = openOrCreateDatabase("user.db", MODE_PRIVATE, null);
		//原生的SQL语句
	/*	db.execSQL("create table if not exists usertb(_id integer primary key autoincrement,name text not null,age integer not null,sex text not null)");
		db.execSQL("insert into usertb(name,sex,age)values('坂田银时','男',22)");
		db.execSQL("insert into usertb(name,sex,age)values('志村新八','男',18)");
		db.execSQL("insert into usertb(name,sex,age)values('神乐','女',18)");
		db.execSQL("insert into usertb(name,sex,age)values('萨达哈鲁','狗',200)");
		
		Cursor c = db.rawQuery("select * from usertb",	null);
		if(c != null)
		{
			while (c.moveToNext()) {
				Log.i("tag", "_id:" + c.getInt(c.getColumnIndex("_id")));
				Log.i("tag", "name:" + c.getString(c.getColumnIndex("name")));
				Log.i("tag", "age:" + c.getInt(c.getColumnIndex("age")));
				Log.i("tag", "sex:" + c.getString(c.getColumnIndex("sex")));
				Log.i("tag", "!!!!!!!!!!!!!!!!!!!");
			}
			c.close();
		}
		db.close();
	
	*/
	
		//用ContentValues 来实现
//		db.execSQL("create table if not exists usertb(_id integer primary key autoincrement,name text not null,age integer not null,sex text not null)");
//		ContentValues values =  new ContentValues();
//		values.put("name", "新八");
//		values.put("sex", "男");
//		values.put("age", 18);
//		long rowId = db.insert("usertb", null, values);
//		values.clear();
//		
//		values.put("name", "银时");
//		values.put("sex", "男");
//		values.put("age", 22);
//		db.insert("usertb", null, values);
//		values.clear();
//		
//		values.put("name", "神乐");
//		values.put("sex", "女");
//		values.put("age", 18);
//		db.insert("usertb", null, values);
//		values.clear();
//		
//		values.put("name", "萨达哈鲁");
//		values.put("sex", "男");
//		values.put("age", 200);
//		db.insert("usertb", null, values);
//		values.clear();
//		
//		values.put("sex", "女");
//		db.update("usertb", values, "_id=?", new String[]{"4"});
//		db.delete("usertb", "name like", new String[]{"%新%"});
//		Cursor c = db.query("usertb", null, "_id>?", new String[]{"0"}, null, null, "name");
//		//Cursor c = db.rawQuery("select * from usertb",	null);
//		if(c != null)
//		{
//			String[] columns = c.getColumnNames();
//			while (c.moveToNext())
//			{
//				for (String columnName:columns) {
//					Log.i("tag", c.getString(c.getColumnIndex(columnName)));
//				}
//				
//			}c.close();
//		}
//			
//		db.close();
		
		DBOpenHelper helper = new DBOpenHelper(MainActivity.this, "stu.db");
//		helper.getReadableDatabase();//获取一个只读的数据库 只能查询 不能写入 不能更新
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor c =  db.rawQuery("select * form stutb", null);
		if(c != null)
			{
				String[] columns = c.getColumnNames();
				while (c.moveToNext())
				{
					for (String columnName:columns) {
						Log.i("tag",columnName + c.getString(c.getColumnIndex(columnName)));
					}
					
				}c.close();
			}
	}
	
}
