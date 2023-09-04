package com.fetch.repository;

import com.fetch.dto.UserLogins;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.GenericRepository;
import io.micronaut.data.repository.PageableRepository;
import jakarta.transaction.Transactional;

@JdbcRepository(dialect = Dialect.POSTGRES)
@Transactional
public interface UserLoginRepository extends PageableRepository<UserLogins, String> {

    @Override
    UserLogins save(UserLogins userLogin);


}
