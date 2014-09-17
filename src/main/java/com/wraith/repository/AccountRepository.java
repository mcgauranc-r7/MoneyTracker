package com.wraith.repository;

import com.wraith.repository.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * User: rowan.massey
 * Date: 24/01/13
 * Time: 21:56
 */
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    public List<Account> findByName(String accountName);

}
