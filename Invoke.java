package java00;

import java.time.LocalDate;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

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
      showStart(cls, mtd, args);

      long startTime = System.currentTimeMillis();  //開始時間記録
      
      // メソッドの実行
      returnValue = mtd.invoke(obj, args);
      long endTime = System.currentTimeMillis();    //終了時間記録
      showEnd(endTime - startTime);

      } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e){
        e.printStackTrace();
      }
      return returnValue;
  }

  static int minframeLength = 70;
  static int maxframeLength = 70;
  Invoke(){
    minframeLength = maxframeLength = 70;
  }

  Invoke(int strlength){
    minframeLength = maxframeLength = strlength;
  }

  //実行開始時の出力
  private static void showStart(Class cls, Method mtd, Object... args){
    
    String headerStr = "┌ Start execution: "+ mtd.getReturnType() + " " 
                        + cls.getName() + "." + mtd.getName() + "(";
    for(int i = 0; i < args.length; i++){
      if(i != 0){
        headerStr += ", ";
      }
      headerStr += String.valueOf(getClass(args[i]));
      headerStr += " ";
      headerStr += String.valueOf(args[i]);
    }
    headerStr += ") ";

    int currentLength = headerStr.length();
    for(int i = 0; i < minframeLength - currentLength - 1; i++){
      headerStr += "─";
    }
    headerStr += "┐";
    System.out.println(headerStr);

    maxframeLength = minframeLength;
    if(maxframeLength < headerStr.length()){
      maxframeLength = headerStr.length();
    }
  }

  //実行終了時の出力
  private static void showEnd(long executionTime){
    String footerStr = " [processing time: " + executionTime + " ms] ┘\n";
    System.out.print("└");
    for(int i = 0; i < maxframeLength - footerStr.length(); i++){
      System.out.print("─");
    }
    System.out.println(footerStr);
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
  private static Method getMethod(Class cls, String methodName, ArrayList<Class> argsClassList){
    Method method = null;
    Class<?>[] argTypes = argsClassList.toArray(new Class<?>[argsClassList.size()]);

    try {
        method = cls.getMethod(methodName, argTypes);
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    }

    return method;
  }
  public static void main(String[] args){

  }
}