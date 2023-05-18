package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.service.dto.AccountDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-17T10:42:22+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDto toDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        accountDto.setId( account.getId() );
        accountDto.setUserName( account.getUserName() );
        accountDto.setUserPassword( account.getUserPassword() );
        accountDto.setTotalBalance( account.getTotalBalance() );

        return accountDto;
    }

    @Override
    public List<AccountDto> toDtos(List<Account> accounts) {
        if ( accounts == null ) {
            return null;
        }

        List<AccountDto> list = new ArrayList<AccountDto>( accounts.size() );
        for ( Account account : accounts ) {
            list.add( toDto( account ) );
        }

        return list;
    }

    @Override
    public Account toEntity(AccountDto accountDto) {
        if ( accountDto == null ) {
            return null;
        }

        Account.AccountBuilder account = Account.builder();

        account.id( accountDto.getId() );
        account.userName( accountDto.getUserName() );
        account.userPassword( accountDto.getUserPassword() );
        account.totalBalance( accountDto.getTotalBalance() );

        return account.build();
    }

    @Override
    public List<Account> toEntities(List<AccountDto> accountDtos) {
        if ( accountDtos == null ) {
            return null;
        }

        List<Account> list = new ArrayList<Account>( accountDtos.size() );
        for ( AccountDto accountDto : accountDtos ) {
            list.add( toEntity( accountDto ) );
        }

        return list;
    }
}
