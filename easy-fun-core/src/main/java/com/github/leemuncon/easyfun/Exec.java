package com.github.leemuncon.easyfun;

import com.github.leemuncon.easyfun.args.Result;

/**
 * Created by leemuncon on 2017/3/14.
 *
 */
public interface Exec<Re, In> {

    Result<Re> exec(In in);

}
