package com.bestoyc.ssmdemo.annotation;

import com.bestoyc.ssmdemo.enums.BusinessType;
import com.bestoyc.ssmdemo.enums.OperatorType;

import java.lang.annotation.*;

/**
 * @Author: oyc
 * @Date: 2020-04-01 9:52
 * @Description:自定义操作日志记录注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
	/**
	 * 模块
	 */
	String title() default "";

	/**
	 * 功能
	 */
	BusinessType businessType() default BusinessType.OTHER;

	/**
	 * 操作人类别
	 */
	OperatorType operatorType() default OperatorType.MANAGE;

	/**
	 * 是否保存请求的参数
	 */
	boolean isSaveRequestData() default true;
}
