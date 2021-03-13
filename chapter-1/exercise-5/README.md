# Exercise 5

通过位与操作判断是否是奇数，然后右移一位继续判断

```java
        while (num > 0) {
            if ((num & 1) == 1) {
                cnt++;
            }

            num /= 2;
        }
```