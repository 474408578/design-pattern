package com.geektime.designandparadigm._48;

import com.geektime.designandparadigm._48.util.UserVo;

public interface IUserController {
    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);
}
