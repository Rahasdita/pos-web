'use strict';

angular.module('posApp')
  .factory('ItemKategoriService', function ($http, $resource) {
    var url='master/item-kategori';
    return {
        itemKategori: $resource(url+'/:id', {}, {
                queryPage: {method:'GET', isArray: false}
            }),
        get: function(param, callback){ return this.itemKategori.get(param, callback) }, 
        query: function(p, callback){ return this.itemKategori.queryPage({"page.page": p, "page.size": 10}, callback) },
        save: function(obj){
            if(obj.id ===null){
                return $http.post(url, obj);
            }else{
                return $http.put(url, obj);
            }
        },
        remove: function(obj){
            if(obj.id !=null){
                return $http.delete(obj.id);
            }
        },
        findByNama: function(value){
            return $http.get(url+'/cari-nama/'+value);
        }
    }
  });
