//package com.example.batchprocessing.JobConfigurations;
//
//import com.example.batchprocessing.ItemWriters.DummyItemWriter;
//import com.example.batchprocessing.ItemWriters.SavingItemWriter;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.annotation.BeforeStep;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.listener.ExecutionContextPromotionListener;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.support.ListItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
//import java.util.Arrays;
//
//@Configuration
//@EnableBatchProcessing
//public class PassingDataToFutureStepsSample {
//
//    @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public ItemReader<Integer> itemReader() {
//        return new ListItemReader<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)) {
//            @Override
//            public Integer read() {
//                Integer item = super.read();
//                System.out.println("reading item = " + item);
//                return item;
//            }
//        };
//    }
//
//    @Bean
//    public ItemWriter<Object> savingItemWriter() {return new SavingItemWriter();}
//
//    @Bean
//    public ExecutionContextPromotionListener promotionListener() {
//        ExecutionContextPromotionListener listener = new ExecutionContextPromotionListener();
//
//        listener.setKeys(new String[] {"someKey" });
//
//        return listener;
//    }
//
//    @Bean
//    public Step step1() {
//        return this.stepBuilderFactory.get("step1")
//                .<Integer, Integer>chunk(3)
//                .reader(itemReader())
//                .writer(savingItemWriter())      //TODO - it gets a hold of StepExecution via @BeforeStep and stores someKey in StepExecutionContext
//                .listener(promotionListener())  //TODO - it promotes StepExecutioinContext to JobExecutionContext at the end of this step
//                .build();
//    }
//
//    @Bean
//    public Step step2() {
//        return this.stepBuilderFactory.get("step2")
//                .<Integer, Integer>chunk(3)
//                .reader(itemReader())
//                .writer(new DummyItemWriter())
//                .build();
//    }
//
//    @Bean
//    public Job passingDataToFutureStepsSampleJob() {
//        return this.jobBuilderFactory.get("passingDataToFutureStepsSampleJob")
//                .start(step1())
//                .next(step2())
//                .build();
//    }
//
//}
//
//
//
//
