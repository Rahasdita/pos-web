'use strict';

angular
  .module('posApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.bootstrap'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/master/item-kategori', {
        templateUrl: 'views/master/item-kategori.html',
        controller: 'ItemKategoriCtrl'
      })
      .when('/transaksi/opd', {
        templateUrl: 'views/transaksi/opd.html',
        controller: 'MainCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .when('/report/ipd', {
        templateUrl: 'views/report/ipd.html',
        controller: 'ReportIpdCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });