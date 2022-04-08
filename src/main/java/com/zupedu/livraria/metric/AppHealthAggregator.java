package com.zupedu.livraria.metric;

import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.actuate.health.StatusAggregator;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AppHealthAggregator implements StatusAggregator {
    @Override
    public Status getAggregateStatus(Set<Status> statuses) {
        boolean statusUp = statuses.stream().allMatch(s -> s.equals(Status.UP));

        return statusUp ? Status.UP : Status.DOWN;
    }
}
