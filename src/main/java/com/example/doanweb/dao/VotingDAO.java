package com.example.doanweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import com.example.doanweb.entity.Voting;
import com.example.doanweb.entity.Voucherdetail;

public interface VotingDAO extends JpaRepository<Voting, Integer>{

    @Query(value = "SELECT v FROM Voting v where v.id=?1")
            Voting selectVotingById(Integer id);
}
