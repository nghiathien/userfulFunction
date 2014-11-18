package per.thiennn.myuserfulfunction.connection.rest;

import per.thiennn.myuserfulfunction.connection.request.CommonParams;
import per.thiennn.myuserfulfunction.connection.response.LoginResponse;
import per.thiennn.myuserfulfunction.utils.JsonUtils;
import android.content.Context;


/**
 *
 *
 * @author THIENNN
 */
public class MyRestHelperMockup extends MyRestHelper {

    protected MyRestHelperMockup() {
    }
    //Login data fake
    String[] loginResponse = new String[] {
            "{\"errorcode\":\"0\", \"errormessage\":\"Successful\",\"token\":\"abc12345-@\", \"user_id\":\"13\"}"
    };
    /**
     * 
     * @param context
     * @param params
     * @param responseHandler
     */
    public void login(Context context, CommonParams params,
            final MyResponseHandler responseHandler) {
        // Random error
            LoginResponse response = (LoginResponse) JsonUtils.fromJson(
                    loginResponse[0], LoginResponse.class);
            responseHandler.onSuccess(response);
    }
}
