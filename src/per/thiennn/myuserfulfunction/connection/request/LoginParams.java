package per.thiennn.myuserfulfunction.connection.request;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
public class LoginParams extends CommonParams{
	@SerializedName (value = "json_key_request")
	String jsonKeyRequest;

    public String getJsonKeyRequest() {
        return jsonKeyRequest;
    }

    public void setJsonKeyRequest(String jsonKeyRequest) {
        this.jsonKeyRequest = jsonKeyRequest;
    }
	
}
