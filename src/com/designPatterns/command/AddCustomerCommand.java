package com.designPatterns.command;

import com.designPatterns.command.framework.Command;

public class AddCustomerCommand implements Command {
    private CustomerService service;

    public AddCustomerCommand(CustomerService customerService) {
        this.service = customerService;
    }

    @Override
    public void execute() {
        service.addCustomer();
    }
}
