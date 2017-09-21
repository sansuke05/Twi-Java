![](https://img.shields.io/badge/languauge-java%208-orange.svg)

# Twi-Java
This is class-library when you handle TwitterAPI that build on Gradle
# Build and LICENCE
Build status:[![Build Status](https://travis-ci.org/ItinoseSan/Twi-Java.svg?branch=master)](https://travis-ci.org/ItinoseSan/Twi-Java) LICENCE:[![](http://img.shields.io/badge/license-MIT-blue.svg?style=flat)](https://github.com/ItinoseSan/Twi-Java/blob/master/TwitterAPI/LICENCE)
# The content relations pull request
I welcome it.but if you pullrequest to this repository,you should write description of pullrequest content in English.
# How to Use
### 1.Clone this repository.
### 2.Apache HttpComponent add as a library your Java application project.
```build.gradle
dependencies {
    compile 'org.apache.httpcomponents:httpclient:4.5.3'
    //You should use new library version
}
```
### 3.Please write this code when you want to use twitterAPI on Java application.
#### Tweet
```Java
 public static void main(String[] args) throws IOException {
        TwiJava twiJava = new TwiJava("ConsumerKey", "ConsumerSecret","AccessToken", "AccessTokenSecret");
        System.out.println(twiJava.tweet("Hello World from Twi-Java"));
    }
```  
#### Get UserTimeline
```Java
   System.out.println(twiJava.getUserTimeLine("100")); //String is tweet count 
```
#### Get HomeTimeline
```Java
  System.out.println(twiJava.getUserTimeLine("100")); 
```

※Japanese

# Twi-Java
Javaで作ったTwitterAPIを使うライブラリです。ビルドツールとしてGradleを導入してみました。
# 使い方
### 1.リポジトリをクローンします。
### 2.ApacheのHttpComponentをJavaプロジェクト内にライブラリとして追加します。
### 3.使用する場合は上の用なコードを書いてください。
# ライセンス
MITライセンスなので使用、改変ともに自由です。

    
