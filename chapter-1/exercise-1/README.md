# Exercise 1

bubbleSort就是完整的冒泡排序，包括k以后的部分
divideSelect就是先随机选一个数确定它在排序后的位置，然后根据
结果决定继续在前部分或后部分查找，比如输入大小为10000，要找5000th的数，
第一次如果找到3000th的数，就在比它大的那部分输入中继续寻找

| Input Size | bubbleSort | divideSelect |
| ----------- | ----------- | ----------- |
| 10000      | 125       | 1 |
| 100000   | 15998        | 4 |
| 200000   | 56463        | 4 |

```
2020-10-01 19:48:00.028 [main] INFO  SelectKst - Enter: length 10000, k 5000
2020-10-01 19:48:00.046 [main] INFO  SelectKst - Generate number done
2020-10-01 19:48:00.046 [main] INFO  SelectKst - Select by DivideSelect
2020-10-01 19:48:00.047 [main] INFO  SelectKst - Select by DivideSelect result: 0.5045600658007952, duration 1
2020-10-01 19:48:00.048 [main] INFO  SelectKst - Select by BubbleSort
2020-10-01 19:48:00.173 [main] INFO  SelectKst - Select by BubbleSort result: 0.5045600658007952, duration 125
2020-10-01 19:48:00.173 [main] INFO  SelectKst - Leave
2020-10-01 19:48:00.173 [main] INFO  SelectKst - 
2020-10-01 19:48:00.173 [main] INFO  SelectKst - 
2020-10-01 19:48:00.173 [main] INFO  SelectKst - Enter: length 100000, k 50000
2020-10-01 19:48:00.177 [main] INFO  SelectKst - Generate number done
2020-10-01 19:48:00.177 [main] INFO  SelectKst - Select by DivideSelect
2020-10-01 19:48:00.181 [main] INFO  SelectKst - Select by DivideSelect result: 0.49950106186036847, duration 4
2020-10-01 19:48:00.182 [main] INFO  SelectKst - Select by BubbleSort
2020-10-01 19:48:16.180 [main] INFO  SelectKst - Select by BubbleSort result: 0.49950106186036847, duration 15998
2020-10-01 19:48:16.180 [main] INFO  SelectKst - Leave
2020-10-01 19:48:16.180 [main] INFO  SelectKst - 
2020-10-01 19:48:16.180 [main] INFO  SelectKst - 
2020-10-01 19:48:16.180 [main] INFO  SelectKst - Enter: length 200000, k 100000
2020-10-01 19:48:16.185 [main] INFO  SelectKst - Generate number done
2020-10-01 19:48:16.186 [main] INFO  SelectKst - Select by DivideSelect
2020-10-01 19:48:16.190 [main] INFO  SelectKst - Select by DivideSelect result: 0.4992139827740554, duration 4
2020-10-01 19:48:16.190 [main] INFO  SelectKst - Select by BubbleSort
2020-10-01 19:49:12.653 [main] INFO  SelectKst - Select by BubbleSort result: 0.4992139827740554, duration 56463
2020-10-01 19:49:12.653 [main] INFO  SelectKst - Leave
2020-10-01 19:49:12.653 [main] INFO  SelectKst - 
2020-10-01 19:49:12.653 [main] INFO  SelectKst - 
```