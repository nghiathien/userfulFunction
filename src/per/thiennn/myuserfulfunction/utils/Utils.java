package per.thiennn.myuserfulfunction.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
/*
 * Created by ThienNN : 18/11/2014
 * Create function for quick use
 * Function list
 * - Dialog with 1-2-3 button
 * - Calendar with datetime return - convert datetime
 * - Validator : email
 */
public class Utils {
    public String TAG = "Utils";
    /*********************************** Create default dialog *****************************************************************************/
    /* Dialog with ok function */
    public static void createDialogOneButton(Context context, String title, String msg,String btnTitle, final CallBack callback){
        AlertDialog.Builder dlg = new AlertDialog.Builder(context);
        dlg.setTitle(title);
        dlg.setMessage(msg);
        dlg.setPositiveButton(btnTitle, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (callback != null) {
                    callback.onPressButton(1);
                }
            }
        });
        dlg.show();
    }
    /* Dialog with 2 button function */
    public static void createDialogTwoButton(Context context, String title, String msg,String btnTitleOK,String btnTitleCancel, final CallBack callback){
        AlertDialog.Builder dlg = new AlertDialog.Builder(context);
        dlg.setTitle(title);
        dlg.setMessage(msg);
        dlg.setPositiveButton(btnTitleOK, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (callback != null) {
                    callback.onPressButton(1);
                }
            }
        });
        dlg.setNegativeButton(btnTitleCancel,
                new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (callback != null) {
                    callback.onPressButton(2);
                }
            }
        });
        dlg.show();
    }
    /* Dialog with 3 button function */
    public static void createDialogThreeButton(Context context, String title, String msg,String btnTitleOK,String btnTitleCancel,String btnTitleConfirm, final CallBack callback){
        AlertDialog.Builder dlg = new AlertDialog.Builder(context);
        dlg.setTitle(title);
        dlg.setMessage(msg);
        dlg.setPositiveButton(btnTitleOK, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (callback != null) {
                    callback.onPressButton(1);
                }
            }
        });
        dlg.setNegativeButton(btnTitleCancel,
                new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (callback != null) {
                    callback.onPressButton(2);
                }
            }
        });
        dlg.setNeutralButton(btnTitleConfirm,
                new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (callback != null) {
                    callback.onPressButton(3);
                }
            }
        });
        dlg.show();
    }
    //*****Call back of dialog**********************
    public interface CallBack {
        void onPressButton(int buttonIndex);
    }
    /*************************************************************************************************************************************/
    /*********************************** Calendar template********************************************************************************/
    /**@nonjavadoc
     * ThienNN
     * optionReturn = 0 : year
     * optionReturn = 1 : month of year
     * optionReturn = 2 : day of month
     */
    public static int getCurrentDateWithOption(int optionReturn){
        Calendar c = Calendar.getInstance();
        int returnVal=0;
        switch (optionReturn) {
        case 0:
            returnVal= c.get(Calendar.YEAR);
            break;
        case 1:
            returnVal= c.get(Calendar.MONTH);
            break;
        case 2:
            returnVal= c.get(Calendar.DAY_OF_MONTH);
            break;
        }
        return returnVal;
    }
    /**@nonjavadoc
     * ThienNN
     * return japanese values for day of week \n
     * eg : Monday : 日（日）
     */
    public static String dateOfWeek(){
        String dateReturn="";
        Calendar c = Calendar.getInstance(); 
        int date = c.get(Calendar.DAY_OF_WEEK);
        switch (date) {
        case 1:
            dateReturn="日（日）";
            break;
        case 2:
            dateReturn="日（月）";
            break;
        case 3:
            dateReturn="日（火）";
            break;
        case 4:
            dateReturn="日（水）";
            break;
        case 5:
            dateReturn="日（木）";
            break;
        case 6:
            dateReturn="日（金）";
            break;
        case 7:
            dateReturn="日（土）";
            break;
        default:
            break;
        }
        return dateReturn;
    }
    /**@nonjavadoc
     * ThienNN
     * Convert Japanese date with format :  yyyy-MM-dd HH:mm:ss\n
     * eg : Monday : 日（日）
     */
    public static String convertJPDate(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        Date date1 = null;
        String dateTime="";
        if (date!=null && !date.equals("")) {
            try {
                date1 = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            dateTime=SimpleDateFormat.getDateInstance(SimpleDateFormat.LONG, Locale.JAPAN).format(date1).toUpperCase().toString();
        }
        return dateTime;
    }
    /**@nonjavadoc
     * ThienNN
     * get date format yyyyMMDD with format :  yyyy-MM-dd HH:mm:ss\n
     * eg : Monday : 日（日）
     */
    public static String getyyyyMMDD(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date1 = null;
        String dateTime="";
        if (date!=null && !date.equals("")) {
            try {
                date1 = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            dateTime = sdf.format(date1);
        }
        return dateTime;
    }
    /*************************************************************************************************************************************/
    /*********************************** Validate functions ******************************************************************************/
    /**@nonjavadoc
     * ThienNN
     * Validate email
     * true : correction email
     * false : wrong email
     */
    public static boolean emailValidator(String email) 
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    /*************************************************************************************************************************************/
    /*********************************** Validate functions ******************************************************************************/
    /**@nonjavadoc
     * Create spinner customize \n
     * parameter : context - spinner - string[] val - textview for item
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void initSpinner(Context con,Spinner spinner,String[] val,int textView) 
    {
        if (textView>0) {
            ArrayAdapter<String> adapter = new ArrayAdapter(con, textView, val);
            spinner.setAdapter(adapter);            
        }else{
            ArrayAdapter<String> adapter = new ArrayAdapter(con, android.R.layout.simple_dropdown_item_1line, val);
            spinner.setAdapter(adapter);
        }
    }
    /*************************************************************************************************************************************/
    /*********************************** Validate functions ******************************************************************************/
    /**@nonjavadoc
     * ThienNN
     * Validate Edittext with right error. 
     * @param edTarget : Edittext target
     * @param errorContent : content for error
     * @param minLeng : min leng of this
     */
    public static void validateEdittext(EditText edTarget,String errorContent,int minLeng) 
    {
        if (edTarget.getText().length()<minLeng) {
            edTarget.setError(errorContent);
        }
    }
    /*************************************************************************************************************************************/
    
}
