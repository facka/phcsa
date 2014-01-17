<html>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.7/angular.min.js"></script>
<script type="text/javascript" src="js/application.js"></script>
<script src="https://code.jquery.com/jquery.js"></script>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">
<body>
	<div ng-app="App">
		<div ng-controller="Edificios">
			<input type="text" ng-model="query" size="80" />
			<button id="buscarButton" ng-click="buscar()">Buscar</button>
			<br>
			
			<ul class="unstyled">
				<li ng-repeat="edificio in edificios"><input id="deleteCheck" type="checkbox"
					ng-model="edificio.selected"> <span>{{edificio.idEdificio}} - {{edificio.direccion}}</span>
					<a ng-href="#editEdificioDialog" data-toggle="modal" data-target="#editEdificioDialog" ng-click="setEdificioToEdit(edificio)">edit</a>
				</li>
			</ul>
			<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#editEdificioDialog">
  				Editar
			</button>
			<a id="deleteButton" href="" ng-click="deleteSelected()">Delete selected</a> 

			<input type="text" ng-model="direccionText" size="30"
				placeholder="direccion"> <button id="agregarButton" ng-click="addEdificio()">Agregar</button>
				
			<!-- Modal -->
			<div class="modal fade" id="editEdificioDialog" tabindex="-1" role="dialog" aria-labelledby="editEdificioDialogLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="editEdificioDialogLabel">Editar edificio {{edificioToEdit.direccion}}</h4>
			      </div>
			      <div class="modal-body">
			        Direccion: <input type="text" ng-model="edificioToEdit.direccion" size="30"
						placeholder="direccion"> 
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button id="guardarEdicionEdificio" type="button" class="btn btn-primary" ng-click="updateEdificio()">Save changes</button>
			      </div>
			    </div><!-- /.modal-content -->
			  </div><!-- /.modal-dialog -->
			</div><!-- /.modal -->	
		</div>	
	</div>
</body>
</html>