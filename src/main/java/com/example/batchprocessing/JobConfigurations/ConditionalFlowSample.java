//package com.example.batchprocessing.JobConfigurations;
//
//import com.example.batchprocessing.Tasklets.MyTaskOne;
//import com.example.batchprocessing.Tasklets.MyTaskThree;
//import com.example.batchprocessing.Tasklets.MyTaskTwo;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.builder.FlowJobBuilder;
//import org.springframework.batch.core.job.flow.Flow;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableBatchProcessing
//public class ConditionalFlowSample {
//
//    @Autowired
//    private JobBuilderFactory jobs;
//
//    @Autowired
//    private StepBuilderFactory steps;
//
//    @Bean
//    public Step stepOne(){
//        return steps.get("stepOne")
//                .tasklet(new MyTaskOne())
//                .build();
//    }
//
//    @Bean
//    public Step stepTwo(){
//        return steps.get("stepTwo")
//                .tasklet(new MyTaskTwo())
//                .build();
//    }
//
//    @Bean
//    public Step stepThree(){
//        return steps.get("stepThree")
//                .tasklet(new MyTaskThree())
//                .build();
//    }
//
//    @Bean
//    public Job conditionalFlowSampleJob(){
//        return jobs.get("conditionalFlowSampleJob")
//                .incrementer(new RunIdIncrementer())
//                .start(stepOne())
//                .on("*").to(stepThree())
//                .from(stepOne()).on("FAILED").to(stepTwo())
//                .build()
//                .build();
//
//    }
//}