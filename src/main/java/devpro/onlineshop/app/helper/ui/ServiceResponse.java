package devpro.onlineshop.app.helper.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServiceResponse<T> implements Serializable {

    private List<T> data;
    private boolean hasError;
    private String message;
    private long totalCount;
    private ResponseStatus responseStatus;

    public ServiceResponse(ResponseStatus responseStatus, List<T> data) {
        this.responseStatus = responseStatus;
        this.data = data;
        this.message = "";
        this.totalCount = 0;
        this.hasError = false;
    }

    public ServiceResponse(ResponseStatus responseStatus, List<T> data, long totalCount) {
        this.responseStatus = responseStatus;
        this.data = data;
        this.message = "";
        this.totalCount = totalCount;
        this.hasError = false;
    }

    public ServiceResponse(ResponseStatus responseStatus, T data) {
        this.data = new ArrayList<T>();
        this.data.add(data);
        this.responseStatus = responseStatus;
        this.message = "";
        this.totalCount = 1;
        this.hasError = false;
    }

    public ServiceResponse(ResponseStatus responseStatus, String message) {
        this.data = new ArrayList<>();
        this.responseStatus = responseStatus;
        this.message = message;
        this.totalCount = 0;
        this.hasError = false;
    }

    public ServiceResponse(Exception exception) {
        this.data = new ArrayList<>();
        this.responseStatus = ResponseStatus.EXCEPTION;
        this.message = exception.getMessage();
        this.totalCount = 0;
        this.hasError = true;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
