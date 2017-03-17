package com.github.leemuncon;

import com.github.leemuncon.easyfun.EasyFun;
import com.github.leemuncon.easyfun.Exec;
import com.github.leemuncon.easyfun.FunStatus;
import com.github.leemuncon.easyfun.args.Result;
import com.github.leemuncon.easyfun.core.DefaultEasyFun;
import org.junit.Test;

/**
 * Created by lifei10 on 2017/3/17.
 *
 * @author lifei87
 * @company jd.com
 * @date 2017/3/17
 */
public class EasyFunTest {

    @Test
    public void Test1() {
        EasyFun<Integer> easyFun = new DefaultEasyFun<Integer>(
                new Exec<Integer, Integer>() {
                    @Override
                    public Result<Integer> exec(Integer integer) {
                        System.out.println("first -> " + integer);
                        integer = integer + 1;
                        return new Result<Integer>(FunStatus.SUCCESS, integer);
                    }
                }
        );

        easyFun.success(new Exec<Integer, Integer>() {
            @Override
            public Result<Integer> exec(Integer integer) {
                System.out.println("success -> " + integer);
                integer = integer + 1;
                return new Result<Integer>(FunStatus.SUCCESS, integer);
            }
        }).error(new Exec<Integer, Integer>() {
            @Override
            public Result<Integer> exec(Integer integer) {
                System.out.println("error -> " + integer);
                integer = integer + 1;
                return new Result<Integer>(FunStatus.SUCCESS, integer);
            }
        }).success(new Exec<Integer, Integer>() {
            @Override
            public Result<Integer> exec(Integer integer) {
                System.out.println("success -> " + integer);
                integer = integer + 1;
                return new Result<Integer>(FunStatus.ERROR, integer);
            }
        }).then(new Exec<Integer, Integer>() {
            @Override
            public Result<Integer> exec(Integer integer) {
                System.out.println("success -> " + integer);
                integer = integer + 1;
                return new Result<Integer>(FunStatus.SUCCESS, integer);
            }
        }, new Exec<Integer, Integer>() {
            @Override
            public Result<Integer> exec(Integer integer) {
                System.out.println("error -> " + integer);
                integer = integer + 1;
                return new Result<Integer>(FunStatus.SUCCESS, integer);
            }
        });
        easyFun.submit(1);
    }

}
