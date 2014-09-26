/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.controller;

import com.pos.dao.ItemKategoriDao;
import com.pos.model.ItemKategori;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefaults;
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
public class MasterItemKategoriCtrl {
    @Autowired
    ItemKategoriDao itemKategoriDao;
    
    @RequestMapping(value = "/item-kategori", method = RequestMethod.GET)
    @ResponseBody
    public Page<ItemKategori> listAll(
            @RequestParam(required = false) String search, 
            @PageableDefaults(pageNumber = 0, value = 10) Pageable pageable, 
            HttpServletResponse response){
        return itemKategoriDao.findAll(pageable);
    }
    
    @RequestMapping(value = "/item-kategori/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ItemKategori findOne(@PathVariable Integer id, 
            HttpServletResponse response){
        return itemKategoriDao.findOne(id);
    }
    @RequestMapping(value = "/item-kategori/cari-nama/{nama}", method = RequestMethod.GET)
    @ResponseBody
    public ItemKategori findByName(@PathVariable String nama, 
            HttpServletResponse response){
        return itemKategoriDao.findByNama(nama);
    }
    
    
    @RequestMapping(value = "/item-kategori", method = RequestMethod.POST)
    public void save(@RequestBody ItemKategori ik, 
            HttpServletResponse response){
        itemKategoriDao.save(ik);
    }
    
    @RequestMapping(value = "/item-kategori", method = RequestMethod.PUT)
    public void update(@RequestBody ItemKategori ik, 
            HttpServletResponse response){
        itemKategoriDao.save(ik);
    }
    
    
    @RequestMapping(value = "/item-kategori", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id, 
            HttpServletResponse response){
        itemKategoriDao.delete(id);
    }
    
    
    
}
