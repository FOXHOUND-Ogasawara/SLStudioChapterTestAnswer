package com.taskapp.logic;

import java.time.LocalDate;
import java.util.List;

import com.taskapp.dataaccess.LogDataAccess;
import com.taskapp.dataaccess.TaskDataAccess;
import com.taskapp.dataaccess.UserDataAccess;
import com.taskapp.exception.AppException;
import com.taskapp.model.Log;
import com.taskapp.model.Task;
import com.taskapp.model.User;

public class TaskLogic {
    private final TaskDataAccess taskDataAccess;
    private final LogDataAccess logDataAccess;
    private final UserDataAccess userDataAccess;


    public TaskLogic() {
        taskDataAccess = new TaskDataAccess();
        logDataAccess = new LogDataAccess();
        userDataAccess = new UserDataAccess();
    }

    public TaskLogic(TaskDataAccess taskDataAccess, LogDataAccess logDataAccess, UserDataAccess userDataAccess) {
        this.taskDataAccess = taskDataAccess;
        this.logDataAccess = logDataAccess;
        this.userDataAccess = userDataAccess;
    }

    /**
     * 全てのタスクを表示します。
     * @param loginUser ログインユーザー
     */
    public void showAll(User loginUser) {
        // タスクのデータを全件取得する
        List<Task> tasks = taskDataAccess.findAll();

        tasks.forEach(task -> {
            // 表示用にステータスの数字を判定する
            String status = "未着手";
            if (task.getStatus() == 1) {
                status = "着手中";
            } else if (task.getStatus() == 2) {
                status = "完了";
            }

            // 表示用に担当者のユーザーコードを判定する
            String repUserName = task.getRepUser().getName();
            if (task.getRepUser().getCode() == loginUser.getCode()) {
                repUserName = "あなた";
            }

            System.out.println(task.getCode() + ". " + "タスク名：" + task.getName() +
                                ", 担当者名：" + repUserName + "が担当しています" +
                                ", ステータス：" + status);
        });
    }

    /**
     * 新しいタスクを保存します。
     * @param code タスクコード
     * @param name タスク名
     * @param repUserCode 担当ユーザーコード
     * @param loginUser ログインユーザー
     * @throws AppException ユーザーコードが存在しない場合にスローされます
     */
    public void save(int code, String name, int repUserCode,
                    User loginUser) throws AppException {

        // 入力された担当ユーザーコードに一致するユーザーを取得する
        User repUser = userDataAccess.findByCode(repUserCode);
        // ユーザーが見つからなかった場合
        if (repUser == null) {
            throw new AppException("存在するユーザーコードを入力してください");
        }

        // Taskオブジェクトにマッピングする
        Task task = new Task(code, name, 0, repUser);
        // タスクデータを登録
        taskDataAccess.save(task);

        // Logオブジェクトにマッピングする
        Log log = new Log(code, loginUser.getCode(), 0, LocalDate.now());
        // ログデータを登録
        logDataAccess.save(log);
        System.out.println(name + "の登録が完了しました。");
    }

    /**
     * タスクのステータスを変更します。
     * @param code タスクコード
     * @param status 新しいステータス
     * @param loginUser ログインユーザー
     * @throws AppException タスクコードが存在しない、またはステータスが前のステータスより1つ先でない場合にスローされます
     */
    public void changeStatus(int code, int status,
                            User loginUser) throws AppException {

        // 入力されたコードに一致するタスクデータを取得する
        Task task = taskDataAccess.findByCode(code);
        // タスクが見つからなかった場合
        if (task == null) {
            throw new AppException("存在するタスクコードを入力してください");
        }

        // 変更後のステータスが、前のステータスの一個後でない場合
        if (task.getStatus() != (status - 1)) {
            throw new AppException("ステータスは、前のステータスより1つ先のもののみを選択してください");
        }
        task.setStatus(status);
        // タスクデータの更新
        taskDataAccess.update(task);

        // Logオブジェクトにマッピングする
        Log log = new Log(code, loginUser.getCode(), status, LocalDate.now());
        // ログの登録
        logDataAccess.save(log);

        System.out.println("ステータスの変更が完了しました。");
    }

    /**
     * タスクを削除します。
     * @param code タスクコード
     * @throws AppException タスクコードが存在しない、またはタスクのステータスが完了でない場合にスローされます
     */
    public void delete(int code) throws AppException {
        // 入力されたコードに一致するタスクデータを取得する
        Task task = taskDataAccess.findByCode(code);
        // タスクが見つからなかった場合
        if (task == null) {
            throw new AppException("存在するタスクコードを入力してください");
        }

        // 該当タスクのステータスが完了じゃない場合
        if (task.getStatus() != 2) {
            throw new AppException("ステータスが完了のタスクを選択してください");
        }

        // タスクを削除する
        taskDataAccess.delete(code);

        // 該当タスクコードのログを削除する
        logDataAccess.deleteByTaskCode(code);

        System.out.println(task.getName() + "の削除が完了しました。");
    }
}