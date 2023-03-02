package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.CapitalGoodsDAO;
import com.calpyte.livabl.domain.CapitalGoods;
import com.calpyte.livabl.repository.CapitalGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CapitalGoodsDAOImpl implements CapitalGoodsDAO {

    @Autowired
    private CapitalGoodsRepository capitalGoodsRepository;

    @Override
    public CapitalGoods save(CapitalGoods capitalGoods) { return capitalGoodsRepository.save(capitalGoods);}

    @Override
    public List<CapitalGoods> saveAll(List<CapitalGoods> capitalGoods) {
        return capitalGoodsRepository.saveAll(capitalGoods);
    }

    @Override
    public List<CapitalGoods> findAll() {
        return capitalGoodsRepository.findAll();
    }

    @Override
    public List<CapitalGoods> findByUser(String email) {
        return capitalGoodsRepository.findAllByEmail(email);
    }

    @Override
    public Optional<CapitalGoods> findById(String id) {
        return capitalGoodsRepository.findById(id);
    }

}
