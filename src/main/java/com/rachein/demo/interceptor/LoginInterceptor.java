package com.rachein.demo.interceptor;//package com.rachein.demo.interceptor;

import com.rachein.demo.exception.CodeMsg;
import com.rachein.demo.exception.GlobalException;
import com.rachein.demo.service.UserService;
import com.rachein.demo.service.impl.UserServiceImpl;
import com.rachein.demo.utils.CookieUtil;
import com.rachein.demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 13:25
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

//    @Value("${interceptors.auth-ignore-uris}")
//    private String authIgnoreUrls;

    @Autowired
    private UserService userService;

    public static final String UserVoPrefix = "ACCESS_USER";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //url是否为免验证身份
//        String[] authIgnoreUrlList = authIgnoreUrls.split("-");
//        String requestURI = request.getRequestURI();
//        for (String url : authIgnoreUrlList) {
//            if (requestURI.equals(url)) {
//                return true;
//            }
//        }
        //从header中获取cookie
        //获取token
        String token = CookieUtil.getCookieValue(request, UserServiceImpl.TOKEN_PREFIX);
        //匹配token
        UserVo userVo = userService.getByToken(response, token);
        //校验
        if (Objects.isNull(userVo)) throw new GlobalException(CodeMsg.AUTH_ERROR);
        //将获取到的user放入到公共域中，方便后序的注解开发
        request.setAttribute(UserVoPrefix, userVo);
        return true;
    }
}
