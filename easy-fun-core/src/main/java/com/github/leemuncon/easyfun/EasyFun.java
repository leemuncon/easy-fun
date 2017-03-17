package com.github.leemuncon.easyfun;

/**
 * Created by leemuncon on 2017/3/14.
 * easy-fun interface
 */

public interface EasyFun<T> extends Executor<T> {

    /**
     * 成功后处理
     *
     * @param exec 下一个处理器
     * @return this
     */
    EasyFun<T> success(Exec exec);

    /**
     * 出错后处理
     *
     * @param exec 下一个处理器
     * @return this
     */
    EasyFun<T> error(Exec exec);

    /**
     * 成功后处理
     *
     * @param success 成功处理
     * @param error   出错处理
     * @return this
     */
    EasyFun<T> then(Exec success, Exec error);

}
