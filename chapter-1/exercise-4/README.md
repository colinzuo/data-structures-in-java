# Exercise 4

## 通过NIO的接口读取文件

```java
        Path path = Paths.get(filePath);

        BufferedReader reader = Files.newBufferedReader(path);
        String line;

        while ((line = reader.readLine()) != null) {
```

## 通过正则判断是否是include语句

```java
private final Pattern p = Pattern.compile("^#include\\s\"(.*)\"$");

            Matcher matcher = p.matcher(line);
            boolean matchFound = matcher.find();
```

## 递归调用如果是include语句

```java
            if (matchFound) {
                String includedFilePath = matcher.group(1);
                String includedContent = preprocess(includedFilePath);
                stringBuffer.append(includedContent);
                continue;
            }
```
