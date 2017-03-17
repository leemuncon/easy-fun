package com.github.leemuncon.easyfun.core;

import com.github.leemuncon.easyfun.Exec;
import com.github.leemuncon.easyfun.FunStatus;
import com.github.leemuncon.easyfun.args.Result;

/**
 * Created by lifei10 on 2017/3/17.
 *
 * @author lifei87
 * @company jd.com
 * @date 2017/3/17
 */
public class BaseExec<T> {

    // 本处理器
    private Exec<?, T> exec;

    public BaseExec(Exec<?, T> exec) {
        this.exec = exec;
    }

    public Result<?> exec(T arg) {
        Result<?> result;
        try {
            if (exec == null) {
                throw new IllegalAccessError("exec was null");
            }
            result = exec.exec(arg);
        } catch (Exception e) {
            result = new Result<Exception>(FunStatus.ERROR, e);
        }
        return result;
    }

}
