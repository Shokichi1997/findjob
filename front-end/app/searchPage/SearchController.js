app.controller("SearchController",['$scope', '$http', function($scope, $http){
$scope.jobs;
  $scope.searchJobs = function(){
    var keywords = document.getElementById("key_search").value;
    if(keywords != ""){
      $http(
        {
          method: 'GET',
          url: 'http://localhost:8090/search/'+keywords,
          headers: {
           "Access-Control-Allow-Origin" : "*",
            "Access-Control-Allow-Headers" : "origin, x-requested-with, content-type",
            "Access-Control-Allow-Methods" : "PUT, GET, POST, DELETE, OPTIONS",
         },
        }
      )
      .then(function successCallback(response){
        var arr = new Array();
        arr = response.data;
        $scope.jobs = arr;
        $scope.paging();
       //window.location.href = "http://127.0.0.1:3000/job-single.html"
        //window.location.reload(true);
       },function errorCallback(response){
          alert("Error. Try Again!" );
       });

       $scope.paging = function(){

         $scope.viewby = 10;
         $scope.totalItems = $scope.jobs.length;
         $scope.currentPage = 1;
         $scope.itemsPerPage = $scope.viewby;
         $scope.maxSize = 5; //Number of pager buttons to show

         $scope.setPage = function (pageNo) {
           $scope.currentPage = pageNo;
         };

         $scope.pageChanged = function() {
           console.log('Page changed to: ' + $scope.currentPage);
         };

       $scope.setItemsPerPage = function(num) {
         $scope.itemsPerPage = num;
         $scope.currentPage = 1; //reset to first page
       }
       }
    }
  };
}]);
