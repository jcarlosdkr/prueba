package com.demo.mapper.impl;

import com.demo.dto.DtoAccount;
import com.demo.dto.DtoAccount.DtoAccountBuilder;
import com.demo.entity.Account;
import com.demo.entity.Account.AccountBuilder;
import com.demo.mapper.AccountMapper;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-11T22:21:11-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account mapToInner(DtoAccount outer) {
        if ( outer == null ) {
            return null;
        }

        AccountBuilder account = Account.builder();

        account.createdAt( AccountMapper.setTimestamp( outer.getCreatedAt() ) );
        account.account( outer.getAccount() );
        account.balance( outer.getBalance() );
        account.owner( outer.getOwner() );

        return account.build();
    }

    @Override
    public DtoAccount mapToOuter(Account inner) {
        if ( inner == null ) {
            return null;
        }

        DtoAccountBuilder dtoAccount = DtoAccount.builder();

        dtoAccount.createdAt( AccountMapper.setTime( inner.getCreatedAt() ) );
        dtoAccount.account( inner.getAccount() );
        dtoAccount.balance( inner.getBalance() );
        dtoAccount.owner( inner.getOwner() );

        return dtoAccount.build();
    }
}
