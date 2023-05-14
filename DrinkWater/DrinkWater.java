import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrinkWater {

    private JLabel alarmLabel;
    private JButton drinkButton;
    private JButton cancelButton;
    private JPanel buttonPanel;

    // アラームの定期実行処理
    public DrinkWater() {
        /*
         * アラーム間隔の計算
         *
         * 必要な水分量 = 1.2L = 1200ml
         * 紙コップ1杯 = 205ml
         * 1200ml / 205ml = 約6(5.85365…)
         * 仕事時間を8時間と仮定し480分(8時間) / 6 = 80分
         */
        int drink = 1200; // 1日に必要な水分
        int mouthful = 205; // １度に摂取する水分量
        int howOften = drink / mouthful; // 摂取回数
        int workTime = 480; // 仕事時間
        int workMinuts = workTime / howOften * 60 * 1000; // 仕事時間をミリ秒に変換

        /*
         * 上記計算結果表示
         * System.out.println(workMinuts);
         */

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                frame();
                System.out.println("実行中…");
            }
        };
        timer.scheduleAtFixedRate(task, 0, workMinuts);
    }

    // ウィンドウ作成
    public void frame() {
        JFrame frame = new JFrame("Drink");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(2, 1));

        alarmLabel = new JLabel("水分補給をしてください", JLabel.CENTER);
        frame.add(alarmLabel);

        drinkButton = new JButton("継続");
        drinkButton.addActionListener(e -> frame.dispose()); // 画面の非表示(プログラムは終了しない)
        cancelButton = new JButton("終了");
        cancelButton.addActionListener(e -> System.exit(0)); // プログラムの終了
        buttonPanel = new JPanel();
        buttonPanel.add(drinkButton);
        buttonPanel.add(cancelButton);
        frame.add(buttonPanel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new DrinkWater();
    }
}