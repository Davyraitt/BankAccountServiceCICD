package com.davyraitt.DataAccess_Repository_Layer.database.repository;

import com.davyraitt.DataAccess_Repository_Layer.database.entitys.AccountHolder;
import com.davyraitt.DataAccess_Repository_Layer.database.entitys.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, UUID> {
    Optional<AccountHolder> findByBsn(String bsn);
    @Query("select a from AccountHolder h left join h.bankAccountsOfThisHolder a where h.bsn = ?1")
    List<AccountHolder> findAllByHolderBsn(String bsn);


}
