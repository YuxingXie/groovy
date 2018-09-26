## 来学习一下Groovy吧

我学习Groovy目的不是为了用它取代java，我的目的很小，只是为了更好的使用Gradle。所以，不会学的太深。

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

src/main/groovy下new--> Groovy Class,输入名字Hello，点OK，便新建好了一个Hello.groovy文件：
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

提醒下，package语句是不能省略的，Hello.groovy刚好没在包中所以代码中没有package语句。

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

我大致推测，花括号大概制造了一个局部作用域，双引号中才能使用类似表达式($it叫循环索引值)。

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

### 补充一下
到这里必须指出几点知识点了，书中一直都在使用，但作者就是不说出来。

* 定义一个方法使用关键字def methodName(param1,param2...)，静态方法定义是def static，无需返回类型

* 很神奇的是，方法的形参不需要指定类型

另外，作者也有几点说明的：

* 1 return语句几乎总是可选的，注意这个“几乎”

* 2 分号分隔语句也是可选的

* 3 方法和类默认是public的

* 4 ?.操作符（请不厌其烦的称之为安全导航操作符）只有对象引用不为空时才会分派调用(否则直接取得null值，本括号内内容是我加的)

* 5 作者说：静态方法内可以使用this来引用Class对象，所以可以使用链式调用。我知道作者的意思，但他的代码我看不懂。

理解一下这几点：

我们前面知道方法定义无需返回类型，所以第一点的return可选，有return类似于定义了返回类型，没return类似于定义了void方法。

第五点作者代码编译都错，这个再说。

## ------------------------重要的分隔线 ----------------------------------

最近不小心看到一本书，叫做《实战Gradle》,其中有一章附录叫《Gradle用户所需要了解的Groovy》，只有短短10页。是的，学习Gradle只
需要极少的Groovy知识。所以，再见了《Groovy程序设计》。

可能，这个GitHub项目会变成一个Gradle学习项目。不如试试吧，因为我创建它的时候碰巧选择了new Gradle project。

## 新的开始，Gradle

同样的，介绍什么的免了，它和ant maven什么关系，和敏捷开发什么关系慢慢去琢磨吧。

直接从安装开始。大概在书的39页。

注意Mac和windows的安装，都需要GRADLE_HOME环境变量，以及导出到PATH中。我安装的版本是Gradle 4.1。

### Hello world!

在build.gradle中写一段代码：
```groovy
task helloWorld{
    doLast {
        println 'Hello world!'
    }
}
```
在终端中运行命令：
```text
$ gradle -q helloWorld
```
输出了字符串"Hello world!"。

#### 代码解释：

先说明，代码解释不是抄书上的，我觉得书上的说得云里雾里。这是我的理解，但是可能理解有误，坑了你请莫怪。

我认为build.gradle文件是一个实现了org.gradle.api.Project接口的类，因为我按command键(win下Ctrl)导航task,代码导航到了
Project接口的task方法，方法返回类型是org.gradle.api.Task。

这个helloWorld是什么呢？task方法的参数？应该不是。引用task方法返回值的变量名？暂且这样认为吧。

另外，build.gradle还可能实现了别的接口，再研究。

然后我认为task方法内部是返回了一个匿名内部类，类型是Task，doLast是Task接口定义的一个方法，在匿名内部类中实现了。

至于为什么那么多接口方法为什么只实现了doLast,我认为我可能对groovy了解不够吧，不能用java的思维方式思考groovy。
也可能这个build.gradle继承自一个实现了Project接口的抽象类吧。

另外，在我的IDE(Intellij Idea)的gradle tool button中发现点小东西：

![](https://github.com/YuxingXie/groovy/raw/master/images/1.png) 

双击helloWorld节点，控制台同样打印出了“Hello world!”。

### Gradle的DSL

DSL:(Domain Specific Language)领域专用语言

理解这门语言需要知道它的两个重要元素：task和action。

action中的doLast可以用“<<”表示：
```groovy
task helloWorld << {
        println 'Hello world!'
}
```
可以运行，不过出现了警告，不建议使用这种方式：
```text
The Task.leftShift(Closure) method has been deprecated and is scheduled to be removed in Gradle 5.0. Please use Task.doLast(Action) instead.
```
说实话，习惯了java啰嗦的语法，某些简单语法反而不适应了。我宁愿啰嗦点也不要语意不明，或者加重记忆负担。

下面的代码展示了，一些更高级的特性。好在我学了点groovy皮毛，能看得懂了。

和书中的代码比较，我没有使用“<<”语法：
```groovy
task startSession{
    doLast{
        chant()
    }
}
def chant(){
    ant.echo(message:'Repeat after me...')
}
3.times {
    task "yayGradle$it"{
        doLast{
            println 'Gradle rocks'
        }
    }
}
yayGradle0.dependsOn startSession
yayGradle2.dependsOn yayGradle1,yayGradle0
task groupTherapy(dependsOn:yayGradle2)

```
这里有点颠覆我之前关于“helloWorld”是什么的推测。因为task "yayGradle$it"是一个字符串，所以它可能不是一个变量名。
我吧helloWorld也加上单引号，task仍然是可以执行的。所以它可能是task方法的参数。这个字符串代表这个任务名。那又怎么解释
不带引号的形式呢？它也是字符串吗？我就当它是吧，groovy没什么不可能。

