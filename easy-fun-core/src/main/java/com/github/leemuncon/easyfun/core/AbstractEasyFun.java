package com.github.leemuncon.easyfun.core;

import com.github.leemuncon.easyfun.Exec;
import com.github.leemuncon.easyfun.EasyFun;

/**
 * Created by leemuncon on 2017/3/14.
 */
public abstract class AbstractEasyFun<T> extends BaseExec<T> implements EasyFun<T> {

    protected EasyFun next;

    protected EasyFun error;

    private int successCount = 0;

    public AbstractEasyFun(Exec<?, T> exec) {
        super(exec);
    }

    @Override
    public synchronized EasyFun<T> success(Exec exec) {
        if (hasNext()) {
            next.success(exec);
        } else {
            next = EasyFunFactory.createEasyFun(exec);
        }
        successCount++;
        return this;
    }

    @Override
    public EasyFun<T> error(Exec exec) {
        if (successCount <= 1) {
            error = EasyFunFactory.createEasyFun(exec);
        } else {
            next.error(exec);
        }
        return this;
    }

    @Override
    public EasyFun<T> then(Exec success, Exec error) {
        success(success);
        error(error);
        return this;
    }

    /**
     * 是否有next
     *
     * @return
     */
    public boolean hasNext() {
        return next != null;
    }

    public boolean hasError() {
        return error != null;
    }
}
