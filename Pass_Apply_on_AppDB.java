package hacknjit2019;

public class Pass_Apply_on_AppDB {

	public static final String DATABASE_NAME = "logg.db";
	public static final String TABLE_NAME = "apps";
	
	public static final String col1 = "package_name";
	public static final String col2 = "apps";
	
	public Pass_Apply_on_AppDB(Context context) {
		super(context, DATABASE_NAME, factor:null, version: 1);
		
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("Create Table " + TABLE_NAME + "(package_name TEXT PRIMARY KEY , password TEXT)");
		
	}
	@Override
	public void onUpgrade(SqLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("Drop Table IF EXISTS " + TABLE_NAME); )
	}
	public boolean insertData(String name, String pass) {
		
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues content Values = new ContentValues();
		contentValues.put(col1,name);
		contentValues.put(col2,pass);
		
		long result = db.insert(TABLE_NAME, nullColumnHack: null, contentValues);
		db.close();
		
		if(result == -1) {
			return false;
		}
		else {
			return true;
		}
	}
	public Cursor getAllData() {
		SQLiteDatabase db = this .getWritableDatabase();
		Cursor res = db.rawQuerry(sql: "Select * from "+TABLE_NAME, selectionArgs: null);
	}
	public boolean updateData(String name, String pass) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(col2,pass);
		db.update(TABLE_NAME, contentValues, whereClause:col1+ " =?", new String[] {name});
		return true;
	}
	public Integer deleteData(String name) {
		SQLiteDatabase db = this.getWritableDatabase();
		int i = db.delete(TABLE_NAME, whereClause: col1+" =?", new String[] {name});
		return i;
	}
	}

