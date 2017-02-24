package com.tekdays

class TaskService {

    def serviceMethod() {

    }

    def addDefaultTask( tekEvent ) {
    	if ( tekEvent.tasks?.size() > 0 )
    		return //Agrega tareas a un nuevo evento

    	tekEvent.addToTasks new Task( title : 'Identifica potencial de ventas')
    	tekEvent.addToTasks new Task( title : 'Obtener compras avilitadas por ventas')
    	tekEvent.addToTasks new Task( title : 'Compila potencial lista de responsables')
    	tekEvent.addToTasks new Task( title : 'Diseña material promocional')
    	tekEvent.addToTasks new Task( title : 'Compila potenciales ventas')
    	tekEvent.addToTasks new Task( title : 'localiza proveedores preferentemente locales')
    	tekEvent.save()
    }
}
