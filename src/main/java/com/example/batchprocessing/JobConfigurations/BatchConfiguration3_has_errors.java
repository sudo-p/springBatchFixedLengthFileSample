//package com.example.batchprocessing.JobConfigurations;
//
//import com.example.batchprocessing.JobExceptions.MissingUsernameException;
//import com.example.batchprocessing.JobExceptions.NegativeAmountException;
//import com.example.batchprocessing.ItemProcessors.SkippingItemProcessor;
//import com.example.batchprocessing.Domain.Transaction;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.xml.StaxEventItemWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.oxm.Marshaller;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//
//import java.text.ParseException;
//
////@Configuration
////@EnableBatchProcessing
//public class BatchConfiguration3_has_errors {
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Value("input/recordWithInvalidData.csv")
//    private Resource invalidInputCsv;
//
//    @Value("file:xml/output.xml")
//    private Resource outputXml;
//
////    public ItemReader<Transaction> skippingItemReader(Resource inputData) throws UnexpectedInputException, ParseException {
////        FlatFileItemReader<Transaction> reader = new FlatFileItemReader<>();
////        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
////        String[] tokens = {"username", "userid", "transactiondate", "amount"};
////        tokenizer.setNames(tokens);
////        reader.setResource(inputData);
////        DefaultLineMapper<Transaction> lineMapper = new DefaultLineMapper<>();
////        lineMapper.setLineTokenizer(tokenizer);
////        lineMapper.setFieldSetMapper(new RecordFieldSetMapper());
////        reader.setLinesToSkip(1);
////        reader.setLineMapper(lineMapper);
////        return reader;
////    }
//
//    @Bean
//    public FlatFileItemReader<Transaction> skippingItemReader() {
//        return new FlatFileItemReaderBuilder<Transaction>()
//                .name("skippingItemReader")
//                .resource(new ClassPathResource("input/recordWithInvalidData.csv"))
//                .delimited()
//                .names(new String[]{"username", "userid", "transactiondate", "amount"})
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<Transaction>() {{       //TODO
//                    setTargetType(Transaction.class);
//                }})
//                .build();
//    }
//
//    @Bean(name = "skippingBatchJob")
//    public Job skippingBatchJob(@Qualifier("skippingStep") Step skippingStep) {
//        return jobBuilderFactory
//                .get("skippingBatchJob")
//                .start(skippingStep)
//                .build();
//    }
//
//    @Bean
//    public Step skippingStep(
//            @Qualifier("skippingItemProcessor") ItemProcessor<Transaction,Transaction> processor,
//            @Qualifier("skippingItemWriter") ItemWriter<Transaction> writer)throws ParseException {
//        return stepBuilderFactory
//                .get("skippingStep")
//                .<Transaction, Transaction>chunk(10)
//                //.reader(skippingItemReader(invalidInputCsv))
//                .reader(skippingItemReader())
//                .processor(processor)
//                .writer(writer)
//                .faultTolerant()
//                .skipLimit(10)
//                .skip(MissingUsernameException.class)
//                .skip(NegativeAmountException.class)
//                .build();
//    }
//
//
//    @Bean
//    public ItemWriter<Transaction> skippingItemWriter(Marshaller marshaller) {
//        StaxEventItemWriter<Transaction> itemWriter = new StaxEventItemWriter<>();
//        itemWriter.setMarshaller(marshaller);
//        itemWriter.setRootTagName("transactionRecord");
//        itemWriter.setResource(outputXml);
//        return itemWriter;
//    }
//
//    @Bean
//    public Marshaller marshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setClassesToBeBound(Transaction.class);
//        return marshaller;
//    }
//
//    @Bean
//    public SkippingItemProcessor skippingItemProcessor() {
//        return new SkippingItemProcessor();
//    }
//
//}
