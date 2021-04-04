package com.geektime.oop._11;

/**
 * @author xschen
 */


public class UserService {
    private UserRepository userRepository;

    public UserBo getUserById(Long userId) {
        UserEntity userEntity = userRepository.getUserById(userId);
        UserBo userBo = null; // convert userEntity to userBo
        return userBo;
    }
}
