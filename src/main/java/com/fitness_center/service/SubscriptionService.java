package com.fitness_center.service;

import com.fitness_center.dto.SubscriptionDto;
import com.fitness_center.entities.Subscription;
import com.fitness_center.mapper.SubscriptionMapper;
import com.fitness_center.repositories.SubscriptionRepository;
import com.fitness_center.service.SubscriptionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubscriptionService implements SubscriptionServiceImpl {

    private final SubscriptionRepository repository;
    private final SubscriptionMapper mapper;

    @Override
    public List<SubscriptionDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SubscriptionDto addSubscription(SubscriptionDto dto) {
        Subscription entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public SubscriptionDto updateSubscription(SubscriptionDto dto) {
        Subscription subscription = repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Subscription not found"));

        subscription.setType(dto.getType());
        subscription.setPrice(dto.getPrice());
        subscription.setStartDate(dto.getStartDate());
        subscription.setEndDate(dto.getEndDate());

        return mapper.toDto(repository.save(subscription));
    }

    @Override
    public SubscriptionDto deleteSubscription(Long id) {
        Subscription subscription = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
        repository.delete(subscription);
        return mapper.toDto(subscription);
    }
}
