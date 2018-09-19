println 'Hello Groovy!'

for(i in 0..2) println 'xxx'

0.upto(2) {println "$it"}

3.times() {println "$it"}

0.step(10,2){println "$it"}

println "cmd cd ../".execute().getClass().name

String obj;
print obj?.charAt(0)
print obj?.length
