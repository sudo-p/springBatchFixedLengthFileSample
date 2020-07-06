//package com.example.batchprocessing.JobConfigurations;
//
//import com.example.batchprocessing.Tasklets.MyTaskOne;
//import com.example.batchprocessing.Tasklets.MyTaskTwo;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableBatchProcessing
//public class TaskletSample {
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
//    public Job taskletSampleJob(){
//        return jobs.get("taskletSampleJob")
//                .incrementer(new RunIdIncrementer())
//                .start(stepOne())
//                .next(stepTwo())
//                .build();
//    }
//}