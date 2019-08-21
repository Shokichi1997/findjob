app.controller('JobController',['$scope', '$http', function($scope, $http){
  $scope.game=5;
      $http(
        {
          method: 'POST',
          url: 'http://localhost:8090/resources/',
          data: JSON.stringify(resource),
          headers: {
           "Content-Type" : "application/json; charset=UTF-8"
         },
        }
      )
      .then(function successCallback(response){
        $scope.resources.push(response.data);
       alert("Resource has added successfully"+ JSON.stringify(response.data));
       window.location.reload(true);

       },function errorCallback(response){
          alert("Error. Try Again!" + JSON.stringify(response.data));

    };
});
