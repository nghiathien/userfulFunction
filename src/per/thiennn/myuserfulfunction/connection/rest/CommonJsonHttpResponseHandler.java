package per.thiennn.myuserfulfunction.connection.rest;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import per.thiennn.myuserfulfunction.connection.response.BaseResponse;
import per.thiennn.myuserfulfunction.utils.ErrorMessage;
import per.thiennn.myuserfulfunction.utils.JsonUtils;
import per.thiennn.myuserfulfunction.utils.Logger;
import android.text.TextUtils;

import com.loopj.android.http.JsonHttpResponseHandler;

/**
 * @author ThienNN
 */
public class CommonJsonHttpResponseHandler extends JsonHttpResponseHandler {
    private final String LOG_TAG = "MyKarteRestHelper";

    private MyResponseHandler responseHandler;
    private int requestType;

    public CommonJsonHttpResponseHandler(MyResponseHandler responseHandler, int requestType) {
        this.responseHandler = responseHandler;
        this.requestType = requestType;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.loopj.android.http.JsonHttpResponseHandler#onSuccess(int,
     * org.apache.http.Header[], org.json.JSONObject)
     */
    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        handleSuccess(statusCode, headers, response != null ? response.toString() : "");
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.loopj.android.http.JsonHttpResponseHandler#onSuccess(int,
     * org.apache.http.Header[], java.lang.String)
     */
    @Override
    public void onSuccess(int statusCode, Header[] headers, String responseString) {
        handleSuccess(statusCode, headers, responseString);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.loopj.android.http.JsonHttpResponseHandler#onSuccess(int,
     * org.apache.http.Header[], org.json.JSONArray)
     */
    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
        super.onSuccess(statusCode, headers, response);
        writeLogSuccess("onSuccess", statusCode, "JSONArray is not implemented");
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.loopj.android.http.JsonHttpResponseHandler#onFailure(int,
     * org.apache.http.Header[], java.lang.Throwable, org.json.JSONObject)
     */
    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        handleFailure(statusCode, headers, errorResponse!= null ? errorResponse.toString() : "", throwable);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.loopj.android.http.JsonHttpResponseHandler#onFailure(int,
     * org.apache.http.Header[], java.lang.Throwable, org.json.JSONArray)
     */
    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
        writeLogFailure("onFailure", statusCode, "JSONArray is not implemented", throwable);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.loopj.android.http.JsonHttpResponseHandler#onFailure(int,
     * org.apache.http.Header[], java.lang.String, java.lang.Throwable)
     */
    @Override
    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        handleFailure(statusCode, headers, responseString, throwable);
    }

    private void writeLogSuccess(String function, int statusCode, String responseBody) {
        Logger.i(LOG_TAG, "RestApi::" + function + "::onSuccess");
        Logger.i(LOG_TAG, "    statusCode: " + statusCode);
        Logger.i(LOG_TAG, "    responseBody: " + responseBody);
    }

    private void writeLogFailure(String function, int statusCode, String responseBody, Throwable e) {
        Logger.e(LOG_TAG, "MyKarteRestHelper::"+ function +"::onFailure");
        Logger.e(LOG_TAG, "    statusCode: " + statusCode);
        Logger.e(LOG_TAG, "    errorResponse: " + responseBody);
        Logger.e(LOG_TAG, "    error: " + e.getMessage());
    }

    private void handleSuccess(int statusCode, Header[] headers, String responseString) {
        Logger.i(LOG_TAG, "responseString -> " + responseString);
        if (!TextUtils.isEmpty(responseString)) {
            BaseResponse response = (BaseResponse) JsonUtils.fromJson(responseString, BaseResponse.class);
            if (response.errorCode.equals("ERROR-Code (Eg : 202)")) {
                try{
                    Logger.i(LOG_TAG, "Action");
                }catch(Exception e){
                    Logger.i(LOG_TAG, "Error : "+e.getMessage());
                }
                return;
            }
        }
        switch (requestType) {
        case 1: //Must defined in const to check request success per API
            loginSuccess(statusCode, headers, responseString);
            break;
        default:
            writeLogSuccess("handleSuccess:default", statusCode, responseString);
            break;
        }
    }

    private void handleFailure(int statusCode, Header[] headers, String responseBody, Throwable e) {
        switch (requestType) {
        case 1: //Must defined in const to check fail success per API
            loginFailure(statusCode, headers, responseBody, e);
            break;
        default:
            writeLogFailure("handleFailure:default", statusCode, responseBody, e);
            break;
        }
    }

    // [ Login handler
    /**
     * 
     * @param statusCode
     * @param headers
     * @param responseBody
     */
    private void loginSuccess(int statusCode, Header[] headers, String responseBody) {
        writeLogSuccess("login", statusCode, responseBody);

        // Convert to appropriate instance
        BaseResponse response = (BaseResponse) JsonUtils.fromJson(responseBody, BaseResponse.class);
        responseHandler.onSuccess(response);
    }

    /**
     * 
     * @param statusCode
     * @param headers
     * @param responseBody
     * @param e
     */
    private void loginFailure(int statusCode, Header[] headers, String responseBody, Throwable e) {
        writeLogFailure("login", statusCode, responseBody, e);

        ErrorMessage errMsg = new ErrorMessage();
        errMsg.setStatusCode(statusCode);
        errMsg.setMessage(e.getMessage());
        responseHandler.onError(errMsg);
    }
    // ]
}
