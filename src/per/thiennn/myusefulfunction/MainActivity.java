package per.thiennn.myusefulfunction;

import per.thiennn.myuserfulfunction.connection.request.LoginParams;
import per.thiennn.myuserfulfunction.createview.MyDialog;
import per.thiennn.myuserfulfunction.utils.JsonUtils;
import per.thiennn.myuserfulfunction.utils.Logger;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
@SuppressWarnings("unused")
public class MainActivity extends Activity {
    public String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN| WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.SCREEN_ORIENTATION_CHANGED,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }
    /**@nonJava
     * Call dialog with init size
     */
    private void callDialog() {
        MyDialog myDialog = new MyDialog(getApplicationContext());
        myDialog.show();
        /*
         * Set size for layout with dynamic size
         */
        myDialog.getWindow().setLayout(460, 680);
    }
    /**@nonJava
     * Create thread non UI with timeout (timeout)
     */
    private void createThreadNonUI(final int timeOut) {
        final Handler handler = new Handler();
        final Runnable r = new Runnable()
        {
            public void run() 
            {
                Log.d("Start falsh","done");
                handler.postDelayed(this, timeOut);
            }
        };
        handler.postDelayed(r, timeOut);
    }
    /**
     * @nonJavadoc
     * @description function request with my rest option
     */
    private void login(String userName, String password,String blockFlag) {
        final ProgressDialog loadingBar = ProgressDialog.show(this, "", "Loading",true);
        /*
         * Create params for login
         */
        LoginParams loginParams = new LoginParams();
//        loginParams.setUserId(userName);
//        loginParams.setUserPassword(password);
        Logger.i(TAG, "[login/params]->" + JsonUtils.toJson(loginParams));
        /*
         * Login request
         */
//        MyRestHelper.getInstance().login(this, loginParams, new MyResponseHandler() {
//            /* (non-Javadoc)
//             * @see com.facenet.mykarte.rest.MyKarteResponseHandler#onSuccess(com.facenet.mykarte.model.response.BaseResponse)
//             */
//            @Override
//            public void onSuccess(BaseResponse response) {
//                loadingBar.dismiss();
//                Logger.i(TAG, "[login]->onSuccess");
//                Logger.i(TAG, "[login]->onSuccess->errorCode: " + response.errorCode);
//                Logger.i(TAG, "[login]->onSuccess->errorMessage: " + response.errorMessage);
//                // If need Response info, need to convert to appropriate instance
//                LoginResponse loginResponse = (LoginResponse) response;
//                if (response.errorCode.equals("Response OK")) {
//                    /* Setting header */
//                } else {
//
//                }
//            }
//
//            /* (non-Javadoc)
//             * @see com.facenet.mykarte.rest.MyKarteResponseHandler#onError(com.facenet.mykarte.util.ErrorMessage)
//             */
//            @Override
//            public void onError(ErrorMessage error) {
//            }
//        });
    }
}
