# DrinkWater
## 概要
*DrinkWater.java*は水分補給を促してくれるアプリになります。
水分補給の間隔、摂取量は[サントリー様の記事](https://www.suntory.co.jp/softdrink/news/pr/article/SBF0867.html)から設定しています。
設定上必要な計算は以下の数字で算出し96分に一度、紙コップ一杯の水分補給を促します。

- 必要な水分量 = 1.2L
- コップ1杯 = 205ml
- 勤務時間　= 8時間

## 使用方法

![イメージ](https://github.com/teto0728/DrinkWater/assets/98692705/adc4745d-2714-4222-8eea-94387921815d)

継続のボタンを押すことで画面が閉じます。その後96分後に再度画面が立ち上がります。
終了のボタンを押すと画面が閉じプロジェクトが終了します。再度画面は立ち上がりません。


## 使用技術

Java 8.0_301
