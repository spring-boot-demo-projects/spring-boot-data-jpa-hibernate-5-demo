package com.example.demo.repository;

import com.example.demo.model.InternalEvent;
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
class InternalEventRepositoryTest {

    @Autowired
    InternalEventRepository repository;

    @Test
    void findAll() {
        final List<InternalEvent> all = repository.findAll();
        Assertions.assertEquals(10, all.size());
    }

    @Test
    void findAllPaged() {
        final Page<InternalEvent> page = repository.findAll(Pageable.ofSize(20));
        Assertions.assertEquals(10, page.getTotalElements());
        page.forEach(internalAppeal -> {
            Assertions.assertNotNull(internalAppeal.getId());
//            Assertions.assertNotNull(internalAppeal.getAppeal());
//            Assertions.assertNotNull(internalAppeal.getAppeal().getEvent().getId());
        });
    }

}
