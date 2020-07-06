//package com.example.batchprocessing.JobConfigurations;
//
//import com.example.batchprocessing.ItemReaders.FilesInDirectoryItemReader;
//import com.example.batchprocessing.ItemWriters.DummyItemWriter;
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
//import com.example.batchprocessing.ItemWriters.RetrySampleItemWriter;
//
//import java.io.File;
//
//
////@Configuration
////@EnableBatchProcessing
//public class RestartSample {
//
//    @Autowired
//    private JobBuilderFactory jobs;
//
//    @Autowired
//    private StepBuilderFactory steps;
//
//    @Bean
//    public Job restartSampleJob() {
//
//        return jobs
//                .get("restartSampleJob")
//                .start(step())
//                .build();
//    }
//
//    @Bean
//    protected Step step() {
//        return
//                steps
//                        .get("step")
//                        .<File, File> chunk(1)
//                        .reader(reader())
//                        .writer(writer())
//                        .build();
//    }
//
//    @Bean
//    protected ItemReader<File> reader() {
//        FilesInDirectoryItemReader reader = new FilesInDirectoryItemReader();
//        reader.setDirectory("C:\\development\\LocalLabs\\CSS\\Flexbox-1");
//        return reader;
//    }
//
//    @Bean
//    protected ItemWriter<Object> writer() {
//        return new DummyItemWriter();
//    }
//}
//
