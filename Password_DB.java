package hacknjit2019;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor; 
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class Password_DB extends SQLiteOpenHelper {
	public static final String DATABASE_NAME = "pass_data.db";
	
	public static final String TABLE_NAME = "password_table";
	
	public static final String col1 = "password"; 
	
	public Password_DB(Context context) {
		super(context, DATABASE_NAME, factory:null, version: 1);
	}
 public void onCreate(SQLiteDatabase db) {
 db.execSQL("CREATE TABLE" + TABLE_NAME + "( password TEXT )" ); 
}
 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	 db.execSQL("DROP TABLE IF EXIST "+ TABLE_NAME)
	 }
 }
 public boolean insertData(String name) {
	 SQLiteDatabase db = this.getWritableDatabase();
	 ContentValues contentValues = new ContentValues();
	 contentValues.put(col1,name);
	 
	 long result = db.insert(TABLE_NAME, .nullColumnHack: null, contentValues);
	 db.close();
	 
	 if (result == -1) {
		 return false;
	 }
	 else {
		 return true;
	 }
 }
 public Cursor getAllData() {
	 SQLiteDatabase db = this.getWritableDatabase();
	 Cursor res = db.rawQuerry(sql: "Select * from "+ TABLE_NAME, selectionArgs: null);
	 return res;
 }
 public boolean updateData(String name, String pass) {
	SQLiteDatabase db = this.getWritableDatabase();
	ContentValues contentValues = new ContentValues(); 
	
	db.update(TABLE_NAME, contentValues, whereClause: col1+" =?", new String[] {name} );
	return true;
 }
 public Integer deleteData(String) {
	 SQLiteDatabase db = this.getWritableDatabase();
	 int i = db.delete(TABLE_NAME, whereClause: col1 +" =?", new String[] {name});
	 return i;
 }
 
