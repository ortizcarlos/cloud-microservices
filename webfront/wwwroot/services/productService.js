angular.module('MyApp')
  .factory('ProductService', function($http) {
    return {
      getProduct: function() {
        return $http.get('/api/product/1');
      },
      updateProduct: function(profileData) {
        return $http.put('/api/product', productData);
      }
    };
  });