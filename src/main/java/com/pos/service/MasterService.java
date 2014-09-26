/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.service;

import com.pos.model.ItemKategori;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author faheem
 */
public interface MasterService {
    public void simpan(ItemKategori ik);
    public Page<ItemKategori> listAll(Pageable pageable);
    public void delete(ItemKategori ik);
    
    
}
