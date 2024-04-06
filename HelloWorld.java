/* Javaの練習用コード
 * ターミナルに表示させるコードの実験 */

// 出力用クラス

import java.time.LocalDate;

public class HelloWorld
{
  //文字列出力
  static void showHello(){
    String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
    System.out.println("output of method: " + methodName);
    System.out.println("HelloWorld");
    System.out.println("insert a new line\n");
    System.out.print("No break. ");
    System.out.println("(^^)");
    System.out.println(); 
  }

  //計算結果出力
  static void showInteger(int a, int b){
    String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
    System.out.println("output of method: " + methodName);
    int sum, difference, product, quotient;
    sum = a + b;
    difference = a - b;
    product = a * b;
    quotient = a / b;

    System.out.println("合計 = " + sum);
    System.out.println("差 = " + difference);
    System.out.println("積 = " + product);
    System.out.println("商 = " + quotient);
    System.out.println("合計=" + sum + ", 差=" + difference + 
                        ", 積=" + product + ", 商=" + quotient);
    System.out.println();                    
  }

  //日付の出力
  static void showDate(){
    String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
    System.out.println("output of method: " + methodName);
    /* 
    java.time.LocalDate ld = java.time.LocalDate.now();
    System.out.println("Today: " + ld);
    */

    LocalDate ld2 = LocalDate.now();  //importによってエラーが起きない
    System.out.println("Today: " + ld2);
    System.out.println();
  }

  //エンコーディングの出力
  static void showEncoding(){
    String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
    System.out.println("output of method: " + methodName);
    System.out.println("Encoding: " + System.getProperty("file.encoding"));
    System.out.println();
  }

  //文字の出力
  static void showCharacter(){
    String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
    System.out.println("output of method: " + methodName);
    char c1, c2, c3;
    c1 = 'a';
    c2 = 0x0061;
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(0x0061); //直接入力すると、数値として扱われる
    System.out.println('\u0061');
    System.out.println();
  }
  public static void main(String[] args) {
    showHello();
    showInteger(8, 3);
    showDate();
    showEncoding();
    showCharacter();
  }
}
