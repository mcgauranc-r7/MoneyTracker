package com.wraith.money.repository;

import com.wraith.money.data.Users;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * User: rowan.massey
 * Date: 24/01/13
 * Time: 22:01
 */
@RestResource(rel = "users", path = "/users")
public interface UsersRepository extends PagingAndSortingRepository<Users, Long> {

    @RestResource
    public List<Users> findByUserName(@Param("userName") String username);

    public List<Users> findAll();
}
