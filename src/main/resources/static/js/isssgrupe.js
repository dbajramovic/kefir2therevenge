var app = angular.module('dummy', [ 'ngRoute', 'ngResource', 'angularjs-dropdown-multiselect','feeds' ]);

app.config(function($routeProvider) {

	$routeProvider.when('/', {
		templateUrl : 'partials/home.html',
		controller : 'home',
		controllerAs : 'controller'
	})
	.when('/groups', {
		templateUrl: 'partials/group-list.html', controller: 'groupListCtrl'
		})
	.when('/groups/:id/view', {
		templateUrl: 'partials/group-view.html', controller: 'groupViewCtrl'
		})
	.when('/groups/new', {
		templateUrl: 'partials/group-add.html',  controller: 'groupCreateCtrl'
		})
	.when('/groups/:id/edit', {
		templateUrl: 'partials/group-edit.html', controller: 'groupEditCtrl'
		})
	.when('/adduserstogroups', {
		templateUrl: 'partials/adduserstogroups.html', controller: 'AddingCtrl'
	})
	.otherwise('/');

}).controller('navigation',

function($rootScope, $http, $location, $route) {

	var self = this;

	self.tab = function(route) {
		return $route.current && route === $route.current.controller;
	};

	$http.get('user').then(function(response) {
		if (response.data.name) {
			$rootScope.authenticated = true;
			$rootScope.username = response.data.name;
		} else {
			$rootScope.authenticated = false;
		}
	}, function() {
		$rootScope.authenticated = false;
	});

	self.credentials = {};

	self.logout = function() {
		$http.post('logout', {}).finally(function() {
			$rootScope.authenticated = false;
			$location.path("/");
		});
	}

}).controller('home', function($http) {
	var self = this;
	$http.get('resource/').then(function(response) {
		self.greeting = response.data;
	})
});

app.factory('groupService', function($resource) {
  return $resource('/resource/groups/:id', {}, {
      show: { method: 'GET' },
      update: { method: 'PUT', params: {id: '@id'} },
      delete: { method: 'DELETE', params: {id: '@id'} }
  });
});

app.factory('groupsService', function($resource) {
  return $resource('/resource/groups', {}, {
      query: { method: 'GET', isArray: true,
          transformResponse: function(data) {
              return angular.fromJson(data)._embedded.groups;
            }
      },
      create: { method: 'POST' }
  });
});

// app.controller('groupListCtrl', function($scope, $state, popupService,
// $window, groupService) {
app.controller('groupListCtrl',  function($scope, $window, groupsService, groupService, $location) {
	  var qry = groupsService.query();
	  $scope.groups = qry; 

      // callback for ng-click 'editgroup':
      $scope.editgroup = function (groupId) {
          $location.path('/groups/' + groupId + "/edit");
      };

      // callback for ng-click 'deletegroup':
      $scope.deletegroup = function (groupId) {
    	  groupService.delete({ id: groupId });
          $scope.groups = groupsService.query();
      };

      // callback for ng-click 'createNewgroup':
      $scope.createNewgroup = function () {
          $location.path('/groups/new');
      };
	  
}).controller('groupViewCtrl', function($scope, $routeParams, groupService, $location) {

    // callback for ng-click 'updategroup':
    $scope.updategroup = function () {
    	groupService.update($scope.group);
        $location.path('/groups');
    };

    // callback for ng-click 'cancel':
    $scope.cancel = function () {
        $location.path('/groups');
    };

    $scope.group = groupService.show({id: $routeParams.id});
    
}).controller('groupCreateCtrl', function($scope, groupsService, $location,$rootScope,$log) {
	
	$scope.init = function() {
			$scope.group = {
				name: '',
				description: '',
				dateofcreation: new Date(),
				creatorusername: $rootScope.username,
				picpath: 'N/A',
				teachinggroup: false,
				forcedgroup: false,
				dissolved: false
			};
			$log.debug($scope.group);
	};
    // callback for ng-click 'createNewgroup':
    $scope.createNewgroup = function () {
    	groupsService.create($scope.group);
        $location.path('/groups');
    }
    
}).controller('groupEditCtrl', function($scope, $routeParams, groupService, $location) {

    // callback for ng-click 'updategroup':
    $scope.updategroup = function () {
    	groupService.update($scope.group);
        $location.path('/groups');
    };

    // callback for ng-click 'cancel':
    $scope.cancel = function () {
        $location.path('/groups');
    };

    $scope.group = groupService.show({id: $routeParams.id});

});
app.controller('AddingCtrl', function($scope, $routeParams, groupService, $location,$log) {
   $scope.init = function() {
	   $log.debug("YO");
	   $scope.listOfStudentsToAddToEvent = [];
	   $scope.usersmodel = [];
	   $scope.userscustomTexts = {buttonDefaultText: 'Select users to add:' };
	   $scope.userssettings = {displayProp: 'username', enableSearch: true ,scrollable: true , scrollableHeight: '500px'};
   };
   //NEED /users or something like that to get users from core
});
app.controller('HomeCtrl',function($scope, $routeParams, groupService, $location,$log) {
	
	   //NEED /users or something like that to get users from core
	});
