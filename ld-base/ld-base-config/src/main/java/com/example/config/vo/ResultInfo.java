package com.example.config.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class ResultInfo implements Serializable {
    protected Boolean result;
    protected Integer code;
    /**
     * 实体转json  为NULL的字段不参加序列化(不显示)。
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String message;

    protected ResultInfo(Boolean result, Integer code, String msg) {
        this.result = result;
        this.code = code;
        this.message = msg;
    }
}
