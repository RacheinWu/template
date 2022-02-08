package com.rachein.demo.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/8 10:31
 */
public class CookieUtil {

    private static Cookie search(HttpServletRequest request, String key) {
        //从request中获取所有cookie
        Cookie[] cookies = request.getCookies();
        //如果没有cookie
        if (cookies == null || cookies.length <= 0) return null;
        //遍历查找
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(key)) return cookie;
        }
        return null;
    }

    /**
     * 根据特定的key获取其cookie
     * @param request
     * @param key
     * @return Cookie
     */
    public static Cookie getCookie(HttpServletRequest request, String key) {
        return search(request, key);
    }

    /**
     * 获取去特定cookie的 值
     * @param request
     * @param key
     * @return String
     */
    public static String getCookieValue(HttpServletRequest request, String key) {
        Cookie cookie = search(request, key);
        if (cookie != null) return cookie.getValue();
        return null;
    }

}
