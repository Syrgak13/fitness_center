package com.fitness_center.service;

import com.fitness_center.dto.SubscriptionDto;

import java.util.List;

public interface SubscriptionServiceImpl {

    List<SubscriptionDto> getAll ();

    SubscriptionDto addSubscription (SubscriptionDto subscriptionDto);

    SubscriptionDto updateSubscription (SubscriptionDto subscriptionDto);

    SubscriptionDto deleteSubscription (Long id);
}
