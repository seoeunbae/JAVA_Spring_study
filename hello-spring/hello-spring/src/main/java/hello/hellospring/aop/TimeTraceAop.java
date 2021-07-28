package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimeTraceAop {// 다 작성한뒤 얘를 스프링빈으로 등록해줘야함

    @Around("execution(* hello.hellospring..*(..))")//적용어디다가 할지 설정하는 어노테이션(hello.hellospring밑은 다 적용해)
        public Object execut(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        try{
            //다음메소드로 진행되는 메소드
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+" "+timeMs+"ms");
        }

    }
}
