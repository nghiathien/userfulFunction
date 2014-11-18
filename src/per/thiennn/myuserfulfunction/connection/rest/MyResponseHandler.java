package per.thiennn.myuserfulfunction.connection.rest;

import per.thiennn.myuserfulfunction.connection.response.BaseResponse;
import per.thiennn.myuserfulfunction.utils.ErrorMessage;

/**
 * @author THIENNN
 */
public class MyResponseHandler {

    /**
     * Common handler for success
     */
    public void onSuccess() {
    };

    public void onSuccess(BaseResponse response) {
    }

    public void onError(/*ErrorMessage error*/) {
    };

    public void onError(ErrorMessage error) {
    };

    public void onAddCustSuccess(/*BaseResponse custInfo*/) {
    }
}
