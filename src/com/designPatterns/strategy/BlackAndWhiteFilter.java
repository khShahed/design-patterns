package com.designPatterns.strategy;

public class BlackAndWhiteFilter implements Filter {
    @Override
    public void apply(String fileNam) {
        System.out.println("Applying black and white filter");
    }
}
