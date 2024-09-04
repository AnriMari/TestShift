# Read Me First

Java Version 17
Maven Version 4.0.0

*** Утилита фильтрации содержимого файлов. Инструкция по запуску:

1. Собрать проект с помощью mvn clean package
2. Запустить утилиту:
   2.1 java -cp target/test-classes/TestShift-0.0.1-SNAPSHOT.jar
   2.2 java -cp target/classes org.example.FilterUtility.Main file1.txt file2.txt
       (file1.txt file2.txt - входные файлы из корневого каталога.)
   Так же можно указать:
       -o /output/path - путь для выходных файлов.
       -p sample_ - префикс для выходных файлов.
       -a - режим добавления данных в выходные файлы.
       -f - полная статистика (-s для краткой).


### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.2/maven-plugin/build-image.html)
* [Docker Compose Support](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#features.docker-compose)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the
parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.


  

   
