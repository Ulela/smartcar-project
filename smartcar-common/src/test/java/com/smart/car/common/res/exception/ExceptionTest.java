package com.smart.car.common.res.exception;

/**
 * 业务异常测试
 * @author chenf
 * @version 1.0
 * @date 2022-07-13
 */
public class ExceptionTest {
    public static void main(String[] args) {
        String token = login("admin","95271");
        System.out.println(token);
    }

    static String login(String username, String password) {
        if (username.equals("admin")) {
            if (password.equals("9527")) {
                return "login successful";
            } else {
                throw new BusinessException("Error username or password.");
            }
        } else {
            throw new UserNotFoundException("User not found.");
        }
    }
}
//自定义业务异常类02
class UserNotFoundException extends BaseException {
    public UserNotFoundException() {
        super();
    }
    public UserNotFoundException(String message) {
        super(message);
    }
}
