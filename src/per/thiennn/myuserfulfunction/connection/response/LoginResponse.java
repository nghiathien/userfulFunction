/**
 * 
 */
package per.thiennn.myuserfulfunction.connection.response;

import com.google.gson.annotations.SerializedName;

/**
 *
 *
 * @author ThienNN
 */
@SuppressWarnings("serial")
public class LoginResponse extends BaseResponse {
    @SerializedName (value = "json_response")
    public String jsonResponse;

    public String getJsonResponse() {
        return jsonResponse;
    }

    public void setJsonResponse(String jsonResponse) {
        this.jsonResponse = jsonResponse;
    }

}
