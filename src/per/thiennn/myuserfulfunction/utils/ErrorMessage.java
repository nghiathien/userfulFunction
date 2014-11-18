/**
 * 
 */
package per.thiennn.myuserfulfunction.utils;

/**
 *
 *
 * @author ThuongTD
 */
public class ErrorMessage {

    private int httpStatusCode;
    private String resultCode;
    private String errorMessage;

    public ErrorMessage() {
        httpStatusCode = 200;
        errorMessage = "";
    }

    public ErrorMessage(int status, String msg) {
        httpStatusCode = status;
        errorMessage = msg;
    }

    public ErrorMessage(int status, String resultCode, String msg) {
        httpStatusCode = status;
        this.setResultCode(resultCode);
        errorMessage = msg;
    }

    public void setStatusCode(int status) {
        httpStatusCode = status;
    }

    public int getStatusCode() {
        return httpStatusCode;
    }

    public String getMessage() {
        return errorMessage;
    }

    public void setMessage(String msg) {
        errorMessage = msg;
    }

    /**
     * @return the resultCode
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * @param resultCode
     *            the resultCode to set
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
}
