package com.taskapp.dataaccess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.taskapp.model.Log;

public class LogDataAccess {
    private final String filePath;


    public LogDataAccess() {
        filePath = "app/src/main/resources/logs.csv";
    }

    public LogDataAccess(String filePath) {
        this.filePath = filePath;
    }

    /**
     * ログをCSVファイルに保存します。
     *
     * @param log 保存するログ
     */
    public void save(Log log) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            String line = createLine(log);
            // 改行を追加する
            writer.newLine();
            // データを1行分追加する
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * すべてのログを取得します。
     *
     * @return すべてのログのリスト
     */
    public List<Log> findAll() {
        List<Log> logs = new ArrayList<Log>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // タイトル行を読み飛ばす
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                int taskCode = Integer.parseInt(values[0]);
                int changeUserCode = Integer.parseInt(values[1]);
                int status = Integer.parseInt(values[2]);
                LocalDate date = LocalDate.parse(values[3]);

                // Logオブジェクトにマッピングする
                Log log = new Log(taskCode, changeUserCode, status, date);
                // リストに追加する
                logs.add(log);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return logs;
    }

    /**
     * 指定したタスクコードに該当するログを削除します。
     *
     * @param taskCode 削除するログのタスクコード
     */
    public void deleteByTaskCode(int taskCode) {
        List<Log> logs = findAll();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            // CSVのヘッダーを書き込む
            writer.write("Task_Code,Change_User_Code,Status,Change_Date\n");

            for(Log log : logs) {
                // 引数のtaskCode以外のデータだけ書き込む
                if(log.getTaskCode() != taskCode) {
                    String line = createLine(log);
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ログをCSVファイルに書き込むためのフォーマットを作成します。
     *
     * @param log フォーマットを作成するログ
     * @return CSVファイルに書き込むためのフォーマット
     */
    private String createLine(Log log) {
        return log.getTaskCode() + "," + log.getChangeUserCode() + "," +
                log.getStatus() + "," + log.getChangeDate();
    }
}