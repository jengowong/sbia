# 深入理解Java类型信息(Class对象)与反射机制

> 参考：https://mp.weixin.qq.com/s/qSrzpgfkyJsLQrunxrIRHw

## 深入理解Class对象
### Class对象的加载
### ClassforName方法
### Class字面常量
### 理解泛化的Class对象引用
### 关于类型转换的问题
### instanceof 关键字与isInstance方法
### RRTI的概念以及Class对象作用
### Class对象的加载及其获取方式
## 理解反射技术
### Constructor类及其用法
### Field类及其用法
### Method类及其用法
### 反射包中的Array类

---

+ RTTI(Run-Time Type Identification)运行时类型识别，其作用是在运行时识别一个对象的类型和类的信息；
+ 在Java中用来表示运行时类型信息的对应类就是Class类；
+ Class类被创建后的对象就是Class对象，Class对象表示的是自己手动编写类的类型信息；
+ 每当我们编写并且编译一个新创建的类就会产生一个对应Class对象并且这个Class对象会被保存在同名.class文件里(编译后的字节码文件保存的就是Class对象)；
+ 为什么需要这样一个Class对象呢？
  因为当我们new一个新对象或者引用静态成员变量时，Java虚拟机(JVM)中的类加载器子系统会将对应Class对象加载到JVM中，然后JVM再根据这个类型信息相关的Class对象创建我们需要的实例对象或者提供静态变量的引用值；
+ 需要特别注意的是，手动编写的每个class类，无论创建多少个实例对象，在JVM中都只有一个Class对象；
+ Class类只存私有构造函数，因此对应Class对象只能有JVM创建和加载；
+ 使用new操作符创建类的新实例对象也会被当作对类的静态成员的引用(构造函数也是类的静态方法)；
+ Class类中定义的方法将适用所有Class对象；
+ 当我们想获取一个类的运行时类型信息并加以使用时，可以调用Class.forName()方法获取Class对象的引用，这样做的好处是无需通过持有该类的实例对象引用而去获取Class对象；
+ 在Java中存在另一种方式来生成Class对象的引用，它就是Class字面常量；
+ 使用字面常量获取Class对象引用方式不仅可以应用于普通的类，也可以应用用接口，数组以及基本数据类型；
+ 使用字面常量的方式获取Class对象的引用不会触发类的初始化，因为触发的是类的加载阶段，在这个阶段Class对象已创建完成，获取其引用并不困难，而无需触发类的最后阶段初始化；
+ 引用编译期静态常量不会触发初始化；
+ 类的加载过程：
  (1)加载Loading：通过一个类的完全限定查找此类字节码文件，并利用字节码文件创建一个Class对象；
  (2)链接Linking
  (2.1)验证Verification：验证字节码的安全性和完整性；
  (2.2)准备Preparation：为静态域分配存储空间，注意此时只是分配静态成员变量的存储空间，不包含实例成员变量；
  (2.3)解析Resolution：如果必要的话，解析这个类创建的对其他类的所有引用；
  (3)初始化Initialization：若该类具有超类，则对其进行初始化，执行静态初始化器和初始化静态成员变量；
+ 应该时刻记住向Class引用添加泛型约束仅仅是为了提供编译期类型的检查从而避免将错误延续到运行时期；
+ 所有类型转换都是在运行时进行正确性检查的，利用RTTI进行判断类型是否正确从而确保强制转换的完成，如果类型转换失败，将会抛出类型转换异常；
+ 事实上instanceOf与isInstance方法产生的结果是相同的；
+ 反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性，这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制；
+ 在Java中，Class类与java.lang.reflect类库一起对反射技术进行了全力的支持；
  Constructor类表示的是Class对象所表示的类的构造方法，利用它可以在运行时动态创建对象；获取Constructor对象是通过Class类中的方法获取的；
  Field表示Class对象所表示的类的成员变量，通过它可以在运行时动态修改成员变量的属性值(包含private)；
  Method表示Class对象所表示的类的成员方法，通过它可以动态调用对象的方法(包含private)；
  Type是Java编程语言中所有类型的公共高级接口，它们包括原始类型、参数化类型、数组类型、类型变量和基本类型；
  由于Type顶级接口，Class也实现了该接口，因此Class类是Type的子类，Type表示的全部类型而每个Class对象表示一个具体类型的实例；