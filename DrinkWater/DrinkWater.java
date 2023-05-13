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

    //アラームの定期実行処理
    public DrinkWater() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                frame();
            }
        };
        timer.scheduleAtFixedRate(task, 0, 400000); // 480000 = 1000ミリビョウ(1秒) * 60(1分) * 8(8時間)
    }

    //ウィンドウ作成
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