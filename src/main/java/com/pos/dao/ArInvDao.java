/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.dao;

import com.pos.model.ArInv;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author faheem
 */
public interface ArInvDao extends PagingAndSortingRepository<ArInv, String>{
    
}
