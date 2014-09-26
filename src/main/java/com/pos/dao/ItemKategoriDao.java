/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.dao;

import com.pos.model.ItemKategori;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author faheem
 */
public interface ItemKategoriDao extends PagingAndSortingRepository<ItemKategori, Integer>{

    public ItemKategori findByNama(String nama);
    
}
