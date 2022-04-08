package com.zupedu.livraria.metric;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "metrica-customizada", enableByDefault = true)
public class MetricaCustomizada {

    @ReadOperation
    public String say() {
        return "Métrica";
    }

}
