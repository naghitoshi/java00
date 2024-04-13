# Javaの練習用リポジトリ 00


## 1. 実行環境
コマンド`java -version`によって確認。

```
java version "22" 2024-03-19
Java(TM) SE Runtime Environment (build 22+36-2370)
Java HotSpot(TM) 64-Bit Server VM (build 22+36-2370, mixed mode, sharing)
```
## 2. ファイル
- [HelloWorld.java](#HelloWorld)

### <a id="HelloWorld"></a>2.1. HelloWorld.java
- `HelloWorld`(クラス)
  - `showHello`(メソッド)  
    `"HelloWorld"`などの文字列を出力する。
  - `showInteger`(メソッド)   
    整数の計算結果を出力する。
  - `showDate`(メソッド)  
    日付の出力。
  - `showEncoding`(メソッド)  
    エンコーディングの出力。
  - `showCharacter`(メソッド)  
    文字の出力。
  - `showDecimal`(メソッド)  
    小数の出力。
  - `showVar`(メソッド)  
    varを使用した宣言。
  - `showOperationType`(メソッド)
    演算時の型の出力。
- `Invoke`(クラス)
  - `execute`(メソッド)  
    メソッドを実行し、実行時間を表示する。
  - `showTitle`(メソッド)  
    実行したメソッドの文字列を表示する。`execute`で使用する。
  - `getClass`(メソッド)
    Object型からプリミティブ型またはクラス型の Class オブジェクトを返す。`getClassList`で使用する。
  - `getClassList`(メソッド)  
    Object型配列から、プリミティブ型またはクラス型の Class オブジェクト配列を返す。`execute`で使用する。
  - `getMethod`(メソッド)  
    メソッドを返す。`execute`で使用する。
    
## 3. クラス、メソッド、フィールド
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
## 4. mainメソッド
- 最初に呼び出されるメソッド。
- 無い場合、コンパイルエラーは起こらないが、実行時にエラーが起こる
- プログラム起動時に指定された引数を受け取るための仮引数を記述
- public と static という修飾子を記述

```
public static void main(String[] args){
  // ...
}
```

### 4.1. public static
- public：このメソッドがすべてのクラスからアクセス可能なことを宣言
- static：このメソッドがクラスから作成したオブジェクトのメンバーではなく、クラスそのもののメンバーである事を宣言。

## 5. import
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

## 6. エンコーディング
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

## 7. 基本データ型
| データ型 | 説明 |
| :---: | :---: |
| boolean | true or false |
| char | 16ビットUnicode文字 \u0000～\uFFFF |
| byte | 8ビット整数 -128～127 |
| short | 16ビット整数 -32,768～32,767 |
| int | 32ビット整数 -2,147,483,648～2,147,483,647 |
| long | 64ビット整数 -9,223,372,036,854,775,808～9,223,372,036,854,775,807 |
| float | 32ビット単精度浮動小数点数 |
| long | 64ビット倍精度浮動小数点数 |

### 7.1 文字リテラル
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

### 7.2. 小数
float型とdouble型がある。`[仮数部]e[符号][指数部]`のように記述する方法もある。  
float型の変数に数値を代入する場合、そのまま記述するとエラー(エラー: 不適合な型: 精度が失われる可能性があるdoubleからfloatへの変換)が起こる。末尾にFを付けることでfloat型の値として扱われる。このような末尾の記号はサフィックスと呼ばれる。
```
float f1, f2;
f1 = 3.14F;
f2 = 314e-2F;
System.out.println(f1); //3.14
System.out.println(f2); //3.14

double d1, d2;
d1 = 2.71;
d2 = 0.271e1;
System.out.println(d1); //2.71
System.out.println(d2); //2.71
```
### 7.3. サフィックス
数値に対して末尾に記号(サフィックス)を付けることで、型を指定することができる。例えば、整数は特に指定しない場合、通常int型(-2147483648 ～ 2147483647)になるが、数値の範囲を超えた値を扱いたいときは、末尾にLを付けることでlong型になる。

| データ型 | サフィックス |
| :---: | :---: |
| long | L (or l) |
| float | F or f |
| double | D or d |

### 7.4. 型推論
Java10からvarを使用することで、型の宣言時にデータ型の記述を省略することができる。varを使用する場合、宣言時に値を代入する必要がある。

```
var num = 10;
var str = "Hello";
```

### 7.5. 演算時の型変換
以下のルールが 1. から順に適用される。特に 4. では、shortやbyte型同士で演算を行った場合もint型に変換が行われることに注意。

1. どちらかの値が double 型の場合は他の値を double 型に変換する
2. どちらかの値が float 型の場合は他の値を float 型に変換する
3. どちらかの値が long 型の場合は他の値を long 型に変換する
4. 1から3に該当しない場合は両方の値を int 型に変換する


## 参考
- [Java入門](https://www.javadrive.jp/start/#section_install) (2024/04/02)
- [Java言語の命名指針](https://qiita.com/rkonno/items/1b30daf83854fecbb814) (2024/04/02)
