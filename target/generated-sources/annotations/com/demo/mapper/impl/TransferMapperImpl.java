package com.demo.mapper.impl;

import com.demo.dto.DtoTransfer;
import com.demo.dto.DtoTransfer.DtoTransferBuilder;
import com.demo.entity.Transfer;
import com.demo.entity.Transfer.TransferBuilder;
import com.demo.mapper.TransferMapper;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-11T22:21:10-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class TransferMapperImpl implements TransferMapper {

    @Override
    public Transfer mapToInner(DtoTransfer outer) {
        if ( outer == null ) {
            return null;
        }

        TransferBuilder transfer = Transfer.builder();

        transfer.sentAt( TransferMapper.setTimestamp( outer.getSentAt() ) );
        transfer.fromAccount( outer.getFromAccount() );
        transfer.toAccount( outer.getToAccount() );
        transfer.amount( outer.getAmount() );

        return transfer.build();
    }

    @Override
    public DtoTransfer mapToOuter(Transfer inner) {
        if ( inner == null ) {
            return null;
        }

        DtoTransferBuilder dtoTransfer = DtoTransfer.builder();

        dtoTransfer.sentAt( TransferMapper.setTime( inner.getSentAt() ) );
        dtoTransfer.fromAccount( inner.getFromAccount() );
        dtoTransfer.toAccount( inner.getToAccount() );
        dtoTransfer.amount( inner.getAmount() );

        return dtoTransfer.build();
    }
}
