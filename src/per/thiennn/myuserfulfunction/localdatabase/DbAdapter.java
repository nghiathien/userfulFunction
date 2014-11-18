package per.thiennn.myuserfulfunction.localdatabase;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DbAdapter {
	private static final String TAG = "DbAdapter";
	private static final String TABLE_SHIFT = "TSHIFT";
	private Context context;

	private DbHelper mDbHelper;
	private SQLiteDatabase mDatabase;

	public DbAdapter(Context context) {
		this.context = context;
		mDbHelper = new DbHelper(context);
	}

	public DbAdapter open() throws SQLException {

		mDatabase = mDbHelper.getWritableDatabase();
		return this;
	}

	public void start() {
		mDatabase.beginTransaction();
	}

	public void end() {
		mDatabase.setTransactionSuccessful();
		mDatabase.endTransaction();
	}

	public void close() {
		mDbHelper.close();
	}
	/**
	 * @nonJavadoc
	 * - Function : get-delete-insert-update example
	 */
	// *********************Begin query******************************************************
	// *********************LOCATION OF SHIFT TABLE******************************************
	// *********************Get all data shift***********************************************
	//	public List<ShiftDTO> getShiftData() {
	//		open();
	//		String sql = this.context.getResources().getString(
	//				R.string.get_all_data_tshift);
	//		Cursor cursor = mDatabase.rawQuery(sql, null);
	//
	//		List<ShiftDTO> list = new ArrayList<ShiftDTO>();
	//		if (cursor.moveToFirst()) {
	//			do {
	//				ShiftDTO shiftData = new ShiftDTO();
	//				shiftData.setShiftID(cursor.getInt(cursor.getColumnIndex("shift_id")));
	//				shiftData.setShiftLable(cursor.getString(cursor.getColumnIndex("shift_lable")));
	//				shiftData.setShiftColor(cursor.getString(cursor.getColumnIndex("shift_color")));
	//				shiftData.setShiftTimeStar(cursor.getString(cursor.getColumnIndex("shift_start")));
	//				shiftData.setShiftTimeEnd(cursor.getString(cursor.getColumnIndex("shift_end")));
	//				shiftData.setShiftAlert(cursor.getString(cursor.getColumnIndex("shift_time")));
	//				shiftData.setShiftLoop(cursor.getInt(cursor.getColumnIndex("shift_loop")));
	//				list.add(shiftData);
	//				Log.d(TAG, "get Shift Data shift" + cursor.getString(1));
	//			} while (cursor.moveToNext());
	//		}
	//		cursor.close();
	//		close();
	//		return list;
	//	}
	//
	//	// *********************delete data shift***********************************************
	//	public boolean deleteShift(int shiftID) {
	//		open();
	//		String whereClause = "SHIFT_ID = ?";
	//		String[] whereArgs = { String.valueOf(shiftID) };
	//		int row2 = mDatabase.delete(TABLE_DATE_SHIFT, "SHIFT_ID ="+shiftID, null);
	//		int row = mDatabase.delete(TABLE_SHIFT, whereClause, whereArgs);
	//		if (row2 != 1) {
	//			Log.d(TAG, "Success to delete group row shiftID 4=" + shiftID+":"+row2);
	//			return false;
	//		} else {
	//			Log.d(TAG, "Success delete group row shiftID 4=" + shiftID);
	//		}
	//		if (row != 1) {
	//			Log.e(TAG, "fail to delete group row shiftID 1=" + shiftID);
	//			return false;
	//		} else {
	//			Log.d(TAG, "Success delete group row shiftID 1=" + shiftID);
	//		}
	//		close();
	//		return true;
	//	}
	//
	//	// *********************insert data shift***********************************************
	//	public boolean insertShift(Context con, String shiftLable,
	//			String shiftColor, String shiftStart, String shiftEnd,
	//			String shiftTime, int shiftLoop) {
	//		int countShift = shiftCount();
	//		if (countShift <= 9) {
	//			int shiftID = getID();
	//			open();
	//			ContentValues values = new ContentValues();
	//			values.put("SHIFT_ID", shiftID);
	//			values.put("SHIFT_LABLE", shiftLable);
	//			values.put("SHIFT_COLOR", shiftColor);
	//			values.put("SHIFT_START", shiftStart);
	//			values.put("SHIFT_END", shiftEnd);
	//			values.put("SHIFT_TIME", shiftTime);
	//			values.put("SHIFT_LOOP", shiftLoop);
	//			long rowId = mDatabase.insert(TABLE_SHIFT, null, values);
	//			if (rowId < 0) {
	//				Log.e(TAG, "ERROR: TABLE_SHIFT INSERT");
	//				return false;
	//			} else {
	//				Log.d(TAG, "TABLE_SHIFT Insert Row Success 1: rowId=" + rowId
	//						+ "SHIFT_ID" + (shiftID));
	//			}
	//			close();
	//		} else {
	//			Toast.makeText(con, "10シフトが入りました。\n新規追加するには削除してください。", Toast.LENGTH_LONG)
	//			.show();
	//		}
	//		return true;
	//	}
	//
	//	// ********************Update data shift***********************************************
	//	public boolean updateShift(int shiftID, String shiftLable,
	//			String shiftColor, String shiftStart, String shiftEnd,
	//			String shiftTime, int shiftLoop) {
	//		open();
	//		ContentValues values = new ContentValues();
	//		values.put("SHIFT_ID", shiftID);
	//		values.put("SHIFT_LABLE", shiftLable);
	//		values.put("SHIFT_COLOR", shiftColor);
	//		values.put("SHIFT_START", shiftStart);
	//		values.put("SHIFT_END", shiftEnd);
	//		values.put("SHIFT_TIME", shiftTime);
	//		values.put("SHIFT_LOOP", shiftLoop);
	//		mDatabase.beginTransaction();
	//		try {
	//			String whereClause = "SHIFT_ID = ?";
	//			String[] whereArgs = { String.valueOf(shiftID) };
	//
	//			int rowsAffected = mDatabase.update(TABLE_SHIFT, values,
	//					whereClause, whereArgs);
	//			if (rowsAffected != 1) {
	//				Log.e(TAG, "ERROR: SHIFT UPDATE [SHIFT_ID=" + shiftID + "]");
	//				return false;
	//			}
	//			Log.d(TAG, "Success update  SHIFT_ID=" + rowsAffected);
	//			mDatabase.setTransactionSuccessful();
	//		} finally {
	//			mDatabase.endTransaction();
	//		}
	//		close();
	//		return true;
	//	}
}
