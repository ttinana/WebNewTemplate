package rs.tijanap.gym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

	static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	// this advice will run before test()method in every class
	@Before("execution(public void test())")
	public void LoggingAdvice() {
		String msg = " First advice run no matter which class. ";
		logger.info("|INFO| " + msg);
		logger.info("****************************************************************************");
	}

	// this advice will run before method TestSpringCoreApp.test()
	@Before("execution(public void rs.tijanap.gym.testModel.TestSpringCoreApp.test())")
	public void LoggingAdviceInClass() {
		String msg = " First advice run in TestSpringCoreApp class. ";
		logger.info("|INFO| " + msg);
		logger.info("****************************************************************************");
	}

	@Before("allAdvice()")
	public void SecondAdvice() {
		String msg = " Second advice run. ";
		logger.info("|INFO| " + msg);
		logger.info("****************************************************************************");
	}

	// this one should not run: I have no methods with TestSpringCoreApp
	// instance argument
	@Before("allAdvice() && allMethodsWitThisArgument()")
	public void ThirsAdvice() {
		String msg = " Third advice run. ";
		logger.info("|INFO| " + msg);
		logger.info("****************************************************************************");
	}

	// execution aplies on Method level
	@Pointcut("execution(* test())")
	public void allAdvice() {
	}

	// within aplies on Class level
	@Pointcut("within(rs.tijanap.gym.testModel.TestSpringCoreApp)")
	public void beforeAllMEthodsOfTheClass() {

	}

	// args aplies on all methods with arguments of specific classes
	@Pointcut("args(rs.tijanap.gym.testModel.TestSpringCoreApp)")
	public void allMethodsWitThisArgument() {

	}

	// *****************************************************************
	@Before("beforeAllMethodsOfRestaurant()")
	public void SpecificAdvice(JoinPoint joinPoint) {
		String msg = " Specific Restaurant before advice run. " + joinPoint.toString();
		String msg1 = " GET OBJECT upon wich before method is called. " + joinPoint.getTarget();
		logger.info("|INFO| " + msg + msg1);
		logger.info("****************************************************************************");

	}

	@AfterThrowing("execution(public void throwSomeExceptionForAOP())")
	public void SpecificAdviceAfterThrowingEx(JoinPoint joinPoint) {
		String msg = " EXCEPTION THROW advice run. " + joinPoint.toString();
		logger.error("|ERROR| " + msg);
		logger.error("****************************************************************************");

	}

	@AfterReturning("beforeAllMethodsOfRestaurant()")
	public void SpecificAdviceAfter(JoinPoint joinPoint) {

		String msg = " Specific Restaurant AFTER advice run. " + joinPoint.toString();
		String msg1 = " GET OBJECT upon wich AFTER method is called. " + joinPoint.getTarget();
		logger.info("|INFO| " + msg + msg1);
		logger.info("****************************************************************************");

	}

	// within aplies on Class level
	@Pointcut("within(rs.tijanap.gym.testModel.Restaurant)")
	public void beforeAllMethodsOfRestaurant() {
	}

	/*
	 * This pointcut I have defined in xml just for practice
	 * So I can leave it aout of here it will still work
	 * 
	 * @Pointcut("execution(* get*(..))")
	public void allGetters() {
	}*/

	@Pointcut("execution(* set*(..))")
	public void allSeters() {
	}
	
	//@Around(value = "allAdvice()")
	@Around("@annotation(rs.tijanap.gym.aspect.Loggable)")
	public  Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		Object returnValue =null;
		try {
			String msg = " Around advice";
			logger.info("INFO BEFORE AROUND ADVICE " + msg);			
			returnValue =proceedingJoinPoint.proceed();
			logger.info("INFO AFTER AROUND ADVICE " + msg);
		} catch (Throwable e) {	
			String msg ="After Around Throwing";
			logger.error("|ERROR|" +msg);			
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public void loginPrimitiveAdviceToExplainAOPspring(){
		System.out.println("login Primitive Advice To Explain AOP spring");
	}
	
	/*@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void a(String name, RuntimeException ex){
		System.out.println(ex.toString());
	}*/

	/*@AfterReturning("args(name)")
	public void allMethodsWithStringArg(String name) {
		System.out.println("hotmeal" + name);
	}*/

	/*
	 * wildcards:
	 * 
	 * @Before("execution(public * get*())") if I dont know if there are any
	 * arguments, may be but dont have to
	 * 
	 * @Before("execution(* get*(..))")
	 * 
	 * 0 or more arguments of a method wildcard: .. 1 or more arguments of a
	 * method wildcard: *
	 */

}
