'use strict';

/**
 * @ngdoc function
 * @name newApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the newApp
 */

angular.module('newApp')
  .controller('MainCtrl', function ($scope,$http) {
    $scope.todos = ['Item 1','Item 2','Item 3'];
    $scope.addTodo = function(){
      $scope.todos.push($scope.todo);
      $scope.todo='';
    };
    $scope.removeTodo = function(index){
      $scope.todos.splice(index,1);
    };

    $scope.getNodes = function() {
      $http.get("http://localhost:8181/read")
        .success(function (response) {
          $scope.nodes = response;
        });
    };
  });
