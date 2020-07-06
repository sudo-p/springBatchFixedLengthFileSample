//package com.example.batchprocessing.JobConfigurations;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.example.batchprocessing.ItemReaders.GeneratingTradeItemReader;
//import com.example.batchprocessing.Domain.Trade;
//import com.example.batchprocessing.ItemWriters.RetrySampleItemWriter;
//
//
///**
// * @author Dave Syer
// *
// */
////@Configuration
////@EnableBatchProcessing
//public class RetrySample {
//
//    @Autowired
//    private JobBuilderFactory jobs;
//
//    @Autowired
//    private StepBuilderFactory steps;
//
//    @Bean
//    public Job retrySampleJob() {
//
//        return jobs
//                .get("retrySampleJob")
//                .preventRestart()
//                .start(step())
//                .build();
//    }
//
//    @Bean
//    protected Step step() {
//        return
//                steps
//                        .get("step")
//                        .startLimit(1)
//                        .allowStartIfComplete(false)
//                        .<Trade, Object> chunk(1)
//                        .reader(reader())
//                        .writer(writer())
//                        .faultTolerant()
//                        .retry(Exception.class)
//                        .retryLimit(3).build();
//    }
//
//    @Bean
//    protected ItemReader<Trade> reader() {
//        GeneratingTradeItemReader reader = new GeneratingTradeItemReader();
//        reader.setLimit(10);
//        return reader;
//    }
//
//    @Bean
//    protected ItemWriter<Object> writer() {
//        return new RetrySampleItemWriter<>();
//    }
//}
