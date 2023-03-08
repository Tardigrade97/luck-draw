package com.example.common.handler;

import com.example.common.annotation.ResponseResult;
import com.example.config.vo.SuccessInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;


@Slf4j
@Component
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // 是否使用自定义 @ResponseResult 注解

        // 从类上获取注解
        ResponseResult annotation = methodParameter.getClass().getAnnotation(ResponseResult.class);
        // 如果从类上方获取不到注解。
        if (Objects.isNull(annotation)) {
            // 从方法上方获取注解
            annotation = methodParameter.getMethod().getAnnotation(ResponseResult.class);
        }

        // 如果是FileSystemResource 不处理
        if (methodParameter.getMethod().getAnnotatedReturnType().getType().getTypeName()
                .equals(FileSystemResource.class.getTypeName())) {
            return false;
        }
        return annotation != null && !annotation.ignore();
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object data,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        // 处理结果集
        SuccessInfo successInfo = SuccessInfo.builder().data(data).build();

        // 如果data 是String类型 并且 格式不是 "application/xml"
        if ((data instanceof String) && !MediaType.APPLICATION_XML_VALUE.equals(mediaType.toString())) {
            ObjectMapper objectMapper = new ObjectMapper();
            // 重写相应头
            serverHttpResponse.getHeaders().set("Content-Type", "application/json");
            return objectMapper.writeValueAsString(successInfo);
        }

        if (Objects.isNull(data) && MediaType.TEXT_HTML_VALUE.equals(mediaType.toString())) {
            ObjectMapper objectMapper = new ObjectMapper();
            // 重写相应头
            serverHttpResponse.getHeaders().set("Content-Type", "application/json");
            return objectMapper.writeValueAsString(successInfo);
        }
        return successInfo;
    }
}
