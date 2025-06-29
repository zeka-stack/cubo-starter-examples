package dev.dong4j.zeka.starter.sample.rest.rest.service;

import dev.dong4j.zeka.kernel.common.api.BaseCodes;
import dev.dong4j.zeka.kernel.common.util.RandomUtils;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.po.User;
import java.lang.reflect.Constructor;
import java.util.Date;
import lombok.SneakyThrows;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.10 13:29
 * @since 1.0.0
 */
@Service
public class ExceptionService {

    /**
     * Exception user
     *
     * @param code code
     * @return the user
     * @since 1.0.0
     */
    public User exception(String code) {
        BaseCodes.PARAM_VERIFY_ERROR.notBlank(code, "code 参数不能为空");

        return User.builder().id(1L).name("dong4j").date(new Date()).age(18).email("arraydsj@163.com").build();
    }

    /**
     * Random exception
     *
     * @since 1.0.0
     */
    @SneakyThrows
    public void randomException() {
        Class<?>[] exceptions = new Class[]{
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            HttpMediaTypeNotAcceptableException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            MethodArgumentTypeMismatchException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
        };

        Class<?> exception = exceptions[RandomUtils.nextInt(13)];
        Constructor<?> constructor = exception.getConstructor();

        throw (Exception) constructor.newInstance();
    }
}
