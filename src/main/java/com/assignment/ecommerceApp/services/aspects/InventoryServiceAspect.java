package com.assignment.ecommerceApp.services.aspects;

import com.assignment.ecommerceApp.services.InventoryService;
import com.assignment.ecommerceApp.utils.TenantContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InventoryServiceAspect {

    @Before("execution(* com.example.service.InventoryService.*(..)) && !execution(* com.example.service.EmployeeService.run(..)) && target(employeeService)")
    public void aroundExecution(JoinPoint pjp, InventoryService inventoryService) throws Throwable {
        org.hibernate.Filter filter = inventoryService.unwrap(Session.class).enableFilter("tenantFilter");
        filter.setParameter("tenant", TenantContext.getCurrentTenant());
        filter.validate();
    }
}
