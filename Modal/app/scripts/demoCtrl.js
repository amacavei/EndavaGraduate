angular.module('modal.demo').controller('Modal',function($scope,$modal){

  $scope.open = function(size){
    var modalInstance = $modal.open({
      templateUrl:'myModalContent.html',
      controller: 'DemoCtrl',
      size: size
    });


  }
});
angular.module('modal.demo').controller('DemoCtrl',function($scope,$modalInstance){
  $scope.ok = function(){
    $modalInstance.close();
  };
  $scope.cancel = function(){
    $modalInstance.dismiss('cancel');
  };
});
