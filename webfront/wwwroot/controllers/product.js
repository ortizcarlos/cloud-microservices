angular.module('MyApp')
  .controller('ProductCtrl', function($scope, $auth, $alert, ProductService) {

    /**
     * Get user's profile information.
     */
    $scope.getProductDetails = function() {
      ProductService.getProduct()
        .success(function(data) {
          $scope.product = data;
        })
        .error(function(error) {
          $alert({
            content: error.message,
            animation: 'fadeZoomFadeDown',
            type: 'material',
            duration: 3
          });
        });
    };

      $scope.getProductDetails();

  });