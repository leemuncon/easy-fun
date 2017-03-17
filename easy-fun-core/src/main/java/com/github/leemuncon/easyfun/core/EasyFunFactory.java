package com.github.leemuncon.easyfun.core;

import com.github.leemuncon.easyfun.EasyFun;
import com.github.leemuncon.easyfun.Exec;

/**
 * Created by lifei10 on 2017/3/14.
 *
 * @author lifei87
 * @company jd.com
 * @date 2017/3/14
 */
public class EasyFunFactory {

    public static EasyFun createEasyFun(Exec<?, ?> exec) {
        @SuppressWarnings({"unchecked", "rawtypes"})
        EasyFun easyFun =  new DefaultEasyFun(exec);
        return easyFun;
    }

}
