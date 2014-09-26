'use strict';

/**
 * @ngdoc function
 * @name belajarYeomanApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the belajarYeomanApp
 */
angular.module('posApp')
        .controller('ReportIpdCtrl', function($scope, $window, $http) {
            
                $scope.tanggal1= new Date(); 
                $scope.tanggal2= new Date() ;
                $scope.unit= '';
            
            $scope.print = function() {
//                $window.location = 'test-print/export.pdf';
                $window.location = 'report/opd/reg.pdf?tanggal1='+$scope.tanggal1.format('yyyy-mm-dd')+
                        '&tanggal2='+$scope.tanggal2.format('yyyy-mm-dd');
            };
            $scope.testData=function(){
                console.log($scope.param);
                $http.get('report/opd/reg.pdf', {
                        tanggal1: $scope.tanggal1,
                        tanggal2: $scope.tanggal2,
                        unit: ''
                })
                                                .success(function(data){
                    console.log('Hasil', data);
                    $scope.pasien=data;
                });
            }
            
            $scope.getJson = function(){
                var param={
                        tanggal1: $scope.tanggal1,
                        tanggal2: $scope.tanggal2,
                        unit: ''
                };
                console.log('param', param);
                $http.get('report/opd/reg/json', param)
            }
            $scope.openStartDate = function($event) {
                $event.preventDefault();
                $event.stopPropagation();

                $scope.dpStartOpened = true;
            };
            $scope.openEndDate = function($event) {
                $event.preventDefault();
                $event.stopPropagation();

                $scope.dpEndOpened = true;
            };

        });
