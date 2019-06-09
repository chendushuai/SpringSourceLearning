package com.chenss.aspectj;

import com.chenss.dao.IndexDao;
import com.chenss.dao.IndexDaoImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect("perthis(this(com.chenss.dao.IndexDaoImpl))")
public class AopAspectJ {
    //@Pointcut("execution(* com.chenss.dao.*.*(..))")//匹配com.chenss.dao包下的所有接口和类的所有方法
    //@Pointcut("execution(public * com.chenss.dao.*.*(..))")//匹配com.chenss.dao包下的所有接口和类的public方法
    //@Pointcut("execution(public * com.chenss.dao.*.*())")//匹配com.chenss.dao包下的所有接口和类的public 无方法参数的方法
    //@Pointcut("execution(* com.chenss.dao.*.*(java.lang.String, ..))")//匹配com.chenss.dao包下的所有接口和类的第一个参数为String类型的方法
    //@Pointcut("execution(* com.chenss.dao.*.*(java.lang.String))")//匹配com.chenss.dao包下的所有接口和类的只有一个参数，且参数为String类型的方法
    //@Pointcut("execution(* com.chenss.dao.*.*(java.lang.String))")//匹配com.chenss.dao包下的所有接口和类的只有一个参数，且参数为String类型的方法
    //@Pointcut("execution(public * *(..))")//匹配所有的public方法
    //@Pointcut("execution(* te*(..))")//匹配所有的以te开头的方法
    //@Pointcut("execution(* com.chenss.dao.IndexDao.*(..))")//匹配com.chenss.dao.IndexDao接口中所有的方法
    //@Pointcut("execution(* com.chenss.dao..*.*(..))")//匹配com.chenss.dao包及其子包中所有的方法

    // ------------
    // within与execution相比，粒度更大，仅能实现到包和接口、类级别。而execution可以精确到方法的返回值，参数个数、修饰符、参数类型等
    //@Pointcut("within(com.chenss.dao.*)")//匹配com.chenss.dao包中的任意方法
    //@Pointcut("within(com.chenss.dao..*)")//匹配com.chenss.dao包及其子包中的任意方法

    /**
     * 此处需要注意的是，如果配置设置proxyTargetClass=false，或默认为false，则是用JDK代理，否则使用的是CGLIB代理
     * JDK代理的实现方式是基于接口实现，代理类继承Proxy，实现接口。
     * 而CGLIB继承被代理的类来实现。
     * 所以使用target会保证目标不变，关联对象不会受到这个设置的影响。
     * 但是使用this对象时，会根据该选项的设置，判断是否能找到对象。
     */
    //@Pointcut("target(com.chenss.dao.IndexDaoImpl)")//目标对象，也就是被代理的对象。限制目标对象为com.chenss.dao.IndexDaoImpl类
    //@Pointcut("this(com.chenss.dao.IndexDaoImpl)")//当前对象，也就是代理对象，代理对象时通过代理目标对象的方式获取新的对象，与原值并非一个。

    /**
     * args同execution不同的地方在于：
     * args匹配的是运行时传递给方法的参数类型
     * execution(* *(java.io.Serializable))匹配的是方法在声明时指定的方法参数类型。
     */
    //@Pointcut("args(java.io.Serializable)")//匹配运行时传递的参数类型为指定类型的、且参数个数和顺序匹配的方法

    //@Pointcut("@target(com.chenss.anno.Chenss)")//具有@Chenss的目标对象中的任意方法
    //@Pointcut("@within(com.chenss.anno.Chenss)")//等同于@target
    //@Pointcut("@annotation(com.chenss.anno.Chenss)")//匹配带有com.chenss.anno.Chenss注解的方法
    //@Pointcut("@args(com.chenss.anno.Chenss)")//接受一个参数，并且传递的参数的运行时类型具有@Classified注解
    //@Pointcut("bean(dao1)")//名称为dao1的bean上的任意方法
    @Pointcut("bean(dao*)")//名称为dao开头的bean上的任意方法
    public void pointCut() {

    }
    /*@DeclareParents(value="com.chenss.dao.*", defaultImpl= IndexDaoImpl.class)
    public static IndexDao mixin;*/
    /*@Before("pointCut()")
    public void before() {
        System.out.println("aspectJ before");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("aspectJ after");
    }*/
    @Around("pointCut()")
    public void around(ProceedingJoinPoint pjp) {
        System.out.println("aspectJ around before");
        Object[] objects = pjp.getArgs();
        if (objects!=null && objects.length>0) {
            for (int i = 0; i < objects.length; i++) {
                objects[i] += " chenss";
            }
        }
        try {
            pjp.proceed(objects);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("aspectJ around after");
    }
}
