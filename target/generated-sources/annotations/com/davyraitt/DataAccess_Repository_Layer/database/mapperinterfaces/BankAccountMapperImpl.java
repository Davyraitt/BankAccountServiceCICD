package com.davyraitt.DataAccess_Repository_Layer.database.mapperinterfaces;

import com.davyraitt.DataAccess_Repository_Layer.database.entitys.BankAccount;
import com.davyraitt.Presentatie_Controller_Layer.dto.BankAccountDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-21T12:04:11+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class BankAccountMapperImpl implements BankAccountMapper {

    @Override
    public BankAccountDTO bankAccountEntityToDTO(BankAccount account) {
        if ( account == null ) {
            return null;
        }

        BankAccountDTO bankAccountDTO = new BankAccountDTO();

        bankAccountDTO.setIBAN( account.getIBAN() );
        bankAccountDTO.setBalance( account.getBalance() );
        bankAccountDTO.setActive( account.isActive() );

        return bankAccountDTO;
    }

    @Override
    public BankAccount bankAccountDTOToEntity(BankAccountDTO account) {
        if ( account == null ) {
            return null;
        }

        BankAccount bankAccount = new BankAccount();

        bankAccount.setIBAN( account.getIBAN() );
        bankAccount.setBalance( account.getBalance() );
        bankAccount.setActive( account.isActive() );

        return bankAccount;
    }

    @Override
    public List<BankAccount> arrayListDTOTOEntity(List<BankAccountDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<BankAccount> list1 = new ArrayList<BankAccount>( list.size() );
        for ( BankAccountDTO bankAccountDTO : list ) {
            list1.add( bankAccountDTOToEntity( bankAccountDTO ) );
        }

        return list1;
    }

    @Override
    public List<BankAccountDTO> arrayListEntityTODTO(List<BankAccount> list) {
        if ( list == null ) {
            return null;
        }

        List<BankAccountDTO> list1 = new ArrayList<BankAccountDTO>( list.size() );
        for ( BankAccount bankAccount : list ) {
            list1.add( bankAccountEntityToDTO( bankAccount ) );
        }

        return list1;
    }
}
