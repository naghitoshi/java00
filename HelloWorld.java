/* Javaの練習用コード
 * ターミナルに表示させるコードの実験 */

// 出力用クラス
package java00;

import java.time.LocalDate;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java00.*;

public class HelloWorld{
  //文字列出力
  public static void showHello(){
    System.out.println("HelloWorld");
    System.out.println("insert a new line\n");
    System.out.print("No ");
    System.out.println("break.");
  }

  //日付の出力
  public static void showDate(){ 
    java.time.LocalDate ld = java.time.LocalDate.now();
    System.out.println("Today: " + ld);

    LocalDate ld2 = LocalDate.now();  //importによってエラーが起きない
    System.out.println("Today: " + ld2);
  }

  //エンコーディングの出力
  public static void showEncoding(){
    System.out.println("Encoding: " + System.getProperty("file.encoding"));
  }
  
  //計算結果出力
  public static void showInteger(int a, int b){
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
                     
  }

  //文字の出力
  public static void showCharacter(){
    char c1, c2, c3;
    c1 = 'a';
    c2 = 0x0061;
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(0x0061); //直接入力すると、数値として扱われる
    System.out.println('\u0061');
  }

  //小数の出力
  public static void showDecimal(){
    float f1, f2;
    //float型の変数に数値を代入する場合そのまま記述するとエラーが起こる。
    //末尾にFを付けることでfloat型の値として扱われる。
    f1 = 3.14F;
    f2 = 314e-2F;
    System.out.println(f1);
    System.out.println(f2);

    double d1, d2;
    d1 = 2.71;
    d2 = 0.271e1;
    System.out.println(d1);
    System.out.println(d2); 
  }

  //型推論
  public static void showVar(){
    var c = 'b';
    var i = 15;
    var d = 1.414;
    var str = "Hello";

    System.out.println(c + ", type: " + ((Object)c).getClass().getSimpleName());
    System.out.println(i + ", type: " + ((Object)i).getClass().getSimpleName());
    System.out.println(d + ", type: " + ((Object)d).getClass().getSimpleName());
    System.out.println(str + ", type: " + ((Object)str).getClass().getSimpleName());
  }

  //演算時の型の確認
  public static void showTypeAfterCalculation(){
    float f1, f2; 
    f1 = f2 = 12.3F;
    double d1, d2;
    d1 = d2 = 34.5;
    short s1, s2;
    s1 = s2 = 5;

    System.out.println("float + float (type): " + ((Object)(f1 + f2)).getClass().getSimpleName());
    System.out.println("float + double (type): " + ((Object)(f1 + d1)).getClass().getSimpleName());
    System.out.println("float + short (type): " + ((Object)(f1 + s1)).getClass().getSimpleName());
    System.out.println("float + short (type): " + ((Object)(s1 + s2)).getClass().getSimpleName());
  }

  public static int test(){
    int a = 10;
    System.out.println("return " + a);
    return a;
  }
  public static void main(String[] args){
    Invoke.execute("java00.HelloWorld", "showHello");
    Invoke.execute("java00.HelloWorld", "showDate");
    Invoke.execute("java00.HelloWorld", "showEncoding");
    Invoke.execute("java00.HelloWorld", "showInteger", 8, 3);
    Invoke.execute("java00.HelloWorld", "showCharacter");
    Invoke.execute("java00.HelloWorld", "showDecimal");
    Invoke.execute("java00.HelloWorld", "showVar");
    Invoke.execute("java00.HelloWorld", "showTypeAfterCalculation");
    int a = (int)Invoke.execute("java00.HelloWorld", "test");
    System.out.println(a);

    Invoke ivk = new Invoke(100); //ヘッダーとフッターの長さを指定
    ivk.execute("java00.HelloWorld", "showTypeAfterCalculation");
  }
}
