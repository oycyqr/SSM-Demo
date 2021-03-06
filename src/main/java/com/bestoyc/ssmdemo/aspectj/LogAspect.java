package com.bestoyc.ssmdemo.aspectj;

import com.bestoyc.ssmdemo.annotation.Log;
import com.bestoyc.ssmdemo.domain.SysOperLog;
import com.bestoyc.ssmdemo.enums.BusinessStatus;
import com.bestoyc.ssmdemo.service.SysOperLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * @Author: oyc
 * @Date: 2020-04-01 9:52
 * @Description: 操作日志记录处理
 */
@Aspect
@Component
public class LogAspect {
	private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

	@Resource
	private SysOperLogService logService;
	/**
	 * 配置织入点
	 */
	@Pointcut("@annotation(com.bestoyc.ssmdemo.annotation.Log)")
	public void logPointCut() {
	}

	/**
	 * 前置通知 用于拦截操作
	 *
	 * @param joinPoint 切点
	 */
	@AfterReturning(pointcut = "logPointCut()")
	public void doBefore(JoinPoint joinPoint) {
		handleLog(joinPoint, null);
	}

	/**
	 * 拦截异常操作
	 *
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(value = "logPointCut()", throwing = "e")
	public void doAfter(JoinPoint joinPoint, Exception e) {
		handleLog(joinPoint, e);
	}

	protected void handleLog(final JoinPoint joinPoint, final Exception e) {
		try {
			log.info("==保存操作日志到数据库==");
			// 获得注解
			Log controllerLog = getAnnotationLog(joinPoint);
			if (controllerLog == null) {
				return;
			}
			// 获取当前的用户
			//SysUser currentUser = ShiroUtils.getSysUser();
			// *========数据库日志=========*//
			SysOperLog operLog = new SysOperLog();
			operLog.setStatus(BusinessStatus.SUCCESS.ordinal());
			// 请求的地址 ShiroUtils.getIp()
			String ip = "127.0.0.1";
			operLog.setOperIp(ip);
			operLog.setOperUrl("home");
			if (e != null) {
				operLog.setStatus(BusinessStatus.FAIL.ordinal());
				operLog.setErrorMsg(e.getMessage().substring( 0, 2000));
			}
			// 设置方法名称
			String className = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName();
			operLog.setMethod(className + "." + methodName + "()");
			// 处理设置注解上的参数
			getControllerMethodDescription(controllerLog, operLog);
			// 保存数据库
			//AsyncManager.me().execute(AsyncFactory.recordOper(operLog));
			logService.insert(operLog);
		} catch (Exception exp) {
			//记录本地异常日志
			log.error("==前置通知异常==");
			log.error("异常信息:{}", exp.getMessage());
			exp.printStackTrace();
		}
	}


	/**
	 * 是否存在注解，如果存在就获取
	 */
	private Log getAnnotationLog(JoinPoint joinPoint) throws Exception {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();

		if (method != null) {
			return method.getAnnotation(Log.class);
		}
		return null;
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 *
	 * @param log     日志
	 * @param operLog 操作日志
	 * @throws Exception
	 */
	public void getControllerMethodDescription(Log log, SysOperLog operLog) throws Exception {
		// 设置action动作
		operLog.setBusinessType(log.businessType().ordinal());
		// 设置标题
		operLog.setTitle(log.title());
		// 设置操作人类别
		operLog.setOperatorType(log.operatorType().ordinal());
		// 是否需要保存request，参数和值
		if (log.isSaveRequestData()) {
			// 获取参数的信息，传入到数据库中。
			//setRequestValue(operLog);
		}
	}

	/**
	 * 获取请求的参数，放到log中
	 *
	 * @param operLog 操作日志
	 * @throws Exception 异常
	 */
	/*private void setRequestValue(SysOperLog operLog) throws Exception {
		Map<String, String[]> map = ServletUtils.getRequest().getParameterMap();
		String params = JSON.marshal(map);
		operLog.setOperParam(StringUtils.substring(params, 0, 2000));
	}*/
}
