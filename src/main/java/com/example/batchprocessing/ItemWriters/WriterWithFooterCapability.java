//package com.example.batchprocessing.ItemWriters;
//
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileFooterCallback;
//
//import java.io.IOException;
//import java.io.Writer;
//import java.math.BigDecimal;
//import java.util.List;
//
//public class WriterWithFooterCapability implements ItemWriter<Integer>,
//        FlatFileFooterCallback {
//
//    private ItemWriter<Integer> delegate;
//
//    private BigDecimal totalAmount = BigDecimal.ZERO;
//
//    @Override
//    public void write(List<? extends Integer> items) throws Exception {
//        BigDecimal chunkTotal = BigDecimal.ZERO;
//        for (Integer item : items) {
//            chunkTotal = chunkTotal.add(BigDecimal.valueOf(item));
//            System.out.println("chunkTotal: " + chunkTotal);
//        }
//
//        delegate.write(items);
//
//        // After successfully writing all items
//        totalAmount = totalAmount.add(chunkTotal);
//    }
//
//    @Override
//    public void writeFooter(Writer writer) throws IOException {
//        writer.write("Total Amount Processed: " + totalAmount);
//    }
//
//    public void setDelegate(ItemWriter delegate) {
//        this.delegate = delegate;
//    }
//
//}
