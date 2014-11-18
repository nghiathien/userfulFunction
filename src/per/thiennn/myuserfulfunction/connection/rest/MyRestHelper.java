package per.thiennn.myuserfulfunction.connection.rest;

import android.content.Context;

/**
 * 
 * 
 * @author THIENNN
 */
public class MyRestHelper {

    private final String LOG_TAG = "MyRestHelper";
    private static final boolean MOCKUP_MODE = false;
    private static MyRestHelper instance;

    protected MyRestHelper() {
    }

    public static MyRestHelper getInstance() {
        if (instance == null) {
            if (MOCKUP_MODE) {
                instance = new MyRestHelperMockup();
            } else {
                instance = new MyRestHelper();
            }
        }

        return instance;
    }

    /**
     * 
     * @param context
     */
    public void cancelRequest(Context context) {
        MyRestClient.cancelRequest(context);
    }

    /**
     * 
     * @param context
     * @param params
     * @param responseHandler
     */
//    public void getNotice(String noticeLoad, Context context, RequestParams params, final MyKarteResponseHandler responseHandler) {
//
//        String apiUrl = "URL";
//        // If need to pass parameter then need to convert it into JSON format as below
//        MyKarteRestClient.get(context, apiUrl, params, new CommonJsonHttpResponseHandler(responseHandler, Constants.ApiConst.API_GET_NOTICE));
//    }
//
//    public void checkPassword(Context context, CheckPassParams params, final MyKarteResponseHandler responseHandler) {
//
//        String apiUrl = "URL";
//        String jsonParam = JsonUtils.toJson(params);
//        // If need to pass parameter then need to convert it into JSON format as below
//        MyKarteRestClient.post(context, apiUrl, jsonParam, new CommonJsonHttpResponseHandler(responseHandler, Constants.ApiConst.API_CHECK_PASSWORD));
//    }
//    public void deleteMessage(String messageID, Context context, RequestParams params, final MyKarteResponseHandler responseHandler) {
//
//        String apiUrl = "URL";
//        // If need to pass parameter then need to convert it into JSON format as below
//        String jsonParam = JsonUtils.toJson(params);
//        MyKarteRestClient.delete(context, apiUrl,null, new CommonJsonHttpResponseHandler(responseHandler, Constants.ApiConst.API_DELETE_MESSAGE));
//    }
//    public void updateCustomerProp(Context context, RequestParams params, final MyKarteResponseHandler responseHandler) {
//
//        String apiUrl = "URL";
//        // If need to pass parameter then need to convert it into JSON format as below
//        MyKarteRestClient.put(context, apiUrl, null,null, new CommonJsonHttpResponseHandler(responseHandler, Constants.ApiConst.API_UPDATE_CUSTOMER_PROP));
//    }
}
