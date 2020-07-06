//package com.example.batchprocessing.ItemWriters;
//
//import java.util.List;
//
//import org.springframework.batch.item.ItemWriter;
//
///**
// * Simulates temporary output trouble - requires to retry 3 times to pass
// * successfully.
//**/
//public class RetrySampleItemWriter<T> implements ItemWriter<T> {
//
//    private int counter = 0;
//
//    @Override
//    public void write(List<? extends T> items) throws Exception {
//        int current = counter;
//        counter += items.size();
//        System.out.println("current:" + current);
//        System.out.println("counter:" + counter);
//        if (current < 3 && (counter >= 2 || counter >= 3)) {
//            System.out.println("throwing exception");
//            throw new IllegalStateException("Temporary error");
//        }
//        System.out.println("Writing:"+ items);
//    }
//
//    /**
//     * @return number of times {@link #write(List)} method was called.
//     */
//    public int getCounter() {
//        return counter;
//    }
//
//}
