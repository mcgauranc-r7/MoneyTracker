package com.wraith.money.repository;

import com.wraith.money.data.Groups;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * User: rowan.massey
 * Date: 24/02/13
 * Time: 16:33
 */
@RestResource(rel = "groups", path = "/groups")
public interface GroupsRepository extends CrudRepository<Groups, Long> {

    public List<Groups> findByName(String groupName);

}