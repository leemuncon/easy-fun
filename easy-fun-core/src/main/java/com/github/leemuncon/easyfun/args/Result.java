package com.github.leemuncon.easyfun.args;

import com.github.leemuncon.easyfun.FunStatus;

/**
 * Created by lifei10 on 2017/3/14.
 *
 * @author lifei87
 * @company jd.com
 * @date 2017/3/14
 */
public class Result<T> implements java.io.Serializable {

    private static final long serialVersionUID = -1685422762458614830L;
    private FunStatus status;

    private T result;

    public Result(FunStatus status, T result) {
        this.status = status;
        this.result = result;
    }

    public FunStatus getStatus() {
        return status;
    }

    public T getResult() {
        return result;
    }

}
