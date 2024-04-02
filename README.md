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
- `public class HelloWorld`  
`HelloWorld`を出力する

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


## 参考
- [Java入門](https://www.javadrive.jp/start/#section_install) (2024/04/02)
- [Java言語の命名指針](https://qiita.com/rkonno/items/1b30daf83854fecbb814) (2024/04/02)
