package com.wraith.repository;

import com.wraith.repository.entity.Payee;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * User: rowan.massey
 * Date: 24/02/13
 * Time: 13:28
 */
public interface PayeeRepository extends PagingAndSortingRepository<Payee, Long> {

    public List<Payee> findByName(String payeeName);

}
