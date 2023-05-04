package com.example.demo.repository;

import com.example.demo.model.InternalAppeal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@DataJpaTest
@Sql(scripts = {
        "classpath:fixture/internal_event_insert.sql",
        "classpath:fixture/internal_appeal_insert.sql"
})
@Sql(executionPhase = AFTER_TEST_METHOD, scripts = {
        "classpath:fixture/internal_event_truncate.sql",
        "classpath:fixture/internal_appeal_truncate.sql"
})
class InternalAppealRepositoryTest {

    @Autowired
    InternalAppealRepository repository;

    @Test
    void findAll() {
        final List<InternalAppeal> page = repository.findAll();
        Assertions.assertEquals(10, page.size());
    }

    @Test
    void findAllPaged() {
        final Page<InternalAppeal> page = repository.findAll(Pageable.ofSize(20));
        Assertions.assertEquals(10, page.getTotalElements());
        page.forEach(internalAppeal -> {
            Assertions.assertNotNull(internalAppeal.getId());
            Assertions.assertNotNull(internalAppeal.getEvent());
            Assertions.assertNotNull(internalAppeal.getEvent().getTitle());
        });
    }

}
