## 来学习一下Groovy吧

参考书：《Groovy程序设计》【美】Venkat Subramaniam

如果使用intellij idea，直接新建Groovy项目，就会内建一个Groovy库，安装都省了。

Groovy是什么，有什么用，怎么安装等等这些问题这里不讨论。

一些资源：http://groovy.codehaus.org

### Ready
intellij idea(Widows):

File-->New-->Project...-->Gradle -->Groovy-->next................

等一等......

好了......

### First app : Hello Groovy

src/main/groovy下new Groovy Class,输入名字Hello，OK，便新建好了一个Hello.groovy文件：
```groovy
class Hello {
}
```
在里面写一个main方法：
```groovy
class Hello {
    public static void main(String args){
        println 'Hello Groovy!'
    }
}
```
注意下println方法的调用，它没有静态导入隐式参数就直接使用了，也没有使用括号和双引号,不需要分号结束一句代码。

另外，虽然是按照java的main方法写的，却不能运行。

怎么运行呢？把文件内容清空，文件里只留下 println 'Hello Groovy!'这一句代码，现在可以运行了。

细心的人可能发现在idea中文件显示为了Hello.groovy，而之前的class Hello{...}在左侧窗口显示为Hello。

运行后控制台打印：Hello Groovy！

我们是否可以认为，直接在groovy文件中编写的代码相当于java中写在main方法的代码呢？至少现在看来效果是这样的。

### 循环
Groovy可以使用传统java循环，单还有更多的循环方式，比如这样：


#### 1：in range循环(不好意思，in range是我命的名，不要把它当标准哦)
```groovy
for(i in 0..2) println 'xxx'
```
这个循环打印了三次'xxx'。0..2表示一个range。

#### 2：upto循环

Groovy在java.lang.Integer中加入了一个实例方法upto(我点击Ctrl+方法名导航到了一个org.codehaus.groovy.runtime.DefaultGroovyMethods类中,
因为我听说过Groovy可以动态添加方法，所以我没有特别惊讶)，代码如下：
```groovy
0.upto(2) {println "$it"}
```
打印了三个值：0 1 2。

注意：
* 1：一定要花括号，据说和闭包有关系（突然觉得需要补一下JavaScript基础）
* 2：双引号不可以替换为单引号

我大致推测，花括号大概制造了一个局部作用域，双引号中才能使用类似表达式(我不知道$it应该叫什么，暂时叫它表达式)。

#### 3：times循环

```groovy
3.times {println "$it"}
```
这个和upto循环结果相同。注意一个小细节，方法不需要参数的时候连圆括号都可以省略。

#### 4：step循环
```groovy
0.step(10,2){println "$it"}
```
打印5次：0 2 4 6 8

请自行根据打印结果猜测方法含义。

### GDK

可以认为GDK扩展了JDK。

作者在“GDK一瞥”这一节举的例子是想说明GDK和JDK的不一样，字符串扩展出了一个execute方法，可以执行windows的cmd命令和Linux,Unix的
terminal命令。当然，这个扩展很好，非常好。但是我不想多深入研究这个。

### 安全导航操作符

java程序员很大的一个烦恼是无时无刻都要避免空指针异常。有时候用三元操作符可以简化一下代码，然而仍然很痛苦。有一次，我看到一个
前端的哥们使用TypeScript写出了user?.name,user?.age,我明白了java是时候需要一些革命了。

groovy的安全导航操作符也使用“?.”访问一个对象的方法或属性，如果这个对象为null,代码是不会抛出空指针异常的。

是因为方法根本没有被调用吗?不是的，null?.method()会返回null(如果方法有返回值的话)，看下面的代码：
```groovy
String obj;
print obj?.charAt(0)
print obj?.length
```
两次打印都为null。

### 异常处理

简单总结作者的意思就是：
* 不想处理的异常不用抛出
* 想处理异常就try catch一下
* 捕获所有异常，catch代码块括号里不用写异常类型，就像catch(ex){},但是ex不是Error或Throwable。

