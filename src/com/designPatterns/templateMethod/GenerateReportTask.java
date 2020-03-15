package com.designPatterns.templateMethod;

public class GenerateReportTask extends Task{
    @Override
    protected void doExecute() {
        System.out.println("Generating report");
    }
}
