package com.davyraitt.DataAccess_Repository_Layer.database.mapperinterfaces;

import com.davyraitt.DataAccess_Repository_Layer.database.entitys.AccountHolder;
import com.davyraitt.Presentatie_Controller_Layer.dto.AccountHolderDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

//@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE, injectionStrategy = CONSTRUCTOR)
@Mapper(componentModel = "spring", uses ={AccountHolderMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)

public interface AccountHolderMapper {

//    @Mapping(target = "NEGEERDITATTRIBUUT", ignore = true) << VOORBEELD VAN JE HOE JE EEN ATTRIBUUT NEGEERT
//    @Mapping(target = "naaminhetengels", source="name") << VOORBEELD VAN JE HOE JE EEN ATTRIBUUT TOEWIJST
    AccountHolderDTO accountHolderToDTO(AccountHolder accountHolder);

    AccountHolder dtoToEntity(AccountHolderDTO accountHolderDTO);

    List<AccountHolderDTO> arrayListAccountHolderToDTO( List<AccountHolder> list);

}
