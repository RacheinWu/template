package com.rachein.demo.redis.mine;

import com.rachein.demo.redis.BasePrefix;
import com.rachein.demo.service.impl.UserServiceImpl;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/8 10:10
 * @Description 提供 生命周期 和 前缀
 */
public class UserKey extends BasePrefix {

    public static final int TOKEN_EXPIRE = 3600*24 *1;//默认一天

    /**
     * 防止被外面实例化
     * @param expireSeconds
     * @param prefix
     */
    private UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    /**
     * 需要缓存的字段：
     */
    public static UserKey TOKEN = new UserKey(TOKEN_EXPIRE, UserServiceImpl.TOKEN_PREFIX);


}
