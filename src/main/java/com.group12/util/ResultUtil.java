package com.group12.util;

import lombok.Data;

@Data
public class ResultUtil {
    private String code;
    private String msg;
    private Object data;
    public static ResultUtil success(Object data) {
        return resultData(CodeEnum.SUCCESS.val(), CodeEnum.SUCCESS.msg(), data);
    }

    public static ResultUtil success(Object data, String msg) {
        return resultData(CodeEnum.SUCCESS.val(), msg, data);
    }

    public static ResultUtil fail(String code, String msg) {
        return resultData(code, msg, null);
    }

    public static ResultUtil fail(String code, String msg, Object data) {
        return resultData(code, msg, data);
    }

    private static ResultUtil resultData(String code, String msg, Object data) {
        ResultUtil resultData = new ResultUtil();
        resultData.setCode(code);
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

}