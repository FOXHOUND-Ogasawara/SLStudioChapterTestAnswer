package com.taskapp.logic;

import com.taskapp.dataaccess.UserDataAccess;
import com.taskapp.exception.AppException;
import com.taskapp.model.User;

public class UserLogic {
    private final UserDataAccess userDataAccess;

    public UserLogic() {
        userDataAccess = new UserDataAccess();
    }

    public UserLogic(UserDataAccess userDataAccess) {
        this.userDataAccess = userDataAccess;
    }

    /**
     * ユーザーのログイン処理を行います。
     * @param email ユーザーのメールアドレス
     * @param password ユーザーのパスワード
     * @return ログインしたユーザーの情報
     * @throws AppException メールアドレスとパスワードが一致するユーザーが存在しない場合にスローされます
     */
    public User login(String email, String password) throws AppException {
        // 渡されたメールアドレスとパスワードに一致するユーザーデータを取得する
        User user = userDataAccess.findByEmailAndPassowrd(email, password);

        // 入力されたメールアドレス、パスワードのデータがあるか判定
        if (user == null) {
            throw new AppException("既に登録されているメールアドレス、パスワードを入力してください");
        }

        System.out.println("ユーザー名：" + user.getName() + "でログインしました。");
        return user;
    }
}