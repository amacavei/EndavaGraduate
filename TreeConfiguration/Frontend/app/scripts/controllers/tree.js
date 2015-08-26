/**
 * Created by amacavei on 8/20/2015.
 */
'use strict'
angular.module('newApp')
  .controller('TreeController', function($scope,$http) {



    $scope.updateParentConf = function() {
      $http.put("http://localhost:8181/updateParentConf",
        {
          name: document.getElementById('ParentConf').value,
          key: document.getElementById('ParentKey').value,
          value: document.getElementById('ParentValue').value
        })
        .success(function (response) {
          $scope.conf = response;
        })
      .success(function (data) {
        $scope.updatePConf = data;
      });
    };

    $scope.getPathBU = function() {
      $http.get("http://localhost:8181/pathBottomUp/" + document.getElementById('Node').value)
        .success(function (response) {
          $scope.pathBu = response;
        });
    };

    $scope.getPathTD = function() {
      $http.get("http://localhost:8181/pathTopDown/" + document.getElementById('Node').value)
        .success(function (response) {
          $scope.pathTd = response;
        });
    };

    $scope.updateAllChild = function() {
      $http.put("http://localhost:8181/updateAllChildren",
        {
          name: document.getElementById('UpdateParent').value
        })
        .success(function (response) {
          $scope.node = response;
        })
      .success(function (data) {
        $scope.updateAll = data;
      });
    };
    $scope.createNode = function() {
      $http.post("http://localhost:8181/createChild",
        {
          nameChild : document.getElementById('NodeCreate').value,
          nameParent : document.getElementById('NodeParent').value,
          key : document.getElementById('NodeKey').value,
          value : document.getElementById('NodeValue').value
        })
        .success(function (response) {
          $scope.node = response;
        })
      .success(function (data) {
        $scope.createN = data;
      });
    };

    $scope.generateDB = function() {
      $http.post("http://localhost:8181/generate",null)
        .success(function (response) {
          $scope.node = response;
        });
    };

    $scope.updateChild = function() {
      $http.put("http://localhost:8181/updateChildConf",
        {
          child: document.getElementById('NodeUpdateChild').value,
          key: document.getElementById('ChildKey').value,
          value: document.getElementById('ChildValue').value,
          parent: document.getElementById('Parent').value
        })
        .success(function (response) {
          $scope.node = response;
        })
      .success(function (data) {
        $scope.updateC = data;
      });
    };
    $scope.updateParent = function() {
      $http.put("http://localhost:8181/updateParentID",
        {
          name: document.getElementById('NodeUpdateParent').value,
          id: document.getElementById('IDParent').value
        })
        .success(function (response) {
          $scope.node = response;
        })
        .success(function (data) {
          $scope.updateP = data;

        });
    };
    $scope.removeNode = function() {
      $http.delete("http://localhost:8181/remove/" + document.getElementById('NodeRemove').value)
        .success(function (response) {
          $scope.node = response;
        })
      .success(function (data) {
        $scope.removeN = data;
      });
    };
    $scope.getNode = function() {
      $http.get("http://localhost:8181/readNode/" + document.getElementById('Node').value + "/")
        .success(function (response) {
          $scope.node = response;
        });
    };
    $scope.getRoot = function() {
      $http.get("http://localhost:8181/root/" + document.getElementById('Node').value)
        .success(function (response) {
          $scope.root = response;
        });
    };

    $scope.getParent = function() {
      $http.get("http://localhost:8181/parent/" + document.getElementById('Node').value)
        .success(function (child) {
          $scope.value = child;
        });
    };

  });
