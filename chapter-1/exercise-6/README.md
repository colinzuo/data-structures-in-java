# Exercise 6

## 基准情况是递归到数组最后一项时

也就是`(low + 1) < high`为false时候
```java
        if ((low + 1) < high) {
            permute(str, low+1, high);
        } else {
            logger.info("permutation: {}", new String(str));
            return;
        }
```

## 递归是首先确定前面的项，然后递归确定后面的项

```java
        char cur = str[low];

        for (int i=low+1; i < high; i++) {
            str[low] = str[i];
            str[i] = cur;
            permute(str, low+1, high);
            str[i] = str[low];
        }

        str[low] = cur;
```

```
2020-10-03 10:43:28.938 [main] INFO  Permute - permutation: abc
2020-10-03 10:43:28.954 [main] INFO  Permute - permutation: acb
2020-10-03 10:43:28.954 [main] INFO  Permute - permutation: bac
2020-10-03 10:43:28.954 [main] INFO  Permute - permutation: bca
2020-10-03 10:43:28.954 [main] INFO  Permute - permutation: cba
2020-10-03 10:43:28.954 [main] INFO  Permute - permutation: cab
```