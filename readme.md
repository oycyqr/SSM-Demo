一、前言
1.1  Mybatis
        MyBatis 本是apache的一个开源项目iBatis, 2010年这个项目由apache software foundation 迁移到了google code，并且改名为MyBatis 。2013年11月迁移到Github。

        iBATIS一词来源于“internet”和“abatis”的组合，是一个基于Java的持久层框架。iBATIS提供的持久层框架包括SQL Maps和Data Access Objects（DAOs）

        MyBatis 是一款优秀的持久层框架，它支持定制化 SQL、存储过程以及高级映射。MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。MyBatis 可以使用简单的 XML 或注解来配置和映射原生类型、接口和 Java 的 POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。

1.2 SSH & SSM  
        SSH(Spring+Spring MVC+Hibernate)框架较注重配置开发，其中的Hiibernate对JDBC的完整封装更面向对象，对增删改查的数据维护更自动化，但SQL优化方面较弱，且入门门槛稍高。

        SSM(Spring+Spring MVC+Mybatis)是当前主流的框架组合开发方式之一，SSM框架越来越轻量级配置，将注解开发发挥到极致，且ORM实现更加灵活，SQL优化更简便。

        相对于SSH框架，SSM框架更适合复杂的大网站的开发。

