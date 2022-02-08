package com.rachein.demo.annotaion.resolve;

import com.rachein.demo.annotaion.CurUser;
import com.rachein.demo.interceptor.LoginInterceptor;
import com.rachein.demo.vo.UserVo;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/8 10:53
 */
@Component
public class CurrentUserAnnotationResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //是否含有UserVo参数 和 是否含有CurUser注解
        return methodParameter.getParameterType().isAssignableFrom(UserVo.class)
                && methodParameter.hasParameterAnnotation(CurUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
//        从拦截器中的request中获取user
        return (UserVo)nativeWebRequest.getAttribute(LoginInterceptor.UserVoPrefix, RequestAttributes.SCOPE_REQUEST);
    }
}
