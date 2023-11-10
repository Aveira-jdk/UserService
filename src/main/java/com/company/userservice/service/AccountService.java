package com.company.userservice.service;

import com.company.userservice.model.dto.request.AccountRequestDto;
import com.company.userservice.model.dto.request.SignUpRequestDto;
import com.company.userservice.model.entity.Account;

import java.util.List;

public interface AccountService {

    Account add(SignUpRequestDto signUpRequestDto);

    void addRole(String id, String roleName);

    void deleteRole(String id, String roleName);

    Account update(String id, AccountRequestDto accountRequestDto);

    void delete(Account account);

    Account getByUsername(String username);

    List<Account> getByRoleName(String role);

    List<Account> getAllAccounts();
}