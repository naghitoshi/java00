/* Javaの練習用コード
 * ターミナルに表示させるコードの実験 */

// 出力用クラス
public class HelloWorld
{
  //文字列出力
  static void showHello(){
    System.out.println("HelloWorld");
    System.out.println("new line\n");
    System.out.print("No line break. ");
    System.out.println("(^^)");
  }

  //計算結果出力
  static void showInteger(int a, int b){
    int sum, difference, product, quotient;
    sum = a + b;
    difference = a - b;
    product = a * b;
    quotient = a / b;

    System.out.println("合計 = " + sum);
    System.out.println("差 = " + difference);
    System.out.println("積 = " + product);
    System.out.println("商 = " + quotient);
  }

  public static void main(String[] args) {
    showHello();
    int a, b;
    a = 8;
    b = 3;
    showInteger(a, b);
  }
}
