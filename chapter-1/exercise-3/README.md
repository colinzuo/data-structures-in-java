# Exercise 3

首先假设当含小数时候使用有效位数设定为15，然后通过将double转换为long提取
整数部分，之后根据整数部分位数计算小数部分位数，通过乘10的对应幂和Math.round
提取小数部分，两部分打印就是简单的求余

```
long integralPart = (long) target;

fractionalPrecision -= intPartList.size();

long factionalPart = Math.round((target - (long) target) * Math.pow(10, fractionalPrecision));
```

```
2020-10-02 09:19:02.657 [main] INFO  PrintDouble - Target 611076179.404044000000000
2020-10-02 09:19:02.672 [main] INFO  PrintDouble - Target 611076179.404044
2020-10-02 09:19:02.672 [main] INFO  PrintDouble - Target 611076179.40404403209686279296875

611076179.404044
```