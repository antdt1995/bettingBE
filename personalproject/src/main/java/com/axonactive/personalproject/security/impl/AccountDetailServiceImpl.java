package com.axonactive.personalproject.security.impl;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountDetailServiceImpl implements UserDetailsService {
    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Account account=accountRepository.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with userName: " + userName));
        return AccountDetailImpl.build(account);
    }
    @Transactional
    public UserDetails validateUser(String userName){
        Account account=accountRepository.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userName));
        return AccountDetailImpl.build(account);
    }

}
