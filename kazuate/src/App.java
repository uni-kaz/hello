import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        // 回数カウント用
        int count = 0;
        // 答え
        Random r = new Random();
        int answer = r.nextInt(90) + 10;
        // 入力した数字
        int inputNumber;
        // 入力した数字 - 答え
        int sub;

        System.out.println("【数当てゲーム】");
        while (count < 5) {
            System.out.print("2桁の正の整数を入力してください（残り" + (5 - count) + "回）：");
            try {
                inputNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                // 整数でないとき
                System.err.println("整数を入力してください．");
                // 入力した文字をバッファからクリア
                scanner.next();
                // カウントしない
                continue;
            }
            if (inputNumber < 0) {
                System.err.println("入力された数字は正の整数ではありません．");
                // カウントしない
                continue;
            }
            // 二桁でないとき
            if (inputNumber < 10 || inputNumber > 99) {
                System.err.println("入力された数字は2桁ではありません．");
                // カウントしない
                continue;
            }
            sub = inputNumber - answer;
            if (sub == 0) {
                System.out.println("当たり");
                break;
            } else if (sub > 0) {
                if (sub >= 20) {
                    // 差が20以上
                    System.out.println("入力された数字は，答えの数より20以上大きいです．");
                } else {
                    System.out.println("入力された数字は，答えの数より大きいです．");
                }
            } else {
                if (sub <= -20) {
                    // 差が20以上
                    System.out.println("入力された数字は，答えの数より20以上小さいです．");
                } else {
                    System.out.println("入力された数字は，答えの数より小さいです．");
                }
            }
            count++;
        }
        // 当てられなかったとき
        if (count >= 5) {
            System.out.println("残念でした．");
        }
        System.out.println("答え：" + answer);
        System.out.println("ゲームを終了します．");
        scanner.close();
    }
}
