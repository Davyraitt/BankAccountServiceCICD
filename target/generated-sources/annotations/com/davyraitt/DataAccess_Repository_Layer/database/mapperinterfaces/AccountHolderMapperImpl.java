package com.davyraitt.DataAccess_Repository_Layer.database.mapperinterfaces;

import com.davyraitt.DataAccess_Repository_Layer.database.entitys.AccountHolder;
import com.davyraitt.Presentatie_Controller_Layer.dto.AccountHolderDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-26T14:02:53+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class AccountHolderMapperImpl implements AccountHolderMapper {

    @Override
    public AccountHolderDTO accountHolderToDTO(AccountHolder accountHolder) {
        if ( accountHolder == null ) {
            return null;
        }

        AccountHolderDTO accountHolderDTO = new AccountHolderDTO();

        accountHolderDTO.setName( accountHolder.getName() );
        accountHolderDTO.setBsn( accountHolder.getBsn() );

        return accountHolderDTO;
    }

    @Override
    public AccountHolder dtoToEntity(AccountHolderDTO accountHolderDTO) {
        if ( accountHolderDTO == null ) {
            return null;
        }

        AccountHolder accountHolder = new AccountHolder();

        accountHolder.setName( accountHolderDTO.getName() );
        accountHolder.setBsn( accountHolderDTO.getBsn() );

        return accountHolder;
    }

    @Override
    public List<AccountHolderDTO> arrayListAccountHolderToDTO(List<AccountHolder> list) {
        if ( list == null ) {
            return null;
        }

        List<AccountHolderDTO> list1 = new ArrayList<AccountHolderDTO>( list.size() );
        for ( AccountHolder accountHolder : list ) {
            list1.add( accountHolderToDTO( accountHolder ) );
        }

        return list1;
    }
}
