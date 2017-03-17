package com.github.leemuncon.easyfun.core;

import com.github.leemuncon.easyfun.Exec;
import com.github.leemuncon.easyfun.FunStatus;
import com.github.leemuncon.easyfun.args.Result;

/**
 * Created by leemuncon on 2017/3/14.
 *
 * 单线程同步操作
 *
 */
public class DefaultEasyFun<T> extends AbstractEasyFun<T> {


    public DefaultEasyFun(Exec<?, T> exec) {
        super(exec);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void submit(T arg) {
        Result<?> result = exec(arg);
        if (FunStatus.ERROR.equals(result.getStatus())) {
            if (hasError()) {
                error.submit(result.getResult());
            }
        } else {
            if (hasNext()) {
                next.submit(result.getResult());
            }
        }
    }
}
