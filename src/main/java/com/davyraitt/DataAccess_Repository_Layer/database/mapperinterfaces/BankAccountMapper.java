package com.davyraitt.DataAccess_Repository_Layer.database.mapperinterfaces;

import com.davyraitt.DataAccess_Repository_Layer.database.entitys.AccountHolder;
import com.davyraitt.DataAccess_Repository_Layer.database.entitys.BankAccount;
import com.davyraitt.Presentatie_Controller_Layer.dto.AccountHolderDTO;
import com.davyraitt.Presentatie_Controller_Layer.dto.BankAccountDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses ={BankAccountMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BankAccountMapper {

    //    @Mapping(target = "NEGEERDITATTRIBUUT", ignore = true) << VOORBEELD VAN JE HOE JE EEN ATTRIBUUT NEGEERT
    //    @Mapping(target = "naaminhetengels", source="name") << VOORBEELD VAN JE HOE JE EEN ATTRIBUUT TOEWIJST
    BankAccountDTO bankAccountEntityToDTO(BankAccount account);

    BankAccount bankAccountDTOToEntity(BankAccountDTO account);

    List<BankAccount> arrayListDTOTOEntity(List<BankAccountDTO> list);

    List<BankAccountDTO> arrayListEntityTODTO(List<BankAccount> list);


}
