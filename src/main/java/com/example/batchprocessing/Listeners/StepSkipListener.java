package com.example.batchprocessing.Listeners;

import org.springframework.batch.core.SkipListener;

public class StepSkipListener implements SkipListener<Integer,Integer> {

    @Override
    public void onSkipInRead(Throwable t) {
        System.out.println("StepSkipListener - onSkipInRead");
    }

    @Override
    public void onSkipInWrite(Integer item, Throwable t) {

        System.out.println("StepSkipListener - afterWrite");
        System.out.println("skipping item: " + item);
    }

    @Override
    public void onSkipInProcess(Integer item, Throwable t) {
        System.out.println("StepSkipListener - onWriteError");
    }
}