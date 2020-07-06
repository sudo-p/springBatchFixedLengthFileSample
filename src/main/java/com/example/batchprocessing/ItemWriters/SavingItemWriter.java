//package com.example.batchprocessing.ItemWriters;
//
//import org.springframework.batch.core.StepExecution;
//import org.springframework.batch.core.annotation.BeforeStep;
//import org.springframework.batch.item.ExecutionContext;
//import org.springframework.batch.item.ItemWriter;
//
//import java.util.List;
//
//public class SavingItemWriter implements ItemWriter<Object> {
//    private StepExecution stepExecution;
//
//    public void write(List<? extends Object> items) throws Exception {
//        // ...
//        for (Object item : items) {
//            System.out.println("writing item = " + item);
//        }
//        ExecutionContext stepContext = this.stepExecution.getExecutionContext();
//        stepContext.put("someKey", items);
//    }
//
//    @BeforeStep
//    public void saveStepExecution(StepExecution stepExecution) {
//        this.stepExecution = stepExecution;
//    }
//}
