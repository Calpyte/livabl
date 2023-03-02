package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.MobileDAO;
import com.calpyte.livabl.domain.MobileCombustion;
import com.calpyte.livabl.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MobileDAOImpl implements MobileDAO {

    @Autowired
    private MobileRepository mobileRepository;

    @Override
    public MobileCombustion save(MobileCombustion mobileCombustion) {
        return mobileRepository.save(mobileCombustion);
    }

    @Override
    public Optional<MobileCombustion> findById(String id) {
        return mobileRepository.findById(id);
    }

    @Override
    public List<MobileCombustion> findAll() {
        return mobileRepository.findAll();
    }

    @Override
    public List<MobileCombustion> findByUser(String email) {
        return mobileRepository.findAllByEmail(email);
    }

    @Override
    public List<MobileCombustion> saveAll(List<MobileCombustion> mobileCombustions) {
        return mobileRepository.saveAll(mobileCombustions);
    }
}
