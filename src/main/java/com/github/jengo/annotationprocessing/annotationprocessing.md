#ANNOTATION PROCESSING
[tutorial](http://hannesdorfmann.com/annotation-processing/annotationprocessing101)
[Java基础入门笔记](https://www.bookstack.cn/read/Java_Basic_Introduction/%E7%AC%AC10%E7%AB%A0%20%E5%8F%8D%E5%B0%84%E6%9C%BA%E5%88%B6-Annotation-Processing-Tool%E8%AF%A6%E8%A7%A3.md)
[code](https://github.com/jengowong/annotationprocessing101)

----

##tutorial
1.explain to you what annotation processing is, 
  what you can do with that powerful tool 
  and finally what you cannot do with it.
2.implement a simple annotation processor step by step

###The Basics
run time = the time when the application runs
compile time = the time when the java compiler compiles your java source code

Annotation processing is a tool build in javac for scanning and processing annotations at compile time.
You can register your own annotation processor for certain annotations.

An annotation processor for a certain annotation takes java code (or compiled byte code) as input and generate files (usually .java files) as output. 