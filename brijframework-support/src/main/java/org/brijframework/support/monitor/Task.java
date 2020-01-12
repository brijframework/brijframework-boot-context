package org.brijframework.support.monitor;

import java.util.concurrent.TimeUnit;

public @interface Task {

	public long initialDelay() default 0;

	public TimeUnit initialDelayUnit() default TimeUnit.MINUTES;

	public long period() default 1; //loop time

	public TimeUnit periodUnit() default TimeUnit.MINUTES;// loop unit

	public String preTask() default "";//Method Name

	public String postTask () default "";//Method Name

	public String startDate () default "";

	public String stopDate () default "";

	public String dateFormat () default "";

	public String startTime () default  "";// = "3:00 am",  "3:00AM", "3:00 PM", "3:00pm"

	public String stopTime () default  ""; // = "3:00 am",  "3:00AM", "3:00 PM", "3:00pm"
}
