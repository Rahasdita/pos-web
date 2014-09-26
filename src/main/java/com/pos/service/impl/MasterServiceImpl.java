/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.service.impl;

import com.pos.dao.ItemKategoriDao;
import com.pos.model.ItemKategori;
import com.pos.service.MasterService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author faheem
 */
@Service
@Transactional
public class MasterServiceImpl implements MasterService{
    @Autowired
    ItemKategoriDao itemKategoriDao;

    public void simpan(ItemKategori ik) {
        itemKategoriDao.save(ik);
    }

    public Page<ItemKategori> listAll(Pageable pageable) {
        return itemKategoriDao.findAll(pageable);
    }

    public void delete(ItemKategori ik) {
        itemKategoriDao.delete(ik);
    }
    
}
