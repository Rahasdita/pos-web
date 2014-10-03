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
      .when('/master/kota', {
        templateUrl: 'views/master/kota.html',
        controller: 'KotaCtrl'
      })
      .when('/transaksi/penjualan', {
        templateUrl: 'views/transaksi/penjualan.html',
        controller: 'ArInvCtrl'
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
//        redirectTo: 'views/404.html'
          templateUrl: 'views/404.html',
      });
  })
  .directive('onEnter',function() {

  var linkFn = function(scope,element,attrs) {
    element.bind("keypress", function(event) {
      if(event.which === 13) {
        scope.$apply(function() {
      scope.$eval(attrs.onEnter);
        });
        event.preventDefault();
      }
    });
  };

  return {
    link:linkFn
  };
});