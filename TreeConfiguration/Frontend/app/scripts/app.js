'use strict';

/**
 * @ngdoc overview
 * @name newApp
 * @description
 * # newApp
 *
 * Main module of the application.
 */
angular
  .module('newApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.sortable',
    'ui.bootstrap'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/contact',{
        templateUrl: 'views/contact.html',
        controller: 'ContactController',
        controllerAs: 'contact'
      })
      .when('/tree', {
        templateUrl: 'views/tree.html',
        controller: 'TreeController',
        controllerAs: 'tree'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
