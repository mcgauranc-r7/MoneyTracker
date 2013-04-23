package com.wraith.repository.handler;

import com.wraith.repository.entity.AccountType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.repository.annotation.HandleBeforeCreate;
import org.springframework.data.rest.repository.annotation.HandleBeforeDelete;
import org.springframework.data.rest.repository.annotation.HandleBeforeSave;
import org.springframework.data.rest.repository.annotation.RepositoryEventHandler;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * User: rowan.massey
 * Date: 23/04/13
 * Time: 19:06
 */
@RepositoryEventHandler(AccountType.class)
public class AccountTypeEventHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @HandleBeforeCreate
    public void beforeAccountTypeCreate(AccountType accountType) {
        logger.debug(String.format("In before create for account '%s'", accountType.getName()));
    }

    @PreAuthorize("isAuthenticated() and (hasRole('ROLE_ADMIN'))")
    @HandleBeforeSave
    public void beforeAccountTypeUpdate(AccountType accountType) {
        logger.debug(String.format("In before update for account '%s'", accountType.getName()));
        //Don't need to add anything to this method, the @PreAuthorize does the job.
    }

    @PreAuthorize("isAuthenticated() and (hasRole('ROLE_ADMIN'))")
    @HandleBeforeDelete
    public void beforeAccountTypeDelete(AccountType accountType) {
        logger.debug(String.format("In before delete for account '%s'", accountType.getName()));
        //Don't need to add anything to this method, the @PreAuthorize does the job.
    }
}
