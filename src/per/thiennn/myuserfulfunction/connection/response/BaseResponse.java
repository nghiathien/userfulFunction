package per.thiennn.myuserfulfunction.connection.response;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * @author ThienNN
 */
@SuppressWarnings("serial")
public class BaseResponse implements Serializable {

    @SerializedName (value = "errorcode")
    public String errorCode;
    @SerializedName (value = "errormessage")
    public String errorMessage;
}
