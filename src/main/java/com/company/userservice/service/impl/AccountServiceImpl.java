package com.company.userservice.service.impl;

import com.company.userservice.model.dto.request.AccountRequestDto;
import com.company.userservice.model.dto.request.SignUpRequestDto;
import com.company.userservice.model.entity.Account;
import com.company.userservice.model.entity.Role;
import com.company.userservice.model.enums.Roles;
import com.company.userservice.model.mapper.AccountMapper;
import com.company.userservice.repository.AccountRepository;
import com.company.userservice.service.AccountService;
import com.company.userservice.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final RoleService roleService;
    private final AccountMapper accountMapper;

    @Override
    public Account add(SignUpRequestDto signUpRequestDto) {
        Role role = roleService.findByRoleName(Roles.USER);
        if (!accountRepository.existsByUsername(signUpRequestDto.getUsername())) {
            Account account = accountMapper.signUpRequestDTOtoAccount(signUpRequestDto);
            return accountRepository.save(account);
        }
        throw new RuntimeException("Account not saved");
    }

    @Override
    public void addRole(String id, String roleName) {
        Roles eRole = Roles.USER;
        if (roleName.equalsIgnoreCase("ADMIN"))
            eRole = Roles.ADMIN;
        Role role = roleService.findByRoleName(eRole);
        if (!accountRepository.existsByRoles(role)){
            Account account = accountRepository.findById(id).get();
            account.getRoles().add(role);
            accountRepository.save(account);
        }
    }

    @Override
    public void deleteRole(String id, String roleName) {
        Roles eRole = Roles.ADMIN;
        if (roleName.equalsIgnoreCase("USER"))
            eRole = Roles.USER;
        Role role = roleService.findByRoleName(eRole);
        if (accountRepository.existsByRoles(role)){
            Account account = accountRepository.findById(id).get();
            account.getRoles().remove(role);
            accountRepository.save(account);
        }
    }

    @Override
    public Account update(String id, AccountRequestDto accountRequestDto) {
        Account account = accountRepository.findById(id).get();
        if (accountRequestDto.getUsername() != null && accountRequestDto.getUsername() != account.getUsername())
            account.setUsername(accountRequestDto.getUsername());
        if (accountRequestDto.getPassword() != null)
            account.setPassword(accountRequestDto.getPassword());
        return accountRepository.save(account);
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public Account getByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public List<Account> getByRoleName(String role) {
        if (role.equalsIgnoreCase("USER"))
            return accountRepository.findAccountsByRoles(new Role(1L, Roles.USER));
        else if (role.equalsIgnoreCase("ADMIN"))
            return accountRepository.findAccountsByRoles(new Role(2L, Roles.ADMIN));
        else return null;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }


}