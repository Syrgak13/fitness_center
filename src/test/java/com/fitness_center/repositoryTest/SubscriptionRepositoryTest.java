package com.fitness_center.repositoryTest;



import com.fitness_center.entities.Subscription;
import com.fitness_center.repositories.SubscriptionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class SubscriptionRepositoryTest {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @BeforeEach
    void setUp() {
        // Очистка базы перед каждым тестом
        subscriptionRepository.deleteAll();

        // Создаем тестовые подписки
        Subscription monthlySubscription = Subscription.builder()
                .type("Monthly")
                .price(50.0)
                .startDate("2025-04-01")
                .endDate("2025-04-30")
                .build();

        Subscription yearlySubscription = Subscription.builder()
                .type("Yearly")
                .price(500.0)
                .startDate("2025-01-01")
                .endDate("2025-12-31")
                .build();

        subscriptionRepository.saveAll(List.of(monthlySubscription, yearlySubscription));
    }

    @Test
    @DisplayName("Тест метода findAll()")
    void testFindAll() {
        List<Subscription> subscriptions = subscriptionRepository.findAll();

        // Проверяем, что найдено две подписки
        assertThat(subscriptions).hasSize(2);

        // Проверяем, что подписки содержат правильные типы
        assertThat(subscriptions).extracting(Subscription::getType)
                .containsExactlyInAnyOrder("Monthly", "Yearly");

        // Проверяем цены
        assertThat(subscriptions).extracting(Subscription::getPrice)
                .containsExactlyInAnyOrder(50.0, 500.0);

        // Проверяем даты начала
        assertThat(subscriptions).extracting(Subscription::getStartDate)
                .containsExactlyInAnyOrder("2025-04-01", "2025-01-01");

        // Проверяем даты окончания
        assertThat(subscriptions).extracting(Subscription::getEndDate)
                .containsExactlyInAnyOrder("2025-04-30", "2025-12-31");
    }
}
