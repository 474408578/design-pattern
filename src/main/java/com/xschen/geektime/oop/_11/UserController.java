package com.xschen.geektime.oop._11;


/**
 * @author xschen
 * 基于贫血模型的开发模式：
 *      UserEntity和UserRepository组成了数据访问层
 *      UserBo和UserService组成了业务逻辑层
 *      UserVO和UserController这里属于接口层
 *
 *      DAO---->Service----->Controller
 *          PO          BO                VO
 *
 *
 * 在贫血模型中，数据和业务逻辑被分割到不同的类中。
 * 充血模型正好相反，数据和对应的业务逻辑被封装到同一个类中。
 */


public class UserController {
    private UserService userService; // 通过构造函数或者IOC框架注入

    public UserVo getUserById(Long userId) {
        UserBo userBo = userService.getUserById(userId);
        UserVo userVo = null; // convert userBo to userVo
        return userVo;
    }
}
