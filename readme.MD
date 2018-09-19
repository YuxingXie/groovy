## 来学习一下Groovy吧

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
注意下println方法，没有括号，双引号。

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
注意：
* 1：一定要花括号，据说和闭包有关系
* 2：双引号不可以替换为单引号

我大致推测，花括号大概制造了一个局部作用域，双引号中才能使用类似表达式(我不知道$it应该叫什么，暂时叫它表达式)。

