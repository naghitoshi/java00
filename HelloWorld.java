/* Javaの練習用コード
 * ターミナルに表示させるコードの実験 */

// 出力用クラス

import java.time.LocalDate;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

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

  public static void main(String[] args){
    Invoke ivk = new Invoke();
    ivk.execute("HelloWorld", "showHello");
    ivk.execute("HelloWorld", "showDate");
    ivk.execute("HelloWorld", "showEncoding");
    ivk.execute("HelloWorld", "showInteger", 8, 3);
    ivk.execute("HelloWorld", "showCharacter");
    ivk.execute("HelloWorld", "showDecimal");
    ivk.execute("HelloWorld", "showVar");
    ivk.execute("HelloWorld", "showTypeAfterCalculation");

  }
}

//メソッド実行用クラス
public class Invoke{

  public static Object execute(String classname, String methodname, Object... args){
    Object returnValue = null;
    try{
      //クラスの取得
      Class<?> cls = Class.forName(classname);
      // インスタンスの取得
      Object obj = cls.getDeclaredConstructor().newInstance();

      //可変長引数のクラスのリストを取得
      ArrayList<Class> argsClassList = getClassList(args);

      // メソッドの取得
      Method mtd = getMethod(cls, methodname, argsClassList);
      
      //文字列の出力
      showTitle(cls, mtd, args);

      long startTime = System.currentTimeMillis();  //開始時間記録
      // メソッドの実行
      returnValue = mtd.invoke(obj, args);
      long endTime = System.currentTimeMillis();    //終了時間記録
      System.out.println("------------------------------ (processing time: " 
                          + (endTime - startTime)
                          + " ms)\n"); 

      } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e){
        e.printStackTrace();
      }
      return returnValue;
  }

  //文字列の出力
  public static void showTitle(Class cls, Method mtd, Object... args){
    String title = "-- Start execution: " + cls.getName() + "." + mtd.getName() + "(";
    for(int i = 0; i < args.length; i++){
      if(i != 0){
        title += ", ";
      }

      if(args[i] instanceof Integer){
        title += (int)args[i];
      } else if (args[i] instanceof Short) {
        title += (short)args[i];
      } else if (args[i] instanceof Long) {
        title += (long)args[i];
      } else if (args[i] instanceof Byte) {
        title += (byte)args[i];
      } else if (args[i] instanceof Float) {
        title += (float)args[i];
      } else if (args[i] instanceof Double) {
        title += (double)args[i];
      } else if (args[i] instanceof Character) {
        title += (char)args[i];
      } else if (args[i] instanceof String) {
        title += (String)args[i];
      } else if (args[i] instanceof Boolean) {
        title += (boolean)args[i];
      } else {
        System.out.println("Unknown type argument: " + args[i]);
        System.exit(1);
      }
    }
    title += ")";

    final int MAXTITLELENGE = 55;
    System.out.print(title);
    for(int i = 0; i < MAXTITLELENGE - title.length(); i++){
        System.out.print("-");
    }
    System.out.println();
  }

  public static Class<?> getClass(Object arg){
    Class<?> cls = null;

    if (arg instanceof Integer) {
      cls = int.class;
    } else if (arg instanceof Short) {
      cls = short.class;
    } else if (arg instanceof Long) {
      cls = long.class;
    } else if (arg instanceof Byte) {
      cls = byte.class;
    } else if (arg instanceof Float) {
      cls = float.class;
    } else if (arg instanceof Double) {
      cls = double.class;
    } else if (arg instanceof Character) {
      cls = char.class;    
    } else if (arg instanceof String) {
      cls = String.class;
    } else if (arg instanceof Boolean) {
      cls = boolean.class;
    } else {
      System.out.println("Unknown type argument: " + arg);
      System.exit(1);
    } 
    return cls;
  }

  //クラスのリストを取得
  public static ArrayList<Class> getClassList(Object[] args){
    ArrayList<Class> classList = new ArrayList<>();
    
    for (Object arg : args) {
      classList.add(getClass(arg)); 
    }

    return classList;
  }
  
  //メソッドの取得
  @SuppressWarnings("unchecked")
  //警告: [unchecked] raw型ClassのメンバーとしてのgetMethod(String,Class<?>...)への無検査呼出しです
  //を抑制しているが、知識不足から安全性は未確認
  public static Method getMethod(Class cls, String methodName, ArrayList<Class> argsClassList){
    Method method = null;
    Class<?>[] argTypes = argsClassList.toArray(new Class<?>[argsClassList.size()]);

    try {
        method = cls.getMethod(methodName, argTypes);
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    }

    return method;
  }
}