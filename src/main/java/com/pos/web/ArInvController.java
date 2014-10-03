/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.web;

import com.pos.dao.ArInvDao;
import com.pos.model.ArInv;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author faheem
 */
@Controller
@RequestMapping("/transaksi")
public class ArInvController {
    @Autowired
    ArInvDao dao;
    
    private Logger logger=LoggerFactory.getLogger(ArInvController.class);
    
    @RequestMapping(value = "/ar-inv", method = RequestMethod.GET)
    @ResponseBody
    public Page<ArInv> listAll(
            @RequestParam(required = false) String search, 
            Pageable pageable, 
            HttpServletResponse response){
        PageRequest pr = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), Sort.Direction.ASC, "nama");
        logger.debug("pageNumber [{}], pageSize: [{}]", pageable.getPageNumber(), pageable.getPageSize());
        return dao.findAll(pr);
    }
    
    @RequestMapping(value = "/ar-inv/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ArInv findOne(@PathVariable String id, 
            HttpServletResponse response){
        return dao.findOne(id);
    }
//    @RequestMapping(value = "/ar-inv/{nama}", method = RequestMethod.GET)
//    @ResponseBody
//    public Page<ArInv> findByName(@PathVariable String nama, 
//            Pageable pageable, 
//            HttpServletResponse response){
//        return itemKategoriDao.filter("%"+nama+"%", pageable);
//    }
    
    
    @RequestMapping(value = "/ar-inv", method = RequestMethod.POST)
    public void save(@RequestBody ArInv ik, 
            HttpServletResponse response){
        dao.save(ik);
    }
    
    @RequestMapping(value = "/ar-inv", method = RequestMethod.PUT)
    public void update(@RequestBody ArInv x, 
            HttpServletResponse response){
        dao.save(x);
    }
    
    
    @RequestMapping(value = "/ar-inv/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id, 
            HttpServletResponse response){
        dao.delete(id);
    }
}
