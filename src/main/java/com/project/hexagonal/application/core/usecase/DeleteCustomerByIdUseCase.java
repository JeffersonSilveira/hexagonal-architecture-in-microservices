package com.project.hexagonal.application.core.usecase;

import com.project.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.project.hexagonal.application.ports.out.DeleteCustomerByIdOutpuPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdOutpuPort {


    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final DeleteCustomerByIdOutpuPort deleteCustomerByIdOutpuPort;

    public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, DeleteCustomerByIdOutpuPort deleteCustomerByIdOutpuPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutpuPort = deleteCustomerByIdOutpuPort;
    }

    @Override
    public void delete(String id) {
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutpuPort.delete(id);
    }
}
