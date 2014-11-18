package per.thiennn.myuserfulfunction.localdatabase;



import per.thiennn.myusefulfunction.R;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper{
	private static final String TAG = DbHelper.class.getSimpleName();

	private static final String DATABASE_NAME = "nurse.db";
	private static final int DATABASE_VERSION = 1;
	Context context;
	
	public DbHelper(Context context) {

		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;
	}

	
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d(TAG, "onCreate()");
		Log.i(TAG, "Create tables and insert init data.");

		String[] sqls = this.context.getResources().getString(R.string.init_database).split(";");

		db.beginTransaction();
		try {
			for (String sql : sqls) {
				if (sql.trim().length() > 0) {
					Log.d(TAG, "sql:"+sql);
					db.execSQL(sql);
				}
			}
			db.setTransactionSuccessful();
		} finally {
			db.endTransaction();
		}

		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.d(TAG, "onCreate()");
		Log.i(TAG, "Upgrading databse from ver[" + oldVersion + "] to ver[" + newVersion + "].");
		Log.i(TAG, "It will destory all old data..");

		String[] sqls = this.context.getResources().getString(R.string.drop_database).split(";");

		db.beginTransaction();
		try {
			for (String sql : sqls) {
				if (sql.trim().length() > 0) {
					Log.d(TAG, "sql:"+sql);
					db.execSQL(sql);
				}
			}
			db.setTransactionSuccessful();
		} finally {
			db.endTransaction();
		}

		onCreate(db);
		
	}
}
