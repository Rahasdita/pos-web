/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.dao;

import com.pos.model.Item;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author faheem
 */
public interface ItemDao extends PagingAndSortingRepository<Item, String>{
    @Query("from Item i where upper(i.nama) like upper(:search) ")
    public Page<Item> filter(@Param("search") String search, Pageable pageable);
    
    @Query("from Item i where upper(i.nama) like upper(:search) ")
    public List<Item> filterAll(String string);
    
    public Item findByNama(String nama);
    
    
}
