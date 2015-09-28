'use strict';

angular
  .module('modal.demo', [
    'ngRoute',
    'ui.bootstrap'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/home', {
        templateUrl: 'demo.html',
        controller: 'Modal'
      })
    })
