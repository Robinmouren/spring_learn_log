# 学习spring日志



###  [AOP总结](#aop)

### [Spring 事务](#affairs)



***

***

### <a id="aop">AOP总结</a> ——2023-12-25  16:20

**概念**：AOP(Aspect Oriented Porgramming) ***面向切面编程***，一种编程范式、**思想**

**作用**：在不惊动原始设计的基础上为方法进行**功能增强**

**核心概念**

* **代理**(Proxy)：SpringAOP的核心本质是采用代理模式实现的，目标对象无法直接完成工作，需要对其进行功能回填，通过原始对象的代理对象实现
* **连接点**(JoinPoint)：在SpringAOP中，理解为任意方法的执行
* **切入点**(Pointcut)：匹配连接点的狮子，也就是具有共性功能的方法描述，即**要追加功能的方法**
* **通知**(Advice)：若干个方法的共性功能，在切入点处执行，最终体现为一个方法，即**共性功能**
* **切面**(Aspect)：描述通知与切入点的对应关系
* **目标对象**(Target)：被代理的原始对象成为目标对象，**原始功能去掉共性功能对应的类产生的对象，这种对象是无法直接完成最终工作的**

******

**AOP工作流程**

1、Spring容器启动

2、**读取**所有切面配置中的切入点

3、初始化bean，判定bean对应的类中的方法是否**匹配**到任意切入点

* 匹配失败，创建对象
* 匹配成功，创建原始对象(**目标对象**)的**代理**对象

4、获取bean执行方法

* 获取bean，调用方法并执行，完成操作
* 获取的bean是代理对象时，根据代理对象的运行模式运行原始方法与增强的内容，完成操作

****

* **切入点表达式标准格式**：动作关键词（访问修饰符 返回值 包名.类/接口名.方法名（参数）异常名））
  * execution(* com.itheima.service.*Service.*(..))

* **切入点表达式描述通配符**：
  * *： 匹配任意符号
  * .. ：匹配任意个连续的任意符号
  * +：匹配子类类型

**通知类型**

* **前置通知**
* **后置通知**
* **环绕通知**（***重点***）
  * 环绕通知依赖形参**ProceedingJoinPoint**才能实现对原始方法的调用
  * ————可以隔离原始方法的调用执行
  * ————返回值设置为**Object**类型
  * ————可以对原始方法调用过程中出现的异常进行处理
* **返回后通知**
* **抛出异常后通知**

*****

* **获取切入点方法的参数**
  * **JoinPoint** ：适用于前置、后置、返回后、抛出异常后通知，设置为方法的**第一个形参**
  * **ProceedJointPoint**：适用于环绕通知
    * pjp的getArgs方法获得**参数对象数组**
    * ProceedingJoinPoint类型的参数对象pjp中的proceed方法**可以传参**args，可以**修改**args中的数据以及参数**初始值**的设置等

* **获取切入点方法返回值**
  * 返回后通知
    * 注释中加上**returning**对应的值，并要与afterReturning方法参数中的**类型名**相同
  * **环绕通知**

* **获取切入点方法运行异常信息**
  * 抛出异常后通知
  * **环绕通知**

***

*****

### <a id="affairs">Spring事务日志</a>

#### 事务

* **是**指在处理一系列事情时，要么这些事情全部执行，或者全部不执行

* #### 作用 

  * 在数据层保障一系列的数据库操作同成功同失败

* Spring事务的作用

  * 在数据层或**业务层**保障一系列的数据库操作同成功同失败

***

* Spring中对于事务有一个接口 **PlatformTransactionManager**，其中有两个方法：
  * void **commit**(TransactionStatus status) throws TransactionException;
  * void **rollback**(TransactionStatus status) throws TransactionException;

* 对于接口有一个实现类 DataSourceTransactionManager

***

#### 案例 ——模拟银行账户间转账业务

* 需求：实现任意两个账户间转账操作
* 分析：
  * 数据层提供基础操作，指定账户减钱（outMoney），指定账户加钱（inMoney）
  * 业务层提供转账操作（transfer），调用减钱与加钱操作
  * 提供两个账号和操作金额执行转账操作
  * 基于Spring整合MyBatis环境搭建

程序正常执行时，账户金额加减正常，整体业务成功

程序出现异常后，转账失败，但是异常以前操作成功，异常之后操作失败，正题业务失败

***

* 在业务层实现方法transfer上加上@Transactional注释，意为将此方法加入Spring事务。注：@Transactional可以写在接口上以及实现类上，一般写在业务层实现类方法对应的接口方法上

***

#### Bean注入

* 在Jdbc配置文件首先设置DataSource类，用DruidDataSource创建对象

* 调用set--方法分别设置DriverClassName、Url、Username、Password。数据从propertise文件中通过在配置类中的变量上添加@Value("${propertise文件名.值}")获取，此时DataSource对象将被添加到IOC容器中。

* 创建一个返回值为**PlatformTransactionManager**的transactionManager方法并添加@Bean注释，参数是DataSource类型的对象，执行此方法时将从IOC容器中得到这个对象

* 使用DataSourceTransactionManager来new一个对象transactionManager
* 调用transactionManager的setDataSource方法设置数据源，传参DataSource类型的对象
* 在SpringConfig配置类上添加
  * @Configuration表示是配置类
  * @CompoentScan表示会扫描哪些包，其中填写包的地址
  * @PropertySource表示添加properties的数据源
  * @Import类似于@Bean，向Spring容器中注入
  * @EnableTransactionManagement表示开启事务

***

#### Spring事务角色

* 在业务层transfer方法调用时开启事务T，
* transfer分别调用数据层的两个方法outMoney()、inMoney()
* 调用数据层数据后分别开启两个事务T1、T2分别代表两个方法的执行
* 两个事务在程序正常执行时可以实现金钱增减，当两个方法中间出现异常时，异常前的事务正常执行，异常后的事务不再执行
* 需求：两个方法所开启的事务需要同时执行或终止
* 在transfer方法上添加@Transactional注释后，在执行transfer方法时会开启一个事务T，而在方法体中的方法被调用所开启的事务将会加入事务T，此时程序只有一个事务，这样可以保证两个方法在出现异常时都终止不执行
* 将开启的事务T称事务管理员，加入的事务称事务协调员

***

* transfer方法执行时，若在outMoney之后inMoney之前出现了异常，结果是两个账户的金钱都没有发生改变，即outMoney事务发生了回滚
* 有些异常会参与事务回滚，而有些不会，不会参与回滚会造成上述的结果是一个账户减少了金钱但是另一个账户没有增加金钱
* 此时需要手动在@Transactional注释中将属性RollbackFor添加对应的异常的class，此时该异常就会参与回滚，程序正常执行

***

#### 事务的传播行为

**事务协调员对事务管理员所携带事务的处理态度**

* 在上述中再加一个需求：无论两个账户是否转账成功，都需要进行日志记录
* 既然无论转账时候成功都要执行一个记录日志的方法，则可以使用try...finally方法，将日志业务方法写在这个地方
* 但此时执行程序时若程序中出现了异常，则日志方法不会执行
* **原因**：日志方法也在transfer的方法体中，执行transfer时开启了事务T，方法体中的方法开启事务时都会加入事务T，则若出现了异常，日志的事务就会终止
* **解决**：在日志方法对应的接口方法@Transactional注释中将propagation属性写为Propagation.REQUIRES_NEW，表示不在任何事务中时，会新建一个新的事务，加入了一个事务时，也会创建一个新的事务
* 此时，事务协调员不受总事务T的约束，程序可以正常执行
