//package com.example.batchprocessing.EntryPoint;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//
//@SpringBootApplication
//@ComponentScan("com.example.batchprocessing")
//public class BatchProcessingApplicationWithoutScheduler implements CommandLineRunner {
//
//	@Autowired
//	JobLauncher jobLauncher;
//
////	@Autowired
////	@Qualifier("importUserJob")
////	Job importUserJob;
////
////	@Autowired
////	@Qualifier("demoJob")
////	Job demoJob;
////
////	@Autowired
////	@Qualifier("skippingBatchJob")
////	Job skippingBatchJob;
////
////	@Autowired
////	@Qualifier("skippableExceptionDuringReadSampleJob")
////	Job skippableExceptionDuringReadSampleJob;
//
////	@Autowired
////	@Qualifier("skippableExceptionDuringProcessSampleJob")
////	Job skippableExceptionDuringProcessSampleJob;
////
//	@Autowired
//	@Qualifier("skippableExceptionDuringWriteSampleJob")
//	Job skippableExceptionDuringWriteSampleJob;
//
//	public static void main(String[] args)
//	{
//		SpringApplication.run(BatchProcessingApplicationWithoutScheduler.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception
//	{
////		JobParameters params1 = new JobParametersBuilder()
////				.addString("JobID", String.valueOf(System.currentTimeMillis()))
////				.toJobParameters();
////		jobLauncher.run(importUserJob, params1);
////
////		JobParameters params2 = new JobParametersBuilder()
////				.addString("JobID", String.valueOf(System.currentTimeMillis()))
////				.toJobParameters();
////		jobLauncher.run(demoJob, params2);
//
////		JobParameters params3 = new JobParametersBuilder()
////				.addString("JobID", String.valueOf(System.currentTimeMillis()))
////				.toJobParameters();
////		jobLauncher.run(skippingBatchJob, params3);
//
//		JobParameters params = new JobParametersBuilder()
//				.addString("JobID", String.valueOf(System.currentTimeMillis()))
//				.toJobParameters();
//		jobLauncher.run(skippableExceptionDuringReadSampleJob, params);
//
////		JobParameters params5 = new JobParametersBuilder()
////				.addString("JobID", String.valueOf(System.currentTimeMillis()))
////				.toJobParameters();
////		jobLauncher.run(skippableExceptionDuringProcessSampleJob, params5);
//
////		JobParameters params = new JobParametersBuilder()
////				.addString("JobID", String.valueOf(System.currentTimeMillis()))
////				.toJobParameters();
////		jobLauncher.run(skippableExceptionDuringWriteSampleJob, params);
//	}
//}