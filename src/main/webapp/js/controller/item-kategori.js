'use strict';

/**
 * @ngdoc function
 * @name belajarYeomanApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the belajarYeomanApp
 */
angular.module('posApp')
        .controller('ItemKategoriCtrl', function($scope, ItemKategoriService) {
            $scope.search = "";
            $scope.oldSearch = "";
            $scope.paging = {
                currentPage: 1,
                totalItems: 0
            };
            $scope.reloadData = function() {
                $scope.dataPage = ItemKategoriService.query($scope.search, $scope.currentPage, function() {
                    $scope.rateCards = data.content;
                    $scope.paging.maxSize = (data.size);
                    $scope.paging.totalItems = data.totalElements;
                    $scope.paging.currentPage = parseInt(data.number) + 1;
                    $scope.paging.maxPage = data.totalPages;
//                        if ($scope.dataPage.totalElements !== $scope.totalItems) {
//                            $scope.totalItems = $scope.dataPage.totalElements;
//                        }
                    });
                    
            };

            $scope.reloadData();

            $scope.edit = function(x) {
                $scope.formTitle="Edit Item Kategori";
                if (x.id) {
                    $scope.currentRecord=ItemKategoriService.get({id: x.id}, function(){
                        $scope.original = angular.copy($scope.currentRecord);
                        console.log('Edit', $scope.currentRecord);
                        $('#formModal').modal('show');
                    });
                }
            };

            $scope.isClean = function() {
                return angular.equals($scope.original, $scope.currentRecord);
            };

            $scope.clear = function() {
                $scope.formTitle="Tambah Item Kategori";
                $scope.currentRecord = null;
                $scope.original = null;
                $scope.isNameExists = false;

                $scope.reloadData();
                
            };

            
            $scope.delete = function(x) {
                bootbox.confirm('Anda yakin untuk mengahapus kategori[' + x.nama + '] ?', function(result) {
                    if (result) {
                        ItemKategoriService.remove(x).success(function() {
                            $scope.clear();
                        });
                    }
                });
            };

            $scope.save = function() {
                ItemKategoriService.findByNama($scope.currentRecord.name).success(function(data) {
                    if (data && (data.id !== $scope.currentRecord.id)) {
                        $scope.isNameExists = true;
                        return;
                    } else {
                        ItemKategoriService.save($scope.currentRecord).success(function() {
                            $('#formModal').modal('hide');
                            bootbox.alert('Simpan kategori item sukses ');
                            $scope.clear();
                        });
                    }
                });
            };

        });
