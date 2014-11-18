/**
 * 
 */
package per.thiennn.myuserfulfunction.connection.rest;

import java.io.File;
import java.io.UnsupportedEncodingException;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

import per.thiennn.myuserfulfunction.utils.Logger;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

/**
 * Rest client helper class, which is the wrapper of AsyncHttpClient, supports
 * to request to server by using HTTP methods
 * 
 * @author THIENNN
 */
public class MyRestClient {

    // Base URL for MyKarte APIs
    private static final String BASE_URL = "https://my-karte.jp/api";
    public static String TAG="MyKarteRestClient";
    // HttpClient object for requesting Rest
    private static AsyncHttpClient client = new AsyncHttpClient();
    private static SyncHttpClient syncClient = new SyncHttpClient();
    static {
        client.setTimeout(10 * 1000);
    }
//    public static Header[] myHeader= { new BasicHeader("Content-Type",
//            "application/json;charset=Windows-31J") };

    public static void cancelRequest(Context context) {
        client.cancelRequests(context, true);
    }

    public static void postSync() {
        
    }

    /**
     * Request to server by GET method
     * 
     * @param url
     *            the relative URL to send the request to.
     * @param params
     *            additional GET parameters to send with the request.
     * @param responseHandler
     *            the response handler instance that should handle the response.
     */
    public static void get(String url, RequestParams params,
            AsyncHttpResponseHandler responseHandler) {
        Logger.d(TAG, url);
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    /**
     * Request to server by POST method
     * 
     * @param url
     *            the relative URL to send the request to.
     * @param params
     *            additional POST parameters to send with the request.
     * @param responseHandler
     *            the response handler instance that should handle the response.
     */
    public static void post(String url, RequestParams params,
            AsyncHttpResponseHandler responseHandler) {
        Logger.d(TAG, url);
        Logger.d(TAG, ""+params);
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    /**
     * Request to server by POST method
     * 
     * @param url
     *            the relative URL to send the request to.
     * @param params
     *            additional POST parameters to send with the request.
     * @param responseHandler
     *            the response handler instance that should handle the response.
     */
    public static void post(Context context, String url, RequestParams params,
            AsyncHttpResponseHandler responseHandler) {
        Logger.d(TAG, url);
        Logger.d(TAG, ""+params);
        Header[] header = buildHeader();
        client.post(context, getAbsoluteUrl(url), header, params, null, responseHandler);
    }

    /**
     * Request to server by DELETE method
     * 
     * @param url
     *            the relative URL to send the request to.
     * @param params
     *            additional DELETE parameters to send with the request.
     * @param responseHandler
     *            the response handler instance that should handle the response.
     */
    public static void delete(String url,
            AsyncHttpResponseHandler responseHandler) {
        Logger.d(TAG, url);
        client.delete(getAbsoluteUrl(url), responseHandler);
    }

    /**
     * Request to server by PUT method
     * 
     * @param url
     *            the relative URL to send the request to.
     * @param params
     *            additional PUT parameters to send with the request.
     * @param responseHandler
     *            the response handler instance that should handle the response..
     */
    public static void put(String url, RequestParams params,
            AsyncHttpResponseHandler responseHandler) {
        Logger.d(TAG, url);
        client.put(getAbsoluteUrl(url), params, responseHandler);
    }

    /**
     * 
     * @param context
     *            Context to execute request against
     * @param url
     *            the relative URL to send the request to.
     * @param params
     *            additional GET parameters to send with the request.
     * @param responseHandler
     *            the response handler instance that should handle the response.
     */
    public static void get(Context context, String url, RequestParams params,
            AsyncHttpResponseHandler responseHandler) {
        Logger.d(TAG, url);
        Logger.d(TAG, "param: " + params);
        Header[] header = buildHeader();

        client.get(context, getAbsoluteUrl(url), header, params,
                responseHandler);
    }

    /**
     * 
     * @param context
     *            Context to execute request against
     * @param url
     *            the relative URL to send the request to.
     * @param params
     *            additional POST parameters to send with the request.
     * @param jsonParams
     *            request parameters in JSON format.
     * @param responseHandler
     *            the response handler instance that should handle the response.
     */
    public static void post(Context context, String url, String jsonParams,
            AsyncHttpResponseHandler responseHandler) {
        Logger.d(TAG, url);
        Header[] header = buildHeader();

        StringEntity entity = null;
        try {
            entity = new StringEntity(jsonParams, HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        client.post(context, getAbsoluteUrl(url), header, entity, null,
                responseHandler);
    }

    /**
     * 
     * @param context
     *            Context to execute request against
     * @param url
     *            the relative URL to send the request to.
     * @param params
     *            additional POST parameters to send with the request.
     * @param jsonParams
     *            request parameters in JSON format.
     * @param responseHandler
     *            the response handler instance that should handle the response.
     */
    public static void postWithoutHeader(Context context, String url, String jsonParams,
            AsyncHttpResponseHandler responseHandler) {
        Logger.d(TAG, url);
//        Header[] header = buildHeader();

        StringEntity entity = null;
        try {
            entity = new StringEntity(jsonParams, HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        client.post(context, getAbsoluteUrl(url), entity, null,
                responseHandler);
    }

    /**
     * 
     * @param context
     *            Context to execute request against
     * @param url
     *            the relative URL to send the request to.
     * @param params
     *            additional GET parameters to send with the request.
     * @param responseHandler
     *            the response handler instance that should handle the response.
     */
    public static void delete(Context context, String url, RequestParams params,
            AsyncHttpResponseHandler responseHandler) {
        Header[] header = buildHeader();
        Logger.d(TAG, url);
        client.delete(context, getAbsoluteUrl(url), header, params,
                responseHandler);
    }

    /**
     * 
     * @param context
     *            Context to execute request against
     * @param url
     *            the relative URL to send the request to.
     * @param params
     *            additional PUT parameters to send with the request.
     * @param jsonParams
     *            request parameters in JSON format.
     * @param responseHandler
     *            the response handler instance that should handle the response.
     */
    public static void put(Context context, String url, RequestParams params,
            String jsonParams, AsyncHttpResponseHandler responseHandler) {
        Logger.d(TAG, url);
        // Create the request header
        Header[] header = buildHeader();

        StringEntity entity = null;
        try {
            //            entity = new StringEntity(jsonParams, "Shift_JIS");
            entity = new StringEntity(jsonParams, HTTP.UTF_8);
            //            entity.setContentType("application/json;charset=Shift_JIS");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        client.put(context, getAbsoluteUrl(url), header, entity, null,
                responseHandler);
    }

    public static void sendSales(Context context, String url, 
            RequestParams params, AsyncHttpResponseHandler responseHandler) {
        Logger.d(TAG, url);
        // Create the request header
        Header[] header = buildMultiPartHeader();
        client.post(context, getAbsoluteUrl(url), header, params, null,
                responseHandler);
    }

    public static void sendSalesSync(Context context, String url, 
            RequestParams params, AsyncHttpResponseHandler responseHandler) {
        Logger.d(TAG, url);
        // Create the request header
        Header[] header = buildMultiPartHeader();
        syncClient.post(context, getAbsoluteUrl(url), header, params, null,
                responseHandler);
    }

    public static void postData(Context context, String url, File[] filesData,
            AsyncHttpResponseHandler responseHandler) {
        Logger.d(TAG, url);
        // Create the request header
        Header[] header = buildMultiPartHeader();
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.setBoundary("BODY_PAD_VALUE");
        for (File file : filesData) {
            builder.addPart(file.getName(), new FileBody(file));
        }
        client.post(context, getAbsoluteUrl(url), header, builder.build(), null,
                responseHandler);
    }

    public static void postDataSync(Context context, String url, File[] filesData,
            AsyncHttpResponseHandler responseHandler) {
        Logger.d(TAG, url);
        // Create the request header
        Header[] header = buildMultiPartHeader();
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.setBoundary("BODY_PAD_VALUE");
        for (File file : filesData) {
            builder.addPart(file.getName(), new FileBody(file));
        }
        syncClient.post(context, getAbsoluteUrl(url), header, builder.build(), null, responseHandler);
    }

    /**
     * Build header for HTTP request
     * 
     */
    private static Header[] buildHeader() {
//        Header[] header = { new BasicHeader("Content-Type", "application/json;charset=Windows-31J"),
        Header[] header = { new BasicHeader("Content-Type", "application/json;charset=UTF-8"),
                new BasicHeader("HEADER-KEY-1", "header value 1"),
                new BasicHeader("HEADER-KEY-2", "header value 2")};
        return header;
    }

    /**
     * Build header for HTTP request
     * 
     */
    private static Header[] buildMultiPartHeader() {
        Header[] header = {
                new BasicHeader("Content-Type",
                        "multipart/form-data; boundary= BODY_PAD_VALUE"),
                        new BasicHeader("HEADER-KEY-1", "header value 1"),
                        new BasicHeader("HEADER-KEY-2", "header value 2")};
        return header;
    }

        /**
     * Create absolute URL to send the request to.
     * 
     * @param relativeUrl
     *            The relative URL
     * @return Full URL to send the request to.
     */
    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
