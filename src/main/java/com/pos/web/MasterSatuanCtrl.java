/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.web;

import com.pos.dao.SatuanDao;
import com.pos.model.Satuan;
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
@RequestMapping("/master")
public class MasterSatuanCtrl {
    @Autowired
    SatuanDao satuanDao;
    private Logger logger=LoggerFactory.getLogger(MasterSatuanCtrl.class);
    
    @RequestMapping(value = "/satuan", method = RequestMethod.GET)
    @ResponseBody
    public Page<Satuan> listAll(
            @RequestParam(required = false) String search, 
            Pageable pageable, 
            HttpServletResponse response){
        PageRequest pr = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), Sort.Direction.ASC, "nama");
        logger.debug("pageNumber [{}], pageSize: [{}]", pageable.getPageNumber(), pageable.getPageSize());
        return satuanDao.findAll(pr);
    }
    
    @RequestMapping(value = "/satuan/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Satuan findOne(@PathVariable Integer id, 
            HttpServletResponse response){
        return satuanDao.findOne(id);
    }
    
    @RequestMapping(value = "/satuan/cek-nama/{nama}", method = RequestMethod.GET)
    @ResponseBody
    public Satuan cekNama(@PathVariable String nama, 
            HttpServletResponse response){
        return satuanDao.findByNama(nama);
    }
    
    @RequestMapping(value = "/satuan/all", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Satuan> findAll(HttpServletResponse response){
        return satuanDao.findAll();
    }
    
    @RequestMapping(value = "/satuan/{nama}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Satuan> findByName(@PathVariable String nama, 
            Pageable pageable, 
            HttpServletResponse response){
        return satuanDao.filter("%"+nama+"%", pageable);
    }
    
    @RequestMapping(value = "/satuan", method = RequestMethod.POST)
    public void save(@RequestBody Satuan ik, 
            HttpServletResponse response){
        satuanDao.save(ik);
    }
    
    @RequestMapping(value = "/satuan", method = RequestMethod.PUT)
    public void update(@RequestBody Satuan ik, 
            HttpServletResponse response){
        satuanDao.save(ik);
    }
    
    
    @RequestMapping(value = "/satuan/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id, 
            HttpServletResponse response){
        satuanDao.delete(id);
    }
    
    
    
}
