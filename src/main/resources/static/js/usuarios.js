// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
    $('#usuarios').DataTable();
});

async function cargarUsuarios()
{
      const request = await fetch('api/usuarios', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      });
      const usuarios = await request.json();

      let codeTrUsuario = '';
      for(let usuario of usuarios)
      {
        let botonEliminar = '<a href="#" onClick="eliminarUsuario(' + usuario.id + ', \'' + usuario.nombre + ' ' + usuario.apellido + '\')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
        codeTrUsuario += '<tr><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>' + usuario.email + '</td><td>'+ usuario.telefono +'</td><td>'+botonEliminar+'</td></tr>';
      }

      document.querySelector('#usuarios tbody').outerHTML = codeTrUsuario;
}

async function eliminarUsuario(id, nombre){
    let confirmacion = confirm("¿Está seguro que desea eliminar al usuario " + nombre);
    if (confirmacion)
    {
        const request = await fetch('api/usuario/' + id, {
                method: 'DELETE',
                headers: {
                  'Accept': 'application/json',
                  'Content-Type': 'application/json'
                }
              });
        let resp = await request.json();

        alert(resp.message);
        cargarUsuarios();
    }
}
