var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/register", {
        templateUrl : "Register.html"
    })
    .when("/liststudents", {
        templateUrl : "ListStudents.html"
    });
});

app.controller('myCtrl', function($scope, $http) {
	$scope.registrationstatus="";
	
	$scope.insertData = function(student) {
		
		console.log($scope.student);
		$http.post('/insertData', student).then(function(success) {
			console.log("success");
			if(success.data==1)
				{
				alert("successfully registered");
				}
			else{
				alert("some error occured");
			}
		}, function(error) {
			
			console.log("fail");
		});
	}
	$scope.qualifications=[];
	$http.get('/getAllData').then(function(response) {
		$scope.students=response.data;
	}, function(error) {
		console.log("fail");
	});
	
	$http.get('/getQualifications').then(function(response) {
		console.log(response.data);
		
			
		console.log(response.data.Qualifications.length);
		for(var i=0;i<response.data.Qualifications.length;i++)
		{   console.log("Hello");
			$scope.qualifications.push(response.data.Qualifications[i].QualificationCode);
		}
		console.log("success");
	}, function(error) {
		console.log("fail");
	});
	
	
});