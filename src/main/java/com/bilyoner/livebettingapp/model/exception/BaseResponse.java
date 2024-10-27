package com.bilyoner.livebettingapp.model.exception;

public class BaseResponse {

    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static final class BaseResponseBuilder {
        private String status;
        private String message;

        private BaseResponseBuilder() {
        }

        public static BaseResponseBuilder aBaseResponse() {
            return new BaseResponseBuilder();
        }

        public BaseResponseBuilder status(String status) {
            this.status = status;
            return this;
        }

        public BaseResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public BaseResponse build() {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatus(status);
            baseResponse.setMessage(message);
            return baseResponse;
        }
    }
}
