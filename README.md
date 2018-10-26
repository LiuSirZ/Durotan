# 基于SpringBoot的基础项目架构(未进行性能调优，待完善版本)
## 旨在快速搭建SpringBoot项目以及整合其他框架 
### 项目参考 [ lihengming/spring-boot-api-project-seed ](https://github.com/lihengming/spring-boot-api-project-seed "lihengming/spring-boot-api-project-seed")
### 一、当前架构
#### 1.SpringBoot + mybatis + 通用Mapper + Project Lombok + cors 
### 二、插件介绍
#### 1）Project Lombok
通过注释帮助我们生成常用的代码 例如set/get，log等。减少重复性工作
#### 2）cors
解决跨域问题。
#### 3）mybatis & 通用Mapper
持久层选择使用市面常用的mybatis，同样使用通用Mapper提供单表操作的基础方法。减少开发人员工作量。
