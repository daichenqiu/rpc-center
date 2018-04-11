package com.dcq.result;

import lombok.Data;

/**
 * Demo class
 *
 * @author chenqiudai
 * @date 11/04/2018
 */
@Data
public class BaseResult<T> {

    public final static String SUCCESS = "200";

    private Integer isSuccess = 1;
    private String code;
    private String msg;
    private T data;

    public final static <T> BaseResult success(){
        return success(null);
    }

    public final static <T> BaseResult success(T data){
        BaseResult result = new BaseResult();
        result.setCode(SUCCESS);
        result.setMsg(SUCCESS);
        result.setData(data);
        return result;
    }

    public final static BaseResult<String > failure(){
        return failure("500","500");
    }

    public final static BaseResult<String > failure(String code, String msg){
        BaseResult result = new BaseResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setIsSuccess(0);
        return result;
    }
}
