# Javaの練習用リポジトリ 00


## 実行環境
コマンド`java -version`によって確認。

```
java version "22" 2024-03-19
Java(TM) SE Runtime Environment (build 22+36-2370)
Java HotSpot(TM) 64-Bit Server VM (build 22+36-2370, mixed mode, sharing)
```
## ファイル
- [HelloWorld.java](#HelloWorld)

### <a id="HelloWorld"></a>HelloWorld.java
- `showHello`(メソッド)  
`"HelloWorld"`などの文字列を出力する
- `showInteger`(メソッド)   
整数の計算結果を出力する
- `showDate`(メソッド)  
日付の出力
- `showEncoding`(メソッド)  
エンコーディングの出力
- `showCharacter`(メソッド)  
文字の出力

## クラス、メソッド、フィールド
- クラス：特定の目的を達成するのに必要なものをまとめたもの  
  
  命名規則）Pascal記法   
  - 先頭を大文字
  - それ以外は小文字
  - 言葉の区切りは大文字
  - 例）`FileCopy` 

- メソッド：クラス内で特定の処理を行うために必要なプログラムをまとめたもの。関数に近い概念。  
  命名規則）camelCase記法   
  - 先頭とそれ以降を小文字。
  - 言葉の区切りは大文字
  - 例）`fileCopy` 

- フィールド：クラスの中でデータの値を保存するために使用するもの。メンバ変数に近い概念。  

```
class クラス{
    データ型 フィールド名; //int A = 0;など

    void メソッド(){
        //
        }
}
```
## mainメソッド
- 最初に呼び出されるメソッド。
- 無い場合、コンパイルエラーは起こらないが、実行時にエラーが起こる
- プログラム起動時に指定された引数を受け取るための仮引数を記述
- public と static という修飾子を記述

```
public static void main(String[] args){
  // ...
}
```

### public static
- public：このメソッドがすべてのクラスからアクセス可能なことを宣言
- static：このメソッドがクラスから作成したオブジェクトのメンバーではなく、クラスそのもののメンバーである事を宣言。

## import
importの宣言によって、クラス名だけで記述することができるようになる。
`String`, `System`クラスなどは`java.lang`パッケージに含まれることからimportを宣言しなくても使用できる。
```
import パッケージ名.クラス名

//例
import java.util.regex.Pattern;
import java.util.regex.Matcher;

//同じパッケージに含まれるクラスをまとめてimport宣言
import java.util.regex.*;
```

## エンコーディング
`System.getProperty("file.encoding")`によってデフォルトのエンコーディング方式を確認できる。
```
//エンコーディングを指定したコンパイル
> javac -encoding エンコーディング名 ソースファイル名
> javac -J-Dfile.encoding=エンコーディング名 ソースファイル名

//エンコーディングを指定してプログラムを実行
> java -Dfile.encoding=エンコーディング名 クラスファイル名
```
- エンコーディング名  
以下は日本でよく使われるエンコーディング
  - US-ASCII  
  128文字の組み合わせを提供する米国の7ビットエンコーディング方式。基本的な英数字と一部の特殊文字をカバーしている。
  - UTF-8  
  可変長のエンコーディング方式であり、英数字や米国のASCII文字に関しては1バイトでエンコードされるが、それ以外の文字に関しては2〜4バイトの可変長でエンコードされる。日本語も含まれており、広くサポートされている。
  - EUC-JP  
  Extended Unix Code-JPの略で、日本語の文字エンコーディング方式の1つ。ASCII文字に関しては1バイトでエンコードされ、日本語の漢字や仮名に関しては2バイトでエンコードされる。
  - Shift_JIS  
  主に日本語の文字をエンコードするためのエンコーディング方式。ASCII文字に関しては1バイトでエンコードされ、ほとんどの日本語の文字に関しては2バイトでエンコードされる。
  - windows-31j  
  主にMicrosoft Windowsで使用される日本語の文字エンコーディング方式。Shift_JISと同様に、ASCII文字に関しては1バイトでエンコードされ、ほとんどの日本語の文字に関しては2バイトでエンコードされる。

## 文字リテラル
文字リテラルは一つの文字の値。複数の文字からなる値は文字列リテラルと呼ばれ区別される。
```
char c1 = 'a';
char c2 = 0x0061;

System.out.println(c1); //a
System.out.println(c2); //a

//直接入力する場合は'\uXXXX'のように記述する
System.out.println(0x0061); //97
System.out.println('\u0061'); //a
```

## 参考
- [Java入門](https://www.javadrive.jp/start/#section_install) (2024/04/02)
- [Java言語の命名指針](https://qiita.com/rkonno/items/1b30daf83854fecbb814) (2024/04/02)
