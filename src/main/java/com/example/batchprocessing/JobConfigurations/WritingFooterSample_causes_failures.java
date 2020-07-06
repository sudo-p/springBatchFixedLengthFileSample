//package com.example.batchprocessing.JobConfigurations;
//
//import java.util.Arrays;
//
//import com.example.batchprocessing.ItemWriters.WriterWithFooterCapability;
//import com.example.batchprocessing.Listeners.StepResultListener;
//import com.example.batchprocessing.Listeners.StepSkipListener;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileItemWriter;
//import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
//import org.springframework.batch.item.support.ListItemReader;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//
//@Configuration
//@EnableBatchProcessing
//public class WritingFooterSample_causes_failures {
//
//    private final JobBuilderFactory jobBuilderFactory;
//
//    private final StepBuilderFactory stepBuilderFactory;
//
//    public WritingFooterSample_causes_failures(JobBuilderFactory jobBuilderFactory,
//                                               StepBuilderFactory stepBuilderFactory) {
//        this.jobBuilderFactory = jobBuilderFactory;
//        this.stepBuilderFactory = stepBuilderFactory;
//    }
//
//    //@Value("file:output/output.txt")
//    private Resource outputResource = null;
//
//    @Bean
//    public ItemReader<Integer> itemReader() {
//        return new ListItemReader<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6,7,8,9)) {
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
//    public FlatFileItemWriter<Integer> flatFileItemWriter() {
//        return new FlatFileItemWriterBuilder<Integer>()
//                .name("itemWriter")
//                .resource(outputResource)
//                //.lineAggregator(lineAggregator())
//                .footerCallback(writerWithFooterCapability())
//                .build();
//    }
//
//    @Bean
//    public WriterWithFooterCapability writerWithFooterCapability() {
//        WriterWithFooterCapability writerWithFooterCapability = new WriterWithFooterCapability();
//        writerWithFooterCapability.setDelegate(flatFileItemWriter());
//        return writerWithFooterCapability;
//    }
//
//    @Bean
//    public Step step() {
//        return this.stepBuilderFactory.get("step")
//                .<Integer, Integer>chunk(3)
//                .reader(itemReader())
//                .writer(writerWithFooterCapability())
//                .build();
//    }
//
//    @Bean
//    public Job writingFooterSampleJob() {
//        return this.jobBuilderFactory.get("writingFooterSampleJob")
//                .start(step())
//                .build();
//    }
//
//}
